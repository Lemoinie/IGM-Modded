package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Claris : Enemy() {
    override fun getMaxDamage(): Int = 188
    override fun getMinDamage(): Int = 182
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 3200
        baseConstitution = 6
        baseIntelligence = 84
        baseDexterity = 26
        baseDefense = 0
        baseMagicDefense = 50
        onTargetHit = StatusEffect(StatusEffectType.STUN, this, 3, 1.0)
        imageId = R.drawable.unit_claris
        idName = R.string.enemy_claris_name
        idDescription = R.string.enemy_claris_description
        passiveSkill = Skills.PASSIVE_STATIC_AFFINITY
        activeSkill = Skills.ACTIVE_ARCANE_DIFFUSION
        rarity = 1
        expGiven = 540
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("SealOfClaris", 1), 50)
        linkedHashMap.put(ItemWrapper.getInstance("ElixirOfLearning", 1), 20)
        linkedHashMap.put(ItemWrapper.getInstance("PotionOfMagicDefense", 1), 100)
        return linkedHashMap
    }
}
