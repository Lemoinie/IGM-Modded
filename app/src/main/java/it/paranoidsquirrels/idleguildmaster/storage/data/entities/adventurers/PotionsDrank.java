package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers;

/* JADX INFO: loaded from: classes3.dex */
public class PotionsDrank {
    private int potionOfAgilityDrank;
    private int potionOfConstitutionDrank;
    private int potionOfDarknessDrank;
    private int potionOfDefenseDrank;
    private int potionOfDexterityDrank;
    private int potionOfHealthDrank;
    private int potionOfImmunityDrank;
    private int potionOfIntelligenceDrank;
    private int potionOfMagicDefenseDrank;
    private int potionOfPrecisionDrank;
    private int potionOfViciousnessDrank;

    public PotionsDrank(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.potionOfConstitutionDrank = i;
        this.potionOfDexterityDrank = i2;
        this.potionOfIntelligenceDrank = i3;
        this.potionOfHealthDrank = i4;
        this.potionOfDefenseDrank = i5;
        this.potionOfMagicDefenseDrank = i6;
        this.potionOfViciousnessDrank = i8;
        this.potionOfPrecisionDrank = i7;
        this.potionOfDarknessDrank = i9;
        this.potionOfImmunityDrank = i10;
        this.potionOfAgilityDrank = i11;
    }

    public PotionsDrank() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    public void increase(int i) {
        switch (i) {
            case 0:
                this.potionOfConstitutionDrank++;
                break;
            case 1:
                this.potionOfDexterityDrank++;
                break;
            case 2:
                this.potionOfIntelligenceDrank++;
                break;
            case 3:
                this.potionOfHealthDrank++;
                break;
            case 4:
                this.potionOfDefenseDrank++;
                break;
            case 5:
                this.potionOfMagicDefenseDrank++;
                break;
            case 6:
                this.potionOfPrecisionDrank++;
                break;
            case 7:
                this.potionOfViciousnessDrank++;
                break;
            case 8:
                this.potionOfDarknessDrank++;
                break;
            case 9:
                this.potionOfImmunityDrank++;
                break;
            case 10:
                this.potionOfAgilityDrank++;
                break;
        }
    }

    public int get(int i) {
        switch (i) {
            case 0:
                return this.potionOfConstitutionDrank;
            case 1:
                return this.potionOfDexterityDrank;
            case 2:
                return this.potionOfIntelligenceDrank;
            case 3:
                return this.potionOfHealthDrank;
            case 4:
                return this.potionOfDefenseDrank;
            case 5:
                return this.potionOfMagicDefenseDrank;
            case 6:
                return this.potionOfPrecisionDrank;
            case 7:
                return this.potionOfViciousnessDrank;
            case 8:
                return this.potionOfDarknessDrank;
            case 9:
                return this.potionOfImmunityDrank;
            case 10:
                return this.potionOfAgilityDrank;
            default:
                return 0;
        }
    }

    public void resetAgility() {
        this.potionOfAgilityDrank = 0;
    }
}
