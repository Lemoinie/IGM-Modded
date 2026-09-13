package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses;

import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Equipment extends Item {
    protected transient int constitution;
    protected transient int defense;
    protected transient int dexterity;
    protected transient EndOfTurnAction endOfTurnAction;
    protected transient int intelligence;
    protected transient int magicDefense;
    protected transient int maxHp;
    protected transient StatusEffect onSelfHit;
    protected transient StatusEffect onTargetHit;
    protected transient int lifesteal = 0;
    protected transient int lifestealWithMinion = 0;
    protected transient int threat = 0;
    protected transient int bonusExperience = 0;
    protected transient int darknessReduction = 0;
    protected transient double counterattack = 0.0d;
    protected transient double darknessDamageAmplification = 0.0d;
    protected transient int retaliationPhysicalDamage = 0;
    protected transient int retaliationMagicalDamage = 0;
    protected transient double healingModifier = 0.0d;
    protected transient double immunityToStatus = 0.0d;
    protected transient int regeneration = 0;
    protected transient double criticalDamage = 0.0d;
    protected transient double criticalChance = 0.0d;
    protected transient boolean initiative = false;
    protected transient boolean alwaysHits = false;
    protected transient int onFireBonusDamage = 0;
    protected transient int freezeBonusDamage = 0;
    protected transient int poisonBonus = 0;
    protected transient int livingCompanionBonusDamage = 0;
    protected transient int regenerationBonus = 0;
    protected transient double flatDodgeChance = 0.0d;
    protected transient int decay = 0;
    protected transient int exaltInspireBonusTurns = 0;

    public int getConstitution() {
        return this.constitution;
    }

    public void setConstitution(int i) {
        this.constitution = i;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public void setIntelligence(int i) {
        this.intelligence = i;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public void setDexterity(int i) {
        this.dexterity = i;
    }

    public int getMaxHp() {
        return this.maxHp;
    }

    public void setMaxHp(int i) {
        this.maxHp = i;
    }

    public int getDefense() {
        return this.defense;
    }

    public void setDefense(int i) {
        this.defense = i;
    }

    public int getMagicDefense() {
        return this.magicDefense;
    }

    public void setMagicDefense(int i) {
        this.magicDefense = i;
    }

    public StatusEffect getOnTargetHit() {
        return this.onTargetHit;
    }

    public void setOnTargetHit(StatusEffect statusEffect) {
        this.onTargetHit = statusEffect;
    }

    public StatusEffect getOnSelfHit() {
        return this.onSelfHit;
    }

    public void setOnSelfHit(StatusEffect statusEffect) {
        this.onSelfHit = statusEffect;
    }

    public EndOfTurnAction getEndOfTurnAction() {
        return this.endOfTurnAction;
    }

    public int getLifesteal() {
        return this.lifesteal;
    }

    public int getLifestealWithMinion() {
        return this.lifestealWithMinion;
    }

    public int getThreat() {
        return this.threat;
    }

    public void setThreat(int i) {
        this.threat = i;
    }

    public int getRetaliationPhysicalDamage() {
        return this.retaliationPhysicalDamage;
    }

    public int getRetaliationMagicalDamage() {
        return this.retaliationMagicalDamage;
    }

    public double getHealingModifier() {
        return this.healingModifier;
    }

    public double getImmunityToStatus() {
        return this.immunityToStatus;
    }

    public void setImmunityToStatus(double d) {
        this.immunityToStatus = d;
    }

    public int getRegeneration() {
        return this.regeneration;
    }

    public void setRegeneration(int i) {
        this.regeneration = i;
    }

    public double getCriticalDamage() {
        return this.criticalDamage;
    }

    public double getCriticalChance() {
        return this.criticalChance;
    }

    public boolean isInitiative() {
        return this.initiative;
    }

    public void setInitiative(boolean z) {
        this.initiative = z;
    }

    public boolean isAlwaysHits() {
        return this.alwaysHits;
    }

    public void setAlwaysHits(boolean z) {
        this.alwaysHits = z;
    }

    public int getOnFireBonusDamage() {
        return this.onFireBonusDamage;
    }

    public int getFreezeBonusDamage() {
        return this.freezeBonusDamage;
    }

    public int getPoisonBonus() {
        return this.poisonBonus;
    }

    public int getLivingCompanionBonusDamage() {
        return this.livingCompanionBonusDamage;
    }

    public int getRegenerationBonus() {
        return this.regenerationBonus;
    }

    public double getFlatDodgeChance() {
        return this.flatDodgeChance;
    }

    public int getDecay() {
        return this.decay;
    }

    public int getExaltInspireBonusTurns() {
        return this.exaltInspireBonusTurns;
    }

    public int getBonusExperience() {
        return this.bonusExperience;
    }

    public int getDarknessReduction() {
        return this.darknessReduction;
    }

    public double getCounterattack() {
        return this.counterattack;
    }

    public void setCounterattack(double d) {
        this.counterattack = d;
    }

    public double getDarknessDamageAmplification() {
        return this.darknessDamageAmplification;
    }

    public void setDarknessDamageAmplification(double d) {
        this.darknessDamageAmplification = d;
    }
}
