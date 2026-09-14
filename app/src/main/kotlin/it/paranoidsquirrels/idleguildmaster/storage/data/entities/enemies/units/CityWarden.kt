package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class CityWarden : Enemy() {
    override fun getMaxDamage(): Int = 31
    override fun getMinDamage(): Int = 26
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 300
        baseConstitution = 20
        baseIntelligence = 8
        baseDexterity = 16
        baseDefense = 15
        baseMagicDefense = 0
        threat = 2
        imageId = R.drawable.unit_city_warden
        idName = R.string.enemy_city_warden_name
        idDescription = R.string.enemy_city_warden_description
        passiveSkill = Skills.PASSIVE_THREATENING_I
        activeSkill = Skills.ACTIVE_RESTORE_ORDER
        rarity = 1
        expGiven = 35
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("WardenBelt", 1), 50)
        linkedHashMap.put(ItemWrapper.getInstance("SilkThread", 1), 200)
        if (i == 1) {
        linkedHashMap.put(ItemWrapper.getInstance("BlackOoze", 1), 200)
        }
        return linkedHashMap
    }
}
