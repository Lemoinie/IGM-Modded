package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ShaKireFirstSwordsman extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 104;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 75;
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
        this.baseMaxHp = 3500;
        this.baseConstitution = 24;
        this.baseIntelligence = 36;
        this.baseDexterity = 42;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.counterattack = 1.0d;
        this.imageId = R.drawable.unit_sha_kire_first_swordsman;
        this.idName = R.string.enemy_sha_kire_first_swordsman_name;
        this.idDescription = R.string.enemy_sha_kire_first_swordsman_description;
        this.passiveSkill = Skills.PASSIVE_RETALIATE_II;
        this.activeSkill = Skills.ACTIVE_DESERT_JUDGEMENT;
        this.expGiven = 600;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("EyesOfTheSwordsman", 1), 1000);
        return linkedHashMap;
    }
}
