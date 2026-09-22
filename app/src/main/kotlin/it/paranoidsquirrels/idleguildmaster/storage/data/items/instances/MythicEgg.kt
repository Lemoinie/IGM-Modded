package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Egg
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet

/** Egg that hatches one of the Mythic pets (Phoenix / Kitsune) with equal probability. */
class MythicEgg : Egg() {
    override fun configureProperties() {
        idName = R.string.item_mythic_egg_name
        idDescription = R.string.item_mythic_egg_description
        idImage = R.drawable.egg_mythic
        price = 100L
    }

    override fun hatch(): Pet? {
        val id = Utils.calculateNewPetId()
        val pool = listOf("Phoenix", "Kitsune")
        val chosen = pool[(Utils.random() * pool.size.toDouble()).toInt()]
        return Pet.getInstance(chosen, id)
    }
}