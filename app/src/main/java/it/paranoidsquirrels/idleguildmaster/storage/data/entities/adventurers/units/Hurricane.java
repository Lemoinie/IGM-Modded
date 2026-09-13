package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Hurricane extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 40;
        this.baseMaxHp = 240;
        this.baseConstitution = 11;
        this.baseIntelligence = 18;
        this.baseDexterity = 36;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.alwaysHits = true;
        this.imageId = R.drawable.unit_hurricane;
        this.idName = R.string.adventurer_hurricane_name;
        this.idDescription = R.string.adventurer_hurricane_description;
        this.passiveSkill = Skills.PASSIVE_KEEN_VISION;
        this.activeSkill = Skills.ACTIVE_BARRAGE_VII;
        this.weaponType = R.string.type_bow;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.ARCHER;
        this.nextClasses.add("CelestialRain");
    }
}
