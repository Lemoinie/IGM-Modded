package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class SPIDER : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_spider_name
        idDescription = R.string.accessory_spider_description
        idEffect = R.string.accessory_spider_effect
        idImage = R.drawable.spider
        source.add(R.string.raid_name_kaunis)
        price = 18500L
        endOfTurnAction = EndOfTurnAction.EXTRA_ATTACK_MELEE
        maxHp = 20
        constitution = 5
        dexterity = 5
    }
}
