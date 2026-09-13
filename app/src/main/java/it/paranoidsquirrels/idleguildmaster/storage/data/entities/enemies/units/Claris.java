package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class Claris extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 188;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 182;
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
        this.baseMaxHp = 3200;
        this.baseConstitution = 6;
        this.baseIntelligence = 84;
        this.baseDexterity = 26;
        this.baseDefense = 0;
        this.baseMagicDefense = 50;
        this.onTargetHit = new StatusEffect(StatusEffectType.STUN, this, 3, 1.0d);
        this.imageId = R.drawable.unit_claris;
        this.idName = R.string.enemy_claris_name;
        this.idDescription = R.string.enemy_claris_description;
        this.passiveSkill = Skills.PASSIVE_STATIC_AFFINITY;
        this.activeSkill = Skills.ACTIVE_ARCANE_DIFFUSION;
        this.rarity = 1;
        this.expGiven = 540;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("SealOfClaris", 1), 50);
        linkedHashMap.put(ItemWrapper.getInstance("ElixirOfLearning", 1), 20);
        linkedHashMap.put(ItemWrapper.getInstance("PotionOfMagicDefense", 1), 100);
        return linkedHashMap;
    }
}
