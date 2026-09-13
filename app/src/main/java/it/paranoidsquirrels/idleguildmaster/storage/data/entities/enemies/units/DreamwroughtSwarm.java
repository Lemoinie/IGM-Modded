package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DreamwroughtSwarm extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 285;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 275;
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
        this.baseMaxHp = 30;
        this.baseConstitution = 1;
        this.baseIntelligence = 50;
        this.baseDexterity = 65;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.statusImmunities.add(StatusEffectType.BLEED);
        this.statusImmunities.add(StatusEffectType.STUN);
        this.statusImmunities.add(StatusEffectType.PETRIFY);
        this.imageId = R.drawable.unit_dreamwrought_swarm;
        this.idName = R.string.enemy_dreamwrought_swarm_name;
        this.idDescription = R.string.enemy_dreamwrought_swarm_description;
        this.passiveSkill = Skills.PASSIVE_SWARM;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.rarity = 1;
        this.expGiven = 500;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy, it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public List<EndOfTurnAction> endOfTurnActions() {
        return this.currentHp <= 1 ? new ArrayList() : Collections.nCopies(this.currentHp - 1, EndOfTurnAction.EXTRA_ATTACK_90);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int applyDamage(double d, boolean z, int i, double d2) {
        return super.applyDamage(1.0d, z, i, 0.0d);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("DreamwroughtLarva", 1), 334);
        linkedHashMap.put(ItemWrapper.getInstance("DreamwroughtLarva", 2), 333);
        linkedHashMap.put(ItemWrapper.getInstance("DreamwroughtLarva", 3), 333);
        return linkedHashMap;
    }
}
