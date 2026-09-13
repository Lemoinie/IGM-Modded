package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class InfernalPrince extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 40;
        this.baseMaxHp = 320;
        this.baseConstitution = 32;
        this.baseIntelligence = 32;
        this.baseDexterity = 32;
        this.baseDefense = 32;
        this.baseMagicDefense = 32;
        this.imageId = R.drawable.unit_infernal_prince;
        this.idName = R.string.adventurer_infernal_prince_name;
        this.idDescription = R.string.adventurer_infernal_prince_description;
        this.passiveSkill = Skills.PASSIVE_CHAOTIC;
        this.activeSkill = Skills.ACTIVE_EXTIRPATE;
        this.weaponType = R.string.type_staff;
        this.armorType = R.string.type_armor_light;
        this.potionDrinkerType = PotionDrinkerType.MAGE;
        this.nextClasses.add("Balrog");
    }
}
