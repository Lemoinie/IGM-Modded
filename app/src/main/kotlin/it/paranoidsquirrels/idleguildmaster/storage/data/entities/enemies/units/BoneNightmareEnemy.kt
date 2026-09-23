package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

/**
 * Reanimated minion raised when an adventurer falls under the Sinister Curse:
 * their soul is reaped into this skeletal war-steed fighting on the enemy side.
 */
class BoneNightmareEnemy : Enemy() {
    override fun getMaxDamage(): Int = 400
    override fun getMinDamage(): Int = 300
    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 8000
        baseConstitution = 100
        baseDexterity = 150
        baseDefense = 40
        baseMagicDefense = 20
        threat = 6
        imageId = R.drawable.unit_bone_nightmare
        idName = R.string.enemy_cursed_bone_nightmare_name
        idDescription = R.string.enemy_cursed_bone_nightmare_description
        passiveSkill = Skills.PASSIVE_THREATENING_II
        activeSkill = Skills.ACTIVE_NONE
        rarity = 1
        expGiven = 1000
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> = LinkedHashMap()
}