package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies;

import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Enemy extends Entity {
    private static final transient String CLASS_PATH = "it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units.%s";
    protected transient int expGiven;
    protected transient int rarity;

    protected abstract void configureStatistics();

    protected abstract int getMaxDamage();

    protected abstract int getMinDamage();

    public abstract LinkedHashMap<ItemWrapper, Integer> listDrops(int i);

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean rollsDamageThreeTimes() {
        return false;
    }

    public static Enemy getInstance(String str) {
        try {
            Enemy enemy = (Enemy) Class.forName(String.format(CLASS_PATH, str)).getConstructor(new Class[0]).newInstance(new Object[0]);
            enemy.trueClass = str;
            enemy.configureStatistics();
            enemy.currentHp = enemy.calculateTotalMaxHp();
            return enemy;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getRarity() {
        return this.rarity;
    }

    public int getExpGiven() {
        return this.expGiven;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateMinAttackDamage() {
        return getMinDamage();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateMaxAttackDamage() {
        return getMaxDamage();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateTotalConstitution() {
        return this.baseConstitution;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateTotalIntelligence() {
        return this.baseIntelligence;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateTotalDexterity() {
        return this.baseDexterity;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateTotalMaxHp() {
        return this.baseMaxHp;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateTotalDefense() {
        return this.baseDefense;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateTotalMagicDefense() {
        return this.baseMagicDefense;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateTotalLifesteal() {
        return this.baseLifesteal;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public double calculateCounterattackChance() {
        return this.counterattack;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public double calculateTotalDarknessDamageAmplification() {
        return this.darknessDamageAmplification;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateRetaliationPhysicalDamage() {
        return this.retaliationPhysicalDamage;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateRetaliationMagicalDamage() {
        return this.retaliationMagicalDamage;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public double calculateHealingModifier() {
        return this.healingModifier;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public double calculateImmunityToStatus() {
        return this.immunityToStatus;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateTotalRegeneration() {
        return this.regeneration;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public double calculateTotalFlatDodgeChance() {
        return this.flatDodgeChance;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public double calculateCriticalDamage() {
        return this.criticalDamage;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public double calculateCriticalChance() {
        return Math.min(0.4d, ((double) (isMagic() ? calculateTotalIntelligence() : calculateTotalDexterity())) * 0.004d);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public List<StatusEffect> onTargetHitEffects() {
        ArrayList arrayList = new ArrayList();
        if (this.onTargetHit != null) {
            arrayList.add(this.onTargetHit);
        }
        return arrayList;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public List<StatusEffect> onSelfHitEffects() {
        ArrayList arrayList = new ArrayList();
        if (this.onSelfHit != null) {
            arrayList.add(this.onSelfHit);
        }
        return arrayList;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public List<EndOfTurnAction> endOfTurnActions() {
        ArrayList arrayList = new ArrayList();
        if (this.endOfTurnAction != null) {
            arrayList.add(this.endOfTurnAction);
        }
        return arrayList;
    }
}
