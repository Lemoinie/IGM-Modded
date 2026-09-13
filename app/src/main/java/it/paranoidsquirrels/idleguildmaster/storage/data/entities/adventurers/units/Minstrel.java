package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class Minstrel extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 25;
        this.baseMaxHp = Logger.BARD_SHIELD;
        this.baseConstitution = 15;
        this.baseIntelligence = 14;
        this.baseDexterity = 15;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.saboteur = true;
        this.endOfTurnAction = EndOfTurnAction.SHIELD_INSPIRE_II;
        this.imageId = R.drawable.unit_minstrel;
        this.idName = R.string.adventurer_minstrel_name;
        this.idDescription = R.string.adventurer_minstrel_description;
        this.passiveSkill = Skills.PASSIVE_INSPIRING_II;
        this.activeSkill = Skills.ACTIVE_FEINT;
        this.weaponType = R.string.type_dagger;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.THIEF;
        this.nextClasses.add("Bard");
    }
}
