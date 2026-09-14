package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Demilich : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 25
        baseMaxHp = 70
        baseConstitution = 6
        baseIntelligence = 30
        baseDexterity = 8
        baseDefense = 0
        baseMagicDefense = 30
        baseLifesteal = 50
        imageId = R.drawable.unit_demilich
        idName = R.string.adventurer_demilich_name
        idDescription = R.string.adventurer_demilich_description
        passiveSkill = Skills.PASSIVE_WITHERING_TOUCH
        activeSkill = Skills.ACTIVE_CURSE_II
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("Lich")
    }
}
