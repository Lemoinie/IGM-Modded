# Implementation Plan: Weapon Skill System & Solteris, Sword of the Sun

## Goal Description
Implement an extensible, modular **Weapon Skill System** allowing weapons (and potentially other equipment) to possess unique named combat skills (such as on-hit direct damage procs, elemental bursts, and status applications). 

Debut the system with **Solteris, Sword of the Sun**, bearing the weapon skill **"Gs Veeshan's Flare"** (on-hit chance to unleash solar flare damage).

---

## 1. Core Architecture: Weapon Skill System

### 1.1 The `WeaponSkill` Model
Create `it.paranoidsquirrels.idleguildmaster.storage.data.items.skills.WeaponSkill` (or enum `WeaponSkills`):
```kotlin
package it.paranoidsquirrels.idleguildmaster.storage.data.items.skills

import androidx.annotation.StringRes
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType

enum class WeaponSkill(
    @JvmField @StringRes val skillName: Int,
    @JvmField @StringRes val skillDescription: Int,
    @JvmField val procChance: Double,              // e.g. 0.20 = 20%
    @JvmField val baseDamage: Int,                 // Flat bonus damage
    @JvmField val isMagic: Boolean = true,         // Physical vs Magic damage
    @JvmField val statusEffect: StatusEffect? = null // Optional debuff (e.g. Ablaze)
) {
    GS_VEESHANS_FLARE(
        R.string.skill_gs_veeshans_flare_name,
        R.string.skill_gs_veeshans_flare_description,
        procChance = 0.20,
        baseDamage = 150,
        isMagic = true,
        statusEffect = StatusEffect(StatusEffectType.ABLAZE, null, 2, 1.0)
    );

    fun formatDescription(resources: android.content.res.Resources): String {
        return resources.getString(skillDescription)
    }
}
```

### 1.2 Equipment Hook ([`Equipment.kt`](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/items/abstractClasses/Equipment.kt))
Add nullable field with default `null` to `Equipment`:
```kotlin
@JvmField @Transient var weaponSkill: WeaponSkill? = null
```
- **100% Backwards Compatible**: All existing 100+ vanilla weapons remain untouched and default to `null`.
- **Zero Save Breakage**: `@Transient` ensures saves do not serialize or require migration; properties configure at runtime via `configureProperties()`.

### 1.3 Combat Execution ([`Area.kt`](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.kt))
In `Area.dealDamage()` / basic attack on-hit resolution:
```kotlin
val ws = (entity as? Adventurer)?.weapon?.weaponSkill
if (ws != null && entity2.currentHp > 0 && Utils.random() < ws.procChance) {
    triggerWeaponSkill(entity, entity2, ws)
}
```
Where `triggerWeaponSkill()`:
1. Calculates damage (mitigated by enemy Magic/Physical Defense or flat).
2. Deducts HP / Shield on `entity2`.
3. Applies `ws.statusEffect` if present.
4. Emits combat log via `Logger.log(...)`.

### 1.4 Combat Logging ([`Logger.kt`](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/Logger.kt))
Add new log type:
```kotlin
const val WEAPON_SKILL_PROC = 127
```
Formatted in combat log:
> *"[Attacker]'s [Weapon] unleashed [Skill Name] on [Target] for [X] damage!"*

### 1.5 UI Presentation ([`UIUtils.kt`](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/UIUtils.kt) & [`DialogItemDetail.kt`](file:///C:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogItemDetail.kt))
In `UIUtils.formatEquipmentDescription()`, if `equipment.weaponSkill != null`:
Append formatted section:
```text
✦ Skill: Gs Veeshan's Flare
  20% chance on hit to erupt with solar flames, dealing 150 Magic damage and inflicting Ablaze.
```

---

## 2. Debut Weapon: Solteris, Sword of the Sun

### 2.1 Item Specs
- **Class**: `SolterisSwordOfTheSun` extends `Sword()`
- **Type**: Sword (Physical, 100% CON scaling)
- **Sprite**: `R.drawable.solteris` (32×32 in [solteris.png](file:///C:/Repositories/IGM-Modded/app/src/main/res/drawable/solteris.png))
- **Proposed Base Stats**:
  - `constitution`: `100`
  - `dexterity`: `35`
  - `criticalChance`: `0.15` (+15%)
  - `weaponSkill`: `WeaponSkill.GS_VEESHANS_FLARE`
  - `price`: `120000L`
- **Skill**: **Gs Veeshan's Flare**
  - Proc Chance: `20%` (0.20)
  - Damage: `150` Magic damage
  - Status Effect: `Ablaze` (2 turns)

### 2.2 Reusability Demonstration
Because `WeaponSkill.GS_VEESHANS_FLARE` is decoupled from the weapon:
Any future weapon (e.g. "Bow of the Sun", "Solar Dagger") can simply set:
```kotlin
weaponSkill = WeaponSkill.GS_VEESHANS_FLARE
```
without writing any additional combat or UI code.

---

## 3. Localization Strings ([`strings.xml`](file:///C:/Repositories/IGM-Modded/app/src/main/res/values/strings.xml))
- `skill_gs_veeshans_flare_name`: `"Gs Veeshan's Flare"`
- `skill_gs_veeshans_flare_description`: `"20% chance on hit to strike the target for 150 Magic damage and inflict Ablaze for 2 turns."`
- `log_weapon_skill_proc`: `"%s's %s unleashed %s on %s for %s damage!"`
- `weapon_solteris_name`: `"Solteris, Sword of the Sun"`
- `weapon_solteris_description`: `"A radiant blade blessed by the ancient solar dragon Veeshan. Its golden edge flares with searing celestial fire upon striking."`

---

## 4. Verification Plan

### Automated Tests
- Create unit test in `app/src/test/kotlin/it/paranoidsquirrels/idleguildmaster/WeaponSkillTest.kt`:
  - Verify weapon skill property assignment on `Equipment`.
  - Verify null default on vanilla weapons.
  - Verify combat proc execution, damage deduction, and status application.
  - Verify log message generation.

### Manual Verification
- Spawn `SolterisSwordOfTheSun` via Dev console (`ITEM SolterisSwordOfTheSun 1`).
- Open Item Detail dialog to verify the `✦ Skill: Gs Veeshan's Flare` section renders cleanly.
- Equip on a Knight / Crusader / Fighter and enter combat:
  - Verify basic attacks occasionally trigger Gs Veeshan's Flare.
  - Check combat log for proc message and damage numbers.
  - Verify enemy takes damage and gains Ablaze status.
