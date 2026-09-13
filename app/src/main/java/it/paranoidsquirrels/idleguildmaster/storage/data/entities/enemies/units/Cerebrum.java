package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import androidx.recyclerview.widget.ItemTouchHelper;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class Cerebrum extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 800;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 500;
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
        this.baseMaxHp = 5000;
        this.baseConstitution = 100;
        this.baseIntelligence = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        this.baseDexterity = 1;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.endOfTurnAction = EndOfTurnAction.EXTRA_ATTACK;
        this.onTargetHit = new StatusEffect(StatusEffectType.PETRIFY, this, 2, 1.0d);
        this.imageId = R.drawable.unit_cerebrum;
        this.idName = R.string.enemy_cerebrum_name;
        this.idDescription = R.string.enemy_cerebrum_description;
        this.passiveSkill = Skills.PASSIVE_MIND_FLAY;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.rarity = 1;
        this.expGiven = 860;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("AbioticCore", 1), 100);
        return linkedHashMap;
    }
}
