package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Egg
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet

class EsotericEgg : Egg() {
    override fun configureProperties() {
        idName = R.string.egg_esoteric_name
        idDescription = R.string.egg_esoteric_description
        idImage = R.drawable.egg_esoteric
        source.add(R.string.dungeon_name_the_desert)
        source.add(R.string.dungeon_name_eternal_battlefield)
        source.add(R.string.dungeon_name_blackwater_port)
        source.add(R.string.dungeon_name_frostbite_peaks)
        source.add(R.string.dungeon_name_obsidian_mines)
        source.add(R.string.raid_name_the_lost_expedition)
        price = 100L
    }

    override fun hatch(): Pet? {
        val id = Utils.calculateNewPetId()
        val r = Utils.random()
        return if (r < 0.75) {
            Pet.getInstance("FloatingEye", id)
        } else if (r < 0.95) {
            Pet.getInstance("TentacleTangle", id)
        } else {
            Pet.getInstance("ThingFromTheAbyss", id)
        }
    }
}
