package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap

class UndeadArcher : Enemy() {
    override fun getMaxDamage(): Int = 14
    override fun getMinDamage(): Int = 11
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = Logger.BARD_SHIELD
        baseConstitution = 5
        baseIntelligence = 1
        baseDexterity = 8
        baseDefense = 50
        baseMagicDefense = 0
        imageId = R.drawable.unit_undead_archer
        idName = R.string.enemy_undead_archer_name
        idDescription = R.string.enemy_undead_archer_description
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
