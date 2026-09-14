package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType

class DivineChampion : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 45
        baseMaxHp = 380
        baseConstitution = 40
        baseIntelligence = 14
        baseDexterity = 18
        baseDefense = 20
        baseMagicDefense = 20
        threat = 3
        counterattack = 0.6
        onSelfHit = StatusEffect(StatusEffectType.DEFENSIVE_STANCE, this, 999, 0.3)
        imageId = R.drawable.unit_divine_champion
        idName = R.string.adventurer_divine_champion_name
        idDescription = R.string.adventurer_divine_champion_description
        passiveSkill = Skills.PASSIVE_SWORD_EXPERTISE_II
        activeSkill = Skills.ACTIVE_EN_GARDE
        weaponType = R.string.type_sword
        armorType = R.string.type_armor_heavy
        potionDrinkerType = PotionDrinkerType.WARRIOR
    }
}
