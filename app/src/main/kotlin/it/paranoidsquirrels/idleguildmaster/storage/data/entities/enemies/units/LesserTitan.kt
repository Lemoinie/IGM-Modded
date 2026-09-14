package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class LesserTitan : Enemy() {
    override fun getMaxDamage(): Int = 300
    override fun getMinDamage(): Int = 220
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 4150
        baseConstitution = 40
        baseIntelligence = 1
        baseDexterity = 16
        baseDefense = 10
        baseMagicDefense = 0
        statusImmunities.add(StatusEffectType.ABLAZE)
        statusImmunities.add(StatusEffectType.BLEED)
        statusImmunities.add(StatusEffectType.POISON)
        imageId = R.drawable.unit_lesser_titan
        idName = R.string.enemy_lesser_titan_name
        idDescription = R.string.enemy_lesser_titan_description
        passiveSkill = Skills.PASSIVE_INORGANIC
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 300
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("AlchemicPowder", 1), 300)
        linkedHashMap.put(ItemWrapper.getInstance("SentientSlab", 1), 150)
        linkedHashMap.put(ItemWrapper.getInstance("ConstructEgg", 1), 1)
        return linkedHashMap
    }
}
