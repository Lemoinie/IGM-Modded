package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap

class InsaneMerchant : Enemy() {
    override fun getMaxDamage(): Int = 27
    override fun getMinDamage(): Int = 23
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 180
        baseConstitution = 16
        baseIntelligence = 20
        baseDexterity = 5
        baseDefense = 0
        baseMagicDefense = 0
        imageId = R.drawable.unit_insane_merchant
        idName = R.string.enemy_insane_merchant_name
        idDescription = R.string.enemy_insane_merchant_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 19
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("Emerald", 1), 40)
        linkedHashMap.put(ItemWrapper.getInstance("Ruby", 1), 40)
        val itemWrapper = ItemWrapper.getInstance("Ivory", 1)
        val numValueOf = Logger.BARD_SHIELD
        linkedHashMap.put(itemWrapper, numValueOf)
        linkedHashMap.put(ItemWrapper.getInstance("Redwood", 10), 180)
        linkedHashMap.put(ItemWrapper.getInstance("Flute", 1), 8)
        linkedHashMap.put(ItemWrapper.getInstance("Chocolate", 1), numValueOf)
        if (i == 1) {
        linkedHashMap.put(ItemWrapper.getInstance("BlackOoze", 1), 200)
        }
        return linkedHashMap
    }
}
