package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbilityType

class EmptyDoctrine : Doctrine() {
    override fun bonusQuestPoints(): Int = 0

    override fun setupValues() {
        idName = R.string.doctrine_empty_name
        idDescription = R.string.doctrine_empty_description
        idDescriptionShort = R.string.doctrine_empty_description
        idImage = R.drawable.sign_plus_white
    }

    override fun setupAbilities(): List<DoctrineAbilityType> = emptyList()
}
