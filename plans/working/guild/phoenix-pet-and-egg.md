# Phoenix & Kitsune Pets, Mythic Pet Type & Mythic Egg

## Goal Description
Introduce a new pet type (**Mythic**), the **Mythic Egg**, and the legendary **Phoenix** pet, while cleanly standardizing the underlying pet architecture to generic species (**Phoenix** and **Kitsune**) with modular display names (**Kiara** and **Senko**). This completely removes the legacy `Semi` joke/inconsistency and cleanly decouples game logic from character presentation.

---

## 1. Clean Architectural Decoupling: Logic vs. Presentation

### The Architectural Philosophy
All game logic, class hierarchies, item drops, abilities, and asset filenames must remain **generic and species-based** (`Phoenix` and `Kitsune`). Character customization (`Kiara` and `Senko`) is strictly confined to the **display layer** (`strings.xml` and replaceable sprites). 

> **Why this matters**: If you ever want to re-theme the pets or revert them to standard generic fantasy beasts, you only need to swap the text in `strings.xml` and the PNGs in `drawable/`—zero Kotlin code, logic, or save-file migrations required!

```
┌────────────────────────────────────────────────────────┐
│                   PRESENTATION LAYER                   │
│  Display Names: "Kiara" & "Senko" (in strings.xml)     │
│  Sprites: pet_phoenix.png & pet_kitsune.png            │
└───────────────────────────▲────────────────────────────┘
                            │ decoupled via R.string / R.drawable
┌───────────────────────────┴────────────────────────────┐
│                    CODE & ENGINE LAYER                 │
│  Classes: Phoenix.kt & Kitsune.kt                      │
│  Type: Mythic.kt                                       │
│  Egg Item: MythicEgg.kt -> listOf("Phoenix", "Kitsune")│
│  Traits: Solar Rebirth & Kitsune Spirit Blessing       │
└────────────────────────────────────────────────────────┘
```

### Complete Removal of `Semi` Inconsistency
- The `Semi` nickname (an old private joke) is **completely removed** from user-facing text, redeem descriptions, and code comments.
- **Redeem Code `Z3GAAZRT`**: Updated to grant `"Kitsune"` (with display name `"Senko"`).
- **100% Backward Compatibility**: In `Pet.getInstance()`:
  ```kotlin
  val resolved = when (str.lowercase()) {
      "senko", "semi", "kitsune" -> "Kitsune"
      else -> str
  }
  ```
  Any older testing save referencing `"Semi"` or `"Senko"` will automatically resolve to `Kitsune` without error.

---

## 2. Art Assets (Verified Ready)

| Asset | Drawable Path | Dimensions | Status |
| :--- | :--- | :---: | :---: |
| **Phoenix / Kiara Sprite** | `res/drawable/pet_phoenix.png` | **64×64** | **Verified Ready** |
| **Kitsune / Senko Sprite** | `res/drawable/pet_kitsune.png` | **64×64** | **Verified Ready** (`pet_senko.png` retained as alias) |
| **Mythic Egg** | `res/drawable/egg_mythic.png` | **32×32** | **Verified Ready** |
| **Solar Rebirth Icon** | `res/drawable/icon_effect_solar_rebirth.png` | **32×32** | **Verified Ready** |

---

## 3. Mythic Pet Type & Mechanics

### Pet Type: `Mythic`
- **Class**: `storage/data/pets/abstractClasses/Mythic.kt` extending `Pet()`.
- **Display String**: `R.string.pet_type_mythic` $\rightarrow$ `"MYTHIC"`.
- **Trait Pool**: Strictly limited to:
  1. `PetAbility.EXPERIENCE`
  2. `PetAbility.DROPS`
  3. `PetAbility.OPPORTUNIST`
  4. `PetAbility.SAVAGE`
- **No Guaranteed / Fixed First Trait**:
  - `guaranteedFirstAbility()` returns `listOf(EXPERIENCE, DROPS, OPPORTUNIST, SAVAGE)`.
  - Slot 1 rolls randomly from this 4-trait pool.
  - Slots 2, 3, and 4 roll from the remaining unpicked traits in this pool.
- **Member Pets**: `Phoenix.kt` and `Kitsune.kt`.

---

### Pet 1: `Phoenix` (Display Name: "Kiara")
- **Class**: `storage/data/pets/instances/Phoenix.kt : Mythic()`
- **TrueClass**: `"Phoenix"`
- **Sprite**: `R.drawable.pet_phoenix` (64×64)
- **Display Strings**:
  - `pet_phoenix_name`: `"Kiara"`
  - `pet_phoenix_description`: `"An immortal phoenix born from eternal flames. With radiant warmth and vibrant spirit, she rises anew each time she falls."`
- **5th Trait: Solar Rebirth**:
  - **Activation**: At the start of each combat turn in `Area.nextTurn()` (when party has a Phoenix companion).
  - **Trigger Chance**: `(p.level * 0.15)%` (e.g. at Lv 50: `7.5%`, at Lv 100: `15%`).
  - **Target Count**: `1 + floor(p.level / 50)` allies (Lv 1–49: 1 ally, Lv 50–99: 2 allies, Lv 100–149: 3 allies, Lv 150+: 4+ allies).
  - **Target Selection**:
    1. Prioritizes fainted allies (`currentHp <= 0`).
    2. If target count remains, selects alive allies who do not currently have `SOLAR_REBIRTH`.
  - **Revive Effect**: If selected ally is fainted, immediately revives them at **1 HP** and applies `SOLAR_REBIRTH` for 1 turn.
    - Combat Log: `"[Ally] was resurrected by Kiara's Solar Rebirth!"`
  - **Death Prevention Effect**: If an alive ally with active `SOLAR_REBIRTH` takes lethal damage in `Area.dealDamage()`:
    - Lethal damage is intercepted, clamping ally's HP to **1 HP**.
    - `SOLAR_REBIRTH` status effect is consumed.
    - Combat Log: `"[Ally] survived lethal damage with 1 HP thanks to Solar Rebirth!"`

---

### Pet 2: `Kitsune` (Display Name: "Senko")
- **Class**: `storage/data/pets/instances/Kitsune.kt : Mythic()` (migrated from legacy `Senko.kt : Wild()`)
- **TrueClass**: `"Kitsune"`
- **Sprite**: `R.drawable.pet_kitsune` (64×64)
- **Display Strings**:
  - `pet_kitsune_name`: `"Senko"`
  - `pet_kitsune_description`: `"A divine celestial kitsune dedicated to nurturing and pampering the guild."`
- **5th Trait: Kitsune Spirit Blessing**:
  - Multiplies healing dealt by party adventurers by `(1 + level * 0.6%)`.
  - Always active, unlocks at level 1.
- **Shop Pack**: `SENKO'S CELESTIAL BOND` (promotional bundle name).

---

## 4. Item: `MythicEgg` & Shop Packs

### 🥚 Item: `MythicEgg`
- **Class**: `storage/data/items/instances/MythicEgg.kt : Egg()`
- **Sprite**: `R.drawable.egg_mythic` (32×32)
- **Display Name**: `item_mythic_egg_name` $\rightarrow$ `"Mythic Egg"`
- **Description**: *"A legendary egg infused with ancient power. It shimmers with otherworldly energy, holding mythical beasts of legend within."*
- **Equal-Chance Hatch Pool**:
  ```kotlin
  override fun hatch(): Pet? {
      val id = Utils.calculateNewPetId()
      val pool = listOf("Phoenix", "Kitsune")
      val chosen = pool[(Utils.random() * pool.size.toDouble()).toInt()]
      return Pet.getInstance(chosen, id)
  }
  ```
  - Exactly 50% chance for Phoenix (Kiara) and 50% chance for Kitsune (Senko).

### 🛒 Shop Companion Bundle Packs
| Bundle Name | Gem Cost | Quantity | Storage Items Added |
| :--- | :---: | :---: | :--- |
| **Mythic Hatchery Cache** | `500 Gems` | 10 Eggs | 10× `MythicEgg` |
| **Mythic Hatchery Bundle** | `1,000 Gems` | 25 Eggs | 25× `MythicEgg` |
| **Mythic Hatchery Treasury** | `2,000 Gems` | 50 Eggs | 50× `MythicEgg` |

---

## Proposed Changes

### Assets
- `pet_phoenix.png`: Verified at 64×64.
- `pet_kitsune.png`: Verified at 64×64 (copied from `pet_senko.png`).
- `egg_mythic.png`: Verified at 32×32.
- `icon_effect_solar_rebirth.png`: Verified at 32×32.

---

### Code Changes

#### [NEW] [Mythic.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/pets/abstractClasses/Mythic.kt)
- Base class for Mythic pets extending `Pet()`.
- Implements `guaranteedFirstAbility()` and custom `rollAbility()` restricted to `[EXPERIENCE, DROPS, OPPORTUNIST, SAVAGE]`.
- Implements `printPetType()` returning `R.string.pet_type_mythic`.

#### [NEW] [Kitsune.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/pets/instances/Kitsune.kt)
- Canonical class for Kitsune pet extending `Mythic()`.
- Uses `idImage = R.drawable.pet_kitsune`, `idName = R.string.pet_kitsune_name`, `idDescription = R.string.pet_kitsune_description`.
- Replaces legacy `Senko.kt`.

#### [NEW] [Phoenix.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/pets/instances/Phoenix.kt)
- Phoenix pet class extending `Mythic()`.
- Uses `idImage = R.drawable.pet_phoenix`, `idName = R.string.pet_phoenix_name`, `idDescription = R.string.pet_phoenix_description`.
- Sets `abilityNumber = 5`.
- Exposes `getSolarRebirthChance(): Double = level * 0.0015`.
- Exposes `getSolarRebirthTargetCount(): Int = 1 + (level / 50)`.

#### [MODIFY] [Pet.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/pets/Pet.kt)
- Update `getInstance()`:
  - Add resolution mapping: `"senko"`, `"semi"`, `"kitsune"` $\rightarrow$ `"Kitsune"`.
  - Support `pet.rollAbility(exclude)` dynamically for class-specific trait pools.

#### [NEW] [MythicEgg.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/instances/MythicEgg.kt)
- Mythic Egg item extending `Egg()`.
- Hatches `["Phoenix", "Kitsune"]` with 50/50 probability.

#### [MODIFY] [RedeemCodes.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/game/redeem/RedeemCodes.kt)
- Update `Z3GAAZRT` description and logic: spawn `Pet.getInstance("Kitsune", ...)` instead of `"Semi"`, and update log message from `"Bloodcrave Semi"` to `"Bloodcrave Senko (Lvl 100) added to the shelter!"`.

#### [MODIFY] [StatusEffectType.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/StatusEffectType.kt)
- Add `SOLAR_REBIRTH` with `R.drawable.icon_effect_solar_rebirth`.

#### [MODIFY] [Area.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt)
- In `Area.nextTurn()`: roll Solar Rebirth chance when exploring with a Phoenix companion.
- In `Area.dealDamage()`: intercept lethal damage when `SOLAR_REBIRTH` is present, clamp to 1 HP, consume effect, and log message.

#### [MODIFY] [DialogPetDetail.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogPetDetail.kt)
- Render Solar Rebirth for Phoenix.
- Standardize Kitsune 5th trait check to `p is Kitsune || p.trueClass in listOf("Kitsune", "Senko", "Semi")`.

#### [MODIFY] [DialogShop.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogShop.kt) & [dialog_shop.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/layout/dialog_shop.xml)
- Update Senko Pack preview to use `Kitsune` instance and `pet_kitsune` drawable.
- Add the 3 Mythic Egg packs (10, 25, 50 eggs) to the Companion Bundle.

#### [MODIFY] [strings.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/values/strings.xml)
- Add `pet_type_mythic` (`"MYTHIC"`).
- Add `pet_phoenix_name` (`"Kiara"`), `pet_phoenix_description`.
- Add `pet_kitsune_name` (`"Senko"`), `pet_kitsune_description` (removing `"Semi"`).
- Add `item_mythic_egg_name`, `item_mythic_egg_description`.
- Add `status_effect_solar_rebirth`.

---

## Verification Plan

### Automated Tests
- `PhoenixAndKitsuneTest.kt`:
  - Verify `Phoenix` and `Kitsune` inherit from `Mythic`.
  - Verify `Pet.getInstance("Semi")`, `Pet.getInstance("Senko")`, and `Pet.getInstance("Kitsune")` all successfully return a `Kitsune` instance.
  - Verify `pet.getName()` returns `"Kiara"` for Phoenix and `"Senko"` for Kitsune.
  - Verify `Mythic.rollAbility()` only rolls from `[EXPERIENCE, DROPS, OPPORTUNIST, SAVAGE]`.
  - Verify `MythicEgg.hatch()` rolls `Phoenix` and `Kitsune` at 50/50 over 1,000 iterations.
  - Test Solar Rebirth level scaling:
    - Lv 1–49: 1 ally
    - Lv 50–99: 2 allies
    - Lv 100–149: 3 allies
    - Lv 150+: 4+ allies
  - Test Solar Rebirth resurrection at 1 HP and lethal damage interception.
- Run unit test suite:
  ```powershell
  ./gradlew testDebugUnitTest
  ```
