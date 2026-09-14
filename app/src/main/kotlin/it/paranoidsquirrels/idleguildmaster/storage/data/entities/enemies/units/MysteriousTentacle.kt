package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class MysteriousTentacle : Enemy() {
    override fun getMaxDamage(): Int = 24
    override fun getMinDamage(): Int = 21
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 800
        baseConstitution = 52
        baseIntelligence = 1
        baseDexterity = 3
        baseDefense = 0
        baseMagicDefense = 0
        imageId = R.drawable.unit_mysterious_tentacle
        idName = R.string.enemy_mysterious_tentacle_name
        idDescription = R.string.enemy_mysterious_tentacle_description
        regeneration = 50
        passiveSkill = Skills.PASSIVE_REGENERATION_III
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 132
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("MysteriousAppendage", 1), 200)
        linkedHashMap.put(ItemWrapper.getInstance("EsotericEgg", 1), 1)
        return linkedHashMap
    }
}
