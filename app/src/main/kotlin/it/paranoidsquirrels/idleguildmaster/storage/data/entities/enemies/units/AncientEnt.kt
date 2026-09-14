package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class AncientEnt : Enemy() {
    override fun getMaxDamage(): Int = 195
    override fun getMinDamage(): Int = 140
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 3200
        baseConstitution = 130
        baseIntelligence = 48
        baseDexterity = 27
        baseDefense = 10
        baseMagicDefense = 10
        imageId = R.drawable.unit_ancient_ent
        idName = R.string.enemy_ancient_ent_name
        idDescription = R.string.enemy_ancient_ent_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_FLEECE
        rarity = 1
        expGiven = 240
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("ElysianWood", 3), 460)
        linkedHashMap.put(ItemWrapper.getInstance("LivingVine", 1), 80)
        linkedHashMap.put(ItemWrapper.getInstance("Avocado", 1), 100)
        linkedHashMap.put(ItemWrapper.getInstance("WoodenEgg", 1), 1)
        return linkedHashMap
    }
}
