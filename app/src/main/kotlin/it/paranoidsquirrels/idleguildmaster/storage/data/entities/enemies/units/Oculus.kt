package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap

class Oculus : Enemy() {
    override fun getMaxDamage(): Int = 135
    override fun getMinDamage(): Int = Logger.STATUS_FEEBLE_TETHER
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 1100
        baseConstitution = 55
        baseIntelligence = 65
        baseDexterity = 36
        baseDefense = 10
        baseMagicDefense = 0
        team = 1
        imageId = R.drawable.unit_oculus
        idName = R.string.enemy_oculus_name
        idDescription = R.string.enemy_oculus_description
        flying = true
        passiveSkill = Skills.PASSIVE_FLYING
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 80
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("ElasticMembrane", 1), 400)
        linkedHashMap.put(ItemWrapper.getInstance("FluxLimiter", 1), 3)
        linkedHashMap.put(ItemWrapper.getInstance("Scanner", 1), 4)
        return linkedHashMap
    }
}
