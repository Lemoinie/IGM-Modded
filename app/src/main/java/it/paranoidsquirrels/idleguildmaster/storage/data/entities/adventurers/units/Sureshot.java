package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Sureshot extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 20;
        this.baseMaxHp = 90;
        this.baseConstitution = 7;
        this.baseIntelligence = 10;
        this.baseDexterity = 20;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.alwaysHits = true;
        this.imageId = R.drawable.unit_sureshot;
        this.idName = R.string.adventurer_sureshot_name;
        this.idDescription = R.string.adventurer_sureshot_description;
        this.passiveSkill = Skills.PASSIVE_KEEN_VISION;
        this.activeSkill = Skills.ACTIVE_BARRAGE_III;
        this.weaponType = R.string.type_bow;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.ARCHER;
        this.nextClasses.add("Fury");
    }
}
