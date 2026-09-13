package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class Centaur extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 15;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 8;
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
        this.baseMaxHp = 80;
        this.baseConstitution = 12;
        this.baseIntelligence = 10;
        this.baseDexterity = 22;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.initiative = true;
        this.imageId = R.drawable.unit_centaur;
        this.idName = R.string.enemy_centaur_name;
        this.idDescription = R.string.enemy_centaur_description;
        this.passiveSkill = Skills.PASSIVE_INITIATIVE;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.rarity = 1;
        this.expGiven = 24;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("PlantFiber", 1), 450);
        linkedHashMap.put(ItemWrapper.getInstance("CopperOre", 1), 450);
        linkedHashMap.put(ItemWrapper.getInstance("Cheese", 1), 25);
        return linkedHashMap;
    }
}
