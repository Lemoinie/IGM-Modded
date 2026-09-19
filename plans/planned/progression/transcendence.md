# Implementation Plan - Transcendence Endgame Progression

Implement **Transcendence (Tier 1 Endgame Progression)** extending beyond Ascension for max-level (Level 45/50 Ascended) rosters.

---

## Goal & Design Philosophy

Transcendence unlocks:
1. **The 4th Equipment Slot (Artifacts / Soul Relics)**
2. **T9 Class-Exclusive Unique Traits**
3. **The Astral Constellation System** (a celestial doctrine-like skill chart)
4. **Base Stat Multiplier**: 2.0x base stats (up from 1.5x Ascended).

---

## User Review Required

> [!IMPORTANT]
> **Data Model & Backward Compatibility**:
> - New fields in `Adventurer` (`transcended: Boolean`, `artifact: Item?`, `uniqueTrait: String?`, `constellationPoints: Int`) will be made optional and default-safe in `DataDeserializer.kt` to ensure zero save file corruption on existing saves.
> - Transcendence requires a hero to be **Level 45/50 Ascended**.

---

## Detailed Mechanics & Architecture

### 1. 4th Equipment Slot (Artifacts)
- **Base Class**: `it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Artifact` extending `Equipment()`:
  - Specialized hooks: `damageTypeConversion()`, `threatDamageConversion()`, `partyAura()`.
- **Initial Suite of Endgame Artifacts**:
  - `HeartOfTheVoid`: Converts physical damage to magic damage; adds +10% lifesteal.
  - `CrownOfTheTyrant`: Converts threat into +0.5% damage per threat point and generates party barriers.
  - `AegisOfDawn`: The first fatal hit suffered each combat is nullified and grants a 50% max HP barrier.
- **UI Integration**:
  - Add 4th item slot UI icon next to Accessory in `dialog_entity_detail.xml` with item swap/equip dialog bindings.

### 2. T9 Class-Exclusive Unique Traits
- **`UniqueTraits` Enum**:
  - **Black Regent** $\to$ `OVERLORDS_REIGN`: Attacks against enemies below 50% HP deal +30% damage and steal 10 mana.
  - **Angel of War** $\to$ `AEGIS_OF_THE_SERAPH`: Basic attacks radiate 25% holy splash damage to adjacent enemies; 30% of overhealing converts to ally barrier.
  - **White Archmage** $\to$ `RADIANT_CONDUIT`: Healing spells smite the lowest-HP enemy for 50% of the heal amount.
  - **Hailstorm** $\to$ `ABSOLUTE_ZERO`: Attacks on Frozen targets deal +50% damage and spread Freeze.
  - **Fury** $\to$ `RAMPAGE`: Critical strikes grant an extra basic attack (up to 2 per turn).
  - **Shadow Sentinel** $\to$ `PHANTOM_RETALIATION`: Dodging an attack triggers an immediate guaranteed critical counterattack.

### 3. Astral Constellations System
- **`Constellation.kt`**:
  - Celestial skill-chart data model:
    - *The Phoenix* (Resurrection/Fire)
    - *The Leviathan* (Damage Reduction/Shields)
    - *The Void Serpent* (Darkness/Execution)
  - Points earned through transcended levels and weekly Siege/Request clears.
- **`DialogConstellations.kt`**:
  - Visual interactive star chart dialog for allocating Astral Shards into passive party auras.

### 4. Save Editor Integration
- In `save_editor/data.js` and `save_editor/app.js`:
  - Add `artifact` 4th slot to adventurer cards with item search autocomplete and sprite preview.
  - Add `transcended` checkbox badge.
  - Add `uniqueTrait` selector.
  - Add Constellation points controls to the Resources tab.

---

## Proposed Changes

### Core Entity & Save Model
- In `Adventurer.kt`: add `transcended: Boolean = false`, `artifact: Item? = null`, `uniqueTrait: String? = null`.
- In `DataDeserializer.kt` & `Data.kt`: safe deserialization with null fallbacks.

### UI & Dialogs
- In `dialog_entity_detail.xml` & `DialogEntityDetail.kt`: add 4th equipment slot icon and Transcendence action button.
- Create `DialogConstellations.kt`.

---

## Verification Plan

### Automated Tests
- Unit tests verifying:
  - 2.0x base stat multiplier for Transcended units.
  - 4th slot Artifact stat aggregation.
  - Unique traits trigger correctly in combat simulation.
  - Save file roundtrip serialization.
