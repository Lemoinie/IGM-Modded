package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Archangel : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 45
        baseMaxHp = 200
        baseConstitution = 10
        baseIntelligence = 50
        baseDexterity = 12
        baseDefense = 0
        baseMagicDefense = 30
        healer = true
        cleanser = true
        imageId = R.drawable.unit_archangel
        idName = R.string.adventurer_archangel_name
        idDescription = R.string.adventurer_archangel_description
        passiveSkill = Skills.PASSIVE_HEALER_II
        activeSkill = Skills.ACTIVE_RESTORATION_II
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
    }
}
