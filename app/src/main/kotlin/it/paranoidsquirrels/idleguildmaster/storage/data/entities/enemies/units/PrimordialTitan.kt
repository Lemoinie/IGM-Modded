package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class PrimordialTitan : Enemy() {
    override fun getMaxDamage(): Int = 330
    override fun getMinDamage(): Int = 280
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 15000
        baseConstitution = 200
        baseIntelligence = 1
        baseDexterity = 80
        baseDefense = 10
        baseMagicDefense = 0
        statusImmunities.add(StatusEffectType.ABLAZE)
        statusImmunities.add(StatusEffectType.BLEED)
        statusImmunities.add(StatusEffectType.POISON)
        imageId = R.drawable.unit_primordial_titan
        idName = R.string.enemy_primordial_titan_name
        idDescription = R.string.enemy_primordial_titan_description
        passiveSkill = Skills.PASSIVE_INORGANIC
        activeSkill = Skills.ACTIVE_FRAGMENTATION
        rarity = 1
        expGiven = 1200
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("ExaltedPowder", 1), 300)
        linkedHashMap.put(ItemWrapper.getInstance("ColossalSword", 1), 100)
        linkedHashMap.put(ItemWrapper.getInstance("PotionOfDefense", 1), 160)
        linkedHashMap.put(ItemWrapper.getInstance("ConstructEgg", 1), 1)
        return linkedHashMap
    }
}
