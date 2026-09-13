package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class KingsHand extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 35;
        this.baseMaxHp = 265;
        this.baseConstitution = 32;
        this.baseIntelligence = 12;
        this.baseDexterity = 14;
        this.baseDefense = 20;
        this.baseMagicDefense = 20;
        this.threat = 3;
        this.counterattack = 0.6d;
        this.imageId = R.drawable.unit_kings_hand;
        this.idName = R.string.adventurer_kings_hand_name;
        this.idDescription = R.string.adventurer_kings_hand_description;
        this.passiveSkill = Skills.PASSIVE_SWORD_MASTERY_III;
        this.activeSkill = Skills.ACTIVE_EN_GARDE;
        this.weaponType = R.string.type_sword;
        this.armorType = R.string.type_armor_heavy;
        this.potionDrinkerType = PotionDrinkerType.WARRIOR;
        this.nextClasses.add("DivineDuelist");
    }
}
