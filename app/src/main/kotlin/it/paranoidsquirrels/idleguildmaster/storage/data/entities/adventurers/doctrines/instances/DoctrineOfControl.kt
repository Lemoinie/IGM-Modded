package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbilityType

class DoctrineOfControl : Doctrine() {
    override fun setupValues() {
        idName = R.string.doctrine_control_name
        idDescription = R.string.doctrine_control_description
        idDescriptionShort = R.string.doctrine_control_description_short
        idImage = R.drawable.doctrine_of_control
    }

    override fun setupAbilities(): List<DoctrineAbilityType> = listOf(
        DoctrineAbilityType.IMPROVED_INTELLIGENCE,
        DoctrineAbilityType.IMPENETRABLE_WILLPOWER,
        DoctrineAbilityType.MIND_BENDER,
        DoctrineAbilityType.CHILLING_FLOW,
        DoctrineAbilityType.STAR_GAZE,
        DoctrineAbilityType.ARCANE_SUPPRESSION
    )

    override fun bonusQuestPoints(): Int = MainActivity.data.controlLevel
    override fun bonusIntelligence(): Int = getValue(DoctrineAbilityType.IMPROVED_INTELLIGENCE)
    override fun bonusStatusImmunity(): Int = getValue(DoctrineAbilityType.IMPENETRABLE_WILLPOWER)
    override fun ignoreEnemyImmunities(): Int = getValue(DoctrineAbilityType.MIND_BENDER)
    override fun freezeOnHit(): Int = getValue(DoctrineAbilityType.CHILLING_FLOW)
    override fun petrifyOnHit(): Int = getValue(DoctrineAbilityType.STAR_GAZE)
    override fun damagePerTurnPerStatus(): Int = getValue(DoctrineAbilityType.ARCANE_SUPPRESSION)
}
