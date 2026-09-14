package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow

class TitanicMight : Bow() {
    override fun configureProperties() {
        idName = R.string.weapon_bow_titanic_might_name
        idDescription = R.string.weapon_bow_titanic_might_description
        idEffect = R.string.weapon_bow_titanic_might_effect
        idImage = R.drawable.titanic_might
        price = 22400L
        onTargetHit = StatusEffect(StatusEffectType.STUN, null, 1, 0.11)
        dexterity = 32
        intelligence = 20
    }
}
