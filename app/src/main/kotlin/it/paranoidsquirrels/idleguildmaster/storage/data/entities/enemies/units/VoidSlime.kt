package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class VoidSlime : Enemy() {
    override fun getMaxDamage(): Int = 33
    override fun getMinDamage(): Int = 33
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 100
        baseConstitution = 40
        baseIntelligence = 2
        baseDexterity = 6
        baseDefense = 40
        baseMagicDefense = 0
        retaliationMagicalDamage = 33
        imageId = R.drawable.unit_void_slime
        idName = R.string.enemy_void_slime_name
        idDescription = R.string.enemy_void_slime_description
        passiveSkill = Skills.PASSIVE_VOID_PULL
        activeSkill = Skills.ACTIVE_NONE
        expGiven = 60
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("GreenSlime", 1), 650)
        linkedHashMap.put(ItemWrapper.getInstance("GreenSlime", 3), 100)
        linkedHashMap.put(ItemWrapper.getInstance("VoidCore", 1), 160)
        return linkedHashMap
    }
}
