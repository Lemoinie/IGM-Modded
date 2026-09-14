package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.ArrayList
import java.util.LinkedHashMap

class Berserker : Enemy() {
    override fun getMaxDamage(): Int = 450
    override fun getMinDamage(): Int = 390
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 1880
        baseConstitution = 60
        baseIntelligence = 8
        baseDexterity = 40
        baseDefense = 0
        baseMagicDefense = 0
        imageId = R.drawable.unit_berserker
        idName = R.string.enemy_berserker_name
        idDescription = R.string.enemy_berserker_description
        passiveSkill = Skills.PASSIVE_BERSERKER_RAGE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 175
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("Mithril", 1), 350)
        return linkedHashMap
    }
    override fun endOfTurnActions(): List<EndOfTurnAction> {
        val arrayList = ArrayList<EndOfTurnAction>()
        if (currentHp <= baseMaxHp.toDouble() * 0.5) {
            arrayList.add(EndOfTurnAction.EXTRA_ATTACK)
        }
        return arrayList
    }
}
