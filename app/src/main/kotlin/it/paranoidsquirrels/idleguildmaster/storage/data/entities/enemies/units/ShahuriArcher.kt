package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class ShahuriArcher : Enemy() {
    override fun getMaxDamage(): Int = 13
    override fun getMinDamage(): Int = 9
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 70
        baseConstitution = 8
        baseIntelligence = 10
        baseDexterity = 25
        baseDefense = 0
        baseMagicDefense = 50
        onTargetHit = StatusEffect(StatusEffectType.STUN, this, 1, 0.1)
        imageId = R.drawable.unit_shahuri_archer
        idName = R.string.enemy_shahuri_archer_name
        idDescription = R.string.enemy_shahuri_archer_description
        passiveSkill = Skills.PASSIVE_DESERT_ARCHER
        activeSkill = Skills.ACTIVE_NONE
        expGiven = 30
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("ScrapMetal", 1), 500)
        linkedHashMap.put(ItemWrapper.getInstance("Pineapple", 1), 10)
        linkedHashMap.put(ItemWrapper.getInstance("ShahuriBowFrame", 1), 30)
        return linkedHashMap
    }
}
