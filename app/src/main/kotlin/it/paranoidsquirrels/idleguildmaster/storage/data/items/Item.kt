package it.paranoidsquirrels.idleguildmaster.storage.data.items

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import java.util.LinkedList
import java.util.Objects

abstract class Item {
    companion object {
        private const val CLASS_PATH = "it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.%s"

        @JvmStatic
        fun getInstance(str: String): Item? {
            return getInstance(str, 1)
        }

        @JvmStatic
        fun getInstance(str: String, i: Int): Item? {
            return try {
                val clazz = Class.forName(String.format(CLASS_PATH, str))
                val item = clazz.getConstructor().newInstance() as Item
                item.trueClass = str
                item.stack = i
                item.source = LinkedList()
                item.configureProperties()
                item
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }

    @JvmField @Transient protected var idDescription: Int = 0
    @JvmField @Transient protected var idEffect: Int = 0
    @JvmField @Transient protected var idImage: Int = 0
    @JvmField @Transient protected var idName: Int = 0
    @JvmField @Transient protected var price: Long = 0L
    @JvmField @Transient protected var rarity: Int = 0
    @JvmField @Transient protected var source: MutableList<Int> = LinkedList()
    @JvmField protected var stack: Int = 0
    @JvmField protected var trueClass: String? = null
    @JvmField @Transient protected var uniqueOrigin: String? = null
    @JvmField @Transient protected var notSellable: Boolean = false
    @JvmField @Transient protected var consumable: Boolean = false

    protected abstract fun configureProperties()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Item) return false
        return trueClass != null && trueClass == other.trueClass
    }

    override fun hashCode(): Int {
        return Objects.hash(trueClass)
    }

    open fun getSecondsToCraft(): Long {
        val discount = if (MainActivity.data.isMerchantPackPurchased) 0.6 else 1.0
        val timeMultiplier = Math.pow(0.9, (MainActivity.data.levelWorkshopTime + MainActivity.data.upgradeWorkshopTime - 1).toDouble())
        return (discount * timeMultiplier * Math.max(price - 1, 1L).toDouble() * 6.0 * stack.toDouble()).toLong()
    }

    open fun getSecondsToSell(): Long {
        val discount = if (MainActivity.data.isMerchantPackPurchased) 0.6 else 1.0
        val timeMultiplier = Math.pow(0.9, (MainActivity.data.levelMarketTime + MainActivity.data.upgradeMarketTime - 1).toDouble())
        return (discount * timeMultiplier * price.toDouble() * 4.0 * stack.toDouble()).toLong()
    }

    open fun getTrueClass(): String? = trueClass
    open fun setTrueClass(str: String?) { trueClass = str }

    open fun getIdName(): Int = idName
    open fun setIdName(i: Int) { idName = i }

    open fun getIdDescription(): Int = idDescription
    open fun setIdDescription(i: Int) { idDescription = i }

    open fun getSource(): MutableList<Int> = source
    open fun setSource(list: MutableList<Int>) { source = list }

    open fun getIdEffect(): Int = idEffect
    open fun setIdEffect(i: Int) { idEffect = i }

    open fun getIdImage(): Int = idImage
    open fun setIdImage(i: Int) { idImage = i }

    open fun getStack(): Int = stack
    open fun setStack(i: Int) { stack = i }

    open fun getPrice(): Long = Utils.truncatePrice(price)
    open fun setPrice(j: Long) { price = j }

    open fun getRarity(): Int = rarity
    open fun setRarity(i: Int) { rarity = i }

    open fun getUniqueOrigin(): String? = uniqueOrigin
    open fun setUniqueOrigin(str: String?) { uniqueOrigin = str }

    open fun isNotSellable(): Boolean = notSellable
    open fun setNotSellable(z: Boolean) { notSellable = z }

    open fun printType(): Int = R.string.type_material

    open fun isConsumable(): Boolean = consumable
    open fun setConsumable(z: Boolean) { consumable = z }
}
