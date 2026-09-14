package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Lazarus : Enemy() {
    override fun getMaxDamage(): Int = 4000
    override fun getMinDamage(): Int = 2800
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 28500
        baseConstitution = 80
        baseIntelligence = 200
        baseDexterity = 250
        baseDefense = 0
        baseMagicDefense = 0
        baseLifesteal = 200
        imageId = R.drawable.unit_lazarus
        idName = R.string.enemy_lazarus_name
        idDescription = R.string.enemy_lazarus_description
        passiveSkill = Skills.PASSIVE_TRUE_LIFESTEAL
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 5000
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("AncestralBlood", 1), 400)
        return linkedHashMap
    }
}
