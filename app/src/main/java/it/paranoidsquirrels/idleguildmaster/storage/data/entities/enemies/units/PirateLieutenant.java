package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class PirateLieutenant extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 43;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 30;
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
        this.baseMaxHp = 600;
        this.baseConstitution = 30;
        this.baseIntelligence = 8;
        this.baseDexterity = 25;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.counterattack = 0.5d;
        this.imageId = R.drawable.unit_pirate_lieutenant;
        this.idName = R.string.enemy_pirate_lieutenant_name;
        this.idDescription = R.string.enemy_pirate_lieutenant_description;
        this.passiveSkill = Skills.PASSIVE_RETALIATE;
        this.activeSkill = Skills.ACTIVE_FLINTLOCK_SHOT;
        this.rarity = 1;
        this.expGiven = 132;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("GhostwoodStump", 1), 375);
        linkedHashMap.put(ItemWrapper.getInstance("BlackIronScraps", 1), 379);
        linkedHashMap.put(ItemWrapper.getInstance("ExoticVelvet", 1), 200);
        linkedHashMap.put(ItemWrapper.getInstance("FreshTuna", 1), 20);
        linkedHashMap.put(ItemWrapper.getInstance("PotionOfDexterity", 1), 1);
        return linkedHashMap;
    }
}
