package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class ShaTheHiddenGod : Enemy() {
    override fun getMaxDamage(): Int = 7
    override fun getMinDamage(): Int = 7
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 7777
        baseConstitution = 7
        baseIntelligence = 7
        baseDexterity = 7
        baseDefense = 0
        baseMagicDefense = 0
        alwaysHits = true
        immunityToStatus = 1.0
        imageId = R.drawable.unit_sha_the_hidden_god
        idName = R.string.enemy_sha_the_hidden_god_name
        idDescription = R.string.enemy_sha_the_hidden_god_description
        passiveSkill = Skills.PASSIVE_PERFECT_IMMUNITY
        activeSkill = Skills.ACTIVE_DISEMBODY
        expGiven = 9600
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("DivineZygote", 1), 1000)
        return linkedHashMap
    }
}
