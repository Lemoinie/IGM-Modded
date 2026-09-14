package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class TheAncient : Enemy() {
    override fun getMaxDamage(): Int = 4500
    override fun getMinDamage(): Int = 3500
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 35000
        baseConstitution = 85
        baseIntelligence = 925
        baseDexterity = 45
        baseDefense = 0
        baseMagicDefense = 0
        initiative = true
        currentMana = 100
        statusImmunities.add(StatusEffectType.STUN)
        statusImmunities.add(StatusEffectType.SILENCE)
        statusImmunities.add(StatusEffectType.TAUNT)
        statusImmunities.add(StatusEffectType.LESSER_CURSE)
        statusImmunities.add(StatusEffectType.CURSE)
        statusImmunities.add(StatusEffectType.GREATER_CURSE)
        statusImmunities.add(StatusEffectType.OMINOUS_CURSE)
        statusImmunities.add(StatusEffectType.ABHORRENT_CURSE)
        imageId = R.drawable.unit_the_ancient
        idName = R.string.enemy_the_ancient_name
        idDescription = R.string.enemy_the_ancient_description
        passiveSkill = Skills.PASSIVE_INSCRUTABLE
        activeSkill = Skills.ACTIVE_DEVOUR_SPIRIT
        rarity = 1
        expGiven = 17500
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("HeartOfDarkness", 1), 333)
        return linkedHashMap
    }
}
