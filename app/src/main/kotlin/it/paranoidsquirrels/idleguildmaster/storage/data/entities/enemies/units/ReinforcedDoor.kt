package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class ReinforcedDoor : Enemy() {
    override fun getMaxDamage(): Int = 300
    override fun getMinDamage(): Int = 200
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 3000
        baseConstitution = 400
        baseIntelligence = 1
        baseDexterity = 15
        baseDefense = 20
        baseMagicDefense = 0
        statusImmunities.add(StatusEffectType.ABLAZE)
        statusImmunities.add(StatusEffectType.BLEED)
        statusImmunities.add(StatusEffectType.POISON)
        imageId = R.drawable.unit_reinforced_door
        idName = R.string.enemy_reinforced_door_name
        idDescription = R.string.enemy_reinforced_door_description
        passiveSkill = Skills.PASSIVE_INORGANIC
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 300
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("CelestialScraps", 50), 1000)
        return linkedHashMap
    }
}
