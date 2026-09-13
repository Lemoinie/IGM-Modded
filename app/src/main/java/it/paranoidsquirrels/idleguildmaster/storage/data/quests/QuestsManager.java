package it.paranoidsquirrels.idleguildmaster.storage.data.quests;

import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
public class QuestsManager {
    public static boolean QUEST_COMPLETED_RECENTLY = false;
    public static boolean QUEST_NOTIFICATION = false;
    static List<Quest> accessibleAfflictionQuests = null;
    static List<Quest> accessibleControlQuests = null;
    static List<Quest> accessibleFortitudeQuests = null;
    static List<Quest> accessibleGraceQuests = null;
    static List<Quest> accessibleIllusionQuests = null;
    static List<Quest> accessibleKnowledgeQuests = null;
    static List<Quest> accessibleQuests = null;
    static List<Quest> accessibleRuinQuests = null;
    static List<Quest> accessibleWarQuests = null;
    public static Quest activeDeterrent = null;
    static int amountAffliction = 0;
    static int amountControl = 0;
    static int amountFortitude = 0;
    static int amountGeneral = 5;
    static int amountGrace;
    static int amountIllusion;
    static int amountKnowledge;
    static int amountRuin;
    static int amountWar;
    public static Quest andStayDead;
    public static Quest annihilator;
    public static Quest botchedRitual;
    public static Quest clashOfTitans;
    public static Quest conqueror;
    public static Quest coupDEtat;
    public static Quest criticalHit;
    public static Quest crystalClear;
    public static Quest darknessWithin;
    public static Quest delirious;
    public static Quest eldritchHorror;
    public static Quest endlessAgony;
    public static Quest exorcism;
    public static Quest expertDuelist;
    public static Quest fallingApart;
    public static Quest fastLearner;
    public static Quest fromHell;
    public static Quest godFeared;
    public static Quest heavyArmor;
    public static Quest hitOrMiss;
    public static Quest iceBreaker;
    public static Quest innocence;
    public static Quest itsATrap;
    public static Quest laroxianPower;
    public static Quest lightBringer;
    public static Quest longMarch;
    public static Quest luckyRoll;
    public static Quest marathon;
    public static Quest masterCrafter;
    public static Quest medic;
    public static Quest miracle;
    public static Quest myopia;
    public static Quest niceTry;
    public static Quest paleontologist;
    public static Quest protector;
    public static Quest psychiatrist;
    public static Quest pulverization;
    public static Quest ragingVolcano;
    public static Quest regicide;
    public static Quest shocking;
    public static Quest slowBurn;
    public static Quest smartFighter;
    public static Quest smokingHot;
    public static Quest softAndFluffy;
    public static Quest soothingRemedy;
    public static Quest speedyHare;
    public static Quest spiky;
    public static Quest student;
    public static Quest tabulaRasa;
    public static Quest thalassophobia;
    public static Quest theEnd;
    public static Quest tormentor;
    public static Quest unscathed;
    public static Quest vampiricThirst;
    public static Quest warrior;

    public static void extractQuests() {
        int iCalculateDifficulty = calculateDifficulty();
        clearQuests(iCalculateDifficulty);
        setupDoctrineAmounts();
        setupAccessibleQuests(iCalculateDifficulty);
        extractAllQuests();
        QUEST_NOTIFICATION = true;
        ((MainActivity) MainActivity.dungeonsFragment.getActivity()).refreshIcons();
    }

    public static int calculateDifficulty() {
        Iterator<Area> it2 = Utils.compileDungeonList().iterator();
        int i = 0;
        while (it2.hasNext() && it2.next().isUnlocked()) {
            i++;
        }
        return i;
    }

    private static void clearQuests(int i) {
        MainActivity.data.getKingsQuests().clear();
        MainActivity.data.getAfflictionQuests().clear();
        MainActivity.data.getControlQuests().clear();
        MainActivity.data.getFortitudeQuests().clear();
        MainActivity.data.getGraceQuests().clear();
        MainActivity.data.getIllusionQuests().clear();
        MainActivity.data.getKnowledgeQuests().clear();
        MainActivity.data.getRuinQuests().clear();
        MainActivity.data.getWarQuests().clear();
        initializeFields(i);
    }

    public static void initializeFields(int i) {
        activeDeterrent = Quest.createInstance("ActiveDeterrent", 0, i, 0);
        andStayDead = Quest.createInstance("AndStayDead", 0, i, 0);
        annihilator = Quest.createInstance("Annihilator", 0, i, 0);
        botchedRitual = Quest.createInstance("BotchedRitual", 0, i, 0);
        clashOfTitans = Quest.createInstance("ClashOfTitans", 0, i, 0);
        conqueror = Quest.createInstance("Conqueror", 0, i, 0);
        coupDEtat = Quest.createInstance("CoupDEtat", 0, i, 0);
        criticalHit = Quest.createInstance("CriticalHit", 0, i, 0);
        crystalClear = Quest.createInstance("CrystalClear", 0, i, 0);
        darknessWithin = Quest.createInstance("DarknessWithin", 0, i, 0);
        delirious = Quest.createInstance("Delirious", 0, i, 0);
        eldritchHorror = Quest.createInstance("EldritchHorror", 0, i, 0);
        endlessAgony = Quest.createInstance("EndlessAgony", 0, i, 0);
        exorcism = Quest.createInstance("Exorcism", 0, i, 0);
        expertDuelist = Quest.createInstance("ExpertDuelist", 0, i, 0);
        fallingApart = Quest.createInstance("FallingApart", 0, i, 0);
        fastLearner = Quest.createInstance("FastLearner", 0, i, 0);
        fromHell = Quest.createInstance("FromHell", 0, i, 0);
        godFeared = Quest.createInstance("GodFeared", 0, i, 0);
        heavyArmor = Quest.createInstance("HeavyArmor", 0, i, 0);
        hitOrMiss = Quest.createInstance("HitOrMiss", 0, i, 0);
        iceBreaker = Quest.createInstance("IceBreaker", 0, i, 0);
        innocence = Quest.createInstance("Innocence", 0, i, 0);
        itsATrap = Quest.createInstance("ItsATrap", 0, i, 0);
        laroxianPower = Quest.createInstance("LaroxianPower", 0, i, 0);
        lightBringer = Quest.createInstance("LightBringer", 0, i, 0);
        longMarch = Quest.createInstance("LongMarch", 0, i, 0);
        luckyRoll = Quest.createInstance("LuckyRoll", 0, i, 0);
        marathon = Quest.createInstance("Marathon", 0, i, 0);
        masterCrafter = Quest.createInstance("MasterCrafter", 0, i, 0);
        medic = Quest.createInstance("Medic", 0, i, 0);
        miracle = Quest.createInstance("Miracle", 0, i, 0);
        myopia = Quest.createInstance("Myopia", 0, i, 0);
        niceTry = Quest.createInstance("NiceTry", 0, i, 0);
        protector = Quest.createInstance("Protector", 0, i, 0);
        psychiatrist = Quest.createInstance("Psychiatrist", 0, i, 0);
        pulverization = Quest.createInstance("Pulverization", 0, i, 0);
        ragingVolcano = Quest.createInstance("RagingVolcano", 0, i, 0);
        regicide = Quest.createInstance("Regicide", 0, i, 0);
        paleontologist = Quest.createInstance("Paleontologist", 0, i, 0);
        shocking = Quest.createInstance("Shocking", 0, i, 0);
        slowBurn = Quest.createInstance("SlowBurn", 0, i, 0);
        smartFighter = Quest.createInstance("SmartFighter", 0, i, 0);
        smokingHot = Quest.createInstance("SmokingHot", 0, i, 0);
        softAndFluffy = Quest.createInstance("SoftAndFluffy", 0, i, 0);
        soothingRemedy = Quest.createInstance("SoothingRemedy", 0, i, 0);
        speedyHare = Quest.createInstance("SpeedyHare", 0, i, 0);
        spiky = Quest.createInstance("Spiky", 0, i, 0);
        student = Quest.createInstance("Student", 0, i, 0);
        tabulaRasa = Quest.createInstance("TabulaRasa", 0, i, 0);
        thalassophobia = Quest.createInstance("Thalassophobia", 0, i, 0);
        theEnd = Quest.createInstance("TheEnd", 0, i, 0);
        tormentor = Quest.createInstance("Tormentor", 0, i, 0);
        unscathed = Quest.createInstance("Unscathed", 0, i, 0);
        vampiricThirst = Quest.createInstance("VampiricThirst", 0, i, 0);
        warrior = Quest.createInstance("Warrior", 0, i, 0);
    }

    private static void setupDoctrineAmounts() {
        HashMap<String, Integer> map = new HashMap<>();
        if (MainActivity.data.getAfflictionLevel() < 10) {
            map.put("DoctrineOfAffliction", 0);
        }
        if (MainActivity.data.getControlLevel() < 10) {
            map.put("DoctrineOfControl", 0);
        }
        if (MainActivity.data.getFortitudeLevel() < 10) {
            map.put("DoctrineOfFortitude", 0);
        }
        if (MainActivity.data.getGraceLevel() < 10) {
            map.put("DoctrineOfGrace", 0);
        }
        if (MainActivity.data.getIllusionLevel() < 10) {
            map.put("DoctrineOfIllusion", 0);
        }
        if (MainActivity.data.getKnowledgeLevel() < 10) {
            map.put("DoctrineOfKnowledge", 0);
        }
        if (MainActivity.data.getRuinLevel() < 10) {
            map.put("DoctrineOfRuin", 0);
        }
        if (MainActivity.data.getWarLevel() < 10) {
            map.put("DoctrineOfWar", 0);
        }
        amountAffliction = 0;
        amountControl = 0;
        amountFortitude = 0;
        amountGrace = 0;
        amountIllusion = 0;
        amountKnowledge = 0;
        amountRuin = 0;
        amountWar = 0;
        if (map.isEmpty()) {
            return;
        }
        int i = 2;
        for (Adventurer adventurer : MainActivity.data.getAdventurers()) {
            int i2 = (adventurer.getId() >= 0 || i <= 0) ? 1 : 2;
            if (i2 > 1) {
                i--;
            }
            incrementOrAssignToRandom(map, adventurer.getDoctrine(), i2);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String str = (String) entry.getKey();
            str.hashCode();
            switch (str) {
                case "DoctrineOfRuin":
                    amountRuin += ((Integer) entry.getValue()).intValue();
                    break;
                case "DoctrineOfKnowledge":
                    amountKnowledge += ((Integer) entry.getValue()).intValue();
                    break;
                case "DoctrineOfFortitude":
                    amountFortitude += ((Integer) entry.getValue()).intValue();
                    break;
                case "DoctrineOfGrace":
                    amountGrace += ((Integer) entry.getValue()).intValue();
                    break;
                case "DoctrineOfIllusion":
                    amountIllusion += ((Integer) entry.getValue()).intValue();
                    break;
                case "DoctrineOfControl":
                    amountControl += ((Integer) entry.getValue()).intValue();
                    break;
                case "DoctrineOfAffliction":
                    amountAffliction += ((Integer) entry.getValue()).intValue();
                    break;
                case "DoctrineOfWar":
                    amountWar += ((Integer) entry.getValue()).intValue();
                    break;
            }
        }
    }

    private static void incrementOrAssignToRandom(Map<String, Integer> map, Doctrine doctrine, int i) {
        String trueClass = doctrine.getTrueClass();
        if (trueClass.equals("EmptyDoctrine")) {
            return;
        }
        if (map.containsKey(trueClass)) {
            map.put(trueClass, Integer.valueOf(map.get(trueClass).intValue() + i));
            return;
        }
        int iRandom = (int) (Utils.random() * ((double) map.size()));
        String str = null;
        int i2 = 0;
        for (String str2 : map.keySet()) {
            if (i2 == iRandom) {
                str = str2;
            }
            i2++;
        }
        map.put(str, Integer.valueOf(map.get(str).intValue() + i));
    }

    private static void setupAccessibleQuests(int i) {
        accessibleQuests = new ArrayList(Arrays.asList(activeDeterrent, andStayDead, annihilator, botchedRitual, clashOfTitans, conqueror, coupDEtat, criticalHit, crystalClear, darknessWithin, delirious, eldritchHorror, endlessAgony, exorcism, expertDuelist, fallingApart, fastLearner, fromHell, godFeared, heavyArmor, hitOrMiss, iceBreaker, innocence, itsATrap, laroxianPower, lightBringer, longMarch, luckyRoll, marathon, masterCrafter, medic, miracle, myopia, niceTry, protector, psychiatrist, pulverization, ragingVolcano, regicide, paleontologist, shocking, slowBurn, smartFighter, smokingHot, softAndFluffy, soothingRemedy, speedyHare, spiky, student, tabulaRasa, thalassophobia, theEnd, tormentor, unscathed, vampiricThirst, warrior));
        accessibleAfflictionQuests = new ArrayList(Arrays.asList(vampiricThirst, fallingApart, theEnd, innocence, softAndFluffy, tormentor, delirious));
        accessibleControlQuests = new ArrayList(Arrays.asList(smokingHot, shocking, slowBurn, iceBreaker, regicide, crystalClear, laroxianPower));
        accessibleFortitudeQuests = new ArrayList(Arrays.asList(heavyArmor, spiky, protector, speedyHare, clashOfTitans, unscathed, godFeared));
        accessibleGraceQuests = new ArrayList(Arrays.asList(medic, lightBringer, soothingRemedy, psychiatrist, andStayDead, miracle, darknessWithin));
        accessibleIllusionQuests = new ArrayList(Arrays.asList(hitOrMiss, luckyRoll, itsATrap, niceTry, eldritchHorror, activeDeterrent, marathon));
        accessibleKnowledgeQuests = new ArrayList(Arrays.asList(student, myopia, paleontologist, masterCrafter, fromHell, fastLearner, exorcism));
        accessibleRuinQuests = new ArrayList(Arrays.asList(annihilator, smartFighter, criticalHit, coupDEtat, botchedRitual, pulverization, thalassophobia));
        accessibleWarQuests = new ArrayList(Arrays.asList(expertDuelist, warrior, longMarch, conqueror, endlessAgony, tabulaRasa, ragingVolcano));
        prepareList(accessibleQuests, i);
        prepareList(accessibleAfflictionQuests, i);
        prepareList(accessibleControlQuests, i);
        prepareList(accessibleFortitudeQuests, i);
        prepareList(accessibleGraceQuests, i);
        prepareList(accessibleIllusionQuests, i);
        prepareList(accessibleKnowledgeQuests, i);
        prepareList(accessibleRuinQuests, i);
        prepareList(accessibleWarQuests, i);
    }

    static /* synthetic */ boolean lambda$prepareList$0(int i, Quest quest) {
        return quest.minimumDifficulty > i;
    }

    private static void prepareList(List<Quest> list, final int i) {
        list.removeIf(new Predicate() { // from class: it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return QuestsManager.lambda$prepareList$0(i, (Quest) obj);
            }
        });
        Collections.shuffle(list);
    }

    private static void extractAllQuests() {
        if (MainActivity.data.getAdventurers().isEmpty()) {
            return;
        }
        MainActivity.data.setQuestsSeen(true);
        MainActivity.data.setQuestsRefreshed(false);
        extractSpecificQuests(amountAffliction, accessibleAfflictionQuests, MainActivity.data.getAfflictionQuests());
        extractSpecificQuests(amountControl, accessibleControlQuests, MainActivity.data.getControlQuests());
        extractSpecificQuests(amountFortitude, accessibleFortitudeQuests, MainActivity.data.getFortitudeQuests());
        extractSpecificQuests(amountGrace, accessibleGraceQuests, MainActivity.data.getGraceQuests());
        extractSpecificQuests(amountIllusion, accessibleIllusionQuests, MainActivity.data.getIllusionQuests());
        extractSpecificQuests(amountKnowledge, accessibleKnowledgeQuests, MainActivity.data.getKnowledgeQuests());
        extractSpecificQuests(amountRuin, accessibleRuinQuests, MainActivity.data.getRuinQuests());
        extractSpecificQuests(amountWar, accessibleWarQuests, MainActivity.data.getWarQuests());
        extractSpecificQuests(amountGeneral, accessibleQuests, MainActivity.data.getKingsQuests());
    }

    private static void extractSpecificQuests(int i, List<Quest> list, List<Quest> list2) {
        for (int i2 = 0; i2 < i; i2++) {
            int iRollRarity = rollRarity();
            Quest fromListByRarity = getFromListByRarity(list, iRollRarity);
            if (fromListByRarity == null) {
                if (list != MainActivity.data.getKingsQuests()) {
                    fromListByRarity = getFromListByRarity(accessibleQuests, iRollRarity);
                }
                if (fromListByRarity == null) {
                    if (accessibleQuests.size() <= 0) {
                        break;
                    } else {
                        fromListByRarity = accessibleQuests.get(0);
                    }
                }
            }
            removeFromAllLists(fromListByRarity);
            if (fromListByRarity.cannotAppearWith() != null) {
                removeFromAllLists(fromListByRarity.cannotAppearWith());
            }
            fromListByRarity.setRarity(iRollRarity);
            fromListByRarity.activate();
            list2.add(fromListByRarity);
        }
        list2.sort(new Comparator() { // from class: it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return QuestsManager.lambda$extractSpecificQuests$1((Quest) obj, (Quest) obj2);
            }
        });
    }

    static /* synthetic */ int lambda$extractSpecificQuests$1(Quest quest, Quest quest2) {
        return quest2.getRarity() - quest.getRarity();
    }

    private static void removeFromAllLists(Quest quest) {
        accessibleAfflictionQuests.remove(quest);
        accessibleControlQuests.remove(quest);
        accessibleFortitudeQuests.remove(quest);
        accessibleGraceQuests.remove(quest);
        accessibleIllusionQuests.remove(quest);
        accessibleKnowledgeQuests.remove(quest);
        accessibleRuinQuests.remove(quest);
        accessibleWarQuests.remove(quest);
        accessibleQuests.remove(quest);
    }

    private static int rollRarity() {
        double dRandom = Utils.random();
        if (dRandom < 0.7d) {
            return 1;
        }
        if (dRandom < 0.9d) {
            return 2;
        }
        return dRandom < 0.97d ? 3 : 4;
    }

    private static Quest getFromListByRarity(List<Quest> list, int i) {
        for (Quest quest : list) {
            if (quest.defaultRarity == i) {
                return quest;
            }
        }
        return null;
    }

    public static void realignQuests() {
        Iterator<Quest> it2 = MainActivity.data.getKingsQuests().iterator();
        while (it2.hasNext()) {
            it2.next().realignStaticReference();
        }
        Iterator<Quest> it3 = MainActivity.data.getAfflictionQuests().iterator();
        while (it3.hasNext()) {
            it3.next().realignStaticReference();
        }
        Iterator<Quest> it4 = MainActivity.data.getControlQuests().iterator();
        while (it4.hasNext()) {
            it4.next().realignStaticReference();
        }
        Iterator<Quest> it5 = MainActivity.data.getFortitudeQuests().iterator();
        while (it5.hasNext()) {
            it5.next().realignStaticReference();
        }
        Iterator<Quest> it6 = MainActivity.data.getGraceQuests().iterator();
        while (it6.hasNext()) {
            it6.next().realignStaticReference();
        }
        Iterator<Quest> it7 = MainActivity.data.getIllusionQuests().iterator();
        while (it7.hasNext()) {
            it7.next().realignStaticReference();
        }
        Iterator<Quest> it8 = MainActivity.data.getKnowledgeQuests().iterator();
        while (it8.hasNext()) {
            it8.next().realignStaticReference();
        }
        Iterator<Quest> it9 = MainActivity.data.getRuinQuests().iterator();
        while (it9.hasNext()) {
            it9.next().realignStaticReference();
        }
        Iterator<Quest> it10 = MainActivity.data.getWarQuests().iterator();
        while (it10.hasNext()) {
            it10.next().realignStaticReference();
        }
    }

    public static void increment(Quest quest, long j) {
        if (quest == null || !quest.isActive() || j <= 0) {
            return;
        }
        long progress = quest.getProgress();
        if (progress < quest.targetProgress) {
            long j2 = progress + j;
            quest.setProgress(j2);
            if (j2 >= quest.targetProgress) {
                QUEST_COMPLETED_RECENTLY = true;
            }
        }
    }

    public static void incrementToValue(Quest quest, long j) {
        if (quest == null || !quest.isActive() || j <= 0 || quest.getProgress() >= quest.targetProgress) {
            return;
        }
        quest.setProgress(j);
        if (j >= quest.targetProgress) {
            QUEST_COMPLETED_RECENTLY = true;
        }
    }
}
