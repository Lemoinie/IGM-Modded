package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Zombie extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 15;
        this.baseMaxHp = 130;
        this.baseConstitution = 34;
        this.baseIntelligence = 1;
        this.baseDexterity = 11;
        this.baseDefense = 50;
        this.baseMagicDefense = 0;
        this.imageId = R.drawable.unit_zombie;
        this.idName = R.string.summoned_zombie_name;
        this.idDescription = R.string.summoned_zombie_description;
        this.passiveSkill = Skills.PASSIVE_NONE;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.weaponType = R.string.type_sword;
        this.armorType = R.string.type_armor_heavy;
        this.potionDrinkerType = PotionDrinkerType.NONE;
        this.summonedMinion = true;
    }
}
