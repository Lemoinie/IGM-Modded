package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Necromancer : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 20
        baseMaxHp = 50
        baseConstitution = 5
        baseIntelligence = 25
        baseDexterity = 7
        baseDefense = 0
        baseMagicDefense = 30
        baseLifesteal = 50
        imageId = R.drawable.unit_necromancer
        idName = R.string.adventurer_necromancer_name
        idDescription = R.string.adventurer_necromancer_description
        passiveSkill = Skills.PASSIVE_WITHERING_TOUCH
        activeSkill = Skills.ACTIVE_CURSE_I
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("Demilich")
        nextClasses.add("Unchained")
    }
}
