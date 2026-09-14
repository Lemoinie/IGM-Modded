package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Singularity : Enemy() {
    override fun getMaxDamage(): Int = 1275
    override fun getMinDamage(): Int = 1225
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 30000
        baseConstitution = 100
        baseIntelligence = 100
        baseDexterity = 100
        baseDefense = 0
        baseMagicDefense = 0
        immunityToStatus = 0.8
        imageId = R.drawable.unit_singularity
        idName = R.string.enemy_singularity_name
        idDescription = R.string.enemy_singularity_description
        passiveSkill = Skills.PASSIVE_INFINITY
        activeSkill = Skills.ACTIVE_GRAVITY_SHIFT
        rarity = 1
        expGiven = 12000
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("FlakeOfInfinity", 1), 960)
        linkedHashMap.put(ItemWrapper.getInstance("InfinityHat", 1), 40)
        return linkedHashMap
    }
    override fun getCurrentMana(): Int = 100
}
