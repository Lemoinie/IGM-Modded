package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Necrobot : Enemy() {
    override fun getMaxDamage(): Int = 750
    override fun getMinDamage(): Int = 600
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 10000
        baseConstitution = 140
        baseIntelligence = 1
        baseDexterity = 140
        baseDefense = 0
        baseMagicDefense = 0
        onTargetHit = StatusEffect(StatusEffectType.BLEED, this, 40, 1.0)
        imageId = R.drawable.unit_necrobot
        idName = R.string.enemy_necrobot_name
        idDescription = R.string.enemy_necrobot_description
        passiveSkill = Skills.PASSIVE_SHARP_BLADES
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 480
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("OrichalcumScraps", 1), 750)
        return linkedHashMap
    }
}
