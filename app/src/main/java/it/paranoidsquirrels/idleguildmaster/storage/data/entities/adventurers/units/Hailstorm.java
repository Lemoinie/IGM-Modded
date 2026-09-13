package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Hailstorm extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 30;
        this.baseMaxHp = 155;
        this.baseConstitution = 9;
        this.baseIntelligence = 14;
        this.baseDexterity = 28;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.alwaysHits = true;
        this.imageId = R.drawable.unit_hailstorm;
        this.idName = R.string.adventurer_hailstorm_name;
        this.idDescription = R.string.adventurer_hailstorm_description;
        this.passiveSkill = Skills.PASSIVE_KEEN_VISION;
        this.activeSkill = Skills.ACTIVE_BARRAGE_V;
        this.weaponType = R.string.type_bow;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.ARCHER;
        this.nextClasses.add("Tempest");
    }
}
