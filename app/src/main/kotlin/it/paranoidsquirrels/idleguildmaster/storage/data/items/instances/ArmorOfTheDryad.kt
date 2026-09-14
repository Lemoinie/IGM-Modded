package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor

class ArmorOfTheDryad : HeavyArmor() {
    override fun configureProperties() {
        idName = R.string.armor_heavy_armor_of_the_dryad_name
        idDescription = R.string.armor_heavy_armor_of_the_dryad_description
        idEffect = R.string.armor_heavy_armor_of_the_dryad_effect
        idImage = R.drawable.armor_of_the_dryad
        price = 873L
        onSelfHit = StatusEffect(StatusEffectType.REGENERATION, null, 1, 1.0)
        maxHp = 240
    }
}
