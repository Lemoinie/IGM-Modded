package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import androidx.recyclerview.widget.ItemTouchHelper;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class Banshee extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 205;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 153;
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
        this.baseMaxHp = 1400;
        this.baseConstitution = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        this.baseIntelligence = 5;
        this.baseDexterity = 85;
        this.baseDefense = 35;
        this.baseMagicDefense = 35;
        this.team = 2;
        this.imageId = R.drawable.unit_banshee;
        this.idName = R.string.enemy_banshee_name;
        this.idDescription = R.string.enemy_banshee_description;
        this.threat = 3;
        this.passiveSkill = Skills.PASSIVE_TERRITORIAL;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.rarity = 1;
        this.expGiven = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("BansheeScale", 1), 600);
        linkedHashMap.put(ItemWrapper.getInstance("BansheeClaw", 1), 18);
        linkedHashMap.put(ItemWrapper.getInstance("BansheeHorn", 1), 2);
        linkedHashMap.put(ItemWrapper.getInstance("ReptileEgg", 1), 1);
        return linkedHashMap;
    }
}
