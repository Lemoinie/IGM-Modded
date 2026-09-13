package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Justiciar extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 40;
        this.baseMaxHp = 320;
        this.baseConstitution = 36;
        this.baseIntelligence = 18;
        this.baseDexterity = 11;
        this.baseDefense = 20;
        this.baseMagicDefense = 36;
        this.threat = 2;
        this.darknessReduction = 50;
        this.imageId = R.drawable.unit_justiciar;
        this.idName = R.string.adventurer_justiciar_name;
        this.idDescription = R.string.adventurer_justiciar_description;
        this.passiveSkill = Skills.PASSIVE_BLINDING_V;
        this.activeSkill = Skills.ACTIVE_CONDEMN_ALL_II;
        this.weaponType = R.string.type_sword;
        this.armorType = R.string.type_armor_heavy;
        this.potionDrinkerType = PotionDrinkerType.WARRIOR;
        this.nextClasses.add("AngelOfWar");
    }
}
