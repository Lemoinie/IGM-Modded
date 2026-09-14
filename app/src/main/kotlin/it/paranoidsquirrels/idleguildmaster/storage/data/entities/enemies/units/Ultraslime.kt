package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Ultraslime : Enemy() {
    override fun getMaxDamage(): Int = 1860
    override fun getMinDamage(): Int = 920
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 99999
        baseConstitution = 1000
        baseIntelligence = 100
        baseDexterity = 125
        baseDefense = 0
        baseMagicDefense = 0
        immunityToStatus = 1.0
        imageId = R.drawable.unit_ultraslime
        idName = R.string.enemy_ultraslime_name
        idDescription = R.string.enemy_ultraslime_description
        passiveSkill = Skills.PASSIVE_PERFECT_IMMUNITY
        activeSkill = Skills.ACTIVE_BOUNCE
        rarity = 1
        expGiven = 99999
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("WhiteSlime", 1), 500)
        return linkedHashMap
    }
}
