package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class TheExiled extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 1425;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 1075;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean isMagic() {
        return false;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean isRanged() {
        return false;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected void configureStatistics() {
        this.baseMaxHp = 30000;
        this.baseConstitution = 215;
        this.baseIntelligence = 215;
        this.baseDexterity = 215;
        this.baseDefense = 25;
        this.baseMagicDefense = 25;
        this.threat = 5;
        this.alwaysHits = true;
        this.baseLifesteal = 35;
        this.counterattack = 0.8d;
        this.darknessDamageAmplification = 0.02d;
        this.immunityToStatus = 0.9d;
        this.regeneration = 500;
        this.flatDodgeChance = 0.3d;
        this.criticalDamage = 2.5d;
        this.initiative = true;
        this.imageId = R.drawable.unit_the_exiled;
        this.idName = R.string.enemy_the_exiled_name;
        this.idDescription = R.string.enemy_the_exiled_description;
        this.passiveSkill = Skills.PASSIVE_BIOENHANCED_II;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.rarity = 1;
        this.expGiven = 15000;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    protected int calculateFlatDamageReduction() {
        return super.calculateFlatDamageReduction() + 40;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("GiftOfLight", 1), 666);
        return linkedHashMap;
    }
}
