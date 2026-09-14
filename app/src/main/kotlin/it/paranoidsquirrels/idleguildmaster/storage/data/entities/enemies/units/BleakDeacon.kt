package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class BleakDeacon : Enemy() {
    override fun getMaxDamage(): Int = 350
    override fun getMinDamage(): Int = 200
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 1700
        baseConstitution = 24
        baseIntelligence = 215
        baseDexterity = 76
        baseDefense = 0
        baseMagicDefense = 30
        currentMana = 100
        healer = true
        onTargetHit = StatusEffect(StatusEffectType.ANOINTED, this, 5, 1.0)
        imageId = R.drawable.unit_bleak_deacon
        idName = R.string.enemy_bleak_deacon_name
        idDescription = R.string.enemy_bleak_deacon_description
        passiveSkill = Skills.PASSIVE_TERATOGEN
        activeSkill = Skills.ACTIVE_MASS_HEAL_I
        rarity = 1
        expGiven = 1000
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("EldritchShred", 1), 350)
        linkedHashMap.put(ItemWrapper.getInstance("EsotericEgg", 1), 1)
        return linkedHashMap
    }
}
