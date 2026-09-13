package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Scourge extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 30;
        this.baseMaxHp = 215;
        this.baseConstitution = 28;
        this.baseIntelligence = 11;
        this.baseDexterity = 12;
        this.baseDefense = 20;
        this.baseMagicDefense = 20;
        this.threat = 2;
        this.imageId = R.drawable.unit_scourge;
        this.idName = R.string.adventurer_scourge_name;
        this.idDescription = R.string.adventurer_scourge_description;
        this.passiveSkill = Skills.PASSIVE_THREATENING_I;
        this.activeSkill = Skills.ACTIVE_DECIMATE_II;
        this.weaponType = R.string.type_sword;
        this.armorType = R.string.type_armor_heavy;
        this.potionDrinkerType = PotionDrinkerType.WARRIOR;
        this.nextClasses.add("Tyrant");
    }
}
