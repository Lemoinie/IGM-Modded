package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class PrimevalWurm : Enemy() {
    override fun getMaxDamage(): Int = 595
    override fun getMinDamage(): Int = 540
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 16000
        baseConstitution = 215
        baseIntelligence = 1
        baseDexterity = 70
        baseDefense = 0
        baseMagicDefense = 0
        statusImmunities.add(StatusEffectType.STUN)
        statusImmunities.add(StatusEffectType.PETRIFY)
        imageId = R.drawable.unit_primeval_wurm
        idName = R.string.enemy_primeval_wurm_name
        idDescription = R.string.enemy_primeval_wurm_description
        passiveSkill = Skills.PASSIVE_BEHEMOTH
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 4000
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("PrimevalScale", 1), 999)
        linkedHashMap.put(ItemWrapper.getInstance("InsectEgg", 1), 1)
        return linkedHashMap
    }
}
