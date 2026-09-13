package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class Phantasm extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 1000;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 999;
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
        this.baseConstitution = 22;
        this.baseIntelligence = 165;
        this.baseDexterity = 500;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.currentMana = 100;
        this.flatDodgeChance = 0.5d;
        this.imageId = R.drawable.unit_phantasm;
        this.idName = R.string.enemy_phantasm_name;
        this.idDescription = R.string.enemy_phantasm_description;
        this.passiveSkill = Skills.PASSIVE_ELUSIVE;
        this.activeSkill = Skills.ACTIVE_LIGHTS_OUT;
        this.rarity = 1;
        this.expGiven = 450;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("KaunianFabric", 1), 500);
        return linkedHashMap;
    }
}
