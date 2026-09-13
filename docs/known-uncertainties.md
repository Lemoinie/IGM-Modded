# Known Uncertainties

## Tracking List

### 1. Area.cast(Entity) Disassembly
- **Status**: RESOLVED.
- **Context**: JADX failed to produce Java code for the skill dispatcher method due to SSA variable elimination conflicts across 3,338 bytecode instruction units.
- **Reference**: `reference/clean_apk/smali_classes3/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.smali` (lines 1204–1770).
- **Resolution**:
  - Reconstructed 100% of the 100 packed-switch cases (`pswitch_63` through `pswitch_0`) mapping `Skills` enum ordinals directly to their execution logic.
  - Verified 92 fluent builder cases utilizing `Area$Skill` methods (`setTargetSelectionMode`, `setDamageAmplification`, `setCriticalAmplification`, `setStatusEffect`, `setForceRange`, `applyEffectOnDodge`, `healing`, `noLog`, `recastOnKill`, `setExecutionThreshold`, `setReviveProbability`).
  - Faithfully reproduced all 8 custom logic cases:
    - `ACTIVE_BARRAGE_II` (`pswitch_54`): Checks `EldritchAlchemist` for `FEEBLE_TETHER` to grant 10.0x damage amplification instead of 1.0x.
    - `ACTIVE_ESCAPE` (`pswitch_24`): Removes entity from combat and fighting group, logs flee event (code 43).
    - `ACTIVE_FIRE_DANCE` (`pswitch_a`): Progresses `summon_smoldering_titan` event and applies `ABLAZE` to acting entity.
    - `ACTIVE_DREAM_FORGE` (`pswitch_8`): Overheals caster by 10,000 HP, logs heal event (code 24), then strikes with 2.0x amp on 10 random targets.
    - `ACTIVE_BOTCHED_SACRIFICE` (`pswitch_9`): Logs event 115 and returns null.
    - `ACTIVE_OVERDRIVE` (`pswitch_e`): Damages `MagicArmor` unit by 300 HP, logs Larox overdrive string, and applies 0.7x damage + `STUN` to all enemies.
    - `ACTIVE_FRAGMENTATION` (`pswitch_15`): Sacrifices 5,000 caster HP, logs fragmentation string, then executes a forced-ranged 5-hit attack.
    - `ACTIVE_EN_GARDE` (`pswitch_5d`): Applies 999-turn `DEFENSIVE_STANCE` to caster, then attacks with 2.0x amp.
  - Correctly reproduced the 3 multi-execute skill chains:
    - `ACTIVE_FOCUSED_BARRAGE` (`pswitch_4d`): Deals 0.5x damage to all enemies, then executes an unlogged follow-up.
    - `ACTIVE_SUBLIMATE` (`pswitch_4a`): Deals 1.7x damage + `ABLAZE` to all enemies with forced range, followed by 1.7x damage + `FROZEN` (2 turns) unlogged.
    - `ACTIVE_WHIP_AND_TEAR` (`pswitch_26`): Hits all except self for 30.0x melee damage, followed by a ranged unlogged attack on a random unit except self.

### 2. AdMob & Play Billing Stubs
- **Status**: RESOLVED (Implemented, hidden from UI).
- **Context**: The game should not attempt live store transactions or display ads in the reconstructed build, but the underlying subsystems must exist so calling code compiles without mock stub divergence.
- **Resolution**:
  - Integrated official Google Play Billing 7.1.1 and Google Mobile Ads SDK 23.1.0 dependencies.
  - Preserved `IAPWrapper` and `MainActivity` ad loading callbacks intact.
  - Temporarily disabled AdMob and IAP in the UI:
    - `MainActivity.refreshIcons()`: Force hides `activityMainBinding.ad`, `activityMainBinding.adfree`, `activityMainBinding.shop`, and drawer item `R.id.shop`.
    - `DialogBuyFromMerchant`: Sets `textView.setVisibility(View.GONE)`.
    - `DialogRefillRaidTry`: Sets `this.binding.shop.setVisibility(View.GONE)`.

### 3. DataBinding Generation vs JADX Output
- **Status**: RESOLVED.
- **Context**: JADX dumped generated databinding classes (`*BindingImpl.java`, `DataBinderMapperImpl.java`) which collide with AGP's built-in annotation processor.
- **Resolution**:
  - Excluded decompiled generated `databinding` classes from the source tree.
  - Configured `dataBinding = true` and `viewBinding = true` in `build.gradle.kts`. AGP now generates all type-safe layout bindings directly from XML.

### 4. Decompiled Java Syntax / Control Flow Artifacts
- **Status**: RESOLVED.
- **Context**: JADX emitted several decompilation anomalies:
  - `Adventurer.calculateTotalStat(int i)` was emitted with duplicate method bodies.
  - Dungeons emitted unreachable double-`break;` statements.
  - Coroutine timeouts in Quests referenced non-existent constants (`CoroutineLiveDataKt.DEFAULT_TIMEOUT`, `WorkRequest.MIN_BACKOFF_MILLIS`).
  - `Utils.rollSpecialFoods` generated an inverted loop condition.
- **Resolution**:
  - Reconstructed exact calculations and loop structures directly verified against pristine Dalvik bytecode in `reference/clean_apk/`.
