package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap

class WickedTribute : Enemy() {
    override fun getMaxDamage(): Int = 1
    override fun getMinDamage(): Int = 1
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 100
        baseConstitution = 2
        baseIntelligence = 400
        baseDexterity = 32
        baseDefense = 0
        baseMagicDefense = 0
        alwaysHits = true
        imageId = R.drawable.unit_wicked_tribute
        idName = R.string.enemy_wicked_tribute_name
        idDescription = R.string.enemy_wicked_tribute_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_THE_TEN_HELLS
        rarity = 1
        expGiven = 850
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("HellishRations", 1), Logger.PET_DECOY)
        linkedHashMap.put(ItemWrapper.getInstance("WickedSeal", 1), 3)
        linkedHashMap.put(ItemWrapper.getInstance("EsotericEgg", 1), 1)
        return linkedHashMap
    }
}
