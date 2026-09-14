package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

abstract class Upgrade : Item() {
    @JvmField @Transient protected var gemPrice: Int = 0

    abstract fun use()

    open fun getGemPrice(): Int = gemPrice

    override fun printType(): Int = R.string.type_upgrade
}
