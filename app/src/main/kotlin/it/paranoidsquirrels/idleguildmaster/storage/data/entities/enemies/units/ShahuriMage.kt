package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class ShahuriMage : Enemy() {
    override fun getMaxDamage(): Int = 9
    override fun getMinDamage(): Int = 8
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 65
        baseConstitution = 4
        baseIntelligence = 15
        baseDexterity = 5
        baseDefense = 0
        baseMagicDefense = 50
        currentMana = 100
        imageId = R.drawable.unit_shahuri_mage
        idName = R.string.enemy_shahuri_mage_name
        idDescription = R.string.enemy_shahuri_mage_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_QUICKSAND_GRASP
        expGiven = 30
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("ScrapMetal", 1), 500)
        linkedHashMap.put(ItemWrapper.getInstance("Quartz", 1), 30)
        linkedHashMap.put(ItemWrapper.getInstance("Pineapple", 1), 10)
        return linkedHashMap
    }
}
