package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class WyrmRider extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 45;
        this.baseMaxHp = 290;
        this.baseConstitution = 12;
        this.baseIntelligence = 20;
        this.baseDexterity = 40;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.endOfTurnAction = EndOfTurnAction.RIDER_VII;
        this.imageId = R.drawable.unit_wyrm_rider;
        this.idName = R.string.adventurer_wyrm_rider_name;
        this.idDescription = R.string.adventurer_wyrm_rider_description;
        this.passiveSkill = Skills.PASSIVE_RIDER_VII;
        this.activeSkill = Skills.ACTIVE_SUBLIMATE;
        this.weaponType = R.string.type_bow;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.ARCHER;
    }
}
