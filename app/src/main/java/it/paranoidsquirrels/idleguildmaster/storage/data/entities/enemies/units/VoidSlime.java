package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class VoidSlime extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 33;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 33;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean isMagic() {
        return true;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean isRanged() {
        return false;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected void configureStatistics() {
        this.baseMaxHp = 100;
        this.baseConstitution = 40;
        this.baseIntelligence = 2;
        this.baseDexterity = 6;
        this.baseDefense = 40;
        this.baseMagicDefense = 0;
        this.retaliationMagicalDamage = 33;
        this.imageId = R.drawable.unit_void_slime;
        this.idName = R.string.enemy_void_slime_name;
        this.idDescription = R.string.enemy_void_slime_description;
        this.passiveSkill = Skills.PASSIVE_VOID_PULL;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.expGiven = 60;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("GreenSlime", 1), 650);
        linkedHashMap.put(ItemWrapper.getInstance("GreenSlime", 3), 100);
        linkedHashMap.put(ItemWrapper.getInstance("VoidCore", 1), 160);
        return linkedHashMap;
    }
}
