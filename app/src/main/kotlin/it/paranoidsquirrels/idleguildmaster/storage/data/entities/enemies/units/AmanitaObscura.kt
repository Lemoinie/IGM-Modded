package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.ArrayList
import java.util.LinkedHashMap

class AmanitaObscura : Enemy() {
    @Transient private var onHit: MutableList<StatusEffect> = ArrayList()
    override fun getMaxDamage(): Int = 190
    override fun getMinDamage(): Int = 150
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 450
        baseConstitution = 14
        baseIntelligence = 1
        baseDexterity = 4
        baseDefense = 0
        baseMagicDefense = 0
        imageId = R.drawable.unit_amanita_obscura
        idName = R.string.enemy_amanita_obscura_name
        idDescription = R.string.enemy_amanita_obscura_description
        passiveSkill = Skills.PASSIVE_NEUROTOXICITY
        activeSkill = Skills.ACTIVE_NONE
        val arrayList = ArrayList<StatusEffect>()
        onHit = arrayList
        arrayList.add(StatusEffect(StatusEffectType.POISON, this, 3, 1.0))
        onHit.add(StatusEffect(StatusEffectType.STUN, this, 1, 1.0))
        rarity = 1
        expGiven = 188
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("PoisonousFlesh", 1), 10)
        return linkedHashMap
    }
    override fun onTargetHitEffects(): List<StatusEffect> = onHit

    override fun onSelfHitEffects(): List<StatusEffect> = onHit
}
