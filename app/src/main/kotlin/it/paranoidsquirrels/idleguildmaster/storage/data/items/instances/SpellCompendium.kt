package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory

class SpellCompendium : Accessory() {
    override fun configureProperties() {
        idName = R.string.accessory_spell_compendium_name
        idDescription = R.string.accessory_spell_compendium_description
        idImage = R.drawable.spell_compendium
        source.add(R.string.dungeon_name_hidden_city_of_larox)
        price = 40L
        intelligence = 30
    }
}
