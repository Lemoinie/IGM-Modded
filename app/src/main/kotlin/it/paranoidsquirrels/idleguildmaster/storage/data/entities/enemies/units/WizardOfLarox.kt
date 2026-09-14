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

class WizardOfLarox : Enemy() {
    override fun getMaxDamage(): Int = 180
    override fun getMinDamage(): Int = 165
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 750
        baseConstitution = 8
        baseIntelligence = 172
        baseDexterity = 46
        baseDefense = 0
        baseMagicDefense = 30
        imageId = R.drawable.unit_wizard_of_larox
        idName = R.string.enemy_wizard_of_larox_name
        idDescription = R.string.enemy_wizard_of_larox_description
        passiveSkill = Skills.PASSIVE_ELEMENTAL_CONTROL
        activeSkill = Skills.ACTIVE_RAYS_OF_DESTRUCTION
        rarity = 1
        expGiven = 200
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("LaroxianFabric", 1), 225)
        linkedHashMap.put(ItemWrapper.getInstance("Pumpkin", 1), 35)
        linkedHashMap.put(ItemWrapper.getInstance("SpellCompendium", 1), 2)
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
        arrayList.add(StatusEffect(statusEffectType, this, 2, 1.0))
        return arrayList
    }
}
