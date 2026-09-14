package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class AegisMechanica : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_aegis_mechanica_name
        idDescription = R.string.weapon_sword_aegis_mechanica_description
        idEffect = R.string.weapon_sword_aegis_mechanica_effect
        idImage = R.drawable.aegis_mechanica
        price = 234000L
        onTargetHit = StatusEffect(StatusEffectType.TAUNT, null, 2, 1.0)
        maxHp = 85
        defense = 10
        magicDefense = 10
    }

    override fun isRanged(): Boolean = true
}
