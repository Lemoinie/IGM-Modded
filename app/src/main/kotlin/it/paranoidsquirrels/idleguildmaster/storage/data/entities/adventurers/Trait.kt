package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers

import androidx.annotation.StringRes
import it.paranoidsquirrels.idleguildmaster.R

enum class Trait(
    @JvmField @StringRes val nameRes: Int,
    @JvmField @StringRes val description: Int
) {
    BOOKWORM(R.string.trait_bookworm_name, R.string.trait_bookworm_description),
    BRUTE(R.string.trait_brute_name, R.string.trait_brute_description),
    FERAL(R.string.trait_feral_name, R.string.trait_feral_description),
    BOOKWORM_PLUS(R.string.trait_bookworm_plus_name, R.string.trait_bookworm_plus_description),
    BRUTE_PLUS(R.string.trait_brute_plus_name, R.string.trait_brute_plus_description),
    FERAL_PLUS(R.string.trait_feral_plus_name, R.string.trait_feral_plus_description),
    VERSATILE(R.string.trait_versatile_name, R.string.trait_versatile_description),
    VERSATILE_PLUS(R.string.trait_versatile_plus_name, R.string.trait_versatile_plus_description),
    ZEALOUS(R.string.trait_zealous_name, R.string.trait_zealous_description),
    ZEALOUS_PLUS(R.string.trait_zealous_plus_name, R.string.trait_zealous_plus_description),
    CUNNING(R.string.trait_cunning_name, R.string.trait_cunning_description),
    CUNNING_PLUS(R.string.trait_cunning_plus_name, R.string.trait_cunning_plus_description),
    ATHLETIC(R.string.trait_athletic_name, R.string.trait_athletic_description),
    ATHLETIC_PLUS(R.string.trait_athletic_plus_name, R.string.trait_athletic_plus_description),
    EMPATHETIC(R.string.trait_empathetic_name, R.string.trait_empathetic_description),
    GIFTED(R.string.trait_gifted_name, R.string.trait_gifted_description),
    INTIMIDATING(R.string.trait_intimidating_name, R.string.trait_intimidating_description),
    FOCUSED(R.string.trait_focused_name, R.string.trait_focused_description),
    DRAGON_BLOOD(R.string.trait_dragon_blood_name, R.string.trait_dragon_blood_description),
    CURSED(R.string.trait_cursed_name, R.string.trait_cursed_description),
    REACTIVE(R.string.trait_reactive_name, R.string.trait_reactive_description),
    NOCTURNAL(R.string.trait_nocturnal_name, R.string.trait_nocturnal_description),
    MINDFUL(R.string.trait_mindful_name, R.string.trait_mindful_description),
    TROLL_BLOOD(R.string.trait_troll_blood_name, R.string.trait_troll_blood_description),
    NIMBLE(R.string.trait_nimble_name, R.string.trait_nimble_description),
    RUTHLESS(R.string.trait_ruthless_name, R.string.trait_ruthless_description),
    BLESSED(R.string.trait_blessed_name, R.string.trait_blessed_description),
    ALERT(R.string.trait_alert_name, R.string.trait_alert_description),
    DEADEYE(R.string.trait_deadeye_name, R.string.trait_deadeye_description),
    SUNDERING(R.string.trait_sundering_name, R.string.trait_sundering_description),
    FORTIFIED(R.string.trait_fortified_name, R.string.trait_fortified_description),
    RECKLESS(R.string.trait_reckless_name, R.string.trait_reckless_description),
    LONE_WOLF(R.string.trait_lone_wolf_name, R.string.trait_lone_wolf_description),
    RUTHLESS_PLUS(R.string.trait_ruthless_plus_name, R.string.trait_ruthless_plus_description),
    EMPATHETIC_PLUS(R.string.trait_empathetic_plus_name, R.string.trait_empathetic_plus_description),
    NOCTURNAL_PLUS(R.string.trait_nocturnal_plus_name, R.string.trait_nocturnal_plus_description),
    GIFTED_PLUS(R.string.trait_gifted_plus_name, R.string.trait_gifted_plus_description),
    INTIMIDATING_PLUS(R.string.trait_intimidating_plus_name, R.string.trait_intimidating_plus_description),
    CURSED_PLUS(R.string.trait_cursed_plus_name, R.string.trait_cursed_plus_description);

    /** True when this trait is a permanently-amplified PLUS form (e.g. `RUTHLESS_PLUS`). */
    fun isPlus(): Boolean = this.name.endsWith("_PLUS")

    companion object {
        @JvmStatic
        fun fromString(str: String?): Trait? {
            if (str == null) return null
            for (trait in values()) {
                if (trait.name == str) {
                    return trait
                }
            }
            return null
        }

        /** Evo-24 upgrade path: maps a base Rare trait to its permanent PLUS form. */
        @JvmStatic
        fun getRarePlusUpgrade(baseTrait: Trait?): Trait? = when (baseTrait) {
            Trait.RUTHLESS -> Trait.RUTHLESS_PLUS
            Trait.EMPATHETIC -> Trait.EMPATHETIC_PLUS
            Trait.NOCTURNAL -> Trait.NOCTURNAL_PLUS
            Trait.GIFTED -> Trait.GIFTED_PLUS
            Trait.INTIMIDATING -> Trait.INTIMIDATING_PLUS
            Trait.CURSED -> Trait.CURSED_PLUS
            else -> null
        }
    }
}
