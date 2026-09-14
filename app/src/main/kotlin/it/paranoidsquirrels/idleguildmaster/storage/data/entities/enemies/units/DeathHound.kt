package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class DeathHound : Enemy() {
    override fun getMaxDamage(): Int = 28
    override fun getMinDamage(): Int = 17
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 70
        baseConstitution = 8
        baseIntelligence = 1
        baseDexterity = 20
        baseDefense = 50
        baseMagicDefense = 0
        imageId = R.drawable.unit_death_hound
        idName = R.string.enemy_death_hound_name
        idDescription = R.string.enemy_death_hound_description
        initiative = true
        passiveSkill = Skills.PASSIVE_INITIATIVE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 36
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("TatteredHide", 1), 800)
        linkedHashMap.put(ItemWrapper.getInstance("ElongatedBone", 1), 40)
        return linkedHashMap
    }
}
