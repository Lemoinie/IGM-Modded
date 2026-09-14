package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class RedElder : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 30
        baseMaxHp = 95
        baseConstitution = 7
        baseIntelligence = 35
        baseDexterity = 9
        baseDefense = 0
        baseMagicDefense = 30
        onTargetHit = StatusEffect(StatusEffectType.ABLAZE, this, 1, 0.5)
        imageId = R.drawable.unit_red_elder
        idName = R.string.adventurer_red_elder_name
        idDescription = R.string.adventurer_red_elder_description
        passiveSkill = Skills.PASSIVE_FIRE_MAGIC_I
        activeSkill = Skills.ACTIVE_METEOR_I
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("ScorchingElder")
    }
}
