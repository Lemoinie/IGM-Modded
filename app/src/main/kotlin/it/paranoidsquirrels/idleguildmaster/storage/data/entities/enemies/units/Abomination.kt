package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Abomination : Enemy() {
    override fun getMaxDamage(): Int = 35
    override fun getMinDamage(): Int = 30
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 1000
        baseConstitution = 20
        baseIntelligence = 1
        baseDexterity = 2
        baseDefense = 50
        baseMagicDefense = 0
        imageId = R.drawable.unit_abomination
        idName = R.string.enemy_abomination_name
        idDescription = R.string.enemy_abomination_description
        onTargetHit = StatusEffect(StatusEffectType.STUN, this, 2, 1.0)
        passiveSkill = Skills.PASSIVE_MASSIVE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 196
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("SoulShard", 1), 50)
        linkedHashMap.put(ItemWrapper.getInstance("BoneFragment", 3), 946)
        linkedHashMap.put(ItemWrapper.getInstance("PotionOfConstitution", 1), 4)
        return linkedHashMap
    }
}
