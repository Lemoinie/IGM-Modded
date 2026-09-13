package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Overlord extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 40;
        this.baseMaxHp = 320;
        this.baseConstitution = 36;
        this.baseIntelligence = 13;
        this.baseDexterity = 16;
        this.baseDefense = 20;
        this.baseMagicDefense = 20;
        this.threat = 2;
        this.stunChanceOnLowerHp = 0.5d;
        this.imageId = R.drawable.unit_overlord;
        this.idName = R.string.adventurer_overlord_name;
        this.idDescription = R.string.adventurer_overlord_description;
        this.passiveSkill = Skills.PASSIVE_SUBJUGATE_I;
        this.activeSkill = Skills.ACTIVE_DECIMATE_III;
        this.weaponType = R.string.type_sword;
        this.armorType = R.string.type_armor_heavy;
        this.potionDrinkerType = PotionDrinkerType.WARRIOR;
        this.nextClasses.add("BlackRegent");
    }
}
