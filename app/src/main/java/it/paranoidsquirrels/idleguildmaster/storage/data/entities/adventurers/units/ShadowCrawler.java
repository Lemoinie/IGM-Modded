package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class ShadowCrawler extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 15;
        this.baseMaxHp = 65;
        this.baseConstitution = 12;
        this.baseIntelligence = 6;
        this.baseDexterity = 12;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.saboteur = true;
        this.nightVision = true;
        this.imageId = R.drawable.unit_shadow_crawler;
        this.idName = R.string.adventurer_shadow_crawler_name;
        this.idDescription = R.string.adventurer_shadow_crawler_description;
        this.passiveSkill = Skills.PASSIVE_NIGHT_VISION_I;
        this.activeSkill = Skills.ACTIVE_BACKSTAB_I;
        this.weaponType = R.string.type_dagger;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.THIEF;
        this.nextClasses.add("ShadowDancer");
    }
}
