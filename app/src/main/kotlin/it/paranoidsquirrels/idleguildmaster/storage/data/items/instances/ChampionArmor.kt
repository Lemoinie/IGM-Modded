package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class ChampionArmor : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_champion_armor_name
        idDescription = R.string.armor_heavy_champion_armor_description
        idEffect = R.string.armor_heavy_champion_armor_effect
        idImage = R.drawable.champion_armor
        price = 13300L
        maxHp = 120
        constitution = 28
        counterattack = 0.4
    }
}
