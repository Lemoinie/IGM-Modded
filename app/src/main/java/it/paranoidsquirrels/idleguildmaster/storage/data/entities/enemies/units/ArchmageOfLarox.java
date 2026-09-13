package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ArchmageOfLarox extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 195;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 180;
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
        this.baseMaxHp = 770;
        this.baseConstitution = 4;
        this.baseIntelligence = 245;
        this.baseDexterity = 34;
        this.baseDefense = 0;
        this.baseMagicDefense = 30;
        this.imageId = R.drawable.unit_archmage_of_larox;
        this.idName = R.string.enemy_archmage_of_larox_name;
        this.idDescription = R.string.enemy_archmage_of_larox_description;
        this.passiveSkill = Skills.PASSIVE_ELEMENTAL_MASTERY;
        this.activeSkill = Skills.ACTIVE_RAYS_OF_DESTRUCTION;
        this.rarity = 1;
        this.expGiven = 330;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy, it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public List<StatusEffect> onTargetHitEffects() {
        double dRandom = Utils.random();
        StatusEffectType statusEffectType = StatusEffectType.ABLAZE;
        if (dRandom > 0.6666666666666666d) {
            statusEffectType = StatusEffectType.FROZEN;
        } else if (dRandom > 0.3333333333333333d) {
            statusEffectType = StatusEffectType.STUN;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new StatusEffect(statusEffectType, this, 4, 1.0d));
        return arrayList;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("LaroxianFabric", 1), 275);
        linkedHashMap.put(ItemWrapper.getInstance("Pumpkin", 1), 35);
        linkedHashMap.put(ItemWrapper.getInstance("SpellCompendium", 1), 3);
        linkedHashMap.put(ItemWrapper.getInstance("RuneOfPower", 1), 3);
        linkedHashMap.put(ItemWrapper.getInstance("ArchmageHat", 1), 1);
        return linkedHashMap;
    }
}
