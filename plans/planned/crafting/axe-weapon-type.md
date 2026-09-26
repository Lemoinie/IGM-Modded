# Implementation Plan: New Weapon Type — Axe

## 1. Goal Description
Introduce **Axe** as a distinct 5th weapon category alongside Sword, Bow, Dagger, and Staff.
Axes will serve as the primary weapon type for the **Outlander** class family (Marauder, Barbarian, Berserker), emphasizing heavy, crushing physical strikes with high damage variance and heavy Constitution scaling.

---

## 2. Weapon Identity & Mathematical Mechanics

### 2.1 Weapon Scaling & Variance Comparison
In Idle Guild Master, weapon damage is calculated via [`Adventurer.calculateMinAttackDamage()`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/Adventurer.kt#L251) and [`calculateMaxAttackDamage()`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/Adventurer.kt#L263):
$$\text{Min Damage} = \text{damageModifier} \times (1.0 - \text{damageDelta})$$
$$\text{Max Damage} = \text{damageModifier} \times (1.0 + \text{damageDelta})$$

| Weapon Type | Primary Stat Modifier | Damage Delta ($\pm$ Spread) | Attack Nature |
| :--- | :--- | :--- | :--- |
| **Sword** | `CON` | $\pm 15\%$ (`0.15`) | Balanced Physical Melee |
| **Bow** | `DEX` | $\pm 10\%$ (`0.10`) | Ranged Physical |
| **Dagger** | `CON + DEX` | $\pm 25\%$ (`0.25`) | Wide Variance Burst Melee |
| **Staff** | `INT` | $\pm 5\%$ (`0.05`) | Consistent Ranged Magic |
| **Axe (New)** | `CON` (or `CON + DEX/2`) | $\pm 20\%$ (`0.20`) | Brutal, Heavy Physical Melee |

### 2.2 Axe Abstract Base Class
Create [`Axe.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/Axe.kt):
```kotlin
package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses

import it.paranoidsquirrels.idleguildmaster.R

abstract class Axe : Weapon() {
    override fun damageDelta(): Double = 0.20
    override fun getDamageModifier(i: Int, i2: Int, i3: Int): Int = i // scales with Constitution
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false
    override fun printType(): Int = R.string.type_axe
    override fun damageDescription(): Int = R.string.help_attack_axes
}
```

---

## 3. Weapon Progression Line (Tier 1 to Tier 9)

To ensure Outlanders have gear progression matching existing classes, implement an Axe line:

| Tier | Weapon Name | Class Name | Stats / Perks | Crafting Ingredients |
| :--- | :--- | :--- | :--- | :--- |
| **T0 / Default** | Rusty Axe | `RustyAxe.kt` | 0 bonus stats (Unequipped fallback) | None (Default weapon) |
| **T1** | Woodcutter's Axe | `WoodcuttersAxe.kt` | +2 CON | 2x Wood, 1x Copper Bar |
| **T2** | Iron Battleaxe | `IronBattleaxe.kt` | +5 CON, +3% Crit Chance | 4x Iron Bar, 2x Wood |
| **T3** | Steel Waraxe | `SteelWaraxe.kt` | +9 CON, +5% Crit Chance | 4x Steel Bar, 2x Hardwood |
| **T4** | Mithril Cleaver | `MithrilCleaver.kt` | +15 CON, +7% Crit Chance, +5% Crit Dmg | 4x Mithril Bar, 2x Beast Horn |
| **T5** | Berserker's Greataxe | `BerserkersGreataxe.kt` | +22 CON, +10% Crit, +10% Lifesteal | 4x Orichalcum, 2x Cursed Bone |
| **T6** | Obsidian Decapitator | `ObsidianDecapitator.kt` | +32 CON, +12% Crit, +15% Bleed Damage | 4x Obsidian Bar, 2x Dragon Scale |
| **T7** | Bloodforged Executioner | `BloodforgedExecutioner.kt` | +45 CON, +15% Crit, +15% Lifesteal | 4x Bloodstone, 2x Demonic Essence |
| **T8** | Titan Cleaver | `TitanCleaver.kt` | +60 CON, +20% Crit, +20% Crit Dmg | 4x Adamantite, 2x Titan Bone |
| **T9 (Mythic)**| World Breaker | `WorldBreaker.kt` | +80 CON, +25% Crit, Extra Attack +15% | 5x Primordial Core, 2x Ancient Shard |

---

## 4. Architectural Modifications & Integrations

### 4.1 String Resources
In `app/src/main/res/values/strings.xml`:
- `type_axe`: `"Axe"`
- `help_attack_axes`: `"Axes deal heavy physical melee damage scaling with Constitution, delivering devastating swings with high critical variance."`
- Item names & descriptions for all implemented axes.

### 4.2 Storage Priority & Sorting
In [`Utils.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt#L125-L145):
```kotlin
private fun typeToPriority(item: Item?): Int {
    if (item == null) return 14
    return when (item) {
        is Sword -> 1
        is Axe -> 2       // Priority next to swords
        is Bow -> 3
        is Dagger -> 4
        is Staff -> 5
        ...
```

### 4.3 Default Unequipped Fallback
In [`Utils.getDefaultWeapon(weaponType)`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt):
```kotlin
if (weaponType == R.string.type_axe) {
    return Item.getInstance("RustyAxe") as Weapon
}
```

### 4.4 Workshop Recipes
In [`Recipes.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/Recipes.kt):
Register recipes for craftable axes across workshop progression tiers.

---

## 5. Verification Checklist

- [ ] `Axe.kt` abstract class created with correct damage spread and scaling.
- [ ] `R.string.type_axe` and `R.string.help_attack_axes` added to strings.xml.
- [ ] `RustyAxe.kt` starter weapon implemented and registered in `Utils.getDefaultWeapon()`.
- [ ] Axe weapons (T1 through T8/T9) implemented in `items/instances/`.
- [ ] `Utils.typeToPriority` handles `is Axe`.
- [ ] Equipment selection dialog (`DialogSelectEquipment`) filters axes correctly when selecting weapons for Axe-wielding adventurers.
- [ ] Unit tests pass (`./gradlew testDebugUnitTest`).
