package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies

import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.LinkedHashMap

class EliteEnemy private constructor(val base: Enemy) : Enemy() {

    init {
        copyCombatState(base)
    }

    companion object {
        @JvmStatic
        fun forClass(baseClass: String?): EliteEnemy? {
            if (baseClass.isNullOrBlank()) return null
            val base = Enemy.getInstance(baseClass) ?: return null
            return createElite(base)
        }

        @JvmStatic
        fun createElite(base: Enemy?): EliteEnemy? {
            if (base == null) return null
            val elite = EliteEnemy(base)
            elite.trueClass = "Elite_" + base.trueClass
            elite.currentHp = elite.calculateTotalMaxHp()
            elite.currentMana = 0
            elite.currentShield = 0
            return elite
        }

        @JvmStatic
        fun forTrueClass(trueClass: String?): EliteEnemy? {
            if (trueClass == null || !trueClass.startsWith("Elite_")) return null
            return forClass(trueClass.substring("Elite_".length))
        }
    }

    private fun copyCombatState(source: Enemy) {
        baseMaxHp = source.calculateTotalMaxHp() * 2
        baseDefense = source.calculateTotalDefense() * 2
        baseMagicDefense = source.calculateTotalMagicDefense() * 2
        baseConstitution = source.calculateTotalConstitution() * 2
        baseIntelligence = source.calculateTotalIntelligence() * 2
        baseDexterity = source.calculateTotalDexterity() * 2
        baseLifesteal = source.calculateTotalLifesteal() * 2
        expGiven = source.getExpGiven() * 2
        imageId = source.imageId
        idName = source.idName
        idDescription = source.idDescription
        passiveSkill = source.passiveSkill
        activeSkill = source.activeSkill
        rarity = source.getRarity()
        initiative = source.initiative
        alwaysHits = source.alwaysHits
    }

    override fun configureStatistics() {}
    override fun getMinDamage(): Int = base.calculateMinAttackDamage() * 2
    override fun getMaxDamage(): Int = base.calculateMaxAttackDamage() * 2
    override fun listDrops(rarity: Int): LinkedHashMap<ItemWrapper, Int> = base.listDrops(rarity)
    override fun isRanged(): Boolean = base.isRanged()
    override fun isMagic(): Boolean = base.isMagic()
    override fun getEnemyType(): EnemyType = base.getEnemyType()
}
