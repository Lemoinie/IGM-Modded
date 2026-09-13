package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class Terrorsaurus extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 480;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 400;
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
        this.baseMaxHp = 2600;
        this.baseConstitution = 94;
        this.baseIntelligence = 1;
        this.baseDexterity = 12;
        this.baseDefense = 10;
        this.baseMagicDefense = 0;
        this.threat = 3;
        this.imageId = R.drawable.unit_terrorsaurus;
        this.idName = R.string.enemy_terrorsaurus_name;
        this.idDescription = R.string.enemy_terrorsaurus_description;
        this.passiveSkill = Skills.PASSIVE_PREHISTORIC_COLOSSUS;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.rarity = 1;
        this.expGiven = 194;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("AncientHide", 1), 390);
        linkedHashMap.put(ItemWrapper.getInstance("TerrorsaurusFang", 1), 1);
        linkedHashMap.put(ItemWrapper.getInstance("DinoRibs", 1), 67);
        linkedHashMap.put(ItemWrapper.getInstance("ReptileEgg", 1), 1);
        return linkedHashMap;
    }
}
