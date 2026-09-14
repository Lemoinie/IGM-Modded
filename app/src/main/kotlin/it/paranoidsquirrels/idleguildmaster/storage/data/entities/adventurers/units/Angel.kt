package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Angel : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 40
        baseMaxHp = 160
        baseConstitution = 9
        baseIntelligence = 45
        baseDexterity = 11
        baseDefense = 0
        baseMagicDefense = 30
        healer = true
        cleanser = true
        imageId = R.drawable.unit_angel
        idName = R.string.adventurer_angel_name
        idDescription = R.string.adventurer_angel_description
        passiveSkill = Skills.PASSIVE_HEALER_II
        activeSkill = Skills.ACTIVE_RESTORATION_I
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("Archangel")
    }
}
