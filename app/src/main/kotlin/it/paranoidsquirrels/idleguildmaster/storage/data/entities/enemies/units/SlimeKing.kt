package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.ArrayList
import java.util.LinkedHashMap

class SlimeKing : Enemy() {
    @Transient private var onHit: MutableList<StatusEffect> = ArrayList()
    override fun getMaxDamage(): Int = 50
    override fun getMinDamage(): Int = 40
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 1000
        baseConstitution = 38
        baseIntelligence = 5
        baseDexterity = 8
        baseDefense = 40
        baseMagicDefense = 0
        alwaysHits = true
        immunityToStatus = 0.5
        imageId = R.drawable.unit_slime_king
        idName = R.string.enemy_slime_king_name
        idDescription = R.string.enemy_slime_king_description
        passiveSkill = Skills.PASSIVE_DISSOLVE_BY_DECREE
        activeSkill = Skills.ACTIVE_NONE
        val arrayList = ArrayList<StatusEffect>()
        onHit = arrayList
        arrayList.add(StatusEffect(StatusEffectType.POISON, this, 3, 0.7))
        onHit.add(StatusEffect(StatusEffectType.SILENCE, this, 3, 0.7))
        onHit.add(StatusEffect(StatusEffectType.FROZEN, this, 3, 0.7))
        onHit.add(StatusEffect(StatusEffectType.ABLAZE, this, 3, 0.7))
        onHit.add(StatusEffect(StatusEffectType.STUN, this, 3, 0.7))
        expGiven = 240
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("GreenSlime", 1), 210)
        linkedHashMap.put(ItemWrapper.getInstance("GreenSlime", 2), 500)
        linkedHashMap.put(ItemWrapper.getInstance("GreenSlime", 3), 250)
        linkedHashMap.put(ItemWrapper.getInstance("SlimeKingsCrown", 1), 30)
        linkedHashMap.put(ItemWrapper.getInstance("SeekingGlass", 1), 10)
        return linkedHashMap
    }
    override fun onTargetHitEffects(): List<StatusEffect> = onHit
}
