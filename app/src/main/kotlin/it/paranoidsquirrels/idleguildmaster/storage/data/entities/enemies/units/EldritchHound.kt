package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class EldritchHound : Enemy() {
    override fun getMaxDamage(): Int = 252
    override fun getMinDamage(): Int = 178
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 1046
        baseConstitution = 22
        baseIntelligence = 1
        baseDexterity = 128
        baseDefense = 0
        baseMagicDefense = 0
        darknessDamageAmplification = 0.01
        imageId = R.drawable.unit_eldritch_hound
        idName = R.string.enemy_eldritch_hound_name
        idDescription = R.string.enemy_eldritch_hound_description
        passiveSkill = Skills.PASSIVE_WICKED_APPETITE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 326
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("BlackHide", 1), 340)
        linkedHashMap.put(ItemWrapper.getInstance("EsotericEgg", 1), 1)
        return linkedHashMap
    }
}
