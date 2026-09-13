package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class NightLament extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 45;
        this.baseMaxHp = 290;
        this.baseConstitution = 30;
        this.baseIntelligence = 12;
        this.baseDexterity = 30;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.saboteur = true;
        this.nightVision = true;
        this.darknessDamageAmplification = 0.02d;
        this.imageId = R.drawable.unit_night_lament;
        this.idName = R.string.adventurer_night_lament_name;
        this.idDescription = R.string.adventurer_night_lament_description;
        this.passiveSkill = Skills.PASSIVE_NIGHT_VISION_IV;
        this.activeSkill = Skills.ACTIVE_UMBRAL_STRIKE_III;
        this.weaponType = R.string.type_dagger;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.THIEF;
    }
}
