package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class CorrosiveWraith : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 45
        baseMaxHp = 290
        baseConstitution = 12
        baseIntelligence = 20
        baseDexterity = 40
        baseDefense = 10
        baseMagicDefense = 10
        alwaysHits = true
        statusImmunities.add(StatusEffectType.POISON)
        poisonBonus = 5
        onTargetHit = StatusEffect(StatusEffectType.POISON, this, 2, 0.4)
        imageId = R.drawable.unit_corrosive_wraith
        idName = R.string.adventurer_corrosive_wraith_name
        idDescription = R.string.adventurer_corrosive_wraith_description
        passiveSkill = Skills.PASSIVE_CORROSIVE_BLOOD
        activeSkill = Skills.ACTIVE_FOCUSED_BARRAGE
        weaponType = R.string.type_bow
        armorType = R.string.type_armor_medium
        potionDrinkerType = PotionDrinkerType.ARCHER
    }
}
