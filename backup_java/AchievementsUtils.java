package it.paranoidsquirrels.idleguildmaster;

import android.app.Activity;
import androidx.work.WorkRequest;
import com.google.android.gms.games.PlayGames;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbility;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances.EmptyDoctrine;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumePotion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AchievementsUtils {
    public static final String ACHIEVEMENT_AGONIZING_TITAN = "CgkIttPX_-AEEAIQJQ";
    public static final String ACHIEVEMENT_APPRENTICE_BLACKSMITH = "CgkIttPX_-AEEAIQAg";
    public static final String ACHIEVEMENT_APPRENTICE_MERCHANT = "CgkIttPX_-AEEAIQBQ";
    public static final String ACHIEVEMENT_ASCENDED = "CgkIttPX_-AEEAIQDA";
    public static final String ACHIEVEMENT_BLACKWATER_PORT = "CgkIttPX_-AEEAIQFg";
    public static final String ACHIEVEMENT_BUSY = "CgkIttPX_-AEEAIQDQ";
    public static final String ACHIEVEMENT_COSMIC_HORROR = "CgkIttPX_-AEEAIQJg";
    public static final String ACHIEVEMENT_DEICIDE = "CgkIttPX_-AEEAIQHQ";
    public static final String ACHIEVEMENT_DIVINE = "CgkIttPX_-AEEAIQMg";
    public static final String ACHIEVEMENT_ETERNAL_BATTLEFIELD = "CgkIttPX_-AEEAIQFA";
    public static final String ACHIEVEMENT_EXPERT = "CgkIttPX_-AEEAIQLQ";
    public static final String ACHIEVEMENT_FABLED = "CgkIttPX_-AEEAIQMQ";
    public static final String ACHIEVEMENT_FILTHY_RICH = "CgkIttPX_-AEEAIQEg";
    public static final String ACHIEVEMENT_FROSTBITE_PEAKS = "CgkIttPX_-AEEAIQFw";
    public static final String ACHIEVEMENT_GUILD_MANAGEMENT_101 = "CgkIttPX_-AEEAIQAQ";
    public static final String ACHIEVEMENT_HEAVY_DRINKER = "CgkIttPX_-AEEAIQEA";
    public static final String ACHIEVEMENT_INFILTRATOR = "CgkIttPX_-AEEAIQIA";
    public static final String ACHIEVEMENT_JACK_OF_ONE_TRADE = "CgkIttPX_-AEEAIQDw";
    public static final String ACHIEVEMENT_LEGENDARY = "CgkIttPX_-AEEAIQLw";
    public static final String ACHIEVEMENT_LEGENDARY_BLACKSMITH = "CgkIttPX_-AEEAIQBA";
    public static final String ACHIEVEMENT_LEGENDARY_MERCHANT = "CgkIttPX_-AEEAIQBw";
    public static final String ACHIEVEMENT_MYTHIC = "CgkIttPX_-AEEAIQMA";
    public static final String ACHIEVEMENT_NOVICE = "CgkIttPX_-AEEAIQKw";
    public static final String ACHIEVEMENT_OBSIDIAN_MINES = "CgkIttPX_-AEEAIQGA";
    public static final String ACHIEVEMENT_RARE_SPECIMEN = "CgkIttPX_-AEEAIQCw";
    public static final String ACHIEVEMENT_RESCUE_TEAM = "CgkIttPX_-AEEAIQHg";
    public static final String ACHIEVEMENT_RESPECTABLE_GUILD = "CgkIttPX_-AEEAIQCQ";
    public static final String ACHIEVEMENT_ROYAL_PUDDING = "CgkIttPX_-AEEAIQIg";
    public static final String ACHIEVEMENT_SEASONED_BLACKSMITH = "CgkIttPX_-AEEAIQAw";
    public static final String ACHIEVEMENT_SEASONED_MERCHANT = "CgkIttPX_-AEEAIQBg";
    public static final String ACHIEVEMENT_SKILLED = "CgkIttPX_-AEEAIQLA";
    public static final String ACHIEVEMENT_SMALL_GUILD = "CgkIttPX_-AEEAIQCA";
    public static final String ACHIEVEMENT_THE_APOSTLE = "CgkIttPX_-AEEAIQJw";
    public static final String ACHIEVEMENT_THE_BARREN_WASTELANDS = "CgkIttPX_-AEEAIQGg";
    public static final String ACHIEVEMENT_THE_CORE = "CgkIttPX_-AEEAIQIQ";
    public static final String ACHIEVEMENT_THE_COUNCIL = "CgkIttPX_-AEEAIQKQ";
    public static final String ACHIEVEMENT_THE_CULTISTS = "CgkIttPX_-AEEAIQJA";
    public static final String ACHIEVEMENT_THE_DESERT = "CgkIttPX_-AEEAIQEw";
    public static final String ACHIEVEMENT_THE_GOLDEN_CITY = "CgkIttPX_-AEEAIQFQ";
    public static final String ACHIEVEMENT_THE_HIDDEN_CITY = "CgkIttPX_-AEEAIQGw";
    public static final String ACHIEVEMENT_THE_LOST_LANDS = "CgkIttPX_-AEEAIQHA";
    public static final String ACHIEVEMENT_THE_NECROMANCER = "CgkIttPX_-AEEAIQIw";
    public static final String ACHIEVEMENT_THE_SEER = "CgkIttPX_-AEEAIQHw";
    public static final String ACHIEVEMENT_THE_SOUTHERN_GROVE = "CgkIttPX_-AEEAIQGQ";
    public static final String ACHIEVEMENT_THE_TOWER = "CgkIttPX_-AEEAIQKg";
    public static final String ACHIEVEMENT_UNITY = "CgkIttPX_-AEEAIQKA";
    public static final String ACHIEVEMENT_VERSATILE_ARMY = "CgkIttPX_-AEEAIQCg";
    public static final String ACHIEVEMENT_VETERAN = "CgkIttPX_-AEEAIQLg";
    public static final String ACHIEVEMENT_WEALTHY = "CgkIttPX_-AEEAIQEQ";
    public static final String ACHIEVEMENT_WORKAHOLIC = "CgkIttPX_-AEEAIQDg";
    private static List<String> achievementQueue = new ArrayList();

    private static Activity getActivity() {
        try {
            return MainActivity.dungeonsFragment.getActivity();
        } catch (Exception unused) {
            return null;
        }
    }

    public static void unlock(String str) {
        Activity activity = getActivity();
        if (activity != null) {
            PlayGames.getAchievementsClient(activity).unlock(str);
        } else {
            achievementQueue.add(str);
        }
    }

    public static void increment(String str, int i) {
        Activity activity = getActivity();
        if (activity != null) {
            PlayGames.getAchievementsClient(activity).increment(str, i);
        }
    }

    public static void flushQueue() {
        Activity activity;
        if (achievementQueue.isEmpty() || (activity = getActivity()) == null) {
            return;
        }
        Iterator<String> it2 = achievementQueue.iterator();
        while (it2.hasNext()) {
            PlayGames.getAchievementsClient(activity).unlock(it2.next());
        }
        achievementQueue.clear();
    }

    public static void retroactivelyUnlockAchievements() {
        boolean z;
        boolean z2;
        if (MainActivity.data.getTutorialStep() >= 8) {
            unlock(ACHIEVEMENT_GUILD_MANAGEMENT_101);
        }
        int size = MainActivity.data.getAdventurers().size();
        MainActivity.data.setMaxAdventurersOwned(size);
        if (size >= 5) {
            unlock(ACHIEVEMENT_SMALL_GUILD);
        }
        if (size >= 12) {
            unlock(ACHIEVEMENT_RESPECTABLE_GUILD);
        }
        if (size >= 20) {
            unlock(ACHIEVEMENT_VERSATILE_ARMY);
        }
        Iterator<Pet> it2 = MainActivity.data.getPets().iterator();
        while (true) {
            z = false;
            if (it2.hasNext()) {
                if (it2.next().getAbilityNumber() == 4) {
                    z2 = true;
                    break;
                }
            } else {
                z2 = false;
                break;
            }
        }
        MainActivity.data.setT4Pet(z2);
        if (z2) {
            unlock(ACHIEVEMENT_RARE_SPECIMEN);
        }
        int iMax = 1;
        for (Adventurer adventurer : MainActivity.data.getAdventurers()) {
            iMax = Math.max(iMax, adventurer.getMaxLevel() / 5);
            if (adventurer.isAscended()) {
                z = true;
            }
            DialogConsumePotion.checkHeavyDrinker(adventurer);
            if (!MainActivity.data.isDoctrineMaxed()) {
                doctrineMaxed(adventurer);
            }
        }
        MainActivity.data.setEverAscended(z);
        if (z) {
            unlock(ACHIEVEMENT_ASCENDED);
        }
        long money = MainActivity.data.getMoney();
        MainActivity.data.setMaxWealth(money);
        if (money > WorkRequest.MIN_BACKOFF_MILLIS) {
            unlock(ACHIEVEMENT_WEALTHY);
        }
        if (money > 1000000) {
            unlock(ACHIEVEMENT_FILTHY_RICH);
        }
        if (MainActivity.data.getTheDesert().isUnlocked()) {
            unlock(ACHIEVEMENT_THE_DESERT);
        }
        if (MainActivity.data.getEternalBattlefield().isUnlocked()) {
            unlock(ACHIEVEMENT_ETERNAL_BATTLEFIELD);
        }
        if (MainActivity.data.getTheGoldenCity().isUnlocked()) {
            unlock(ACHIEVEMENT_THE_GOLDEN_CITY);
        }
        if (MainActivity.data.getBlackwaterPort().isUnlocked()) {
            unlock(ACHIEVEMENT_BLACKWATER_PORT);
        }
        if (MainActivity.data.getFrostbitePeaks().isUnlocked()) {
            unlock(ACHIEVEMENT_FROSTBITE_PEAKS);
        }
        if (MainActivity.data.getObsidianMines().isUnlocked()) {
            unlock(ACHIEVEMENT_OBSIDIAN_MINES);
        }
        if (MainActivity.data.getTheSouthernGrove().isUnlocked()) {
            unlock(ACHIEVEMENT_THE_SOUTHERN_GROVE);
        }
        if (MainActivity.data.getBarrenWastelands().isUnlocked()) {
            unlock(ACHIEVEMENT_THE_BARREN_WASTELANDS);
        }
        if (MainActivity.data.getHiddenCityOfLarox().isUnlocked()) {
            unlock(ACHIEVEMENT_THE_HIDDEN_CITY);
        }
        if (MainActivity.data.getLostLands().isUnlocked()) {
            unlock(ACHIEVEMENT_THE_LOST_LANDS);
        }
        if (MainActivity.data.getDivineArcheology().completed()) {
            unlock(ACHIEVEMENT_DEICIDE);
        }
        if (MainActivity.data.getImperialRescue().completed()) {
            unlock(ACHIEVEMENT_RESCUE_TEAM);
        }
        if (MainActivity.data.getTheDreadfulAscent().completed()) {
            unlock(ACHIEVEMENT_THE_SEER);
        }
        if (MainActivity.data.getCelestialMothership().completed()) {
            unlock(ACHIEVEMENT_INFILTRATOR);
        }
        if (MainActivity.data.getTheDireDescent().completed()) {
            unlock(ACHIEVEMENT_THE_CORE);
        }
        if (MainActivity.data.getTheSlimePond().getMaxProgress() > 6) {
            unlock(ACHIEVEMENT_ROYAL_PUDDING);
        }
        if (MainActivity.data.getAncientGraveDigging().getMaxProgress() > 11) {
            unlock(ACHIEVEMENT_THE_NECROMANCER);
        }
        if (MainActivity.data.getSeenItems().contains("ElixirOfLearning") || MainActivity.data.getSeenItems().contains("EternalHunger") || MainActivity.data.getSeenItems().contains("SealOfClaris")) {
            unlock(ACHIEVEMENT_THE_CULTISTS);
        }
        if (MainActivity.data.getSeenItems().contains("ExaltedPowder") || MainActivity.data.getSeenItems().contains("ColossalSword")) {
            unlock(ACHIEVEMENT_AGONIZING_TITAN);
        }
        if (MainActivity.data.getSeenItems().contains("StarFragment")) {
            unlock(ACHIEVEMENT_COSMIC_HORROR);
        }
        if (MainActivity.data.getSeenItems().contains("AstralGoo") || MainActivity.data.getSeenItems().contains("CosmicViolin")) {
            unlock(ACHIEVEMENT_THE_APOSTLE);
        }
        if (MainActivity.data.getSleepingPlanet().getMaxProgress() > 14) {
            unlock(ACHIEVEMENT_UNITY);
        }
        if (MainActivity.data.getSleepingPlanet().getMaxProgress() > 16) {
            unlock(ACHIEVEMENT_THE_COUNCIL);
        }
        if (MainActivity.data.getSleepingPlanet().getMaxProgress() > 35) {
            unlock(ACHIEVEMENT_THE_TOWER);
        }
        if (iMax > 1) {
            unlock(ACHIEVEMENT_NOVICE);
        }
        if (iMax > 2) {
            unlock(ACHIEVEMENT_SKILLED);
        }
        if (iMax > 3) {
            unlock(ACHIEVEMENT_EXPERT);
        }
        if (iMax > 4) {
            unlock(ACHIEVEMENT_VETERAN);
        }
        if (iMax > 5) {
            unlock(ACHIEVEMENT_LEGENDARY);
        }
        if (iMax > 6) {
            unlock(ACHIEVEMENT_MYTHIC);
        }
        if (iMax > 7) {
            unlock(ACHIEVEMENT_FABLED);
        }
        if (iMax > 8) {
            unlock(ACHIEVEMENT_DIVINE);
        }
    }

    private static void doctrineMaxed(Adventurer adventurer) {
        if (adventurer.getDoctrine() instanceof EmptyDoctrine) {
            return;
        }
        for (DoctrineAbility doctrineAbility : adventurer.getDoctrine().getAbilities()) {
            if (doctrineAbility.getLevel() < doctrineAbility.getType().maxLevel) {
                return;
            }
        }
        MainActivity.data.setDoctrineMaxed(true);
        unlock(ACHIEVEMENT_JACK_OF_ONE_TRADE);
    }
}
