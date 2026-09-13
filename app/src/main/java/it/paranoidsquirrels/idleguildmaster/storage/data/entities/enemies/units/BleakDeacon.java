package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class BleakDeacon extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 350;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 200;
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
        this.baseMaxHp = 1700;
        this.baseConstitution = 24;
        this.baseIntelligence = 215;
        this.baseDexterity = 76;
        this.baseDefense = 0;
        this.baseMagicDefense = 30;
        this.currentMana = 100;
        this.healer = true;
        this.onTargetHit = new StatusEffect(StatusEffectType.ANOINTED, this, 5, 1.0d);
        this.imageId = R.drawable.unit_bleak_deacon;
        this.idName = R.string.enemy_bleak_deacon_name;
        this.idDescription = R.string.enemy_bleak_deacon_description;
        this.passiveSkill = Skills.PASSIVE_TERATOGEN;
        this.activeSkill = Skills.ACTIVE_MASS_HEAL_I;
        this.rarity = 1;
        this.expGiven = 1000;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("EldritchShred", 1), 350);
        linkedHashMap.put(ItemWrapper.getInstance("EsotericEgg", 1), 1);
        return linkedHashMap;
    }
}
