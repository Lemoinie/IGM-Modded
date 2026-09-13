package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class LostMiner extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 162;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 88;
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
        this.baseMaxHp = 790;
        this.baseConstitution = 8;
        this.baseIntelligence = 20;
        this.baseDexterity = 40;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.initiative = true;
        this.darknessDamageAmplification = 0.01d;
        this.imageId = R.drawable.unit_lost_miner;
        this.idName = R.string.enemy_lost_miner_name;
        this.idDescription = R.string.enemy_lost_miner_description;
        this.passiveSkill = Skills.PASSIVE_NIGHT_HUNTER;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.rarity = 1;
        this.expGiven = 300;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("ObsidianChunk", 1), 300);
        linkedHashMap.put(ItemWrapper.getInstance("ShadowGem", 1), 200);
        linkedHashMap.put(ItemWrapper.getInstance("PotionOfDarkness", 1), 4);
        return linkedHashMap;
    }
}
