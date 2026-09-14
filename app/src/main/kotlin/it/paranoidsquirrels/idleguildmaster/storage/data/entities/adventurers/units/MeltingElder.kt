package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class MeltingElder : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 40
        baseMaxHp = 160
        baseConstitution = 9
        baseIntelligence = 45
        baseDexterity = 11
        baseDefense = 0
        baseMagicDefense = 30
        onTargetHit = StatusEffect(StatusEffectType.ABLAZE, this, 1, 1.0)
        endOfTurnAction = EndOfTurnAction.EXTRA_ATTACK_1
        imageId = R.drawable.unit_melting_elder
        idName = R.string.adventurer_melting_elder_name
        idDescription = R.string.adventurer_melting_elder_description
        passiveSkill = Skills.PASSIVE_PYROMANCY_I
        activeSkill = Skills.ACTIVE_METEOR_II
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("Inferno")
    }
}
