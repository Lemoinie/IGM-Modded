package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class Wraith : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 40
        baseMaxHp = 240
        baseConstitution = 11
        baseIntelligence = 18
        baseDexterity = 36
        baseDefense = 10
        baseMagicDefense = 10
        alwaysHits = true
        statusImmunities.add(StatusEffectType.POISON)
        onTargetHit = StatusEffect(StatusEffectType.POISON, this, 2, 0.4)
        imageId = R.drawable.unit_wraith
        idName = R.string.adventurer_wraith_name
        idDescription = R.string.adventurer_wraith_description
        passiveSkill = Skills.PASSIVE_POISONOUS_BLOOD
        activeSkill = Skills.ACTIVE_FOCUSED_BARRAGE
        weaponType = R.string.type_bow
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.ARCHER
        nextClasses.add("CorrosiveWraith")
    }
}
