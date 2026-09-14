package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap

class MagicArmor : Enemy() {
    override fun getMaxDamage(): Int = 135
    override fun getMinDamage(): Int = Logger.BARD_SHIELD
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 400
        baseConstitution = 68
        baseIntelligence = 1
        baseDexterity = 54
        baseDefense = 75
        baseMagicDefense = 75
        retaliationMagicalDamage = 105
        threat = 2
        imageId = R.drawable.unit_magic_armor
        idName = R.string.enemy_magic_armor_name
        idDescription = R.string.enemy_magic_armor_description
        passiveSkill = Skills.PASSIVE_ANIMATED_GUARDIAN
        activeSkill = Skills.ACTIVE_DISASSEMBLE
        rarity = 1
        expGiven = Logger.ARCANE_SUPPRESSION
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("AnimatedScraps", 1), 375)
        linkedHashMap.put(ItemWrapper.getInstance("RadiatingNucleus", 1), 2)
        linkedHashMap.put(ItemWrapper.getInstance("ConstructEgg", 1), 1)
        return linkedHashMap
    }
}
