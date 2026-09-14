package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Egg
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet

class AvianEgg : Egg() {
    override fun configureProperties() {
        idName = R.string.egg_avian_name
        idDescription = R.string.egg_avian_description
        idImage = R.drawable.egg_avian
        source.add(R.string.dungeon_name_the_desert)
        source.add(R.string.dungeon_name_obsidian_mines)
        source.add(R.string.dungeon_name_frostbite_peaks)
        price = 100L
    }

    override fun hatch(): Pet? {
        val id = Utils.calculateNewPetId()
        val r = Utils.random()
        return if (r < 0.75) {
            Pet.getInstance("Dove", id)
        } else if (r < 0.95) {
            Pet.getInstance("Owl", id)
        } else {
            Pet.getInstance("Eagle", id)
        }
    }
}
