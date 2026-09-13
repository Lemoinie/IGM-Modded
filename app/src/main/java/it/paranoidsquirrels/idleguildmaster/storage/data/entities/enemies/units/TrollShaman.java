package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class TrollShaman extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 77;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 73;
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
        this.baseMaxHp = 540;
        this.baseConstitution = 10;
        this.baseIntelligence = 2;
        this.baseDexterity = 4;
        this.baseDefense = 40;
        this.baseMagicDefense = 30;
        this.healer = true;
        this.cleanser = true;
        this.regeneration = 20;
        this.imageId = R.drawable.unit_troll_shaman;
        this.idName = R.string.enemy_troll_shaman_name;
        this.idDescription = R.string.enemy_troll_shaman_description;
        this.passiveSkill = Skills.PASSIVE_TROLL_MAGIC;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.rarity = 1;
        this.expGiven = Logger.SUMMON_SMOLDERING_TITAN;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("TrollHide", 1), 200);
        linkedHashMap.put(ItemWrapper.getInstance("Winterwood", 1), 150);
        linkedHashMap.put(ItemWrapper.getInstance("FrostmetalOre", 1), 150);
        linkedHashMap.put(ItemWrapper.getInstance("IceFiber", 1), 150);
        linkedHashMap.put(ItemWrapper.getInstance("Blueberry", 1), 40);
        linkedHashMap.put(ItemWrapper.getInstance("PotionOfHealth", 1), 4);
        return linkedHashMap;
    }
}
