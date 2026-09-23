package it.paranoidsquirrels.idleguildmaster.storage.data.entities

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import it.paranoidsquirrels.idleguildmaster.R

enum class StatusEffectType(
    @JvmField @StringRes val nameRes: Int,
    @JvmField @StringRes val logDescription: Int,
    @JvmField @DrawableRes val icon: Int,
    @JvmField val negative: Boolean,
    @JvmField val serialized: Boolean
) {
    TAUNT(R.string.status_effect_taunt, R.string.status_effect_taunt_description, R.drawable.icon_effect_taunt, true, false),
    DEFENSIVE_STANCE(R.string.status_effect_defensive_stance, R.string.status_effect_defensive_stance_description, R.drawable.icon_effect_defensive_stance, false, true),
    STUN(R.string.status_effect_stun, R.string.status_effect_stun_description, R.drawable.icon_effect_stun, true, true),
    STUN_NOT_CLEANSABLE(R.string.status_effect_stun, R.string.status_effect_stun_description, R.drawable.icon_effect_stun, false, true),
    SILENCE(R.string.status_effect_silence, R.string.status_effect_silence_description, R.drawable.icon_effect_silence, true, true),
    ABLAZE(R.string.status_effect_ablaze, R.string.status_effect_ablaze_description, R.drawable.icon_effect_ablaze, true, true),
    BLOODFLAME(R.string.status_effect_bloodflame, R.string.status_effect_bloodflame_log_description, R.drawable.icon_effect_bloodflame, true, true),
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
    FROZEN(R.string.status_effect_freeze, R.string.status_effect_freeze_description, R.drawable.icon_effect_freeze, true, true),
    RADIANT_BLESSING(R.string.status_effect_radiant_blessing, R.string.status_effect_radiant_blessing_description, R.drawable.icon_effect_radiant_blessing, false, false),
    SOLAR_REBIRTH(R.string.status_effect_solar_rebirth, R.string.status_effect_solar_rebirth_description, R.drawable.icon_effect_solar_rebirth, false, false),
    SANGUINE_FERVOR(R.string.status_effect_sanguine_fervor_name, R.string.status_effect_sanguine_fervor_log_description, R.drawable.icon_effect_sanguine_fervor, false, false),
    SINISTER_CURSE(R.string.status_effect_sinister_curse_name, R.string.status_effect_sinister_curse_description, R.drawable.icon_effect_sinister_curse, true, false)
}
