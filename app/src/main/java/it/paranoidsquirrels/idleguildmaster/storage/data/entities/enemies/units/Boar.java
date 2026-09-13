package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class Boar extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 3;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 1;
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
        this.baseMaxHp = 100;
        this.baseConstitution = 10;
        this.baseIntelligence = 2;
        this.baseDexterity = 2;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.imageId = R.drawable.unit_boar;
        this.idName = R.string.enemy_boar_name;
        this.idDescription = R.string.enemy_boar_description;
        this.passiveSkill = Skills.PASSIVE_NONE;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.rarity = 1;
        this.expGiven = 12;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("BoarTusk", 1), 300);
        linkedHashMap.put(ItemWrapper.getInstance("BeastPelt", 1), 450);
        linkedHashMap.put(ItemWrapper.getInstance("MeatChop", 1), 12);
        linkedHashMap.put(ItemWrapper.getInstance("WildEgg", 1), 1);
        return linkedHashMap;
    }
}
