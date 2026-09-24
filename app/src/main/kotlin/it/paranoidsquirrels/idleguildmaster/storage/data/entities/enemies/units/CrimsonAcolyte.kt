package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.ArrayList
import java.util.LinkedHashMap

class CrimsonAcolyte : Enemy() {
    override fun getMaxDamage(): Int = 200
    override fun getMinDamage(): Int = 100
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 3000
        baseConstitution = 80
        baseDexterity = 50
        baseIntelligence = 200
        baseDefense = 0
        baseMagicDefense = 60
        baseLifesteal = 100
        immunityToStatus = 0.0
        criticalDamage = 2.0
        onTargetHit = StatusEffect(StatusEffectType.BLOODFLAME, this, 3, 1.0)
        // Casts Sanguine Pyre immediately on turn 1 (like Bleak Disciple).
        currentMana = 100
        threat = 4
        imageId = R.drawable.scarlet_mage
        idName = R.string.enemy_crimson_acolyte_name
        idDescription = R.string.enemy_crimson_acolyte_description
        passiveSkill = Skills.PASSIVE_MARTYRS_PACT
        activeSkill = Skills.ACTIVE_SANGUINE_PYRE
        rarity = 1
        expGiven = 2500


        // Hard immune to elemental effects
        statusImmunities.add(StatusEffectType.ABLAZE)
        statusImmunities.add(StatusEffectType.BLOODFLAME)

        // Martyr's Pact: on death, every surviving enemy ally gains +1 permanent
        // Sanguine Fervor stack (consolidated into a single status, count in turnsLeft).
        onDeathEffectsOnAllies.add(StatusEffect(StatusEffectType.SANGUINE_FERVOR, this, 1, 1.0))
    }

    /** All drops listed for the Bestiary / inspection UI. */
    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("EsotericEgg", 1), 1000)
        linkedHashMap.put(ItemWrapper.getInstance("EldritchSeal", 1), 1000)
        linkedHashMap.put(ItemWrapper.getInstance("BlackHide", 1), 1000)
        linkedHashMap.put(ItemWrapper.getInstance("AbherrantFabric", 1), 1000)
        return linkedHashMap
    }

    /** Independent per-item rolls: 5% / 15% / 15% / 15%. */
    override fun rollDrops(evKey: Int): List<ItemWrapper> {
        val rolled = ArrayList<ItemWrapper>()
        if (Utils.random() < 0.05) rolled.add(ItemWrapper.getInstance("EsotericEgg", 1))
        if (Utils.random() < 0.15) rolled.add(ItemWrapper.getInstance("EldritchSeal", 1))
        if (Utils.random() < 0.15) rolled.add(ItemWrapper.getInstance("BlackHide", 1))
        if (Utils.random() < 0.15) rolled.add(ItemWrapper.getInstance("AbherrantFabric", 1))
        return rolled
    }

    override fun calculateCriticalChance(): Double = 0.60
}