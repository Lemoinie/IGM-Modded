package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class TrollWarrior extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 78;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 67;
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
        this.baseMaxHp = 820;
        this.baseConstitution = 30;
        this.baseIntelligence = 2;
        this.baseDexterity = 10;
        this.baseDefense = 70;
        this.baseMagicDefense = 0;
        this.regeneration = 30;
        this.imageId = R.drawable.unit_troll_warrior;
        this.idName = R.string.enemy_troll_warrior_name;
        this.idDescription = R.string.enemy_troll_warrior_description;
        this.passiveSkill = Skills.PASSIVE_REGENERATION_II;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.rarity = 1;
        this.expGiven = Logger.SUMMON_SMOLDERING_TITAN;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("TrollHide", 1), 200);
        linkedHashMap.put(ItemWrapper.getInstance("FrostmetalOre", 1), 200);
        linkedHashMap.put(ItemWrapper.getInstance("Blueberry", 1), 30);
        return linkedHashMap;
    }
}
