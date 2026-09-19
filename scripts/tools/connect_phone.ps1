# connect_phone.ps1 — reconnect to the Android phone over USB or wireless ADB
# and (optionally) install + launch the latest debug APK.
#
# Why this exists:
#   Once the PC has ever been paired to the phone, wireless reconnects need NO pairing
#   code — only `adb connect <ip>:<port>`. The port can change, but `adb mdns services`
#   discovers it automatically, so a lost wireless session is one command away.
#
# Usage:
#   .\scripts\tools\connect_phone.ps1                 # rediscover + connect only
#   .\scripts\tools\connect_phone.ps1 -Install        # connect, then install latest APK
#   .\scripts\tools\connect_phone.ps1 -Install -Launch
#   .\scripts\tools\connect_phone.ps1 -Ip 192.168.1.8 -Port 5555 -Install -Launch
#
# The last known wireless target is remembered in $env:USERPROFILE\.igm_phone.txt
# (a machine-local file, never committed).

param(
    [switch]$Install,
    [switch]$Launch,
    [string]$Ip = "",
    [int]$Port = 0,
    [string]$ApkPath = ""
)

$ErrorActionPreference = 'Stop'
$adb = 'C:\Users\Admin\AppData\Local\Android\Sdk\platform-tools\adb.exe'
if (-not (Test-Path $adb)) { $adb = (Get-Command adb -ErrorAction SilentlyContinue).Source }
if (-not $adb) { Write-Host 'adb not found — install platform-tools.'; exit 1 }

$stateFile = Join-Path $env:USERPROFILE '.igm_phone.txt'

function Get-AdbDevices {
    $raw = & $adb devices 2>$null
    $serials = @()
    foreach ($line in $raw) {
        if ($line -match '^([^\s]+)\s+(device|offline)($|\s)') { $serials += $Matches[1] }
    }
    return $serials
}

function Get-WirelessTargetFromMdns {
    $out = & $adb mdns services 2>$null
    $targets = @()
    for ($i = 0; $i -lt $out.Count; $i++) {
        if ($out[$i] -match '_adb-tls-connect') {
            # Look ahead/behind for an ip:port token.
            for ($j = $i; $j -lt [Math]::Min($i + 4, $out.Count); $j++) {
                $m = [regex]::Match($out[$j], '(\d+\.\d+\.\d+\.\d+):(\d+)')
                if ($m.Success) { $targets += @{ Ip = $m.Groups[1].Value; Port = [int]$m.Groups[2].Value }; break }
            }
        }
    }
    return $targets
}

function Connect-To($ip, $port) {
    Write-Host ("adb connect {0}:{1} ..." -f $ip, $port)
    & $adb connect "$ip`:$port" 2>$null | Out-Null
    Start-Sleep -Milliseconds 800
    $serial = Get-AdbDevices | Where-Object { $_ -eq "$ip`:$port" } | Select-Object -First 1
    if ($serial) { return $serial }
    return $null
}

# 1) USB first (most reliable transport when the cable is plugged in).
$serial = Get-AdbDevices | Where-Object { $_ -notmatch '^\d+\.\d+\.\d+\.\d+:\d+$' } | Select-Object -First 1

# 2) Explicit IP:port requested.
if (-not $serial -and $Ip -and $Port -gt 0) {
    $serial = Connect-To $Ip $Port
    if ($serial) { "$Ip`:$Port" | Set-Content $stateFile }
}

# 3) Saved target from the previous run.
if (-not $serial -and (Test-Path $stateFile)) {
    $saved = (Get-Content $stateFile).Trim()
    if ($saved -match '^(\d+\.\d+\.\d+\.\d+):(\d+)$') {
        $serial = Connect-To $Matches[1] [int]$Matches[2]
    }
}

# 4) mDNS discovery — finds the phone on the LAN automatically.
if (-not $serial) {
    $targets = Get-WirelessTargetFromMdns
    foreach ($t in $targets) {
        $serial = Connect-To $t.Ip $t.Port
        if ($serial) { "$($t.Ip):$($t.Port)" | Set-Content $stateFile; break }
        # Pairing popups rotate; give the connection a moment to die before the next try.
        Start-Sleep -Seconds 1
    }
}

if (-not $serial) {
    Write-Host 'No device found. Plug in USB (select File transfer + Allow USB debugging),'
    Write-Host 'or re-open Settings -> Wireless debugging and run:'
    Write-Host "  & '$adb' pair <phone-ip>:<pair-port> <code>"
    exit 2
}

Write-Host ("Connected via: " + $serial)
& $adb devices 2>$null

if ($Install) {
    if (-not $ApkPath) {
        $apk = Get-ChildItem 'C:\Repositories\IGM-Modded\app\build\outputs\apk\debug\*.apk' |
            Sort-Object LastWriteTime -Descending | Select-Object -First 1
        if (-not $apk) { Write-Host 'No APK found — build first.'; exit 3 }
        $ApkPath = $apk.FullName
    }
    Write-Host ("Installing: " + $ApkPath)
    $remote = '/data/local/tmp/igm_deploy.apk'
    & $adb -s $serial push $ApkPath $remote 2>$null | Out-Null
    & $adb -s $serial shell pm install -r $remote 2>$null | Out-Null
    if ($Launch) {
        & $adb -s $serial shell am start -n it.paranoidsquirrels.idleguildmaster.rebuilt/it.paranoidsquirrels.idleguildmaster.MainActivity 2>$null | Out-Null
    }
    Write-Host 'Done.'
    # Report the on-device version for sanity.
    & $adb -s $serial shell dumpsys package it.paranoidsquirrels.idleguildmaster.rebuilt 2>$null |
        Select-String 'versionName' | Select-Object -First 1 | ForEach-Object { $_.Line.Trim() }
}