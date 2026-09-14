package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class InsanePriest : Enemy() {
    override fun getMaxDamage(): Int = 42
    override fun getMinDamage(): Int = 40
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 200
        baseConstitution = 12
        baseIntelligence = 30
        baseDexterity = 12
        baseDefense = 0
        baseMagicDefense = 30
        imageId = R.drawable.unit_insane_priest
        idName = R.string.enemy_insane_priest_name
        idDescription = R.string.enemy_insane_priest_description
        healer = true
        passiveSkill = Skills.PASSIVE_HEALER_I
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 35
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("SilkThread", 1), 300)
        linkedHashMap.put(ItemWrapper.getInstance("GoldScraps", 1), 100)
        linkedHashMap.put(ItemWrapper.getInstance("HolyWater", 1), 2)
        linkedHashMap.put(ItemWrapper.getInstance("MitreHat", 1), 1)
        if (i == 1) {
        linkedHashMap.put(ItemWrapper.getInstance("BlackOoze", 1), 200)
        }
        return linkedHashMap
    }
}
