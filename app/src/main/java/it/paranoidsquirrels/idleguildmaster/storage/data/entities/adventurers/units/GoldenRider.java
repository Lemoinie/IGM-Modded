package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class GoldenRider extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 40;
        this.baseMaxHp = 240;
        this.baseConstitution = 11;
        this.baseIntelligence = 18;
        this.baseDexterity = 36;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.endOfTurnAction = EndOfTurnAction.RIDER_VI;
        this.imageId = R.drawable.unit_golden_rider;
        this.idName = R.string.adventurer_golden_rider_name;
        this.idDescription = R.string.adventurer_golden_rider_description;
        this.passiveSkill = Skills.PASSIVE_RIDER_VI;
        this.activeSkill = Skills.ACTIVE_INCINERATE_II;
        this.weaponType = R.string.type_bow;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.ARCHER;
        this.nextClasses.add("WyrmRider");
    }
}
