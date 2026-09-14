package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.LinkedHashMap

class PaleHermit : Enemy() {
    override fun getMaxDamage(): Int = 218
    override fun getMinDamage(): Int = Logger.LOST_EXPEDITION_FALL_DAMAGE
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 3500
        baseConstitution = 8
        baseIntelligence = 40
        baseDexterity = 60
        baseDefense = 0
        baseMagicDefense = 0
        initiative = true
        darknessDamageAmplification = 0.01
        imageId = R.drawable.unit_pale_hermit
        idName = R.string.enemy_pale_hermit_name
        idDescription = R.string.enemy_pale_hermit_description
        passiveSkill = Skills.PASSIVE_NIGHT_HUNTER
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 2500
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("VoodooDoll", 1), 1000)
        return linkedHashMap
    }
}
