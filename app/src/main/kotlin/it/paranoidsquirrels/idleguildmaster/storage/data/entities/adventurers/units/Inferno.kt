package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType
import java.util.ArrayList
import java.util.Collections

class Inferno : Adventurer() {
    override fun configureStatistics() {
        maxLevel = 45
        baseMaxHp = 200
        baseConstitution = 10
        baseIntelligence = 50
        baseDexterity = 12
        baseDefense = 0
        baseMagicDefense = 30
        onTargetHit = StatusEffect(StatusEffectType.ABLAZE, this, 1, 1.0)
        imageId = R.drawable.unit_inferno
        idName = R.string.adventurer_inferno_name
        idDescription = R.string.adventurer_inferno_description
        passiveSkill = Skills.PASSIVE_PYROMANCY_II
        activeSkill = Skills.ACTIVE_METEOR_II
        weaponType = R.string.type_staff
        armorType = R.string.type_armor_light
        potionDrinkerType = PotionDrinkerType.MAGE
    }
    override fun endOfTurnActions(): List<EndOfTurnAction> {
        val arrayList = ArrayList(super.endOfTurnActions())
        arrayList.addAll(Collections.nCopies(2, EndOfTurnAction.EXTRA_ATTACK_1))
        return arrayList
    }
}
