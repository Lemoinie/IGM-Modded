package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Rogue extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 5;
        this.baseMaxHp = 30;
        this.baseConstitution = 6;
        this.baseIntelligence = 4;
        this.baseDexterity = 6;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.imageId = R.drawable.unit_rogue;
        this.idName = R.string.adventurer_rogue_name;
        this.idDescription = R.string.adventurer_rogue_description;
        this.passiveSkill = Skills.PASSIVE_NONE;
        this.activeSkill = Skills.ACTIVE_BACKSTAB_I;
        this.weaponType = R.string.type_dagger;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.THIEF;
        this.nextClasses.add("Thief");
    }
}
