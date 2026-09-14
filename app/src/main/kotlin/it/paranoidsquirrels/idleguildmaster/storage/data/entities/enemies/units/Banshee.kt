package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Banshee : Enemy() {
    override fun getMaxDamage(): Int = 205
    override fun getMinDamage(): Int = 153
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 1400
        baseConstitution = 250
        baseIntelligence = 5
        baseDexterity = 85
        baseDefense = 35
        baseMagicDefense = 35
        team = 2
        imageId = R.drawable.unit_banshee
        idName = R.string.enemy_banshee_name
        idDescription = R.string.enemy_banshee_description
        threat = 3
        passiveSkill = Skills.PASSIVE_TERRITORIAL
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 250
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("BansheeScale", 1), 600)
        linkedHashMap.put(ItemWrapper.getInstance("BansheeClaw", 1), 18)
        linkedHashMap.put(ItemWrapper.getInstance("BansheeHorn", 1), 2)
        linkedHashMap.put(ItemWrapper.getInstance("ReptileEgg", 1), 1)
        return linkedHashMap
    }
}
