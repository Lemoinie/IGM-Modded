package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class Icicle : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_icicle_name
        idDescription = R.string.weapon_staff_icicle_description
        idEffect = R.string.weapon_staff_icicle_effect
        idImage = R.drawable.icicle
        price = 2358L
        onTargetHit = StatusEffect(StatusEffectType.FROZEN, null, 1, 1.0)
        intelligence = 26
        constitution = 10
        dexterity = 10
    }
}
