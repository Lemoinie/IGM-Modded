@echo off
setlocal enabledelayedexpansion
title Build Companion App - IGM Companion

set "REPO_ROOT=%~dp0.."
cd /d "%REPO_ROOT%"

echo ============================================================
echo         IGM Companion - Build Companion APK
echo ============================================================
echo Workspace: %CD%
echo.

set "BUILD_SCRIPT=%CD%\companion_app\build_companion.ps1"

if not exist "%BUILD_SCRIPT%" (
    echo [ERROR] Build script not found at: %BUILD_SCRIPT%
    goto :end
)

echo Running: powershell -ExecutionPolicy Bypass -File companion_app\build_companion.ps1...
echo.
powershell -ExecutionPolicy Bypass -File "%BUILD_SCRIPT%"
set "BUILD_STATUS=%errorlevel%"

echo.
if %BUILD_STATUS% equ 0 (
    echo [SUCCESS] Companion APK built and signed successfully!
    echo Output APK: %CD%\companion_app\IdleGuildCompanion.apk
) else (
    echo [ERROR] Build failed with exit code %BUILD_STATUS%.
)

:end
echo.
echo ============================================================
pause
