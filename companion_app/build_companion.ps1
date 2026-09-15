$ErrorActionPreference = "Stop"

$appDir = "C:\Repositories\Idle Guild Master\companion_app"
$buildTools = "C:\Users\JackF\AppData\Local\Android\Sdk\build-tools\34.0.0"
$androidJar = "C:\Users\JackF\AppData\Local\Android\Sdk\platforms\android-34\android.jar"
$keystore = "C:\tools\debug.keystore"

$outDir = "$appDir\build"
$compiledRes = "$outDir\compiled_res"
$genDir = "$outDir\gen"
$classesDir = "$outDir\classes"

# Clean build dir
if (Test-Path $outDir) { Remove-Item -Recurse -Force $outDir }
New-Item -ItemType Directory -Force -Path $compiledRes | Out-Null
New-Item -ItemType Directory -Force -Path $genDir | Out-Null
New-Item -ItemType Directory -Force -Path $classesDir | Out-Null

Write-Host "1. Compiling Android Resources with AAPT2..."
& "$buildTools\aapt2.exe" compile --dir "$appDir\res" -o "$compiledRes\resources.zip"

Write-Host "2. Linking Resources and generating R.java & base APK..."
$resZip = "$compiledRes\resources.zip"
& "$buildTools\aapt2.exe" link -I $androidJar --manifest "$appDir\AndroidManifest.xml" --min-sdk-version 26 --target-sdk-version 34 --java $genDir -o "$outDir\base.apk" --auto-add-overlay $resZip

Write-Host "3. Compiling Java Source Files with Javac..."
$javaFiles = Get-ChildItem -Path "$appDir\src", $genDir -Filter "*.java" -Recurse | Select-Object -ExpandProperty FullName
& javac -encoding UTF-8 -cp $androidJar -d $classesDir $javaFiles

Write-Host "4. Dexing classes with D8..."
$classFiles = Get-ChildItem -Path $classesDir -Filter "*.class" -Recurse | Select-Object -ExpandProperty FullName
& "$buildTools\d8.bat" --release --min-api 26 --output $outDir --lib $androidJar $classFiles

Write-Host "5. Packaging classes.dex into APK..."
Set-Location $outDir
& "C:\Program Files\Java\jdk-17\bin\jar.exe" uf "$outDir\base.apk" classes.dex

Write-Host "6. Zipaligning APK..."
& "$buildTools\zipalign.exe" -p -f -v 4 "$outDir\base.apk" "$outDir\IdleGuildCompanion_aligned.apk" | Out-Null

Write-Host "7. Signing APK..."
$finalApk = "$appDir\IdleGuildCompanion.apk"
& "$buildTools\apksigner.bat" sign --ks $keystore --ks-pass pass:android --key-pass pass:android --out $finalApk "$outDir\IdleGuildCompanion_aligned.apk"

Write-Host "`n✅ Build Successful! Output: $finalApk"
