package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class LightDisciple extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 10;
        this.baseMaxHp = 25;
        this.baseConstitution = 3;
        this.baseIntelligence = 15;
        this.baseDexterity = 5;
        this.baseDefense = 0;
        this.baseMagicDefense = 30;
        this.healer = true;
        this.imageId = R.drawable.unit_light_disciple;
        this.idName = R.string.adventurer_light_disciple_name;
        this.idDescription = R.string.adventurer_light_disciple_description;
        this.passiveSkill = Skills.PASSIVE_HEALER_I;
        this.activeSkill = Skills.ACTIVE_ENERGY_BURST_I;
        this.weaponType = R.string.type_staff;
        this.armorType = R.string.type_armor_light;
        this.potionDrinkerType = PotionDrinkerType.MAGE;
        this.nextClasses.add("Cleric");
    }
}
