package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class SpiritEngraver extends Adventurer {
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
        this.flatDodgeChance = 0.1d;
        this.onTargetHit = new StatusEffect(StatusEffectType.BLEED, this, 60, 1.0d);
        this.imageId = R.drawable.unit_spirit_engraver;
        this.idName = R.string.adventurer_spirit_engraver_name;
        this.idDescription = R.string.adventurer_spirit_engraver_description;
        this.passiveSkill = Skills.PASSIVE_DEADLY_FINESSE_III;
        this.activeSkill = Skills.ACTIVE_THOUSAND_CUTS_II;
        this.weaponType = R.string.type_dagger;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.THIEF;
    }
}
