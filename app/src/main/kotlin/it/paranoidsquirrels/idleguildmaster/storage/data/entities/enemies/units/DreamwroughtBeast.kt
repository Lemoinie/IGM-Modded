package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap

class DreamwroughtBeast : Enemy() {
    override fun getMaxDamage(): Int = 800
    override fun getMinDamage(): Int = 550
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 6000
        baseConstitution = Logger.BARD_SHIELD
        baseIntelligence = Logger.BARD_SHIELD
        baseDexterity = 140
        baseDefense = 0
        baseMagicDefense = 0
        imageId = R.drawable.unit_dreamwrought_beast
        idName = R.string.enemy_dreamwrought_beast_name
        idDescription = R.string.enemy_dreamwrought_beast_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 400
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("DreamwroughtMane", 1), 700)
        return linkedHashMap
    }
}
