package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Templar extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 30;
        this.baseMaxHp = 215;
        this.baseConstitution = 28;
        this.baseIntelligence = 14;
        this.baseDexterity = 9;
        this.baseDefense = 20;
        this.baseMagicDefense = 30;
        this.threat = 2;
        this.darknessReduction = 30;
        this.imageId = R.drawable.unit_templar;
        this.idName = R.string.adventurer_templar_name;
        this.idDescription = R.string.adventurer_templar_description;
        this.passiveSkill = Skills.PASSIVE_BLINDING_III;
        this.activeSkill = Skills.ACTIVE_CONDEMN_ALL_I;
        this.weaponType = R.string.type_sword;
        this.armorType = R.string.type_armor_heavy;
        this.potionDrinkerType = PotionDrinkerType.WARRIOR;
        this.nextClasses.add("Inquisitor");
    }
}
