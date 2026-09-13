package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Inquisitor extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 35;
        this.baseMaxHp = 265;
        this.baseConstitution = 32;
        this.baseIntelligence = 16;
        this.baseDexterity = 10;
        this.baseDefense = 20;
        this.baseMagicDefense = 33;
        this.threat = 2;
        this.darknessReduction = 40;
        this.imageId = R.drawable.unit_inquisitor;
        this.idName = R.string.adventurer_inquisitor_name;
        this.idDescription = R.string.adventurer_inquisitor_description;
        this.passiveSkill = Skills.PASSIVE_BLINDING_IV;
        this.activeSkill = Skills.ACTIVE_CONDEMN_ALL_II;
        this.weaponType = R.string.type_sword;
        this.armorType = R.string.type_armor_heavy;
        this.potionDrinkerType = PotionDrinkerType.WARRIOR;
        this.nextClasses.add("Justiciar");
    }
}
