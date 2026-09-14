package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class KasimirTheSeer : Enemy() {
    override fun getMaxDamage(): Int = 305
    override fun getMinDamage(): Int = 280
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 4500
        baseConstitution = 500
        baseIntelligence = 500
        baseDexterity = 500
        baseDefense = 0
        baseMagicDefense = 0
        alwaysHits = true
        immunityToStatus = 0.5
        imageId = R.drawable.unit_kasimir_the_seer
        idName = R.string.enemy_kasimir_the_seer_name
        idDescription = R.string.enemy_kasimir_the_seer_description
        passiveSkill = Skills.PASSIVE_CLAIRVOYANCE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 5000
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        return LinkedHashMap<ItemWrapper, Int>()
    }
}
