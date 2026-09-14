package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Egg
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet

class ReptileEgg : Egg() {
    override fun configureProperties() {
        idName = R.string.egg_reptile_name
        idDescription = R.string.egg_reptile_description
        idImage = R.drawable.egg_reptile
        source.add(R.string.dungeon_name_the_southern_grove)
        source.add(R.string.dungeon_name_barren_wastelands)
        price = 100L
    }

    override fun hatch(): Pet? {
        val id = Utils.calculateNewPetId()
        val r = Utils.random()
        return if (r < 0.75) {
            Pet.getInstance("Lizard", id)
        } else if (r < 0.95) {
            Pet.getInstance("TreeFrog", id)
        } else {
            Pet.getInstance("Crocodile", id)
        }
    }
}
