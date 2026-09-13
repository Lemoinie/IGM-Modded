package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class Dryad extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 280;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 150;
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
        this.baseMaxHp = 670;
        this.baseConstitution = 4;
        this.baseIntelligence = 150;
        this.baseDexterity = 60;
        this.baseDefense = 0;
        this.baseMagicDefense = 30;
        this.healer = true;
        this.imageId = R.drawable.unit_dryad;
        this.idName = R.string.enemy_dryad_name;
        this.idDescription = R.string.enemy_dryad_description;
        this.passiveSkill = Skills.PASSIVE_HEALER_I;
        this.activeSkill = Skills.ACTIVE_DAZE;
        this.rarity = 1;
        this.expGiven = 200;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("FleetfootFabric", 1), 350);
        linkedHashMap.put(ItemWrapper.getInstance("BagOfChokingPowder", 1), 100);
        linkedHashMap.put(ItemWrapper.getInstance("WhiteHair", 1), 15);
        linkedHashMap.put(ItemWrapper.getInstance("SylvanFlute", 1), 10);
        linkedHashMap.put(ItemWrapper.getInstance("MeatyMushroom", 1), Integer.valueOf(Logger.BARD_SHIELD));
        linkedHashMap.put(ItemWrapper.getInstance("PotionOfAgility", 1), 2);
        return linkedHashMap;
    }
}
