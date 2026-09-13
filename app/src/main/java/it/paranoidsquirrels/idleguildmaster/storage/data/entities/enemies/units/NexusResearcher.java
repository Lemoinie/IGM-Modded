package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.AbstractMap;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class NexusResearcher extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 240;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 225;
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
        this.baseMaxHp = 735;
        this.baseConstitution = 22;
        this.baseIntelligence = 154;
        this.baseDexterity = 15;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.healer = true;
        this.increaseHealingAgainst = new AbstractMap.SimpleEntry("MagicArmor", Double.valueOf(2.0d));
        this.imageId = R.drawable.unit_nexus_researcher;
        this.idName = R.string.enemy_nexus_researcher_name;
        this.idDescription = R.string.enemy_nexus_researcher_description;
        this.passiveSkill = Skills.PASSIVE_REVERSE_ENTROPY;
        this.activeSkill = Skills.ACTIVE_OVERDRIVE;
        this.rarity = 1;
        this.expGiven = 140;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("Pumpkin", 1), 25);
        linkedHashMap.put(ItemWrapper.getInstance("VeilBreaker", 1), 3);
        linkedHashMap.put(ItemWrapper.getInstance("UnstableGem", 1), 3);
        return linkedHashMap;
    }
}
