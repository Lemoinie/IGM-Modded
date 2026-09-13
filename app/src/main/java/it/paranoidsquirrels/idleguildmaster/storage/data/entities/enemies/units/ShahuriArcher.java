package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ShahuriArcher extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 13;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 9;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean isMagic() {
        return false;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean isRanged() {
        return true;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected void configureStatistics() {
        this.baseMaxHp = 70;
        this.baseConstitution = 8;
        this.baseIntelligence = 10;
        this.baseDexterity = 25;
        this.baseDefense = 0;
        this.baseMagicDefense = 50;
        this.onTargetHit = new StatusEffect(StatusEffectType.STUN, this, 1, 0.1d);
        this.imageId = R.drawable.unit_shahuri_archer;
        this.idName = R.string.enemy_shahuri_archer_name;
        this.idDescription = R.string.enemy_shahuri_archer_description;
        this.passiveSkill = Skills.PASSIVE_DESERT_ARCHER;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.expGiven = 30;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("ScrapMetal", 1), 500);
        linkedHashMap.put(ItemWrapper.getInstance("Pineapple", 1), 10);
        linkedHashMap.put(ItemWrapper.getInstance("ShahuriBowFrame", 1), 30);
        return linkedHashMap;
    }
}
