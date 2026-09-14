package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap

class ElectricSlime : Enemy() {
    override fun getMaxDamage(): Int = 35
    override fun getMinDamage(): Int = 26
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 100
        baseConstitution = 40
        baseIntelligence = 2
        baseDexterity = 6
        baseDefense = 40
        baseMagicDefense = 0
        onTargetHit = StatusEffect(StatusEffectType.STUN, this, 2, 1.0)
        onSelfHit = StatusEffect(StatusEffectType.STUN, this, 2, 1.0)
        imageId = R.drawable.unit_electric_slime
        idName = R.string.enemy_electric_slime_name
        idDescription = R.string.enemy_electric_slime_description
        passiveSkill = Skills.PASSIVE_POSITIVE_CHARGE
        activeSkill = Skills.ACTIVE_NONE
        expGiven = 30
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("GreenSlime", 1), 530)
        linkedHashMap.put(ItemWrapper.getInstance("GreenSlime", 2), 200)
        linkedHashMap.put(ItemWrapper.getInstance("GreenSlime", 3), 50)
        linkedHashMap.put(ItemWrapper.getInstance("StaticCore", 1), Logger.BARD_SHIELD)
        linkedHashMap.put(ItemWrapper.getInstance("PotionOfImmunity", 1), 100)
        return linkedHashMap
    }
}
