package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Unchained extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 25;
        this.baseMaxHp = 170;
        this.baseConstitution = 20;
        this.baseIntelligence = 20;
        this.baseDexterity = 20;
        this.baseDefense = 20;
        this.baseMagicDefense = 20;
        this.imageId = R.drawable.unit_unchained;
        this.idName = R.string.adventurer_unchained_name;
        this.idDescription = R.string.adventurer_unchained_description;
        this.passiveSkill = Skills.PASSIVE_CHAOTIC;
        this.activeSkill = Skills.ACTIVE_FLAY;
        this.weaponType = R.string.type_staff;
        this.armorType = R.string.type_armor_light;
        this.potionDrinkerType = PotionDrinkerType.MAGE;
        this.nextClasses.add("Demon");
    }
}
