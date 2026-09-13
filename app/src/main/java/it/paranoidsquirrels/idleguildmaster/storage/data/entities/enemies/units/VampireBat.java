package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class VampireBat extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 52;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 28;
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
        this.baseMaxHp = 350;
        this.baseConstitution = 2;
        this.baseIntelligence = 2;
        this.baseDexterity = 65;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.flying = true;
        this.baseLifesteal = 100;
        this.imageId = R.drawable.unit_vampire_bat;
        this.idName = R.string.enemy_vampire_bat_name;
        this.idDescription = R.string.enemy_vampire_bat_description;
        this.passiveSkill = Skills.PASSIVE_FLYING_LEECH;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.rarity = 1;
        this.expGiven = 58;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("BatWing", 1), 300);
        linkedHashMap.put(ItemWrapper.getInstance("BatTooth", 1), 200);
        linkedHashMap.put(ItemWrapper.getInstance("AvianEgg", 1), 1);
        return linkedHashMap;
    }
}
