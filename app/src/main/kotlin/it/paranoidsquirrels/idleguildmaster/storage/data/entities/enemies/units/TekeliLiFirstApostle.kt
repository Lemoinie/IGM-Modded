package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class TekeliLiFirstApostle : Enemy() {
    override fun getMaxDamage(): Int = 515
    override fun getMinDamage(): Int = 460
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 18000
        baseConstitution = 165
        baseIntelligence = 320
        baseDexterity = 38
        baseDefense = 0
        baseMagicDefense = 0
        baseLifesteal = 100
        imageId = R.drawable.unit_tekeli_li_first_apostle
        idName = R.string.enemy_tekeli_li_first_apostle_name
        idDescription = R.string.enemy_tekeli_li_first_apostle_description
        passiveSkill = Skills.PASSIVE_PRIMORDIAL_HUNGER
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 16000
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("AstralGoo", 1), 500)
        linkedHashMap.put(ItemWrapper.getInstance("CosmicViolin", 1), 250)
        linkedHashMap.put(ItemWrapper.getInstance("EsotericEgg", 1), 1)
        return linkedHashMap
    }
}
