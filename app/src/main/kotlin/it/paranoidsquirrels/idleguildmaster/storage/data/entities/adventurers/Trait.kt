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
    ALERT(R.string.trait_alert_name, R.string.trait_alert_description);

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
    }
}
