package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbilityType

class DoctrineOfFortitude : Doctrine() {
    override fun setupValues() {
        idName = R.string.doctrine_fortitude_name
        idDescription = R.string.doctrine_fortitude_description
        idDescriptionShort = R.string.doctrine_fortitude_description_short
        idImage = R.drawable.doctrine_of_fortitude
    }

    override fun setupAbilities(): List<DoctrineAbilityType> = listOf(
        DoctrineAbilityType.IMPROVED_HEALTH,
        DoctrineAbilityType.IMPROVED_CONSTITUTION,
        DoctrineAbilityType.MANIFEST_DANGER,
        DoctrineAbilityType.TROLL_RESISTANCE,
        DoctrineAbilityType.WARLOCK_RESILIENCE,
        DoctrineAbilityType.MIRROR_OF_ANGUISH
    )

    override fun bonusQuestPoints(): Int = MainActivity.data.fortitudeLevel
    override fun bonusConstitution(): Int = getValue(DoctrineAbilityType.IMPROVED_CONSTITUTION)
    override fun bonusHp(): Int = getValue(DoctrineAbilityType.IMPROVED_HEALTH)
    override fun bonusThreat(): Int = getValue(DoctrineAbilityType.MANIFEST_DANGER)
    override fun bonusDefense(): Int = getValue(DoctrineAbilityType.TROLL_RESISTANCE)
    override fun bonusMagicDefense(): Int = getValue(DoctrineAbilityType.WARLOCK_RESILIENCE)
    override fun addsDefensesToRetaliate(): Boolean = getValue(DoctrineAbilityType.MIRROR_OF_ANGUISH) > 0
}
