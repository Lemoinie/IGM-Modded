package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class AvatarOfTheAncient : Enemy() {
    override fun getMaxDamage(): Int = 650
    override fun getMinDamage(): Int = 610
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 6000
        baseConstitution = 1
        baseIntelligence = 999
        baseDexterity = 24
        baseDefense = 0
        baseMagicDefense = 0
        flatDodgeChance = 0.6
        immunityToStatus = 1.0
        imageId = R.drawable.unit_avatar_of_the_ancient
        idName = R.string.enemy_avatar_of_the_ancient_name
        idDescription = R.string.enemy_avatar_of_the_ancient_description
        passiveSkill = Skills.PASSIVE_COSMIC_PROJECTION
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 10000
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("StarFragment", 1), 325)
        linkedHashMap.put(ItemWrapper.getInstance("EsotericEgg", 1), 1)
        return linkedHashMap
    }
}
