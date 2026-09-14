package it.paranoidsquirrels.idleguildmaster.storage.data.items

class ItemWrapper private constructor() {
    var item: Item? = null
        private set

    companion object {
        @JvmStatic
        fun getInstance(str: String): ItemWrapper {
            return getInstance(str, 1)
        }

        @JvmStatic
        fun getInstance(str: String, i: Int): ItemWrapper {
            val itemWrapper = ItemWrapper()
            itemWrapper.item = Item.getInstance(str, i)
            return itemWrapper
        }
    }
}
