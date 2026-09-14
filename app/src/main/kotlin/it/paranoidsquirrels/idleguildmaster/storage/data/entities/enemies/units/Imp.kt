package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.ArrayList
import java.util.LinkedHashMap

class Imp : Enemy() {
    @Transient private var onHit: MutableList<StatusEffect> = ArrayList()
    override fun getMaxDamage(): Int = 180
    override fun getMinDamage(): Int = 130
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 440
        baseConstitution = 50
        baseIntelligence = 1
        baseDexterity = 94
        baseDefense = 0
        baseMagicDefense = 0
        flying = true
        val arrayList = ArrayList<StatusEffect>()
        onHit = arrayList
        arrayList.add(StatusEffect(StatusEffectType.POISON, this, 12, 1.0))
        onHit.add(StatusEffect(StatusEffectType.BLEED, this, 12, 1.0))
        imageId = R.drawable.unit_imp
        idName = R.string.enemy_imp_name
        idDescription = R.string.enemy_imp_description
        passiveSkill = Skills.PASSIVE_FLYING_DISEASE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = Logger.ARCANE_SUPPRESSION
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("SpellwovenHide", 1), 400)
        return linkedHashMap
    }
    override fun onTargetHitEffects(): List<StatusEffect> = onHit
}
