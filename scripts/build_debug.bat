@echo off
setlocal enabledelayedexpansion
title Build Debug APK - IGM Modded

set "REPO_ROOT=%~dp0.."
cd /d "%REPO_ROOT%"

echo ============================================================
echo           IGM Modded - Build Debug APK
echo ============================================================
echo Workspace: %CD%
echo.

echo Running: gradlew.bat assembleDebug...
echo.
call gradlew.bat assembleDebug
set "BUILD_STATUS=%errorlevel%"

echo.
if %BUILD_STATUS% equ 0 (
    echo [SUCCESS] Debug APK build succeeded!
    echo.
    set "APK_PATH="
    for /f "delims=" %%F in ('dir /b /s /o:-d "%CD%\app\build\outputs\apk\debug\*.apk" 2^>nul') do (
        if not defined APK_PATH set "APK_PATH=%%F"
    )
    if defined APK_PATH (
        echo Built APK: !APK_PATH!
    ) else (
        echo APK folder: %CD%\app\build\outputs\apk\debug\
    )
) else (
    echo [ERROR] Build failed with exit code %BUILD_STATUS%.
)

echo.
echo ============================================================
pause
