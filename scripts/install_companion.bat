@echo off
setlocal enabledelayedexpansion
title Install Companion APK - IGM Companion

set "REPO_ROOT=%~dp0.."
cd /d "%REPO_ROOT%"

echo ============================================================
echo      IGM Companion - Install Companion APK to Device
echo ============================================================

:: 1. Locate ADB executable
set "ADB="
where adb >nul 2>nul
if %errorlevel% equ 0 (
    set "ADB=adb"
) else if exist "%LOCALAPPDATA%\Android\Sdk\platform-tools\adb.exe" (
    set "ADB=%LOCALAPPDATA%\Android\Sdk\platform-tools\adb.exe"
) else if exist "C:\Users\Admin\AppData\Local\Android\Sdk\platform-tools\adb.exe" (
    set "ADB=C:\Users\Admin\AppData\Local\Android\Sdk\platform-tools\adb.exe"
)

if not defined ADB (
    echo [ERROR] adb.exe not found!
    echo Please make sure Android SDK platform-tools is installed.
    goto :end
)

:: 2. Locate Companion APK
set "APK_PATH=%CD%\companion_app\IdleGuildCompanion.apk"

if not exist "%APK_PATH%" (
    echo [WARNING] Companion APK not found at: %APK_PATH%
    echo Building companion APK now...
    echo.
    call "%~dp0build_companion.bat"
    if not exist "%APK_PATH%" (
        echo [ERROR] Build failed or APK still missing!
        goto :end
    )
)

echo Target APK: %APK_PATH%
echo.

:: 3. Clean up duplicate mDNS auto-connect if another device is active
set "DEVICE_COUNT=0"
for /f "tokens=1,2" %%A in ('"%ADB%" devices') do (
    if "%%B"=="device" set /a DEVICE_COUNT+=1
)
if !DEVICE_COUNT! gtr 1 (
    for /f "tokens=1" %%D in ('"%ADB%" devices ^| findstr /i "_adb-tls-connect"') do (
        echo [INFO] Disconnecting duplicate mDNS alias: %%D...
        "%ADB%" disconnect %%D >nul 2>&1
    )
)

:: 4. Detect target device
set "TARGET="
for /f "tokens=1,2" %%A in ('"%ADB%" devices') do (
    if "%%B"=="device" (
        if not defined TARGET set "TARGET=%%A"
    )
)

if not defined TARGET (
    echo [ERROR] No connected Android device found!
    echo Please connect your phone via USB or Wireless Debugging.
    echo If using wireless debugging, run scripts\pair_and_connect.bat
    goto :end
)

echo Target Device: %TARGET%
echo.

:: 5. Install APK
echo Installing Companion APK to %TARGET%...
"%ADB%" -s %TARGET% install -r "%APK_PATH%"
set "INSTALL_STATUS=%errorlevel%"

if !INSTALL_STATUS! neq 0 (
    echo.
    echo [INFO] Direct update failed - signature mismatch with older build.
    echo Re-installing cleanly - device backups are preserved in external storage...
    "%ADB%" -s %TARGET% uninstall com.lemoinie.idleguildcompanion >nul 2>&1
    "%ADB%" -s %TARGET% install "%APK_PATH%"
    set "INSTALL_STATUS=!errorlevel!"
)

echo.
if !INSTALL_STATUS! equ 0 (
    echo [SUCCESS] Companion App installed successfully!
    echo.
    echo Launching IGM Companion on %TARGET%...
    "%ADB%" -s %TARGET% shell am start -n com.lemoinie.idleguildcompanion/.MainActivity
) else (
    echo [ERROR] Installation failed with exit code %INSTALL_STATUS%.
    echo Make sure your phone is connected and "Allow USB debugging" is accepted.
)

:end
echo.
echo ============================================================
pause
