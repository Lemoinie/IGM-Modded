package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import androidx.recyclerview.widget.ItemTouchHelper;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class Lazarus extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 4000;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 2800;
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
        this.baseMaxHp = 28500;
        this.baseConstitution = 80;
        this.baseIntelligence = 200;
        this.baseDexterity = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.baseLifesteal = 200;
        this.imageId = R.drawable.unit_lazarus;
        this.idName = R.string.enemy_lazarus_name;
        this.idDescription = R.string.enemy_lazarus_description;
        this.passiveSkill = Skills.PASSIVE_TRUE_LIFESTEAL;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.rarity = 1;
        this.expGiven = 5000;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("AncestralBlood", 1), 400);
        return linkedHashMap;
    }
}
