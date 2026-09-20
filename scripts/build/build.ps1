<#
.SYNOPSIS
    IGM Modded - Automated Build, Test & Deploy Pipeline
    Author: lemoinie
.DESCRIPTION
    Builds the 100% Kotlin reconstructed Idle Guild Master mod with Gradle,
    installs to a connected Android device (USB or Wireless Debugging),
    and starts the game.
.PARAMETER Clean
    Performs a clean build before assembling.
.PARAMETER Test
    Runs unit tests (testDebugUnitTest) before building the APK.
.PARAMETER NoDeploy
    Only builds the APK without installing to a device.
.PARAMETER Logcat
    Streams application logcat after launching.
.PARAMETER Device
    Specific ADB device serial/IP:port.
#>

param (
    [switch]$Clean,
    [switch]$Test,
    [switch]$NoDeploy,
    [switch]$Logcat,
    [string]$Device
)

$ErrorActionPreference = "Stop"

# Script lives in scripts/build/; repository root is two levels up.
if (Test-Path "$PSScriptRoot\gradlew.bat") {
    $repoDir = $PSScriptRoot
} else {
    $repoDir = (Resolve-Path (Join-Path $PSScriptRoot "..\..")).Path
}
$gradlew = "$repoDir\gradlew.bat"
$package = "it.paranoidsquirrels.idleguildmaster.rebuilt"
$activity = "$package/it.paranoidsquirrels.idleguildmaster.MainActivity"

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

function Get-ConnectedDevice {
    if ($Device) { return $Device }
    & $adb start-server | Out-Null
    $devices = (& $adb devices | Select-String -Pattern "\b(device)\b")
    if ($devices.Count -gt 0) {
        return $devices[0].Line.Trim().Split("`t")[0].Trim()
    }
    return $null
}

Write-Host "=========================================" -ForegroundColor Cyan
Write-Host " IGM Modded Build & Deploy Pipeline       " -ForegroundColor Cyan
Write-Host "=========================================" -ForegroundColor Cyan

# 1. Clean if requested
if ($Clean) {
    Write-Host "[1/4] Cleaning previous build..." -ForegroundColor Yellow
    & $gradlew -p $repoDir clean
    if ($LASTEXITCODE -ne 0) { exit $LASTEXITCODE }
}

# 2. Run Tests if requested
if ($Test) {
    Write-Host "[2/4] Running unit tests..." -ForegroundColor Yellow
    & $gradlew -p $repoDir testDebugUnitTest
    if ($LASTEXITCODE -ne 0) {
        Write-Error "Unit tests failed!"
        exit $LASTEXITCODE
    }
    Write-Host "Unit tests passed!" -ForegroundColor Green
}

# 3. Assemble Dev and Release APKs
Write-Host "[3/4] Building Dev and Release APKs..." -ForegroundColor Yellow
& $gradlew -p $repoDir assembleDebug assembleRelease
if ($LASTEXITCODE -ne 0) {
    Write-Error "Gradle build failed!"
    exit $LASTEXITCODE
}

# Find built APKs
$devApk = Get-ChildItem "$repoDir\app\build\outputs\apk\debug" -Filter "*.apk" | Select-Object -First 1 -ExpandProperty FullName
$releaseApk = Get-ChildItem "$repoDir\app\build\outputs\apk\release" -Filter "*.apk" | Select-Object -First 1 -ExpandProperty FullName

if ($devApk -and (Test-Path $devApk)) {
    $devSizeMB = [math]::Round(((Get-Item $devApk).Length / 1MB), 2)
    Write-Host "Dev APK:     $devApk ($devSizeMB MB)" -ForegroundColor Green
} else {
    Write-Error "Dev APK artifact not found in app/build/outputs/apk/debug/."
    exit 1
}

if ($releaseApk -and (Test-Path $releaseApk)) {
    $releaseSizeMB = [math]::Round(((Get-Item $releaseApk).Length / 1MB), 2)
    Write-Host "Release APK: $releaseApk ($releaseSizeMB MB)" -ForegroundColor Green
}

$apkPath = $devApk

# 4. Deploy to device
if ($NoDeploy) {
    Write-Host "Build complete! (Skipping deploy: -NoDeploy specified)" -ForegroundColor Cyan
    exit 0
}

Write-Host "[4/4] Deploying to Android device..." -ForegroundColor Yellow
$target = Get-ConnectedDevice

if (!$target) {
    Write-Warning "No connected ADB device found. APK built at: $apkPath"
    Write-Host "Connect a device via USB or Wireless Debugging and run: adb install -r `"$apkPath`"" -ForegroundColor Yellow
    exit 0
}

Write-Host "Target Device: $target" -ForegroundColor Cyan
Write-Host "Installing APK..." -ForegroundColor Cyan
& $adb -s $target install -r $apkPath
if ($LASTEXITCODE -ne 0) {
    Write-Error "Installation failed!"
    exit $LASTEXITCODE
}

Write-Host "Starting Game: $activity..." -ForegroundColor Cyan
& $adb -s $target shell am force-stop $package
& $adb -s $target shell am start -n $activity | Out-Null
Write-Host "Game launched successfully!" -ForegroundColor Green

if ($Logcat) {
    Write-Host "Streaming Logcat (Ctrl+C to exit)..." -ForegroundColor Yellow
    & $adb -s $target logcat -v time --pid=(& $adb -s $target shell pidof -s $package)
}
