package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Djinn : Enemy() {
    override fun getMaxDamage(): Int = 33
    override fun getMinDamage(): Int = 27
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 500
        baseConstitution = 16
        baseIntelligence = 20
        baseDexterity = 15
        baseDefense = 0
        baseMagicDefense = 30
        currentMana = 100
        imageId = R.drawable.unit_djinn
        idName = R.string.enemy_djinn_name
        idDescription = R.string.enemy_djinn_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_SANDSTORM
        expGiven = 142
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("BottledSandSpirit", 1), 30)
        linkedHashMap.put(ItemWrapper.getInstance("PotionOfPrecision", 1), 11)
        linkedHashMap.put(ItemWrapper.getInstance("EsotericEgg", 1), 1)
        return linkedHashMap
    }
}
