package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class EmperorClovisXXVIII extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 140;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return Logger.BOTCHED_OFFERING;
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
        this.baseMaxHp = 6800;
        this.baseConstitution = 18;
        this.baseIntelligence = 1;
        this.baseDexterity = 48;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.initiative = true;
        this.currentMana = 100;
        this.immunityToStatus = 0.75d;
        this.imageId = R.drawable.unit_emperor_clovis_xxviii;
        this.idName = R.string.enemy_emperor_clovis_xxviii_name;
        this.idDescription = R.string.enemy_emperor_clovis_xxviii_description;
        this.passiveSkill = Skills.PASSIVE_ENHANCED_IMMUNITY;
        this.activeSkill = Skills.ACTIVE_PANDEMONIUM;
        this.rarity = 1;
        this.expGiven = 9600;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("SkeletonKey", 1), 1000);
        return linkedHashMap;
    }
}
