# Phoenix Pet, Mystic Pet Type & Mystic Egg

## Goal Description
Introduce a new pet type (**Mystic**), the **Mystic Egg**, and the legendary **Phoenix** pet, while migrating **Senko** into the Mystic type.

This implementation includes:
1. **Art Resizing & Assets**:
   - Resizing `app/src/main/res/drawable/phoenix.png` (500×500) to **64×64 pixels** (`pet_phoenix.png`) to conform to all existing pet sprites.
   - Using the provided `app/src/main/res/drawable/egg_mystic.png` (already 32×32).
   - Resizing `app/src/main/res/drawable/icon_effect_solar_rebirth.png` (16×16) to **32×32 pixels** to match all status effect icons.
2. **New Pet Type: `Mystic`**:
   - Abstract class `storage/data/pets/abstractClasses/Mystic.kt` extending `Pet()`.
   - Migrating `Senko` from `Wild` to `Mystic`.
   - Dedicated trait pool: strictly `EXPERIENCE`, `DROPS`, `OPPORTUNIST`, `SAVAGE` with no locked first trait (first trait rolls randomly from this pool, and subsequent traits roll from the remaining pool).
3. **New Pet: `Phoenix`**:
   - `storage/data/pets/instances/Phoenix.kt` extending `Mystic()`.
   - 5th Trait: **Solar Rebirth**:
     - Each turn, has a `(level * 0.15)%` chance to bless **`(1 + floor(level / 50))` allies** with a 1-turn `SOLAR_REBIRTH` status effect:
       - **Lv 1–49**: 1 ally
       - **Lv 50–99**: 2 allies
       - **Lv 100–149**: 3 allies
       - **Lv 150+**: 4+ allies
     - **If a blessed ally is fainted**: immediately revives them at **1 HP**!
     - **If a blessed ally is alive**: if they take lethal damage while the buff is active, they survive at **1 HP**.
4. **New Item: `MysticEgg`**:
   - `storage/data/items/instances/MysticEgg.kt` extending `Egg()`.
   - Description: *"A mysterious egg infused with ancient magic. It shimmers with otherworldly energy, hiding untold secrets and mystical power within."*
   - Consuming in Pet Shelter hatches a Mystic pet with equal probability across the Mystic pool (currently 50% Phoenix / 50% Senko, automatically scaling to `1/N` when more Mystic pets are added).
5. **Shop Companion Bundle Egg Packs**:
   - **Mystic Hatchery Cache**: 10 Mystic Eggs for `500 Gems`
   - **Mystic Hatchery Bundle**: 25 Mystic Eggs for `1,000 Gems`
   - **Mystic Hatchery Treasury**: 50 Mystic Eggs for `2,000 Gems`

---

## User Review Required

> [!IMPORTANT]
> ### 1. Asset Specifications & Resizing
> 
> | Asset | Source Path | Source Size | Target Path | Target Size | Format |
> | :--- | :--- | :---: | :--- | :---: | :---: |
> | **Phoenix Sprite** | `res/drawable/phoenix.png` | 500×500 | `res/drawable/pet_phoenix.png` | **64×64** | 32-bit ARGB PNG |
> | **Mystic Egg** | `res/drawable/egg_mystic.png` | 32×32 | `res/drawable/egg_mystic.png` | **32×32** (as-is) | 32-bit ARGB PNG |
> | **Solar Rebirth Icon** | `res/drawable/icon_effect_solar_rebirth.png` | 16×16 | `res/drawable/icon_effect_solar_rebirth.png` | **32×32** | 32-bit ARGB PNG |

---

> [!IMPORTANT]
> ### 2. Mystic Pet Type & Trait Pool
> 
> - **Class**: `storage/data/pets/abstractClasses/Mystic.kt`
> - **Type Name**: `R.string.pet_type_mystic` $\rightarrow$ `"Mystic"`
> - **Trait Pool**: Strictly limited to:
>   1. `PetAbility.EXPERIENCE`
>   2. `PetAbility.DROPS`
>   3. `PetAbility.OPPORTUNIST`
>   4. `PetAbility.SAVAGE`
> - **No Guaranteed / Fixed First Trait**:
>   - `guaranteedFirstAbility()` returns `listOf(PetAbility.EXPERIENCE, PetAbility.DROPS, PetAbility.OPPORTUNIST, PetAbility.SAVAGE)`.
>   - Slot 1 rolls randomly from this 4-trait pool.
>   - Subsequent ability slots (2, 3, 4) roll from the remaining unpicked traits in this pool.
> - **Senko Migration**: `class Senko : Mystic()` replaces `class Senko : Wild()`.

---

> [!IMPORTANT]
> ### 3. Phoenix & Solar Rebirth Mechanics
> 
> - **Class**: `storage/data/pets/instances/Phoenix.kt : Mystic()`
> - **Display Name**: `pet_phoenix_name` $\rightarrow$ `"Phoenix"`
> - **Description**: `pet_phoenix_description` $\rightarrow$ `"A legendary bird of eternal flame. When it falls, it rises anew from its ashes."`
> - **Sprite**: `R.drawable.pet_phoenix` (64×64)
> - **5th Trait: Solar Rebirth**:
>   - **Activation**: At the start of each combat turn in `Area.nextTurn()` (when party has a Phoenix companion).
>   - **Trigger Chance**: `(p.level * 0.15)%` (e.g. at Lv 50: `7.5%`, at Lv 100: `15%`).
>   - **Target Count**: `1 + (p.level / 50)` allies (Lv 1–49: 1 ally, Lv 50–99: 2 allies, Lv 100–149: 3 allies, Lv 150+: 4+ allies).
>   - **Target Selection**:
>     1. Prioritizes fainted allies (`currentHp <= 0`).
>     2. If slots remain, selects alive allies that do not already have `SOLAR_REBIRTH`.
>   - **Revive Effect**: If a selected ally is fainted, immediately revives them at **1 HP** and applies `StatusEffectType.SOLAR_REBIRTH` for 1 turn.
>     - Combat Log: `"[Ally] was resurrected by Phoenix's Solar Rebirth!"`
>   - **Death Prevention Effect**: If an alive ally with active `SOLAR_REBIRTH` takes lethal damage in `Area.dealDamage()`:
>     - Lethal damage is intercepted, clamping ally's HP to **1 HP**.
>     - `SOLAR_REBIRTH` status effect is consumed.
>     - Combat Log: `"[Ally] survived lethal damage with 1 HP thanks to Solar Rebirth!"`

---

> [!IMPORTANT]
> ### 4. Mystic Egg & Equal Chance Hatching
> 
> #### 🥚 Item: `MysticEgg`
> - Class: `storage/data/items/instances/MysticEgg.kt : Egg()`
> - Icon: `R.drawable.egg_mystic` (32×32)
> - Description: *"A mysterious egg infused with ancient magic. It shimmers with otherworldly energy, hiding untold secrets and mystical power within."*
> - **Equal-Chance Hatch Pool**:
>   ```kotlin
>   override fun hatch(): Pet? {
>       val id = Utils.calculateNewPetId()
>       val pool = listOf("Phoenix", "Senko")
>       val chosen = pool[(Utils.random() * pool.size.toDouble()).toInt()]
>       return Pet.getInstance(chosen, id)
>   }
>   ```
>   - Equal 50% chance for Phoenix and Senko (automatically scales to `1/N` when more Mystic pets are added in the future).
> 
> #### 🛒 Shop Companion Bundle Additions
> | Bundle Name | Gem Cost | Quantity | Contents |
> | :--- | :---: | :---: | :--- |
> | **Mystic Hatchery Cache** | `500 Gems` | 10 Eggs | 10× `MysticEgg` added to storage |
> | **Mystic Hatchery Bundle** | `1,000 Gems` | 25 Eggs | 25× `MysticEgg` added to storage |
> | **Mystic Hatchery Treasury** | `2,000 Gems` | 50 Eggs | 50× `MysticEgg` added to storage |

---

## Proposed Changes

### Assets
#### [NEW] [pet_phoenix.png](file:///c:/Repositories/IGM-Modded/app/src/main/res/drawable/pet_phoenix.png)
- Resized 64×64 PNG derived from `res/drawable/phoenix.png`.

#### [MODIFY] [icon_effect_solar_rebirth.png](file:///c:/Repositories/IGM-Modded/app/src/main/res/drawable/icon_effect_solar_rebirth.png)
- Resized 32×32 PNG derived from `res/drawable/icon_effect_solar_rebirth.png`.

---

### Code Changes

#### [NEW] [Mystic.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/pets/abstractClasses/Mystic.kt)
- Base class for Mystic pets:
  - `guaranteedFirstAbility()`: returns `[EXPERIENCE, DROPS, OPPORTUNIST, SAVAGE]`
  - `rollAbility()`: rolls from the remaining traits in `[EXPERIENCE, DROPS, OPPORTUNIST, SAVAGE]`
  - `printPetType()`: returns `R.string.pet_type_mystic`

#### [MODIFY] [Senko.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/pets/instances/Senko.kt)
- Change superclass from `Wild()` to `Mystic()`.

#### [NEW] [Phoenix.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/pets/instances/Phoenix.kt)
- Phoenix pet class extending `Mystic()`.
- Sets `abilityNumber = 5`, `idImage = R.drawable.pet_phoenix`.
- Exposes `getSolarRebirthChance(): Double = level * 0.0015`.
- Exposes `getSolarRebirthTargetCount(): Int = 1 + (level / 50)`.

#### [MODIFY] [Pet.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/pets/Pet.kt)
- Add `open fun rollAbility(exclude: List<PetAbility>): PetAbility = Utils.rollPetAbility(exclude)`.
- Use `pet.rollAbility(...)` in `getInstance()` to respect custom pet pools.

#### [NEW] [MysticEgg.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/instances/MysticEgg.kt)
- Mystic Egg item extending `Egg()`.
- Equal-chance hatching for `["Phoenix", "Senko"]`.
- Sets `idImage = R.drawable.egg_mystic` (32×32).

#### [MODIFY] [StatusEffectType.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/StatusEffectType.kt)
- Add `SOLAR_REBIRTH` with `R.drawable.icon_effect_solar_rebirth`.

#### [MODIFY] [Area.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt)
- In `Area.nextTurn()`: roll `(level * 0.15)%` for Phoenix Solar Rebirth. Select up to `1 + (level / 50)` targets (fainted first, then alive). Revive fainted allies at 1 HP or apply 1-turn buff to alive allies.
- In `Area.dealDamage()`: intercept lethal damage when `SOLAR_REBIRTH` is present, clamp to 1 HP, and consume effect.

#### [MODIFY] [DialogPetDetail.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogPetDetail.kt)
- Render 5th trait **Solar Rebirth** when viewing Phoenix (showing chance %, target count, and description).

#### [MODIFY] [DialogShop.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogShop.kt) & [dialog_shop.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/layout/dialog_shop.xml)
- Add the 3 Mystic Egg packs (10, 25, 50 eggs) to the Companion Bundle.

#### [MODIFY] [strings.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/values/strings.xml)
- Add localized strings for `pet_type_mystic`, `pet_phoenix_name`, `pet_phoenix_description`, `status_effect_solar_rebirth`, and `egg_mystic_name`/`description`.

---

## Verification Plan

### Automated Tests
- `PhoenixPetTest.kt`:
  - Verify `Phoenix` and `Senko` are both instances of `Mystic`.
  - Verify `Mystic.rollAbility()` only rolls from `[EXPERIENCE, DROPS, OPPORTUNIST, SAVAGE]`.
  - Verify `MysticEgg.hatch()` rolls Phoenix and Senko with equal probability (test over 1,000 iterations).
  - Test Solar Rebirth target scaling:
    - Lv 1: 1 target
    - Lv 49: 1 target
    - Lv 50: 2 targets
    - Lv 99: 2 targets
    - Lv 100: 3 targets
  - Test Solar Rebirth in combat simulation:
    - Reviving a fainted ally at 1 HP with Solar Rebirth status effect.
    - Intercepting lethal damage on an alive ally, clamping HP to 1.
  - Image size verification: `pet_phoenix.png` is 64×64, `egg_mystic.png` is 32×32, `icon_effect_solar_rebirth.png` is 32×32.

### Manual Verification
- View Pet Shelter: verify Phoenix and Senko display with `Mystic` badge.
- Open Shop $\rightarrow$ Companions: Purchase 10 Mystic Eggs, check inventory.
- Consume Mystic Egg in Storage: verify hatch flow and resulting pet.
- Enter combat with Phoenix: verify Solar Rebirth triggers on multiple allies according to level scaling.
