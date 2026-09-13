package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Thief extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 10;
        this.baseMaxHp = 45;
        this.baseConstitution = 9;
        this.baseIntelligence = 5;
        this.baseDexterity = 9;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.saboteur = true;
        this.imageId = R.drawable.unit_thief;
        this.idName = R.string.adventurer_thief_name;
        this.idDescription = R.string.adventurer_thief_description;
        this.passiveSkill = Skills.PASSIVE_SABOTEUR;
        this.activeSkill = Skills.ACTIVE_BACKSTAB_I;
        this.weaponType = R.string.type_dagger;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.THIEF;
        this.nextClasses.add("ShadowCrawler");
        this.nextClasses.add("Cutthroat");
        this.nextClasses.add("Trickster");
    }
}
