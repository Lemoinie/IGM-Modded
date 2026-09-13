package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ImperialMage extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 29;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 26;
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
        this.baseMaxHp = 300;
        this.baseConstitution = 15;
        this.baseIntelligence = 40;
        this.baseDexterity = 20;
        this.baseDefense = 0;
        this.baseMagicDefense = 30;
        this.imageId = R.drawable.unit_imperial_mage;
        this.idName = R.string.enemy_imperial_mage_name;
        this.idDescription = R.string.enemy_imperial_mage_description;
        this.passiveSkill = Skills.PASSIVE_NONE;
        this.activeSkill = Skills.ACTIVE_STATIC_SURGE;
        this.rarity = 1;
        this.expGiven = 92;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("GoldScraps", 1), 400);
        linkedHashMap.put(ItemWrapper.getInstance("CorruptedStaff", 1), 1);
        linkedHashMap.put(ItemWrapper.getInstance("PotionOfIntelligence", 1), 4);
        if (i == 1) {
            linkedHashMap.put(ItemWrapper.getInstance("BlackOoze", 1), 200);
        }
        return linkedHashMap;
    }
}
