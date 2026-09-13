package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class HorseRider extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 15;
        this.baseMaxHp = 65;
        this.baseConstitution = 6;
        this.baseIntelligence = 8;
        this.baseDexterity = 16;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.endOfTurnAction = EndOfTurnAction.RIDER_I;
        this.imageId = R.drawable.unit_horse_rider;
        this.idName = R.string.adventurer_horse_rider_name;
        this.idDescription = R.string.adventurer_horse_rider_description;
        this.passiveSkill = Skills.PASSIVE_RIDER_I;
        this.activeSkill = Skills.ACTIVE_BARRAGE_II;
        this.weaponType = R.string.type_bow;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.ARCHER;
        this.nextClasses.add("WolfRider");
    }
}
