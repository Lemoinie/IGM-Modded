package it.paranoidsquirrels.idleguildmaster.storage.data.items

import com.google.gson.annotations.SerializedName
import java.util.Objects

class MerchantOffer(
    var item: Item? = null
) {
    var price: Long = 0L

    @SerializedName("gems")
    var isGems: Boolean = false

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MerchantOffer) return false
        return price == other.price && isGems == other.isGems && item == other.item
    }

    override fun hashCode(): Int {
        return Objects.hash(price, isGems, item)
    }
}
