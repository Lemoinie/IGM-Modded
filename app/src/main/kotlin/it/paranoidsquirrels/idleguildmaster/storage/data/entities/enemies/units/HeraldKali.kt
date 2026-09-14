package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class HeraldKali : Enemy() {
    override fun getMaxDamage(): Int = 305
    override fun getMinDamage(): Int = 280
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 4500
        baseConstitution = 500
        baseIntelligence = 500
        baseDexterity = 500
        baseDefense = 0
        baseMagicDefense = 0
        alwaysHits = true
        immunityToStatus = 0.5
        currentMana = 100
        imageId = R.drawable.unit_herald_kali
        idName = R.string.enemy_herald_kali_name
        idDescription = R.string.enemy_herald_kali_description
        passiveSkill = Skills.PASSIVE_CLAIRVOYANCE
        activeSkill = Skills.ACTIVE_SACRIFICE
        rarity = 1
        expGiven = 9600
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("SerpentStaff", 1), 1000)
        return linkedHashMap
    }
    override fun calculateManaRegen(): Int = 10
}
