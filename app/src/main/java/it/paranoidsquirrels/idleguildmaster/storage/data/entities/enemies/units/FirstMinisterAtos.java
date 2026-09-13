package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class FirstMinisterAtos extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 1900;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 1200;
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
        this.baseMaxHp = 18500;
        this.baseConstitution = 75;
        this.baseIntelligence = 5;
        this.baseDexterity = 190;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.currentMana = 80;
        this.onTargetHit = new StatusEffect(StatusEffectType.ABLAZE, this, 3, 1.0d);
        this.onSelfHit = new StatusEffect(StatusEffectType.ABLAZE, this, 3, 1.0d);
        this.statusImmunities.add(StatusEffectType.ABLAZE);
        this.imageId = R.drawable.unit_first_minister_atos;
        this.idName = R.string.enemy_first_minister_atos_name;
        this.idDescription = R.string.enemy_first_minister_atos_description;
        this.passiveSkill = Skills.PASSIVE_ABLAZE;
        this.activeSkill = Skills.ACTIVE_AT_THE_STAKE;
        this.rarity = 1;
        this.expGiven = 4000;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("KaunianFabric", 1), 650);
        linkedHashMap.put(ItemWrapper.getInstance("FireproofOil", 1), 350);
        return linkedHashMap;
    }
}
