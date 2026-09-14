package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class KabarTheRotten : Enemy() {
    override fun getMaxDamage(): Int = 150
    override fun getMinDamage(): Int = 130
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 900
        baseConstitution = 14
        baseIntelligence = 34
        baseDexterity = 8
        baseDefense = 50
        baseMagicDefense = 0
        baseLifesteal = 25
        imageId = R.drawable.unit_kabar_the_rotten
        idName = R.string.enemy_kabar_the_rotten_name
        idDescription = R.string.enemy_kabar_the_rotten_description
        passiveSkill = Skills.PASSIVE_LICH_CURSE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 360
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("PhylacteryFragment", 1), 666)
        linkedHashMap.put(ItemWrapper.getInstance("CursedSilver", 3), 309)
        linkedHashMap.put(ItemWrapper.getInstance("RobeOfTheLich", 1), 25)
        return linkedHashMap
    }
}
