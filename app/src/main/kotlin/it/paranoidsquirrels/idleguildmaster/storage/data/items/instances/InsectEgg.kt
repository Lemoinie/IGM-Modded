package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Egg
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet

class InsectEgg : Egg() {
    override fun configureProperties() {
        idName = R.string.egg_insect_name
        idDescription = R.string.egg_insect_description
        idImage = R.drawable.egg_insect
        source.add(R.string.dungeon_name_the_desert)
        source.add(R.string.dungeon_name_obsidian_mines)
        source.add(R.string.dungeon_name_the_southern_grove)
        price = 100L
    }

    override fun hatch(): Pet? {
        val id = Utils.calculateNewPetId()
        val r = Utils.random()
        return if (r < 0.75) {
            Pet.getInstance("Mosquito", id)
        } else if (r < 0.95) {
            Pet.getInstance("Beetle", id)
        } else {
            Pet.getInstance("Tarantula", id)
        }
    }
}
