package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Guard extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 15;
        this.baseMaxHp = 95;
        this.baseConstitution = 16;
        this.baseIntelligence = 8;
        this.baseDexterity = 6;
        this.baseDefense = 20;
        this.baseMagicDefense = 20;
        this.threat = 3;
        this.imageId = R.drawable.unit_guard;
        this.idName = R.string.adventurer_guard_name;
        this.idDescription = R.string.adventurer_guard_description;
        this.passiveSkill = Skills.PASSIVE_THREATENING_II;
        this.activeSkill = Skills.ACTIVE_MIGHTY_STRIKE;
        this.weaponType = R.string.type_sword;
        this.armorType = R.string.type_armor_heavy;
        this.potionDrinkerType = PotionDrinkerType.WARRIOR;
        this.nextClasses.add("IronWarden");
        this.nextClasses.add("RoyalGuard");
    }
}
