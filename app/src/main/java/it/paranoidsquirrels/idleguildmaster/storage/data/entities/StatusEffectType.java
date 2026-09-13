package it.paranoidsquirrels.idleguildmaster.storage.data.entities;

import it.paranoidsquirrels.idleguildmaster.R;

/* JADX INFO: loaded from: classes3.dex */
public enum StatusEffectType {
    TAUNT(R.string.status_effect_taunt, R.string.status_effect_taunt_description, R.drawable.icon_effect_taunt, true, false),
    DEFENSIVE_STANCE(R.string.status_effect_defensive_stance, R.string.status_effect_defensive_stance_description, R.drawable.icon_effect_defensive_stance, false, true),
    STUN(R.string.status_effect_stun, R.string.status_effect_stun_description, R.drawable.icon_effect_stun, true, true),
    STUN_NOT_CLEANSABLE(R.string.status_effect_stun, R.string.status_effect_stun_description, R.drawable.icon_effect_stun, false, true),
    SILENCE(R.string.status_effect_silence, R.string.status_effect_silence_description, R.drawable.icon_effect_silence, true, true),
    ABLAZE(R.string.status_effect_ablaze, R.string.status_effect_ablaze_description, R.drawable.icon_effect_ablaze, true, true),
    POISON(R.string.status_effect_poison, R.string.status_effect_poison_description, R.drawable.icon_effect_poison, true, true),
    REGENERATION(R.string.status_effect_regeneration, R.string.status_effect_regeneration_description, R.drawable.icon_effect_regeneration, false, true),
    LESSER_CURSE(R.string.status_effect_lesser_curse, R.string.status_effect_lesser_curse_description, R.drawable.icon_effect_curse, true, false),
    CURSE(R.string.status_effect_curse, R.string.status_effect_curse_description, R.drawable.icon_effect_curse, true, false),
    GREATER_CURSE(R.string.status_effect_greater_curse, R.string.status_effect_greater_curse_description, R.drawable.icon_effect_curse, true, false),
    OMINOUS_CURSE(R.string.status_effect_ominous_curse, R.string.status_effect_ominous_curse_description, R.drawable.icon_effect_curse, true, false),
    ABHORRENT_CURSE(R.string.status_effect_abhorrent_curse, R.string.status_effect_abhorrent_curse_description, R.drawable.icon_effect_curse, true, false),
    BLEED(R.string.status_effect_bleed, R.string.status_effect_bleed_description, R.drawable.icon_effect_bleed, true, true),
    DELIRIUM(R.string.status_effect_delirium, R.string.status_effect_delirium_description, R.drawable.icon_effect_delirium, false, true),
    FRENZY(R.string.status_effect_frenzy, R.string.status_effect_frenzy_description, R.drawable.icon_effect_frenzy, false, true),
    ANOINTED(R.string.status_effect_anointed, R.string.status_effect_anointed_description, R.drawable.icon_effect_anointed, false, true),
    SKELETON_KEY(R.string.status_effect_skeleton_key, R.string.status_effect_skeleton_key_description, R.drawable.skeleton_key, false, false),
    FEEBLE_TETHER(R.string.status_effect_feeble_tether, R.string.status_effect_feeble_tether_description, R.drawable.feeble_tether, false, true),
    INSPIRE(R.string.status_effect_inspire, R.string.status_effect_inspire_description, R.drawable.icon_effect_inspire, false, true),
    EXALT(R.string.status_effect_exalt, R.string.status_effect_exalt_description, R.drawable.icon_effect_exalt, false, true),
    PETRIFY(R.string.status_effect_petrify, R.string.status_effect_petrify_description, R.drawable.icon_effect_petrify, true, true),
    FALSE_LIFE(R.string.status_effect_false_life, R.string.status_effect_false_life_description, R.drawable.icon_effect_false_life, false, true),
    TERRIFY(R.string.status_effect_terrify, R.string.status_effect_terrify_description, R.drawable.icon_effect_terrify, true, true),
    FROZEN(R.string.status_effect_freeze, R.string.status_effect_freeze_description, R.drawable.icon_effect_freeze, true, true);

    public transient int icon;
    public transient int logDescription;
    public transient int name;
    public transient boolean negative;
    public transient boolean serialized;

    StatusEffectType(int i, int i2, int i3, boolean z, boolean z2) {
        this.name = i;
        this.logDescription = i2;
        this.icon = i3;
        this.negative = z;
        this.serialized = z2;
    }
}
