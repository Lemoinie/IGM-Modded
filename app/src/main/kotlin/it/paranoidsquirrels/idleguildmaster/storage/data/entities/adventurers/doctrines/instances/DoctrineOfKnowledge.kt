package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbilityType

class DoctrineOfKnowledge : Doctrine() {
    override fun setupValues() {
        idName = R.string.doctrine_knowledge_name
        idDescription = R.string.doctrine_knowledge_description
        idDescriptionShort = R.string.doctrine_knowledge_description_short
        idImage = R.drawable.doctrine_of_knowlegde
    }

    override fun setupAbilities(): List<DoctrineAbilityType> = listOf(
        DoctrineAbilityType.EXALTED_CONSTITUTION,
        DoctrineAbilityType.EXALTED_DEXTERITY,
        DoctrineAbilityType.EXALTED_INTELLIGENCE,
        DoctrineAbilityType.EXALTED_HEALTH,
        DoctrineAbilityType.EXALTED_MANA,
        DoctrineAbilityType.LORE_MASTER
    )

    override fun bonusQuestPoints(): Int = MainActivity.data.knowledgeLevel
    override fun bonusHp(): Int = getValue(DoctrineAbilityType.EXALTED_HEALTH)
    override fun bonusConstitution(): Int = getValue(DoctrineAbilityType.EXALTED_CONSTITUTION)
    override fun bonusDexterity(): Int = getValue(DoctrineAbilityType.EXALTED_DEXTERITY)
    override fun bonusIntelligence(): Int = getValue(DoctrineAbilityType.EXALTED_INTELLIGENCE)
    override fun bonusManaRegen(): Int = getValue(DoctrineAbilityType.EXALTED_MANA)
    override fun doubleAccessoryStats(): Boolean = getValue(DoctrineAbilityType.LORE_MASTER) > 0
}
