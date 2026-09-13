package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class PlagueSpreader extends Adventurer {
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
        this.onTargetHit = new StatusEffect(StatusEffectType.POISON, this, 2, 0.4d);
        this.imageId = R.drawable.unit_plague_spreader;
        this.idName = R.string.adventurer_plague_spreader_name;
        this.idDescription = R.string.adventurer_plague_spreader_description;
        this.passiveSkill = Skills.PASSIVE_POISONOUS_ARROWS_III;
        this.activeSkill = Skills.ACTIVE_BARRAGE_II;
        this.weaponType = R.string.type_bow;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.ARCHER;
        this.nextClasses.add("Blight");
    }
}
