package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

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
public class Thorvus extends Enemy {
    private transient List<StatusEffect> onHit;

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 176;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 168;
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
        this.baseMaxHp = 4450;
        this.baseConstitution = 14;
        this.baseIntelligence = 68;
        this.baseDexterity = 20;
        this.baseDefense = 0;
        this.baseMagicDefense = 50;
        ArrayList arrayList = new ArrayList();
        this.onHit = arrayList;
        arrayList.add(new StatusEffect(StatusEffectType.ABLAZE, this, 2, 1.0d));
        this.onHit.add(new StatusEffect(StatusEffectType.FROZEN, this, 2, 1.0d));
        this.imageId = R.drawable.unit_thorvus;
        this.idName = R.string.enemy_thorvus_name;
        this.idDescription = R.string.enemy_thorvus_description;
        this.passiveSkill = Skills.PASSIVE_ELEMENTAL_DUALITY;
        this.activeSkill = Skills.ACTIVE_ARCANE_DIFFUSION;
        this.rarity = 1;
        this.expGiven = 500;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy, it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public List<StatusEffect> onTargetHitEffects() {
        return this.onHit;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("EternalHunger", 1), 100);
        linkedHashMap.put(ItemWrapper.getInstance("ElixirOfLearning", 1), 20);
        linkedHashMap.put(ItemWrapper.getInstance("PotionOfMagicDefense", 1), 100);
        return linkedHashMap;
    }
}
