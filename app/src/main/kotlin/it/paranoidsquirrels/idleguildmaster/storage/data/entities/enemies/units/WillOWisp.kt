package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class WillOWisp : Enemy() {
    override fun getMaxDamage(): Int = 13
    override fun getMinDamage(): Int = 10
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 90
        baseConstitution = 8
        baseIntelligence = 15
        baseDexterity = 20
        baseDefense = 100
        baseMagicDefense = 0
        imageId = R.drawable.unit_will_o_wisp
        idName = R.string.enemy_will_o_wisp_name
        idDescription = R.string.enemy_will_o_wisp_description
        passiveSkill = Skills.PASSIVE_INCORPOREAL
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 38
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("SpiritTome", 1), 10)
        linkedHashMap.put(ItemWrapper.getInstance("SpiritCandle", 1), 30)
        linkedHashMap.put(ItemWrapper.getInstance("SpectralCloth", 1), 700)
        linkedHashMap.put(ItemWrapper.getInstance("EsotericEgg", 1), 1)
        return linkedHashMap
    }
}
