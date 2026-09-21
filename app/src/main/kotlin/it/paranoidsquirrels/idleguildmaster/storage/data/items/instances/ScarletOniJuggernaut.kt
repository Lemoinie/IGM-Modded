package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class ScarletOniJuggernaut : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_scarlet_oni_juggernaut_name
        idDescription = R.string.armor_heavy_scarlet_oni_juggernaut_description
        idEffect = R.string.armor_heavy_scarlet_oni_juggernaut_effect
        idImage = R.drawable.scarlet_oni_juggernaut
        price = 125893L
        maxHp = 720
        constitution = 126
        criticalChance = 0.30
        criticalDamage = 0.35
    }
}