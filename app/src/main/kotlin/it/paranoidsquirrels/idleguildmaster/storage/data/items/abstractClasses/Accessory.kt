package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses

import it.paranoidsquirrels.idleguildmaster.R

abstract class Accessory : Equipment() {
    override fun printType(): Int = R.string.type_accessory
}
