package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Gcss : Enemy() {
    override fun getMaxDamage(): Int = 900
    override fun getMinDamage(): Int = 600
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 5000
        baseConstitution = 400
        baseIntelligence = 1
        baseDexterity = 45
        baseDefense = 35
        baseMagicDefense = 0
        statusImmunities.add(StatusEffectType.ABLAZE)
        statusImmunities.add(StatusEffectType.BLEED)
        statusImmunities.add(StatusEffectType.POISON)
        imageId = R.drawable.unit_gcss
        idName = R.string.enemy_gcss_name
        idDescription = R.string.enemy_gcss_description
        passiveSkill = Skills.PASSIVE_INORGANIC
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 300
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("Synapse", 1), 1000)
        return linkedHashMap
    }
}
