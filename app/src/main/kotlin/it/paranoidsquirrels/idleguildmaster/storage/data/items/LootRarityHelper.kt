package it.paranoidsquirrels.idleguildmaster.storage.data.items

/**
 * Utility helper to determine if an item is flagged for rare drop visual highlight in claim dialogs.
 */
object LootRarityHelper {

    /**
     * Returns true if [item] has [Item.isRareDrop] set to true.
     */
    @JvmStatic
    fun isUltraRareDrop(item: Item?): Boolean = item?.isRareDrop == true
}
