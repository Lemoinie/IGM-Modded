package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Apprentice extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 5;
        this.baseMaxHp = 20;
        this.baseConstitution = 2;
        this.baseIntelligence = 10;
        this.baseDexterity = 4;
        this.baseDefense = 0;
        this.baseMagicDefense = 30;
        this.imageId = R.drawable.unit_apprentice;
        this.idName = R.string.adventurer_apprentice_name;
        this.idDescription = R.string.adventurer_apprentice_description;
        this.passiveSkill = Skills.PASSIVE_NONE;
        this.activeSkill = Skills.ACTIVE_ENERGY_BURST_I;
        this.weaponType = R.string.type_staff;
        this.armorType = R.string.type_armor_light;
        this.potionDrinkerType = PotionDrinkerType.MAGE;
        this.nextClasses.add("LightDisciple");
        this.nextClasses.add("Adept");
    }
}
