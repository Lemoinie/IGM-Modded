package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Egg
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet

class ConstructEgg : Egg() {
    override fun configureProperties() {
        idName = R.string.egg_construct_name
        idDescription = R.string.egg_construct_description
        idImage = R.drawable.egg_construct
        source.add(R.string.dungeon_name_blackwater_port)
        source.add(R.string.dungeon_name_obsidian_mines)
        source.add(R.string.raid_name_the_cultist_rebels)
        price = 100L
    }

    override fun hatch(): Pet? {
        val id = Utils.calculateNewPetId()
        val r = Utils.random()
        return if (r < 0.75) {
            Pet.getInstance("Rockling", id)
        } else if (r < 0.95) {
            Pet.getInstance("Golem", id)
        } else {
            Pet.getInstance("Tesseract", id)
        }
    }
}
