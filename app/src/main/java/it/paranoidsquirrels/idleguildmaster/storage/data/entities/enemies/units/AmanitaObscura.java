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
public class AmanitaObscura extends Enemy {
    private transient List<StatusEffect> onHit;

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 190;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 150;
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
        this.baseMaxHp = 450;
        this.baseConstitution = 14;
        this.baseIntelligence = 1;
        this.baseDexterity = 4;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.imageId = R.drawable.unit_amanita_obscura;
        this.idName = R.string.enemy_amanita_obscura_name;
        this.idDescription = R.string.enemy_amanita_obscura_description;
        this.passiveSkill = Skills.PASSIVE_NEUROTOXICITY;
        this.activeSkill = Skills.ACTIVE_NONE;
        ArrayList arrayList = new ArrayList();
        this.onHit = arrayList;
        arrayList.add(new StatusEffect(StatusEffectType.POISON, this, 3, 1.0d));
        this.onHit.add(new StatusEffect(StatusEffectType.STUN, this, 1, 1.0d));
        this.rarity = 1;
        this.expGiven = 188;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy, it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public List<StatusEffect> onTargetHitEffects() {
        return this.onHit;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy, it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public List<StatusEffect> onSelfHitEffects() {
        return this.onHit;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("PoisonousFlesh", 1), 10);
        return linkedHashMap;
    }
}
