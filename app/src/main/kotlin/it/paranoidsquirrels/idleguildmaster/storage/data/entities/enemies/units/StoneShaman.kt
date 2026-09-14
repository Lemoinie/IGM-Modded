package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap

class StoneShaman : Enemy() {
    override fun getMaxDamage(): Int = 350
    override fun getMinDamage(): Int = 180
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 1200
        baseConstitution = 40
        baseIntelligence = Logger.BOTCHED_OFFERING
        baseDexterity = 2
        baseDefense = 0
        baseMagicDefense = 90
        healer = true
        cleanser = true
        imageId = R.drawable.unit_stone_shaman
        idName = R.string.enemy_stone_shaman_name
        idDescription = R.string.enemy_stone_shaman_description
        passiveSkill = Skills.PASSIVE_NATURAL_EMPATHY
        activeSkill = Skills.ACTIVE_FIRE_DANCE
        rarity = 1
        expGiven = 270
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("Kindlequartz", 1), 4)
        return linkedHashMap
    }
}
