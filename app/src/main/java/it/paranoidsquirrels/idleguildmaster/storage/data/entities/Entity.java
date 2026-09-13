package it.paranoidsquirrels.idleguildmaster.storage.data.entities;

import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Entity {
    public static final transient int MAX_MANA = 100;
    protected transient Skills activeSkill;
    protected transient int baseConstitution;
    protected transient int baseDefense;
    protected transient int baseDexterity;
    protected transient int baseIntelligence;
    protected transient int baseMagicDefense;
    protected transient int baseMaxHp;
    protected int currentHp;
    protected int currentMana;
    protected int currentShield;
    protected transient EndOfTurnAction endOfTurnAction;
    protected transient int enemy;
    protected transient int idDescription;
    protected transient int idName;
    protected transient int imageId;
    protected transient StatusEffect onSelfHit;
    protected transient StatusEffect onTargetHit;
    protected transient Skills passiveSkill;
    protected String trueClass;
    protected transient int threat = 1;
    protected transient double counterattack = 0.0d;
    protected transient boolean flying = false;
    protected transient int baseLifesteal = 0;
    protected transient double darknessDamageAmplification = 0.0d;
    protected transient boolean healer = false;
    protected transient boolean cleanser = false;
    protected transient boolean initiative = false;
    protected transient int retaliationPhysicalDamage = 0;
    protected transient int retaliationMagicalDamage = 0;
    protected transient double healingModifier = 1.0d;
    protected transient double immunityToStatus = 0.0d;
    protected transient double ignoreImmunityToStatus = 0.0d;
    protected transient int regeneration = 0;
    protected transient double criticalDamage = 1.5d;
    protected transient boolean alwaysHits = false;
    protected transient int onFireBonusDamage = 0;
    protected transient int freezeBonusDamage = 0;
    protected transient int poisonBonus = 0;
    protected transient int livingCompanionBonusDamage = 0;
    protected transient int regenerationBonus = 0;
    protected transient double flatDodgeChance = 0.0d;
    protected transient double stunChanceOnLowerHp = 0.0d;
    protected transient int inspireExaltExtraTurns = 0;
    protected transient double criticalReduction = 0.0d;
    protected transient int maxLifestealOverheal = 0;
    protected transient int damagePerTurnPerStatus = 0;
    protected transient double armorIgnored = 0.0d;
    protected transient boolean forcesTargetToCounterattack = false;
    protected transient boolean addsDefensesToRetaliate = false;
    protected transient boolean moreDamageWhenHalfLife = false;
    protected transient boolean moreDamageDealtAndTaken = false;
    protected transient int maxOverheal = 0;
    protected transient int bonusResurrectChance = 0;
    protected transient int healMissingHpOnEnemyDeath = 0;
    protected transient int team = 0;
    protected transient Map.Entry<String, Double> increaseHealingAgainst = null;
    protected transient List<StatusEffectType> statusImmunities = new ArrayList();
    protected transient List<StatusEffect> onDeathEffectsOnEnemies = new ArrayList();
    protected transient List<StatusEffect> onDeathEffectsOnAllies = new ArrayList();
    protected List<StatusEffect> negativeStatusEffects = new CopyOnWriteArrayList();
    protected List<StatusEffect> positiveStatusEffects = new CopyOnWriteArrayList();

    public abstract double calculateCounterattackChance();

    public abstract double calculateCriticalChance();

    public abstract double calculateCriticalDamage();

    public abstract double calculateHealingModifier();

    public abstract double calculateImmunityToStatus();

    public abstract int calculateMaxAttackDamage();

    public abstract int calculateMinAttackDamage();

    public abstract int calculateRetaliationMagicalDamage();

    public abstract int calculateRetaliationPhysicalDamage();

    public abstract int calculateTotalConstitution();

    public abstract double calculateTotalDarknessDamageAmplification();

    public abstract int calculateTotalDefense();

    public abstract int calculateTotalDexterity();

    public abstract double calculateTotalFlatDodgeChance();

    public abstract int calculateTotalIntelligence();

    public abstract int calculateTotalLifesteal();

    public abstract int calculateTotalMagicDefense();

    public abstract int calculateTotalMaxHp();

    public abstract int calculateTotalRegeneration();

    public boolean canPickDoctrine() {
        return false;
    }

    public abstract List<EndOfTurnAction> endOfTurnActions();

    public abstract boolean isMagic();

    public abstract boolean isRanged();

    public abstract List<StatusEffect> onSelfHitEffects();

    public abstract List<StatusEffect> onTargetHitEffects();

    public abstract boolean rollsDamageThreeTimes();

    public int getIdName() {
        return this.idName;
    }

    public int getIdDescription() {
        return this.idDescription;
    }

    public String getTrueClass() {
        return this.trueClass;
    }

    public int getImageId() {
        return this.imageId;
    }

    public Skills getPassiveSkill() {
        return this.passiveSkill;
    }

    public Skills getActiveSkill() {
        return this.activeSkill;
    }

    public int getCurrentHp() {
        return this.currentHp;
    }

    public void setCurrentHp(int i) {
        this.currentHp = i;
    }

    public int getCurrentMana() {
        return this.currentMana;
    }

    public void setCurrentMana(int i) {
        this.currentMana = i;
    }

    public int getCurrentShield() {
        return this.currentShield;
    }

    public void setCurrentShield(int i) {
        this.currentShield = i;
    }

    public boolean isFlying() {
        return this.flying;
    }

    public boolean isHealer() {
        return this.healer;
    }

    public boolean isCleanser() {
        return this.cleanser;
    }

    public boolean isInitiative() {
        return this.initiative;
    }

    public double calculateIgnoreImmunityToStatus() {
        return this.ignoreImmunityToStatus;
    }

    public boolean isAlwaysHits() {
        return this.alwaysHits;
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

    public double getStunChanceOnLowerHp() {
        return this.stunChanceOnLowerHp;
    }

    public int getInspireExaltBonusTurns() {
        return this.inspireExaltExtraTurns;
    }

    public double getCriticalReduction() {
        return this.criticalReduction;
    }

    public int getMaxLifestealOverheal() {
        return this.maxLifestealOverheal;
    }

    public int getDamagePerTurnPerStatus() {
        return this.damagePerTurnPerStatus;
    }

    public double getArmorIgnored() {
        return this.armorIgnored;
    }

    public boolean isForcesTargetToCounterattack() {
        return this.forcesTargetToCounterattack;
    }

    public boolean isAddsDefensesToRetaliate() {
        return this.addsDefensesToRetaliate;
    }

    public boolean isMoreDamageWhenHalfLife() {
        return this.moreDamageWhenHalfLife;
    }

    public boolean isMoreDamageDealtAndTaken() {
        return this.moreDamageDealtAndTaken;
    }

    public int getMaxOverheal() {
        return this.maxOverheal;
    }

    public int getBonusResurrectChance() {
        return this.bonusResurrectChance;
    }

    public int getHealMissingHpOnEnemyDeath() {
        return this.healMissingHpOnEnemyDeath;
    }

    public int getTeam() {
        return this.team;
    }

    public Map.Entry<String, Double> getIncreaseHealingAgainst() {
        return this.increaseHealingAgainst;
    }

    public int getThreat() {
        return this.threat;
    }

    public List<StatusEffect> getNegativeStatusEffects() {
        return this.negativeStatusEffects;
    }

    public void setNegativeStatusEffects(List<StatusEffect> list) {
        this.negativeStatusEffects = list;
    }

    public List<StatusEffect> getPositiveStatusEffects() {
        return this.positiveStatusEffects;
    }

    public void setPositiveStatusEffects(List<StatusEffect> list) {
        this.positiveStatusEffects = list;
    }

    public List<StatusEffect> calculateOnDeathEffectsOnEnemies() {
        return this.onDeathEffectsOnEnemies;
    }

    public List<StatusEffect> calculateOnDeathEffectsOnAllies() {
        return this.onDeathEffectsOnAllies;
    }

    public int calculateManaRegen() {
        return (calculateTotalIntelligence() / 10) + 10;
    }

    public double rollAttackDamage() {
        double poisonBonus;
        int iCalculateMinAttackDamage = calculateMinAttackDamage();
        int iCalculateMaxAttackDamage = calculateMaxAttackDamage();
        double dRandom = Utils.random();
        if (rollsDamageThreeTimes()) {
            dRandom = Math.max(Math.max(dRandom, Utils.random()), Utils.random());
        }
        double d = (dRandom * ((double) (iCalculateMaxAttackDamage - iCalculateMinAttackDamage))) + ((double) iCalculateMinAttackDamage);
        if ((this instanceof Adventurer) && d > iCalculateMaxAttackDamage - 1) {
            QuestsManager.increment(QuestsManager.luckyRoll, 1L);
        }
        for (StatusEffect statusEffect : this.negativeStatusEffects) {
            if (statusEffect.getType() == StatusEffectType.POISON) {
                poisonBonus = 0.2d;
                if (statusEffect.getCause() != null) {
                    poisonBonus = 0.2d + (((double) statusEffect.getCause().getPoisonBonus()) * 0.01d);
                }
                return d * (1.0d - poisonBonus);
            }
        }
        poisonBonus = 0.0d;
        return d * (1.0d - poisonBonus);
    }

    public int applyDamage(double d, boolean z, int i, double d2) {
        if (this instanceof Enemy) {
            i = 0;
        }
        int iRound = Utils.round(Math.max(1.0d, (((1.0d - Math.min(1.0d, ((1.0d - d2) * 0.01d) * ((double) (z ? calculateTotalMagicDefense() : calculateTotalDefense())))) * d) - ((double) calculateFlatDamageReduction())) - ((double) i)));
        if (this instanceof Adventurer) {
            QuestsManager.increment(QuestsManager.heavyArmor, (int) (d - ((double) iRound)));
            QuestsManager.increment(QuestsManager.protector, iRound);
        }
        int i2 = this.currentShield;
        if (i2 >= iRound) {
            this.currentShield = i2 - iRound;
        } else {
            this.currentHp = Math.max(0, (this.currentHp - iRound) + i2);
            this.currentShield = 0;
        }
        return iRound;
    }

    protected int calculateFlatDamageReduction() {
        Iterator<StatusEffect> it2 = this.positiveStatusEffects.iterator();
        int i = 0;
        while (it2.hasNext()) {
            if (it2.next().getType() == StatusEffectType.EXALT) {
                i += 5;
            }
        }
        return i + (calculateTotalConstitution() / 8);
    }

    public int addStatusEffect(StatusEffect statusEffect, double d) {
        StatusEffect next;
        boolean z = Utils.random() < d;
        if ((!z && this.statusImmunities.contains(statusEffect.getType())) || Utils.random() > statusEffect.getProbability()) {
            return 0;
        }
        double dCalculateImmunityToStatus = statusEffect.getType().negative ? calculateImmunityToStatus() : 0.0d;
        if (!z && Utils.random() < dCalculateImmunityToStatus) {
            if (this instanceof Adventurer) {
                QuestsManager.increment(QuestsManager.crystalClear, 1L);
            }
            return 0;
        }
        StatusEffect statusEffect2 = new StatusEffect(statusEffect.getType(), statusEffect.getCause(), statusEffect.getTurnsLeft(), 1.0d);
        List<StatusEffect> list = statusEffect2.getType().negative ? this.negativeStatusEffects : this.positiveStatusEffects;
        Iterator<StatusEffect> it2 = list.iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (statusEffect2.getType() != next.getType());
        switch (AnonymousClass1.$SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[statusEffect2.getType().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                if (next != null) {
                    if (next.getTurnsLeft() >= statusEffect2.getTurnsLeft()) {
                        return 0;
                    }
                    list.remove(next);
                }
                list.add(statusEffect2);
                return statusEffect2.getTurnsLeft();
            case 25:
                if (next != null) {
                    int turnsLeft = next.getTurnsLeft() + statusEffect2.getTurnsLeft();
                    next.setTurnsLeft(turnsLeft);
                    return turnsLeft;
                }
                list.add(statusEffect2);
                return statusEffect2.getTurnsLeft();
            default:
                return 0;
        }
    }

    /* JADX INFO: renamed from: it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType;

        static {
            int[] iArr = new int[StatusEffectType.values().length];
            $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType = iArr;
            try {
                iArr[StatusEffectType.TAUNT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.DEFENSIVE_STANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.STUN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.STUN_NOT_CLEANSABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.SILENCE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.ABLAZE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.POISON.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.LESSER_CURSE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.CURSE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.GREATER_CURSE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.OMINOUS_CURSE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.ABHORRENT_CURSE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.DELIRIUM.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.FRENZY.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.ANOINTED.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.SKELETON_KEY.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.FROZEN.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.REGENERATION.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.FEEBLE_TETHER.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.INSPIRE.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.EXALT.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.PETRIFY.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.FALSE_LIFE.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.TERRIFY.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$it$paranoidsquirrels$idleguildmaster$storage$data$entities$StatusEffectType[StatusEffectType.BLEED.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
        }
    }
}
