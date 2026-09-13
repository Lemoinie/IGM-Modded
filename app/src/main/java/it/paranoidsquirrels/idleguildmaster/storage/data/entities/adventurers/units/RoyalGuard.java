package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class RoyalGuard extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 20;
        this.baseMaxHp = 130;
        this.baseConstitution = 20;
        this.baseIntelligence = 9;
        this.baseDexterity = 8;
        this.baseDefense = 20;
        this.baseMagicDefense = 20;
        this.threat = 3;
        this.counterattack = 0.3d;
        this.imageId = R.drawable.unit_royal_guard;
        this.idName = R.string.adventurer_royal_guard_name;
        this.idDescription = R.string.adventurer_royal_guard_description;
        this.passiveSkill = Skills.PASSIVE_SWORD_MASTERY_I;
        this.activeSkill = Skills.ACTIVE_MIGHTY_STRIKE;
        this.weaponType = R.string.type_sword;
        this.armorType = R.string.type_armor_heavy;
        this.potionDrinkerType = PotionDrinkerType.WARRIOR;
        this.nextClasses.add("RoyalSwordsman");
    }
}
