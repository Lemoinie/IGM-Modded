package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class ShaKireFirstSwordsman : Enemy() {
    override fun getMaxDamage(): Int = 104
    override fun getMinDamage(): Int = 75
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 3500
        baseConstitution = 24
        baseIntelligence = 36
        baseDexterity = 42
        baseDefense = 0
        baseMagicDefense = 0
        counterattack = 1.0
        imageId = R.drawable.unit_sha_kire_first_swordsman
        idName = R.string.enemy_sha_kire_first_swordsman_name
        idDescription = R.string.enemy_sha_kire_first_swordsman_description
        passiveSkill = Skills.PASSIVE_RETALIATE_II
        activeSkill = Skills.ACTIVE_DESERT_JUDGEMENT
        expGiven = 600
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("EyesOfTheSwordsman", 1), 1000)
        return linkedHashMap
    }
}
