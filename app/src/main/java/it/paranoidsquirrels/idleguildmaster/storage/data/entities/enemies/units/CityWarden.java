package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class CityWarden extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 31;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 26;
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
        this.baseMaxHp = 300;
        this.baseConstitution = 20;
        this.baseIntelligence = 8;
        this.baseDexterity = 16;
        this.baseDefense = 15;
        this.baseMagicDefense = 0;
        this.threat = 2;
        this.imageId = R.drawable.unit_city_warden;
        this.idName = R.string.enemy_city_warden_name;
        this.idDescription = R.string.enemy_city_warden_description;
        this.passiveSkill = Skills.PASSIVE_THREATENING_I;
        this.activeSkill = Skills.ACTIVE_RESTORE_ORDER;
        this.rarity = 1;
        this.expGiven = 35;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("WardenBelt", 1), 50);
        linkedHashMap.put(ItemWrapper.getInstance("SilkThread", 1), 200);
        if (i == 1) {
            linkedHashMap.put(ItemWrapper.getInstance("BlackOoze", 1), 200);
        }
        return linkedHashMap;
    }
}
