package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Phoenix : Enemy() {
    override fun getMaxDamage(): Int = 1350
    override fun getMinDamage(): Int = 1250
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 12000
        baseConstitution = 50
        baseIntelligence = 125
        baseDexterity = 210
        baseDefense = 0
        baseMagicDefense = 0
        flying = true
        imageId = R.drawable.unit_phoenix
        idName = R.string.enemy_phoenix_name
        idDescription = R.string.enemy_phoenix_description
        passiveSkill = Skills.PASSIVE_ABSURD_GENEALOGY
        activeSkill = Skills.ACTIVE_TABULA_RASA
        rarity = 1
        expGiven = 7500
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("PhoenixFeather", 1), 260)
        return linkedHashMap
    }
}
