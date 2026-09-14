package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class GiantMoth : Enemy() {
    override fun getMaxDamage(): Int = 95
    override fun getMinDamage(): Int = 70
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 480
        baseConstitution = 7
        baseIntelligence = 2
        baseDexterity = 42
        baseDefense = 0
        baseMagicDefense = 0
        currentMana = 100
        flying = true
        imageId = R.drawable.unit_giant_moth
        idName = R.string.enemy_giant_moth_name
        idDescription = R.string.enemy_giant_moth_description
        passiveSkill = Skills.PASSIVE_FLYING
        activeSkill = Skills.ACTIVE_CHOKING_POWDER
        rarity = 1
        expGiven = 70
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("GiantMothWing", 1), 550)
        linkedHashMap.put(ItemWrapper.getInstance("InsectEgg", 1), 1)
        return linkedHashMap
    }
}
