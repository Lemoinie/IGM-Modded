package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Wraith extends Adventurer {
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
        this.statusImmunities.add(StatusEffectType.POISON);
        this.onTargetHit = new StatusEffect(StatusEffectType.POISON, this, 2, 0.4d);
        this.imageId = R.drawable.unit_wraith;
        this.idName = R.string.adventurer_wraith_name;
        this.idDescription = R.string.adventurer_wraith_description;
        this.passiveSkill = Skills.PASSIVE_POISONOUS_BLOOD;
        this.activeSkill = Skills.ACTIVE_FOCUSED_BARRAGE;
        this.weaponType = R.string.type_bow;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.ARCHER;
        this.nextClasses.add("CorrosiveWraith");
    }
}
