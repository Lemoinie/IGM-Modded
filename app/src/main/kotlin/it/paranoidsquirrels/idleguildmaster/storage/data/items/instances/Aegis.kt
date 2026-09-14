package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class Aegis : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_aegis_name
        idDescription = R.string.weapon_sword_aegis_description
        idEffect = R.string.weapon_sword_aegis_effect
        idImage = R.drawable.aegis
        price = 150000L
        onTargetHit = StatusEffect(StatusEffectType.TAUNT, null, 2, 1.0)
        maxHp = 60
        defense = 10
        magicDefense = 10
    }
}
