package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class ImperialCaptain : Enemy() {
    var authorityStacks: Int = 0

    override fun configureStatistics() {
        baseMaxHp = 1500
        baseDefense = 30
        baseMagicDefense = 30
        baseConstitution = 40
        baseDexterity = 20
        baseIntelligence = 40
        baseLifesteal = 0
        imageId = R.drawable.imperial_captain
        idName = R.string.enemy_imperial_captain_name
        idDescription = R.string.enemy_imperial_captain_description
        currentMana = 100
        passiveSkill = Skills.PASSIVE_IMPERIAL_AUTHORITY
        activeSkill = Skills.ACTIVE_EXECUTION_ORDER
        rarity = 2
        expGiven = 500
    }

    override fun getMinDamage(): Int = 100
    override fun getMaxDamage(): Int = 150

    override fun listDrops(rarity: Int): LinkedHashMap<ItemWrapper, Int> {
        val drops = LinkedHashMap<ItemWrapper, Int>()
        drops[ItemWrapper.getInstance("GoldScraps", 30)] = 850
        drops[ItemWrapper.getInstance("PotionOfConstitution", 1)] = 50
        drops[ItemWrapper.getInstance("PotionOfHealth", 1)] = 50
        drops[ItemWrapper.getInstance("CaptainsSword", 1)] = 50
        return drops
    }

    override fun isMagic(): Boolean = false
    override fun isRanged(): Boolean = false

    fun boostAuthority() {
        if (authorityStacks < 5) {
            authorityStacks++
        }
    }

    override fun calculateTotalDefense(): Int {
        return super.calculateTotalDefense() + (authorityStacks * 5)
    }

    override fun calculateTotalMagicDefense(): Int {
        return super.calculateTotalMagicDefense() + (authorityStacks * 5)
    }

    override fun calculateMaxAttackDamage(): Int {
        val base = super.calculateMaxAttackDamage()
        return base + (base * authorityStacks * 5 / 100)
    }

    override fun calculateMinAttackDamage(): Int {
        val base = super.calculateMinAttackDamage()
        return base + (base * authorityStacks * 5 / 100)
    }

    override fun onTargetHitEffects(): List<StatusEffect> {
        val effects = mutableListOf<StatusEffect>()
        onTargetHit?.let { effects.add(it) }
        effects.add(StatusEffect(StatusEffectType.STUN, this, 1, 0.50))
        return effects
    }

    override fun endOfTurnActions(): List<EndOfTurnAction> {
        boostAuthority()
        return super.endOfTurnActions()
    }
}
