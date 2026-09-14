package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class UndeadGeneral : Enemy() {
    override fun getMaxDamage(): Int = 90
    override fun getMinDamage(): Int = 60
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 600
        baseConstitution = 35
        baseIntelligence = 16
        baseDexterity = 24
        baseDefense = 50
        baseMagicDefense = 0
        imageId = R.drawable.unit_undead_general
        idName = R.string.enemy_undead_general_name
        idDescription = R.string.enemy_undead_general_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 240
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("BoneFragment", 5), 570)
        linkedHashMap.put(ItemWrapper.getInstance("CursedSilver", 1), 300)
        linkedHashMap.put(ItemWrapper.getInstance("PotionOfViciousness", 1), 100)
        return linkedHashMap
    }
}
