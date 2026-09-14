package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.ArrayList
import java.util.LinkedHashMap

class ArchmageOfLarox : Enemy() {
    override fun getMaxDamage(): Int = 195
    override fun getMinDamage(): Int = 180
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 770
        baseConstitution = 4
        baseIntelligence = 245
        baseDexterity = 34
        baseDefense = 0
        baseMagicDefense = 30
        imageId = R.drawable.unit_archmage_of_larox
        idName = R.string.enemy_archmage_of_larox_name
        idDescription = R.string.enemy_archmage_of_larox_description
        passiveSkill = Skills.PASSIVE_ELEMENTAL_MASTERY
        activeSkill = Skills.ACTIVE_RAYS_OF_DESTRUCTION
        rarity = 1
        expGiven = 330
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("LaroxianFabric", 1), 275)
        linkedHashMap.put(ItemWrapper.getInstance("Pumpkin", 1), 35)
        linkedHashMap.put(ItemWrapper.getInstance("SpellCompendium", 1), 3)
        linkedHashMap.put(ItemWrapper.getInstance("RuneOfPower", 1), 3)
        linkedHashMap.put(ItemWrapper.getInstance("ArchmageHat", 1), 1)
        return linkedHashMap
    }
    override fun onTargetHitEffects(): List<StatusEffect> {
        val dRandom = Utils.random()
        val statusEffectType = if (dRandom > 0.6666666666666666) {
            StatusEffectType.FROZEN
        } else if (dRandom > 0.3333333333333333) {
            StatusEffectType.STUN
        } else {
            StatusEffectType.ABLAZE
        }
        val arrayList = ArrayList<StatusEffect>()
        arrayList.add(StatusEffect(statusEffectType, this, 4, 1.0))
        return arrayList
    }
}
