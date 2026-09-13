package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class HeraldKali extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public int calculateManaRegen() {
        return 10;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 305;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 280;
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
        this.baseMaxHp = 4500;
        this.baseConstitution = 500;
        this.baseIntelligence = 500;
        this.baseDexterity = 500;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.alwaysHits = true;
        this.immunityToStatus = 0.5d;
        this.currentMana = 100;
        this.imageId = R.drawable.unit_herald_kali;
        this.idName = R.string.enemy_herald_kali_name;
        this.idDescription = R.string.enemy_herald_kali_description;
        this.passiveSkill = Skills.PASSIVE_CLAIRVOYANCE;
        this.activeSkill = Skills.ACTIVE_SACRIFICE;
        this.rarity = 1;
        this.expGiven = 9600;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("SerpentStaff", 1), 1000);
        return linkedHashMap;
    }
}
