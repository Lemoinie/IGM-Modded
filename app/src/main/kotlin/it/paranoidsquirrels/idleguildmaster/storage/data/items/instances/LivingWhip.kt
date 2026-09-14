package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class LivingWhip : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_living_whip_name
        idDescription = R.string.weapon_sword_living_whip_description
        idEffect = R.string.weapon_sword_living_whip_effect
        idImage = R.drawable.living_whip
        price = 567L
        onTargetHit = StatusEffect(StatusEffectType.TAUNT, null, 1, 0.65)
        maxHp = 40
        dexterity = 12
    }

    override fun isRanged(): Boolean = true
}
