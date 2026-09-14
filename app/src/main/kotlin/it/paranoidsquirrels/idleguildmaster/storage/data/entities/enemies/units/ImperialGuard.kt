package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class ImperialGuard : Enemy() {
    override fun getMaxDamage(): Int = 34
    override fun getMinDamage(): Int = 30
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 600
        baseConstitution = 35
        baseIntelligence = 10
        baseDexterity = 25
        baseDefense = 30
        baseMagicDefense = 0
        imageId = R.drawable.unit_imperial_guard
        idName = R.string.enemy_imperial_guard_name
        idDescription = R.string.enemy_imperial_guard_description
        currentMana = 100
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_PROTECT_THE_WEAK
        rarity = 1
        expGiven = 92
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("GoldScraps", 1), 400)
        linkedHashMap.put(ItemWrapper.getInstance("CorruptedShield", 1), 1)
        if (i == 1) {
        linkedHashMap.put(ItemWrapper.getInstance("BlackOoze", 1), 200)
        }
        return linkedHashMap
    }
}
