package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class WhiteElder extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 30;
        this.baseMaxHp = 95;
        this.baseConstitution = 7;
        this.baseIntelligence = 35;
        this.baseDexterity = 9;
        this.baseDefense = 0;
        this.baseMagicDefense = 30;
        this.healer = true;
        this.cleanser = true;
        this.imageId = R.drawable.unit_white_elder;
        this.idName = R.string.adventurer_white_elder_name;
        this.idDescription = R.string.adventurer_white_elder_description;
        this.passiveSkill = Skills.PASSIVE_HEALER_II;
        this.activeSkill = Skills.ACTIVE_MASS_HEAL_II;
        this.weaponType = R.string.type_staff;
        this.armorType = R.string.type_armor_light;
        this.potionDrinkerType = PotionDrinkerType.MAGE;
        this.nextClasses.add("RadiantElder");
    }
}
