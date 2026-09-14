package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class LostMiner : Enemy() {
    override fun getMaxDamage(): Int = 162
    override fun getMinDamage(): Int = 88
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 790
        baseConstitution = 8
        baseIntelligence = 20
        baseDexterity = 40
        baseDefense = 0
        baseMagicDefense = 0
        initiative = true
        darknessDamageAmplification = 0.01
        imageId = R.drawable.unit_lost_miner
        idName = R.string.enemy_lost_miner_name
        idDescription = R.string.enemy_lost_miner_description
        passiveSkill = Skills.PASSIVE_NIGHT_HUNTER
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 300
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("ObsidianChunk", 1), 300)
        linkedHashMap.put(ItemWrapper.getInstance("ShadowGem", 1), 200)
        linkedHashMap.put(ItemWrapper.getInstance("PotionOfDarkness", 1), 4)
        return linkedHashMap
    }
}
