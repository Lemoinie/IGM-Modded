package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class CorrosiveWraith extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 45;
        this.baseMaxHp = 290;
        this.baseConstitution = 12;
        this.baseIntelligence = 20;
        this.baseDexterity = 40;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.alwaysHits = true;
        this.statusImmunities.add(StatusEffectType.POISON);
        this.poisonBonus = 5;
        this.onTargetHit = new StatusEffect(StatusEffectType.POISON, this, 2, 0.4d);
        this.imageId = R.drawable.unit_corrosive_wraith;
        this.idName = R.string.adventurer_corrosive_wraith_name;
        this.idDescription = R.string.adventurer_corrosive_wraith_description;
        this.passiveSkill = Skills.PASSIVE_CORROSIVE_BLOOD;
        this.activeSkill = Skills.ACTIVE_FOCUSED_BARRAGE;
        this.weaponType = R.string.type_bow;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.ARCHER;
    }
}
