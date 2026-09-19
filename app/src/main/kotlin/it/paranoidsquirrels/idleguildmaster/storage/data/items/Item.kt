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
    @JvmField @Transient var idName: Int = 0
    @JvmField @Transient protected var price: Long = 0L
    @JvmField @Transient protected var rarity: Int = 0
    @JvmField @Transient protected var source: MutableList<Int> = LinkedList()
    @JvmField var stack: Int = 0
    @JvmField protected var trueClass: String? = null
    @JvmField @Transient protected var uniqueOrigin: String? = null
    @JvmField @Transient protected var notSellable: Boolean = false
    @JvmField @Transient protected var consumable: Boolean = false
    /**
     * Optional preset gem yield for this item instance (used by Shadow-dropped
     * Geodes: 10% -> 100, 20% -> 50, 70% -> 20). Null = vanilla behavior.
     * Not @Transient: Gson omits the key unless set, so it survives save/load.
     */
    @JvmField var gemValue: Int? = null

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
        var discount = 1.0
        if (MainActivity.data.isApprenticeWorkshopPurchased) discount *= 0.8
        if (MainActivity.data.isJourneymanWorkshopPurchased) discount *= 0.6
        if (MainActivity.data.isMasterWorkshopPurchased) discount *= 0.6
        if (MainActivity.data.isGrandmasterWorkshopPurchased) discount *= 0.4
        val timeMultiplier = Math.pow(0.9, (MainActivity.data.levelWorkshopTime + MainActivity.data.upgradeWorkshopTime - 1).toDouble())
        return (discount * timeMultiplier * Math.max(price - 1, 1L).toDouble() * 6.0 * stack.toDouble()).toLong().coerceAtLeast(1L)
    }

    open fun getSecondsToSell(): Long {
        var discount = 1.0
        if (MainActivity.data.isApprenticeMerchantPurchased) discount *= 0.8
        if (MainActivity.data.isJourneymanMerchantPurchased) discount *= 0.6
        if (MainActivity.data.isMerchantPackPurchased) discount *= 0.6
        if (MainActivity.data.isTradeBaronPurchased) discount *= 0.4
        val timeMultiplier = Math.pow(0.9, (MainActivity.data.levelMarketTime + MainActivity.data.upgradeMarketTime - 1).toDouble())
        return (discount * timeMultiplier * price.toDouble() * 4.0 * stack.toDouble()).toLong().coerceAtLeast(1L)
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

    open fun getGemValue(): Int? = gemValue
    open fun setGemValue(value: Int?) { gemValue = value }

    open fun isNotSellable(): Boolean = notSellable
    open fun setNotSellable(z: Boolean) { notSellable = z }

    open fun printType(): Int = R.string.type_material

    open fun isConsumable(): Boolean = consumable
    open fun setConsumable(z: Boolean) { consumable = z }
}
