package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class AngelOfWar extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 45;
        this.baseMaxHp = 380;
        this.baseConstitution = 40;
        this.baseIntelligence = 20;
        this.baseDexterity = 12;
        this.baseDefense = 20;
        this.baseMagicDefense = 40;
        this.threat = 2;
        this.darknessReduction = 50;
        this.immunityToStatus = 0.7d;
        this.imageId = R.drawable.unit_angel_of_war;
        this.idName = R.string.adventurer_angel_of_war_name;
        this.idDescription = R.string.adventurer_angel_of_war_description;
        this.passiveSkill = Skills.PASSIVE_SEARING;
        this.activeSkill = Skills.ACTIVE_CONDEMN_ALL_II;
        this.weaponType = R.string.type_sword;
        this.armorType = R.string.type_armor_heavy;
        this.potionDrinkerType = PotionDrinkerType.WARRIOR;
    }
}
