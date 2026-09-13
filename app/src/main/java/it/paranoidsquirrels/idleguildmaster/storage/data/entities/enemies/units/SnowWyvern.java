package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class SnowWyvern extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 90;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 65;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean isMagic() {
        return true;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean isRanged() {
        return false;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected void configureStatistics() {
        this.baseMaxHp = 1250;
        this.baseConstitution = 15;
        this.baseIntelligence = 30;
        this.baseDexterity = 40;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.flying = true;
        this.imageId = R.drawable.unit_snow_wyvern;
        this.idName = R.string.enemy_snow_wyvern_name;
        this.idDescription = R.string.enemy_snow_wyvern_description;
        this.passiveSkill = Skills.PASSIVE_FLYING;
        this.activeSkill = Skills.ACTIVE_FROZEN_BREATH;
        this.rarity = 1;
        this.expGiven = 520;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("FrostmetalOre", 1), 500);
        linkedHashMap.put(ItemWrapper.getInstance("FrozenScale", 1), 50);
        linkedHashMap.put(ItemWrapper.getInstance("FrozenEgg", 1), 5);
        linkedHashMap.put(ItemWrapper.getInstance("WyvernChop", 1), 200);
        linkedHashMap.put(ItemWrapper.getInstance("AvianEgg", 1), 1);
        return linkedHashMap;
    }
}
