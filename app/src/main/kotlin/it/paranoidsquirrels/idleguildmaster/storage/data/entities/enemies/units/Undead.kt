package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Undead : Enemy() {
    override fun getMaxDamage(): Int = 11
    override fun getMinDamage(): Int = 8
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 160
        baseConstitution = 16
        baseIntelligence = 1
        baseDexterity = 5
        baseDefense = 50
        baseMagicDefense = 0
        imageId = R.drawable.unit_undead
        idName = R.string.enemy_undead_name
        idDescription = R.string.enemy_undead_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 20
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("BoneFragment", 1), 500)
        linkedHashMap.put(ItemWrapper.getInstance("SharpRib", 1), 10)
        return linkedHashMap
    }
}
