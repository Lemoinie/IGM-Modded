package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Deckhand : Enemy() {
    override fun getMaxDamage(): Int = 28
    override fun getMinDamage(): Int = 24
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 320
        baseConstitution = 16
        baseIntelligence = 4
        baseDexterity = 74
        baseDefense = 0
        baseMagicDefense = 0
        imageId = R.drawable.unit_deckhand
        idName = R.string.enemy_deckhand_name
        idDescription = R.string.enemy_deckhand_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 30
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("MonkeyHide", 1), 300)
        linkedHashMap.put(ItemWrapper.getInstance("AbyssalSeashell", 1), 200)
        linkedHashMap.put(ItemWrapper.getInstance("Banana", 1), 20)
        linkedHashMap.put(ItemWrapper.getInstance("WildEgg", 1), 1)
        return linkedHashMap
    }
}
