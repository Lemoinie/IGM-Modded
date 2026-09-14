package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class AncestralBlood : Item() {
    override fun configureProperties() {
        idName = R.string.item_ancestral_blood_name
        idDescription = R.string.item_ancestral_blood_description
        idImage = R.drawable.ancestral_blood
        source.add(R.string.raid_name_the_tower)
        price = 1000L
    }
}
