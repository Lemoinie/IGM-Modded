package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class DarkSorcerer extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 15;
        this.baseMaxHp = 35;
        this.baseConstitution = 4;
        this.baseIntelligence = 20;
        this.baseDexterity = 6;
        this.baseDefense = 0;
        this.baseMagicDefense = 30;
        this.baseLifesteal = 50;
        this.imageId = R.drawable.unit_dark_sorcerer;
        this.idName = R.string.adventurer_dark_sorcerer_name;
        this.idDescription = R.string.adventurer_dark_sorcerer_description;
        this.passiveSkill = Skills.PASSIVE_WITHERING_TOUCH;
        this.activeSkill = Skills.ACTIVE_ENERGY_BURST_II;
        this.weaponType = R.string.type_staff;
        this.armorType = R.string.type_armor_light;
        this.potionDrinkerType = PotionDrinkerType.MAGE;
        this.nextClasses.add("Necromancer");
    }
}
