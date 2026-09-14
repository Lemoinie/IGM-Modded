package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class DivineDuelist : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 40
        baseMaxHp = 320
        baseConstitution = 36
        baseIntelligence = 13
        baseDexterity = 16
        baseDefense = 20
        baseMagicDefense = 20
        threat = 3
        counterattack = 0.6
        onSelfHit = StatusEffect(StatusEffectType.DEFENSIVE_STANCE, this, 999, 0.15)
        imageId = R.drawable.unit_divine_duelist
        idName = R.string.adventurer_divine_duelist_name
        idDescription = R.string.adventurer_divine_duelist_description
        passiveSkill = Skills.PASSIVE_SWORD_EXPERTISE_I
        activeSkill = Skills.ACTIVE_EN_GARDE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
        nextClasses.add("DivineChampion")
    }
}
