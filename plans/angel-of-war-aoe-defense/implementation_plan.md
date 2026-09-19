# Implementation Plan - Angel of War Branch AoE Row Defense

Add an **AoE Damage Interception & Shared Burden** mechanic to the **Angel of War branch** (Holy Knight $\to$ Paladin $\to$ Templar $\to$ Inquisitor $\to$ Justiciar $\to$ Angel of War). When an enemy performs an AoE attack, alive Angel of War branch units in the **same row** intercept $[n]\%$ of that damage for their allies. If multiple protectors are in the same row, they use the highest protection rate and **split the intercepted burden equally**, preventing fragile allies from being one-shot and ensuring frontline tanks survive the onslaught together.

---

## User Review Required

> [!IMPORTANT]
> **Interception Scaling Across Tiers**:
> - **Tier 4 (Holy Knight)**: **10%** AoE damage intercepted
> - **Tier 5 (Paladin)**: **15%** AoE damage intercepted
> - **Tier 6 (Templar)**: **20%** AoE damage intercepted
> - **Tier 7 (Inquisitor)**: **25%** AoE damage intercepted
> - **Tier 8 (Justiciar)**: **30%** AoE damage intercepted
> - **Tier 9 (Angel of War)**: **35%** AoE damage intercepted

> [!NOTE]
> **Shared Burden Mechanics (Multi-Protector Synergy)**:
> - **Highest Tier Sets the Shield**: When an ally is attacked, we take the highest interception rate among living protectors in the row (e.g. if an Angel of War [35%] and an Inquisitor [25%] are present, the protection rate is **35%**).
> - **Equal Split**: The 35% intercepted damage is split evenly among the living protectors in that row (e.g. 17.5% each for 2 protectors).
> - **Pre-Mitigation Raw Damage**: The intercepted damage is mitigated by each protector's own DEF, MDEF, Constitution flat damage reduction, Radiant Blessing flat DR, and holy shields via `guard.applyDamage(...)`.
> - **Cross-Protection**: Because `guard !== ally`, an Angel of War does not protect itself, but a second Angel of War in the same row **will** cross-protect it, giving both tanks 35% reduction on their own hits!

---

## Architecture & Combat Logic

### 1. Same-Row Identification
Slots in Idle Guild Master are arranged in 5-unit rows:
- **Row 0**: Slots 1..5 (`adventurersExploring[0..4]`)
- **Row 1**: Slots 6..10 (`adventurersExploring[5..9]`)
- **Row 2**: Slots 11..15 (`adventurersExploring[10..14]`)

Row index formula:
$$\text{rowIndex} = \lfloor \text{slotIndex} / 5 \rfloor$$

### 2. AoE Attack Detection
An enemy attack is identified as an AoE attack when:
- Attacker is an `Enemy` (`entity is Enemy`).
- Target is an `Adventurer` (`entity2 is Adventurer`).
- Active skill is cast (`skill != null && !skill.healing`) with multi-target selection:
  - `skill.targetSelectionMode in listOf(TARGET_ALL, TARGET_ALL_ENEMIES, TARGET_ALL_EXCEPT_SELF)`
  - OR `(skill.targetSelectionMode.toIntOrNull() ?: 1) > 1` (e.g. Barrage hitting 2+ targets).

### 3. Shared Burden Execution in `Area.dealDamage`
```kotlin
if (isAoe && !z4 && z5) {
    val allyIndex = this.adventurersExploring.indexOf(entity2)
    if (allyIndex >= 0) {
        val allyRow = allyIndex / 5
        val protectors = this.adventurersExploring.asSequence()
            .filterIsInstance<Adventurer>()
            .filter { it.currentHp > 0 && it !== entity2 && (this.adventurersExploring.indexOf(it) / 5) == allyRow }
            .filter { getAoeDamageInterceptionPct(it.passiveSkill) > 0.0 }
            .toList()

        if (protectors.isNotEmpty()) {
            val maxPct = protectors.maxOf { getAoeDamageInterceptionPct(it.passiveSkill) }
            val totalInterceptedRaw = rawDamage * maxPct
            allyRawDamage = rawDamage - totalInterceptedRaw

            val perGuardRaw = totalInterceptedRaw / protectors.size
            for (guard in protectors) {
                val guardBarrier = if (pet != null) pet.barrier else 0
                val iGuardDmg = guard.applyDamage(
                    perGuardRaw,
                    zIsMagic,
                    guardBarrier,
                    entity.getArmorIgnored()
                )
                animateDamage(guard)
                Logger.log(this, Logger.AOE_DAMAGE_INTERCEPTED, guard, entity2, iGuardDmg)
                checkDeath(guard)
            }
        }
    }
}
```

---

## Proposed Changes

### Core Engine & Combat

#### [MODIFY] [Area.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt)
- Add helper `getAoeDamageInterceptionPct(passiveSkill: Skills?): Double`:
  - `PASSIVE_AURA_OF_LIGHT_I` $\to$ 0.10
  - `PASSIVE_AURA_OF_LIGHT_II` $\to$ 0.15
  - `PASSIVE_AURA_OF_DEVOTION_I` $\to$ 0.20
  - `PASSIVE_AURA_OF_DEVOTION_II` $\to$ 0.25
  - `PASSIVE_AURA_OF_SANCTITY` $\to$ 0.30
  - `PASSIVE_AURA_OF_THE_SERAPHIM` $\to$ 0.35
- Add helper `isAoeAttack(skill: Skill?): Boolean`.
- In `dealDamage(...)`:
  - Calculate `rawDamage` before `applyDamage`.
  - When an enemy performs an AoE attack against an adventurer, locate all alive protectors in the same row.
  - Compute `maxPct` and split `totalInterceptedRaw` evenly across all living protectors in the row.
  - Apply each slice to each protector via `guard.applyDamage(...)`, trigger `animateDamage(guard)`, check protector death via `checkDeath(guard)`.
  - Apply remaining damage to the target ally via `entity2.applyDamage(...)`.
  - Log each protector's intercepted damage using `Logger.AOE_DAMAGE_INTERCEPTED`.

---

### Combat Logging & UI

#### [MODIFY] [Logger.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Logger.kt)
- Add `const val AOE_DAMAGE_INTERCEPTED = 126`.
- Add case handler in `log(...)` formatting:
  - Protector name in GREEN
  - Intercepted damage in RED
  - Protected ally name in GREEN

#### [MODIFY] [strings.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/values/strings.xml)
- Add `<string name="log_aoe_damage_intercepted" formatted="false">%s intercepted %s damage for %s.</string>`.
- Update passive descriptions (`passive_aura_of_light_i_description` through `passive_aura_of_the_seraphim_description`) to document the AoE damage interception percentage for same-row allies.

---

### Tests & Documentation

#### [MODIFY] [ModFeaturesTest.kt](file:///c:/Repositories/IGM-Modded/app/src/test/kotlin/it/paranoidsquirrels/idleguildmaster/ModFeaturesTest.kt)
- Add unit tests verifying:
  1. **Single Protector (1 AoW, 1 Ally)**: 35% raw damage intercepted by AoW.
  2. **Shared Burden (2 AoWs, 1 Ally)**: 35% total intercepted, split evenly (17.5% raw damage to each AoW).
  3. **Tier Priority (1 AoW [35%], 1 Inquisitor [25%])**: 35% rate used, split evenly (17.5% raw damage to each).
  4. **Row Isolation**: AoW in Row 0 does **not** intercept damage for an ally in Row 1.
  5. **Cross-Protection**: AoW #1 is protected by AoW #2 in the same row, but does not protect itself.
  6. **Protector Death Handling**: If a protector dies during an AoE burst, remaining alive protectors handle subsequent hits.

#### [MODIFY] [docs/vanilla-behavior.md](file:///c:/Repositories/IGM-Modded/docs/vanilla-behavior.md)
- Document the AoE row defense and Shared Burden mechanics under the Angel of War branch documentation.

---

## Verification Plan

### Automated Tests
- Run Gradle unit tests via powershell:
  `./gradlew testDebugUnitTest --tests "it.paranoidsquirrels.idleguildmaster.ModFeaturesTest"`
- Verify all existing (68+) and new tests pass.

### Manual / Combat Log Verification
- Inspect combat logs during an enemy AoE skill (e.g. `STOMP`):
  - Confirm logs output:
    `"[Enemy] dealt [X] damage to [Ally]."`
    `"[Angel of War] intercepted [Y] damage for [Ally]."`
  - For 2 Angels of War, verify that both display interception logs with their half-share.
