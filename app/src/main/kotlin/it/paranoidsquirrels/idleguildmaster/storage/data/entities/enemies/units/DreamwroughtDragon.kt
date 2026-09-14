package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class DreamwroughtDragon : Enemy() {
    override fun getMaxDamage(): Int = 1150
    override fun getMinDamage(): Int = 900
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 12500
        baseConstitution = 315
        baseIntelligence = 100
        baseDexterity = 400
        baseDefense = 10
        baseMagicDefense = 0
        flying = true
        imageId = R.drawable.unit_dreamwrought_dragon
        idName = R.string.enemy_dreamwrought_dragon_name
        idDescription = R.string.enemy_dreamwrought_dragon_description
        passiveSkill = Skills.PASSIVE_FLYING
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 550
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("DreamwroughtHide", 1), 900)
        return linkedHashMap
    }
}
