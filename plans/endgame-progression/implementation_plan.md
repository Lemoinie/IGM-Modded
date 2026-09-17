# Implementation Plan: Endgame Progression System (Transcendence & Apotheosis)

Build a multi-tiered endgame progression ladder for `Idle Guild Master` extending beyond Ascension to engage players with max-level rosters:
1. **Transcendence (Tier 1)**: Unlocks the **4th Equipment Slot (Artifacts)**, **T9 Class-Exclusive Unique Traits**, and the **Astral Constellation System** (a celestial doctrine-like skill chart).
2. **Apotheosis (Tier 2)**: Unlocks the **Ultimate Bar (0–100, +20 regen/turn)** and **Ultimate Skills** with high-impact combat animations and celestial aesthetics.

---

## User Review Required

> [!IMPORTANT]
> **Data Model & Backward Compatibility**:
> - New fields in `Adventurer` (`transcended: Boolean`, `apotheosis: Boolean`, `artifact: Item?`, `uniqueTrait: UniqueTrait?`, `constellationPoints: Int`, `currentUltimate: Int`) will be made optional and default-safe in [`DataDeserializer.kt`](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/DataDeserializer.kt) to ensure zero save file corruption on existing saves.
> - Transcendence will require a hero to be **Level 45/50 Ascended**.
> - Apotheosis will require a hero to be **Level 50 Transcended**.

> [!TIP]
> **Phased Rollout**:
> We will implement and verify this in two distinct phases:
> - **Phase A: Transcendence** (Artifact slot, T9 Unique Traits, Constellations, Save Editor support).
> - **Phase B: Apotheosis** (Ultimate bar, Ultimate skill combat loop, visual FX).

---

## Open Questions

1. **Artifact Acquisition**: Should Artifacts be craftable in the Workshop using raid drops (e.g. Celestial Mothership / Void Beast components), acquired as direct raid boss drops, or earned via the new Guild Request / Siege milestones?
2. **Transcendence Reset**: When an adventurer transcends, should they reset to Level 1 of their base class (like Ascension) or remain at Level 45/50 with uncapped max levels (e.g. Level cap 60)?

---

## Proposed Changes

### Phase 1: Core Entity & Save Model Architecture

#### [MODIFY] [Adventurer.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/Adventurer.kt)
- Add progression flags:
  ```kotlin
  @JvmField var transcended: Boolean = false
  @JvmField var apotheosis: Boolean = false
  ```
- Add 4th equipment slot:
  ```kotlin
  @JvmField var artifact: Item? = null
  ```
- Add T9 Unique Trait field:
  ```kotlin
  @JvmField var uniqueTrait: String? = null
  ```
- Add Ultimate Bar combat state:
  ```kotlin
  @JvmField var currentUltimate: Int = 0
  open fun calculateUltimateRegen(): Int = 20
  ```
- Update stat calculations:
  - Base stat multiplier: Ascended = 1.5x, Transcended = 2.0x, Apotheosis = 2.5x.
  - Include `artifact` in stat scans (`calculateTotalStat`, retaliation, dodge, decay, lifesteal).

#### [MODIFY] [DataDeserializer.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/DataDeserializer.kt) & [Data.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/Data.kt)
- Safely parse `"transcended"`, `"apotheosis"`, `"artifact"`, and `"uniqueTrait"` from adventurer JSON blocks with null fallbacks.

---

### Phase 2: 4th Equipment Slot (Artifacts / Soul Relics)

#### [NEW] `it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Artifact`
- Base abstract class extending `Equipment()`:
  - Specialized hooks: `bonusUltimateRegen()`, `damageTypeConversion()`, `threatDamageConversion()`, `partyAura()`.

#### [NEW] Initial Suite of Endgame Artifacts (under `items/instances/`):
- `HeartOfTheVoid`: Converts physical damage to magic damage; adds +10% lifesteal.
- `CrownOfTheTyrant`: Converts threat into +0.5% damage per threat point and generates party barriers.
- `ChronosHourglass`: +10 bonus Ultimate bar generation per turn.
- `AegisOfDawn`: The first fatal hit suffered each combat is nullified and grants a 50% max HP barrier.

#### [MODIFY] [LayoutAdventurerDetailBinding](file:///C:/Repositories/IGM-Modded/app/src/main/res/layout/dialog_entity_detail.xml) & [DialogEntityDetail.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogEntityDetail.kt)
- Add the 4th item slot UI icon next to Accessory with item swap/equip dialog bindings.

---

### Phase 3: T9 Class-Exclusive Unique Traits

#### [NEW] `it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.UniqueTraits`
- Enum defining signature traits for all Tier 9 classes:
  - **Black Regent** -> `OVERLORDS_REIGN`: Attacks against enemies below 50% HP deal +30% damage and steal 10 mana.
  - **Angel of War** -> `AEGIS_OF_THE_SERAPH`: Basic attacks radiate 25% holy splash damage to adjacent enemies; 30% of overhealing converts to ally barrier.
  - **White Archmage** -> `RADIANT_CONDUIT`: Healing spells smite the lowest-HP enemy for 50% of the heal amount.
  - **Hailstorm** -> `ABSOLUTE_ZERO`: Attacks on Frozen targets deal +50% damage and spread Freeze.
  - **Fury** -> `RAMPAGE`: Critical strikes grant an extra basic attack (up to 2 per turn).
  - **Shadow Sentinel** -> `PHANTOM_RETALIATION`: Dodging an attack triggers an immediate guaranteed critical counterattack.

#### [MODIFY] [Area.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt)
- Integrate unique trait hooks into damage dealing, skill casting, and turn resolution loops.

---

### Phase 4: Astral Constellations (New Doctrine-like System)

#### [NEW] `it.paranoidsquirrels.idleguildmaster.storage.data.constellations.Constellation`
- Celestial skill-chart data model:
  - Constellations: *The Phoenix* (Resurrection/Fire), *The Leviathan* (Damage Reduction/Shields), *The Chronomancer* (Turn Speed/Ultimate Charge), *The Void Serpent* (Darkness/Execution).
  - Points earned through transcended levels and weekly Siege/Request clears.

#### [NEW] `DialogConstellations.kt` & Layout
- Visual interactive star chart dialog for allocating Astral Shards into passive party auras.

---

### Phase 5: Ultimate Bar & Ultimate Skills (Apotheosis)

#### [MODIFY] [Entity.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/Entity.kt)
- Add `currentUltimate: Int = 0`, `ultimateSkill: Skills? = null`.

#### [MODIFY] [Area.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt)
- In the turn execution loop:
  ```kotlin
  if (entity.isApotheosis() && entity.currentUltimate >= 100) {
      castUltimateSkill(entity, area)
      entity.currentUltimate = 0
  } else if (entity.currentMana >= 100) {
      castActiveSkill(entity, area)
      entity.currentMana = 0
  } else {
      basicAttack(entity, area)
      entity.currentMana = min(100, entity.currentMana + entity.calculateManaRegen())
      if (entity.isApotheosis()) {
          entity.currentUltimate = min(100, entity.currentUltimate + entity.calculateUltimateRegen())
      }
  }
  ```

#### [MODIFY] [Skills.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/Skills.kt)
- Add ultimate skills for all T9 archetypes (e.g. `ULTIMATE_JUDGMENT_OF_THE_RUINED_KING`, `ULTIMATE_HEAVENS_RETRIBUTION`, `ULTIMATE_BLIZZARD_OF_AGES`).

#### [MODIFY] Combat UI & [UIUtils.kt](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/UIUtils.kt)
- Add the 3rd purple/cyan Ultimate gauge on adventurer combat portraits.
- Add Apotheosis Celestial glowing unit card borders and title palettes.

---

### Phase 6: Save Editor Integration

#### [MODIFY] [data.js](file:///C:/Repositories/IGM-Modded/save_editor/data.js) & [app.js](file:///C:/Repositories/IGM-Modded/save_editor/app.js)
- Add `artifact` 4th slot to adventurer cards with item search autocomplete and live sprite preview.
- Add `transcended` and `apotheosis` checkbox badges.
- Add `uniqueTrait` selector populated with all T9 signature traits.
- Add Constellation points and progress controls to the Resources tab.

---

## Verification Plan

### Automated Tests
1. **Compilation Check**: Run `./gradlew assembleDebug` to guarantee zero bytecode / syntax errors.
2. **Unit Tests**: Add tests under `app/src/test/kotlin/` verifying:
   - Stat scaling multipliers for Ascended (1.5x), Transcended (2.0x), and Apotheosis (2.5x).
   - 4th slot Artifact stat aggregation.
   - Ultimate Bar charges by +20 each turn and triggers Ultimate Skill at 100.
   - Unique traits trigger correctly in simulated combat turns.
3. **Save Roundtrip Test**: Test loading existing saves, mutating to Transcended/Apotheosis with Artifacts, and re-serializing.

### Manual / Device Verification
1. Open `DialogEntityDetail` on a max-level ascended unit -> verify Transcendence ritual button appears.
2. Complete Transcendence -> verify 4th Artifact slot unlocks, Unique Trait is assigned, and Constellation dialog opens.
3. Deploy into combat in Area/Dungeon -> verify Ultimate bar appears, regenerates +20 per turn, and casts cinematic Ultimate at 100.
4. Open `save_editor/index.html` in browser -> confirm heroes show Artifact slot, Transcended state, and Unique Traits cleanly.
