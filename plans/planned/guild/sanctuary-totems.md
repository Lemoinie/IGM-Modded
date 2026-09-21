# Sanctuary Totems: Passive Shelter Resonance System

## Goal Description
Introduce the **Sanctuary Totem** system to the Pet Shelter (`DialogShelter`), giving pets resting in the shelter meaningful guild-wide utility even when not deployed to an active combat party.

This system directly solves the "idle pet syndrome" caused by large shelter expansions (e.g. Sanctuary Grounds I & II + Senko pack = 20+ shelter capacity) where only 4 pets can fight in dungeons while the rest sit idle.

---

## User Review Required

> [!IMPORTANT]
> ### 1. Deployment Mechanism: Totem Attunement Slots vs. Counting All Pets
> To avoid incentivizing players to hoard 50 low-tier duplicate pets and clutter calculations, Sanctuary Totems uses **Dedicated Totem Attunement Slots**:
> 
> - **Totem Pedestal**: Located at the top of the Pet Shelter dialog.
> - **3 Base Slots**: Unlocked by default; expandable to **5 Slots** via Shelter level or Gem upgrades.
> - **Attunement Rule**:
>   - Players choose which resting pets to place into the Totem Slots.
>   - Attuned pets **remain in the shelter**, continue to receive Auto-Feed, and can be swapped freely.
>   - Attuned pets **cannot simultaneously be deployed** to a dungeon or raid team.
>   - **Unique Species Rule**: You cannot slot two of the exact same pet species into the Totem (e.g. only 1 Wolf, 1 Red Wolf, 1 Senko).

---

> [!IMPORTANT]
> ### 2. Level Scaling & Same-Family Diminishing Returns
> A Level 1 pet does **NOT** give the same bonus as a Level 100 pet. Resonance scales dynamically with **Pet Level** and **Tier**:
> 
> $$\text{Pet Resonance} = \text{Base Value} \times \left(1.0 + \frac{\text{Level}}{100.0} \times \text{Tier}\right)$$
> 
> #### Same-Family Diminishing Returns (Option 2)
> Players can attune multiple pets of the same family (as long as they are distinct species, e.g. `Dove`, `Eagle`, `Owl`):
> * **1st Pet of a Family**: **100%** resonance value.
> * **2nd Pet of same Family**: **50%** resonance value.
> * **3rd Pet of same Family**: **25%** resonance value.
> 
> *Examples*:
> * **3× Lv100 Avians** (`Dove` + `Eagle` + `Owl`): $10\% + 5\% + 2.5\% = \mathbf{+17.5\%}$ **Dodge** (rewards collection without breaking combat balance).
> * **3× Lv100 Insects** (`Beetle` + `Mosquito` + `Tarantula`): $20\% + 10\% + 5\% = \mathbf{+35\%}$ **Curious chance** to roll drops twice.
> 
> *Synergy*: Leveling shelter pets through Auto-Feeding and Shelter Effectiveness directly benefits the entire guild!

---

> [!IMPORTANT]
> ### 3. Family Resonance Perks
> Each pet family grants a specific, thematic guild-wide bonus when attuned. The perks cover all 7 vanilla pet types plus the planned Mystic family:
> 
> | Pet Family | In-Game Species | Primary Resonance Perk | Single Max (Lv100 T4) | 3-Pet Max (Diminishing) |
> | :--- | :--- | :--- | :---: | :---: |
> | **Avian** | `Dove`, `Eagle`, `Owl` | **Graceful Flight**: Increases party Dodge Chance | +10.0% Dodge | **+17.5% Dodge** |
> | **Construct** | `Golem`, `Tesseract` | **Fortified Aegis**: Increases party Physical Defense & Magic Defense | +12 DEF & MDEF | **+18 DEF & MDEF** |
> | **Esoteric** | `FloatingEye`, `ThingFromTheAbyss`, `TentacleTangle` | **Eldritch Ward**: Increases party Status Effect Immunity chance | +25.0% Immunity | **+43.75% Immunity** |
> | **Insect** | `Beetle`, `Mosquito`, `Tarantula` | **Curious Harvesters**: Directly boosts party pet's **Curious trait** (chance to roll drops twice, stacking additively) | +20.0% Curious | **+35.0% Curious** |
> | **Reptile** | `Crocodile`, `Lizard`, `TreeFrog` | **Predatory Precision**: Increases party Hit Chance (reduces miss rate) | +15.0% Hit Chance | **+26.25% Hit Chance** |
> | **Wild** | `Rat`, `RedWolf`, `Squirrel` | **Feral Instinct**: Boosts party Critical Strike Chance & Critical Damage | +5% Crit, +25% Crit Dmg | **+8.75% Crit, +43.75% Crit Dmg** |
> | **Wooden** | `FloatingSeed`, `HolyTree`, `WalkingBush` | **Nature's Bounty**: Increases Auto-Feed effectiveness & team healing dealt | +40% Food, +8% Healing | **+70% Food, +14% Healing** |
> | **Mystic** | `Phoenix`, `Senko` | **Ancestral Wisdom**: Increases all Adventurer combat experience gained | +40.0% XP | **+60.0% XP** |

> [!TIP]
> **Insect & Curious Trait Synergy**:
> Rather than creating a separate drop-doubling mechanic that could be abused to roll drops 3× times, Insect resonance directly adds to the existing **Curious** pet trait roll:
> * *Example*: A player with 3× Lv100 Insects (+35% Totem Curious) deploying a Lv82 pet with Curious 24.6% will have:
>   $$24.6\% + 35.0\% = \mathbf{59.6\%} \text{ total chance to roll drops twice}$$
> This provides clean, balanced drop amplification without multiple stacking rolls.

---

## Proposed Changes

### UI & Presentation
#### [MODIFY] [dialog_shelter.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/layout/dialog_shelter.xml)
- Add a collapsible `Sanctuary Totem` banner at the top of the shelter.
- Shows 3–5 circular totem pedestal slots where attuned pet avatars are displayed with a glowing border.
- Tapping an empty slot opens the pet selection modal to attune an available shelter pet.
- Tapping an attuned pet shows its current resonance contribution and an "Unattune" button.

#### [NEW] [item_totem_slot.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/layout/item_totem_slot.xml)
- Layout for individual totem slot display (pet sprite, level badge, family resonance icon).

---

### Game Logic & Combat Integration
#### [NEW] [SanctuaryTotemManager.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/game/pets/SanctuaryTotemManager.kt)
- Calculates total active resonance bonuses across all attuned pets, applying the 100% / 50% / 25% diminishing returns for duplicate families.
- Exposes getters for combat, shelter, and drop calculations:
  - `getDodgeBonus(): Double` (Avian: +% Dodge)
  - `getDefenseBonus(): Int` & `getMagicDefenseBonus(): Int` (Construct: +DEF/MDEF)
  - `getStatusImmunityBonus(): Double` (Esoteric: +% Status Immunity)
  - `getCuriousBonus(): Double` (Insect: +% Curious trait chance to roll drops twice)
  - `getHitChanceBonus(): Double` (Reptile: +% Hit Chance)
  - `getCritChanceBonus(): Double` & `getCritDamageBonus(): Double` (Wild: +% Crit & Crit Damage)
  - `getHealingMultiplier(): Double` & `getFoodEffectivenessBonus(): Double` (Wooden: +% Healing & Food Value)
  - `getXpMultiplier(): Double` (Mystic: +% Adventurer XP)

#### [MODIFY] [Entity.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/Entity.kt) / [Combat.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/combat/Combat.kt)
- Integrate `SanctuaryTotemManager` combat stat bonuses into adventurer stats (Dodge, DEF/MDEF, Status Immunity, Hit Chance, Crit Chance, Crit Damage).

#### [MODIFY] [DungeonCombat.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/combat/DungeonCombat.kt) / [Pet.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/pets/Pet.kt)
- When evaluating the party pet's `Curious` roll-twice check upon winning drops, add `SanctuaryTotemManager.getCuriousBonus()` directly to the activation chance.

#### [MODIFY] [Data.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/Data.kt)
- Add `@SerializedName("totemAttunedPetIds") var totemAttunedPetIds: ArrayList<String> = ArrayList()`.
- Add `@SerializedName("totemMaxSlots") var totemMaxSlots: Int = 3`.

---

## Verification Plan

### Automated Tests
- In `PetSystemTest.kt`:
  - `testTotemAttunementSlotCap()`: verify maximum slot enforcement (3 base, up to 5).
  - `testTotemDuplicateSpeciesPrevention()`: verify cannot attune two of the exact same species simultaneously.
  - `testSameFamilyDiminishingReturns()`: verify 1st bird = 100%, 2nd bird = 50%, 3rd bird = 25% (total 17.5% dodge for 3 Lv100 birds).
  - `testInsectCuriousIntegration()`: verify Insect resonance adds directly to the Curious drop-twice roll chance.
  - `testWildCritBonus()`: verify Wild resonance boosts both Crit Chance and Crit Damage.
  - `testMysticXpScaling()`: verify Lv100 Mystic provides +40% XP bonus.
