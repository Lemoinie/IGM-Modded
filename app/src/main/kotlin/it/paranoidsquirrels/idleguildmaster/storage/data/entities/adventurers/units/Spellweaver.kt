package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Spellweaver : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 20
        baseMaxHp = 50
        baseConstitution = 5
        baseIntelligence = 28
        baseDexterity = 8
        baseDefense = 0
        baseMagicDefense = 30
        customIntelligenceScaling = 1.2
        imageId = R.drawable.unit_spell_weaver
        idName = R.string.adventurer_spell_weaver_name
        idDescription = R.string.adventurer_spell_weaver_description
        passiveSkill = Skills.PASSIVE_AETHER_RESONANCE_II
        activeSkill = Skills.ACTIVE_ARCANE_BLAST_I
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
        nextClasses.add("AetherMage")
    }
}
