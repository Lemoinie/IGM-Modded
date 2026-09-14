# Reverse Engineering Reference

## Source References

- **Base APK**: `Guild+Master+-+Idle+Dungeons_2.148_APKPure.xapk`
- **Reference workspace** (read-only, outside this repository):
  `C:\Repositories\Idle Guild Master`
  - `jdax_output/` — JADX 1.5.6 decompilation of the vanilla APK
  - `reference/clean_apk/` — untouched apktool unpack (pristine smali,
    AndroidManifest, and resources)
  - `reference/clean_apk/smali_classes3/` — Dalvik bytecode reference used to
    verify reconstructed methods
- **In-repository Java baseline**: `backup_java/` — the reconstructed vanilla Java
  classes from before the Kotlin migration. Used for parity questions and as the
  migration source of truth. It is reference material, **not** build input.

## What Was Reconstructed

The original app is 100% Android Java (no Unity/Unreal/LibGDX/NDK binaries).
Framework dependencies used by vanilla: AndroidX, Material, Jackson (JSON),
RxJava 3, TrueTime. The reconstruction keeps Gson (primary save serializer) plus
Jackson (secondary JSON), RxJava 3, and TrueTime — matching the vanilla surface.

JADX decompiled 1,149 of 1,150 classes cleanly. The **single decompilation
failure** was `Area.cast(Entity)` (the skill dispatcher), which was reconstructed
by hand from `Area.smali` — see [known-uncertainties.md](known-uncertainties.md),
item 1 (RESOLVED).

## Current State of the Reconstruction

- The Kotlin source tree in `app/src/main/kotlin/` is a **faithful port** of the
  reconstructed Java baseline (1,069 Kotlin files, zero Java application sources).
- `backup_java/` preserves the Java baseline for reference/diffing purposes.
- Functional parity is verified by the JVM test suite
  (`app/src/test/java/it/paranoidsquirrels/idleguildmaster/FunctionalParityTest.java`)
  covering data initialization, save round-trip, adventurer creation, core formulas,
  skill casting, and dungeon combat setup.

## Re-verification Workflow

When a vanilla behavior is in doubt:

1. Check `docs/vanilla-behavior.md` and `docs/known-uncertainties.md` first —
   the behavior may already be verified.
2. Compare the Kotlin class in `app/src/main/kotlin/` against the Java baseline in
   `backup_java/`.
3. If both are ambiguous, consult the bytecode:
   `C:\Repositories\Idle Guild Master\reference\clean_apk\smali_classes3\...`
4. Record any new finding in the appropriate `docs/` file so it is never
   "rediscovered" by reading smali again.