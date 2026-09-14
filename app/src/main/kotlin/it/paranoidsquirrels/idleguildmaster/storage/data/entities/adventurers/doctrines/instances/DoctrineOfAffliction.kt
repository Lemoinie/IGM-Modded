package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbilityType

class DoctrineOfAffliction : Doctrine() {
    override fun setupValues() {
        idName = R.string.doctrine_affliction_name
        idDescription = R.string.doctrine_affliction_description
        idDescriptionShort = R.string.doctrine_affliction_description_short
        idImage = R.drawable.doctrine_of_affliction
    }

    override fun setupAbilities(): List<DoctrineAbilityType> = listOf(
        DoctrineAbilityType.IMPROVED_HEALTH,
        DoctrineAbilityType.IMPROVED_DEXTERITY,
        DoctrineAbilityType.NECROSIS_PORPHYRICA,
        DoctrineAbilityType.SERVUS_SANGUINIS,
        DoctrineAbilityType.SERVUS_UMBRAE,
        DoctrineAbilityType.GENUS_VAMPYRI
    )

    override fun bonusQuestPoints(): Int = MainActivity.data.afflictionLevel
    override fun bonusHp(): Int = getValue(DoctrineAbilityType.IMPROVED_HEALTH)
    override fun bonusDexterity(): Int = getValue(DoctrineAbilityType.IMPROVED_DEXTERITY)
    override fun reduceCriticalBonusDamage(): Int = getValue(DoctrineAbilityType.NECROSIS_PORPHYRICA)
    override fun bonusLifesteal(): Int = getValue(DoctrineAbilityType.SERVUS_SANGUINIS)
    override fun darknessDamageIncrease(): Int = getValue(DoctrineAbilityType.SERVUS_UMBRAE)
    override fun maxLifestealOverheal(): Int = getValue(DoctrineAbilityType.GENUS_VAMPYRI)
}
