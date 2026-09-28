@echo off
setlocal enabledelayedexpansion
title Disconnect All Devices - IGM Modded

set "REPO_ROOT=%~dp0.."
cd /d "%REPO_ROOT%"

echo ============================================================
echo           IGM Modded - Disconnect All Devices
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

:: 2. Check current connected devices
echo Currently connected devices:
"%ADB%" devices
echo.

:: 3. Disconnect devices
if not "%~1"=="" (
    if /i "%~1"=="-k" goto :kill_server
    if /i "%~1"=="--kill" goto :kill_server
    if /i "%~1"=="kill" goto :kill_server
    if /i not "%~1"=="all" (
        echo Disconnecting device: %~1...
        "%ADB%" disconnect %~1
        goto :after_disconnect
    )
)

echo Disconnecting all TCP/IP (wireless) devices...
"%ADB%" disconnect

:after_disconnect
echo.
echo Remaining connected devices:
"%ADB%" devices
echo.
echo [SUCCESS] Disconnect completed.
goto :end

:kill_server
echo Stopping ADB server (kill-server)...
"%ADB%" kill-server
echo [SUCCESS] ADB server killed. All connections terminated.

:end
echo.
echo ============================================================
pause
