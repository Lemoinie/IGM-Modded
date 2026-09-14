package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class PlagueSpreader : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 30
        baseMaxHp = 155
        baseConstitution = 9
        baseIntelligence = 14
        baseDexterity = 28
        baseDefense = 10
        baseMagicDefense = 10
        alwaysHits = true
        onTargetHit = StatusEffect(StatusEffectType.POISON, this, 2, 0.4)
        imageId = R.drawable.unit_plague_spreader
        idName = R.string.adventurer_plague_spreader_name
        idDescription = R.string.adventurer_plague_spreader_description
        passiveSkill = Skills.PASSIVE_POISONOUS_ARROWS_III
        activeSkill = Skills.ACTIVE_BARRAGE_II
        weaponType = R.string.type_bow
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.ARCHER
        nextClasses.add("Blight")
    }
}
