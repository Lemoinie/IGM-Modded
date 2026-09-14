package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class DreadfulMorningstar : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_dreadful_morningstar_name
        idDescription = R.string.weapon_sword_dreadful_morningstar_description
        idEffect = R.string.weapon_sword_dreadful_morningstar_effect
        idImage = R.drawable.dreadful_morningstar
        source.add(R.string.raid_name_the_tower)
        price = 20000L
        onTargetHit = StatusEffect(StatusEffectType.TERRIFY, null, 1, 0.18)
        constitution = 40
        dexterity = 10
    }
}
