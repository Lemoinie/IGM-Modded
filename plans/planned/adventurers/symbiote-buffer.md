# Implementation Plan - Symbiote Buffer Class Line (Yuumi-Style Attached Support)

Introduce a new specialized symbiotic support class branch (**Soulbinder $\to$ Spirit Weaver $\to$ Aether Symbiote $\to$ Soul Conduit $\to$ Ascendant Familiar $\to$ Cosmic Luminary $\to$ Eternal Bondsmith**) inspired by the "attached enchanter" archetype (such as Yuumi from League of Legends). 

The class bonds with an ally in combat, transferring incoming damage directly to the host while empowering that host with shared stats, targeted healing, warding shields, and damage amplification.

---

## 1. Goal & Design Philosophy

- **The Problem with Traditional Buffers**: Standard backline enchanters are often squishy targets prone to being picked off by backline-targeting assassins, AoE cleaves, or unlucky random targeting before they can get their buffs rolling.
- **The Symbiote Fantasy**: 
  - The Symbiote attaches to a host ally at the start of battle.
  - While bonded, incoming attacks directed at the Symbiote are **redirected to the host**, who absorbs the blows using their own armor, shields, and defenses.
  - The Symbiote is immune to standard single-target burst, but **lives and dies by their host**: if the host is overwhelmed and falls, the Symbiote is exposed and fragile.
  - In exchange for sacrificing their own direct offensive actions, the Symbiote dramatically supercharges their host's combat stats, mana generation, and damage output.

---

## 2. User Review Required

> [!IMPORTANT]
> **Key Design Choices for User Confirmation**:
> 1. **Class Tree Placement**:
>    - **Option A (Recommended)**: Branch from **Cleric (Tier 2)** as an alternative to White Mage at Tier 3 (`Soulbinder`).
>    - **Option B**: Branch from **Apprentice (Tier 1)** directly as a parallel specialized magic/support branch (`Initiate of the Bond`).
> 2. **AoE Handling**:
>    - **Option A (Recommended - True Invulnerability)**: When an enemy casts a multi-target or party-wide AoE attack, the Symbiote takes **0 damage** while attached. The host takes only their own normal AoE damage (the host is not penalized with double-damage).
>    - **Option B (Damage Redirection)**: The host takes their own AoE hit *plus* the redirected AoE hit from the Symbiote.
> 3. **Host Death & Re-attachment**:
>    - **Option A (Dynamic Re-bonding - Recommended)**: If the host dies, the Symbiote immediately searches for the next highest-threat living ally and bonds to them. Only if the entire team is wiped does the Symbiote become exposed alone.
>    - **Option B (Exposed on Death)**: If the host dies, the Symbiote is unbonded and vulnerable for the rest of that wave/chamber, unable to re-attach until the next battle.
> 4. **Host Selection Priority**:
>    - **Option A (Recommended - Tank Anchor)**: Automatically bonds to the ally with the **highest Threat** (usually the team's frontline tank).
>    - **Option B (Formation Anchor)**: Automatically bonds to the ally in **Slot 1** (frontmost unit).
>    - **Option C (Carry Anchor)**: Automatically bonds to the ally with the **highest Attack Damage** (hyper-carry buffer).

---

## 3. Class Progression & Evolution Tree (Tiers 3 – 9)

| Tier | Class Name | Base Stats (HP / CON / INT / DEX) | Weapon / Armor | Core Role & Identity |
| :--- | :--- | :--- | :--- | :--- |
| **T3** (Lv 25) | **Soulbinder** | 45 / 6 / 32 / 8 | Staff / Light Armor | Unlocks *Symbiotic Bond* (15% stat transfer) & basic single-target damage redirection. |
| **T4** (Lv 40) | **Spirit Weaver** | 65 / 10 / 46 / 12 | Staff / Light Armor | *Active: Spirit Ward* (grants host temporary shield + cleanses 1 negative condition). 20% stat transfer. |
| **T5** (Lv 55) | **Aether Symbiote** | 90 / 14 / 62 / 16 | Staff / Light Armor | *Passive: Aetheric Link* (+1 MP regen/turn to host, +15% host damage amp). 25% stat transfer. |
| **T6** (Lv 70) | **Soul Conduit** | 120 / 18 / 80 / 20 | Staff / Light Armor | *Active: Astral Surge* (heals host for 30% Max HP + grants Frenzy for 2 turns). 30% stat transfer. |
| **T7** (Lv 85) | **Ascendant Familiar** | 160 / 24 / 100 / 24 | Staff / Light Armor | *Passive: Resonant Aura* (Host gains +15% lifesteal; 35% stat transfer). |
| **T8** (Lv 100) | **Cosmic Luminary** | 210 / 30 / 125 / 30 | Staff / Light Armor | *Passive: Celestial Bastion* (40% stat transfer; host takes 15% less damage from all sources). |
| **T9** (Lv 115) | **Eternal Bondsmith** | 270 / 38 / 155 / 36 | Staff / Light Armor | *Active: Soul Transcendence* (45% stat transfer; once per battle prevents a lethal blow on host, restoring host to 30% HP). |

---

## 4. Detailed Combat Mechanics

### 4.1 Host Bonding (`getBondedHost`)
At the start of combat, the Symbiote evaluates the party:
1. Filters `adventurersExploring` for living allies (`it !== this && it.currentHp > 0`).
2. Sorts candidates by `getThreat()` descending, breaking ties by lowest slot index.
3. Sets `bondedHost = candidate`.
4. If no living allies exist, `bondedHost = null` (detached state).

### 4.2 Damage Redirection in `Area.dealDamage`
When `dealDamage(entity, entity2, skill, endOfTurnAction)` is called:
```kotlin
// Check if the target is an attached symbiote
val symbiote = entity2 as? Adventurer
val host = if (symbiote != null && isSymbioteClass(symbiote)) getBondedHost(symbiote) else null

if (symbiote != null && host != null && host.currentHp > 0) {
    if (isAoeAttack(skill)) {
        // AoE immunity while attached: Symbiote ignores AoE cleaves
        Logger.log(this, Logger.SYMBIOTE_AOE_EVADED, symbiote, host)
        return
    } else {
        // Single-target attack redirected to host
        Logger.log(this, Logger.SYMBIOTE_DAMAGE_REDIRECTED, symbiote, host)
        dealDamage(entity, host, skill, endOfTurnAction)
        return
    }
}
```
* **Host Mitigation**: The attack redirected to `host` goes through `host.applyDamage(...)`, meaning the host's Constitution DR, armor, defense, magic defense, shields, and passive damage reductions properly mitigate the hit.
* **Detached Vulnerability**: If `host == null` (all other allies dead), `dealDamage` executes normally against the Symbiote, dealing full unmitigated damage to their fragile HP pool.

### 4.3 Stat Sharing Mechanics ("You and Me!")
While bonded, the Symbiote passively transfers a percentage of their gear and base stats to the host:
- **Shared Intelligence**: Host gains $+ (Symbiote.calculateTotalIntelligence() \times StatSharePct)$ as bonus flat damage and healing amplification.
- **Shared Constitution**: Host gains $+ (Symbiote.calculateTotalConstitution() \times StatSharePct \times 5)$ as bonus Max HP / Shield pool.
- Computed dynamically during combat stat evaluations or applied as an ongoing passive status effect: `StatusEffectType.SYMBIOTIC_BOND`.

### 4.4 Turn Actions (Dedicated Support Rotation)
The Symbiote's turn actions replace basic attacks:
- **Basic Turn**: Channels a healing pulse / mana transfer into the host (scales with Symbiote INT).
- **Skill Cast (Spirit Ward / Astral Surge / Soul Transcendence)**:
  - Cleanses negative status effects on the host.
  - Grants defensive barriers / shields.
  - Amplifies host's next attack with holy or aetheric damage.

---

## 5. Architecture & Implementation Steps

### 5.1 Unit Classes (`storage/data/entities/adventurers/units/`)
- Create 7 new class files:
  - [`Soulbinder.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/units/Soulbinder.kt) (T3)
  - [`SpiritWeaver.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/units/SpiritWeaver.kt) (T4)
  - [`AetherSymbiote.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/units/AetherSymbiote.kt) (T5)
  - [`SoulConduit.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/units/SoulConduit.kt) (T6)
  - [`AscendantFamiliar.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/units/AscendantFamiliar.kt) (T7)
  - [`CosmicLuminary.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/units/CosmicLuminary.kt) (T8)
  - [`EternalBondsmith.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/units/EternalBondsmith.kt) (T9)
- Update [`Cleric.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/adventurers/units/Cleric.kt):
  ```kotlin
  nextClasses.add("WhiteMage")
  nextClasses.add("Soulbinder")
  ```

### 5.2 Skills & Status Effects
- Add new skills in [`Skills.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/Skills.kt):
  - `PASSIVE_SYMBIOTIC_BOND_I` through `PASSIVE_SYMBIOTIC_BOND_VII`
  - `ACTIVE_SPIRIT_WARD`, `ACTIVE_ASTRAL_SURGE`, `ACTIVE_SOUL_TRANSCENDENCE`
- Add status effect in [`StatusEffectType.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/StatusEffectType.kt):
  - `SYMBIOTIC_BOND` (tracks host connection and stat bonuses).

### 5.3 Combat Engine Updates in [`Area.kt`](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt)
- Add helper methods:
  - `fun getBondedHost(adventurer: Adventurer): Adventurer?`
  - `fun isSymbiote(adventurer: Adventurer): Boolean`
  - `fun getSymbioteStatSharePct(passiveSkill: Skills?): Double`
- In `dealDamage(...)`:
  - Intercept single-target incoming damage targeting an attached Symbiote and forward to `host`.
  - Negate AoE damage for attached Symbiote so the host is not double-punished.
- In turn action resolution:
  - If actor is an attached Symbiote, direct action supports `host` rather than attacking enemies.

### 5.4 Strings & Localization
- Add class names, descriptions, skill names, and combat log entries in `app/src/main/res/values/strings.xml`.

---

## 6. Verification & Testing

1. **Unit Tests (`app/src/test/kotlin/.../ModFeaturesTest.kt`)**:
   - Verify `Cleric` evolution options include both `WhiteMage` and `Soulbinder`.
   - Verify `getBondedHost()` correctly picks the highest-threat living ally.
   - Verify single-target damage to Symbiote is redirected to the host.
   - Verify host mitigates redirected damage using host's own defense values.
   - Verify AoE damage does not hit the attached Symbiote.
   - Verify Symbiote becomes vulnerable when all allies are dead.
   - Verify stat-share calculations scale correctly from T3 (15%) to T9 (45%).
2. **Build Validation**:
   - Run `./gradlew test` to ensure clean build with zero regressions.
