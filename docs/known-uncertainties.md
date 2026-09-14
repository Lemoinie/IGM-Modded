# Known Uncertainties

Tracking list for reverse-engineering and reconstruction questions. Items below are
marked **RESOLVED** when a behavior was verified; unresolved questions should be
recorded here instead of being forgotten.

## 1. `Area.cast(Entity)` Disassembly

- **Status**: RESOLVED.
- **Context**: JADX failed to produce Java code for the skill dispatcher method due
  to SSA variable elimination conflicts across 3,338 bytecode instruction units.
- **Reference**: `reference/clean_apk/smali_classes3/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.smali`
  (lines 1204–1770).
- **Resolution**:
  - Reconstructed 100% of the 100 packed-switch cases (`pswitch_63` through
    `pswitch_0`) mapping `Skills` enum ordinals directly to their execution logic.
  - Verified 92 fluent builder cases using `Area$Skill` methods
    (`setTargetSelectionMode`, `setDamageAmplification`, `setCriticalAmplification`,
    `setStatusEffect`, `setForceRange`, `applyEffectOnDodge`, `healing`, `noLog`,
    `recastOnKill`, `setExecutionThreshold`, `setReviveProbability`).
  - Faithfully reproduced all 8 custom logic cases (`ACTIVE_BARRAGE_II`,
    `ACTIVE_ESCAPE`, `ACTIVE_FIRE_DANCE`, `ACTIVE_DREAM_FORGE`,
    `ACTIVE_BOTCHED_SACRIFICE`, `ACTIVE_OVERDRIVE`, `ACTIVE_FRAGMENTATION`,
    `ACTIVE_EN_GARDE`).
  - Correctly reproduced the 3 multi-execute skill chains (`ACTIVE_FOCUSED_BARRAGE`,
    `ACTIVE_SUBLIMATE`, `ACTIVE_WHIP_AND_TEAR`).
  - The Kotlin port lives in `storage/data/places/Area.kt`; the Java baseline is in
    `backup_java/Area.java`. The JVM test `test5_ReconstructedSkillCasting_AreaCastMethod`
    exercises representative cases.

## 2. AdMob & Play Billing Stubs

- **Status**: RESOLVED (implemented, hidden from UI).
- **Context**: The game should not attempt live store transactions or display ads in
  the reconstructed build, but the underlying subsystems must exist so calling code
  compiles without mock-stub divergence.
- **Resolution**:
  - Integrated official Google Play Billing 7.1.1 and Google Mobile Ads SDK 23.1.0.
  - Preserved `IAPWrapper` and `MainActivity` ad-loading callbacks intact.
  - Temporarily disabled AdMob and IAP in the UI: the ad/shop/ad-free views and the
    drawer shop item are hidden, and merchant/raid-shop buy buttons are hidden.

## 3. DataBinding Generation vs JADX Output

- **Status**: RESOLVED.
- **Context**: JADX dumped generated DataBinding classes (`*BindingImpl.java`,
  `DataBinderMapperImpl.java`) which collided with AGP's built-in annotation
  processor.
- **Resolution**:
  - Excluded decompiled generated databinding classes from the source tree.
  - `dataBinding = true` + `viewBinding = true` in `app/build.gradle.kts`; AGP now
    generates all type-safe layout bindings directly from XML (under `app/build/`).

## 4. Decompiled Java Syntax / Control Flow Artifacts

- **Status**: RESOLVED.
- **Context**: JADX emitted several decompilation anomalies, including
  `Adventurer.calculateTotalStat(int)` with duplicate method bodies, unreachable
  double-`break;` statements in dungeons, coroutine-timeout references to
  non-existent constants, and an inverted loop in `Utils.rollSpecialFoods`.
- **Resolution**: Reconstructed exact calculations and loop structures verified
  against pristine Dalvik bytecode in `reference/clean_apk/`.

## 5. Save Version / Schema Drift

- **Status**: RESOLVED (documented behavior).
- **Context**: The on-disk save has **no explicit version field**. Compatibility is
  maintained by the tolerant `DataDeserializer` (unknown keys ignored, missing keys
  default). This is by design in the reconstruction, not a gap.
- **Implication**: When adding save fields, add them to `Data` with
  `@SerializedName`; old saves will load with defaults for new keys. If a field
  needs migration logic, implement it in `DataDeserializer` and document it here.

## Open Items / Revisit List

- **Unverified locale parity**: ~130 `values-*/` folders mirror vanilla strings. The
  mod touches a handful of keys (`app_name`, etc.). Whether every locale needs every
  new mod string has not been fully verified.
- **Reference workspace availability**: The ground-truth reference
  (`C:\Repositories\Idle Guild Master`) lives outside this repository; if it is ever
  unavailable, `backup_java/` and this docs folder are the fallback.
- **SDK 35**: `gradle.properties` carries `android.suppressUnsupportedCompileSdk=35`
  but the module compiles against SDK 34. Moving to 35 is not yet planned/verified.