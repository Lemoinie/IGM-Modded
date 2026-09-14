package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Pirate : Enemy() {
    override fun getMaxDamage(): Int = 35
    override fun getMinDamage(): Int = 28
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 380
        baseConstitution = 25
        baseIntelligence = 4
        baseDexterity = 20
        baseDefense = 0
        baseMagicDefense = 0
        counterattack = 0.5
        imageId = R.drawable.unit_pirate
        idName = R.string.enemy_pirate_name
        idDescription = R.string.enemy_pirate_description
        passiveSkill = Skills.PASSIVE_RETALIATE
        activeSkill = Skills.ACTIVE_FLINTLOCK_SHOT
        rarity = 1
        expGiven = 30
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("GhostwoodStump", 1), 300)
        linkedHashMap.put(ItemWrapper.getInstance("BlackIronScraps", 1), 200)
        linkedHashMap.put(ItemWrapper.getInstance("FreshSalmon", 1), 12)
        return linkedHashMap
    }
}
