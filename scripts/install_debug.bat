@echo off
setlocal enabledelayedexpansion
title Install Debug APK - IGM Modded

set "REPO_ROOT=%~dp0.."
cd /d "%REPO_ROOT%"

echo ============================================================
echo           IGM Modded - Install Debug APK to Device
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

:: 2. Locate the newest APK in app\build\outputs\apk\debug\
set "APK_DIR=%CD%\app\build\outputs\apk\debug"
set "APK_PATH="
for /f "delims=" %%F in ('dir /b /s /o:-d "%APK_DIR%\*.apk" 2^>nul') do (
    if not defined APK_PATH set "APK_PATH=%%F"
)

if not defined APK_PATH (
    echo [ERROR] No APK found in %APK_DIR%!
    echo Please run build_debug.bat first to compile the APK.
    goto :end
)

echo Target APK: %APK_PATH%
echo.

:: 3. Check connected devices
echo Checking connected devices...
"%ADB%" devices
echo.

:: 4. Install APK
echo Installing APK to connected device...
"%ADB%" install -r "%APK_PATH%"
set "INSTALL_STATUS=%errorlevel%"

echo.
if %INSTALL_STATUS% equ 0 (
    echo [SUCCESS] APK installed successfully!
    echo.
    echo Launching Idle Guild Master...
    "%ADB%" shell am start -n it.paranoidsquirrels.idleguildmaster.rebuilt/it.paranoidsquirrels.idleguildmaster.MainActivity
) else (
    echo [ERROR] Installation failed with exit code %INSTALL_STATUS%.
    echo Make sure your phone is connected and "Allow USB debugging" is accepted.
)

:end
echo.
echo ============================================================
pause
