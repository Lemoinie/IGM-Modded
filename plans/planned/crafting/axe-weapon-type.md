# Implementation Plan: Axes Weapon System & Reference Integration

## 1. Goal Description

Integrate the complete **Axes** weapon archetype into *Idle Guild Master*, implementing all 26 weapons, exact stat distributions, special on-hit combat procs, crafting recipes, and drop mechanics defined in [reference/Axes](file:///c:/Repositories/IGM-Modded/reference/Axes).

This plan establishes Axes as the 5th core weapon family (alongside Sword, Bow, Dagger, and Staff) designed specifically for the **Outlander** class family ([reference/Outlander](file:///c:/Repositories/IGM-Modded/reference/Outlander)), supporting three specialized weapon subcategories:
1. **Standard Axes & Greataxes**: Heavy physical melee weapons scaling with Constitution, delivering crushing strikes with high damage variance ($\pm 20\%$). Equippable by the entire Berserker progression line and Tamer lines.
2. **Long Axes**: Hybrid poleaxes infused with primal/eldritch power, featuring high Intelligence and multiple debilitating status afflictions (Poison, Freeze, Ablaze, Stun, Silence). Exclusively wielded by **Druids** (and usable by Berserkers/Tamers).
3. **Cleavers**: High-agility, high-risk weapons with extreme damage spread ($\pm 30\%$ to $\pm 50\%$) and evasive bonuses. Exclusively wielded by **Exiles** (and usable by Berserkers/Tamers).

---

## 2. Visual Assets & Resource Mapping

All 26 graphical assets are pre-existing 32x32 PNG sprites located in [reference/Axes](file:///c:/Repositories/IGM-Modded/reference/Axes). They will be installed into `app/src/main/res/drawable/`:

| Source File | Destination Resource | Weapon Class Name | Subtype |
| :--- | :--- | :--- | :--- |
| `stick.png` | `@drawable/stick` | `Stick` | Starter / Default Axe |
| `copper_axe.png` | `@drawable/copper_axe` | `CopperAxe` | Standard Axe |
| `iron_axe.png` | `@drawable/iron_axe` | `IronAxe` | Standard Axe |
| `undead_axe.png` | `@drawable/undead_axe` | `UndeadAxe` | Standard Axe |
| `gold_axe.png` | `@drawable/gold_axe` | `GoldenAxe` | Standard Axe |
| `corrupted_axe.png` | `@drawable/corrupted_axe` | `CorruptedAxe` | Standard Axe (Drop) |
| `enforcers_axe.png` | `@drawable/enforcers_axe` | `EnforcersAxe` | Standard Axe |
| `zapper.png` | `@drawable/zapper` | `Zapper` | Standard Axe |
| `black_iron_axe.png` | `@drawable/black_iron_axe` | `BlackIronAxe` | Standard Axe |
| `abyssal_great_axe.png` | `@drawable/abyssal_great_axe` | `AbyssalGreataxe` | Greataxe |
| `frostmetal_axe.png` | `@drawable/frostmetal_axe` | `FrostmetalAxe` | Standard Axe |
| `frozen_long_axe.png` | `@drawable/frozen_long_axe` | `FrozenLongAxe` | Long Axe |
| `obsidian_axe.png` | `@drawable/obsidian_axe` | `ObsidianAxe` | Standard Axe |
| `vampire_axe.png` | `@drawable/vampire_axe` | `VampireAxe` | Standard Axe |
| `unholy_axe.png` | `@drawable/unholy_axe` | `UnholyAxe` | Standard Axe |
| `primeval_axe.png` | `@drawable/primeval_axe` | `PrimevalAxe` | Standard Axe |
| `celestial_axe.png` | `@drawable/celestial_axe` | `CelestialAxe` | Standard Axe |
| `animated_axe.png` | `@drawable/animated_axe` | `AnimatedAxe` | Standard Axe |
| `enchanted_cleaver.png` | `@drawable/enchanted_cleaver` | `EnchantedCleaver` | Cleaver |
| `wicked_cleaver.png` | `@drawable/wicked_cleaver` | `WickedCleaver` | Cleaver |
| `berserkers_axe.png` | `@drawable/berserkers_axe` | `BerserkersAxe` | Standard Axe (Drop) |
| `molten_slayer.png` | `@drawable/molten_slayer` | `MoltenSlayer` | Standard Axe |
| `omni_sever.png` | `@drawable/omni_sever` | `OmniSever` | Raid Axe |
| `cursed_long_axe.png` | `@drawable/cursed_long_axe` | `CursedLongAxe` | Long Axe |
| `infernal_long_axe.png` | `@drawable/infernal_long_axe` | `InfernalLongAxe` | Long Axe |
| `abhorrent_long_axe.png` | `@drawable/abhorrent_long_axe` | `AbhorrentLongAxe` | Long Axe |

---

## 3. Weapon Architecture & Subtypes

### 3.1 Scaling & Damage Mechanics

In *Idle Guild Master*, weapon damage is determined by [`Adventurer.calculateMinAttackDamage()`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/Adventurer.kt#L262) and [`calculateMaxAttackDamage()`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/Adventurer.kt#L277):
$$\text{Min Attack} = \text{damageModifier} \times (1.0 - \text{damageDelta})$$
$$\text{Max Attack} = \text{damageModifier} \times (1.0 + \text{damageDelta})$$

| Weapon Family | Scaling Function (`getDamageModifier`) | Base Spread (`damageDelta`) | Archetype Identity |
| :--- | :--- | :--- | :--- |
| **Sword** | `CON` | $\pm 15\%$ (`0.15`) | Reliable melee |
| **Bow** | `DEX` | $\pm 10\%$ (`0.10`) | Precise ranged |
| **Dagger** | `CON + DEX` | $\pm 25\%$ (`0.25`) | Wide burst melee |
| **Staff** | `INT` | $\pm 5\%$ (`0.05`) | Consistent magic |
| **Axe (New)** | `CON` | $\pm 20\%$ (`0.20`) | Brutal heavy physical melee |
| **Long Axe (New)** | `CON` (or `CON + INT/2`) | $\pm 20\%$ (`0.20`) | Elemental & hybrid crowd-control melee |
| **Cleaver (New)** | `CON` | $\pm 30\%$ to $\pm 50\%$ | Wild swing high-risk skirmishing melee |

### 3.2 Abstract Class Hierarchy

Create under `app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/`:

#### 1. [`Axe.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/Axe.kt)
```kotlin
package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses

import it.paranoidsquirrels.idleguildmaster.R

abstract class Axe : Weapon() {
    override fun damageDelta(): Double = 0.20
    override fun getDamageModifier(i: Int, i2: Int, i3: Int): Int = i // Constitution
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false
    override fun printType(): Int = R.string.type_axe
    override fun damageDescription(): Int = R.string.help_attack_axes
}
```

#### 2. [`LongAxe.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/LongAxe.kt)
```kotlin
package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses

import it.paranoidsquirrels.idleguildmaster.R

abstract class LongAxe : Axe() {
    override fun damageDelta(): Double = 0.20
    override fun getDamageModifier(i: Int, i2: Int, i3: Int): Int = i // Constitution
    override fun printType(): Int = R.string.type_long_axe
    override fun damageDescription(): Int = R.string.help_attack_long_axes
}
```

#### 3. [`Cleaver.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/Cleaver.kt)
```kotlin
package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses

import it.paranoidsquirrels.idleguildmaster.R

abstract class Cleaver : Axe() {
    override fun damageDelta(): Double = 0.30 // Baseline 30%, overrides to 50% for Wicked Cleaver
    override fun printType(): Int = R.string.type_cleaver
    override fun damageDescription(): Int = R.string.help_attack_cleavers
}
```

---

## 4. Class Equipment Suitability Matrix

According to the canonical specification in `Axes Stats and Crafting Cost.docx`:
- **Berserkers** (and Marauder, Barbarian, Savage Berserker, Scarlet Berserker, Blood Reaver, Crimson Warlord, Avatar of Wrath): **Any axe** (`w is Axe`).
- **Tamers** (Heathen, Rat Tamer, and Beast Tamer progression): **Any axe** (`w is Axe`).
- **Druids**: **Long Axes** (`w is LongAxe || w.getTrueClass() == "Stick"`).
- **Exiles**: **Cleavers** (`w is Cleaver || w.getTrueClass() == "Stick"`).

### 4.1 Suitability Logic in [`Adventurer.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/Adventurer.kt#L239)

```kotlin
open fun isWeaponSuitable(w: Weapon?): Boolean {
    if (w == null) return false
    if (doctrine?.canUseAllWeapons() == true) return true
    if (weaponType == R.string.type_axe) {
        return w is Axe // Any Axe (Standard Axe, Long Axe, Cleaver)
    }
    return w.printType() == weaponType
}
```

- In `Druid.kt`:
  ```kotlin
  weaponType = R.string.type_long_axe
  override fun isWeaponSuitable(w: Weapon?): Boolean {
      if (w == null) return false
      if (doctrine?.canUseAllWeapons() == true) return true
      return w is LongAxe || w.getTrueClass() == "Stick"
  }
  ```
- In `Exile.kt`:
  ```kotlin
  weaponType = R.string.type_cleaver
  override fun isWeaponSuitable(w: Weapon?): Boolean {
      if (w == null) return false
      if (doctrine?.canUseAllWeapons() == true) return true
      return w is Cleaver || w.getTrueClass() == "Stick"
  }
  ```

### 4.2 Filtering in [`DialogSelectEquipment.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogSelectEquipment.kt#L104)

Replace the hardcoded `item.printType() == slotType` weapon check with `adv.isWeaponSuitable(item as? Weapon)`:
```kotlin
val available = ArrayList<Equipment>()
for (item in MainActivity.data.items) {
    val suitable = when (t) {
        "weapon" -> adv.isWeaponSuitable(item as? Weapon)
        "armor" -> adv.isArmorSuitable(item as? Armor)
        "accessory" -> item is Accessory
        else -> false
    }
    if (suitable && item is Equipment) {
        available.add(item)
    }
}
```
*Result*: When selecting a weapon for a Berserker or Tamer, all 26 axes appear. For a Druid, only Long Axes appear. For an Exile, only Cleavers appear.

---

## 5. Complete 26 Weapons Catalog

### 5.1 Standard Axes & Greataxes

| Item Name | Class | Subtype | Stats | Special Effects | Crafting Ingredients / Source | Price |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **Stick** | `Stick` | Axe | +1 CON, +1 INT | None (Starter / Fallback) | Default starter weapon | 0L |
| **Copper Axe** | `CopperAxe` | Axe | +2 CON, +2 INT | None | 3x `Wood`, 3x `CopperIngot` | 20L |
| **Iron Axe** | `IronAxe` | Axe | +4 CON, +3 INT | None | 15x `Wood`, 5x `IronIngot` | 50L |
| **Undead Axe** | `UndeadAxe` | Axe | +8 CON, +5 INT | None | 30x `BoneFragment`, 3x `SharpRib` | 75L |
| **Golden Axe** | `GoldenAxe` | Axe | +12 CON, +6 INT | None | 5x `Redwood`, 15x `GoldIngot` | 485L |
| **Corrupted Axe** | `CorruptedAxe` | Axe | +1 CON | None | **0.1% Drop** from `Enforcer` (Kaunis) | 250L |
| **Enforcer's Axe** | `EnforcersAxe` | Axe | +18 CON, +10 DEX, +18 INT | None | 1x `CorruptedAxe`, 1x `CleansingPotion` | 950L |
| **Zapper** | `Zapper` | Axe | +19 CON, +10 DEX, +19 INT | 10% Stun (1 turn) | 1x `EnforcersAxe`, 1x `StaticEssence` | 2,100L |
| **Black Iron Axe** | `BlackIronAxe` | Axe | +15 CON, +6 INT | None | 3x `GhostwoodBoard`, 3x `BlackIronIngot` | 380L |
| **Abyssal Greataxe** | `AbyssalGreataxe` | Axe | +25 CON, +20 INT | None | 10x `GhostwoodBoard`, 5x `AbyssalIngot` | 1,250L |
| **Frostmetal Axe** | `FrostmetalAxe` | Axe | +17 CON, +8 INT | None | 3x `Winterwood`, 1x `FrostmetalIngot` | 520L |
| **Obsidian Axe** | `ObsidianAxe` | Axe | +20 CON, +10 INT | None | 72x `ObsidianChunk` | 360L |
| **Vampire Axe** | `VampireAxe` | Axe | +20 CON, +10 INT | +20% Lifesteal | 1x `ObsidianAxe`, 1x `CrimsonBrew` | 1,050L |
| **Unholy Axe** | `UnholyAxe` | Axe | +24 CON, +12 INT | +25% Counterattack | 1x `ObsidianAxe`, 1x `UnholyPotion` | 1,520L |
| **Primeval Axe** | `PrimevalAxe` | Axe | +35 CON, +10 DEF | None | 100x `ElysianWood`, 3x `PrimevalScale` | 2,200L |
| **Celestial Axe** | `CelestialAxe` | Axe | +26 CON, +14 INT | None | 44x `CelestialMetal` | 610L |
| **Animated Axe** | `AnimatedAxe` | Axe | +28 CON, +16 INT | None | 47x `AnimatedIngot` | 670L |
| **Berserker's Axe** | `BerserkersAxe` | Axe | +40 CON | 10% Extra Attack | **3.0% Drop** from `Berserker` (Lost Lands) | 2,600L |
| **Molten Slayer** | `MoltenSlayer` | Axe | +50 CON | 10% Extra Attack, 100% Ablaze (1 turn) | 1x `BerserkersAxe`, 10x `Infernite` | 5,200L |
| **Omni-Sever** | `OmniSever` | Axe | +30 CON, +30 INT | 20% Freeze, 15% Ablaze, 10% Stun (1 turn) | 1x `GoldenAxe`, 1x `PrismaticEssence` | 6,800L |

### 5.2 Long Axes (Druid Specialty)

| Item Name | Class | Subtype | Stats | Special Effects | Crafting Ingredients / Source | Price |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **Frozen Long Axe** | `FrozenLongAxe` | Long Axe | +5 CON, +15 INT | 100% Freeze (1 turn) | 1x `FrostmetalAxe`, 1x `FrostNucleus`, 5x `FrostCrystal` | 1,450L |
| **Cursed Long Axe** | `CursedLongAxe` | Long Axe | +10 CON, +25 INT | 100% Poison (2 turns) | 20x `CursedSilver`, 5x `Redwood` | 2,800L |
| **Infernal Long Axe** | `InfernalLongAxe` | Long Axe | +20 CON, +35 INT | 100% Poison (2 turns), 100% Ablaze (2 turns) | 1x `CursedLongAxe`, 10x `Infernite` | 5,400L |
| **Abhorrent Long Axe**| `AbhorrentLongAxe`| Long Axe | +30 CON, +45 INT | 100% Poison (2t), 100% Ablaze (2t), 10% Stun (1t), 10% Silence (1t) | 1x `CursedLongAxe` (or `InfernalLongAxe`), 1x `AbioticCore` | 9,500L |

### 5.3 Cleavers (Exile Specialty)

| Item Name | Class | Subtype | Stats | Special Effects | Crafting Ingredients / Source | Price |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **Enchanted Cleaver**| `EnchantedCleaver`| Cleaver | +25 CON, +25 INT | $\pm 30\%$ Damage Spread | 1x `SpellCompendium`, 1x `AnimatedAxe` | 1,800L |
| **Wicked Cleaver** | `WickedCleaver` | Cleaver | +25 CON, +25 INT | $\pm 50\%$ Damage Spread, +10% Dodge | 1x `EnchantedCleaver`, 1x `VeilShatterer`, 1x `WickedSeal` | 3,850L |

---

## 6. Engine Enhancements

### 6.1 Equipment Extra Attack Chance

Currently, `endOfTurnAction = EndOfTurnAction.EXTRA_ATTACK` in [`Equipment.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/Equipment.kt) is unconditionally added if non-null. For weapons with proc chances (e.g. Berserker's Axe and Molten Slayer at 10%):

1. In `Equipment.kt`:
   ```kotlin
   @JvmField @Transient protected var endOfTurnActionProbability: Double = 1.0
   open fun getEndOfTurnActionProbability(): Double = endOfTurnActionProbability
   ```
2. In [`Adventurer.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/Adventurer.kt#L756):
   ```kotlin
   val w = weapon
   if (w != null && w.getEndOfTurnAction() != null) {
       if (w.getEndOfTurnActionProbability() >= 1.0 || Utils.random() < w.getEndOfTurnActionProbability()) {
           val wAction = w.getEndOfTurnAction()!!
           for (i in 0 until w.getEndOfTurnActionRepeats()) {
               arrayList.add(wAction)
           }
       }
   }
   ```

### 6.2 Multiple On-Hit Status Afflictions

Weapons like `OmniSever`, `InfernalLongAxe`, and `AbhorrentLongAxe` inflict multiple status effects simultaneously (or each with independent probabilities).

1. In `Equipment.kt`:
   ```kotlin
   @JvmField @Transient protected var onTargetHitList: MutableList<StatusEffect> = mutableListOf()
   open fun getOnTargetHitEffects(): List<StatusEffect> {
       if (onTargetHitList.isNotEmpty()) return onTargetHitList
       return listOfNotNull(onTargetHit)
   }
   ```
2. In [`Adventurer.onTargetHitEffects()`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/Adventurer.kt#L693):
   ```kotlin
   val w = weapon
   if (w != null) {
       for (hit in w.getOnTargetHitEffects()) {
           arrayList.add(StatusEffect(hit.type, this, hit.turnsLeft, hit.probability))
       }
   }
   ```

---

## 7. Enemy Drop Tables

### 7.1 Corrupted Axe Drop from Imperial Enforcer

In [`Enforcer.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/units/Enforcer.kt):
```kotlin
override fun rollDrops(evKey: Int): List<ItemWrapper> {
    val drops = super.rollDrops(evKey).toMutableList()
    // 0.1% independent drop for Corrupted Axe
    if (Utils.random() < 0.001) {
        drops.add(ItemWrapper.getInstance("CorruptedAxe", 1))
    }
    return drops
}
```

### 7.2 Berserker's Axe Drop from The Berserker

In [`storage/data/entities/enemies/units/Berserker.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/units/Berserker.kt):
```kotlin
override fun rollDrops(evKey: Int): List<ItemWrapper> {
    val drops = super.rollDrops(evKey).toMutableList()
    // 3.0% independent drop for Berserker's Axe
    if (Utils.random() < 0.03) {
        drops.add(ItemWrapper.getInstance("BerserkersAxe", 1))
    }
    return drops
}
```

---

## 8. Crafting Recipes in [`Recipes.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/Recipes.kt)

Add the 24 craftable axe entries to the `Recipes` enum:
```kotlin
// --- Axe Progression ---
CopperAxe(Item.getInstance("Wood", 3), Item.getInstance("CopperIngot", 3)),
IronAxe(Item.getInstance("Wood", 15), Item.getInstance("IronIngot", 5)),
UndeadAxe(Item.getInstance("BoneFragment", 30), Item.getInstance("SharpRib", 3)),
GoldenAxe(Item.getInstance("Redwood", 5), Item.getInstance("GoldIngot", 15)),
EnforcersAxe(Item.getInstance("CorruptedAxe", 1), Item.getInstance("CleansingPotion", 1)),
Zapper(Item.getInstance("EnforcersAxe", 1), Item.getInstance("StaticEssence", 1)),
BlackIronAxe(Item.getInstance("GhostwoodBoard", 3), Item.getInstance("BlackIronIngot", 3)),
AbyssalGreataxe(Item.getInstance("GhostwoodBoard", 10), Item.getInstance("AbyssalIngot", 5)),
FrostmetalAxe(Item.getInstance("Winterwood", 3), Item.getInstance("FrostmetalIngot", 1)),
FrozenLongAxe(Item.getInstance("FrostmetalAxe", 1), Item.getInstance("FrostNucleus", 1), Item.getInstance("FrostCrystal", 5)),
ObsidianAxe(Item.getInstance("ObsidianChunk", 72)),
VampireAxe(Item.getInstance("ObsidianAxe", 1), Item.getInstance("CrimsonBrew", 1)),
UnholyAxe(Item.getInstance("ObsidianAxe", 1), Item.getInstance("UnholyPotion", 1)),
PrimevalAxe(Item.getInstance("ElysianWood", 100), Item.getInstance("PrimevalScale", 3)),
CelestialAxe(Item.getInstance("CelestialMetal", 44)),
AnimatedAxe(Item.getInstance("AnimatedIngot", 47)),
EnchantedCleaver(Item.getInstance("SpellCompendium", 1), Item.getInstance("AnimatedAxe", 1)),
WickedCleaver(Item.getInstance("EnchantedCleaver", 1), Item.getInstance("VeilShatterer", 1), Item.getInstance("WickedSeal", 1)),
MoltenSlayer(Item.getInstance("BerserkersAxe", 1), Item.getInstance("Infernite", 10)),
OmniSever(Item.getInstance("GoldenAxe", 1), Item.getInstance("PrismaticEssence", 1)),
CursedLongAxe(Item.getInstance("CursedSilver", 20), Item.getInstance("Redwood", 5)),
InfernalLongAxe(Item.getInstance("CursedLongAxe", 1), Item.getInstance("Infernite", 10)),
AbhorrentLongAxe(Item.getInstance("CursedLongAxe", 1), Item.getInstance("AbioticCore", 1)),
```

---

## 9. Global Utilities & UI Integration

### 9.1 Storage Sorting in [`Utils.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt#L125)

```kotlin
private fun typeToPriority(item: Item?): Int {
    if (item == null) return 13
    return try {
        when (item) {
            is Sword -> 1
            is Axe -> 2        // Axes sit right next to Swords
            is Bow -> 3
            is Dagger -> 4
            is Staff -> 5
            ...
```

### 9.2 Default Weapon Fallback in [`Utils.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt#L1058)

```kotlin
@JvmStatic
fun getDefaultWeapon(i: Int): Weapon? {
    return when (i) {
        R.string.type_sword -> Item.getInstance("Spade") as? Weapon
        R.string.type_staff -> Item.getInstance("Cane") as? Weapon
        R.string.type_dagger -> Item.getInstance("Sickle") as? Weapon
        R.string.type_bow -> Item.getInstance("TrainingBow") as? Weapon
        R.string.type_axe, R.string.type_long_axe, R.string.type_cleaver -> Item.getInstance("Stick") as? Weapon
        else -> null
    }
}
```

---

## 10. String Resources in `strings.xml`

Add to `app/src/main/res/values/strings.xml`:
- Weapon type labels:
  - `type_axe`: `"AXE"`
  - `type_long_axe`: `"LONG AXE"`
  - `type_cleaver`: `"CLEAVER"`
- Weapon descriptions:
  - `help_attack_axes`: `"Axes deal heavy physical melee damage scaling with Constitution, delivering devastating swings with high damage variance."`
  - `help_attack_long_axes`: `"Long Axes deal hybrid physical damage, channeling elemental and eldritch afflictions upon enemies."`
  - `help_attack_cleavers`: `"Cleavers deliver unpredictable, high-variance physical strikes while granting evasive agility in combat."`
- Item names, descriptions, and effect strings for all 26 weapons.

---

## 11. Phased Execution Roadmap

### Phase 1: Assets & Resource Strings
- Copy all 26 PNG files from `reference/Axes/` to `app/src/main/res/drawable/`.
- Add type strings (`type_axe`, `type_long_axe`, `type_cleaver`), help descriptions, and all item name/desc/effect strings to `strings.xml`.

### Phase 2: Engine & Architecture Modifications
- Create `Axe.kt`, `LongAxe.kt`, and `Cleaver.kt` in `abstractClasses/`.
- Add `endOfTurnActionProbability` and `onTargetHitList` / `getOnTargetHitEffects()` to `Equipment.kt`.
- Update `Adventurer.kt` for probability checks on weapon extra attacks, multi-effect on-hit procs, and weapon suitability.
- Update `DialogSelectEquipment.kt` to use `adv.isWeaponSuitable(item as? Weapon)`.
- Update `Utils.kt` for default weapon fallback (`Stick`) and priority sorting (`is Axe -> 2`).

### Phase 3: Item Instances
- Implement all 26 item classes in `storage/data/items/instances/`:
  - `Stick.kt`, `CopperAxe.kt`, `IronAxe.kt`, `UndeadAxe.kt`, `GoldenAxe.kt`, `CorruptedAxe.kt`, `EnforcersAxe.kt`, `Zapper.kt`, `BlackIronAxe.kt`, `AbyssalGreataxe.kt`, `FrostmetalAxe.kt`, `FrozenLongAxe.kt`, `ObsidianAxe.kt`, `VampireAxe.kt`, `UnholyAxe.kt`, `PrimevalAxe.kt`, `CelestialAxe.kt`, `AnimatedAxe.kt`, `EnchantedCleaver.kt`, `WickedCleaver.kt`, `BerserkersAxe.kt`, `MoltenSlayer.kt`, `OmniSever.kt`, `CursedLongAxe.kt`, `InfernalLongAxe.kt`, `AbhorrentLongAxe.kt`.

### Phase 4: Enemy Drop Tables
- Update `Enforcer.kt` to drop `CorruptedAxe` at 0.1% chance.
- Update `storage/data/entities/enemies/units/Berserker.kt` to drop `BerserkersAxe` at 3.0% chance.

### Phase 5: Workshop Crafting Recipes
- Register all 24 craftable axes in `Recipes.kt`.

### Phase 6: Outlander Tree Integration
- Align Outlander classes (`Outlander`, `Marauder`, `Barbarian`, `Berserker`, `Heathen`, `RatTamer`, `Druid`, `Exile`) to their respective `weaponType` and suitability rules.

### Phase 7: Verification & Testing
- Run `./gradlew testDebugUnitTest` to ensure all existing unit tests pass.
- Write new unit tests verifying:
  - Axe base damage calculations and spread ($\pm 20\%$, Cleaver $\pm 30\% / \pm 50\%$).
  - Weapon suitability for Berserker (Any Axe), Druid (Long Axe only), Exile (Cleaver only), and other classes (ineligible).
  - All 24 recipes resolve correctly via `Recipes.from()` and `Recipes.into()`.
  - On-hit status effects trigger with specified probabilities.
  - Drop table rolls for `Enforcer` and `Berserker`.
