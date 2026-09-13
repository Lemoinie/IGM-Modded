package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class DrakeRider extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 35;
        this.baseMaxHp = 195;
        this.baseConstitution = 10;
        this.baseIntelligence = 16;
        this.baseDexterity = 32;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.endOfTurnAction = EndOfTurnAction.RIDER_V;
        this.imageId = R.drawable.unit_drake_rider;
        this.idName = R.string.adventurer_drake_rider_name;
        this.idDescription = R.string.adventurer_drake_rider_description;
        this.passiveSkill = Skills.PASSIVE_RIDER_V;
        this.activeSkill = Skills.ACTIVE_INCINERATE;
        this.weaponType = R.string.type_bow;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.ARCHER;
        this.nextClasses.add("GoldenRider");
    }
}
