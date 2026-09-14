package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Egg
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet

class WoodenEgg : Egg() {
    override fun configureProperties() {
        idName = R.string.egg_wooden_name
        idDescription = R.string.egg_wooden_description
        idImage = R.drawable.egg_wooden
        source.add(R.string.dungeon_name_enchanted_forest)
        source.add(R.string.dungeon_name_the_southern_grove)
        price = 100L
    }

    override fun hatch(): Pet? {
        val id = Utils.calculateNewPetId()
        val r = Utils.random()
        return if (r < 0.75) {
            Pet.getInstance("FloatingSeed", id)
        } else if (r < 0.95) {
            Pet.getInstance("WalkingBush", id)
        } else {
            Pet.getInstance("HolyTree", id)
        }
    }
}
