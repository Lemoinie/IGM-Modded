package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class NightVeil extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 40;
        this.baseMaxHp = 240;
        this.baseConstitution = 27;
        this.baseIntelligence = 11;
        this.baseDexterity = 27;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.saboteur = true;
        this.nightVision = true;
        this.darknessDamageAmplification = 0.02d;
        this.imageId = R.drawable.unit_night_veil;
        this.idName = R.string.adventurer_night_veil_name;
        this.idDescription = R.string.adventurer_night_veil_description;
        this.passiveSkill = Skills.PASSIVE_NIGHT_VISION_IV;
        this.activeSkill = Skills.ACTIVE_UMBRAL_STRIKE_II;
        this.weaponType = R.string.type_dagger;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.THIEF;
        this.nextClasses.add("NightLament");
    }
}
