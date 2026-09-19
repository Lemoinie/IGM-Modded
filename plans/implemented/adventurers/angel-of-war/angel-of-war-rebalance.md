# Implementation Plan - Holy Knight & Angel of War Evolution Line Rebalance

Rework and rebalance the **Holy Knight -> Angel of War** evolution line in the Footman tree. This transforms the branch from a redundant silence/darkness meatshield into a **Paladin / Frontline Auramancer (Semi-Tank + Frontline Healer + Holy Smiter + Status Purifier)**.

---

## Core Class Identity & Weapon Scaling

- **Role**: Frontline Protector & Support Anchor (Threat: 2).
- **Stat Profile**: High MDEF, moderate DEF, high CON and INT.
- **Stat Scaling**: **100% CON and 70% INT** across all tiers in the branch:
  - ttackConstitutionScaling = 1.0
  - ttackIntelligenceScaling = 0.7
  - ttackDexterityScaling = 0.0
- **Damage Type Split**:
  - **Basic Attacks**: Always **Physical damage** (using equipped Sword).
  - **Active Skills**:
    - T4 (Holy Knight) & T5 (Paladin): **Physical damage**.
    - T6 (Templar), T7 (Inquisitor), T8 (Justiciar), T9 (Angel of War): **Magic damage** (using skill.setForceMagic(true)).
- **Anti-Undead Specialization**:
  - **Radiant Blessing Aura**: All party attacks gain +5% (T4) up to +30% (T9) damage vs Undead.
  - **T6-T9 Active Skills**: Deal **+50% extra damage against Undead** (e.g. T6 deals 220% normal, 330% vs Undead).
- **Buff Philosophy**:
  - **All generic damage-increasing buffs (ANOINTED, EXALT) are removed from all skills.**
  - Focus is strictly on holy sustain, holy shields, debuff purging, and party-wide protection with holy damage amplification targeted exclusively against Undead.

---

## Dynamic Status Effect: Radiant Blessing

Instead of maintaining 7 separate status effect enums or hardcoded class checks, a single dynamic status effect **RADIANT_BLESSING** handles all aura effects across tiers:

- **Icon**: R.drawable.icon_effect_radiant_blessing (pp/src/main/res/drawable/icon_effect_radiant_blessing.png).
- **Engine Payload on StatusEffect (Approach 1)**:
  `kotlin
  class StatusEffect @JvmOverloads constructor(
      var type: StatusEffectType? = null,
      @Transient var cause: Entity? = null,
      var turnsLeft: Int = 0,
      @Transient var probability: Double = 0.0,
      var immunity: Double = 0.0,
      var flatDr: Int = 0,
      var regenPct: Double = 0.0,
      var undeadDamageBonus: Double = 0.0
  )
  `
- **Combined 4-in-1 Holy Mechanics**:
  1. **Status Immunity**: Checked in Adventurer.calculateImmunityToStatus() (its += blessing.immunity).
  2. **Bonus Damage against Undead**: In Area.dealDamage(), when attacking an EnemyType.UNDEAD, multiplies damage by (1.0 + blessing.undeadDamageBonus).
  3. **Flat Damage Reduction**: Checked in Entity.calculateFlatDamageReduction() (i += blessing.flatDr).
  4. **HP Regeneration**: Processed in Area.kt turn status loop (iRound += round(blessing.regenPct * maxHp)).
- **Application**: Automatically cast on all allies at the beginning of battle (initializeFight()) with 	urnsLeft = 1 so the player visually sees the glowing blessing icon over all party members.

---

## Tier-by-Tier Evolution (T4 -> T9)

### Tier 4: Holy Knight (HolyKnight.kt)
- **Threat**: 2
- **Scaling**: 100% CON, 70% INT
- **Passive (PASSIVE_AURA_OF_LIGHT_I)**:
  - Reduces Darkness by 15.
  - Battle-Start: Applies **Radiant Blessing** (+10% Status Immunity, +5% Damage against Undead) to all allies.
- **Active (ACTIVE_HOLY_SMITE_I)**:
  - Strikes 1 enemy for 200% **Physical damage**.
  - Heals the lowest-HP ally for 50% of damage dealt.

### Tier 5: Paladin (Paladin.kt)
- **Threat**: 2
- **Scaling**: 100% CON, 70% INT
- **Passive (PASSIVE_AURA_OF_LIGHT_II)**:
  - Reduces Darkness by 25.
  - Battle-Start: Applies **Radiant Blessing** (+15% Status Immunity, +10% Damage against Undead) to all allies.
  - On basic attack, heals the lowest-HP ally for 25% of damage dealt.
- **Active (ACTIVE_HOLY_SMITE_II)**:
  - Strikes 1 enemy for 220% **Physical damage**.
  - Heals the lowest-HP ally for 60% of damage dealt (no generic damage buffs).

### Tier 6: Templar (Templar.kt)
- **Threat**: 2
- **Scaling**: 100% CON, 70% INT
- **Passive (PASSIVE_AURA_OF_DEVOTION_I)**:
  - Reduces Darkness by 35.
  - Battle-Start: Applies **Radiant Blessing** (+20% Status Immunity, +15% Damage against Undead, +5 Flat Damage Reduction) to all allies.
  - On basic attack, heals the lowest-HP ally for 30% of damage dealt.
- **Active (ACTIVE_RADIANT_JUDGMENT_I)**:
  - Strikes the front line of enemies for 220% **Magic damage** (**+50% damage against Undead**, dealing 330% effective damage).
  - Cleanses 1 negative status effect from all allies and heals each ally for 15% of their own Max HP.

### Tier 7: Inquisitor (Inquisitor.kt)
- **Threat**: 2
- **Scaling**: 100% CON, 70% INT
- **Passive (PASSIVE_AURA_OF_DEVOTION_II)**:
  - Reduces Darkness by 45.
  - Battle-Start: Applies **Radiant Blessing** (+30% Status Immunity, +20% Damage against Undead, +8 Flat Damage Reduction) to all allies.
  - On basic attack, heals the lowest-HP ally for 35% of damage dealt.
- **Active (ACTIVE_RADIANT_JUDGMENT_II)**:
  - Strikes all enemies for 240% **Magic damage** (**+50% damage against Undead**, dealing 360% effective damage) + Silences them for 1 turn.
  - Cleanses 1 negative status effect from all allies and grants each ally a holy shield equal to 15% of their own Max HP.

### Tier 8: Justiciar (Justiciar.kt)
- **Threat**: 2
- **Scaling**: 100% CON, 70% INT
- **Passive (PASSIVE_AURA_OF_SANCTITY)**:
  - Reduces Darkness by 50.
  - Battle-Start: Applies **Radiant Blessing** (+40% Status Immunity, +25% Damage against Undead, +10 Flat Damage Reduction, +3% HP Regen/turn) to all allies.
  - On turn start, cleanses 1 negative status effect from the most debuffed ally.
  - On basic attack, heals the lowest-HP ally for 40% of damage dealt.
- **Active (ACTIVE_WRATH_OF_HEAVEN_I)**:
  - Strikes all enemies for 250% **Magic damage** (**+50% damage against Undead**, dealing 375% effective damage) + Silences them for 1 turn.
  - Cleanses all negative status effects from all allies and grants each ally a holy shield equal to **20% of their own Max HP**.

### Tier 9: Angel of War (AngelOfWar.kt)
- **Threat**: 2
- **Scaling**: 100% CON, 70% INT
- **Passive (PASSIVE_AURA_OF_THE_SERAPHIM)**:
  - Reduces Darkness by 50.
  - Battle-Start: Applies **Radiant Blessing** (+50% Status Immunity, +30% Damage against Undead, +15 Flat Damage Reduction, +5% HP Regen/turn) to all allies.
  - On turn start, cleanses 1 negative status effect from **all** allies.
  - On basic attack, heals the lowest-HP ally for 50% of damage dealt (overhealing converts into holy shield).
- **Active (ACTIVE_WRATH_OF_HEAVEN_II)**:
  - Strikes all enemies for 280% **Magic damage** (**+50% damage against Undead**, dealing 420% effective damage) + Silences them for 2 turns.
  - Fully cleanses all negative status effects from all allies and grants each ally a holy shield equal to **25% of their own Max HP**.

---

## Technical Engine Implementation Details

### 1. StatusEffect.kt & StatusEffectType.kt
- Add immunity: Double = 0.0, latDr: Int = 0, 
egenPct: Double = 0.0, undeadDamageBonus: Double = 0.0 to StatusEffect.
- Add RADIANT_BLESSING(R.string.status_effect_radiant_blessing, R.string.status_effect_radiant_blessing_description, R.drawable.icon_effect_radiant_blessing, false, false) to StatusEffectType.

### 2. Entity.kt & Adventurer.kt
- In Entity.addStatusEffect(): propagate immunity, latDr, 
egenPct, and undeadDamageBonus.
- In Adventurer.calculateImmunityToStatus(): add lessing.immunity.
- In Entity.calculateFlatDamageReduction(): add lessing.flatDr.
- In unit classes (HolyKnight through AngelOfWar):
  - Set ttackConstitutionScaling = 1.0 and ttackIntelligenceScaling = 0.7.
  - Set appropriate 	hreat = 2, base stats, and passive/active skills.

### 3. Area.kt
- In Skill:
  - Add ar forceMagic: Boolean? = null and un setForceMagic(bool: Boolean?): Skill.
  - Add ar undeadDamageMultiplier: Double = 1.0 and un setUndeadDamageMultiplier(mult: Double): Skill.
  - In dealDamage():
    - al zIsMagic = skill?.forceMagic ?: endOfTurnAction?.forceMagic ?: entity.isMagic().
    - If skill != null && entity2 is Enemy && entity2.getEnemyType() == EnemyType.UNDEAD, apply livingCompanionBonusDamage *= skill.undeadDamageMultiplier (1.5x for T6-T9).
- In dealDamage():
  - Check attacker's positiveStatusEffects for RADIANT_BLESSING. If target entity2 is Enemy && entity2.getEnemyType() == EnemyType.UNDEAD, apply statusDamageMultiplier *= (1.0 + blessing.undeadDamageBonus).
  - Trigger basic attack lifesteal-healing for Paladin passives.
- In Area.initializeFight():
  - Check party for Holy Knight branch units and apply RADIANT_BLESSING (999 turns) with the appropriate tier payload (immunity, latDr, 
egenPct, undeadDamageBonus) to all allies.
- In Area.nextTurn():
  - Handle PASSIVE_AURA_OF_SANCTITY (cleanse most debuffed ally) and PASSIVE_AURA_OF_THE_SERAPHIM (cleanse all allies).
- In turn status effect resolution:
  - For StatusEffectType.RADIANT_BLESSING: if effect.regenPct > 0.0, heal the entity for 
ound(effect.regenPct * maxHp).
- In cast():
  - ACTIVE_HOLY_SMITE_I (200% physical dmg, 50% damage heal to lowest ally)
  - ACTIVE_HOLY_SMITE_II (220% physical dmg, 60% damage heal to lowest ally)
  - ACTIVE_RADIANT_JUDGMENT_I (220% magic dmg via setForceMagic(true), setUndeadDamageMultiplier(1.5), cleanse 1 debuff, party heal (15% of each target's Max HP))
  - ACTIVE_RADIANT_JUDGMENT_II (240% magic dmg via setForceMagic(true), setUndeadDamageMultiplier(1.5), Silence 1 turn, cleanse 1 debuff, party shield (15% of each target's Max HP))
  - ACTIVE_WRATH_OF_HEAVEN_I (250% magic dmg via setForceMagic(true), setUndeadDamageMultiplier(1.5), Silence 1 turn, full cleanse, **party shield (20% of each target's Max HP)**)
  - ACTIVE_WRATH_OF_HEAVEN_II (280% magic dmg via setForceMagic(true), setUndeadDamageMultiplier(1.5), Silence 2 turns, full cleanse, **party shield (25% of each target's Max HP)**)

### 4. strings.xml
- Localize all skill names, descriptions, and the Radiant Blessing status effect name and description.

---

## Verification Plan

### Automated Tests
- Write comprehensive unit tests in ModFeaturesTest.kt:
  - Verify StatusEffect payload fields (immunity, latDr, 
egenPct, undeadDamageBonus).
  - Verify RADIANT_BLESSING applies status immunity (+10% to +50%) and flat damage reduction (+5 to +15).
  - Verify RADIANT_BLESSING increases damage against EnemyType.UNDEAD (+5% to +30%) and does not boost damage against non-undead.
  - Verify active skills T6-T9 deal 50% extra damage against EnemyType.UNDEAD (e.g. 220 dmg becomes 330 dmg against Skeleton/Undead, but stays 220 against Wolf/Beast).
  - Verify RADIANT_BLESSING turn tick heals by 
egenPct.
  - Verify weapon damage scaling uses 100% CON + 70% INT.
  - Verify active skills T6+ deal magic damage (setForceMagic(true)) while normal attacks deal physical damage.
  - Verify ACTIVE_WRATH_OF_HEAVEN_I (20% shield) and ACTIVE_WRATH_OF_HEAVEN_II (25% shield) grant shields without applying damage buffs.
- Run ./gradlew.bat testDebugUnitTest to ensure all tests pass.

### Manual / Device Verification
- Build and deploy APK to target device.
- Verify the Radiant Blessing icon appears over all party members at battle start in combat UI.
- Verify combat logs confirm shields, magic damage active skills, status resistance, and +50% active skill bonus damage against Undead.
