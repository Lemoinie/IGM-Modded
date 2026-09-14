package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow

class SerpentSting : Bow() {
    override fun configureProperties() {
        idName = R.string.weapon_bow_serpent_sting_name
        idDescription = R.string.weapon_bow_serpent_sting_description
        idEffect = R.string.weapon_bow_serpent_sting_effect
        idImage = R.drawable.serpent_sting
        price = 10000L
        source.add(R.string.raid_name_the_dire_descent)
        uniqueOrigin = getTrueClass()
        notSellable = true
        endOfTurnAction = EndOfTurnAction.STUN_SELF_NOT_CLEANSABLE
        dexterity = 40
    }

    override fun getDamageModifier(i: Int, i2: Int, i3: Int): Int = super.getDamageModifier(i, i2, i3) * 3
}
