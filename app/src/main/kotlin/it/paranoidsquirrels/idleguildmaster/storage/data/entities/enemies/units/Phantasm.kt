package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Phantasm : Enemy() {
    override fun getMaxDamage(): Int = 1000
    override fun getMinDamage(): Int = 999
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 450
        baseConstitution = 22
        baseIntelligence = 165
        baseDexterity = 500
        baseDefense = 0
        baseMagicDefense = 0
        currentMana = 100
        flatDodgeChance = 0.5
        imageId = R.drawable.unit_phantasm
        idName = R.string.enemy_phantasm_name
        idDescription = R.string.enemy_phantasm_description
        passiveSkill = Skills.PASSIVE_ELUSIVE
        activeSkill = Skills.ACTIVE_LIGHTS_OUT
        rarity = 1
        expGiven = 450
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("KaunianFabric", 1), 500)
        return linkedHashMap
    }
}
