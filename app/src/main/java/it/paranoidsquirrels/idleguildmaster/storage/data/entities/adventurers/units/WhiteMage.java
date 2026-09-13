package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class WhiteMage extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 20;
        this.baseMaxHp = 50;
        this.baseConstitution = 5;
        this.baseIntelligence = 25;
        this.baseDexterity = 7;
        this.baseDefense = 0;
        this.baseMagicDefense = 30;
        this.healer = true;
        this.imageId = R.drawable.unit_white_mage;
        this.idName = R.string.adventurer_white_mage_name;
        this.idDescription = R.string.adventurer_white_mage_description;
        this.passiveSkill = Skills.PASSIVE_HEALER_I;
        this.activeSkill = Skills.ACTIVE_MASS_HEAL_I;
        this.weaponType = R.string.type_staff;
        this.armorType = R.string.type_armor_light;
        this.potionDrinkerType = PotionDrinkerType.MAGE;
        this.nextClasses.add("WhiteArchmage");
    }
}
