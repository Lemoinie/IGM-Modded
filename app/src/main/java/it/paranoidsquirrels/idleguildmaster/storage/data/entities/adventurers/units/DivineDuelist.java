package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class DivineDuelist extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 40;
        this.baseMaxHp = 320;
        this.baseConstitution = 36;
        this.baseIntelligence = 13;
        this.baseDexterity = 16;
        this.baseDefense = 20;
        this.baseMagicDefense = 20;
        this.threat = 3;
        this.counterattack = 0.6d;
        this.onSelfHit = new StatusEffect(StatusEffectType.DEFENSIVE_STANCE, this, 999, 0.15d);
        this.imageId = R.drawable.unit_divine_duelist;
        this.idName = R.string.adventurer_divine_duelist_name;
        this.idDescription = R.string.adventurer_divine_duelist_description;
        this.passiveSkill = Skills.PASSIVE_SWORD_EXPERTISE_I;
        this.activeSkill = Skills.ACTIVE_EN_GARDE;
        this.weaponType = R.string.type_sword;
        this.armorType = R.string.type_armor_heavy;
        this.potionDrinkerType = PotionDrinkerType.WARRIOR;
        this.nextClasses.add("DivineChampion");
    }
}
