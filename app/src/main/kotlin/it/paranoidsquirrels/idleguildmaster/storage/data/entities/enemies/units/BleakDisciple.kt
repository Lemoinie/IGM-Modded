package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class BleakDisciple : Enemy() {
    override fun getMaxDamage(): Int = 380
    override fun getMinDamage(): Int = 160
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 1490
        baseConstitution = 9
        baseIntelligence = 158
        baseDexterity = 62
        baseDefense = 0
        baseMagicDefense = 30
        initiative = true
        currentMana = 100
        darknessDamageAmplification = 0.01
        imageId = R.drawable.unit_bleak_disciple
        idName = R.string.enemy_bleak_disciple_name
        idDescription = R.string.enemy_bleak_disciple_description
        passiveSkill = Skills.PASSIVE_NIGHT_HUNTER
        activeSkill = Skills.ACTIVE_INSTILL_TERROR
        rarity = 1
        expGiven = 360
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("AbherrantFabric", 1), 440)
        linkedHashMap.put(ItemWrapper.getInstance("EsotericEgg", 1), 1)
        return linkedHashMap
    }
}
