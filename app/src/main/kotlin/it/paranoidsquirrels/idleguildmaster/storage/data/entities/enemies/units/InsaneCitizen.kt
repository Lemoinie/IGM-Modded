package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class InsaneCitizen : Enemy() {
    override fun getMaxDamage(): Int = 27
    override fun getMinDamage(): Int = 23
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 200
        baseConstitution = 16
        baseIntelligence = 8
        baseDexterity = 5
        baseDefense = 0
        baseMagicDefense = 0
        imageId = R.drawable.unit_insane_citizen
        idName = R.string.enemy_insane_citizen_name
        idDescription = R.string.enemy_insane_citizen_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 19
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("SilverRing", 1), 5)
        linkedHashMap.put(ItemWrapper.getInstance("SilkThread", 1), 100)
        linkedHashMap.put(ItemWrapper.getInstance("Potato", 1), 25)
        if (i == 1) {
        linkedHashMap.put(ItemWrapper.getInstance("BlackOoze", 1), 200)
        }
        return linkedHashMap
    }
}
