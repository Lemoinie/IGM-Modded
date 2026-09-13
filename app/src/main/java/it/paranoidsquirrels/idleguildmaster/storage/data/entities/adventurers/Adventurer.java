package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers;

import it.paranoidsquirrels.idleguildmaster.Formulas;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbility;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Armor;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Equipment;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.SerpentBite;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Adventurer extends Entity {
    private static final transient String CLASS_PATH = "it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units.%s";
    private static final int KEY_CONSTITUTION = 0;
    private static final int KEY_DEFENSE = 4;
    private static final int KEY_DEXTERITY = 2;
    private static final int KEY_HP = 3;
    private static final int KEY_INTELLIGENCE = 1;
    private static final int KEY_MAGIC_DEFENSE = 5;
    public static final transient int RESERVED_ID_ENTITY_BOUND = -100;
    protected Accessory accessory;
    protected Armor armor;
    protected transient int armorType;
    protected boolean ascended;
    protected Doctrine doctrine;
    protected int experience;
    protected int id;
    protected int level;
    protected transient int maxLevel;
    protected Adventurer minionBound;
    protected transient PotionDrinkerType potionDrinkerType;
    protected PotionsDrank potionsDrank;
    protected boolean seen;
    protected long timeWhenDismissed;
    protected Trait traitCommon;
    protected Trait traitRare;
    protected Weapon weapon;
    protected transient int weaponType;
    protected transient boolean healsMinionBound = false;
    protected transient boolean summonedMinion = false;
    protected transient int darknessReduction = 0;
    protected transient boolean saboteur = false;
    protected transient boolean nightVision = false;
    protected transient List<String> nextClasses = new ArrayList();

    protected abstract void configureStatistics();

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int getTeam() {
        return 0;
    }

    public static Adventurer getInstance(String str, int i, int i2, int i3, Weapon weapon, Armor armor, Accessory accessory, Trait trait, Trait trait2, PotionsDrank potionsDrank, Doctrine doctrine, boolean z) {
        try {
            Adventurer adventurer = (Adventurer) Class.forName(String.format(CLASS_PATH, str)).getConstructor(new Class[0]).newInstance(new Object[0]);
            adventurer.trueClass = str;
            adventurer.id = i;
            adventurer.level = i2;
            adventurer.experience = i3;
            adventurer.weapon = weapon;
            adventurer.armor = armor;
            adventurer.accessory = accessory;
            adventurer.traitCommon = trait;
            adventurer.traitRare = trait2;
            adventurer.potionsDrank = potionsDrank;
            if (doctrine == null) {
                doctrine = Doctrine.getInstance("EmptyDoctrine");
            }
            adventurer.doctrine = doctrine;
            adventurer.ascended = z;
            adventurer.configureStatistics();
            return adventurer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public boolean isSeen() {
        return this.seen;
    }

    public void setSeen(boolean z) {
        this.seen = z;
    }

    public long getTimeWhenDismissed() {
        return this.timeWhenDismissed;
    }

    public void setTimeWhenDismissed(long j) {
        this.timeWhenDismissed = j;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public int getMaxLevel() {
        return this.maxLevel;
    }

    public void setMaxLevel(int i) {
        this.maxLevel = i;
    }

    public int getExperience() {
        return this.experience;
    }

    public void setExperience(int i) {
        this.experience = i;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return this.armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Accessory getAccessory() {
        return this.accessory;
    }

    public void setAccessory(Accessory accessory) {
        this.accessory = accessory;
    }

    public Trait getTraitCommon() {
        return this.traitCommon;
    }

    public Trait getTraitRare() {
        return this.traitRare;
    }

    public PotionsDrank getPotionsDrank() {
        return this.potionsDrank;
    }

    public void setPotionsDrank(PotionsDrank potionsDrank) {
        this.potionsDrank = potionsDrank;
    }

    public Doctrine getDoctrine() {
        return this.doctrine;
    }

    public void setDoctrine(Doctrine doctrine) {
        this.doctrine = doctrine;
    }

    public boolean isAscended() {
        return this.ascended;
    }

    public void setAscended(boolean z) {
        this.ascended = z;
    }

    public int calculateMaxPotions(int i) {
        return (int) this.potionDrinkerType.getMaxAmount(i, this.maxLevel, this.ascended);
    }

    public int getWeaponType() {
        return this.weaponType;
    }

    public int getArmorType() {
        return this.armorType;
    }

    public Adventurer getMinionBound() {
        return this.minionBound;
    }

    public void setMinionBound(Adventurer adventurer) {
        this.minionBound = adventurer;
    }

    public boolean isHealsMinionBound() {
        return this.healsMinionBound;
    }

    public boolean isSummonedMinion() {
        return this.summonedMinion;
    }

    public List<String> getNextClasses() {
        return this.nextClasses;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean isRanged() {
        return this.weapon.isRanged();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean isMagic() {
        return this.weapon.isMagic();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean rollsDamageThreeTimes() {
        return this.doctrine.rollDamageThreeTimes();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateMinAttackDamage() {
        Weapon weapon = this.weapon;
        if (weapon == null) {
            return 1;
        }
        float damageModifier = weapon.getDamageModifier(calculateTotalConstitution(), calculateTotalIntelligence(), calculateTotalDexterity());
        if (this.weapon instanceof SerpentBite) {
            damageModifier *= getThreat();
        }
        return Utils.round(((double) damageModifier) * (1.0d - this.weapon.damageDelta()));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateMaxAttackDamage() {
        Weapon weapon = this.weapon;
        if (weapon == null) {
            return 1;
        }
        float damageModifier = weapon.getDamageModifier(calculateTotalConstitution(), calculateTotalIntelligence(), calculateTotalDexterity());
        if (this.weapon instanceof SerpentBite) {
            damageModifier *= getThreat();
        }
        return Utils.round(((double) damageModifier) * (this.weapon.damageDelta() + 1.0d));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateManaRegen() {
        int iCalculateManaRegen = super.calculateManaRegen() + this.doctrine.bonusManaRegen();
        return this.traitRare == Trait.GIFTED ? iCalculateManaRegen + 2 : iCalculateManaRegen;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public double calculateCounterattackChance() {
        double counterattack = this.counterattack;
        Weapon weapon = this.weapon;
        if (weapon != null) {
            counterattack += weapon.getCounterattack();
        }
        Armor armor = this.armor;
        if (armor != null) {
            counterattack += armor.getCounterattack();
        }
        Accessory accessory = this.accessory;
        if (accessory != null) {
            counterattack += accessory.getCounterattack();
        }
        if (this.traitRare == Trait.REACTIVE) {
            counterattack += 0.1d;
        }
        return counterattack + (((double) this.doctrine.bonusCounterattack()) * 0.01d);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int getThreat() {
        int threat = this.threat;
        Weapon weapon = this.weapon;
        if (weapon != null) {
            threat += weapon.getThreat();
        }
        Armor armor = this.armor;
        if (armor != null) {
            threat += armor.getThreat();
        }
        Accessory accessory = this.accessory;
        if (accessory != null) {
            threat += accessory.getThreat();
        }
        if (this.traitRare == Trait.INTIMIDATING) {
            threat++;
        }
        return Math.max(1, threat + this.doctrine.bonusThreat());
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int getInspireExaltBonusTurns() {
        int exaltInspireBonusTurns = this.inspireExaltExtraTurns;
        Weapon weapon = this.weapon;
        if (weapon != null) {
            exaltInspireBonusTurns += weapon.getExaltInspireBonusTurns();
        }
        Armor armor = this.armor;
        if (armor != null) {
            exaltInspireBonusTurns += armor.getExaltInspireBonusTurns();
        }
        Accessory accessory = this.accessory;
        return accessory != null ? exaltInspireBonusTurns + accessory.getExaltInspireBonusTurns() : exaltInspireBonusTurns;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public double getCriticalReduction() {
        return (this.criticalReduction + ((double) this.doctrine.reduceCriticalBonusDamage())) * 0.01d;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int getMaxLifestealOverheal() {
        return this.maxLifestealOverheal + this.doctrine.maxLifestealOverheal();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int getDamagePerTurnPerStatus() {
        return this.damagePerTurnPerStatus + this.doctrine.damagePerTurnPerStatus();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public double getArmorIgnored() {
        return this.armorIgnored + (((double) this.doctrine.ignoreArmorPercentage()) * 0.01d);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean isForcesTargetToCounterattack() {
        return this.forcesTargetToCounterattack || this.doctrine.forcesCounterattack();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean isAddsDefensesToRetaliate() {
        return this.addsDefensesToRetaliate || this.doctrine.addsDefensesToRetaliate();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean isMoreDamageWhenHalfLife() {
        return this.moreDamageWhenHalfLife || this.doctrine.moreDamageWhenHalfLife();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean isMoreDamageDealtAndTaken() {
        return this.moreDamageDealtAndTaken || this.doctrine.moreDamageDealtAndTaken();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int getMaxOverheal() {
        return this.maxOverheal + this.doctrine.maxOverheal();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int getBonusResurrectChance() {
        return this.bonusResurrectChance + this.doctrine.bonusResurrectionChance();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int getHealMissingHpOnEnemyDeath() {
        return this.healMissingHpOnEnemyDeath + this.doctrine.healingNova();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    protected int calculateFlatDamageReduction() {
        int iCalculateFlatDamageReduction = super.calculateFlatDamageReduction();
        if (this.traitRare != Trait.DRAGON_BLOOD) {
            return iCalculateFlatDamageReduction;
        }
        int i = iCalculateFlatDamageReduction + (this.maxLevel / 5);
        return this.ascended ? i + 9 : i;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateTotalConstitution() {
        return calculateTotalStat(0);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateTotalIntelligence() {
        return calculateTotalStat(1);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateTotalDexterity() {
        return calculateTotalStat(2);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateTotalMaxHp() {
        return calculateTotalStat(3);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateTotalDefense() {
        return calculateTotalStat(4);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateTotalMagicDefense() {
        return calculateTotalStat(5);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateTotalLifesteal() {
        int lifesteal;
        Weapon weapon = this.weapon;
        if (weapon != null) {
            lifesteal = weapon.getLifesteal();
            if (this.minionBound != null) {
                lifesteal += this.weapon.getLifestealWithMinion();
            }
        } else {
            lifesteal = 0;
        }
        Armor armor = this.armor;
        if (armor != null) {
            lifesteal += armor.getLifesteal();
            if (this.minionBound != null) {
                lifesteal += this.armor.getLifestealWithMinion();
            }
        }
        Accessory accessory = this.accessory;
        if (accessory != null) {
            lifesteal += accessory.getLifesteal();
            if (this.minionBound != null) {
                lifesteal += this.accessory.getLifestealWithMinion();
            }
        }
        return this.baseLifesteal + lifesteal + (this.traitRare == Trait.CURSED ? 15 : 0) + this.doctrine.bonusLifesteal();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public double calculateTotalDarknessDamageAmplification() {
        double darknessDamageAmplification = this.darknessDamageAmplification + (((double) this.potionsDrank.get(8)) * 0.001d);
        Weapon weapon = this.weapon;
        if (weapon != null) {
            darknessDamageAmplification += weapon.getDarknessDamageAmplification();
        }
        Armor armor = this.armor;
        if (armor != null) {
            darknessDamageAmplification += armor.getDarknessDamageAmplification();
        }
        Accessory accessory = this.accessory;
        if (accessory != null) {
            darknessDamageAmplification += accessory.getDarknessDamageAmplification();
        }
        if (this.traitRare == Trait.NOCTURNAL) {
            darknessDamageAmplification += 0.005d;
        }
        return darknessDamageAmplification + (((double) this.doctrine.darknessDamageIncrease()) * 0.001d);
    }

    public int darknessReduction() {
        int darknessReduction = this.darknessReduction;
        Weapon weapon = this.weapon;
        if (weapon != null) {
            darknessReduction += weapon.getDarknessReduction();
        }
        Armor armor = this.armor;
        if (armor != null) {
            darknessReduction += armor.getDarknessReduction();
        }
        Accessory accessory = this.accessory;
        if (accessory != null) {
            darknessReduction += accessory.getDarknessReduction();
        }
        return this.traitRare == Trait.BLESSED ? darknessReduction + 8 : darknessReduction;
    }

    public double experienceMultiplier() {
        Weapon weapon = this.weapon;
        double bonusExperience = weapon != null ? 0.0d + ((double) weapon.getBonusExperience()) : 0.0d;
        Armor armor = this.armor;
        if (armor != null) {
            bonusExperience += (double) armor.getBonusExperience();
        }
        Accessory accessory = this.accessory;
        if (accessory != null) {
            bonusExperience += (double) accessory.getBonusExperience();
        }
        return (bonusExperience / 100.0d) + 1.0d;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateRetaliationPhysicalDamage() {
        int retaliationPhysicalDamage = this.retaliationPhysicalDamage;
        Weapon weapon = this.weapon;
        if (weapon != null) {
            retaliationPhysicalDamage += weapon.getRetaliationPhysicalDamage();
        }
        Armor armor = this.armor;
        if (armor != null) {
            retaliationPhysicalDamage += armor.getRetaliationPhysicalDamage();
        }
        Accessory accessory = this.accessory;
        if (accessory != null) {
            retaliationPhysicalDamage += accessory.getRetaliationPhysicalDamage();
        }
        return isAddsDefensesToRetaliate() ? retaliationPhysicalDamage + calculateTotalDefense() : retaliationPhysicalDamage;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateRetaliationMagicalDamage() {
        int retaliationMagicalDamage = this.retaliationMagicalDamage;
        Weapon weapon = this.weapon;
        if (weapon != null) {
            retaliationMagicalDamage += weapon.getRetaliationMagicalDamage();
        }
        Armor armor = this.armor;
        if (armor != null) {
            retaliationMagicalDamage += armor.getRetaliationMagicalDamage();
        }
        Accessory accessory = this.accessory;
        if (accessory != null) {
            retaliationMagicalDamage += accessory.getRetaliationMagicalDamage();
        }
        return isAddsDefensesToRetaliate() ? retaliationMagicalDamage + calculateTotalMagicDefense() : retaliationMagicalDamage;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public double calculateHealingModifier() {
        double healingModifier = this.healingModifier;
        Weapon weapon = this.weapon;
        if (weapon != null) {
            healingModifier += weapon.getHealingModifier();
        }
        Armor armor = this.armor;
        if (armor != null) {
            healingModifier += armor.getHealingModifier();
        }
        Accessory accessory = this.accessory;
        if (accessory != null) {
            healingModifier += accessory.getHealingModifier();
        }
        double dBonusHealingModifier = healingModifier + (((double) this.doctrine.bonusHealingModifier()) * 0.01d);
        return this.traitRare == Trait.EMPATHETIC ? dBonusHealingModifier * 1.2d : dBonusHealingModifier;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public double calculateImmunityToStatus() {
        double immunityToStatus = this.immunityToStatus + (((double) this.potionsDrank.get(9)) * 0.01d);
        Weapon weapon = this.weapon;
        if (weapon != null) {
            immunityToStatus += weapon.getImmunityToStatus();
        }
        Armor armor = this.armor;
        if (armor != null) {
            immunityToStatus += armor.getImmunityToStatus();
        }
        Accessory accessory = this.accessory;
        if (accessory != null) {
            immunityToStatus += accessory.getImmunityToStatus();
        }
        if (this.traitRare == Trait.MINDFUL) {
            immunityToStatus += 0.1d;
        }
        return immunityToStatus + (((double) this.doctrine.bonusStatusImmunity()) * 0.01d);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public double calculateIgnoreImmunityToStatus() {
        return this.ignoreImmunityToStatus + ((double) this.doctrine.ignoreEnemyImmunities());
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateTotalRegeneration() {
        int regeneration = this.regeneration;
        Weapon weapon = this.weapon;
        if (weapon != null) {
            regeneration += weapon.getRegeneration();
        }
        Armor armor = this.armor;
        if (armor != null) {
            regeneration += armor.getRegeneration();
        }
        Accessory accessory = this.accessory;
        if (accessory != null) {
            regeneration += accessory.getRegeneration();
        }
        if (this.traitRare != Trait.TROLL_BLOOD) {
            return regeneration;
        }
        int i = regeneration + (this.maxLevel / 5);
        return this.ascended ? i + 9 : i;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public double calculateTotalFlatDodgeChance() {
        double flatDodgeChance = this.flatDodgeChance + (((double) this.potionsDrank.get(10)) * 0.01d);
        Weapon weapon = this.weapon;
        if (weapon != null) {
            flatDodgeChance += weapon.getFlatDodgeChance();
        }
        Armor armor = this.armor;
        if (armor != null) {
            flatDodgeChance += armor.getFlatDodgeChance();
        }
        Accessory accessory = this.accessory;
        if (accessory != null) {
            flatDodgeChance += accessory.getFlatDodgeChance();
        }
        if (this.traitRare == Trait.NIMBLE) {
            flatDodgeChance += 0.08d;
        }
        return flatDodgeChance + (((double) this.doctrine.bonusDodgeChance()) * 0.01d);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public double calculateCriticalDamage() {
        double criticalDamage = this.criticalDamage + (((double) this.potionsDrank.get(7)) * 0.02d);
        Weapon weapon = this.weapon;
        if (weapon != null) {
            criticalDamage += weapon.getCriticalDamage();
        }
        Armor armor = this.armor;
        if (armor != null) {
            criticalDamage += armor.getCriticalDamage();
        }
        Accessory accessory = this.accessory;
        if (accessory != null) {
            criticalDamage += accessory.getCriticalDamage();
        }
        double dBonusCritDamage = criticalDamage + (((double) this.doctrine.bonusCritDamage()) * 0.01d);
        return this.traitRare == Trait.RUTHLESS ? dBonusCritDamage * 1.2d : dBonusCritDamage;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public double calculateCriticalChance() {
        double dMin = Math.min(0.4d, ((double) (isMagic() ? calculateTotalIntelligence() : calculateTotalDexterity())) * 0.004d) + (((double) this.potionsDrank.get(6)) * 0.01d);
        Weapon weapon = this.weapon;
        if (weapon != null) {
            dMin += weapon.getCriticalChance();
        }
        Armor armor = this.armor;
        if (armor != null) {
            dMin += armor.getCriticalChance();
        }
        Accessory accessory = this.accessory;
        if (accessory != null) {
            dMin += accessory.getCriticalChance();
        }
        return dMin + (((double) this.doctrine.bonusCritChance()) * 0.01d);
    }

    public boolean isSaboteur() {
        return this.saboteur;
    }

    public void setSaboteur(boolean z) {
        this.saboteur = z;
    }

    public boolean isNightVision() {
        return this.nightVision;
    }

    public void setNightVision(boolean z) {
        this.nightVision = z;
    }

    public int decay() {
        int iCalculateTotalMaxHp = calculateTotalMaxHp();
        Weapon weapon = this.weapon;
        double decay = weapon != null ? 0.0d + ((double) weapon.getDecay()) : 0.0d;
        Armor armor = this.armor;
        if (armor != null) {
            decay += (double) armor.getDecay();
        }
        Accessory accessory = this.accessory;
        if (accessory != null) {
            decay += (double) accessory.getDecay();
        }
        if (this.summonedMinion) {
            decay = Math.max(1.0d, decay + (((double) iCalculateTotalMaxHp) * 0.25d));
        }
        if (this.traitRare == Trait.CURSED) {
            decay = Math.max(1.0d, decay + (((double) iCalculateTotalMaxHp) * 0.04d));
        }
        return Utils.round(decay);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean isInitiative() {
        if (this.initiative || this.traitRare == Trait.ALERT) {
            return true;
        }
        Weapon weapon = this.weapon;
        if (weapon != null && weapon.isInitiative()) {
            return true;
        }
        Armor armor = this.armor;
        if (armor != null && armor.isInitiative()) {
            return true;
        }
        Accessory accessory = this.accessory;
        return accessory != null && accessory.isInitiative();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean isAlwaysHits() {
        if (this.alwaysHits) {
            return true;
        }
        Weapon weapon = this.weapon;
        if (weapon != null && weapon.isAlwaysHits()) {
            return true;
        }
        Armor armor = this.armor;
        if (armor != null && armor.isAlwaysHits()) {
            return true;
        }
        Accessory accessory = this.accessory;
        return accessory != null && accessory.isAlwaysHits();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int getOnFireBonusDamage() {
        int onFireBonusDamage = this.onFireBonusDamage;
        Weapon weapon = this.weapon;
        if (weapon != null) {
            onFireBonusDamage += weapon.getOnFireBonusDamage();
        }
        Armor armor = this.armor;
        if (armor != null) {
            onFireBonusDamage += armor.getOnFireBonusDamage();
        }
        Accessory accessory = this.accessory;
        return accessory != null ? onFireBonusDamage + accessory.getOnFireBonusDamage() : onFireBonusDamage;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int getFreezeBonusDamage() {
        int freezeBonusDamage = this.freezeBonusDamage;
        Weapon weapon = this.weapon;
        if (weapon != null) {
            freezeBonusDamage += weapon.getFreezeBonusDamage();
        }
        Armor armor = this.armor;
        if (armor != null) {
            freezeBonusDamage += armor.getFreezeBonusDamage();
        }
        Accessory accessory = this.accessory;
        return accessory != null ? freezeBonusDamage + accessory.getFreezeBonusDamage() : freezeBonusDamage;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int getLivingCompanionBonusDamage() {
        int livingCompanionBonusDamage = this.livingCompanionBonusDamage;
        Weapon weapon = this.weapon;
        if (weapon != null) {
            livingCompanionBonusDamage += weapon.getLivingCompanionBonusDamage();
        }
        Armor armor = this.armor;
        if (armor != null) {
            livingCompanionBonusDamage += armor.getLivingCompanionBonusDamage();
        }
        Accessory accessory = this.accessory;
        return accessory != null ? livingCompanionBonusDamage + accessory.getLivingCompanionBonusDamage() : livingCompanionBonusDamage;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int getPoisonBonus() {
        int poisonBonus = this.poisonBonus;
        Weapon weapon = this.weapon;
        if (weapon != null) {
            poisonBonus += weapon.getPoisonBonus();
        }
        Armor armor = this.armor;
        if (armor != null) {
            poisonBonus += armor.getPoisonBonus();
        }
        Accessory accessory = this.accessory;
        return accessory != null ? poisonBonus + accessory.getPoisonBonus() : poisonBonus;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int getRegenerationBonus() {
        int regenerationBonus = this.regenerationBonus;
        Weapon weapon = this.weapon;
        if (weapon != null) {
            regenerationBonus += weapon.getRegenerationBonus();
        }
        Armor armor = this.armor;
        if (armor != null) {
            regenerationBonus += armor.getRegenerationBonus();
        }
        Accessory accessory = this.accessory;
        return accessory != null ? regenerationBonus + accessory.getRegenerationBonus() : regenerationBonus;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public List<StatusEffect> onTargetHitEffects() {
        ArrayList arrayList = new ArrayList();
        if (this.onTargetHit != null) {
            arrayList.add(new StatusEffect(this.onTargetHit.getType(), this, this.onTargetHit.getTurnsLeft(), this.onTargetHit.getProbability()));
        }
        Weapon weapon = this.weapon;
        if (weapon != null && weapon.getOnTargetHit() != null) {
            StatusEffect onTargetHit = this.weapon.getOnTargetHit();
            onTargetHit.setCause(this);
            arrayList.add(onTargetHit);
        }
        Armor armor = this.armor;
        if (armor != null && armor.getOnTargetHit() != null) {
            StatusEffect onTargetHit2 = this.armor.getOnTargetHit();
            onTargetHit2.setCause(this);
            arrayList.add(onTargetHit2);
        }
        Accessory accessory = this.accessory;
        if (accessory != null && accessory.getOnTargetHit() != null) {
            StatusEffect onTargetHit3 = this.accessory.getOnTargetHit();
            onTargetHit3.setCause(this);
            arrayList.add(onTargetHit3);
        }
        if (this.doctrine.freezeOnHit() > 0) {
            arrayList.add(new StatusEffect(StatusEffectType.FROZEN, this, 1, ((double) this.doctrine.freezeOnHit()) * 0.01d));
        }
        if (this.doctrine.petrifyOnHit() > 0) {
            arrayList.add(new StatusEffect(StatusEffectType.PETRIFY, this, 1, ((double) this.doctrine.petrifyOnHit()) * 0.01d));
        }
        return arrayList;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public List<StatusEffect> onSelfHitEffects() {
        ArrayList arrayList = new ArrayList();
        if (this.onSelfHit != null) {
            arrayList.add(new StatusEffect(this.onSelfHit.getType(), this, this.onSelfHit.getTurnsLeft(), this.onSelfHit.getProbability()));
        }
        Weapon weapon = this.weapon;
        if (weapon != null && weapon.getOnSelfHit() != null) {
            StatusEffect onSelfHit = this.weapon.getOnSelfHit();
            onSelfHit.setCause(this);
            arrayList.add(onSelfHit);
        }
        Armor armor = this.armor;
        if (armor != null && armor.getOnSelfHit() != null) {
            StatusEffect onSelfHit2 = this.armor.getOnSelfHit();
            onSelfHit2.setCause(this);
            arrayList.add(onSelfHit2);
        }
        Accessory accessory = this.accessory;
        if (accessory != null && accessory.getOnSelfHit() != null) {
            StatusEffect onSelfHit3 = this.accessory.getOnSelfHit();
            onSelfHit3.setCause(this);
            arrayList.add(onSelfHit3);
        }
        return arrayList;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public List<EndOfTurnAction> endOfTurnActions() {
        ArrayList arrayList = new ArrayList();
        if (this.endOfTurnAction != null) {
            arrayList.add(this.endOfTurnAction);
        }
        Weapon weapon = this.weapon;
        if (weapon != null && weapon.getEndOfTurnAction() != null) {
            arrayList.add(this.weapon.getEndOfTurnAction());
        }
        Armor armor = this.armor;
        if (armor != null && armor.getEndOfTurnAction() != null) {
            arrayList.add(this.armor.getEndOfTurnAction());
        }
        Accessory accessory = this.accessory;
        if (accessory != null && accessory.getEndOfTurnAction() != null) {
            arrayList.add(this.accessory.getEndOfTurnAction());
        }
        if (this.doctrine.extraAttackChance() > 0 && Utils.random() < ((double) this.doctrine.extraAttackChance()) * 0.01d) {
            arrayList.add(EndOfTurnAction.EXTRA_ATTACK);
        }
        if (this.doctrine.falseLifeChance() > 0) {
            arrayList.add(EndOfTurnAction.FALSE_LIFE);
        }
        return arrayList;
    }

        private int calculateTotalStat(int i) {
        double d2 = this.ascended ? 1.5d : 1.0d;
        int i3;
        if (i == 0) {
            i3 = ((int) (((double) this.baseConstitution) * d2)) + this.potionsDrank.get(0) + this.doctrine.bonusConstitution();
        } else if (i == 1) {
            i3 = ((int) (((double) this.baseIntelligence) * d2)) + this.potionsDrank.get(2) + this.doctrine.bonusIntelligence();
        } else if (i == 2) {
            i3 = ((int) (((double) this.baseDexterity) * d2)) + this.potionsDrank.get(1) + this.doctrine.bonusDexterity();
        } else if (i == 3) {
            i3 = ((int) (((double) ((this.baseMaxHp + this.level) - 1)) * d2)) + (this.potionsDrank.get(3) * 5) + this.doctrine.bonusHp();
        } else if (i == 4) {
            i3 = this.baseDefense + this.potionsDrank.get(4) + this.doctrine.bonusDefense();
        } else if (i == 5) {
            i3 = this.baseMagicDefense + this.potionsDrank.get(5) + this.doctrine.bonusMagicDefense();
        } else {
            i3 = 0;
        }

        boolean zDoubleAccessoryStats = this.doctrine.doubleAccessoryStats();
        int i5 = 0;
        for (Equipment equipment : Arrays.asList(this.weapon, this.armor, this.accessory)) {
            if (equipment != null) {
                int mult = (zDoubleAccessoryStats && (equipment instanceof Accessory)) ? 2 : 1;
                if (i == 0) {
                    i5 += equipment.getConstitution() * mult;
                } else if (i == 1) {
                    i5 += equipment.getIntelligence() * mult;
                } else if (i == 2) {
                    i5 += equipment.getDexterity() * mult;
                } else if (i == 3) {
                    i5 += equipment.getMaxHp() * mult;
                } else if (i == 4) {
                    i5 += equipment.getDefense();
                } else if (i == 5) {
                    i5 += equipment.getMagicDefense();
                }
            }
        }

        double d = 1.0d;
        if (this.traitCommon != null) {
            switch (AnonymousClass1.$SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$adventurers$Trait[this.traitCommon.ordinal()]) {
                case 1:
                    if (i == 0) {
                        d = 1.15d;
                    }
                    break;
                case 2:
                    if (i == 2) {
                        d = 1.15d;
                    }
                    break;
                case 3:
                    if (i == 1) {
                        d = 1.15d;
                    }
                    break;
                case 4:
                    if (i == 0) {
                        d = 1.1d;
                    } else if (i == 1 || i == 2) {
                        d = 0.95d;
                    }
                    break;
                case 5:
                    if (i == 2) {
                        d = 1.1d;
                    } else if (i == 0 || i == 1) {
                        d = 0.95d;
                    }
                    break;
                case 6:
                    if (i == 1) {
                        d = 1.1d;
                    } else if (i == 0 || i == 2) {
                        d = 0.95d;
                    }
                    break;
            }
        }
        return Utils.round(((double) (i3 + i5)) * d);
    }

    /* JADX INFO: renamed from: it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$adventurers$Trait;

        static {
            int[] iArr = new int[Trait.values().length];
            $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$adventurers$Trait = iArr;
            try {
                iArr[Trait.BOOKWORM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$adventurers$Trait[Trait.FERAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$adventurers$Trait[Trait.BRUTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$adventurers$Trait[Trait.BOOKWORM_PLUS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$adventurers$Trait[Trait.FERAL_PLUS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$adventurers$Trait[Trait.BRUTE_PLUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public int totalExperienceToNextLevel() {
        return Formulas.experienceToNextLevel(this.level, isAscended());
    }

    public int addExperience(int i) {
        int level = getLevel();
        while (this.level < this.maxLevel && i > 0) {
            int iMin = Math.min(totalExperienceToNextLevel() - this.experience, i);
            i -= iMin;
            int i2 = this.experience + iMin;
            this.experience = i2;
            if (i2 >= totalExperienceToNextLevel()) {
                this.level++;
                this.experience = 0;
                this.currentHp = calculateTotalMaxHp();
            }
        }
        return getLevel() - level;
    }

    public void changeRareTrait(Trait trait) {
        this.traitRare = trait;
    }

    public int getDoctrinePoints() {
        if (!this.ascended || this.doctrine.getTrueClass().equals("EmptyDoctrine")) {
            return 0;
        }
        int iDoctrinePointsFromLevels = doctrinePointsFromLevels() + this.doctrine.bonusQuestPoints();
        for (DoctrineAbility doctrineAbility : this.doctrine.getAbilities()) {
            iDoctrinePointsFromLevels -= doctrineAbility.getLevel() * doctrineAbility.getType().cost;
        }
        return iDoctrinePointsFromLevels;
    }

    public int doctrinePointsFromLevels() {
        int i = this.maxLevel;
        return ((((int) ((((double) (i - 5)) * 0.5d) * ((double) (i / 5)))) + this.level) / 15) + 3;
    }

    public int simulateDoctrinePoints(Doctrine doctrine) {
        if (!this.ascended || doctrine.getTrueClass().equals("EmptyDoctrine")) {
            return 0;
        }
        return doctrinePointsFromLevels() + doctrine.bonusQuestPoints();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean canPickDoctrine() {
        return this.ascended;
    }
}
