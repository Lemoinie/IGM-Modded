package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class Fury extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 25;
        this.baseMaxHp = Logger.BARD_SHIELD;
        this.baseConstitution = 8;
        this.baseIntelligence = 12;
        this.baseDexterity = 24;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.alwaysHits = true;
        this.imageId = R.drawable.unit_fury;
        this.idName = R.string.adventurer_fury_name;
        this.idDescription = R.string.adventurer_fury_description;
        this.passiveSkill = Skills.PASSIVE_KEEN_VISION;
        this.activeSkill = Skills.ACTIVE_BARRAGE_IV;
        this.weaponType = R.string.type_bow;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.ARCHER;
        this.nextClasses.add("Hailstorm");
    }
}
