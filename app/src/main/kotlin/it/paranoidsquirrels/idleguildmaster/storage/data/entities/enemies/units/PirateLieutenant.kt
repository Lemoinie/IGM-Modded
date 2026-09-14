package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class PirateLieutenant : Enemy() {
    override fun getMaxDamage(): Int = 43
    override fun getMinDamage(): Int = 30
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 600
        baseConstitution = 30
        baseIntelligence = 8
        baseDexterity = 25
        baseDefense = 0
        baseMagicDefense = 0
        counterattack = 0.5
        imageId = R.drawable.unit_pirate_lieutenant
        idName = R.string.enemy_pirate_lieutenant_name
        idDescription = R.string.enemy_pirate_lieutenant_description
        passiveSkill = Skills.PASSIVE_RETALIATE
        activeSkill = Skills.ACTIVE_FLINTLOCK_SHOT
        rarity = 1
        expGiven = 132
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("GhostwoodStump", 1), 375)
        linkedHashMap.put(ItemWrapper.getInstance("BlackIronScraps", 1), 379)
        linkedHashMap.put(ItemWrapper.getInstance("ExoticVelvet", 1), 200)
        linkedHashMap.put(ItemWrapper.getInstance("FreshTuna", 1), 20)
        linkedHashMap.put(ItemWrapper.getInstance("PotionOfDexterity", 1), 1)
        return linkedHashMap
    }
}
