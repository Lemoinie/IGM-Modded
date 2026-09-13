# Reverse Engineering Reference

## Source References
- Base APK: Guild+Master+-+Idle+Dungeons_2.148_APKPure.xapk
- Reference Workspace: C:\Repositories\Idle Guild Master (read-only reference)
  - jadx_output/: JADX 1.5.6 decompilation of vanilla APK
  - eference/clean_apk/: Untouched apktool unpack (pristine smali, AndroidManifest, and resources)
  - eference/clean_apk/smali_classes3/: Dalvik bytecode reference for verification

## Key Decompilation Notes
- Original app is 100% Android Java (no Unity, Unreal, LibGDX, or C++ NDK binaries).
- Framework dependencies used by vanilla: AndroidX, Material, Jackson (JSON), RxJava 3, TrueTime.
- JADX successfully decompiled 1,149 of 1,150 classes cleanly.
- Single decompilation failure: Area.cast(Entity) in Area.java, which must be reconstructed from Area.smali.
