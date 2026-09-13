package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class GiantMoth extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 95;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 70;
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
        this.baseMaxHp = 480;
        this.baseConstitution = 7;
        this.baseIntelligence = 2;
        this.baseDexterity = 42;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.currentMana = 100;
        this.flying = true;
        this.imageId = R.drawable.unit_giant_moth;
        this.idName = R.string.enemy_giant_moth_name;
        this.idDescription = R.string.enemy_giant_moth_description;
        this.passiveSkill = Skills.PASSIVE_FLYING;
        this.activeSkill = Skills.ACTIVE_CHOKING_POWDER;
        this.rarity = 1;
        this.expGiven = 70;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("GiantMothWing", 1), 550);
        linkedHashMap.put(ItemWrapper.getInstance("InsectEgg", 1), 1);
        return linkedHashMap;
    }
}
