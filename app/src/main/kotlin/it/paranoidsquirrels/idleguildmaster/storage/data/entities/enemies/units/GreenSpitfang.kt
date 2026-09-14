package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class GreenSpitfang : Enemy() {
    override fun getMaxDamage(): Int = 150
    override fun getMinDamage(): Int = 105
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 520
        baseConstitution = 15
        baseIntelligence = 3
        baseDexterity = 55
        baseDefense = 0
        baseMagicDefense = 0
        initiative = true
        imageId = R.drawable.unit_green_spitfang
        idName = R.string.enemy_green_spitfang_name
        idDescription = R.string.enemy_green_spitfang_description
        passiveSkill = Skills.PASSIVE_INITIATIVE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 92
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("SpitfangScale", 1), 400)
        linkedHashMap.put(ItemWrapper.getInstance("LongSerpentFang", 1), 20)
        linkedHashMap.put(ItemWrapper.getInstance("ReptileEgg", 1), 1)
        return linkedHashMap
    }
}
