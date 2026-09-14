package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class SmolderingTitan : Enemy() {
    override fun getMaxDamage(): Int = 550
    override fun getMinDamage(): Int = 500
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 6850
        baseConstitution = 340
        baseIntelligence = 28
        baseDexterity = 10
        baseDefense = 35
        baseMagicDefense = 0
        statusImmunities.add(StatusEffectType.ABLAZE)
        onSelfHit = StatusEffect(StatusEffectType.ABLAZE, null, 1, 1.0)
        imageId = R.drawable.unit_smoldering_titan
        idName = R.string.enemy_smoldering_titan_name
        idDescription = R.string.enemy_smoldering_titan_description
        passiveSkill = Skills.PASSIVE_FIRE_GIANT
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 3750
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("Infernite", 1), 1000)
        return linkedHashMap
    }
}
