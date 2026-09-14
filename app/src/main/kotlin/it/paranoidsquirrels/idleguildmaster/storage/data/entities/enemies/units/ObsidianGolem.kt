package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class ObsidianGolem : Enemy() {
    override fun getMaxDamage(): Int = 25
    override fun getMinDamage(): Int = 20
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 1200
        baseConstitution = 30
        baseIntelligence = 1
        baseDexterity = 1
        baseDefense = 0
        baseMagicDefense = 100
        imageId = R.drawable.unit_obsidian_golem
        idName = R.string.enemy_obsidian_golem_name
        idDescription = R.string.enemy_obsidian_golem_description
        passiveSkill = Skills.PASSIVE_DEFLECT_MAGIC
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 84
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("ObsidianChunk", 1), 600)
        linkedHashMap.put(ItemWrapper.getInstance("ConstructEgg", 1), 1)
        return linkedHashMap
    }
}
