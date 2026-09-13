package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class BleakDisciple extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 380;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 160;
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
        this.baseMaxHp = 1490;
        this.baseConstitution = 9;
        this.baseIntelligence = 158;
        this.baseDexterity = 62;
        this.baseDefense = 0;
        this.baseMagicDefense = 30;
        this.initiative = true;
        this.currentMana = 100;
        this.darknessDamageAmplification = 0.01d;
        this.imageId = R.drawable.unit_bleak_disciple;
        this.idName = R.string.enemy_bleak_disciple_name;
        this.idDescription = R.string.enemy_bleak_disciple_description;
        this.passiveSkill = Skills.PASSIVE_NIGHT_HUNTER;
        this.activeSkill = Skills.ACTIVE_INSTILL_TERROR;
        this.rarity = 1;
        this.expGiven = 360;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("AbherrantFabric", 1), 440);
        linkedHashMap.put(ItemWrapper.getInstance("EsotericEgg", 1), 1);
        return linkedHashMap;
    }
}
