package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class BoneHorror extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 15;
        this.baseMaxHp = 315;
        this.baseConstitution = 72;
        this.baseIntelligence = 1;
        this.baseDexterity = 17;
        this.baseDefense = 50;
        this.baseMagicDefense = 0;
        this.threat = 3;
        this.imageId = R.drawable.unit_bone_horror;
        this.idName = R.string.summoned_bone_horror_name;
        this.idDescription = R.string.summoned_bone_horror_description;
        this.passiveSkill = Skills.PASSIVE_THREATENING_II;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.weaponType = R.string.type_sword;
        this.armorType = R.string.type_armor_heavy;
        this.potionDrinkerType = PotionDrinkerType.NONE;
        this.summonedMinion = true;
    }
}
