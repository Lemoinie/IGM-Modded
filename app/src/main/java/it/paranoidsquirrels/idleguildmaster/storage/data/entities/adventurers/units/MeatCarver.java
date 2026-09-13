package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class MeatCarver extends Adventurer {
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
        this.flatDodgeChance = 0.1d;
        this.onTargetHit = new StatusEffect(StatusEffectType.BLEED, this, 15, 1.0d);
        this.imageId = R.drawable.unit_meat_carver;
        this.idName = R.string.adventurer_meat_carver_name;
        this.idDescription = R.string.adventurer_meat_carver_description;
        this.passiveSkill = Skills.PASSIVE_DEADLY_FINESSE_I;
        this.activeSkill = Skills.ACTIVE_THOUSAND_CUTS;
        this.weaponType = R.string.type_dagger;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.THIEF;
        this.nextClasses.add("WoundsWeaver");
    }
}
