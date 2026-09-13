package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import androidx.recyclerview.widget.ItemTouchHelper;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class Ent extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 14;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 11;
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
        this.baseIntelligence = 20;
        this.baseDexterity = 3;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.imageId = R.drawable.unit_ent;
        this.idName = R.string.enemy_ent_name;
        this.idDescription = R.string.enemy_ent_description;
        this.passiveSkill = Skills.PASSIVE_NONE;
        this.activeSkill = Skills.ACTIVE_STOMP;
        this.rarity = 3;
        this.expGiven = Logger.BARD_SHIELD;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("Wood", 1), 499);
        linkedHashMap.put(ItemWrapper.getInstance("AncientSeed", 1), 50);
        linkedHashMap.put(ItemWrapper.getInstance("Apple", 1), Integer.valueOf(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
        linkedHashMap.put(ItemWrapper.getInstance("WoodenEgg", 1), 1);
        return linkedHashMap;
    }
}
