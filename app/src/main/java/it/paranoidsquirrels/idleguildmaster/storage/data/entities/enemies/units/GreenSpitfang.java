package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class GreenSpitfang extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 150;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 105;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean isMagic() {
        return false;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean isRanged() {
        return true;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected void configureStatistics() {
        this.baseMaxHp = 520;
        this.baseConstitution = 15;
        this.baseIntelligence = 3;
        this.baseDexterity = 55;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.initiative = true;
        this.imageId = R.drawable.unit_green_spitfang;
        this.idName = R.string.enemy_green_spitfang_name;
        this.idDescription = R.string.enemy_green_spitfang_description;
        this.passiveSkill = Skills.PASSIVE_INITIATIVE;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.rarity = 1;
        this.expGiven = 92;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("SpitfangScale", 1), 400);
        linkedHashMap.put(ItemWrapper.getInstance("LongSerpentFang", 1), 20);
        linkedHashMap.put(ItemWrapper.getInstance("ReptileEgg", 1), 1);
        return linkedHashMap;
    }
}
