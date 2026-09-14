package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class TrollWhelp : Enemy() {
    override fun getMaxDamage(): Int = 48
    override fun getMinDamage(): Int = 42
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 470
        baseConstitution = 20
        baseIntelligence = 2
        baseDexterity = 6
        baseDefense = 50
        baseMagicDefense = 0
        regeneration = 15
        imageId = R.drawable.unit_troll_whelp
        idName = R.string.enemy_troll_whelp_name
        idDescription = R.string.enemy_troll_whelp_description
        passiveSkill = Skills.PASSIVE_REGENERATION_I
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 60
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("TrollHide", 1), 300)
        linkedHashMap.put(ItemWrapper.getInstance("Blueberry", 1), 15)
        return linkedHashMap
    }
}
