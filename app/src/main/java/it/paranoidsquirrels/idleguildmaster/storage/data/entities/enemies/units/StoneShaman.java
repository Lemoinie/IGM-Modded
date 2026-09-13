package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class StoneShaman extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 350;
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
        this.baseMaxHp = 1200;
        this.baseConstitution = 40;
        this.baseIntelligence = Logger.BOTCHED_OFFERING;
        this.baseDexterity = 2;
        this.baseDefense = 0;
        this.baseMagicDefense = 90;
        this.healer = true;
        this.cleanser = true;
        this.imageId = R.drawable.unit_stone_shaman;
        this.idName = R.string.enemy_stone_shaman_name;
        this.idDescription = R.string.enemy_stone_shaman_description;
        this.passiveSkill = Skills.PASSIVE_NATURAL_EMPATHY;
        this.activeSkill = Skills.ACTIVE_FIRE_DANCE;
        this.rarity = 1;
        this.expGiven = 270;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("Kindlequartz", 1), 4);
        return linkedHashMap;
    }
}
