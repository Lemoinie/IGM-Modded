package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class FirstMinisterAtos : Enemy() {
    override fun getMaxDamage(): Int = 1900
    override fun getMinDamage(): Int = 1200
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 18500
        baseConstitution = 75
        baseIntelligence = 5
        baseDexterity = 190
        baseDefense = 0
        baseMagicDefense = 0
        currentMana = 80
        onTargetHit = StatusEffect(StatusEffectType.ABLAZE, this, 3, 1.0)
        onSelfHit = StatusEffect(StatusEffectType.ABLAZE, this, 3, 1.0)
        statusImmunities.add(StatusEffectType.ABLAZE)
        imageId = R.drawable.unit_first_minister_atos
        idName = R.string.enemy_first_minister_atos_name
        idDescription = R.string.enemy_first_minister_atos_description
        passiveSkill = Skills.PASSIVE_ABLAZE
        activeSkill = Skills.ACTIVE_AT_THE_STAKE
        rarity = 1
        expGiven = 4000
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("KaunianFabric", 1), 650)
        linkedHashMap.put(ItemWrapper.getInstance("FireproofOil", 1), 350)
        return linkedHashMap
    }
}
