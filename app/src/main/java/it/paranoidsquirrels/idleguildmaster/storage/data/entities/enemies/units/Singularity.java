package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class Singularity extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int getCurrentMana() {
        return 100;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 1275;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 1225;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean isMagic() {
        return true;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean isRanged() {
        return true;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected void configureStatistics() {
        this.baseMaxHp = 30000;
        this.baseConstitution = 100;
        this.baseIntelligence = 100;
        this.baseDexterity = 100;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.immunityToStatus = 0.8d;
        this.imageId = R.drawable.unit_singularity;
        this.idName = R.string.enemy_singularity_name;
        this.idDescription = R.string.enemy_singularity_description;
        this.passiveSkill = Skills.PASSIVE_INFINITY;
        this.activeSkill = Skills.ACTIVE_GRAVITY_SHIFT;
        this.rarity = 1;
        this.expGiven = 12000;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("FlakeOfInfinity", 1), 960);
        linkedHashMap.put(ItemWrapper.getInstance("InfinityHat", 1), 40);
        return linkedHashMap;
    }
}
