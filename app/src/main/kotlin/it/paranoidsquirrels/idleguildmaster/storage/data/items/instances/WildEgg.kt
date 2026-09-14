package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Egg
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet

class WildEgg : Egg() {
    override fun configureProperties() {
        idName = R.string.egg_wild_name
        idDescription = R.string.egg_wild_description
        idImage = R.drawable.egg_wild
        source.add(R.string.dungeon_name_enchanted_forest)
        source.add(R.string.dungeon_name_blackwater_port)
        price = 100L
    }

    override fun hatch(): Pet? {
        val id = Utils.calculateNewPetId()
        val r = Utils.random()
        return if (r < 0.75) {
            Pet.getInstance("Rat", id)
        } else if (r < 0.95) {
            Pet.getInstance("Squirrel", id)
        } else {
            Pet.getInstance("RedWolf", id)
        }
    }
}
