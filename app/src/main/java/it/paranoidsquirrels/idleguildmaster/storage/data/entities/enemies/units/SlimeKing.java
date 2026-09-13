package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import androidx.recyclerview.widget.ItemTouchHelper;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class SlimeKing extends Enemy {
    private transient List<StatusEffect> onHit;

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 50;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 40;
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
        this.baseMaxHp = 1000;
        this.baseConstitution = 38;
        this.baseIntelligence = 5;
        this.baseDexterity = 8;
        this.baseDefense = 40;
        this.baseMagicDefense = 0;
        this.alwaysHits = true;
        this.immunityToStatus = 0.5d;
        this.imageId = R.drawable.unit_slime_king;
        this.idName = R.string.enemy_slime_king_name;
        this.idDescription = R.string.enemy_slime_king_description;
        this.passiveSkill = Skills.PASSIVE_DISSOLVE_BY_DECREE;
        this.activeSkill = Skills.ACTIVE_NONE;
        ArrayList arrayList = new ArrayList();
        this.onHit = arrayList;
        arrayList.add(new StatusEffect(StatusEffectType.POISON, this, 3, 0.7d));
        this.onHit.add(new StatusEffect(StatusEffectType.SILENCE, this, 3, 0.7d));
        this.onHit.add(new StatusEffect(StatusEffectType.FROZEN, this, 3, 0.7d));
        this.onHit.add(new StatusEffect(StatusEffectType.ABLAZE, this, 3, 0.7d));
        this.onHit.add(new StatusEffect(StatusEffectType.STUN, this, 3, 0.7d));
        this.expGiven = 240;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy, it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public List<StatusEffect> onTargetHitEffects() {
        return this.onHit;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("GreenSlime", 1), 210);
        linkedHashMap.put(ItemWrapper.getInstance("GreenSlime", 2), 500);
        linkedHashMap.put(ItemWrapper.getInstance("GreenSlime", 3), Integer.valueOf(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
        linkedHashMap.put(ItemWrapper.getInstance("SlimeKingsCrown", 1), 30);
        linkedHashMap.put(ItemWrapper.getInstance("SeekingGlass", 1), 10);
        return linkedHashMap;
    }
}
