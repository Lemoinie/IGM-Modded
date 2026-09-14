package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap

class TrollShaman : Enemy() {
    override fun getMaxDamage(): Int = 77
    override fun getMinDamage(): Int = 73
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 540
        baseConstitution = 10
        baseIntelligence = 2
        baseDexterity = 4
        baseDefense = 40
        baseMagicDefense = 30
        healer = true
        cleanser = true
        regeneration = 20
        imageId = R.drawable.unit_troll_shaman
        idName = R.string.enemy_troll_shaman_name
        idDescription = R.string.enemy_troll_shaman_description
        passiveSkill = Skills.PASSIVE_TROLL_MAGIC
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = Logger.SUMMON_SMOLDERING_TITAN
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("TrollHide", 1), 200)
        linkedHashMap.put(ItemWrapper.getInstance("Winterwood", 1), 150)
        linkedHashMap.put(ItemWrapper.getInstance("FrostmetalOre", 1), 150)
        linkedHashMap.put(ItemWrapper.getInstance("IceFiber", 1), 150)
        linkedHashMap.put(ItemWrapper.getInstance("Blueberry", 1), 40)
        linkedHashMap.put(ItemWrapper.getInstance("PotionOfHealth", 1), 4)
        return linkedHashMap
    }
}
