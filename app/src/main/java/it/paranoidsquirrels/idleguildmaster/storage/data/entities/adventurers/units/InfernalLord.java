package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class InfernalLord extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 35;
        this.baseMaxHp = 265;
        this.baseConstitution = 28;
        this.baseIntelligence = 28;
        this.baseDexterity = 28;
        this.baseDefense = 28;
        this.baseMagicDefense = 28;
        this.imageId = R.drawable.unit_infernal_lord;
        this.idName = R.string.adventurer_infernal_lord_name;
        this.idDescription = R.string.adventurer_infernal_lord_description;
        this.passiveSkill = Skills.PASSIVE_CHAOTIC;
        this.activeSkill = Skills.ACTIVE_OBLITERATE;
        this.weaponType = R.string.type_staff;
        this.armorType = R.string.type_armor_light;
        this.potionDrinkerType = PotionDrinkerType.MAGE;
        this.nextClasses.add("InfernalPrince");
    }
}
