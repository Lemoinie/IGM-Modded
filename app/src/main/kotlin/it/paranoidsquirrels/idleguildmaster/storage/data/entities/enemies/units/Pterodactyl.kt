package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class Pterodactyl : Enemy() {
    override fun getMaxDamage(): Int = 495
    override fun getMinDamage(): Int = 415
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 775
        baseConstitution = 15
        baseIntelligence = 1
        baseDexterity = 126
        baseDefense = 10
        baseMagicDefense = 0
        flying = true
        imageId = R.drawable.unit_pterodactyl
        idName = R.string.enemy_pterodactyl_name
        idDescription = R.string.enemy_pterodactyl_description
        passiveSkill = Skills.PASSIVE_PREHISTORIC_AVIAN
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 175
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("AncientMembrane", 1), 325)
        linkedHashMap.put(ItemWrapper.getInstance("PterodactylClaw", 1), 1)
        linkedHashMap.put(ItemWrapper.getInstance("DinoRibs", 1), 67)
        linkedHashMap.put(ItemWrapper.getInstance("AvianEgg", 1), 1)
        return linkedHashMap
    }
}
