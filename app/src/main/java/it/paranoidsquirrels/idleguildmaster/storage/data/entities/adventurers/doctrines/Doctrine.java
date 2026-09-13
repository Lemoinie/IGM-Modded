package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Doctrine {
    private static final transient String CLASS_PATH = "it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances.%s";
    protected transient List<DoctrineAbility> abilities = new ArrayList();
    protected transient int idDescription;
    protected transient int idDescriptionShort;
    protected transient int idImage;
    protected transient int idName;
    protected int l1;
    protected int l2;
    protected int l3;
    protected int l4;
    protected int l5;
    protected int l6;
    protected String trueClass;

    public boolean addsDefensesToRetaliate() {
        return false;
    }

    public int bonusConstitution() {
        return 0;
    }

    public int bonusCounterattack() {
        return 0;
    }

    public int bonusCritChance() {
        return 0;
    }

    public int bonusCritDamage() {
        return 0;
    }

    public int bonusDefense() {
        return 0;
    }

    public int bonusDexterity() {
        return 0;
    }

    public int bonusDodgeChance() {
        return 0;
    }

    public int bonusHealingModifier() {
        return 0;
    }

    public int bonusHp() {
        return 0;
    }

    public int bonusIntelligence() {
        return 0;
    }

    public int bonusLifesteal() {
        return 0;
    }

    public int bonusMagicDefense() {
        return 0;
    }

    public int bonusManaRegen() {
        return 0;
    }

    public abstract int bonusQuestPoints();

    public int bonusResurrectionChance() {
        return 0;
    }

    public int bonusStatusImmunity() {
        return 0;
    }

    public int bonusThreat() {
        return 0;
    }

    public boolean canUseAllWeapons() {
        return false;
    }

    public int damageOnFalseLifeRemoval() {
        return 0;
    }

    public int damagePerTurnPerStatus() {
        return 0;
    }

    public int darknessDamageIncrease() {
        return 0;
    }

    public boolean doubleAccessoryStats() {
        return false;
    }

    public int extraAttackChance() {
        return 0;
    }

    public int falseLifeChance() {
        return 0;
    }

    public boolean forcesCounterattack() {
        return false;
    }

    public int freezeOnHit() {
        return 0;
    }

    public int healingNova() {
        return 0;
    }

    public int ignoreArmorPercentage() {
        return 0;
    }

    public int ignoreEnemyImmunities() {
        return 0;
    }

    public int maxLifestealOverheal() {
        return 0;
    }

    public int maxOverheal() {
        return 0;
    }

    public boolean moreDamageDealtAndTaken() {
        return false;
    }

    public boolean moreDamageWhenHalfLife() {
        return false;
    }

    public int petrifyOnHit() {
        return 0;
    }

    public int reduceCriticalBonusDamage() {
        return 0;
    }

    public boolean rollDamageThreeTimes() {
        return false;
    }

    protected abstract List<DoctrineAbilityType> setupAbilities();

    protected abstract void setupValues();

    public static Doctrine getInstance(String str) {
        return getInstance(str, 0, 0, 0, 0, 0, 0);
    }

    public static Doctrine getInstance(String str, int i, int i2, int i3, int i4, int i5, int i6) {
        try {
            int i7 = 0;
            Doctrine doctrine = (Doctrine) Class.forName(String.format(CLASS_PATH, str)).getConstructor(new Class[0]).newInstance(new Object[0]);
            doctrine.trueClass = str;
            doctrine.l1 = i;
            doctrine.l2 = i2;
            doctrine.l3 = i3;
            doctrine.l4 = i4;
            doctrine.l5 = i5;
            doctrine.l6 = i6;
            doctrine.setupValues();
            Iterator<DoctrineAbilityType> it2 = doctrine.setupAbilities().iterator();
            while (it2.hasNext()) {
                doctrine.setupAbility(it2.next(), i7);
                i7++;
            }
            return doctrine;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void setupAbility(DoctrineAbilityType doctrineAbilityType, int i) {
        int i2;
        if (i == 0) {
            i2 = this.l1;
        } else if (i == 1) {
            i2 = this.l2;
        } else if (i == 2) {
            i2 = this.l3;
        } else if (i == 3) {
            i2 = this.l4;
        } else if (i == 4) {
            i2 = this.l5;
        } else {
            i2 = i != 5 ? 0 : this.l6;
        }
        this.abilities.add(new DoctrineAbility(doctrineAbilityType, i2));
    }

    public void realignLevels() {
        int i = 0;
        for (DoctrineAbility doctrineAbility : this.abilities) {
            if (i == 0) {
                this.l1 = doctrineAbility.getLevel();
            } else if (i == 1) {
                this.l2 = doctrineAbility.getLevel();
            } else if (i == 2) {
                this.l3 = doctrineAbility.getLevel();
            } else if (i == 3) {
                this.l4 = doctrineAbility.getLevel();
            } else if (i == 4) {
                this.l5 = doctrineAbility.getLevel();
            } else if (i == 5) {
                this.l6 = doctrineAbility.getLevel();
            }
            i++;
        }
    }

    protected int getValue(DoctrineAbilityType doctrineAbilityType) {
        int iIndexOf = this.abilities.indexOf(new DoctrineAbility(doctrineAbilityType, 0));
        if (iIndexOf >= 0) {
            return this.abilities.get(iIndexOf).getValue();
        }
        return 0;
    }

    public int getIdImage() {
        return this.idImage;
    }

    public int getIdName() {
        return this.idName;
    }

    public int getIdDescription() {
        return this.idDescription;
    }

    public int getIdDescriptionShort() {
        return this.idDescriptionShort;
    }

    public List<DoctrineAbility> getAbilities() {
        return this.abilities;
    }

    public String getTrueClass() {
        return this.trueClass;
    }
}
