package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbilityType

class DoctrineOfWar : Doctrine() {
    override fun setupValues() {
        idName = R.string.doctrine_war_name
        idDescription = R.string.doctrine_war_description
        idDescriptionShort = R.string.doctrine_war_description_short
        idImage = R.drawable.doctrine_of_war
    }

    override fun setupAbilities(): List<DoctrineAbilityType> = listOf(
        DoctrineAbilityType.IMPROVED_CONSTITUTION,
        DoctrineAbilityType.IMPROVED_DEXTERITY,
        DoctrineAbilityType.CONDITIONED_REFLEXES,
        DoctrineAbilityType.TACTICAL_KNOWLEDGE,
        DoctrineAbilityType.RELENTLESS_ASSAULT,
        DoctrineAbilityType.WEAPON_MASTER
    )

    override fun bonusQuestPoints(): Int = MainActivity.data.warLevel
    override fun bonusConstitution(): Int = getValue(DoctrineAbilityType.IMPROVED_CONSTITUTION)
    override fun bonusDexterity(): Int = getValue(DoctrineAbilityType.IMPROVED_DEXTERITY)
    override fun bonusCounterattack(): Int = getValue(DoctrineAbilityType.CONDITIONED_REFLEXES)
    override fun ignoreArmorPercentage(): Int = getValue(DoctrineAbilityType.TACTICAL_KNOWLEDGE)
    override fun forcesCounterattack(): Boolean = getValue(DoctrineAbilityType.RELENTLESS_ASSAULT) > 0
    override fun canUseAllWeapons(): Boolean = getValue(DoctrineAbilityType.WEAPON_MASTER) > 0
}
