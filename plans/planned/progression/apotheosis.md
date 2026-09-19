# Implementation Plan - Apotheosis Endgame Progression

Implement **Apotheosis (Tier 2 Endgame Progression)** extending beyond Transcendence for max-level (Level 50 Transcended) adventurers.

---

## Goal & Design Philosophy

Apotheosis unlocks:
1. **The Ultimate Bar (0–100 Gauge, +20 charge/turn)**
2. **Ultimate Skills** with high-impact combat animations and celestial aesthetics
3. **Base Stat Multiplier**: 2.5x base stats (up from 2.0x Transcended).
4. **Celestial Visuals**: Apotheosis glowing card borders, glowing combat portraits, and title palettes.

---

## User Review Required

> [!IMPORTANT]
> **Progression Requirement**:
> - Apotheosis requires a hero to be **Level 50 Transcended**.
> - The Ultimate Bar functions alongside Mana: heroes charge both Mana (for active skills) and Ultimate (for ultimate skills).

---

## Detailed Mechanics & Architecture

### 1. Ultimate Bar & Combat Loop
- **`currentUltimate: Int = 0`** on `Entity`:
  - Regenerates by +20 per turn: `calculateUltimateRegen(): Int = 20`.
  - Artifacts like `ChronosHourglass` can boost generation (+10 bonus/turn).
- **Turn Priority in `Area.kt`**:
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

### 2. Ultimate Skills Suite (`Skills.kt`)
Signature ultimates for T9 archetypes:
- **`ULTIMATE_JUDGMENT_OF_THE_RUINED_KING`** (Black Regent): Deals 500% damage to all enemies, silences for 3 turns, and grants the entire party 50% max HP shields.
- **`ULTIMATE_HEAVENS_RETRIBUTION`** (Angel of War): Resurrects all fallen allies with 50% HP and smites all enemies with 400% holy magic damage (+100% vs Undead).
- **`ULTIMATE_BLIZZARD_OF_AGES`** (Hailstorm): Freezes all enemies for 2 turns and deals 450% frost magic damage.
- **`ULTIMATE_CATACLYSMIC_VOLLEY`** (Wyrm Rider): Wyrm sweeps the battlefield dealing 600% hybrid damage, applying Ablaze and Frozen.
- **`ULTIMATE_SHADOW_HARVEST`** (Whisper): Instantly strikes the 3 lowest-HP enemies for 600% physical damage with 100% critical rate.

### 3. Combat UI & Visuals
- In `dialog_dungeon_detail.xml` & `UIUtils.kt`:
  - Add a 3rd purple/cyan Ultimate progress bar beneath the HP and Mana bars for Apotheosis units.
  - Apotheosis celestial glowing borders on unit cards in combat and headquarters.

### 4. Save Editor Integration
- In `save_editor/data.js` and `save_editor/app.js`:
  - Add `apotheosis` checkbox badge and ultimate skill configuration.

---

## Proposed Changes

### Core Entity & Combat
- In `Adventurer.kt` & `Entity.kt`: add `apotheosis: Boolean = false`, `currentUltimate: Int = 0`.
- In `Area.kt`: wire ultimate charge resolution and ultimate skill casting in turn execution.
- In `Skills.kt`: declare ultimate skills.

### UI & Layout
- In `dialog_dungeon_detail.xml` / `layout_entity_fighting.xml`: add the Ultimate gauge.
- In `UIUtils.kt`: add Apotheosis styling and color palettes.

---

## Verification Plan

### Automated Tests
- Unit tests verifying:
  - 2.5x base stat multiplier for Apotheosis units.
  - Ultimate bar charges +20 per turn and triggers ultimate skill at 100.
  - Ultimate skills execute correctly with appropriate target modes and effects.
