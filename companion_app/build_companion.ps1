param (
    [switch]$Deploy
)

$ErrorActionPreference = "Stop"

$scriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$appDir = $scriptDir
$repoRoot = Split-Path -Parent $appDir

$sdkDir = "C:\Users\Admin\AppData\Local\Android\Sdk"
if (-not (Test-Path $sdkDir)) {
    if ($env:ANDROID_HOME -and (Test-Path $env:ANDROID_HOME)) { $sdkDir = $env:ANDROID_HOME }
    elseif (Test-Path "$repoRoot\local.properties") {
        $sdkLine = Get-Content "$repoRoot\local.properties" | Where-Object { $_ -match "^sdk.dir=(.+)$" }
        if ($sdkLine) { $sdkDir = $Matches[1].Replace("\\", "\").Replace("/", "\") }
    }
}

$buildToolsDirs = Get-ChildItem (Join-Path $sdkDir "build-tools") | Sort-Object Name -Descending
$buildTools = $buildToolsDirs[0].FullName
$androidJar = Join-Path $sdkDir "platforms\android-34\android.jar"
$keystore = Join-Path $env:USERPROFILE ".android\debug.keystore"
if (-not (Test-Path $keystore)) { $keystore = "C:\tools\debug.keystore" }

$jarExe = (Get-Command jar -ErrorAction SilentlyContinue).Source
if (-not $jarExe) { $jarExe = "C:\Program Files\Java\jdk-17\bin\jar.exe" }

$outDir = "$appDir\build"
$compiledRes = "$outDir\compiled_res"
$genDir = "$outDir\gen"
$classesDir = "$outDir\classes"

# Clean build dir
if (Test-Path $outDir) { Remove-Item -Recurse -Force $outDir }
New-Item -ItemType Directory -Force -Path $compiledRes | Out-Null
New-Item -ItemType Directory -Force -Path $genDir | Out-Null
New-Item -ItemType Directory -Force -Path $classesDir | Out-Null

function Check-Exit($step) {
    if ($LASTEXITCODE -ne 0) {
        Write-Error "❌ $step failed with exit code $LASTEXITCODE"
        exit $LASTEXITCODE
    }
}

Write-Host "1. Compiling Android Resources with AAPT2..."
& "$buildTools\aapt2.exe" compile --dir "$appDir\res" -o "$compiledRes\resources.zip"
Check-Exit "AAPT2 compile"

Write-Host "2. Linking Resources and generating R.java & base APK..."
$resZip = "$compiledRes\resources.zip"
& "$buildTools\aapt2.exe" link -I $androidJar --manifest "$appDir\AndroidManifest.xml" --min-sdk-version 26 --target-sdk-version 34 --java $genDir -o "$outDir\base.apk" --auto-add-overlay $resZip
Check-Exit "AAPT2 link"

Write-Host "3. Compiling Java Source Files with Javac..."
$javaFiles = Get-ChildItem -Path "$appDir\src", $genDir -Filter "*.java" -Recurse | Select-Object -ExpandProperty FullName
& javac -encoding UTF-8 -source 17 -target 17 -cp $androidJar -d $classesDir $javaFiles
Check-Exit "Javac"

Write-Host "4. Dexing classes with D8..."
$classFiles = Get-ChildItem -Path $classesDir -Filter "*.class" -Recurse | Select-Object -ExpandProperty FullName
& "$buildTools\d8.bat" --release --min-api 26 --output $outDir --lib $androidJar $classFiles
Check-Exit "D8"

Write-Host "5. Packaging classes.dex into APK..."
Set-Location $outDir
& $jarExe uf "$outDir\base.apk" classes.dex
Check-Exit "Jar package"

Write-Host "6. Zipaligning APK..."
& "$buildTools\zipalign.exe" -p -f -v 4 "$outDir\base.apk" "$outDir\IdleGuildCompanion_aligned.apk" | Out-Null
Check-Exit "Zipalign"

Write-Host "7. Signing APK..."
$finalApk = "$appDir\IdleGuildCompanion.apk"
& "$buildTools\apksigner.bat" sign --ks $keystore --ks-pass pass:android --key-pass pass:android --out $finalApk "$outDir\IdleGuildCompanion_aligned.apk"
Check-Exit "Apksigner"

Write-Host "`n✅ Build Successful! Output: $finalApk"

if ($Deploy) {
    Write-Host "`nDeploying to Android device..." -ForegroundColor Yellow
    $adb = Join-Path $sdkDir "platform-tools\adb.exe"
    if (-not (Test-Path $adb)) { $adb = (Get-Command adb -ErrorAction SilentlyContinue).Source }
    if ($adb) {
        $raw = & $adb devices 2>$null
        $serials = @()
        foreach ($line in $raw) {
            if ($line -match '^([^\s]+)\s+device($|\s)') { $serials += $Matches[1] }
        }
        if ($serials.Count -gt 0) {
            $device = $serials[0]
            Write-Host "Installing to $device..." -ForegroundColor Cyan
            & $adb -s $device install -r $finalApk
            Write-Host "Launching Companion App..." -ForegroundColor Cyan
            & $adb -s $device shell am start -n "com.lemoinie.idleguildcompanion/.MainActivity" | Out-Null
            Write-Host "Deployed and launched!" -ForegroundColor Green
        } else {
            Write-Warning "No connected ADB device found to deploy."
        }
    } else {
        Write-Warning "adb not found; skipping deploy."
    }
}
