package it.paranoidsquirrels.idleguildmaster.storage.data.entities;

import it.paranoidsquirrels.idleguildmaster.R;

/* JADX INFO: loaded from: classes3.dex */
public enum EndOfTurnAction {
    RIDER_I(false, true, 25, null, false, false, null, false, true, true, R.string.log_rider_horse_attack),
    RIDER_II(false, true, 40, null, false, false, null, false, true, true, R.string.log_rider_wolf_attack),
    RIDER_III(false, true, 55, null, false, false, null, false, true, true, R.string.log_rider_worg_attack),
    RIDER_IV(false, true, 55, null, true, false, null, false, true, true, R.string.log_rider_spitfang_attack),
    RIDER_V(false, true, 70, null, true, false, null, false, true, true, R.string.log_rider_drake_attack),
    RIDER_VI(false, true, 85, null, true, false, null, false, true, true, R.string.log_rider_golden_drake_attack),
    RIDER_VII(false, true, 100, null, true, false, null, false, true, true, R.string.log_rider_wyrm_attack),
    BLEED_POKE(false, true, 1, true, null, null, new StatusEffect(StatusEffectType.BLEED, null, 8, 1.0d), false, false, false, R.string.log_damage_dealt),
    BLEED_POKE_II(false, true, 1, true, null, null, new StatusEffect(StatusEffectType.BLEED, null, 20, 1.0d), false, false, false, R.string.log_damage_dealt),
    STUN_FLAT(false, true, 50, null, true, null, new StatusEffect(StatusEffectType.STUN, null, 1, 0.1d), false, false, false, R.string.log_damage_dealt),
    STUN_FLAT_II(false, true, 100, null, true, null, new StatusEffect(StatusEffectType.STUN, null, 1, 0.11d), false, false, false, R.string.log_damage_dealt),
    EXTRA_ATTACK(false, false, 0, null, null, null, null, true, true, false, R.string.log_damage_dealt),
    EXTRA_ATTACK_MELEE(false, false, 0, null, false, null, null, true, true, false, R.string.log_damage_dealt),
    EXTRA_ATTACK_1(false, true, 1, null, null, null, null, true, true, false, R.string.log_damage_dealt),
    EXTRA_ATTACK_90(false, true, 90, null, null, null, null, true, true, false, R.string.log_damage_dealt),
    EXTRA_ATTACK_140_MAGIC(false, true, 140, null, true, true, null, false, false, true, R.string.log_invisible_servant_attack),
    EXTRA_ATTACK_200_MAGIC(false, true, 180, null, true, true, null, false, false, true, R.string.log_enlighted_servant_attack),
    EXTRA_ATTACK_HP_TO_DAMAGE(false, true, 0, null, true, false, null, false, false, true, R.string.log_mottiphobia_attack),
    STUN_SELF_NOT_CLEANSABLE(false, false, 0, null, null, null, null, false, false, false, R.string.log_healing),
    FALSE_LIFE(false, false, 0, null, null, null, null, false, false, false, R.string.log_healing),
    SHIELD_INSPIRE_I(true, true, 30, null, null, null, new StatusEffect(StatusEffectType.INSPIRE, null, 1, 1.0d), false, false, false, R.string.log_healing),
    SHIELD_INSPIRE_II(true, true, 30, null, null, null, new StatusEffect(StatusEffectType.INSPIRE, null, 3, 1.0d), false, false, false, R.string.log_healing),
    SHIELD_INSPIRE_III(true, true, 75, null, null, null, new StatusEffect(StatusEffectType.INSPIRE, null, 3, 1.0d), false, false, false, R.string.log_healing),
    SHIELD_EXALT_I(true, true, 75, null, null, null, new StatusEffect(StatusEffectType.EXALT, null, 3, 1.0d), false, false, false, R.string.log_healing),
    SHIELD_EXALT_II(true, true, 75, null, null, null, new StatusEffect(StatusEffectType.EXALT, null, 5, 1.0d), false, false, false, R.string.log_healing);

    public int damage;
    public StatusEffect effect;
    public boolean flatDamage;
    public Boolean forceMagic;
    public Boolean forceRange;
    public boolean fromLivingCompanion;
    public int log;
    public Boolean procsOnMelee;
    public boolean replicatesBasicAttack;
    public boolean shields;
    public boolean triggersRetaliation;

    EndOfTurnAction(boolean z, boolean z2, int i, Boolean bool, Boolean bool2, Boolean bool3, StatusEffect statusEffect, boolean z3, boolean z4, boolean z5, int i2) {
        this.shields = z;
        this.flatDamage = z2;
        this.damage = i;
        this.procsOnMelee = bool;
        this.forceRange = bool2;
        this.forceMagic = bool3;
        this.effect = statusEffect;
        this.replicatesBasicAttack = z3;
        this.triggersRetaliation = z4;
        this.fromLivingCompanion = z5;
        this.log = i2;
    }
}
