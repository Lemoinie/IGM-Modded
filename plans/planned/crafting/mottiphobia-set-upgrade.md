# Implementation Plan: Mottiphobia Set Endgame Upgrade (The Hivemother's Regalia)

## Goal Description
Upgrade the **Mottiphobia Set** into an endgame (T8/T9) powerhouse by introducing evolved craftable versions of all three set pieces:
1. **Weapon**: [Mottiphobia](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/instances/Mottiphobia.kt) $\rightarrow$ **Hivemother's Fang** (`HivemothersFang`)
2. **Armor**: [BeastmasterJacket](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/instances/BeastmasterJacket.kt) $\rightarrow$ **Apex Beastmaster Jacket** (`ApexBeastmasterJacket`)
3. **Accessory**: [ArchaicAmulet](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/instances/ArchaicAmulet.kt) $\rightarrow$ **Primal Archaic Talisman** (`PrimalArchaicTalisman`)

The upgraded dagger implements all five requested combat enhancements:
- **Higher HP Scaling**: $1.5\times$ Current HP (up from $1.0\times$).
- **Multi-Target / Multi-Hit**: Strikes twice per turn (`endOfTurnActionRepeats = 2`), acquiring targets dynamically.
- **Armor Penetration**: Swarm ignores $50\%$ of target physical defense.
- **Vampiric Leech**: Restores HP equal to $25\%$ of swarm damage dealt, sustaining the user's HP pool.
- **Status Affliction**: Inflicts 15 turns of Bleed (`StatusEffectType.BLEED`) on every hit.

---

## 1. Item Specifications & Crafting Recipes

### 1.1 Weapon: Hivemother's Fang (`HivemothersFang`)
- **Base Item**: [Dagger](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/Dagger.kt)
- **Stats**:
  - `maxHp = 120` (up from +25)
  - `dexterity = 30` (up from +10)
  - `endOfTurnAction = EndOfTurnAction.EXTRA_ATTACK_HIVEMOTHER_SWARM`
  - `endOfTurnActionRepeats = 2` (triggers twice per turn)
  - `price = 18500L`
- **In-Game Text**:
  - *Name*: Hivemother's Fang
  - *Description*: "An ancient dagger pulsing with the essence of a dream-queen. Her ravenous children swarm out twice each turn, ravaging foes for 150% HP, piercing 50% armor, inflicting bleed, and siphoning life back to the wielder."
  - *Effect*: Extra attack x2 (150% HP dmg, 50% armor pen, leech, bleed)
- **Crafting Recipe** in [`Recipes.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/Recipes.kt):
  - `Mottiphobia x1`
  - `DreamwroughtLarva x35`
  - `AncestralBlood x6`
  - `HeartOfDarkness x4`

---

### 1.2 Armor: Apex Beastmaster Jacket (`ApexBeastmasterJacket`)
- **Base Item**: [MediumArmor](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/MediumArmor.kt)
- **Stats**:
  - `maxHp = 420` (up from +220)
  - `constitution = 20` (up from +10)
  - `dexterity = 25` (up from +10)
  - `defense = 8`
  - `livingCompanionBonusDamage = 80` (**Animal Affinity: 80**, up from 50)
  - `price = 14200L`
- **In-Game Text**:
  - *Name*: Apex Beastmaster Jacket
  - *Description*: "Reinforced with mutant hides and ancient beast sinew. Grants supreme empathy with wild kin, vastly increasing the vigor of the wearer and their swarming companions."
  - *Effect*: Animal Affinity: 80
- **Crafting Recipe** in [`Recipes.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/Recipes.kt):
  - `BeastmasterJacket x1`
  - `MutantHide x20`
  - `DreamwroughtHide x12`
  - `AncestralBlood x4`

---

### 1.3 Accessory: Primal Archaic Talisman (`PrimalArchaicTalisman`)
- **Base Item**: [Accessory](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/Accessory.kt)
- **Stats**:
  - `maxHp = 260` (up from +140)
  - `constitution = 12`
  - `regenerationBonus = 10`
  - `livingCompanionBonusDamage = 60` (**Animal Affinity: 60**, up from 40)
  - `price = 11500L`
- **In-Game Text**:
  - *Name*: Primal Archaic Talisman
  - *Description*: "An age-old talisman vibrating with the primaeval heartbeat of nature. Greatly bolsters living companions while fortifying the bearer's constitution and recovery."
  - *Effect*: Animal Affinity: 60
- **Crafting Recipe** in [`Recipes.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/Recipes.kt):
  - `ArchaicAmulet x1`
  - `FlakeOfInfinity x6`
  - `AncestralBlood x3`
  - `PrehistoricMixture x3`

---

## 2. Combat Mechanics & Mathematical Architecture

### 2.1 Full Set Synergy Overview
When equipped together, the three pieces provide:
- **Total Gear Max HP**: $+120 + 420 + 260 = \mathbf{+800\text{ HP}}$ (plus $+32\text{ CON} = +4$ flat DR).
- **Total Animal Affinity**: $80 + 60 = \mathbf{140\text{ Animal Affinity}}$ $\rightarrow$ $\mathbf{2.40\times\text{ multiplier}}$ ($+140\%$ bonus damage).
- **Swarm Attack Frequency**: **2 strikes per turn** at range.

### 2.2 Mathematical Damage Walkthrough
For an endgame Rogue with **600 base HP** (approx. **$1,400$ total Max HP** with gear):

$$\text{Base Swarm Damage} = \text{Current HP} \times 1.5 = 1,400 \times 1.5 = 2,100$$
$$\text{Animal Affinity Multiplier} = 1.0 + (140 \times 0.01) = 2.40\times$$
$$\text{Pre-Mitigation Raw Damage per Strike} = 2,100 \times 2.40 = \mathbf{5,040\text{ physical damage}}$$

- **Total Output**: $2 \times 5,040 = \mathbf{10,080\text{ raw damage}}$ each turn.
- **Armor Penetration**: Effectively calculates enemy armor as $\text{Defense} \times (1.0 - 0.50)$, preventing late-game tanks from stonewalling the swarm.
- **Vampiric Leech**: Restores $25\% \times \text{Damage Dealt} \approx \mathbf{1,260\text{ HP}}$ per strike, keeping the rogue at $100\%$ HP to maintain maximum damage scaling on subsequent rounds.
- **Bleed Application**: Adds $15$ turns of Bleed on every hit, shredding enemy armor further over prolonged boss encounters.

---

## 3. Code Implementation Details

### 3.1 [`EndOfTurnAction.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/EndOfTurnAction.kt)
Add a new enum entry:
```kotlin
EXTRA_ATTACK_HIVEMOTHER_SWARM(
    shields = false,
    flatDamage = true,
    damage = 0,
    procsOnMelee = null,
    forceRange = true,
    forceMagic = false,
    effect = StatusEffect(StatusEffectType.BLEED, null, 15, 1.0),
    replicatesBasicAttack = false,
    triggersRetaliation = false,
    fromLivingCompanion = true,
    log = R.string.log_hivemother_swarm_attack
)
```

### 3.2 [`Area.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt) Combat Logic
1. **Base Damage Calculation** in `dealDamage`:
   ```kotlin
   if (endOfTurnAction == EndOfTurnAction.EXTRA_ATTACK_HP_TO_DAMAGE) {
       dRollAttackDamage = entity.currentHp.toDouble()
   } else if (endOfTurnAction == EndOfTurnAction.EXTRA_ATTACK_HIVEMOTHER_SWARM) {
       dRollAttackDamage = entity.currentHp.toDouble() * 1.5
   }
   ```
2. **Armor Penetration** in `dealDamage`:
   ```kotlin
   val effectiveArmorIgnored = if (endOfTurnAction == EndOfTurnAction.EXTRA_ATTACK_HIVEMOTHER_SWARM) {
       Math.max(entity.getArmorIgnored(), 0.50)
   } else {
       entity.getArmorIgnored()
   }
   val iApplyDamage = entity2.applyDamage(
       if (aoeProtectors.isEmpty()) rawDamage else rawDamage - aoeInterceptedRaw,
       zIsMagic,
       barrier,
       effectiveArmorIgnored
   )
   ```
3. **Vampiric Leech** in `dealDamage`:
   ```kotlin
   if (endOfTurnAction == EndOfTurnAction.EXTRA_ATTACK_HIVEMOTHER_SWARM && iApplyDamage > 0 && entity.currentHp > 0) {
       val leech = Utils.round(iApplyDamage.toDouble() * 0.25)
       val maxHp = entity.calculateTotalMaxHp()
       val healed = Math.min(maxHp, entity.currentHp + leech) - entity.currentHp
       if (healed > 0) {
           entity.currentHp += healed
           Logger.log(this, Logger.HEAL, entity, healed)
       }
   }
   ```

### 3.3 New Item Classes in `app/src/main/kotlin/.../items/instances/`
- `HivemothersFang.kt` extending `Dagger`
- `ApexBeastmasterJacket.kt` extending `MediumArmor`
- `PrimalArchaicTalisman.kt` extending `Accessory`

### 3.4 Recipes in [`Recipes.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/Recipes.kt)
Add the three recipe enum constants with proper tier-appropriate materials.

### 3.5 String Resources in `strings.xml`
Add item name, description, effect, and combat log string:
- `log_hivemother_swarm_attack`: `"%s's ravenous swarm tore through %s for %s damage."`

---

## 4. Verification & Testing Checklist

- [ ] `./gradlew compileDebugKotlin` succeeds with zero errors.
- [ ] Crafting: All three recipes appear in the Workshop when prerequisites are in storage.
- [ ] End-of-turn execution: Hivemother's Fang fires two separate attacks per turn.
- [ ] Multi-target: If target 1 dies from the first hit, target 2 is selected for the second hit.
- [ ] Armor penetration: Swarm damage against 100 DEF enemy deals significantly higher damage than standard physical attack.
- [ ] Vampiric Leech: When damaged, triggering the swarm restores HP up to max.
- [ ] Bleed: Target receives 15 stacks of Bleed upon taking damage.
- [ ] Animal Affinity scaling: Equipping Apex Beastmaster Jacket (+80) and Primal Archaic Talisman (+60) produces a $2.40\times$ multiplier on raw damage.
