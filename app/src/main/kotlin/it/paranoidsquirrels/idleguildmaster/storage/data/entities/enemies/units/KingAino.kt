package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class KingAino : Enemy() {
    override fun getMaxDamage(): Int = 3500
    override fun getMinDamage(): Int = 2500
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 25000
        baseConstitution = 200
        baseIntelligence = 2
        baseDexterity = 200
        baseDefense = 0
        baseMagicDefense = 0
        onTargetHit = StatusEffect(StatusEffectType.STUN, this, 4, 1.0)
        imageId = R.drawable.unit_king_aino
        idName = R.string.enemy_king_aino_name
        idDescription = R.string.enemy_king_aino_description
        passiveSkill = Skills.PASSIVE_GARGANTUAN
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 5500
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("OrichalcumScraps", 5), 950)
        linkedHashMap.put(ItemWrapper.getInstance("SPIDER", 1), 50)
        return linkedHashMap
    }
}
