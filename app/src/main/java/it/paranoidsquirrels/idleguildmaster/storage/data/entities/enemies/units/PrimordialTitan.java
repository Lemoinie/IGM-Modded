package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class PrimordialTitan extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 330;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 280;
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
        this.baseMaxHp = 15000;
        this.baseConstitution = 200;
        this.baseIntelligence = 1;
        this.baseDexterity = 80;
        this.baseDefense = 10;
        this.baseMagicDefense = 0;
        this.statusImmunities.add(StatusEffectType.ABLAZE);
        this.statusImmunities.add(StatusEffectType.BLEED);
        this.statusImmunities.add(StatusEffectType.POISON);
        this.imageId = R.drawable.unit_primordial_titan;
        this.idName = R.string.enemy_primordial_titan_name;
        this.idDescription = R.string.enemy_primordial_titan_description;
        this.passiveSkill = Skills.PASSIVE_INORGANIC;
        this.activeSkill = Skills.ACTIVE_FRAGMENTATION;
        this.rarity = 1;
        this.expGiven = 1200;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("ExaltedPowder", 1), 300);
        linkedHashMap.put(ItemWrapper.getInstance("ColossalSword", 1), 100);
        linkedHashMap.put(ItemWrapper.getInstance("PotionOfDefense", 1), 160);
        linkedHashMap.put(ItemWrapper.getInstance("ConstructEgg", 1), 1);
        return linkedHashMap;
    }
}
