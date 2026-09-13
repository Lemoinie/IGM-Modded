package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class Ultraslime extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 1860;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 920;
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
        this.baseMaxHp = 99999;
        this.baseConstitution = 1000;
        this.baseIntelligence = 100;
        this.baseDexterity = 125;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.immunityToStatus = 1.0d;
        this.imageId = R.drawable.unit_ultraslime;
        this.idName = R.string.enemy_ultraslime_name;
        this.idDescription = R.string.enemy_ultraslime_description;
        this.passiveSkill = Skills.PASSIVE_PERFECT_IMMUNITY;
        this.activeSkill = Skills.ACTIVE_BOUNCE;
        this.rarity = 1;
        this.expGiven = 99999;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("WhiteSlime", 1), 500);
        return linkedHashMap;
    }
}
