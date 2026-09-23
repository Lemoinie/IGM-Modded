package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class CrimsonAcolyte : Enemy() {
    override fun getMaxDamage(): Int = 600
    override fun getMinDamage(): Int = 500
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = false

    override fun configureStatistics() {
        baseMaxHp = 5000
        baseConstitution = 80
        baseDexterity = 250
        baseIntelligence = 200
        baseDefense = 0
        baseMagicDefense = 60
        baseLifesteal = 100
        immunityToStatus = 0.60
        criticalDamage = 2.0
        imageId = R.drawable.scarlet_mage
        idName = R.string.enemy_crimson_acolyte_name
        idDescription = R.string.enemy_crimson_acolyte_description
        passiveSkill = Skills.PASSIVE_NONE
        activeSkill = Skills.ACTIVE_SANGUINE_PYRE
        // Martyr's Pact: on death, every surviving enemy ally gains +1 permanent Sanguine Fervor stack.
        onDeathEffectsOnAllies.add(StatusEffect(StatusEffectType.SANGUINE_FERVOR, this, 0, 1.0))
    }

    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> = LinkedHashMap()

    override fun calculateCriticalChance(): Double = 0.60
}