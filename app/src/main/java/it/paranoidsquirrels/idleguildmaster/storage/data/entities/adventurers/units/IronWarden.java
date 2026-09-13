package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class IronWarden extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 20;
        this.baseMaxHp = 130;
        this.baseConstitution = 20;
        this.baseIntelligence = 10;
        this.baseDexterity = 7;
        this.baseDefense = 22;
        this.baseMagicDefense = 22;
        this.threat = 3;
        this.imageId = R.drawable.unit_iron_warden;
        this.idName = R.string.adventurer_iron_warden_name;
        this.idDescription = R.string.adventurer_iron_warden_description;
        this.passiveSkill = Skills.PASSIVE_THREATENING_II;
        this.activeSkill = Skills.ACTIVE_TAUNT_I;
        this.weaponType = R.string.type_sword;
        this.armorType = R.string.type_armor_heavy;
        this.potionDrinkerType = PotionDrinkerType.WARRIOR;
        this.nextClasses.add("IronDefender");
    }
}
