package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbilityType

class DoctrineOfIllusion : Doctrine() {
    override fun setupValues() {
        idName = R.string.doctrine_illusion_name
        idDescription = R.string.doctrine_illusion_description
        idDescriptionShort = R.string.doctrine_illusion_description_short
        idImage = R.drawable.doctrine_of_illusion
    }

    override fun setupAbilities(): List<DoctrineAbilityType> = listOf(
        DoctrineAbilityType.IMPROVED_DEXTERITY,
        DoctrineAbilityType.IMPROVED_INTELLIGENCE,
        DoctrineAbilityType.EPHEMERAL_PRESENCE,
        DoctrineAbilityType.BEAT_THE_ODDS,
        DoctrineAbilityType.FALSE_LIFE,
        DoctrineAbilityType.TRUE_AGONY
    )

    override fun bonusQuestPoints(): Int = MainActivity.data.illusionLevel
    override fun bonusDexterity(): Int = getValue(DoctrineAbilityType.IMPROVED_DEXTERITY)
    override fun bonusIntelligence(): Int = getValue(DoctrineAbilityType.IMPROVED_INTELLIGENCE)
    override fun bonusDodgeChance(): Int = getValue(DoctrineAbilityType.EPHEMERAL_PRESENCE)
    override fun rollDamageThreeTimes(): Boolean = getValue(DoctrineAbilityType.BEAT_THE_ODDS) > 0
    override fun falseLifeChance(): Int = getValue(DoctrineAbilityType.FALSE_LIFE)
    override fun damageOnFalseLifeRemoval(): Int = getValue(DoctrineAbilityType.TRUE_AGONY)
}
