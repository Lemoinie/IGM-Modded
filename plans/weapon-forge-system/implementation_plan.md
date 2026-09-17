# Implementation Plan: Weapon Leveling & Forge System

## Goal Description
Implement a comprehensive **Weapon Forging System** accessible from a new **Forge** building in Headquarters. The system allows players to forge weapons from +1 to +10 using materials and gold, rolling stat upgrades native to each weapon, with fail de-leveling rollbacks, lock-on-destroy mechanics, storage slot separation, and custom rarity borders.

---

## 1. Core Mechanics & Design Specifications

### 1.1 Headquarters Forge Access
- **Headquarters Integration**:
  - Add a **Forge** option in HeadquartersFragment with its own building card in ragment_headquarters.xml.
  - Clicking Forge opens DialogForge.
- **Equipped Weapon Selection**:
  - Instead of browsing storage (which could contain hundreds of materials and items), DialogForge directly lists weapons **currently equipped by adventurers**.
  - Guarantees a compact, responsive list of at most 1–40 items.
  - Each entry displays:
    - Adventurer portrait, name, and class (e.g. *Lancelot - Royal Guard*).
    - Equipped weapon icon with its forge rarity border, name, and current forge level (+X).
  - Selecting a weapon opens the forge workstation for that item.

### 1.2 Random Stat Upgrade Mechanics
1. **Eligible Stats Determined by Native Weapon Stats**:
   - Only attributes among {HP, CON, DEX, INT} that have a base value > 0 on the specific weapon can be rolled:
     - Weapon with only DEX (e.g. CursedBow, VerdantBow): **100% chance** to pick DEX.
     - Weapon with CON and INT: **50% chance** to pick CON, **50%** INT.
     - Weapon with CON, DEX, and INT: **33.3% chance** each.
2. **Roll Value**:
   - Random integer from 1 to 5:
     - CON, DEX, or INT: increases by the exact rolled value (+1 to +5).
     - HP: increases by alue * 5 (+5 to +25 Max HP).
3. **De-leveling Rollback Stack (LIFO)**:
   - Each forged weapon maintains a persistent orgeRolls: MutableList<ForgeRoll>:
     `kotlin
     data class ForgeRoll(val stat: String, val rollValue: Int, val statIncrease: Int)
     `
   - **On Level Up**: Roll is pushed onto orgeRolls and added to the weapon\'s active bonus stats.
   - **On Failure Drop (-1)**: The topmost roll is popped from orgeRolls and deducted from the bonus stats. The weapon identically reverts to the exact stats it possessed at the lower level.
   - **Multi-Step Walkthrough (+6 -> +5 -> +4 -> +5 -> +6 -> +5)**:
     1. Start at +6: [R1, R2, R3, R4, R5_old, R6_old].
     2. Drop to +5: Pops R6_old. Stack is [R1, R2, R3, R4, R5_old].
     3. Drop to +4: Pops R5_old. Stack is [R1, R2, R3, R4]. Old Lv5 roll is discarded.
     4. Up to +5: Rolls a fresh Lv5 stat (R5_new, e.g. +4 CON). Stack: [R1, R2, R3, R4, R5_new].
     5. Up to +6: Rolls a fresh Lv6 stat (R6_new, e.g. +20 HP). Stack: [R1..R4, R5_new, R6_new].
     6. Drop to +5: Pops R6_new. Stack: [R1..R4, R5_new].
     - Final stat at +5: Base Stats + Rolls 1..4 + **R5_new (+4 CON)**.
   - **On Drop to +0**: Stack is cleared, all bonus stats reset to 0, and the weapon merges back into the standard Level 0 stack in storage.

### 1.3 Storage & Stacking Rules
- **Level 0 Weapons**: Stack together normally in a single storage slot (stack = N).
- **Forged Weapons (+1 to +10)**: Each forged weapon takes **its own separate slot** in storage (stack = 1). Two weapons of the same type and level (e.g. two Fang Dagger +1) occupy 2 separate slots.
- **Destroy / Locked**: On a Destroy outcome, the weapon is locked (isForgeLocked = true). It keeps its current level and stats, but cannot be forged further.
- **Equality in Item.kt**:
  `kotlin
  override fun equals(other: Any?): Boolean {
      if (this === other) return true
      if (other !is Item) return false
      if (trueClass == null || trueClass != other.trueClass) return false
      if (forgeLevel == 0 && other.forgeLevel == 0) return true
      return this === other
  }
  `

### 1.4 Rarity Borders & Visual Styling
1. **Border Color Palette**:
   - +0, +1, +2: **White Border** (object_border_dim_white).
   - +3, +4: **Uncommon** (
arity_border_uncommon, Green #8032ff32).
   - +5, +6: **Rare** (
arity_border_rare, Blue #ff0070dd).
   - +7, +8: **Epic** (
arity_border_epic, Purple #ffa335ee).
   - +9, +10: **Legendary** (
arity_border_legendary, Yellow / Gold #ffffaa00).
   - **Mythic**: Red (
arity_border_mythic.xml, #ffff1744), standby asset.
2. **Item-First Border on Character Sheet**:
   - detailWeapon renders the weapon\'s actual forge border (+3..+10 in Green, Blue, Purple, Gold).
   - If a weapon has a white border (+0..+2) and the adventurer is Ascended, it displays the Ascended hero border (object_border_ascended).
   - Only the hero portrait, name, level, and exp bar keep the Ascended hero frame.
3. **Visual Contrast**:
   - Ascended Hero frame: #ffffdb7f (soft pale champagne gold, 1dp stroke).
   - Legendary Weapon frame: #ffffaa00 (deep saturated amber-gold, 2dp stroke).
4. **Storage & Selection**:
   - Always displays the weapon\'s own forge rarity border.

### 1.5 Forging Probabilities
| Level | Success | Fail (-1) | Destroy (Lock) |
| :--- | :---: | :---: | :---: |
| **0 -> +1** | 100% | 0% | 0% |
| **+1 -> +2** | 90% | 10% (reverts to Lv0) | 0% |
| **+2 -> +3** | 80% | 20% (drops to +1) | 0% |
| **+3 -> +4** | 70% | 25% (drops to +2) | 5% |
| **+4 -> +5** | 60% | 30% (drops to +3) | 10% |
| **+5 -> +6** | 50% | 35% (drops to +4) | 15% |
| **+6 -> +7** | 40% | 40% (drops to +5) | 20% |
| **+7 -> +8** | 35% | 40% (drops to +6) | 25% |
| **+8 -> +9** | 30% | 40% (drops to +7) | 30% |
| **+9 -> +10** | 20% | 40% (drops to +8) | 40% |

---

## 2. Technical Architecture & File Changes

### 2.1 Headquarters & UI
- **[MODIFY] ragment_headquarters.xml**: Adds the orgeContainer card layout.
- **[MODIFY] HeadquartersFragment.kt**: Connects orgeContainer click listener to open DialogForge.
- **[NEW] DialogForge.kt & dialog_forge.xml**:
  - List screen: Lists all adventurers with their equipped weapons.
  - Workstation screen: Displays weapon icon, current vs next stats, material costs, success/fail/destroy odds, and animated Forge button.

### 2.2 Data Model & Engine Fixes
- **[MODIFY] Item.kt**:
  - orgeLevel: Int = 0, isForgeLocked: Boolean = false, orgeRolls: MutableList<ForgeRoll> = ArrayList().
  - Custom equals() (stacks at Lv0, instance identity at Lv1..10).
  - getDisplayName() appending +<level> and (Locked).
  - getRarity(): 0 for Lv0..2, 2 for Lv3..4, 3 for Lv5..6, 4 for Lv7..8, 5 for Lv9..10, 6 for Mythic.
- **[MODIFY] Equipment.kt**:
  - Adds rolled forge bonuses in getMaxHp(), getConstitution(), getDexterity(), getIntelligence().
- **[MODIFY] DataDeserializer.kt**:
  - Deserializes orgeLevel, isForgeLocked, and orgeRolls from save JSON.
- **[MODIFY] DialogSelectEquipment.kt**:
  - Fixes swap() to preserve the exact Equipment instance instead of spawning a reset Lv0 clone.
- **[MODIFY] UIUtils.kt**:
  - Updates ackgroundFromRarity() mapping to colored borders.
  - Grid adapter displays +X badge on weapon icon.
- **[MODIFY] colors.xml & [NEW] 
arity_border_mythic.xml**:
  - Configures Purple Epic, Gold Legendary, and Red Mythic border assets.

---

## 3. Verification Plan

### Automated Verification
1. Compilation check via Gradle / uild_mod.ps1.
2. Script verification:
   - Verify eligible stat filtering (DEX-only weapon only rolls DEX).
   - Verify roll history LIFO stack rollback on de-leveling.
   - Verify storage slot separation for +1..+10 and merge on 0.
   - Verify save/load JSON round-trip preserves all forge rolls.

### Manual Verification
1. Open Headquarters -> click Forge -> confirm list shows only equipped adventurer weapons.
2. Select a weapon, forge to +1, +2, +3:
   - Check name updates (+1, +2, +3).
   - Check border is white at +1/+2 and turns green at +3.
3. Check Ascended hero with +1 weapon -> shows golden Ascended border.
4. Check Ascended hero with +3 weapon -> shows green Uncommon border.
