package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger

class ToxicStalker : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 25
        baseMaxHp = Logger.BARD_SHIELD
        baseConstitution = 8
        baseIntelligence = 12
        baseDexterity = 24
        baseDefense = 10
        baseMagicDefense = 10
        alwaysHits = true
        onTargetHit = StatusEffect(StatusEffectType.POISON, this, 1, 0.4)
        imageId = R.drawable.unit_toxic_stalker
        idName = R.string.adventurer_toxic_stalker_name
        idDescription = R.string.adventurer_toxic_stalker_description
        passiveSkill = Skills.PASSIVE_POISONOUS_ARROWS_II
        activeSkill = Skills.ACTIVE_BARRAGE_II
        weaponType = R.string.type_bow
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.ARCHER
        nextClasses.add("PlagueSpreader")
        nextClasses.add("Alchemist")
    }
}
