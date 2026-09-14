package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbilityType

class DoctrineOfGrace : Doctrine() {
    override fun setupValues() {
        idName = R.string.doctrine_grace_name
        idDescription = R.string.doctrine_grace_description
        idDescriptionShort = R.string.doctrine_grace_description_short
        idImage = R.drawable.doctrine_of_grace
    }

    override fun setupAbilities(): List<DoctrineAbilityType> = listOf(
        DoctrineAbilityType.IMPROVED_HEALTH,
        DoctrineAbilityType.IMPROVED_INTELLIGENCE,
        DoctrineAbilityType.SELFLESS_SPIRIT,
        DoctrineAbilityType.DIVINE_INTERVENTION,
        DoctrineAbilityType.OVERHEAL,
        DoctrineAbilityType.HEALING_NOVA
    )

    override fun bonusQuestPoints(): Int = MainActivity.data.graceLevel
    override fun bonusHp(): Int = getValue(DoctrineAbilityType.IMPROVED_HEALTH)
    override fun bonusIntelligence(): Int = getValue(DoctrineAbilityType.IMPROVED_INTELLIGENCE)
    override fun bonusResurrectionChance(): Int = getValue(DoctrineAbilityType.DIVINE_INTERVENTION)
    override fun bonusHealingModifier(): Int = getValue(DoctrineAbilityType.SELFLESS_SPIRIT)
    override fun maxOverheal(): Int = getValue(DoctrineAbilityType.OVERHEAL)
    override fun healingNova(): Int = getValue(DoctrineAbilityType.HEALING_NOVA)
}
