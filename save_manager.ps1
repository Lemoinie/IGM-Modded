<#
.SYNOPSIS
    IGM Modded - All-in-One Save File Manager & Editor
    Author: lemoinie
.DESCRIPTION
    Commands:
      .\save_manager.ps1 pull             - Pull latest save from phone & create timestamped backup
      .\save_manager.ps1 push             - Push local save.json to phone and restart game
      .\save_manager.ps1 backup           - Create a backup of the current save.json
      .\save_manager.ps1 restore [file]   - Restore a save from the backups/ folder
      .\save_manager.ps1 add-gems <num>   - Add gems to save.json and push immediately
      .\save_manager.ps1 add-gold <num>   - Add gold to save.json and push immediately
      .\save_manager.ps1 add-hero <spec>  - Add a customized adventurer and push
      .\save_manager.ps1 unlock-all       - Ensure all 5 packs + full storage capacity
      .\save_manager.ps1 connect <host:port> [code] - Connect or pair wireless debugging
      .\save_manager.ps1 scan [ip]        - Scan local IP for open wireless debug ports
#>

param (
    [Parameter(Position=0)]
    [string]$Command = "help",

    [Parameter(Position=1)]
    [string]$Value,

    [Parameter(Position=2)]
    [string]$Extra
)

# Script lives in scripts/save/; repository root is two levels up.
if (Test-Path "$PSScriptRoot\gradlew.bat") {
    $repoDir = $PSScriptRoot
} else {
    $repoDir = (Resolve-Path (Join-Path $PSScriptRoot "..\..")).Path
}
$saveFile = "$repoDir\save.json"
$backupDir = "$repoDir\backups"
$package = "it.paranoidsquirrels.idleguildmaster.rebuilt"
$activity = "$package/it.paranoidsquirrels.idleguildmaster.MainActivity"

if (!(Test-Path $backupDir)) {
    New-Item -ItemType Directory -Path $backupDir | Out-Null
}

# Auto-detect adb.exe
$adb = $null
$candidatePaths = @(
    "adb",
    "$env:LOCALAPPDATA\Android\Sdk\platform-tools\adb.exe",
    "$env:ANDROID_HOME\platform-tools\adb.exe",
    "$env:ANDROID_SDK_ROOT\platform-tools\adb.exe",
    "C:\Users\Admin\AppData\Local\Android\Sdk\platform-tools\adb.exe",
    "C:\Users\JackF\AppData\Local\Android\Sdk\platform-tools\adb.exe"
)

foreach ($c in $candidatePaths) {
    if ($c -eq "adb") {
        $cmd = Get-Command "adb" -ErrorAction SilentlyContinue
        if ($cmd) { $adb = "adb"; break }
    } elseif (Test-Path $c) {
        $adb = $c
        break
    }
}

if (!$adb) {
    Write-Error "adb.exe not found. Please install the Android SDK or add platform-tools to PATH."
    exit 1
}

function Get-TargetDevice {
    & $adb start-server | Out-Null
    for ($i = 0; $i -lt 5; $i++) {
        $devList = (& $adb devices | Select-String -Pattern "\b(device)\b")
        if ($devList.Count -gt 0) {
            return $devList[0].Line.Trim().Split("`t")[0].Trim()
        }
        Start-Sleep -Milliseconds 500
    }
    Write-Error "No connected Android device found. Make sure USB or Wireless debugging is connected."
    exit 1
}

switch ($Command.ToLower()) {
    "pull" {
        $target = Get-TargetDevice
        Write-Host "Pulling save from device ($target)..." -ForegroundColor Cyan
        & $adb -s $target shell "run-as $package cat files/data.txt" > "$saveFile.tmp"

        # Check if run-as worked
        if ((Get-Item "$saveFile.tmp").Length -lt 10) {
            # Try pull via tmp fallback
            & $adb -s $target shell "run-as $package cp files/data.txt /data/local/tmp/data_pull.txt"
            & $adb -s $target pull "/data/local/tmp/data_pull.txt" "$saveFile.tmp" | Out-Null
            & $adb -s $target shell "rm /data/local/tmp/data_pull.txt"
        }

        $utf8NoBom = New-Object System.Text.UTF8Encoding($false)
        [System.IO.File]::WriteAllText($saveFile, $raw, $utf8NoBom)
        Remove-Item "$saveFile.tmp" -Force -ErrorAction SilentlyContinue

        # Create timestamped backup
        $timestamp = (Get-Date).ToString("yyyyMMdd_HHmmss")
        Copy-Item $saveFile "$backupDir\save_$timestamp.json"
        Write-Host "Save pulled successfully -> $saveFile" -ForegroundColor Green
        Write-Host "Backup created -> backups\save_$timestamp.json" -ForegroundColor Yellow
    }

    "push" {
        if (!(Test-Path $saveFile)) {
            Write-Error "save.json does not exist. Run 'pull' first."
            exit 1
        }
        $target = Get-TargetDevice
        Write-Host "Pushing save to device ($target)..." -ForegroundColor Cyan
        & $adb -s $target shell "am force-stop $package"
        & $adb -s $target push $saveFile "/data/local/tmp/data.txt" | Out-Null
        & $adb -s $target shell "run-as $package cp /data/local/tmp/data.txt files/data.txt"
        & $adb -s $target shell "run-as $package cp /data/local/tmp/data.txt files/databackup.txt"
        & $adb -s $target shell "rm /data/local/tmp/data.txt"
        & $adb -s $target shell "am start -n $activity" | Out-Null
        Write-Host "Save pushed and game restarted successfully!" -ForegroundColor Green
    }

    "backup" {
        if (!(Test-Path $saveFile)) {
            Write-Error "save.json not found."
            exit 1
        }
        $timestamp = (Get-Date).ToString("yyyyMMdd_HHmmss")
        $dest = "$backupDir\save_$timestamp.json"
        Copy-Item $saveFile $dest
        Write-Host "Backup created: $dest" -ForegroundColor Green
    }

    "restore" {
        if (!$Value) {
            Write-Host "Available backups in ${backupDir}:" -ForegroundColor Cyan
            Get-ChildItem $backupDir -Filter "*.json" | ForEach-Object { Write-Host " - $($_.Name)" }
            Write-Host "Usage: .\save_manager.ps1 restore <filename>" -ForegroundColor Yellow
            return
        }
        $source = "$backupDir\$Value"
        if (!(Test-Path $source)) { $source = $Value }
        if (Test-Path $source) {
            Copy-Item $source $saveFile -Force
            Write-Host "Restored $source -> save.json" -ForegroundColor Green
            Write-Host "Run '.\save_manager.ps1 push' to upload to phone." -ForegroundColor Yellow
        } else {
            Write-Error "Backup file not found: $Value"
        }
    }

    "add-gems" {
        $amount = [long]$Value
        if ($amount -eq 0) { $amount = 10000 }
        $json = Get-Content $saveFile -Raw | ConvertFrom-Json
        $json.gems = [long]$json.gems + $amount
        $json | ConvertTo-Json -Depth 30 | Set-Content $saveFile -Encoding UTF8
        Write-Host "Added $amount gems! New balance: $($json.gems)" -ForegroundColor Green
        & $PSCommandPath push
    }

    "add-gold" {
        $amount = [long]$Value
        if ($amount -eq 0) { $amount = 10000000 }
        $json = Get-Content $saveFile -Raw | ConvertFrom-Json
        $json.money = [long]$json.money + $amount
        $json | ConvertTo-Json -Depth 30 | Set-Content $saveFile -Encoding UTF8
        Write-Host "Added $amount gold! New balance: $($json.money)" -ForegroundColor Green
        & $PSCommandPath push
    }

    "add-hero" {
        $spec = $Value
        if (!$spec) {
            Write-Host "Usage: .\save_manager.ps1 add-hero <Class>:<Trait1>:<Trait2>:<Weapon>:<Armor>:<Accessory>:<Level>:<Ascended>" -ForegroundColor Yellow
            Write-Host "Example: .\save_manager.ps1 add-hero NightLament:FERAL_PLUS:RUTHLESS:45:TRUE" -ForegroundColor Cyan
            return
        }
        $parts = $spec.Split(":")
        $className = $parts[0]
        $traitCommon = $null
        $traitRare = $null
        $wpName = $null
        $armName = $null
        $accName = $null
        $level = 1
        $asc = $null

        $knownTraits = @('ALERT','BLESSED','BOOKWORM','BOOKWORM_PLUS','BRUTE','BRUTE_PLUS','CURSED','DRAGON_BLOOD','EMPATHETIC','FERAL','FERAL_PLUS','FOCUSED','GIFTED','INTIMIDATING','MINDFUL','NIMBLE','NOCTURNAL','REACTIVE','RUTHLESS','TROLL_BLOOD')

        for ($i = 1; $i -lt $parts.Length; $i++) {
            $t = $parts[$i].Trim()
            if (!$t) { continue }
            if ($t -match '^(true|yes|1|ascended)$') { $asc = $true; continue }
            if ($t -match '^(false|no|0)$') { $asc = $false; continue }
            if ($t -match '^\d+$') {
                $level = [int]$t
                if ($asc -eq $null -and $level -ge 45) { $asc = $true }
                continue
            }
            if ($knownTraits -contains $t.ToUpper()) {
                if (!$traitCommon) { $traitCommon = $t.ToUpper() }
                elseif (!$traitRare) { $traitRare = $t.ToUpper() }
                continue
            }
            if (!$wpName) { $wpName = $t }
            elseif (!$armName) { $armName = $t }
            elseif (!$accName) { $accName = $t }
        }
        if ($asc -eq $null) { $asc = ($level -ge 45) }

        $json = Get-Content $saveFile -Raw | ConvertFrom-Json
        $newId = ($json.adventurers | Measure-Object -Property id -Maximum).Maximum + 1
        if (!$newId) { $newId = 1 }

        $advObj = [pscustomobject]@{
            ascended = [bool]$asc
            doctrine = [pscustomobject]@{
                l1 = 0; l2 = 0; l3 = 0; l4 = 0; l5 = 0; l6 = 0; trueClass = "EmptyDoctrine"
            }
            experience = 0
            id = [int]$newId
            level = [int]$level
            potionsDrank = [pscustomobject]@{
                potionOfAgilityDrank = 0; potionOfConstitutionDrank = 0; potionOfDarknessDrank = 0; potionOfDefenseDrank = 0
                potionOfDexterityDrank = 0; potionOfHealthDrank = 0; potionOfImmunityDrank = 0; potionOfIntelligenceDrank = 0
                potionOfMagicDefenseDrank = 0; potionOfPrecisionDrank = 0; potionOfViciousnessDrank = 0
            }
            seen = $false
            timeWhenDismissed = 0
            traitCommon = $traitCommon
            traitRare = $traitRare
            weapon = if ($wpName) { [pscustomobject]@{ stack = 1; trueClass = $wpName } } else { $null }
            armor = if ($armName) { [pscustomobject]@{ stack = 1; trueClass = $armName } } else { $null }
            accessory = if ($accName) { [pscustomobject]@{ stack = 1; trueClass = $accName } } else { $null }
            currentHp = 100
            currentMana = 60
            currentShield = 0
            negativeStatusEffects = @()
            positiveStatusEffects = @()
            trueClass = $className
        }

        $advList = [System.Collections.ArrayList]@($json.adventurers)
        $advList.Add($advObj) | Out-Null
        $json.adventurers = $advList

        if ($json.adventurers.Count -gt $json.maxAdventurersOwned) {
            $json.maxAdventurersOwned = $json.adventurers.Count + 5
        }

        $json | ConvertTo-Json -Depth 30 | Set-Content $saveFile -Encoding UTF8
        Write-Host "Created Hero: $className (Lvl $level, Ascended: $asc) in save.json!" -ForegroundColor Green
        & $PSCommandPath push
    }

    "unlock-all" {
        $json = Get-Content $saveFile -Raw | ConvertFrom-Json
        $json.starterPackPurchased = $true
        $json.adventurerPackPurchased = $true
        $json.merchantPackPurchased = $true
        $json.imperialVanguardPurchased = $true
        $json.unholyCrusadePurchased = $true
        $json.maxAdventurersOwned = 25
        $json.upgradeShelter = 10
        $json.upgradeQuarters = 10
        $json | ConvertTo-Json -Depth 30 | Set-Content $saveFile -Encoding UTF8
        Write-Host "All packs and max capacity unlocked in save.json!" -ForegroundColor Green
        & $PSCommandPath push
    }

    "connect" {
        if (!$Value) {
            Write-Host "Usage: .\save_manager.ps1 connect <IP:Port> [PairingCode]" -ForegroundColor Yellow
            return
        }
        if ($Extra) {
            Write-Host "Pairing with code $Extra at $Value..." -ForegroundColor Cyan
            & $adb pair $Value $Extra
        } else {
            Write-Host "Connecting to $Value..." -ForegroundColor Cyan
            & $adb connect $Value
        }
    }

    "scan" {
        $ip = if ($Value) { $Value } else { "192.168.1.5" }
        $scanScript = "$repoDir\scripts\tools\scan_ports.ps1"
        if (Test-Path $scanScript) {
            & $scanScript -ip $ip
        } else {
            Write-Error "scan_ports.ps1 not found in scripts/tools/."
        }
    }

    default {
        Write-Host @"
============================================================
      IGM Modded - Save Manager (by lemoinie)
============================================================
Commands:
  .\save_manager.ps1 pull             - Pull live save from phone & backup
  .\save_manager.ps1 push             - Push local save.json to phone & reload
  .\save_manager.ps1 backup           - Save a snapshot into backups/
  .\save_manager.ps1 restore [file]   - Restore snapshot to save.json
  .\save_manager.ps1 add-gems 50000   - Add gems & sync to phone immediately
  .\save_manager.ps1 add-gold 1000000 - Add gold & sync to phone immediately
  .\save_manager.ps1 add-hero <spec>  - Add custom hero to save & push
  .\save_manager.ps1 unlock-all       - Enable all 5 packs & expand guild slots
  .\save_manager.ps1 connect <ip:port> [code] - Pair/connect wireless ADB
  .\save_manager.ps1 scan [ip]        - Scan IP for open wireless debug ports
============================================================
"@ -ForegroundColor Cyan
    }
}
