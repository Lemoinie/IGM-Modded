package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbilityType

class DoctrineOfRuin : Doctrine() {
    override fun setupValues() {
        idName = R.string.doctrine_ruin_name
        idDescription = R.string.doctrine_ruin_description
        idDescriptionShort = R.string.doctrine_ruin_description_short
        idImage = R.drawable.doctrine_of_ruin
    }

    override fun setupAbilities(): List<DoctrineAbilityType> = listOf(
        DoctrineAbilityType.IMPROVED_DEXTERITY,
        DoctrineAbilityType.EXPOSE_WEAKNESS,
        DoctrineAbilityType.EXPLOIT_WEAKNESS,
        DoctrineAbilityType.LIGHTNING_SPEED,
        DoctrineAbilityType.EYE_FOR_AN_EYE,
        DoctrineAbilityType.RAGEBOUND
    )

    override fun bonusQuestPoints(): Int = MainActivity.data.ruinLevel
    override fun bonusDexterity(): Int = getValue(DoctrineAbilityType.IMPROVED_DEXTERITY)
    override fun bonusCritChance(): Int = getValue(DoctrineAbilityType.EXPOSE_WEAKNESS)
    override fun bonusCritDamage(): Int = getValue(DoctrineAbilityType.EXPLOIT_WEAKNESS)
    override fun extraAttackChance(): Int = getValue(DoctrineAbilityType.LIGHTNING_SPEED)
    override fun moreDamageWhenHalfLife(): Boolean = getValue(DoctrineAbilityType.EYE_FOR_AN_EYE) > 0
    override fun moreDamageDealtAndTaken(): Boolean = getValue(DoctrineAbilityType.RAGEBOUND) > 0
}
