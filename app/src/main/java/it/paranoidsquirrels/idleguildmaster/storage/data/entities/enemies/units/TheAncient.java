package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class TheAncient extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 4500;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 3500;
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
        this.baseMaxHp = 35000;
        this.baseConstitution = 85;
        this.baseIntelligence = 925;
        this.baseDexterity = 45;
        this.baseDefense = 0;
        this.baseMagicDefense = 0;
        this.initiative = true;
        this.currentMana = 100;
        this.statusImmunities.add(StatusEffectType.STUN);
        this.statusImmunities.add(StatusEffectType.SILENCE);
        this.statusImmunities.add(StatusEffectType.TAUNT);
        this.statusImmunities.add(StatusEffectType.LESSER_CURSE);
        this.statusImmunities.add(StatusEffectType.CURSE);
        this.statusImmunities.add(StatusEffectType.GREATER_CURSE);
        this.statusImmunities.add(StatusEffectType.OMINOUS_CURSE);
        this.statusImmunities.add(StatusEffectType.ABHORRENT_CURSE);
        this.imageId = R.drawable.unit_the_ancient;
        this.idName = R.string.enemy_the_ancient_name;
        this.idDescription = R.string.enemy_the_ancient_description;
        this.passiveSkill = Skills.PASSIVE_INSCRUTABLE;
        this.activeSkill = Skills.ACTIVE_DEVOUR_SPIRIT;
        this.rarity = 1;
        this.expGiven = 17500;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("HeartOfDarkness", 1), 333);
        return linkedHashMap;
    }
}
