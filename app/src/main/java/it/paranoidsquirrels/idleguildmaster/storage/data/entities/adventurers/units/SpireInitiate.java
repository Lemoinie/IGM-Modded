package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class SpireInitiate extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 25;
        this.baseMaxHp = Logger.BARD_SHIELD;
        this.baseConstitution = 18;
        this.baseIntelligence = 8;
        this.baseDexterity = 18;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.saboteur = true;
        this.flatDodgeChance = 0.1d;
        this.imageId = R.drawable.unit_spire_initiate;
        this.idName = R.string.adventurer_spire_initiate_name;
        this.idDescription = R.string.adventurer_spire_initiate_description;
        this.passiveSkill = Skills.PASSIVE_INFILTRATOR;
        this.activeSkill = Skills.ACTIVE_ECLIPSE_I;
        this.weaponType = R.string.type_dagger;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.THIEF;
        this.nextClasses.add("SpireAcolyte");
    }
}
