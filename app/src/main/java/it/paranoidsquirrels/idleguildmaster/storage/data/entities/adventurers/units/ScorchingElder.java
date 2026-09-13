package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class ScorchingElder extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 35;
        this.baseMaxHp = 125;
        this.baseConstitution = 8;
        this.baseIntelligence = 40;
        this.baseDexterity = 10;
        this.baseDefense = 0;
        this.baseMagicDefense = 30;
        this.onTargetHit = new StatusEffect(StatusEffectType.ABLAZE, this, 1, 1.0d);
        this.imageId = R.drawable.unit_scorching_elder;
        this.idName = R.string.adventurer_scorching_elder_name;
        this.idDescription = R.string.adventurer_scorching_elder_description;
        this.passiveSkill = Skills.PASSIVE_FIRE_MAGIC_II;
        this.activeSkill = Skills.ACTIVE_METEOR_II;
        this.weaponType = R.string.type_staff;
        this.armorType = R.string.type_armor_light;
        this.potionDrinkerType = PotionDrinkerType.MAGE;
        this.nextClasses.add("MeltingElder");
    }
}
