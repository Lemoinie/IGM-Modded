package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class AncientLich extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 35;
        this.baseMaxHp = 125;
        this.baseConstitution = 8;
        this.baseIntelligence = 40;
        this.baseDexterity = 10;
        this.baseDefense = 0;
        this.baseMagicDefense = 30;
        this.baseLifesteal = 50;
        this.healsMinionBound = true;
        this.imageId = R.drawable.unit_ancient_lich;
        this.idName = R.string.adventurer_ancient_lich_name;
        this.idDescription = R.string.adventurer_ancient_lich_description;
        this.passiveSkill = Skills.PASSIVE_WITHERING_LINK;
        this.activeSkill = Skills.ACTIVE_CURSE_III;
        this.weaponType = R.string.type_staff;
        this.armorType = R.string.type_armor_light;
        this.potionDrinkerType = PotionDrinkerType.MAGE;
        this.nextClasses.add("LorfOfDecay");
    }
}
