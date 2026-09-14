package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap

class Dryad : Enemy() {
    override fun getMaxDamage(): Int = 280
    override fun getMinDamage(): Int = 150
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 670
        baseConstitution = 4
        baseIntelligence = 150
        baseDexterity = 60
        baseDefense = 0
        baseMagicDefense = 30
        healer = true
        imageId = R.drawable.unit_dryad
        idName = R.string.enemy_dryad_name
        idDescription = R.string.enemy_dryad_description
        passiveSkill = Skills.PASSIVE_HEALER_I
        activeSkill = Skills.ACTIVE_DAZE
        rarity = 1
        expGiven = 200
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("FleetfootFabric", 1), 350)
        linkedHashMap.put(ItemWrapper.getInstance("BagOfChokingPowder", 1), 100)
        linkedHashMap.put(ItemWrapper.getInstance("WhiteHair", 1), 15)
        linkedHashMap.put(ItemWrapper.getInstance("SylvanFlute", 1), 10)
        linkedHashMap.put(ItemWrapper.getInstance("MeatyMushroom", 1), Logger.BARD_SHIELD)
        linkedHashMap.put(ItemWrapper.getInstance("PotionOfAgility", 1), 2)
        return linkedHashMap
    }
}
