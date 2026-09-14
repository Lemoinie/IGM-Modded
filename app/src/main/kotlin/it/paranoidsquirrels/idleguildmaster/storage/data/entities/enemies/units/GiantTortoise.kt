package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class GiantTortoise : Enemy() {
    override fun getMaxDamage(): Int = 55
    override fun getMinDamage(): Int = 40
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 1400
        baseConstitution = 60
        baseIntelligence = 2
        baseDexterity = 1
        baseDefense = 50
        baseMagicDefense = 0
        onSelfHit = StatusEffect(StatusEffectType.BLEED, this, 25, 1.0)
        imageId = R.drawable.unit_giant_tortoise
        idName = R.string.enemy_giant_tortoise_name
        idDescription = R.string.enemy_giant_tortoise_description
        passiveSkill = Skills.PASSIVE_SHARP_SPIKES
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 70
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("GiantShellFragment", 1), 500)
        linkedHashMap.put(ItemWrapper.getInstance("TortoiseThorn", 1), 50)
        linkedHashMap.put(ItemWrapper.getInstance("Egg", 1), 25)
        linkedHashMap.put(ItemWrapper.getInstance("ReptileEgg", 1), 1)
        return linkedHashMap
    }
}
