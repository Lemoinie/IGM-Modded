package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class WolfRider extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 20;
        this.baseMaxHp = 90;
        this.baseConstitution = 7;
        this.baseIntelligence = 10;
        this.baseDexterity = 20;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.endOfTurnAction = EndOfTurnAction.RIDER_II;
        this.imageId = R.drawable.unit_wolf_rider;
        this.idName = R.string.adventurer_wolf_rider_name;
        this.idDescription = R.string.adventurer_wolf_rider_description;
        this.passiveSkill = Skills.PASSIVE_RIDER_II;
        this.activeSkill = Skills.ACTIVE_BARRAGE_II;
        this.weaponType = R.string.type_bow;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.ARCHER;
        this.nextClasses.add("WorgRider");
    }
}
