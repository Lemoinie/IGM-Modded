package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class GiantSpider : Enemy() {
    override fun getMaxDamage(): Int = 60
    override fun getMinDamage(): Int = 30
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 600
        baseConstitution = 10
        baseIntelligence = 2
        baseDexterity = 35
        baseDefense = 0
        baseMagicDefense = 0
        onTargetHit = StatusEffect(StatusEffectType.POISON, this, 10, 1.0)
        imageId = R.drawable.unit_giant_spider
        idName = R.string.enemy_giant_spider_name
        idDescription = R.string.enemy_giant_spider_description
        passiveSkill = Skills.PASSIVE_VENOMOUS_BITE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 58
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("CobwebBundle", 1), 300)
        linkedHashMap.put(ItemWrapper.getInstance("SpiderLeg", 1), 200)
        linkedHashMap.put(ItemWrapper.getInstance("InsectEgg", 1), 1)
        return linkedHashMap
    }
}
