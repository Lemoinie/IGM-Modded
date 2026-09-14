package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class VampireBat : Enemy() {
    override fun getMaxDamage(): Int = 52
    override fun getMinDamage(): Int = 28
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 350
        baseConstitution = 2
        baseIntelligence = 2
        baseDexterity = 65
        baseDefense = 0
        baseMagicDefense = 0
        flying = true
        baseLifesteal = 100
        imageId = R.drawable.unit_vampire_bat
        idName = R.string.enemy_vampire_bat_name
        idDescription = R.string.enemy_vampire_bat_description
        passiveSkill = Skills.PASSIVE_FLYING_LEECH
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 58
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("BatWing", 1), 300)
        linkedHashMap.put(ItemWrapper.getInstance("BatTooth", 1), 200)
        linkedHashMap.put(ItemWrapper.getInstance("AvianEgg", 1), 1)
        return linkedHashMap
    }
}
