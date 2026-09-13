package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class KabarTheRotten extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 150;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 130;
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
        this.baseMaxHp = 900;
        this.baseConstitution = 14;
        this.baseIntelligence = 34;
        this.baseDexterity = 8;
        this.baseDefense = 50;
        this.baseMagicDefense = 0;
        this.baseLifesteal = 25;
        this.imageId = R.drawable.unit_kabar_the_rotten;
        this.idName = R.string.enemy_kabar_the_rotten_name;
        this.idDescription = R.string.enemy_kabar_the_rotten_description;
        this.passiveSkill = Skills.PASSIVE_LICH_CURSE;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.rarity = 1;
        this.expGiven = 360;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("PhylacteryFragment", 1), 666);
        linkedHashMap.put(ItemWrapper.getInstance("CursedSilver", 3), 309);
        linkedHashMap.put(ItemWrapper.getInstance("RobeOfTheLich", 1), 25);
        return linkedHashMap;
    }
}
