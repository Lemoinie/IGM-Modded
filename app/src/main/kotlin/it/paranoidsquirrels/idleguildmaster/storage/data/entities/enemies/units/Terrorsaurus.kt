package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Terrorsaurus : Enemy() {
    override fun getMaxDamage(): Int = 480
    override fun getMinDamage(): Int = 400
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 2600
        baseConstitution = 94
        baseIntelligence = 1
        baseDexterity = 12
        baseDefense = 10
        baseMagicDefense = 0
        threat = 3
        imageId = R.drawable.unit_terrorsaurus
        idName = R.string.enemy_terrorsaurus_name
        idDescription = R.string.enemy_terrorsaurus_description
        passiveSkill = Skills.PASSIVE_PREHISTORIC_COLOSSUS
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 194
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("AncientHide", 1), 390)
        linkedHashMap.put(ItemWrapper.getInstance("TerrorsaurusFang", 1), 1)
        linkedHashMap.put(ItemWrapper.getInstance("DinoRibs", 1), 67)
        linkedHashMap.put(ItemWrapper.getInstance("ReptileEgg", 1), 1)
        return linkedHashMap
    }
}
