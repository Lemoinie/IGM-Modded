package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class ShadowDancer extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 20;
        this.baseMaxHp = 90;
        this.baseConstitution = 15;
        this.baseIntelligence = 7;
        this.baseDexterity = 15;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.saboteur = true;
        this.nightVision = true;
        this.darknessDamageAmplification = 0.01d;
        this.imageId = R.drawable.unit_shadow_dancer;
        this.idName = R.string.adventurer_shadow_dancer_name;
        this.idDescription = R.string.adventurer_shadow_dancer_description;
        this.passiveSkill = Skills.PASSIVE_NIGHT_VISION_II;
        this.activeSkill = Skills.ACTIVE_BACKSTAB_I;
        this.weaponType = R.string.type_dagger;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.THIEF;
        this.nextClasses.add("NightBlade");
    }
}
