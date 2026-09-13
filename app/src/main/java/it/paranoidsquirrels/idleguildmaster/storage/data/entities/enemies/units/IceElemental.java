package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class IceElemental extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 55;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 20;
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
        this.baseMaxHp = 2000;
        this.baseConstitution = 3;
        this.baseIntelligence = 33;
        this.baseDexterity = 3;
        this.baseDefense = 0;
        this.baseMagicDefense = 50;
        this.onSelfHit = new StatusEffect(StatusEffectType.FROZEN, this, 4, 1.0d);
        this.onTargetHit = new StatusEffect(StatusEffectType.FROZEN, this, 4, 1.0d);
        this.imageId = R.drawable.unit_ice_elemental;
        this.idName = R.string.enemy_ice_elemental_name;
        this.idDescription = R.string.enemy_ice_elemental_description;
        this.passiveSkill = Skills.PASSIVE_SUB_ZERO;
        this.activeSkill = Skills.ACTIVE_ICE_TOMB;
        this.rarity = 1;
        this.expGiven = 280;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("FrostmetalOre", 1), 500);
        linkedHashMap.put(ItemWrapper.getInstance("FrostCrystal", 1), 50);
        linkedHashMap.put(ItemWrapper.getInstance("FrostNucleus", 1), 5);
        linkedHashMap.put(ItemWrapper.getInstance("EsotericEgg", 1), 1);
        return linkedHashMap;
    }
}
