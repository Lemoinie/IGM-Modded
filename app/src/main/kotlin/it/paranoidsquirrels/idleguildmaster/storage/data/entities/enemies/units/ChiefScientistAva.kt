package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap

class ChiefScientistAva : Enemy() {
    override fun getMaxDamage(): Int = 2500
    override fun getMinDamage(): Int = 750
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 15000
        baseConstitution = 18
        baseIntelligence = 375
        baseDexterity = 12
        baseDefense = 0
        baseMagicDefense = 0
        poisonBonus = 30
        immunityToStatus = 0.8
        healer = true
        cleanser = true
        imageId = R.drawable.unit_chief_scientist_ava
        idName = R.string.enemy_chief_scientist_ava_name
        idDescription = R.string.enemy_chief_scientist_ava_description
        passiveSkill = Skills.PASSIVE_UNETHICAL_CONDUCT
        activeSkill = Skills.ACTIVE_LIVE_TEST
        rarity = 1
        expGiven = 4000
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("KaunianFabric", 1), 830)
        linkedHashMap.put(ItemWrapper.getInstance("PotionOfClumsiness", 1), Logger.BARD_SHIELD)
        linkedHashMap.put(ItemWrapper.getInstance("ChiefScientistCoat", 1), 50)
        return linkedHashMap
    }
}
