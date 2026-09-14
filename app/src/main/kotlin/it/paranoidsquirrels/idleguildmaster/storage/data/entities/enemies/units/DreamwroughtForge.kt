package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class DreamwroughtForge : Enemy() {
    override fun getMaxDamage(): Int = 1150
    override fun getMinDamage(): Int = 1000
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 16000
        baseConstitution = 700
        baseIntelligence = 250
        baseDexterity = 5
        baseDefense = 10
        baseMagicDefense = 10
        imageId = R.drawable.unit_dreamwrought_forge
        idName = R.string.enemy_dreamwrought_forge_name
        idDescription = R.string.enemy_dreamwrought_forge_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_DREAM_FORGE
        rarity = 1
        expGiven = 625
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("DreamwroughtSteel", 1), 1000)
        return linkedHashMap
    }
}
