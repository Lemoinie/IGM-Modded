package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers;

/* JADX INFO: loaded from: classes3.dex */
public enum PotionDrinkerType {
    NONE(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d),
    WARRIOR(9.0d, 3.0d, 1.0d, 10.0d, 5.0d, 5.0d, 2.0d, 2.0d, 3.0d, 15.0d, 3.0d),
    ARCHER(4.0d, 10.0d, 4.0d, 5.0d, 3.0d, 3.0d, 6.0d, 6.0d, 4.0d, 3.0d, 6.0d),
    THIEF(7.0d, 7.0d, 4.0d, 5.0d, 3.0d, 3.0d, 8.0d, 4.0d, 6.0d, 1.0d, 6.0d),
    MAGE(3.0d, 3.0d, 14.0d, 3.0d, 1.0d, 5.0d, 2.0d, 6.0d, 4.0d, 10.0d, 3.0d);

    private static final double STANDARD_STEP = 0.02857142857142857d;
    public double agility;
    public double constitution;
    public double darkness;
    public double defense;
    public double dexterity;
    public double health;
    public double immunity;
    public double intelligence;
    public double magicDefense;
    public double precision;
    public double viciousness;

    PotionDrinkerType(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11) {
        this.constitution = d;
        this.dexterity = d2;
        this.intelligence = d3;
        this.health = d4;
        this.defense = d5;
        this.magicDefense = d6;
        this.precision = d7;
        this.viciousness = d8;
        this.darkness = d9;
        this.immunity = d10;
        this.agility = d11;
    }

    public double getMaxAmount(int i, int i2, boolean z) {
        if (!z) {
            return getMaxAmountPreAscension(i, i2);
        }
        return getMaxAmountPreAscension(i, 45) + getIncreasedAmountPostAscension(i, i2);
    }

    private double getMaxAmountPreAscension(int i, int i2) {
        double d;
        double d2 = ((double) i2) * STANDARD_STEP;
        switch (i) {
            case 0:
                d = this.constitution;
                break;
            case 1:
                d = this.dexterity;
                break;
            case 2:
                d = this.intelligence;
                break;
            case 3:
                d = this.health;
                break;
            case 4:
                d = this.defense;
                break;
            case 5:
                d = this.magicDefense;
                break;
            case 6:
                d = this.precision;
                break;
            case 7:
                d = this.viciousness;
                break;
            case 8:
                d = this.darkness;
                break;
            case 9:
                d = this.immunity;
                break;
            case 10:
                d = this.agility;
                break;
            default:
                d = 0.0d;
                break;
        }
        return d * d2;
    }

    private double getIncreasedAmountPostAscension(int i, int i2) {
        double d;
        double d2 = ((double) i2) * STANDARD_STEP;
        switch (i) {
            case 0:
                d = this.constitution;
                break;
            case 1:
                d = this.dexterity;
                break;
            case 2:
                d = this.intelligence;
                break;
            case 3:
                d = this.health;
                break;
            case 4:
            case 5:
                d2 = 1.0d;
                d = 1.0d;
                break;
            case 6:
                d = this.precision;
                d2 *= 0.5d;
                break;
            case 7:
                d = this.viciousness;
                d2 *= 0.5d;
                break;
            case 8:
                d = this.darkness;
                d2 *= 0.5d;
                break;
            case 9:
                d = this.immunity;
                d2 *= 0.5d;
                break;
            case 10:
                d = this.agility;
                d2 *= 0.5d;
                break;
            default:
                d = 0.0d;
                break;
        }
        return d * d2;
    }
}
