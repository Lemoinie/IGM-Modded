# Implementation Plan: Axe Weapon Type & Catalog Integration

## 1. Goal Description

Implement the **Axe** weapon category into *Idle Guild Master*, introducing `Axe` as a distinct weapon type alongside Sword, Bow, Dagger, and Staff. This includes all 26 axes, their stats, special on-hit combat procs, crafting recipes, and drop mechanics specified in [reference/Axes](file:///c:/Repositories/IGM-Modded/reference/Axes).

Every weapon in [reference/Axes](file:///c:/Repositories/IGM-Modded/reference/Axes) belongs strictly to the **Axe** weapon category (`Axe.kt`), regardless of in-game naming.

---

## 2. Weapon Identity & Mathematical Mechanics

### 2.1 Scaling & Damage Spread
Weapon damage in *Idle Guild Master* is calculated in [`Adventurer.calculateMinAttackDamage()`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/Adventurer.kt#L262) and [`calculateMaxAttackDamage()`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/Adventurer.kt#L277):
$$\text{Min Attack} = \text{damageModifier} \times (1.0 - \text{damageDelta})$$
$$\text{Max Attack} = \text{damageModifier} \times (1.0 + \text{damageDelta})$$

| Weapon Family | Scaling Modifier (`getDamageModifier`) | Spread (`damageDelta`) | Attack Nature |
| :--- | :--- | :--- | :--- |
| **Sword** | $100\%$ CON (`i`) | $\pm 15\%$ (`0.15`) | Balanced physical melee |
| **Bow** | $100\%$ DEX (`i3`) | $\pm 10\%$ (`0.10`) | Consistent physical ranged |
| **Dagger** | $100\%$ CON + $100\%$ DEX (`i + i3`) | $\pm 25\%$ (`0.25`) | Wide variance burst melee |
| **Staff** | $100\%$ INT (`i2`) | $\pm 5\%$ (`0.05`) | Flat magical ranged |
| **Axe (New)** | $\mathbf{200\%}\text{ }\mathbf{CON}$ ($\mathbf{i \times 2}$) | $\pm \mathbf{20\%}$ ($\mathbf{0.20}$) | Devastating high-impact physical melee |

*Note on Cleaver variants*: `EnchantedCleaver` overrides `damageDelta` to $\pm 30\%$ (`0.30`) and `WickedCleaver` overrides `damageDelta` to $\pm 50\%$ (`0.50`), while retaining the same base `Axe` class and $200\%$ CON scaling.

### 2.2 Base Class: [`Axe.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/Axe.kt)

Create under `app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/Axe.kt`:
```kotlin
package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses

import it.paranoidsquirrels.idleguildmaster.R

abstract class Axe : Weapon() {
    override fun damageDelta(): Double = 0.20
    override fun getDamageModifier(i: Int, i2: Int, i3: Int): Int = i * 2 // 200% Constitution scaling
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false
    override fun printType(): Int = R.string.type_axe
    override fun damageDescription(): Int = R.string.help_attack_axes
}
```

All 26 weapons inherit directly from `Axe`.

---

## 3. Visual Assets & Resource Mapping

Copy all 26 PNG sprite files from [reference/Axes](file:///c:/Repositories/IGM-Modded/reference/Axes) into `app/src/main/res/drawable/`:

| Source File | Target Resource | Item Class | Description |
| :--- | :--- | :--- | :--- |
| `stick.png` | `@drawable/stick` | `Stick` | Starter / Default Axe |
| `copper_axe.png` | `@drawable/copper_axe` | `CopperAxe` | Copper Axe |
| `iron_axe.png` | `@drawable/iron_axe` | `IronAxe` | Iron Axe |
| `undead_axe.png` | `@drawable/undead_axe` | `UndeadAxe` | Undead Axe |
| `gold_axe.png` | `@drawable/gold_axe` | `GoldenAxe` | Golden Axe |
| `corrupted_axe.png` | `@drawable/corrupted_axe` | `CorruptedAxe` | Corrupted Axe |
| `enforcers_axe.png` | `@drawable/enforcers_axe` | `EnforcersAxe` | Enforcer's Axe |
| `zapper.png` | `@drawable/zapper` | `Zapper` | Zapper |
| `black_iron_axe.png` | `@drawable/black_iron_axe` | `BlackIronAxe` | Black Iron Axe |
| `abyssal_great_axe.png` | `@drawable/abyssal_great_axe` | `AbyssalGreataxe` | Abyssal Greataxe |
| `frostmetal_axe.png` | `@drawable/frostmetal_axe` | `FrostmetalAxe` | Frostmetal Axe |
| `frozen_long_axe.png` | `@drawable/frozen_long_axe` | `FrozenLongAxe` | Frozen Long Axe |
| `obsidian_axe.png` | `@drawable/obsidian_axe` | `ObsidianAxe` | Obsidian Axe |
| `vampire_axe.png` | `@drawable/vampire_axe` | `VampireAxe` | Vampire Axe |
| `unholy_axe.png` | `@drawable/unholy_axe` | `UnholyAxe` | Unholy Axe |
| `primeval_axe.png` | `@drawable/primeval_axe` | `PrimevalAxe` | Primeval Axe |
| `celestial_axe.png` | `@drawable/celestial_axe` | `CelestialAxe` | Celestial Axe |
| `animated_axe.png` | `@drawable/animated_axe` | `AnimatedAxe` | Animated Axe |
| `enchanted_cleaver.png` | `@drawable/enchanted_cleaver` | `EnchantedCleaver` | Enchanted Cleaver |
| `wicked_cleaver.png` | `@drawable/wicked_cleaver` | `WickedCleaver` | Wicked Cleaver |
| `berserkers_axe.png` | `@drawable/berserkers_axe` | `BerserkersAxe` | Berserker's Axe |
| `molten_slayer.png` | `@drawable/molten_slayer` | `MoltenSlayer` | Molten Slayer |
| `omni_sever.png` | `@drawable/omni_sever` | `OmniSever` | Omni-Sever |
| `cursed_long_axe.png` | `@drawable/cursed_long_axe` | `CursedLongAxe` | Cursed Long Axe |
| `infernal_long_axe.png` | `@drawable/infernal_long_axe` | `InfernalLongAxe` | Infernal Long Axe |
| `abhorrent_long_axe.png` | `@drawable/abhorrent_long_axe` | `AbhorrentLongAxe` | Abhorrent Long Axe |

---

## 4. Complete 26 Axes Catalog

All items are placed in `app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/instances/`.

| Item Class | Display Name | Stats | Special Perks / Procs | Price | Crafting / Drop Source |
| :--- | :--- | :--- | :--- | :--- | :--- |
| `Stick` | Stick | +1 CON, +1 INT | None | 0L | Base unequipped starter weapon |
| `CopperAxe` | Copper Axe | +2 CON, +2 INT | None | 20L | 3x `Wood`, 3x `CopperIngot` |
| `IronAxe` | Iron Axe | +4 CON, +3 INT | None | 50L | 15x `Wood`, 5x `IronIngot` |
| `UndeadAxe` | Undead Axe | +8 CON, +5 INT | None | 75L | 30x `BoneFragment`, 3x `SharpRib` |
| `GoldenAxe` | Golden Axe | +12 CON, +6 INT | None | 485L | 5x `Redwood`, 15x `GoldIngot` |
| `CorruptedAxe` | Corrupted Axe | +1 CON | None | 250L | **0.1% Drop** from `Enforcer` (Kaunis) |
| `EnforcersAxe` | Enforcer's Axe | +18 CON, +10 DEX, +18 INT | None | 950L | 1x `CorruptedAxe`, 1x `CleansingPotion` |
| `Zapper` | Zapper | +19 CON, +10 DEX, +19 INT | 10% Stun (1 turn) | 2,100L | 1x `EnforcersAxe`, 1x `StaticEssence` |
| `BlackIronAxe` | Black Iron Axe | +15 CON, +6 INT | None | 380L | 3x `GhostwoodBoard`, 3x `BlackIronIngot` |
| `AbyssalGreataxe` | Abyssal Greataxe | +25 CON, +20 INT | None | 1,250L | 10x `GhostwoodBoard`, 5x `AbyssalIngot` |
| `FrostmetalAxe` | Frostmetal Axe | +17 CON, +8 INT | None | 520L | 3x `Winterwood`, 1x `FrostmetalIngot` |
| `FrozenLongAxe` | Frozen Long Axe | +5 CON, +15 INT | 100% Freeze (1 turn) | 1,450L | 1x `FrostmetalAxe`, 1x `FrostNucleus`, 5x `FrostCrystal` |
| `ObsidianAxe` | Obsidian Axe | +20 CON, +10 INT | None | 360L | 72x `ObsidianChunk` |
| `VampireAxe` | Vampire Axe | +20 CON, +10 INT | +20% Lifesteal | 1,050L | 1x `ObsidianAxe`, 1x `CrimsonBrew` |
| `UnholyAxe` | Unholy Axe | +24 CON, +12 INT | +25% Counterattack | 1,520L | 1x `ObsidianAxe`, 1x `UnholyPotion` |
| `PrimevalAxe` | Primeval Axe | +35 CON, +10 DEF | None | 2,200L | 100x `ElysianWood`, 3x `PrimevalScale` |
| `CelestialAxe` | Celestial Axe | +26 CON, +14 INT | None | 610L | 44x `CelestialMetal` |
| `AnimatedAxe` | Animated Axe | +28 CON, +16 INT | None | 670L | 47x `AnimatedIngot` |
| `EnchantedCleaver` | Enchanted Cleaver | +25 CON, +25 INT | $\pm 30\%$ Damage Spread (`damageDelta = 0.30`) | 1,800L | 1x `SpellCompendium`, 1x `AnimatedAxe` |
| `WickedCleaver` | Wicked Cleaver | +25 CON, +25 INT | $\pm 50\%$ Spread (`damageDelta = 0.50`), +10% Dodge | 3,850L | 1x `EnchantedCleaver`, 1x `VeilShatterer`, 1x `WickedSeal` |
| `BerserkersAxe` | Berserker's Axe | +40 CON | 10% Extra Attack | 2,600L | **3.0% Drop** from `Berserker` (Lost Lands) |
| `MoltenSlayer` | Molten Slayer | +50 CON | 10% Extra Attack, 100% Ablaze (1 turn) | 5,200L | 1x `BerserkersAxe`, 10x `Infernite` |
| `OmniSever` | Omni-Sever | +30 CON, +30 INT | 20% Freeze, 15% Ablaze, 10% Stun (1 turn) | 6,800L | 1x `GoldenAxe`, 1x `PrismaticEssence` |
| `CursedLongAxe` | Cursed Long Axe | +10 CON, +25 INT | 100% Poison (2 turns) | 2,800L | 20x `CursedSilver`, 5x `Redwood` |
| `InfernalLongAxe` | Infernal Long Axe | +20 CON, +35 INT | 100% Poison (2 turns), 100% Ablaze (2 turns) | 5,400L | 1x `CursedLongAxe`, 10x `Infernite` |
| `AbhorrentLongAxe`| Abhorrent Long Axe| +30 CON, +45 INT | 100% Poison (2t), 100% Ablaze (2t), 10% Stun (1t), 10% Silence (1t) | 9,500L | 1x `CursedLongAxe`, 1x `AbioticCore` |

---

## 5. Engine Enhancements

### 5.1 Weapon Extra Attack Chance
In [`Equipment.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/Equipment.kt), add probability support for weapon extra attacks:
```kotlin
@JvmField @Transient protected var endOfTurnActionProbability: Double = 1.0
open fun getEndOfTurnActionProbability(): Double = endOfTurnActionProbability
```

In [`Adventurer.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/Adventurer.kt#L756):
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

### 5.2 Multiple On-Hit Status Afflictions
In [`Equipment.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/Equipment.kt), support weapons with multiple simultaneous or probabilistic on-hit status effects:
```kotlin
@JvmField @Transient protected var onTargetHitList: MutableList<StatusEffect> = mutableListOf()
open fun getOnTargetHitEffects(): List<StatusEffect> {
    if (onTargetHitList.isNotEmpty()) return onTargetHitList
    return listOfNotNull(onTargetHit)
}
```

In [`Adventurer.onTargetHitEffects()`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/Adventurer.kt#L693):
```kotlin
val w = weapon
if (w != null) {
    for (hit in w.getOnTargetHitEffects()) {
        arrayList.add(StatusEffect(hit.type, this, hit.turnsLeft, hit.probability))
    }
}
```

---

## 6. Enemy Drop Integrations

### 6.1 Corrupted Axe (0.1% Drop)
In [`Enforcer.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/units/Enforcer.kt):
```kotlin
override fun rollDrops(evKey: Int): List<ItemWrapper> {
    val drops = super.rollDrops(evKey).toMutableList()
    if (Utils.random() < 0.001) {
        drops.add(ItemWrapper.getInstance("CorruptedAxe", 1))
    }
    return drops
}
```

### 6.2 Berserker's Axe (3.0% Drop)
In [`storage/data/entities/enemies/units/Berserker.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/units/Berserker.kt):
```kotlin
override fun rollDrops(evKey: Int): List<ItemWrapper> {
    val drops = super.rollDrops(evKey).toMutableList()
    if (Utils.random() < 0.03) {
        drops.add(ItemWrapper.getInstance("BerserkersAxe", 1))
    }
    return drops
}
```

---

## 7. Workshop Crafting Recipes

Register in [`Recipes.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/Recipes.kt):
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

## 8. Global Utilities & Strings

### 8.1 Sorting & Fallback in [`Utils.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/Utils.kt)
1. In `typeToPriority()`:
   ```kotlin
   is Sword -> 1
   is Axe -> 2        // Axes sit right next to Swords
   is Bow -> 3
   ...
   ```
2. In `getDefaultWeapon()`:
   ```kotlin
   R.string.type_axe -> Item.getInstance("Stick") as? Weapon
   ```

### 8.2 String Resources in `strings.xml`
- `type_axe`: `"AXE"`
- `help_attack_axes`: `"Axes deal heavy physical melee damage scaling with 200% Constitution, delivering crushing strikes with high damage variance."`
- Item names, descriptions, and effect strings for all 26 weapons.

---

## 9. Verification Checklist

- [ ] All 26 PNG sprite files copied to `app/src/main/res/drawable/`.
- [ ] `Axe.kt` abstract base class implemented with `getDamageModifier = i * 2` and `damageDelta = 0.20`.
- [ ] All 26 weapon classes created in `items/instances/` inheriting directly from `Axe`.
- [ ] `EnchantedCleaver` and `WickedCleaver` override `damageDelta` to `0.30` and `0.50`.
- [ ] `Equipment.kt` and `Adventurer.kt` updated for weapon extra attack chance and multi-status effects.
- [ ] `Enforcer.kt` (0.1% Corrupted Axe) and `Berserker.kt` (3.0% Berserker's Axe) drop hooks added.
- [ ] 24 crafting recipes registered in `Recipes.kt`.
- [ ] `Utils.typeToPriority` and `Utils.getDefaultWeapon` support `Axe` and `Stick`.
- [ ] Existing unit tests pass (`./gradlew testDebugUnitTest`).
