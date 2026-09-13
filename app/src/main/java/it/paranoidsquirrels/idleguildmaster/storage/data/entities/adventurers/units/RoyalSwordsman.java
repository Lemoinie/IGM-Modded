package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class RoyalSwordsman extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 25;
        this.baseMaxHp = 170;
        this.baseConstitution = 24;
        this.baseIntelligence = 10;
        this.baseDexterity = 10;
        this.baseDefense = 20;
        this.baseMagicDefense = 20;
        this.threat = 3;
        this.counterattack = 0.3d;
        this.imageId = R.drawable.unit_royal_swordman;
        this.idName = R.string.adventurer_royal_swordsman_name;
        this.idDescription = R.string.adventurer_royal_swordsman_description;
        this.passiveSkill = Skills.PASSIVE_SWORD_MASTERY_I;
        this.activeSkill = Skills.ACTIVE_EN_GARDE;
        this.weaponType = R.string.type_sword;
        this.armorType = R.string.type_armor_heavy;
        this.potionDrinkerType = PotionDrinkerType.WARRIOR;
        this.nextClasses.add("RoyalCaptain");
    }
}
