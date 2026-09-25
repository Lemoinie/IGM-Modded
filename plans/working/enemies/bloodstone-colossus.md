# Implementation Plan: Bloodstone Colossus & Sanguine Crucible Encounter Tuning

## Feature Overview
Introduce **Bloodstone Colossus**, a high-threat frontline construct, to **The Sanguine Crucible** raid. Update pre-boss corridor encounter waves so that each combat wave rolls 50% to be entirely Bloodstone Colossuses and 50% to be entirely Crimson Acolytes, then rolls the enemy count (1–5 enemies). Update Archmagus Valthex's `Blood Convocation` summon mechanic to roll a 60% chance for Bloodstone Colossus and a 40% chance for Crimson Acolyte. Additionally, implement the **Scarlet Debris** material item dropped exclusively by the Colossus at a 1% rate, and update the **Scarlet Oni Juggernaut** crafting recipe in `Recipes.kt` to require **5 Scarlet Debris** instead of 10 Heart of Darkness.

---

## 1. Design & Specifications

### 1.1 New Unit: Bloodstone Colossus
- **Role**: Tank minion with high threat and heavy durability designed to peel attacks away from fragile glass-cannon Crimson Acolytes and Archmagus Valthex.
- **Class**: `BloodstoneColossus` (`app/src/main/kotlin/.../enemies/units/BloodstoneColossus.kt`) inheriting from `Enemy()`.
- **Drawable Sprite**: `R.drawable.bloodstone_colossus` (existing at `app/src/main/res/drawable/bloodstone_colossus.png`).
- **Enemy Type**: `EnemyType.CONSTRUCT` registered in `EnemyTypeRegistry.kt`.
- **Combat Stats**:
  - `threat = 8` (High threat: Crimson Acolyte has threat 4, Archmagus Valthex has threat 1; adventurers using `weightedSelection` target the Colossus with 8× weight vs Valthex and 2× vs Acolyte).
  - `baseMaxHp = 12,000` (Tank pool; compare with Crimson Acolyte's 3,000 HP).
  - `baseConstitution = 120`.
  - `baseDexterity = 30` (Slow construct).
  - `baseIntelligence = 10`.
  - `baseDefense = 80` (Heavy physical defense).
  - `baseMagicDefense = 40` (Moderate magic resistance).
  - `isMagic(): Boolean = false`, `isRanged(): Boolean = false` (Physical melee strikes).
  - `getMinDamage(): Int = 120`, `getMaxDamage(): Int = 180`.
  - `rarity = 1`, `expGiven = 3,500`.
  - `statusImmunities`:
    - `StatusEffectType.ABLAZE` & `StatusEffectType.BLOODFLAME` (standard Crucible immunity).
    - `StatusEffectType.BLEED` & `StatusEffectType.POISON` (inorganic construct property).
  - `passiveSkill`: `Skills.PASSIVE_THREATENING_IV` (displays Threatening IV in entity details sheet).
  - `activeSkill`: `Skills.ACTIVE_NONE`.
- **Drop Table**:
  - `ScarletDebris` (1% chance, 1 count).
  - Displayed in `listDrops()` for the Bestiary/inspection modal and rolled independently via `rollDrops()`:
    ```kotlin
    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val map = LinkedHashMap<ItemWrapper, Int>()
        map.put(ItemWrapper.getInstance("ScarletDebris", 1), 1000)
        return map
    }

    override fun rollDrops(evKey: Int): List<ItemWrapper> {
        val rolled = ArrayList<ItemWrapper>()
        if (Utils.random() < 0.01) rolled.add(ItemWrapper.getInstance("ScarletDebris", 1))
        return rolled
    }
    ```

### 1.2 New Item: Scarlet Debris
- **Class**: `ScarletDebris` (`app/src/main/kotlin/.../items/instances/ScarletDebris.kt`) inheriting from `Item()`.
- **Drawable Sprite**: `R.drawable.scarlet_debris` (existing at `app/src/main/res/drawable/scarlet_debris.png`).
- **Properties**:
  - `idName = R.string.item_scarlet_debris_name` ("Scarlet Debris").
  - `idDescription = R.string.item_scarlet_debris_description` ("Crystalline shards sheared from a Bloodstone Colossus. Pulsing with violent, coagulated energy.").
  - `idImage = R.drawable.scarlet_debris`.
  - `price = 2,500L` (endgame material value).
- **Utility / Crafting**:
  - Serves as the key endgame craft component for **Scarlet Oni Juggernaut** (5× `ScarletDebris`).
- **Seen Items Registration**:
  - Add `"ScarletDebris"` to `Data.seenItems` in `Data.kt` initialization so it is recorded in the player's item codex.

### 1.3 Pre-Boss Corridor Wave Spawning (`SanguineCrucible.kt`)
- **Location**: `SanguineCrucible.rollEnemies()`.
- **Current Behavior**: 80% combat chamber generates 1–5 enemies, all hardcoded to `CrimsonAcolyte`.
- **New Behavior**:
  - Roll 50% for enemy type:
    - 50% chance: `BloodstoneColossus`
    - 50% chance: `CrimsonAcolyte`
  - Roll enemy count: `val count = 1 + (Utils.random() * 5).toInt()` (1 to 5).
  - Spawn `count` enemies of the chosen type, ensuring the wave is purely Colossuses or purely Acolytes.
  - Code:
    ```kotlin
    if (Utils.random() < 0.8) {
        val enemyName = if (Utils.random() < 0.5) "BloodstoneColossus" else "CrimsonAcolyte"
        val count = 1 + (Utils.random() * 5).toInt()
        val wave = CopyOnWriteArrayList<Enemy>()
        for (i in 0 until count) {
            Enemy.getInstance(enemyName)?.let { wave.add(it) }
        }
        Logger.log(this, Logger.EVENT_HARMFUL, R.string.log_sanguine_crucible_combat_chamber)
        return wave
    }
    ```
- **Area Enemy Listing**:
  - Update `SanguineCrucible.listEnemies()` to include `BloodstoneColossus` alongside `CrimsonAcolyte` and `ArchmagusValthex`.

### 1.4 Archmagus Valthex Passive Summon Tuning (`Area.kt` & `Logger.kt`)
- **Location**: `Area.kt` (lines 2721–2733, `BLOOD_CONVOCATION` block in `dealDamage()`).
- **Current Behavior**: Whenever Archmagus Valthex takes damage, 36% chance (`BLOOD_CONVOCATION_SUMMON_CHANCE`) to summon a `CrimsonAcolyte`.
- **New Behavior**:
  - When summon triggers and formation has room (`enemies.size < 5`):
    - Roll 60% for `BloodstoneColossus` and 40% for `CrimsonAcolyte`:
      ```kotlin
      val minionClass = if (Utils.random() < 0.6) "BloodstoneColossus" else "CrimsonAcolyte"
      val minion = Enemy.getInstance(minionClass)
      if (minion != null) {
          this.enemies.add(minion)
          this.fightingGroup.add(minion)
          Logger.log(this, Logger.BLOOD_CONVOCATION, entity2, minion)
      }
      ```
- **Battle Log Update (`Logger.kt`)**:
  - Update `BLOOD_CONVOCATION` handler in `Logger.kt` to extract the minion entity (if provided as `objArr[1]`) and interpolate the summoned unit's name:
    ```kotlin
    BLOOD_CONVOCATION -> {
        val casterConvocation = objArr[0] as Entity
        val minion = if (objArr.size > 1) objArr[1] as? Entity else null
        val minionName = minion?.idName?.let { RESOURCES!!.getString(it) } ?: "minion"
        strWrap = wrap(
            String.format(
                RESOURCES!!.getString(R.string.log_sanguine_convocation),
                RESOURCES!!.getString(casterConvocation.idName),
                minionName
            ),
            getRed()
        )
    }
    ```
- **String Resources (`strings.xml`)**:
  - Update `log_sanguine_convocation`:
    `%1$s summons a %2$s through forbidden blood rites!`
  - Update `passive_blood_convocation_description`:
    `Whenever the Archmagus takes damage, there is a 36% chance to summon a minion (60% Bloodstone Colossus, 40% Crimson Acolyte) while the formation has room.`

### 1.5 Crafting Recipe Update: Scarlet Oni Juggernaut (`Recipes.kt`)
- **Location**: `Recipes.kt` (`Recipes.ScarletOniJuggernaut`).
- **Previous Ingredients**:
  - `ScarletOni` (1)
  - `MysteriousCog` (5)
  - `HeartOfDarkness` (10)
  - `EldritchSeal` (1)
- **New Ingredients**:
  - `ScarletOni` (1)
  - `MysteriousCog` (5)
  - `ScarletDebris` (5) — *Replaces 10 Heart of Darkness*
  - `EldritchSeal` (1)
- **Code**:
  ```kotlin
  ScarletOniJuggernaut(
      Item.getInstance("ScarletOni", 1),
      Item.getInstance("MysteriousCog", 5),
      Item.getInstance("ScarletDebris", 5),
      Item.getInstance("EldritchSeal", 1)
  ),
  ```
- **Unit Test Update (`ModFeaturesTest.kt`)**:
  - Update `testScarletOniJuggernautCraftableAmount()`: replace `Item.getInstance("HeartOfDarkness", 25)` with `Item.getInstance("ScarletDebris", 15)`.

---

## 2. File Change Plan

| File | Type | Changes |
| :--- | :--- | :--- |
| `app/src/main/kotlin/.../enemies/units/BloodstoneColossus.kt` | **NEW** | Create `BloodstoneColossus : Enemy()` with stats, immunities, drops (1% Scarlet Debris), and threat = 8. |
| `app/src/main/kotlin/.../items/instances/ScarletDebris.kt` | **NEW** | Create `ScarletDebris : Item()` configuring properties, name, description, and price. |
| `app/src/main/kotlin/.../enemies/EnemyTypeRegistry.kt` | **MODIFY** | Register `"BloodstoneColossus" to EnemyType.CONSTRUCT`. |
| `app/src/main/kotlin/.../places/raids/SanguineCrucible.kt` | **MODIFY** | Update `rollEnemies()` to roll 50% full Colossus wave / 50% full Acolyte wave, then roll 1–5 count of that unit; add `BloodstoneColossus` to `listEnemies()`. |
| `app/src/main/kotlin/.../places/Area.kt` | **MODIFY** | Update `BLOOD_CONVOCATION` trigger to roll 60% `BloodstoneColossus` / 40% `CrimsonAcolyte`, passing the spawned minion to `Logger.log`. |
| `app/src/main/kotlin/.../places/Logger.kt` | **MODIFY** | Support dynamic minion name interpolation in `BLOOD_CONVOCATION` event formatting. |
| `app/src/main/kotlin/.../items/Recipes.kt` | **MODIFY** | Update `ScarletOniJuggernaut` recipe: replace 10 `HeartOfDarkness` with 5 `ScarletDebris`. |
| `app/src/test/kotlin/.../ModFeaturesTest.kt` | **MODIFY** | Update `testScarletOniJuggernautCraftableAmount()` to test with `ScarletDebris` instead of `HeartOfDarkness`. |
| `app/src/main/kotlin/.../storage/data/Data.kt` | **MODIFY** | Add `"ScarletDebris"` to `seenItems`. |
| `app/src/main/res/values/strings.xml` | **MODIFY** | Add strings for Bloodstone Colossus, Scarlet Debris; update `log_sanguine_convocation` and `passive_blood_convocation_description`. |
| `app/src/main/kotlin/.../ui/dialogs/changelog/ModChangelogActive.kt` | **MODIFY** | Document additions, recipe change, and encounter adjustments in the active changelog. |
| `docs/vanilla-behavior.md` | **MODIFY** | Document Bloodstone Colossus, Scarlet Debris, recipe update, and Sanguine Crucible wave/summon mechanics. |

---

## 3. Step-by-Step Implementation Flow

1. **Step 1: String Resources**
   - Add name and description for `BloodstoneColossus` and `ScarletDebris` to `strings.xml`.
   - Update `log_sanguine_convocation` to support two format arguments (`%1$s` caster, `%2$s` minion).
   - Update `passive_blood_convocation_description` to reflect the 60/40 summon split.

2. **Step 2: Create Item `ScarletDebris.kt`**
   - Place under `app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/instances/`.
   - Set `idImage = R.drawable.scarlet_debris`, `price = 2500L`.
   - Add `"ScarletDebris"` to `seenItems` in `Data.kt`.

3. **Step 3: Create Unit `BloodstoneColossus.kt`**
   - Place under `app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/units/`.
   - Configure stats: `baseMaxHp = 12000`, `baseDefense = 80`, `baseMagicDefense = 40`, `threat = 8`, `expGiven = 3500`.
   - Implement `listDrops()` and `rollDrops()` with 1% `ScarletDebris`.
   - Set status immunities (`ABLAZE`, `BLOODFLAME`, `BLEED`, `POISON`).

4. **Step 4: Register Enemy Type & Raid Enemy List**
   - In `EnemyTypeRegistry.kt`: map `"BloodstoneColossus"` to `EnemyType.CONSTRUCT`.
   - In `SanguineCrucible.kt`: add `Enemy.getInstance("BloodstoneColossus")` to `listEnemies()`.

5. **Step 5: Corridor Wave Spawning Update**
   - In `SanguineCrucible.kt`: update the combat chamber wave spawner in `rollEnemies()` to first roll 50% between `"BloodstoneColossus"` and `"CrimsonAcolyte"` for the entire wave, then roll the 1–5 count and fill the wave with that chosen unit type.

6. **Step 6: Archmagus Valthex Passive Summon Tuning**
   - In `Area.kt`: in the `Skills.PASSIVE_BLOOD_CONVOCATION` block, roll 60% `"BloodstoneColossus"` and 40% `"CrimsonAcolyte"`, and pass the created enemy instance to `Logger.log()`.
   - In `Logger.kt`: read `objArr[1]` as the summoned Entity to resolve and display its name.

7. **Step 7: Update Scarlet Oni Juggernaut Recipe & Test**
   - In `Recipes.kt`: update `ScarletOniJuggernaut` enum to use `Item.getInstance("ScarletDebris", 5)` instead of `Item.getInstance("HeartOfDarkness", 10)`.
   - In `ModFeaturesTest.kt`: update `testScarletOniJuggernautCraftableAmount()` to supply `ScarletDebris`.

8. **Step 8: Changelog & Documentation**
   - Append an entry to `ModChangelogActive.kt`.
   - Update `docs/vanilla-behavior.md` with the new enemy stats, recipe, and wave formulas.

---

## 4. Verification Plan

### Automated / Build Verification
- Run Gradle compilation: `./gradlew compileDebugSources` or `.\scripts\build\build.ps1 -SkipInstall -SkipDeploy`.
- Ensure zero unresolved references or resource ID mismatches.

### Logic & Statistical Verification
- Test `Enemy.getInstance("BloodstoneColossus")` returns non-null instance with expected stats (`threat == 8`, `baseMaxHp == 12000`).
- Test `Item.getInstance("ScarletDebris")` returns non-null instance with correct drawable and price.
- Test `Recipes.into(Item.getInstance("ScarletOniJuggernaut", 1))` requires 5 `ScarletDebris` and does NOT contain `HeartOfDarkness`.
- Run unit test `testScarletOniJuggernautCraftableAmount()` to verify crafting bottleneck scaling.
- Simulate 10,000 corridor waves: assert that ~50% of waves consist purely of `BloodstoneColossus` (size 1–5) and ~50% consist purely of `CrimsonAcolyte` (size 1–5), with no mixed waves.
- Simulate 10,000 summons from Valthex's passive: assert that ratio is ~60% Colossus / 40% Acolyte ± 1.5%.
- Simulate 10,000 drop rolls for `BloodstoneColossus`: assert that Scarlet Debris drops at ~1.0% ± 0.3%.

### Manual / In-Game Verification
- Launch game and inspect The Sanguine Crucible raid card / preview:
  - Verify `BloodstoneColossus` appears in the preview list.
  - Tap `BloodstoneColossus` in the preview / bestiary: verify portrait (`bloodstone_colossus.png`), stats, `Threatening IV` passive badge, and `Scarlet Debris` in the drop list.
  - Tap `Scarlet Debris` icon: verify name, description, and sprite (`scarlet_debris.png`).
- Dispatch a raid team into The Sanguine Crucible:
  - Confirm corridor waves spawn homogeneous packs of 1–5 units of either pure Colossuses or pure Acolytes (never mixed).
  - Observe combat: against Colossus packs, verify heavy physical armor and threat targeting; against Acolyte packs, verify magic burst.
  - Reach boss room: hit Archmagus Valthex until passive triggers; check combat log for summon notification with appropriate unit name ("Archmagus Valthex summons a Bloodstone Colossus through forbidden blood rites!").
