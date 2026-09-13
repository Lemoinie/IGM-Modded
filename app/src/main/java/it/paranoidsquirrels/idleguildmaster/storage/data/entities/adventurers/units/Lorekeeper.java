package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Lorekeeper extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 35;
        this.baseMaxHp = 195;
        this.baseConstitution = 19;
        this.baseIntelligence = 20;
        this.baseDexterity = 19;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.saboteur = true;
        this.endOfTurnAction = EndOfTurnAction.SHIELD_INSPIRE_III;
        this.imageId = R.drawable.unit_lorekeeper;
        this.idName = R.string.adventurer_lorekeeper_name;
        this.idDescription = R.string.adventurer_lorekeeper_description;
        this.passiveSkill = Skills.PASSIVE_INSPIRING_III;
        this.activeSkill = Skills.ACTIVE_PETRIFYING_MELODY;
        this.weaponType = R.string.type_dagger;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.THIEF;
        this.nextClasses.add("HeavenlyCantor");
    }
}
