package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class SandStatue extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 8;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 5;
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
        this.baseMaxHp = Logger.BARD_SHIELD;
        this.baseConstitution = 12;
        this.baseIntelligence = 2;
        this.baseDexterity = 10;
        this.baseDefense = 0;
        this.baseMagicDefense = 50;
        this.statusImmunities.add(StatusEffectType.ABLAZE);
        this.statusImmunities.add(StatusEffectType.BLEED);
        this.statusImmunities.add(StatusEffectType.POISON);
        this.imageId = R.drawable.unit_sand_statue;
        this.idName = R.string.enemy_sand_statue_name;
        this.idDescription = R.string.enemy_sand_statue_description;
        this.passiveSkill = Skills.PASSIVE_INORGANIC;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.expGiven = 29;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("MetamorphicSand", 1), 300);
        return linkedHashMap;
    }
}
