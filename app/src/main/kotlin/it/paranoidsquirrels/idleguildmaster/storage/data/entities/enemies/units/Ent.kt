package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap

class Ent : Enemy() {
    override fun getMaxDamage(): Int = 14
    override fun getMinDamage(): Int = 11
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 300
        baseConstitution = 20
        baseIntelligence = 20
        baseDexterity = 3
        baseDefense = 0
        baseMagicDefense = 0
        imageId = R.drawable.unit_ent
        idName = R.string.enemy_ent_name
        idDescription = R.string.enemy_ent_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_STOMP
        rarity = 3
        expGiven = Logger.BARD_SHIELD
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("Wood", 1), 499)
        linkedHashMap.put(ItemWrapper.getInstance("AncientSeed", 1), 50)
        linkedHashMap.put(ItemWrapper.getInstance("Apple", 1), 250)
        linkedHashMap.put(ItemWrapper.getInstance("WoodenEgg", 1), 1)
        return linkedHashMap
    }
}
