package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Paladin extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 25;
        this.baseMaxHp = 170;
        this.baseConstitution = 24;
        this.baseIntelligence = 12;
        this.baseDexterity = 8;
        this.baseDefense = 20;
        this.baseMagicDefense = 26;
        this.threat = 2;
        this.darknessReduction = 20;
        this.imageId = R.drawable.unit_paladin;
        this.idName = R.string.adventurer_paladin_name;
        this.idDescription = R.string.adventurer_paladin_description;
        this.passiveSkill = Skills.PASSIVE_BLINDING_II;
        this.activeSkill = Skills.ACTIVE_CONDEMN;
        this.weaponType = R.string.type_sword;
        this.armorType = R.string.type_armor_heavy;
        this.potionDrinkerType = PotionDrinkerType.WARRIOR;
        this.nextClasses.add("Templar");
    }
}
