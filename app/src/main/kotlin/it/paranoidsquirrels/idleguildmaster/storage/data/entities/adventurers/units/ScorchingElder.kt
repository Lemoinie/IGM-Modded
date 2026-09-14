package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class ScorchingElder : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 35
        baseMaxHp = 125
        baseConstitution = 8
        baseIntelligence = 40
        baseDexterity = 10
        baseDefense = 0
        baseMagicDefense = 30
        onTargetHit = StatusEffect(StatusEffectType.ABLAZE, this, 1, 1.0)
        imageId = R.drawable.unit_scorching_elder
        idName = R.string.adventurer_scorching_elder_name
        idDescription = R.string.adventurer_scorching_elder_description
        passiveSkill = Skills.PASSIVE_FIRE_MAGIC_II
        activeSkill = Skills.ACTIVE_METEOR_II
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("MeltingElder")
    }
}
