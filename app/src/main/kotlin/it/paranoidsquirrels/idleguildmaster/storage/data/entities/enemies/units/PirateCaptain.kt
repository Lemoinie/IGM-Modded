package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class PirateCaptain : Enemy() {
    override fun getMaxDamage(): Int = 54
    override fun getMinDamage(): Int = 40
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 800
        baseConstitution = 40
        baseIntelligence = 8
        baseDexterity = 35
        baseDefense = 0
        baseMagicDefense = 0
        currentMana = 50
        counterattack = 0.5
        imageId = R.drawable.unit_pirate_captain
        idName = R.string.enemy_pirate_captain_name
        idDescription = R.string.enemy_pirate_captain_description
        passiveSkill = Skills.PASSIVE_RETALIATE
        activeSkill = Skills.ACTIVE_FLINTLOCK_SHOT
        rarity = 1
        expGiven = 264
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("GhostwoodStump", 1), 375)
        linkedHashMap.put(ItemWrapper.getInstance("BlackIronScraps", 1), 378)
        linkedHashMap.put(ItemWrapper.getInstance("ExoticVelvet", 1), 200)
        linkedHashMap.put(ItemWrapper.getInstance("FreshTuna", 1), 23)
        linkedHashMap.put(ItemWrapper.getInstance("PotionOfDexterity", 1), 2)
        return linkedHashMap
    }
}
