package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

class ThaumaturgicBlood : Item() {
    override fun configureProperties() {
        idName = R.string.item_thaumaturgic_blood_name
        idDescription = R.string.item_thaumaturgic_blood_description
        idImage = R.drawable.thaumaturgic_blood
        price = 89L
    }
}
