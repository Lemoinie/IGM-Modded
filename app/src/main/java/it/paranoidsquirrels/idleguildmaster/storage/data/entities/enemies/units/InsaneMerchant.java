package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class InsaneMerchant extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 27;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 23;
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
        this.baseMaxHp = 180;
        this.baseConstitution = 16;
        this.baseIntelligence = 20;
        this.baseDexterity = 5;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.imageId = R.drawable.unit_insane_merchant;
        this.idName = R.string.enemy_insane_merchant_name;
        this.idDescription = R.string.enemy_insane_merchant_description;
        this.passiveSkill = Skills.PASSIVE_NONE;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.rarity = 1;
        this.expGiven = 19;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("Emerald", 1), 40);
        linkedHashMap.put(ItemWrapper.getInstance("Ruby", 1), 40);
        ItemWrapper itemWrapper = ItemWrapper.getInstance("Ivory", 1);
        Integer numValueOf = Integer.valueOf(Logger.BARD_SHIELD);
        linkedHashMap.put(itemWrapper, numValueOf);
        linkedHashMap.put(ItemWrapper.getInstance("Redwood", 10), 180);
        linkedHashMap.put(ItemWrapper.getInstance("Flute", 1), 8);
        linkedHashMap.put(ItemWrapper.getInstance("Chocolate", 1), numValueOf);
        if (i == 1) {
            linkedHashMap.put(ItemWrapper.getInstance("BlackOoze", 1), 200);
        }
        return linkedHashMap;
    }
}
