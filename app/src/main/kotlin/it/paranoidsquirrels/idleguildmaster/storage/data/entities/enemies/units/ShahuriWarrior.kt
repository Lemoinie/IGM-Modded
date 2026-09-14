package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class ShahuriWarrior : Enemy() {
    override fun getMaxDamage(): Int = 8
    override fun getMinDamage(): Int = 6
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 145
        baseConstitution = 12
        baseIntelligence = 8
        baseDexterity = 5
        baseDefense = 20
        baseMagicDefense = 50
        imageId = R.drawable.unit_shahuri_warrior
        idName = R.string.enemy_shahuri_warrior_name
        idDescription = R.string.enemy_shahuri_warrior_description
        threat = 2
        passiveSkill = Skills.PASSIVE_THREATENING_I
        activeSkill = Skills.ACTIVE_NONE
        expGiven = 30
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("ScrapMetal", 1), 500)
        linkedHashMap.put(ItemWrapper.getInstance("Pineapple", 1), 10)
        linkedHashMap.put(ItemWrapper.getInstance("RecurveBlade", 1), 30)
        return linkedHashMap
    }
}
