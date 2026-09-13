package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class HellishSculptor extends Adventurer {
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
        this.flatDodgeChance = 0.1d;
        this.onTargetHit = new StatusEffect(StatusEffectType.BLEED, this, 60, 1.0d);
        this.imageId = R.drawable.unit_hellish_sculptor;
        this.idName = R.string.adventurer_hellish_sculptor_name;
        this.idDescription = R.string.adventurer_hellish_sculptor_description;
        this.passiveSkill = Skills.PASSIVE_DEADLY_FINESSE_III;
        this.activeSkill = Skills.ACTIVE_THOUSAND_CUTS;
        this.weaponType = R.string.type_dagger;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.THIEF;
        this.nextClasses.add("SpiritEngraver");
    }
}
