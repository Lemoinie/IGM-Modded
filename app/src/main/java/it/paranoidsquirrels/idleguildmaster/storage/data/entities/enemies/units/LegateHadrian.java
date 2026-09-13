package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class LegateHadrian extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 950;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 950;
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
        this.baseMaxHp = 6400;
        this.baseConstitution = Logger.BARD_SHIELD;
        this.baseIntelligence = 80;
        this.baseDexterity = 96;
        this.baseDefense = 20;
        this.baseMagicDefense = 20;
        this.threat = 3;
        this.alwaysHits = true;
        this.baseLifesteal = 20;
        this.counterattack = 0.5d;
        this.darknessDamageAmplification = 0.01d;
        this.immunityToStatus = 0.8d;
        this.regeneration = 75;
        this.flatDodgeChance = 0.2d;
        this.criticalDamage = 2.0d;
        this.initiative = true;
        this.imageId = R.drawable.unit_legate_hadrian;
        this.idName = R.string.enemy_legate_hadrian_name;
        this.idDescription = R.string.enemy_legate_hadrian_description;
        this.passiveSkill = Skills.PASSIVE_BIOENHANCED;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.rarity = 1;
        this.expGiven = 300;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    protected int calculateFlatDamageReduction() {
        return super.calculateFlatDamageReduction() + 15;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("Evo23Vial", 3), 1000);
        return linkedHashMap;
    }
}
