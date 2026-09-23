package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper
import java.util.ArrayList
import java.util.LinkedHashMap

class ArchmagusValthex : Enemy() {
    override fun getMaxDamage(): Int = 250
    override fun getMinDamage(): Int = 200
    override fun isMagic(): Boolean = true
    override fun isRanged(): Boolean = true

    override fun configureStatistics() {
        baseMaxHp = 150000
        baseConstitution = 100
        baseDexterity = 300
        baseIntelligence = 600
        baseDefense = 10
        baseMagicDefense = 90
        baseLifesteal = 150
        immunityToStatus = 0.0
        criticalDamage = 1.5
        // Casts Scarlet Aeonia immediately on turn 1 (like Bleak Disciple).
        currentMana = 100
        threat = 1
        imageId = R.drawable.scarlet_grand_mage
        idName = R.string.enemy_archmagus_valthex_name
        idDescription = R.string.enemy_archmagus_valthex_description
        passiveSkill = Skills.PASSIVE_BLOOD_CONVOCATION
        activeSkill = Skills.ACTIVE_SCARLET_AEONIA
        rarity = 1
        expGiven = 50000
        onTargetHit = StatusEffect(StatusEffectType.BLOODFLAME, this, 3, 1.0)

        statusImmunities.add(StatusEffectType.ABLAZE)
        statusImmunities.add(StatusEffectType.BLOODFLAME)
    }

    /** All drops listed for the Bestiary / inspection UI. */
    override fun listDrops(i: Int): LinkedHashMap<ItemWrapper, Int> {
        val linkedHashMap = LinkedHashMap<ItemWrapper, Int>()
        linkedHashMap.put(ItemWrapper.getInstance("ScarletStrand", 1), 1000)
        linkedHashMap.put(ItemWrapper.getInstance("EsotericEgg", 1), 1000)
        linkedHashMap.put(ItemWrapper.getInstance("EldritchSeal", 1), 1000)
        linkedHashMap.put(ItemWrapper.getInstance("BlackHide", 1), 1000)
        linkedHashMap.put(ItemWrapper.getInstance("AbherrantFabric", 1), 1000)
        return linkedHashMap
    }

    /** Independent per-item rolls: 1% / 5% / 35% / 35% / 45%. */
    override fun rollDrops(evKey: Int): List<ItemWrapper> {
        val rolled = ArrayList<ItemWrapper>()
        if (Utils.random() < 0.01) rolled.add(ItemWrapper.getInstance("ScarletStrand", 1))
        if (Utils.random() < 0.05) rolled.add(ItemWrapper.getInstance("EsotericEgg", 1))
        if (Utils.random() < 0.35) rolled.add(ItemWrapper.getInstance("EldritchSeal", 1))
        if (Utils.random() < 0.35) rolled.add(ItemWrapper.getInstance("BlackHide", 1))
        if (Utils.random() < 0.45) rolled.add(ItemWrapper.getInstance("AbherrantFabric", 1))
        return rolled
    }

    override fun calculateCriticalChance(): Double = 1.0
}