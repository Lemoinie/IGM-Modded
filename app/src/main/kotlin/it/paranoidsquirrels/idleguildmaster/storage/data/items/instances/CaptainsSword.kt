package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class CaptainsSword : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_captains_sword_name
        idDescription = R.string.weapon_sword_captains_sword_description
        idEffect = R.string.weapon_sword_captains_sword_effect
        idImage = R.drawable.captains_sword
        source.add(R.string.dungeon_name_the_golden_city)
        price = 8000L
        constitution = 25
        dexterity = 8
        onTargetHit = StatusEffect(StatusEffectType.STUN, null, 1, 0.20)
        isRareDrop = true
    }
}
