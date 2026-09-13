package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class Pterodactyl extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 495;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 415;
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
        this.baseMaxHp = 775;
        this.baseConstitution = 15;
        this.baseIntelligence = 1;
        this.baseDexterity = 126;
        this.baseDefense = 10;
        this.baseMagicDefense = 0;
        this.flying = true;
        this.imageId = R.drawable.unit_pterodactyl;
        this.idName = R.string.enemy_pterodactyl_name;
        this.idDescription = R.string.enemy_pterodactyl_description;
        this.passiveSkill = Skills.PASSIVE_PREHISTORIC_AVIAN;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.rarity = 1;
        this.expGiven = 175;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("AncientMembrane", 1), 325);
        linkedHashMap.put(ItemWrapper.getInstance("PterodactylClaw", 1), 1);
        linkedHashMap.put(ItemWrapper.getInstance("DinoRibs", 1), 67);
        linkedHashMap.put(ItemWrapper.getInstance("AvianEgg", 1), 1);
        return linkedHashMap;
    }
}
