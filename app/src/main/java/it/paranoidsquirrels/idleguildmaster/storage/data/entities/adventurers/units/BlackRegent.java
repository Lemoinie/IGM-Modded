package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class BlackRegent extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 45;
        this.baseMaxHp = 380;
        this.baseConstitution = 40;
        this.baseIntelligence = 14;
        this.baseDexterity = 18;
        this.baseDefense = 20;
        this.baseMagicDefense = 20;
        this.threat = 2;
        this.stunChanceOnLowerHp = 1.0d;
        this.imageId = R.drawable.unit_black_regent;
        this.idName = R.string.adventurer_black_regent_name;
        this.idDescription = R.string.adventurer_black_regent_description;
        this.passiveSkill = Skills.PASSIVE_SUBJUGATE_II;
        this.activeSkill = Skills.ACTIVE_DECIMATE_III;
        this.weaponType = R.string.type_sword;
        this.armorType = R.string.type_armor_heavy;
        this.potionDrinkerType = PotionDrinkerType.WARRIOR;
    }
}
