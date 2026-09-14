package it.paranoidsquirrels.idleguildmaster.storage.data.quests

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import java.util.ArrayList
import java.util.Arrays
import java.util.Collections
import java.util.HashMap

object QuestsManager {
    @JvmField var QUEST_COMPLETED_RECENTLY = false
    @JvmField var QUEST_NOTIFICATION = false

    @JvmField var accessibleAfflictionQuests: MutableList<Quest>? = null
    @JvmField var accessibleControlQuests: MutableList<Quest>? = null
    @JvmField var accessibleFortitudeQuests: MutableList<Quest>? = null
    @JvmField var accessibleGraceQuests: MutableList<Quest>? = null
    @JvmField var accessibleIllusionQuests: MutableList<Quest>? = null
    @JvmField var accessibleKnowledgeQuests: MutableList<Quest>? = null
    @JvmField var accessibleQuests: MutableList<Quest>? = null
    @JvmField var accessibleRuinQuests: MutableList<Quest>? = null
    @JvmField var accessibleWarQuests: MutableList<Quest>? = null

    @JvmField var amountAffliction = 0
    @JvmField var amountControl = 0
    @JvmField var amountFortitude = 0
    @JvmField var amountGeneral = 5
    @JvmField var amountGrace = 0
    @JvmField var amountIllusion = 0
    @JvmField var amountKnowledge = 0
    @JvmField var amountRuin = 0
    @JvmField var amountWar = 0

    @JvmField var activeDeterrent: Quest? = null
    @JvmField var andStayDead: Quest? = null
    @JvmField var annihilator: Quest? = null
    @JvmField var botchedRitual: Quest? = null
    @JvmField var clashOfTitans: Quest? = null
    @JvmField var conqueror: Quest? = null
    @JvmField var coupDEtat: Quest? = null
    @JvmField var criticalHit: Quest? = null
    @JvmField var crystalClear: Quest? = null
    @JvmField var darknessWithin: Quest? = null
    @JvmField var delirious: Quest? = null
    @JvmField var eldritchHorror: Quest? = null
    @JvmField var endlessAgony: Quest? = null
    @JvmField var exorcism: Quest? = null
    @JvmField var expertDuelist: Quest? = null
    @JvmField var fallingApart: Quest? = null
    @JvmField var fastLearner: Quest? = null
    @JvmField var fromHell: Quest? = null
    @JvmField var godFeared: Quest? = null
    @JvmField var heavyArmor: Quest? = null
    @JvmField var hitOrMiss: Quest? = null
    @JvmField var iceBreaker: Quest? = null
    @JvmField var innocence: Quest? = null
    @JvmField var itsATrap: Quest? = null
    @JvmField var laroxianPower: Quest? = null
    @JvmField var lightBringer: Quest? = null
    @JvmField var longMarch: Quest? = null
    @JvmField var luckyRoll: Quest? = null
    @JvmField var marathon: Quest? = null
    @JvmField var masterCrafter: Quest? = null
    @JvmField var medic: Quest? = null
    @JvmField var miracle: Quest? = null
    @JvmField var myopia: Quest? = null
    @JvmField var niceTry: Quest? = null
    @JvmField var paleontologist: Quest? = null
    @JvmField var protector: Quest? = null
    @JvmField var psychiatrist: Quest? = null
    @JvmField var pulverization: Quest? = null
    @JvmField var ragingVolcano: Quest? = null
    @JvmField var regicide: Quest? = null
    @JvmField var shocking: Quest? = null
    @JvmField var slowBurn: Quest? = null
    @JvmField var smartFighter: Quest? = null
    @JvmField var smokingHot: Quest? = null
    @JvmField var softAndFluffy: Quest? = null
    @JvmField var soothingRemedy: Quest? = null
    @JvmField var speedyHare: Quest? = null
    @JvmField var spiky: Quest? = null
    @JvmField var student: Quest? = null
    @JvmField var tabulaRasa: Quest? = null
    @JvmField var thalassophobia: Quest? = null
    @JvmField var theEnd: Quest? = null
    @JvmField var tormentor: Quest? = null
    @JvmField var unscathed: Quest? = null
    @JvmField var vampiricThirst: Quest? = null
    @JvmField var warrior: Quest? = null

    @JvmStatic
    fun extractQuests() {
        val iCalculateDifficulty = calculateDifficulty()
        clearQuests(iCalculateDifficulty)
        setupDoctrineAmounts()
        setupAccessibleQuests(iCalculateDifficulty)
        extractAllQuests()
        QUEST_NOTIFICATION = true
        (MainActivity.dungeonsFragment.activity as? MainActivity)?.refreshIcons()
    }

    @JvmStatic
    fun calculateDifficulty(): Int {
        var i = 0
        for (area in Utils.compileDungeonList()) {
            if (area.isUnlocked) {
                i++
            }
        }
        return i
    }

    private fun clearQuests(i: Int) {
        MainActivity.data.kingsQuests.clear()
        MainActivity.data.afflictionQuests.clear()
        MainActivity.data.controlQuests.clear()
        MainActivity.data.fortitudeQuests.clear()
        MainActivity.data.graceQuests.clear()
        MainActivity.data.illusionQuests.clear()
        MainActivity.data.knowledgeQuests.clear()
        MainActivity.data.ruinQuests.clear()
        MainActivity.data.warQuests.clear()
        initializeFields(i)
    }

    @JvmStatic
    fun initializeFields(i: Int) {
        activeDeterrent = Quest.createInstance("ActiveDeterrent", 0, i, 0)
        andStayDead = Quest.createInstance("AndStayDead", 0, i, 0)
        annihilator = Quest.createInstance("Annihilator", 0, i, 0)
        botchedRitual = Quest.createInstance("BotchedRitual", 0, i, 0)
        clashOfTitans = Quest.createInstance("ClashOfTitans", 0, i, 0)
        conqueror = Quest.createInstance("Conqueror", 0, i, 0)
        coupDEtat = Quest.createInstance("CoupDEtat", 0, i, 0)
        criticalHit = Quest.createInstance("CriticalHit", 0, i, 0)
        crystalClear = Quest.createInstance("CrystalClear", 0, i, 0)
        darknessWithin = Quest.createInstance("DarknessWithin", 0, i, 0)
        delirious = Quest.createInstance("Delirious", 0, i, 0)
        eldritchHorror = Quest.createInstance("EldritchHorror", 0, i, 0)
        endlessAgony = Quest.createInstance("EndlessAgony", 0, i, 0)
        exorcism = Quest.createInstance("Exorcism", 0, i, 0)
        expertDuelist = Quest.createInstance("ExpertDuelist", 0, i, 0)
        fallingApart = Quest.createInstance("FallingApart", 0, i, 0)
        fastLearner = Quest.createInstance("FastLearner", 0, i, 0)
        fromHell = Quest.createInstance("FromHell", 0, i, 0)
        godFeared = Quest.createInstance("GodFeared", 0, i, 0)
        heavyArmor = Quest.createInstance("HeavyArmor", 0, i, 0)
        hitOrMiss = Quest.createInstance("HitOrMiss", 0, i, 0)
        iceBreaker = Quest.createInstance("IceBreaker", 0, i, 0)
        innocence = Quest.createInstance("Innocence", 0, i, 0)
        itsATrap = Quest.createInstance("ItsATrap", 0, i, 0)
        laroxianPower = Quest.createInstance("LaroxianPower", 0, i, 0)
        lightBringer = Quest.createInstance("LightBringer", 0, i, 0)
        longMarch = Quest.createInstance("LongMarch", 0, i, 0)
        luckyRoll = Quest.createInstance("LuckyRoll", 0, i, 0)
        marathon = Quest.createInstance("Marathon", 0, i, 0)
        masterCrafter = Quest.createInstance("MasterCrafter", 0, i, 0)
        medic = Quest.createInstance("Medic", 0, i, 0)
        miracle = Quest.createInstance("Miracle", 0, i, 0)
        myopia = Quest.createInstance("Myopia", 0, i, 0)
        niceTry = Quest.createInstance("NiceTry", 0, i, 0)
        protector = Quest.createInstance("Protector", 0, i, 0)
        psychiatrist = Quest.createInstance("Psychiatrist", 0, i, 0)
        pulverization = Quest.createInstance("Pulverization", 0, i, 0)
        ragingVolcano = Quest.createInstance("RagingVolcano", 0, i, 0)
        regicide = Quest.createInstance("Regicide", 0, i, 0)
        paleontologist = Quest.createInstance("Paleontologist", 0, i, 0)
        shocking = Quest.createInstance("Shocking", 0, i, 0)
        slowBurn = Quest.createInstance("SlowBurn", 0, i, 0)
        smartFighter = Quest.createInstance("SmartFighter", 0, i, 0)
        smokingHot = Quest.createInstance("SmokingHot", 0, i, 0)
        softAndFluffy = Quest.createInstance("SoftAndFluffy", 0, i, 0)
        soothingRemedy = Quest.createInstance("SoothingRemedy", 0, i, 0)
        speedyHare = Quest.createInstance("SpeedyHare", 0, i, 0)
        spiky = Quest.createInstance("Spiky", 0, i, 0)
        student = Quest.createInstance("Student", 0, i, 0)
        tabulaRasa = Quest.createInstance("TabulaRasa", 0, i, 0)
        thalassophobia = Quest.createInstance("Thalassophobia", 0, i, 0)
        theEnd = Quest.createInstance("TheEnd", 0, i, 0)
        tormentor = Quest.createInstance("Tormentor", 0, i, 0)
        unscathed = Quest.createInstance("Unscathed", 0, i, 0)
        vampiricThirst = Quest.createInstance("VampiricThirst", 0, i, 0)
        warrior = Quest.createInstance("Warrior", 0, i, 0)
    }

    private fun setupDoctrineAmounts() {
        val map = HashMap<String, Int>()
        if (MainActivity.data.afflictionLevel < 10) {
            map["DoctrineOfAffliction"] = 0
        }
        if (MainActivity.data.controlLevel < 10) {
            map["DoctrineOfControl"] = 0
        }
        if (MainActivity.data.fortitudeLevel < 10) {
            map["DoctrineOfFortitude"] = 0
        }
        if (MainActivity.data.graceLevel < 10) {
            map["DoctrineOfGrace"] = 0
        }
        if (MainActivity.data.illusionLevel < 10) {
            map["DoctrineOfIllusion"] = 0
        }
        if (MainActivity.data.knowledgeLevel < 10) {
            map["DoctrineOfKnowledge"] = 0
        }
        if (MainActivity.data.ruinLevel < 10) {
            map["DoctrineOfRuin"] = 0
        }
        if (MainActivity.data.warLevel < 10) {
            map["DoctrineOfWar"] = 0
        }
        amountAffliction = 0
        amountControl = 0
        amountFortitude = 0
        amountGrace = 0
        amountIllusion = 0
        amountKnowledge = 0
        amountRuin = 0
        amountWar = 0
        if (map.isEmpty()) {
            return
        }
        var i = 2
        for (adventurer in MainActivity.data.adventurers) {
            val i2 = if (adventurer.getId() >= 0 || i <= 0) 1 else 2
            if (i2 > 1) {
                i--
            }
            incrementOrAssignToRandom(map, adventurer.getDoctrine(), i2)
        }
        for (entry in map.entries) {
            when (entry.key) {
                "DoctrineOfRuin" -> amountRuin += entry.value
                "DoctrineOfKnowledge" -> amountKnowledge += entry.value
                "DoctrineOfFortitude" -> amountFortitude += entry.value
                "DoctrineOfGrace" -> amountGrace += entry.value
                "DoctrineOfIllusion" -> amountIllusion += entry.value
                "DoctrineOfControl" -> amountControl += entry.value
                "DoctrineOfAffliction" -> amountAffliction += entry.value
                "DoctrineOfWar" -> amountWar += entry.value
            }
        }
    }

    private fun incrementOrAssignToRandom(map: MutableMap<String, Int>, doctrine: Doctrine?, i: Int) {
        val trueClass = doctrine?.getTrueClass() ?: return
        if (trueClass == "EmptyDoctrine") {
            return
        }
        if (map.containsKey(trueClass)) {
            map[trueClass] = (map[trueClass] ?: 0) + i
            return
        }
        val iRandom = (Utils.random() * map.size.toDouble()).toInt()
        var str: String? = null
        var i2 = 0
        for (str2 in map.keys) {
            if (i2 == iRandom) {
                str = str2
            }
            i2++
        }
        if (str != null) {
            map[str] = (map[str] ?: 0) + i
        }
    }

    private fun setupAccessibleQuests(i: Int) {
        val allQuests = listOfNotNull(
            activeDeterrent, andStayDead, annihilator, botchedRitual, clashOfTitans, conqueror,
            coupDEtat, criticalHit, crystalClear, darknessWithin, delirious, eldritchHorror,
            endlessAgony, exorcism, expertDuelist, fallingApart, fastLearner, fromHell,
            godFeared, heavyArmor, hitOrMiss, iceBreaker, innocence, itsATrap,
            laroxianPower, lightBringer, longMarch, luckyRoll, marathon, masterCrafter,
            medic, miracle, myopia, niceTry, protector, psychiatrist,
            pulverization, ragingVolcano, regicide, shocking, slowBurn, smartFighter,
            smokingHot, softAndFluffy, soothingRemedy, speedyHare, spiky, student,
            tabulaRasa, thalassophobia, theEnd, tormentor, unscathed, vampiricThirst,
            warrior, paleontologist
        )
        accessibleQuests = ArrayList(allQuests)
        accessibleAfflictionQuests = ArrayList(listOfNotNull(laroxianPower, slowBurn, smokingHot, spiky, tormentor, vampiricThirst, shocking))
        accessibleControlQuests = ArrayList(listOfNotNull(clashOfTitans, delirious, godFeared, regicide, iceBreaker, theEnd, innocence))
        accessibleFortitudeQuests = ArrayList(listOfNotNull(unscathed, fallingApart, protector, heavyArmor, softAndFluffy, speedyHare, coupDEtat))
        accessibleGraceQuests = ArrayList(listOfNotNull(medic, lightBringer, soothingRemedy, psychiatrist, andStayDead, miracle, darknessWithin))
        accessibleIllusionQuests = ArrayList(listOfNotNull(hitOrMiss, luckyRoll, itsATrap, niceTry, eldritchHorror, activeDeterrent, marathon))
        accessibleKnowledgeQuests = ArrayList(listOfNotNull(student, myopia, paleontologist, masterCrafter, fromHell, fastLearner, exorcism))
        accessibleRuinQuests = ArrayList(listOfNotNull(annihilator, smartFighter, criticalHit, coupDEtat, botchedRitual, pulverization, thalassophobia))
        accessibleWarQuests = ArrayList(listOfNotNull(expertDuelist, warrior, longMarch, conqueror, endlessAgony, tabulaRasa, ragingVolcano))

        prepareList(accessibleQuests, i)
        prepareList(accessibleAfflictionQuests, i)
        prepareList(accessibleControlQuests, i)
        prepareList(accessibleFortitudeQuests, i)
        prepareList(accessibleGraceQuests, i)
        prepareList(accessibleIllusionQuests, i)
        prepareList(accessibleKnowledgeQuests, i)
        prepareList(accessibleRuinQuests, i)
        prepareList(accessibleWarQuests, i)
    }

    private fun prepareList(list: MutableList<Quest>?, i: Int) {
        list?.removeAll { it.getMinimumDifficulty() > i }
        if (list != null) {
            Collections.shuffle(list)
        }
    }

    private fun extractAllQuests() {
        if (MainActivity.data.adventurers.isEmpty()) {
            return
        }
        MainActivity.data.isQuestsSeen = true
        MainActivity.data.isQuestsRefreshed = false
        extractSpecificQuests(amountAffliction, accessibleAfflictionQuests, MainActivity.data.afflictionQuests)
        extractSpecificQuests(amountControl, accessibleControlQuests, MainActivity.data.controlQuests)
        extractSpecificQuests(amountFortitude, accessibleFortitudeQuests, MainActivity.data.fortitudeQuests)
        extractSpecificQuests(amountGrace, accessibleGraceQuests, MainActivity.data.graceQuests)
        extractSpecificQuests(amountIllusion, accessibleIllusionQuests, MainActivity.data.illusionQuests)
        extractSpecificQuests(amountKnowledge, accessibleKnowledgeQuests, MainActivity.data.knowledgeQuests)
        extractSpecificQuests(amountRuin, accessibleRuinQuests, MainActivity.data.ruinQuests)
        extractSpecificQuests(amountWar, accessibleWarQuests, MainActivity.data.warQuests)
        extractSpecificQuests(amountGeneral, accessibleQuests, MainActivity.data.kingsQuests)
    }

    private fun extractSpecificQuests(i: Int, list: MutableList<Quest>?, list2: MutableList<Quest>) {
        if (list == null) return
        for (i2 in 0 until i) {
            val iRollRarity = rollRarity()
            var fromListByRarity = getFromListByRarity(list, iRollRarity)
            if (fromListByRarity == null) {
                if (list != MainActivity.data.kingsQuests) {
                    fromListByRarity = getFromListByRarity(accessibleQuests, iRollRarity)
                }
                if (fromListByRarity == null) {
                    val acc = accessibleQuests
                    if (acc != null && acc.isNotEmpty()) {
                        fromListByRarity = acc[0]
                    } else {
                        break
                    }
                }
            }
            if (fromListByRarity != null) {
                removeFromAllLists(fromListByRarity)
                val cannot = fromListByRarity.cannotAppearWith()
                if (cannot != null) {
                    removeFromAllLists(cannot)
                }
                fromListByRarity.setRarity(iRollRarity)
                fromListByRarity.activate()
                list2.add(fromListByRarity)
            }
        }
        list2.sortWith { q1, q2 -> q2.getRarity() - q1.getRarity() }
    }

    private fun removeFromAllLists(quest: Quest) {
        accessibleAfflictionQuests?.remove(quest)
        accessibleControlQuests?.remove(quest)
        accessibleFortitudeQuests?.remove(quest)
        accessibleGraceQuests?.remove(quest)
        accessibleIllusionQuests?.remove(quest)
        accessibleKnowledgeQuests?.remove(quest)
        accessibleRuinQuests?.remove(quest)
        accessibleWarQuests?.remove(quest)
        accessibleQuests?.remove(quest)
    }

    private fun rollRarity(): Int {
        val dRandom = Utils.random()
        if (dRandom < 0.7) {
            return 1
        }
        if (dRandom < 0.9) {
            return 2
        }
        return if (dRandom < 0.97) 3 else 4
    }

    private fun getFromListByRarity(list: List<Quest>?, i: Int): Quest? {
        if (list == null) return null
        for (quest in list) {
            if (quest.getDefaultRarity() == i) {
                return quest
            }
        }
        return null
    }

    @JvmStatic
    fun realignQuests() {
        for (quest in MainActivity.data.kingsQuests) quest.realignStaticReference()
        for (quest in MainActivity.data.afflictionQuests) quest.realignStaticReference()
        for (quest in MainActivity.data.controlQuests) quest.realignStaticReference()
        for (quest in MainActivity.data.fortitudeQuests) quest.realignStaticReference()
        for (quest in MainActivity.data.graceQuests) quest.realignStaticReference()
        for (quest in MainActivity.data.illusionQuests) quest.realignStaticReference()
        for (quest in MainActivity.data.knowledgeQuests) quest.realignStaticReference()
        for (quest in MainActivity.data.ruinQuests) quest.realignStaticReference()
        for (quest in MainActivity.data.warQuests) quest.realignStaticReference()
    }

    @JvmStatic
    fun increment(quest: Quest?, j: Long) {
        if (quest == null || !quest.isActive() || j <= 0) {
            return
        }
        val progress = quest.getProgress()
        val target = quest.getTargetProgress()
        if (progress < target) {
            val j2 = progress + j
            quest.setProgress(j2)
            if (j2 >= target) {
                QUEST_COMPLETED_RECENTLY = true
            }
        }
    }

    @JvmStatic
    fun incrementToValue(quest: Quest?, j: Long) {
        if (quest == null || !quest.isActive() || j <= 0 || quest.getProgress() >= quest.getTargetProgress()) {
            return
        }
        quest.setProgress(j)
        if (j >= quest.getTargetProgress()) {
            QUEST_COMPLETED_RECENTLY = true
        }
    }
}
