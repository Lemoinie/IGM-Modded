package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ImperialGuard extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 34;
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
        this.baseConstitution = 35;
        this.baseIntelligence = 10;
        this.baseDexterity = 25;
        this.baseDefense = 30;
        this.baseMagicDefense = 0;
        this.imageId = R.drawable.unit_imperial_guard;
        this.idName = R.string.enemy_imperial_guard_name;
        this.idDescription = R.string.enemy_imperial_guard_description;
        this.currentMana = 100;
        this.passiveSkill = Skills.PASSIVE_NONE;
        this.activeSkill = Skills.ACTIVE_PROTECT_THE_WEAK;
        this.rarity = 1;
        this.expGiven = 92;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("GoldScraps", 1), 400);
        linkedHashMap.put(ItemWrapper.getInstance("CorruptedShield", 1), 1);
        if (i == 1) {
            linkedHashMap.put(ItemWrapper.getInstance("BlackOoze", 1), 200);
        }
        return linkedHashMap;
    }
}
