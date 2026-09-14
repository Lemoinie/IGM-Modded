package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class ImperialMage : Enemy() {
    override fun getMaxDamage(): Int = 29
    override fun getMinDamage(): Int = 26
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 300
        baseConstitution = 15
        baseIntelligence = 40
        baseDexterity = 20
        baseDefense = 0
        baseMagicDefense = 30
        imageId = R.drawable.unit_imperial_mage
        idName = R.string.enemy_imperial_mage_name
        idDescription = R.string.enemy_imperial_mage_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_STATIC_SURGE
        rarity = 1
        expGiven = 92
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("GoldScraps", 1), 400)
        linkedHashMap.put(ItemWrapper.getInstance("CorruptedStaff", 1), 1)
        linkedHashMap.put(ItemWrapper.getInstance("PotionOfIntelligence", 1), 4)
        if (i == 1) {
        linkedHashMap.put(ItemWrapper.getInstance("BlackOoze", 1), 200)
        }
        return linkedHashMap
    }
}
