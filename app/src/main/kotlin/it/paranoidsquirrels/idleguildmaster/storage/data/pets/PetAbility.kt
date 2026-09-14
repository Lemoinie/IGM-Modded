package it.paranoidsquirrels.idleguildmaster.storage.data.pets

import it.paranoidsquirrels.idleguildmaster.R

enum class PetAbility(
    @JvmField val nameRes: Int,
    @JvmField val description: Int
) {
    EMPTY(R.string.pet_ability_empty_name, R.string.pet_ability_empty_description),
    FIGHTER(R.string.pet_ability_fighter_name, R.string.pet_ability_fighter_description),
    HEALER(R.string.pet_ability_healer_name, R.string.pet_ability_healer_description),
    DECOY(R.string.pet_ability_decoy_name, R.string.pet_ability_decoy_description),
    OPPORTUNIST(R.string.pet_ability_opportunist_name, R.string.pet_ability_opportunist_description),
    MAGIC(R.string.pet_ability_magic_name, R.string.pet_ability_magic_description),
    SAVAGE(R.string.pet_ability_savage_name, R.string.pet_ability_savage_description),
    BRIGHT(R.string.pet_ability_bright_name, R.string.pet_ability_bright_description),
    EXPERIENCE(R.string.pet_ability_experience_name, R.string.pet_ability_experience_description),
    DROPS(R.string.pet_ability_drops_name, R.string.pet_ability_drops_description),
    COUNTERATTACK(R.string.pet_ability_counterattack_name, R.string.pet_ability_counterattack_description),
    LIFESTEAL(R.string.pet_ability_lifesteal_name, R.string.pet_ability_lifesteal_description),
    REGENERATION(R.string.pet_ability_regeneration_name, R.string.pet_ability_regeneration_description),
    BARRIER(R.string.pet_ability_barrier_name, R.string.pet_ability_barrier_description);

    companion object {
        @JvmStatic
        fun fromString(str: String): PetAbility? {
            for (petAbility in values()) {
                if (petAbility.toString() == str) {
                    return petAbility
                }
            }
            return null
        }
    }
}
