package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ChiefScientistAva extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 2500;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 750;
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
        this.baseMaxHp = 15000;
        this.baseConstitution = 18;
        this.baseIntelligence = 375;
        this.baseDexterity = 12;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.poisonBonus = 30;
        this.immunityToStatus = 0.8d;
        this.healer = true;
        this.cleanser = true;
        this.imageId = R.drawable.unit_chief_scientist_ava;
        this.idName = R.string.enemy_chief_scientist_ava_name;
        this.idDescription = R.string.enemy_chief_scientist_ava_description;
        this.passiveSkill = Skills.PASSIVE_UNETHICAL_CONDUCT;
        this.activeSkill = Skills.ACTIVE_LIVE_TEST;
        this.rarity = 1;
        this.expGiven = 4000;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("KaunianFabric", 1), 830);
        linkedHashMap.put(ItemWrapper.getInstance("PotionOfClumsiness", 1), Integer.valueOf(Logger.BARD_SHIELD));
        linkedHashMap.put(ItemWrapper.getInstance("ChiefScientistCoat", 1), 50);
        return linkedHashMap;
    }
}
