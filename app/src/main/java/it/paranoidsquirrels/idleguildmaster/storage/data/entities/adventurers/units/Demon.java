package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Demon extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 30;
        this.baseMaxHp = 215;
        this.baseConstitution = 24;
        this.baseIntelligence = 24;
        this.baseDexterity = 24;
        this.baseDefense = 24;
        this.baseMagicDefense = 24;
        this.imageId = R.drawable.unit_demon;
        this.idName = R.string.adventurer_demon_name;
        this.idDescription = R.string.adventurer_demon_description;
        this.passiveSkill = Skills.PASSIVE_CHAOTIC;
        this.activeSkill = Skills.ACTIVE_ANNIHILATE;
        this.weaponType = R.string.type_staff;
        this.armorType = R.string.type_armor_light;
        this.potionDrinkerType = PotionDrinkerType.MAGE;
        this.nextClasses.add("InfernalLord");
    }
}
