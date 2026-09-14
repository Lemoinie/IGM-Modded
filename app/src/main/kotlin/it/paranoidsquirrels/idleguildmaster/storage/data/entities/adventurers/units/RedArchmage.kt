package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class RedArchmage : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 25
        baseMaxHp = 70
        baseConstitution = 6
        baseIntelligence = 30
        baseDexterity = 8
        baseDefense = 0
        baseMagicDefense = 30
        onTargetHit = StatusEffect(StatusEffectType.ABLAZE, this, 1, 0.5)
        imageId = R.drawable.unit_red_archmage
        idName = R.string.adventurer_red_archmage_name
        idDescription = R.string.adventurer_red_archmage_description
        passiveSkill = Skills.PASSIVE_FIRE_MAGIC_I
        activeSkill = Skills.ACTIVE_FIREBALL
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("RedElder")
    }
}
