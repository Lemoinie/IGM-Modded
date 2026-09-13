package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class NightSpecter extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 30;
        this.baseMaxHp = 155;
        this.baseConstitution = 21;
        this.baseIntelligence = 9;
        this.baseDexterity = 21;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.saboteur = true;
        this.nightVision = true;
        this.darknessDamageAmplification = 0.015d;
        this.imageId = R.drawable.unit_night_specter;
        this.idName = R.string.adventurer_night_specter_name;
        this.idDescription = R.string.adventurer_night_specter_description;
        this.passiveSkill = Skills.PASSIVE_NIGHT_VISION_III;
        this.activeSkill = Skills.ACTIVE_UMBRAL_STRIKE_I;
        this.weaponType = R.string.type_dagger;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.THIEF;
        this.nextClasses.add("NightTerror");
    }
}
