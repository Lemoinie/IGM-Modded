package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class UndeadWarlord : Enemy() {
    override fun getMaxDamage(): Int = 16
    override fun getMinDamage(): Int = 12
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 220
        baseConstitution = 24
        baseIntelligence = 1
        baseDexterity = 12
        baseDefense = 50
        baseMagicDefense = 0
        imageId = R.drawable.unit_undead_warlord
        idName = R.string.enemy_undead_warlord_name
        idDescription = R.string.enemy_undead_warlord_description
        retaliationPhysicalDamage = 12
        passiveSkill = Skills.PASSIVE_SPIKES
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 84
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("WarlordSkull", 2), 10)
        linkedHashMap.put(ItemWrapper.getInstance("BoneFragment", 1), 960)
        return linkedHashMap
    }
}
