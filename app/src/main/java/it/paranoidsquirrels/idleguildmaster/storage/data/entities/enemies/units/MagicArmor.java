package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class MagicArmor extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 135;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return Logger.BARD_SHIELD;
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
        this.baseMaxHp = 400;
        this.baseConstitution = 68;
        this.baseIntelligence = 1;
        this.baseDexterity = 54;
        this.baseDefense = 75;
        this.baseMagicDefense = 75;
        this.retaliationMagicalDamage = 105;
        this.threat = 2;
        this.imageId = R.drawable.unit_magic_armor;
        this.idName = R.string.enemy_magic_armor_name;
        this.idDescription = R.string.enemy_magic_armor_description;
        this.passiveSkill = Skills.PASSIVE_ANIMATED_GUARDIAN;
        this.activeSkill = Skills.ACTIVE_DISASSEMBLE;
        this.rarity = 1;
        this.expGiven = Logger.ARCANE_SUPPRESSION;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("AnimatedScraps", 1), 375);
        linkedHashMap.put(ItemWrapper.getInstance("RadiatingNucleus", 1), 2);
        linkedHashMap.put(ItemWrapper.getInstance("ConstructEgg", 1), 1);
        return linkedHashMap;
    }
}
