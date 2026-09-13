package it.paranoidsquirrels.idleguildmaster.storage.data.pets;

import it.paranoidsquirrels.idleguildmaster.Formulas;
import it.paranoidsquirrels.idleguildmaster.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Pet {
    private static final transient String CLASS_PATH = "it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances.%s";
    protected transient int abilityNumber;
    protected boolean favourite;
    protected int food;
    protected int id;
    protected transient int idDescription;
    protected transient int idImage;
    protected transient int idName;
    protected int level;
    protected PetAbility petAbility1;
    protected PetAbility petAbility2;
    protected PetAbility petAbility3;
    protected PetAbility petAbility4;
    protected String trueClass;
    protected transient double fighter = 0.0d;
    protected transient double healer = 0.0d;
    protected transient double decoy = 0.0d;
    protected transient double opportunist = 0.0d;
    protected transient double statusEffectChance = 0.0d;
    protected transient int statusEffectTurns = 0;
    protected transient double savage = 0.0d;
    protected transient int bright = 0;
    protected transient double experience = 0.0d;
    protected transient double drops = 0.0d;
    protected transient double counterattack = 0.0d;
    protected transient double lifesteal = 0.0d;
    protected transient int regeneration = 0;
    protected transient int barrier = 0;

    protected abstract void configureStatistics();

    protected abstract List<PetAbility> guaranteedFirstAbility();

    public abstract int printPetType();

    public static Pet getInstance(String str, int i, int i2, int i3, PetAbility petAbility, PetAbility petAbility2, PetAbility petAbility3, PetAbility petAbility4) {
        try {
            Pet pet = (Pet) Class.forName(String.format(CLASS_PATH, str)).getConstructor(new Class[0]).newInstance(new Object[0]);
            pet.configureStatistics();
            pet.trueClass = str;
            pet.level = i2;
            pet.food = i3;
            pet.id = i;
            pet.petAbility1 = petAbility;
            pet.petAbility2 = petAbility2;
            pet.petAbility3 = petAbility3;
            pet.petAbility4 = petAbility4;
            pet.configureAbilities();
            return pet;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Pet getInstance(String str, int i) {
        try {
            Pet pet = (Pet) Class.forName(String.format(CLASS_PATH, str)).getConstructor(new Class[0]).newInstance(new Object[0]);
            pet.configureStatistics();
            pet.trueClass = str;
            pet.level = 1;
            pet.food = 0;
            pet.id = i;
            ArrayList arrayList = new ArrayList();
            PetAbility petAbility = pet.guaranteedFirstAbility().get((int) (Utils.random() * ((double) pet.guaranteedFirstAbility().size())));
            arrayList.add(petAbility);
            pet.petAbility1 = petAbility;
            PetAbility petAbilityRollPetAbility = Utils.rollPetAbility(arrayList);
            arrayList.add(petAbilityRollPetAbility);
            pet.petAbility2 = petAbilityRollPetAbility;
            PetAbility petAbilityRollPetAbility2 = pet.abilityNumber > 2 ? Utils.rollPetAbility(arrayList) : PetAbility.EMPTY;
            arrayList.add(petAbilityRollPetAbility2);
            pet.petAbility3 = petAbilityRollPetAbility2;
            PetAbility petAbilityRollPetAbility3 = pet.abilityNumber > 3 ? Utils.rollPetAbility(arrayList) : PetAbility.EMPTY;
            arrayList.add(petAbilityRollPetAbility3);
            pet.petAbility4 = petAbilityRollPetAbility3;
            pet.configureAbilities();
            return pet;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int totalFoodToNextLevel() {
        return Formulas.foodToNextLevel(this.level);
    }

    public int calculateTotalFoodGiven() {
        int iFoodToNextLevel = 0;
        for (int i = 1; i < this.level; i++) {
            iFoodToNextLevel += Formulas.foodToNextLevel(i);
        }
        return iFoodToNextLevel + this.food;
    }

    public int feed(int i) {
        int level = getLevel();
        while (i > 0) {
            int iMin = Math.min(totalFoodToNextLevel() - this.food, i);
            i -= iMin;
            int i2 = this.food + iMin;
            this.food = i2;
            if (i2 >= totalFoodToNextLevel()) {
                this.level++;
                this.food = 0;
            }
        }
        if (this.level > level) {
            configureAbilities();
        }
        return this.level - level;
    }

    private void configureAbilities() {
        configureAbility(this.petAbility1, this.level);
        configureAbility(this.petAbility2, this.level - 20);
        configureAbility(this.petAbility3, this.level - 40);
        configureAbility(this.petAbility4, this.level - 60);
    }

    protected void configureAbility(PetAbility petAbility, int i) {
        if (i <= 0) {
        }
        switch (petAbility) {
            case FIGHTER:
                this.fighter = (((double) i) * 0.5d) + 1.0d;
                break;
            case HEALER:
                this.healer = (((double) i) * 0.2d) + 1.0d;
                break;
            case DECOY:
                this.decoy = ((double) i) * 0.01d;
                break;
            case OPPORTUNIST:
                this.opportunist = ((double) i) * 0.2d;
                break;
            case MAGIC:
                double d = i;
                this.statusEffectChance = 0.3d * d;
                this.statusEffectTurns = Utils.round((d * 0.028d) + 1.0d);
                break;
            case SAVAGE:
                this.savage = ((double) i) * 0.3d;
                break;
            case BRIGHT:
                this.bright = Utils.round((((double) i) * 0.5d) + 1.0d);
                break;
            case EXPERIENCE:
                this.experience = ((double) i) * 0.4d;
                break;
            case DROPS:
                this.drops = ((double) i) * 0.3d;
                break;
            case COUNTERATTACK:
                this.counterattack = ((double) i) * 0.35d;
                break;
            case LIFESTEAL:
                this.lifesteal = ((double) i) * 0.15d;
                break;
            case REGENERATION:
                this.regeneration = Utils.round((((double) i) * 0.3d) + 1.0d);
                break;
            case BARRIER:
                this.barrier = Utils.round((((double) i) * 0.1d) + 1.0d);
                break;
        }
    }

    public PetAbility getPetAbility1() {
        return this.petAbility1;
    }

    public PetAbility getPetAbility2() {
        return this.petAbility2;
    }

    public PetAbility getPetAbility3() {
        return this.petAbility3;
    }

    public PetAbility getPetAbility4() {
        return this.petAbility4;
    }

    public double getFighter() {
        return this.fighter;
    }

    public double getHealer() {
        return this.healer;
    }

    public double getDecoy() {
        return this.decoy;
    }

    public double getOpportunist() {
        return this.opportunist;
    }

    public int getLevel() {
        return this.level;
    }

    public int getFood() {
        return this.food;
    }

    public String getTrueClass() {
        return this.trueClass;
    }

    public int getId() {
        return this.id;
    }

    public int getAbilityNumber() {
        return this.abilityNumber;
    }

    public boolean isFavourite() {
        return this.favourite;
    }

    public void setFavourite(boolean z) {
        this.favourite = z;
    }

    public int getIdName() {
        return this.idName;
    }

    public int getIdDescription() {
        return this.idDescription;
    }

    public int getIdImage() {
        return this.idImage;
    }

    public double getStatusEffectChance() {
        return this.statusEffectChance;
    }

    public int getStatusEffectTurns() {
        return this.statusEffectTurns;
    }

    public double getSavage() {
        return this.savage;
    }

    public int getBright() {
        return this.bright;
    }

    public double getExperience() {
        return this.experience;
    }

    public double getDrops() {
        return this.drops;
    }

    public double getCounterattack() {
        return this.counterattack;
    }

    public double getLifesteal() {
        return this.lifesteal;
    }

    public int getRegeneration() {
        return this.regeneration;
    }

    public int getBarrier() {
        return this.barrier;
    }
}
