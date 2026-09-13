package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class UndyingBastion extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 40;
        this.baseMaxHp = 320;
        this.baseConstitution = 36;
        this.baseIntelligence = 18;
        this.baseDexterity = 11;
        this.baseDefense = 29;
        this.baseMagicDefense = 29;
        this.threat = 4;
        this.imageId = R.drawable.unit_undying_bastion;
        this.idName = R.string.adventurer_undying_bastion_name;
        this.idDescription = R.string.adventurer_undying_bastion_description;
        this.passiveSkill = Skills.PASSIVE_THREATENING_III;
        this.activeSkill = Skills.ACTIVE_TAUNT_IV;
        this.weaponType = R.string.type_sword;
        this.armorType = R.string.type_armor_heavy;
        this.potionDrinkerType = PotionDrinkerType.WARRIOR;
        this.nextClasses.add("EternalFortress");
    }
}
