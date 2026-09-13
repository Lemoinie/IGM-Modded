package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Warrior extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 10;
        this.baseMaxHp = 65;
        this.baseConstitution = 12;
        this.baseIntelligence = 6;
        this.baseDexterity = 5;
        this.baseDefense = 20;
        this.baseMagicDefense = 20;
        this.threat = 2;
        this.imageId = R.drawable.unit_warrior;
        this.idName = R.string.adventurer_warrior_name;
        this.idDescription = R.string.adventurer_warrior_description;
        this.passiveSkill = Skills.PASSIVE_THREATENING_I;
        this.activeSkill = Skills.ACTIVE_MIGHTY_STRIKE;
        this.weaponType = R.string.type_sword;
        this.armorType = R.string.type_armor_heavy;
        this.potionDrinkerType = PotionDrinkerType.WARRIOR;
        this.nextClasses.add("Guard");
        this.nextClasses.add("Knight");
    }
}
