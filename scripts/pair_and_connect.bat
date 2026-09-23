@echo off
setlocal enabledelayedexpansion
title Wireless ADB Pair ^& Connect

echo ============================================================
echo           IGM Modded - Wireless ADB Pair ^& Connect
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
    echo Searched: %%LOCALAPPDATA%%\Android\Sdk\platform-tools\adb.exe
    goto :end
)

:: 2. Read Configuration from wireless_debug.txt (or CLI arguments)
set "CONFIG_FILE=%~dp0wireless_debug.txt"
set "PAIR_ADDRESS="
set "CONNECT_ADDRESS="
set "PAIR_CODE="

:: Check CLI arguments first (all three must be provided)
if not "%~1"=="" if not "%~2"=="" if not "%~3"=="" (
    set "PAIR_ADDRESS=%~1"
    set "CONNECT_ADDRESS=%~2"
    set "PAIR_CODE=%~3"
)

:: Read from config file if not provided via CLI
if not defined PAIR_ADDRESS (
    if not exist "%CONFIG_FILE%" (
        echo [ERROR] Configuration file not found: %CONFIG_FILE%
        goto :end
    )
    for /f "usebackq eol=# tokens=1,2 delims==" %%a in ("%CONFIG_FILE%") do (
        set "KEY=%%a"
        set "VAL=%%b"
        if /i "!KEY!"=="PAIR_ADDRESS" set "PAIR_ADDRESS=!VAL!"
        if /i "!KEY!"=="CONNECT_ADDRESS" set "CONNECT_ADDRESS=!VAL!"
        if /i "!KEY!"=="PAIR_CODE" set "PAIR_CODE=!VAL!"
    )
    :: Fallback: try raw line-by-line if key-value wasn't found
    if not defined PAIR_ADDRESS (
        set /a count=0
        for /f "usebackq eol=# tokens=*" %%l in ("%CONFIG_FILE%") do (
            set /a count+=1
            if !count! equ 1 set "PAIR_ADDRESS=%%l"
            if !count! equ 2 set "CONNECT_ADDRESS=%%l"
            if !count! equ 3 set "PAIR_CODE=%%l"
        )
    )
)

:: Trim spaces
if defined PAIR_ADDRESS for /f "tokens=*" %%a in ("%PAIR_ADDRESS%") do set "PAIR_ADDRESS=%%a"
if defined CONNECT_ADDRESS for /f "tokens=*" %%a in ("%CONNECT_ADDRESS%") do set "CONNECT_ADDRESS=%%a"
if defined PAIR_CODE for /f "tokens=*" %%a in ("%PAIR_CODE%") do set "PAIR_CODE=%%a"

if not defined PAIR_ADDRESS (
    echo [ERROR] Missing PAIR_ADDRESS in %CONFIG_FILE%!
    goto :end
)
if not defined CONNECT_ADDRESS (
    echo [ERROR] Missing CONNECT_ADDRESS in %CONFIG_FILE%!
    goto :end
)
if not defined PAIR_CODE (
    echo [ERROR] Missing PAIR_CODE in %CONFIG_FILE%!
    goto :end
)

echo Pair Address:    %PAIR_ADDRESS%
echo Connect Address: %CONNECT_ADDRESS%
echo Pairing Code:    %PAIR_CODE%
echo.

:: 3. Step 1: Pair
echo [Step 1/2] Pairing with %PAIR_ADDRESS% using code %PAIR_CODE%...
"%ADB%" pair %PAIR_ADDRESS% %PAIR_CODE%
set "PAIR_RESULT=%errorlevel%"

if %PAIR_RESULT% neq 0 (
    echo.
    echo [ERROR] Pairing failed with error code %PAIR_RESULT%.
    echo Please make sure:
    echo   1. Both your PC and phone are on the same Wi-Fi network.
    echo   2. "Pair device with pairing code" dialog is open on your phone.
    echo   3. The IP, port, and code match the phone's current pairing dialog.
    goto :end
)

echo.
echo [Step 1/2 SUCCESS] Device paired!
echo.

:: 4. Step 2: Connect
echo [Step 2/2] Connecting to %CONNECT_ADDRESS%...
"%ADB%" connect %CONNECT_ADDRESS%
set "CONNECT_RESULT=%errorlevel%"

echo.
if %CONNECT_RESULT% equ 0 (
    echo [SUCCESS] Connected successfully!
) else (
    echo [WARNING] Connect command returned exit code %CONNECT_RESULT%.
)

echo.
echo Connected devices list:
"%ADB%" devices

:end
echo.
echo ============================================================
pause
