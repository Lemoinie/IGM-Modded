package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Crusader : Enemy() {
    override fun getMaxDamage(): Int = 80
    override fun getMinDamage(): Int = 55
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 940
        baseConstitution = 16
        baseIntelligence = 4
        baseDexterity = 19
        baseDefense = 0
        baseMagicDefense = 0
        retaliationMagicalDamage = 20
        imageId = R.drawable.unit_crusader
        idName = R.string.enemy_crusader_name
        idDescription = R.string.enemy_crusader_description
        passiveSkill = Skills.PASSIVE_LESSER_PSYONIC
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 72
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("KabelianMetal", 1), 150)
        linkedHashMap.put(ItemWrapper.getInstance("CrusaderInsigna", 1), 20)
        return linkedHashMap
    }
}
