package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class FrozenSlime extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 35;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 26;
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
        this.baseMaxHp = 100;
        this.baseConstitution = 40;
        this.baseIntelligence = 2;
        this.baseDexterity = 6;
        this.baseDefense = 40;
        this.baseMagicDefense = 0;
        this.onTargetHit = new StatusEffect(StatusEffectType.FROZEN, this, 4, 1.0d);
        this.onSelfHit = new StatusEffect(StatusEffectType.FROZEN, this, 4, 1.0d);
        this.imageId = R.drawable.unit_frozen_slime;
        this.idName = R.string.enemy_frozen_slime_name;
        this.idDescription = R.string.enemy_frozen_slime_description;
        this.passiveSkill = Skills.PASSIVE_SUB_ZERO;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.expGiven = 30;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("GreenSlime", 1), 530);
        linkedHashMap.put(ItemWrapper.getInstance("GreenSlime", 2), 200);
        linkedHashMap.put(ItemWrapper.getInstance("GreenSlime", 3), 50);
        linkedHashMap.put(ItemWrapper.getInstance("PermafrostCore", 1), Integer.valueOf(Logger.BARD_SHIELD));
        linkedHashMap.put(ItemWrapper.getInstance("PotionOfImmunity", 1), 100);
        return linkedHashMap;
    }
}
