package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class UnholySpellcage : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_unholy_spellcage_name
        idDescription = R.string.armor_heavy_unholy_spellcage_description
        idEffect = R.string.armor_heavy_unholy_spellcage_effect
        idImage = R.drawable.unholy_spellcage
        price = 3086L
        maxHp = 320
        constitution = 9
        retaliationMagicalDamage = 60
    }
}
