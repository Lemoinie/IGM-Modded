package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Titan extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 35;
        this.baseMaxHp = 265;
        this.baseConstitution = 32;
        this.baseIntelligence = 16;
        this.baseDexterity = 10;
        this.baseDefense = 27;
        this.baseMagicDefense = 27;
        this.threat = 4;
        this.imageId = R.drawable.unit_titan;
        this.idName = R.string.adventurer_titan_name;
        this.idDescription = R.string.adventurer_titan_description;
        this.passiveSkill = Skills.PASSIVE_THREATENING_III;
        this.activeSkill = Skills.ACTIVE_TAUNT_III;
        this.weaponType = R.string.type_sword;
        this.armorType = R.string.type_armor_heavy;
        this.potionDrinkerType = PotionDrinkerType.WARRIOR;
        this.nextClasses.add("UndyingBastion");
    }
}
