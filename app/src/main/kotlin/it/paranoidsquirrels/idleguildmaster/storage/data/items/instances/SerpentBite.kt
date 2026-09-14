package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword

class SerpentBite : Sword() {
    override fun configureProperties() {
        idName = R.string.weapon_sword_serpent_bite_name
        idDescription = R.string.weapon_sword_serpent_bite_description
        idEffect = R.string.weapon_sword_serpent_bite_effect
        idImage = R.drawable.serpent_bite
        price = 10000L
        source.add(R.string.raid_name_the_dire_descent)
        uniqueOrigin = getTrueClass()
        notSellable = true
        threat = -4
        constitution = 30
        dexterity = 10
    }
}
