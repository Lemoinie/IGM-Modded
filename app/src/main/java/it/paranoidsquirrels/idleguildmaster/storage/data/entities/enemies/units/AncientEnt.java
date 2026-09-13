package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class AncientEnt extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 195;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 140;
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
        this.baseMaxHp = 3200;
        this.baseConstitution = 130;
        this.baseIntelligence = 48;
        this.baseDexterity = 27;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.imageId = R.drawable.unit_ancient_ent;
        this.idName = R.string.enemy_ancient_ent_name;
        this.idDescription = R.string.enemy_ancient_ent_description;
        this.passiveSkill = Skills.PASSIVE_NONE;
        this.activeSkill = Skills.ACTIVE_FLEECE;
        this.rarity = 1;
        this.expGiven = 240;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("ElysianWood", 3), 460);
        linkedHashMap.put(ItemWrapper.getInstance("LivingVine", 1), 80);
        linkedHashMap.put(ItemWrapper.getInstance("Avocado", 1), 100);
        linkedHashMap.put(ItemWrapper.getInstance("WoodenEgg", 1), 1);
        return linkedHashMap;
    }
}
