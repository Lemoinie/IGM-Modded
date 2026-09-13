package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class WoundsWeaver extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 35;
        this.baseMaxHp = 195;
        this.baseConstitution = 24;
        this.baseIntelligence = 10;
        this.baseDexterity = 24;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.saboteur = true;
        this.flatDodgeChance = 0.1d;
        this.onTargetHit = new StatusEffect(StatusEffectType.BLEED, this, 30, 1.0d);
        this.imageId = R.drawable.unit_wound_weaver;
        this.idName = R.string.adventurer_wounds_weaver_name;
        this.idDescription = R.string.adventurer_wounds_weaver_description;
        this.passiveSkill = Skills.PASSIVE_DEADLY_FINESSE_II;
        this.activeSkill = Skills.ACTIVE_THOUSAND_CUTS;
        this.weaponType = R.string.type_dagger;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.THIEF;
        this.nextClasses.add("HellishSculptor");
    }
}
