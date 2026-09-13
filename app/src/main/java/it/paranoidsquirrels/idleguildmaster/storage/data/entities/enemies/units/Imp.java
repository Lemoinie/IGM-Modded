package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class Imp extends Enemy {
    private transient List<StatusEffect> onHit;

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 180;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 130;
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
        this.baseMaxHp = 440;
        this.baseConstitution = 50;
        this.baseIntelligence = 1;
        this.baseDexterity = 94;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.flying = true;
        ArrayList arrayList = new ArrayList();
        this.onHit = arrayList;
        arrayList.add(new StatusEffect(StatusEffectType.POISON, this, 12, 1.0d));
        this.onHit.add(new StatusEffect(StatusEffectType.BLEED, this, 12, 1.0d));
        this.imageId = R.drawable.unit_imp;
        this.idName = R.string.enemy_imp_name;
        this.idDescription = R.string.enemy_imp_description;
        this.passiveSkill = Skills.PASSIVE_FLYING_DISEASE;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.rarity = 1;
        this.expGiven = Logger.ARCANE_SUPPRESSION;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy, it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public List<StatusEffect> onTargetHitEffects() {
        return this.onHit;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("SpellwovenHide", 1), 400);
        return linkedHashMap;
    }
}
