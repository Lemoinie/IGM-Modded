package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class ArcaneAssassin : Enemy() {
    override fun getMaxDamage(): Int = 60
    override fun getMinDamage(): Int = 30
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 300
        baseConstitution = 15
        baseIntelligence = 20
        baseDexterity = 84
        baseDefense = 0
        baseMagicDefense = 0
        imageId = R.drawable.unit_arcane_assassin
        idName = R.string.enemy_arcane_assassin_name
        idDescription = R.string.enemy_arcane_assassin_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_ARCANE_STRIKE
        rarity = 1
        expGiven = 92
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("GoldScraps", 1), 400)
        linkedHashMap.put(ItemWrapper.getInstance("CorruptedDagger", 1), 1)
        if (i == 1) {
        linkedHashMap.put(ItemWrapper.getInstance("BlackOoze", 1), 200)
        }
        return linkedHashMap
    }
}
