package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class UndeadWarlord extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 16;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 12;
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
        this.baseMaxHp = 220;
        this.baseConstitution = 24;
        this.baseIntelligence = 1;
        this.baseDexterity = 12;
        this.baseDefense = 50;
        this.baseMagicDefense = 0;
        this.imageId = R.drawable.unit_undead_warlord;
        this.idName = R.string.enemy_undead_warlord_name;
        this.idDescription = R.string.enemy_undead_warlord_description;
        this.retaliationPhysicalDamage = 12;
        this.passiveSkill = Skills.PASSIVE_SPIKES;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.rarity = 1;
        this.expGiven = 84;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("WarlordSkull", 2), 10);
        linkedHashMap.put(ItemWrapper.getInstance("BoneFragment", 1), 960);
        return linkedHashMap;
    }
}
