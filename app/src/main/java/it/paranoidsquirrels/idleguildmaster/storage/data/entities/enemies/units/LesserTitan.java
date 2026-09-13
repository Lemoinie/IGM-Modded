package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class LesserTitan extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 300;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 220;
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
        this.baseMaxHp = 4150;
        this.baseConstitution = 40;
        this.baseIntelligence = 1;
        this.baseDexterity = 16;
        this.baseDefense = 10;
        this.baseMagicDefense = 0;
        this.statusImmunities.add(StatusEffectType.ABLAZE);
        this.statusImmunities.add(StatusEffectType.BLEED);
        this.statusImmunities.add(StatusEffectType.POISON);
        this.imageId = R.drawable.unit_lesser_titan;
        this.idName = R.string.enemy_lesser_titan_name;
        this.idDescription = R.string.enemy_lesser_titan_description;
        this.passiveSkill = Skills.PASSIVE_INORGANIC;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.rarity = 1;
        this.expGiven = 300;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("AlchemicPowder", 1), 300);
        linkedHashMap.put(ItemWrapper.getInstance("SentientSlab", 1), 150);
        linkedHashMap.put(ItemWrapper.getInstance("ConstructEgg", 1), 1);
        return linkedHashMap;
    }
}
