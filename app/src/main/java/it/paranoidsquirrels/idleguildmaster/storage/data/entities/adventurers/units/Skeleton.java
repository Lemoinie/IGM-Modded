package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Skeleton extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 15;
        this.baseMaxHp = 170;
        this.baseConstitution = 50;
        this.baseIntelligence = 1;
        this.baseDexterity = 14;
        this.baseDefense = 50;
        this.baseMagicDefense = 0;
        this.threat = 2;
        this.imageId = R.drawable.unit_skeleton;
        this.idName = R.string.summoned_skeleton_name;
        this.idDescription = R.string.summoned_skeleton_description;
        this.passiveSkill = Skills.PASSIVE_THREATENING_I;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.weaponType = R.string.type_sword;
        this.armorType = R.string.type_armor_heavy;
        this.potionDrinkerType = PotionDrinkerType.NONE;
        this.summonedMinion = true;
    }
}
