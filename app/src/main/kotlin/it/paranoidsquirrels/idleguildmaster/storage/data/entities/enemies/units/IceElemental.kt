package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class IceElemental : Enemy() {
    override fun getMaxDamage(): Int = 55
    override fun getMinDamage(): Int = 20
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 2000
        baseConstitution = 3
        baseIntelligence = 33
        baseDexterity = 3
        baseDefense = 0
        baseMagicDefense = 50
        onSelfHit = StatusEffect(StatusEffectType.FROZEN, this, 4, 1.0)
        onTargetHit = StatusEffect(StatusEffectType.FROZEN, this, 4, 1.0)
        imageId = R.drawable.unit_ice_elemental
        idName = R.string.enemy_ice_elemental_name
        idDescription = R.string.enemy_ice_elemental_description
        passiveSkill = Skills.PASSIVE_SUB_ZERO
        activeSkill = Skills.ACTIVE_ICE_TOMB
        rarity = 1
        expGiven = 280
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("FrostmetalOre", 1), 500)
        linkedHashMap.put(ItemWrapper.getInstance("FrostCrystal", 1), 50)
        linkedHashMap.put(ItemWrapper.getInstance("FrostNucleus", 1), 5)
        linkedHashMap.put(ItemWrapper.getInstance("EsotericEgg", 1), 1)
        return linkedHashMap
    }
}
