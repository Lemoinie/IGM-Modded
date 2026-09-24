@echo off
setlocal enabledelayedexpansion
title Pull Save from Connected Device - IGM Modded

set "REPO_ROOT=%~dp0.."
cd /d "%REPO_ROOT%"

set "PACKAGE=it.paranoidsquirrels.idleguildmaster.rebuilt"
set "SAVE_FILE=%CD%\save.json"
set "BACKUP_DIR=%CD%\backups"

echo ============================================================
echo           IGM Modded - Pull Save from Connected Device
echo ============================================================
echo Workspace: %CD%
echo.

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

:: 2. Find connected device
set "TARGET="
for /f "tokens=1,2" %%A in ('"%ADB%" devices') do (
    if "%%B"=="device" (
        if not defined TARGET set "TARGET=%%A"
    )
)

if not defined TARGET (
    echo [ERROR] No connected Android device found!
    echo Please make sure USB or Wireless Debugging is connected.
    echo Run scripts\pair_and_connect.bat to reconnect wireless debugging.
    goto :end
)

echo Target Device: %TARGET%
echo App Package:   %PACKAGE%
echo.

:: 3. Pull save file from app internal storage
echo Pulling save data from device...

:: Primary: exec-out (binary-clean stream from run-as)
"%ADB%" -s %TARGET% exec-out run-as %PACKAGE% cat files/data.txt > "%SAVE_FILE%" 2>nul

:: Verify if file exists and is not empty
set "PULL_OK=0"
set "FILE_SIZE="
if exist "%SAVE_FILE%" (
    for %%F in ("%SAVE_FILE%") do set "FILE_SIZE=%%~zF"
)
if defined FILE_SIZE (
    if !FILE_SIZE! GTR 50 set "PULL_OK=1"
)

:: Fallback method: shell run-as cat
if "!PULL_OK!"=="0" (
    echo Exec-out failed, attempting shell stream fallback...
    "%ADB%" -s %TARGET% shell "run-as %PACKAGE% cat files/data.txt" > "%SAVE_FILE%" 2>nul
    set "FILE_SIZE="
    if exist "%SAVE_FILE%" (
        for %%F in ("%SAVE_FILE%") do set "FILE_SIZE=%%~zF"
    )
    if defined FILE_SIZE (
        if !FILE_SIZE! GTR 50 set "PULL_OK=1"
    )
)

if "!PULL_OK!"=="1" (
    echo [SUCCESS] Save pulled successfully!
    echo Save Path: %SAVE_FILE%
    echo File Size: !FILE_SIZE! bytes
    
    :: 4. Create timestamped backup in backups\
    if not exist "%BACKUP_DIR%" mkdir "%BACKUP_DIR%"
    for /f %%a in ('powershell -NoProfile -Command "Get-Date -Format yyyyMMdd_HHmmss"') do set "TIMESTAMP=%%a"
    if not defined TIMESTAMP set "TIMESTAMP=latest"
    copy /y "%SAVE_FILE%" "%BACKUP_DIR%\save_!TIMESTAMP!.json" >nul 2>&1
    echo Backup:    %BACKUP_DIR%\save_!TIMESTAMP!.json
) else (
    echo [ERROR] Failed to pull save data!
    echo Possible causes:
    echo   [!] The game has not been launched yet on the device.
    echo   [!] Package %PACKAGE% is not installed or not debuggable.
)

:end
echo.
echo ============================================================
pause
