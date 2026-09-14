package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.ArrayList
import java.util.LinkedHashMap

class Thorvus : Enemy() {
    @Transient private var onHit: MutableList<StatusEffect> = ArrayList()
    override fun getMaxDamage(): Int = 176
    override fun getMinDamage(): Int = 168
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 4450
        baseConstitution = 14
        baseIntelligence = 68
        baseDexterity = 20
        baseDefense = 0
        baseMagicDefense = 50
        val arrayList = ArrayList<StatusEffect>()
        onHit = arrayList
        arrayList.add(StatusEffect(StatusEffectType.ABLAZE, this, 2, 1.0))
        onHit.add(StatusEffect(StatusEffectType.FROZEN, this, 2, 1.0))
        imageId = R.drawable.unit_thorvus
        idName = R.string.enemy_thorvus_name
        idDescription = R.string.enemy_thorvus_description
        passiveSkill = Skills.PASSIVE_ELEMENTAL_DUALITY
        activeSkill = Skills.ACTIVE_ARCANE_DIFFUSION
        rarity = 1
        expGiven = 500
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("EternalHunger", 1), 100)
        linkedHashMap.put(ItemWrapper.getInstance("ElixirOfLearning", 1), 20)
        linkedHashMap.put(ItemWrapper.getInstance("PotionOfMagicDefense", 1), 100)
        return linkedHashMap
    }
    override fun onTargetHitEffects(): List<StatusEffect> = onHit
}
