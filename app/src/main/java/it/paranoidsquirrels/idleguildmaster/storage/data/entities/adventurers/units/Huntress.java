package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Huntress extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 10;
        this.baseMaxHp = 45;
        this.baseConstitution = 5;
        this.baseIntelligence = 6;
        this.baseDexterity = 12;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.imageId = R.drawable.unit_huntress;
        this.idName = R.string.adventurer_huntress_name;
        this.idDescription = R.string.adventurer_huntress_description;
        this.passiveSkill = Skills.PASSIVE_NONE;
        this.activeSkill = Skills.ACTIVE_BARRAGE_II;
        this.weaponType = R.string.type_bow;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.ARCHER;
        this.nextClasses.add("HorseRider");
        this.nextClasses.add("Marksman");
    }
}
