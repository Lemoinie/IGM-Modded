package it.paranoidsquirrels.idleguildmaster;

import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;

/* JADX INFO: loaded from: classes3.dex */
public class Formulas {
    private static final int BASE_MARKET_SPACES = 1;
    private static final int BASE_QUARTERS_SPACES = 2;
    private static final int BASE_STORAGE_SPACES = 35;
    private static final int BASE_TAVERN_SPACES = 1;
    private static final long BASE_TAVERN_VISITOR_INTERVAL = 28800;
    private static final int BASE_WORKSHOP_SPACES = 1;
    private static final long IMPOSSIBLY_HIGH_PRICE = 99999999999999L;

    public static int totalStarsToNextLp(int i) {
        return (i * 3) + 4;
    }

    public static long getQuartersPrice() {
        long j;
        switch (MainActivity.data.getLevelQuarters()) {
            case 0:
                j = 5;
                break;
            case 1:
                j = 275;
                break;
            case 2:
                j = 2000;
                break;
            case 3:
                j = WorkRequest.MIN_BACKOFF_MILLIS;
                break;
            case 4:
                j = 40000;
                break;
            case 5:
                j = 100000;
                break;
            case 6:
                j = 200000;
                break;
            case 7:
                j = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
                break;
            case 8:
                j = 400000;
                break;
            case 9:
                j = 500000;
                break;
            case 10:
                j = 700000;
                break;
            case 11:
                j = 1000000;
                break;
            case 12:
                j = 1400000;
                break;
            case 13:
                j = 1850000;
                break;
            case 14:
                j = 2400000;
                break;
            case 15:
                j = 3000000;
                break;
            case 16:
                j = 4000000;
                break;
            case 17:
                j = 5000000;
                break;
            case 18:
                j = 6000000;
                break;
            case 19:
                j = 7000000;
                break;
            case 20:
                j = 8000000;
                break;
            case 21:
                j = 9000000;
                break;
            case 22:
                j = 10000000;
                break;
            default:
                j = IMPOSSIBLY_HIGH_PRICE;
                break;
        }
        return Utils.truncatePrice(j);
    }

    public static long getTavernCapacityPrice() {
        return Utils.truncatePrice((long) (Math.pow(3.0d, MainActivity.data.getLevelTavernCapacity()) * 5000.0d));
    }

    public static long getTavernTimePrice() {
        return Utils.truncatePrice((long) (Math.pow(1.7d, MainActivity.data.getLevelTavernTime()) * 200.0d));
    }

    public static long getStorageCapacityPrice() {
        int levelStorage = MainActivity.data.getLevelStorage();
        int i = levelStorage + 1;
        if (i > 80) {
            return IMPOSSIBLY_HIGH_PRICE;
        }
        long jMin = i > 60 ? ((long) Math.min(levelStorage - 59, 20)) * WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS : 0L;
        if (i > 50) {
            jMin += ((long) Math.min(levelStorage - 49, 10)) * 22000;
        }
        if (i > 40) {
            jMin += ((long) Math.min(levelStorage - 39, 10)) * 12000;
        }
        if (i > 30) {
            jMin += ((long) Math.min(levelStorage - 29, 10)) * 4000;
        }
        if (i > 20) {
            jMin += ((long) Math.min(levelStorage - 19, 10)) * 800;
        }
        if (i > 10) {
            jMin += ((long) Math.min(levelStorage - 9, 10)) * 150;
        }
        return jMin + (((long) Math.min(i, 10)) * 50);
    }

    public static long getMarketListingsPrice() {
        return Utils.truncatePrice((long) (Math.pow(4.5d, MainActivity.data.getLevelMarketListings()) * 20.0d));
    }

    public static long getMarketTimePrice() {
        return Utils.truncatePrice((long) (Math.pow(1.7d, MainActivity.data.getLevelMarketTime()) * 10.0d));
    }

    public static long getWorkshopQueuePrice() {
        return Utils.truncatePrice((long) (Math.pow(4.5d, MainActivity.data.getLevelWorkshopQueue()) * 20.0d));
    }

    public static long getWorkshopTimePrice() {
        return Utils.truncatePrice((long) (Math.pow(1.7d, MainActivity.data.getLevelWorkshopTime()) * 10.0d));
    }

    public static long getShelterPrice() {
        long j;
        switch (MainActivity.data.getLevelShelter()) {
            case 0:
                j = 500;
                break;
            case 1:
                j = 2000;
                break;
            case 2:
                j = 8000;
                break;
            case 3:
                j = 32000;
                break;
            case 4:
                j = 64000;
                break;
            case 5:
                j = 128000;
                break;
            case 6:
                j = 256000;
                break;
            case 7:
                j = 512000;
                break;
            case 8:
                j = 1000000;
                break;
            case 9:
                j = 2000000;
                break;
            case 10:
                j = 4000000;
                break;
            default:
                j = IMPOSSIBLY_HIGH_PRICE;
                break;
        }
        return Utils.truncatePrice(j);
    }

    public static long getShelterAutofeedPrice() {
        return Utils.truncatePrice(MainActivity.data.getLevelShelterAutofeed() > 0 ? IMPOSSIBLY_HIGH_PRICE : WorkRequest.MIN_BACKOFF_MILLIS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    public static int getQuartersCapacity() {
        int IsStarterPackPurchased = MainActivity.data.isStarterPackPurchased() ? 1 : 0;
        int i = IsStarterPackPurchased;
        if (MainActivity.data.isAdventurerPackPurchased()) {
            i = IsStarterPackPurchased + 2;
        }
        int i2 = i;
        if (MainActivity.data.isImperialVanguardPurchased()) {
            i2 = i + 4;
        }
        int i3 = i2;
        if (MainActivity.data.isUnholyCrusadePurchased()) {
            i3 = i2 + 4;
        }
        return MainActivity.data.getLevelQuarters() + 2 + MainActivity.data.getUpgradeQuarters() + i3;
    }

    public static long getTavernVisitorInterval() {
        return (long) (Math.pow(0.9d, MainActivity.data.getLevelTavernTime() + MainActivity.data.getUpgradeTavernTime()) * 28800.0d * 1000.0d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    public static int getTavernCapacity() {
        int IsStarterPackPurchased = MainActivity.data.isStarterPackPurchased() ? 1 : 0;
        int i = IsStarterPackPurchased;
        if (MainActivity.data.isAdventurerPackPurchased()) {
            i = IsStarterPackPurchased + 2;
        }
        return MainActivity.data.getLevelTavernCapacity() + 1 + MainActivity.data.getUpgradeTavernCapacity() + i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    public static int marketListings() {
        int IsStarterPackPurchased = MainActivity.data.isStarterPackPurchased() ? 1 : 0;
        int i = IsStarterPackPurchased;
        if (MainActivity.data.isMerchantPackPurchased()) {
            i = IsStarterPackPurchased + 2;
        }
        return MainActivity.data.getLevelMarketListings() + 1 + MainActivity.data.getUpgradeMarketQueue() + i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    public static int workshopQueue() {
        int IsStarterPackPurchased = MainActivity.data.isStarterPackPurchased() ? 1 : 0;
        int i = IsStarterPackPurchased;
        if (MainActivity.data.isMerchantPackPurchased()) {
            i = IsStarterPackPurchased + 2;
        }
        return MainActivity.data.getLevelWorkshopQueue() + 1 + MainActivity.data.getUpgradeWorkshopQueue() + i;
    }

    public static int storageSpaces() {
        int i = MainActivity.data.isStarterPackPurchased() ? 35 : 0;
        if (MainActivity.data.isAdventurerPackPurchased()) {
            i += 35;
        }
        if (MainActivity.data.isMerchantPackPurchased()) {
            i += 70;
        }
        return MainActivity.data.getLevelStorage() + 35 + MainActivity.data.getUpgradeStorage() + i;
    }

    public static int shelterCapacity() {
        return MainActivity.data.getLevelShelter() + MainActivity.data.getUpgradeShelter() + 2;
    }

    public static int experienceToNextLevel(int i, boolean z) {
        double dPow = Math.pow(i, 1.4d);
        int i2 = (int) ((3.0d + dPow) * 10.0d * dPow);
        if (z) {
            i2 *= 2;
        }
        if (i2 >= 10000) {
            return (i2 / 1000) * 1000;
        }
        if (i2 >= 1000) {
            return (i2 / 100) * 100;
        }
        return i2 >= 100 ? (i2 / 10) * 10 : i2;
    }

    public static int foodToNextLevel(int i) {
        return (int) (Math.pow(1.085d, i) * 30.0d);
    }
}
