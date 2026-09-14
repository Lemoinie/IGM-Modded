package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap

class EmperorClovisXXVIII : Enemy() {
    override fun getMaxDamage(): Int = 140
    override fun getMinDamage(): Int = Logger.BOTCHED_OFFERING
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 6800
        baseConstitution = 18
        baseIntelligence = 1
        baseDexterity = 48
        baseDefense = 0
        baseMagicDefense = 0
        initiative = true
        currentMana = 100
        immunityToStatus = 0.75
        imageId = R.drawable.unit_emperor_clovis_xxviii
        idName = R.string.enemy_emperor_clovis_xxviii_name
        idDescription = R.string.enemy_emperor_clovis_xxviii_description
        passiveSkill = Skills.PASSIVE_ENHANCED_IMMUNITY
        activeSkill = Skills.ACTIVE_PANDEMONIUM
        rarity = 1
        expGiven = 9600
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("SkeletonKey", 1), 1000)
        return linkedHashMap
    }
}
