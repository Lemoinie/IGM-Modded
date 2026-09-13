package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class ElementalAlchemist extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 35;
        this.baseMaxHp = 195;
        this.baseConstitution = 10;
        this.baseIntelligence = 20;
        this.baseDexterity = 28;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.alwaysHits = true;
        this.onTargetHit = new StatusEffect(StatusEffectType.POISON, this, 1, 0.4d);
        this.onDeathEffectsOnEnemies.add(new StatusEffect(StatusEffectType.POISON, this, 5, 1.0d));
        this.onDeathEffectsOnEnemies.add(new StatusEffect(StatusEffectType.STUN, this, 1, 1.0d));
        this.onDeathEffectsOnEnemies.add(new StatusEffect(StatusEffectType.ABLAZE, this, 5, 1.0d));
        this.onDeathEffectsOnEnemies.add(new StatusEffect(StatusEffectType.FROZEN, this, 5, 1.0d));
        this.imageId = R.drawable.unit_elemental_alchemist;
        this.idName = R.string.adventurer_elemental_alchemist_name;
        this.idDescription = R.string.adventurer_elemental_alchemist_description;
        this.passiveSkill = Skills.PASSIVE_THAUMATURGY_II;
        this.activeSkill = Skills.ACTIVE_BARRAGE_II;
        this.weaponType = R.string.type_bow;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.ARCHER;
        this.nextClasses.add("EsotericAlchemist");
    }
}
