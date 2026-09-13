package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ShaTheHiddenGod extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 7;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 7;
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
        this.baseMaxHp = 7777;
        this.baseConstitution = 7;
        this.baseIntelligence = 7;
        this.baseDexterity = 7;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.alwaysHits = true;
        this.immunityToStatus = 1.0d;
        this.imageId = R.drawable.unit_sha_the_hidden_god;
        this.idName = R.string.enemy_sha_the_hidden_god_name;
        this.idDescription = R.string.enemy_sha_the_hidden_god_description;
        this.passiveSkill = Skills.PASSIVE_PERFECT_IMMUNITY;
        this.activeSkill = Skills.ACTIVE_DISEMBODY;
        this.expGiven = 9600;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("DivineZygote", 1), 1000);
        return linkedHashMap;
    }
}
