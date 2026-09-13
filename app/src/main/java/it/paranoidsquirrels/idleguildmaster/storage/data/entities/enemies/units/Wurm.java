package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class Wurm extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 16;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 8;
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
        this.baseMaxHp = 160;
        this.baseConstitution = 16;
        this.baseIntelligence = 2;
        this.baseDexterity = 6;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.imageId = R.drawable.unit_wurm;
        this.idName = R.string.enemy_wurm_name;
        this.idDescription = R.string.enemy_wurm_description;
        this.baseLifesteal = 100;
        this.passiveSkill = Skills.PASSIVE_LEECH;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.expGiven = 14;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("WurmScale", 1), 300);
        linkedHashMap.put(ItemWrapper.getInstance("WurmBlood", 1), 300);
        linkedHashMap.put(ItemWrapper.getInstance("InsectEgg", 1), 1);
        return linkedHashMap;
    }
}
