package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap

class LegateHadrian : Enemy() {
    override fun getMaxDamage(): Int = 950
    override fun getMinDamage(): Int = 950
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 6400
        baseConstitution = Logger.BARD_SHIELD
        baseIntelligence = 80
        baseDexterity = 96
        baseDefense = 20
        baseMagicDefense = 20
        threat = 3
        alwaysHits = true
        baseLifesteal = 20
        counterattack = 0.5
        darknessDamageAmplification = 0.01
        immunityToStatus = 0.8
        regeneration = 75
        flatDodgeChance = 0.2
        criticalDamage = 2.0
        initiative = true
        imageId = R.drawable.unit_legate_hadrian
        idName = R.string.enemy_legate_hadrian_name
        idDescription = R.string.enemy_legate_hadrian_description
        passiveSkill = Skills.PASSIVE_BIOENHANCED
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 300
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        val count23 = 1 + (Utils.random() * 3).toInt()
        val count22 = 1 + (Utils.random() * 3).toInt()
        linkedHashMap.put(ItemWrapper.getInstance("Evo23Vial", count23), 100)
        linkedHashMap.put(ItemWrapper.getInstance("Evo22Vial", count22), 100)
        return linkedHashMap
    }
    override fun calculateFlatDamageReduction(): Int = super.calculateFlatDamageReduction() + 15
}
