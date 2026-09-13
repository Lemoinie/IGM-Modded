package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class BlackIdol extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 45;
        this.baseMaxHp = 200;
        this.baseConstitution = 10;
        this.baseIntelligence = 50;
        this.baseDexterity = 12;
        this.baseDefense = 0;
        this.baseMagicDefense = 30;
        this.baseLifesteal = 50;
        this.healsMinionBound = true;
        this.imageId = R.drawable.unit_black_idol;
        this.idName = R.string.adventurer_black_idol_name;
        this.idDescription = R.string.adventurer_black_idol_description;
        this.passiveSkill = Skills.PASSIVE_WITHERING_LINK;
        this.activeSkill = Skills.ACTIVE_CURSE_V;
        this.weaponType = R.string.type_staff;
        this.armorType = R.string.type_armor_light;
        this.potionDrinkerType = PotionDrinkerType.MAGE;
    }
}
