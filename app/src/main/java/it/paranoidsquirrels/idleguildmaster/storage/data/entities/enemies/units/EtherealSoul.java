package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class EtherealSoul extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 138;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return Logger.LOST_EXPEDITION_FALL_DAMAGE;
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
        this.baseMaxHp = 3180;
        this.baseConstitution = 20;
        this.baseIntelligence = 1;
        this.baseDexterity = 23;
        this.baseDefense = 50;
        this.baseMagicDefense = 0;
        this.imageId = R.drawable.unit_ethereal_soul;
        this.idName = R.string.enemy_ethereal_soul_name;
        this.idDescription = R.string.enemy_ethereal_soul_description;
        this.passiveSkill = Skills.PASSIVE_NONE;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.rarity = 1;
        this.expGiven = 300;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        return new LinkedHashMap<>();
    }
}
