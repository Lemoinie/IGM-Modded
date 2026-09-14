package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Beholder : Enemy() {
    override fun getMaxDamage(): Int = 46
    override fun getMinDamage(): Int = 38
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 1100
        baseConstitution = 2
        baseIntelligence = 100
        baseDexterity = 15
        baseDefense = 0
        baseMagicDefense = 30
        imageId = R.drawable.unit_beholder
        idName = R.string.enemy_beholder_name
        idDescription = R.string.enemy_beholder_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_ARCANE_BARRAGE
        rarity = 1
        expGiven = 125
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("EldritchTendril", 1), 500)
        linkedHashMap.put(ItemWrapper.getInstance("LargeIris", 1), 60)
        linkedHashMap.put(ItemWrapper.getInstance("EsotericEgg", 1), 1)
        return linkedHashMap
    }
}
