# Rebuild Idle Guild Master Base Game (C:\Repositories\IGM-Modded)

Standalone reconstruction of the vanilla base game (v2.148) in `C:\Repositories\IGM-Modded`. The existing repository (`C:\Repositories\Idle Guild Master`) serves strictly as a read-only reverse-engineering reference.

---

## Technical Directives & Constraints

1. **Isolation**: `C:\Repositories\IGM-Modded` is completely independent. No mod code, smali injectors, or mod hooks will be brought over.
2. **Application ID**: `it.paranoidsquirrels.idleguildmaster.rebuilt` to allow side-by-side installation with the vanilla game.
3. **Ads & Billing**: Implemented via offline no-op stubs and hidden from the UI to avoid network crashes and external SDK bloat while maintaining code compatibility.
4. **Behavioral Fidelity**: Preserve vanilla quirks and behavior; do not "fix" strange vanilla logic unless proven to be a decompiler artifact.
5. **Documentation**: Maintain reverse-engineering notes in `docs/`:
   - `docs/architecture.md`
   - `docs/reverse-engineering.md`
   - `docs/vanilla-behavior.md`
   - `docs/save-format.md`
   - `docs/asset-mapping.md`
   - `docs/known-uncertainties.md`
6. **Critical Smali Reconstruction**: Precisely reverse-engineer and implement `Area.cast(Entity)` from `reference/clean_apk/.../Area.smali` and the instruction dump in `scratch/area_debug`.

---

## 3-Stage Migration Plan

### Stage 1 — Establish Compiling Baseline (In Progress)
1. **Initialize Project Skeleton**:
   - Root `build.gradle.kts`, `settings.gradle.kts`, `gradle.properties`, Gradle wrapper (v8.9).
   - `app/build.gradle.kts` (compileSdk 35, minSdk 26, AGP 8.5.2, Kotlin 1.9.24, DataBinding/ViewBinding enabled).
   - Base `docs/` templates.
2. **Import Resources & Assets**:
   - Vanilla `res/` and `assets/` from `reference/clean_apk/`.
   - Clean up AAPT2 resource discrepancies and manifest entries.
3. **Import Clean Domain Sources**:
   - Extract `it/paranoidsquirrels/idleguildmaster` Java code from `jadx_output`.
   - Wire standard Gradle dependencies (AndroidX, Jackson, RxJava, TrueTime).
   - Exclude decompiled DataBinding generated classes (let AGP regenerate them).
4. **Reconstruct `Area.cast(Entity)`**:
   - Analyze bytecode dispatcher in `Area.smali` and implement exact skill dispatching in Java.
5. **Fix Compilation Errors**:
   - Resolve decompilation syntax artifacts, missing symbols, and visibility qualifiers.
   - **Verification**: Run `.\gradlew assembleDebug` until build succeeds.

### Stage 2 — Functional Parity Verification
1. Verify application launch, save loading/deserialization, and guild headquarters screen.
2. Verify adventurer generation, recruitment, and inventory assignment.
3. Verify dungeon loop, combat encounters, skill casting via `Area.cast`, and loot distribution.
4. Verify offline idle time calculations and save serialization.

### Stage 3 — Progressive Kotlin Migration
1. Move domain models and formulas into `app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/domain/`.
2. Convert item/entity/skill hierarchies into Kotlin data and sealed classes.
3. Migrate combat and progression simulations into `game/`.
4. Modernize UI layers with Kotlin idioms and coroutines.

---

## Verification Criteria
- Stage 1: `.\gradlew assembleDebug` outputs `app-debug.apk` with exit code 0.
- Stage 2: ADB deploy to connected device, boots into MainActivity with 0 unhandled exceptions in Logcat.
