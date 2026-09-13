package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Demilich extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 25;
        this.baseMaxHp = 70;
        this.baseConstitution = 6;
        this.baseIntelligence = 30;
        this.baseDexterity = 8;
        this.baseDefense = 0;
        this.baseMagicDefense = 30;
        this.baseLifesteal = 50;
        this.imageId = R.drawable.unit_demilich;
        this.idName = R.string.adventurer_demilich_name;
        this.idDescription = R.string.adventurer_demilich_description;
        this.passiveSkill = Skills.PASSIVE_WITHERING_TOUCH;
        this.activeSkill = Skills.ACTIVE_CURSE_II;
        this.weaponType = R.string.type_staff;
        this.armorType = R.string.type_armor_light;
        this.potionDrinkerType = PotionDrinkerType.MAGE;
        this.nextClasses.add("Lich");
    }
}
