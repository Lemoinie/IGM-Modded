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
public class WizardOfLarox extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 180;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 165;
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
        this.baseMaxHp = 750;
        this.baseConstitution = 8;
        this.baseIntelligence = 172;
        this.baseDexterity = 46;
        this.baseDefense = 0;
        this.baseMagicDefense = 30;
        this.imageId = R.drawable.unit_wizard_of_larox;
        this.idName = R.string.enemy_wizard_of_larox_name;
        this.idDescription = R.string.enemy_wizard_of_larox_description;
        this.passiveSkill = Skills.PASSIVE_ELEMENTAL_CONTROL;
        this.activeSkill = Skills.ACTIVE_RAYS_OF_DESTRUCTION;
        this.rarity = 1;
        this.expGiven = 200;
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
        arrayList.add(new StatusEffect(statusEffectType, this, 2, 1.0d));
        return arrayList;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("LaroxianFabric", 1), 225);
        linkedHashMap.put(ItemWrapper.getInstance("Pumpkin", 1), 35);
        linkedHashMap.put(ItemWrapper.getInstance("SpellCompendium", 1), 2);
        return linkedHashMap;
    }
}
