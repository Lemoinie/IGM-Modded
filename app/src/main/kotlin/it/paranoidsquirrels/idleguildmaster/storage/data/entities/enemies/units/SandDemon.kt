package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class SandDemon : Enemy() {
    override fun getMaxDamage(): Int = 46
    override fun getMinDamage(): Int = 30
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 950
        baseConstitution = 46
        baseIntelligence = 2
        baseDexterity = 16
        baseDefense = 0
        baseMagicDefense = 50
        statusImmunities.add(StatusEffectType.ABLAZE)
        statusImmunities.add(StatusEffectType.BLEED)
        statusImmunities.add(StatusEffectType.POISON)
        imageId = R.drawable.unit_sand_demon
        idName = R.string.enemy_sand_demon_name
        idDescription = R.string.enemy_sand_demon_description
        passiveSkill = Skills.PASSIVE_INORGANIC
        activeSkill = Skills.ACTIVE_NONE
        expGiven = 36
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("MetamorphicSand", 1), 1000)
        return linkedHashMap
    }
}
