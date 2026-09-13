package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class RoyalCaptain extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 30;
        this.baseMaxHp = 215;
        this.baseConstitution = 28;
        this.baseIntelligence = 11;
        this.baseDexterity = 12;
        this.baseDefense = 20;
        this.baseMagicDefense = 20;
        this.threat = 3;
        this.counterattack = 0.45d;
        this.imageId = R.drawable.unit_royal_captain;
        this.idName = R.string.adventurer_royal_captain_name;
        this.idDescription = R.string.adventurer_royal_captain_description;
        this.passiveSkill = Skills.PASSIVE_SWORD_MASTERY_II;
        this.activeSkill = Skills.ACTIVE_EN_GARDE;
        this.weaponType = R.string.type_sword;
        this.armorType = R.string.type_armor_heavy;
        this.potionDrinkerType = PotionDrinkerType.WARRIOR;
        this.nextClasses.add("KingsHand");
    }
}
