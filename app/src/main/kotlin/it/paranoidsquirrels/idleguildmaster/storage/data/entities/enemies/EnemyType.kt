package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies

import androidx.annotation.StringRes
import it.paranoidsquirrels.idleguildmaster.R

enum class EnemyType(
    @JvmField @StringRes val nameRes: Int,
    @JvmField @StringRes val descriptionRes: Int
) {
    HUMANOID(R.string.enemy_type_humanoid, R.string.enemy_type_humanoid_desc),
    BEAST(R.string.enemy_type_beast, R.string.enemy_type_beast_desc),
    UNDEAD(R.string.enemy_type_undead, R.string.enemy_type_undead_desc),
    DEMON(R.string.enemy_type_demon, R.string.enemy_type_demon_desc),
    DRAGON(R.string.enemy_type_dragon, R.string.enemy_type_dragon_desc),
    SLIME(R.string.enemy_type_slime, R.string.enemy_type_slime_desc),
    ELEMENTAL(R.string.enemy_type_elemental, R.string.enemy_type_elemental_desc),
    PLANT(R.string.enemy_type_plant, R.string.enemy_type_plant_desc),
    CONSTRUCT(R.string.enemy_type_construct, R.string.enemy_type_construct_desc),
    ABERRATION(R.string.enemy_type_aberration, R.string.enemy_type_aberration_desc)
}
