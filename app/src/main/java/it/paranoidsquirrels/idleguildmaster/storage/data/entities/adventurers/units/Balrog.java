package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Balrog extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 45;
        this.baseMaxHp = 380;
        this.baseConstitution = 36;
        this.baseIntelligence = 36;
        this.baseDexterity = 36;
        this.baseDefense = 36;
        this.baseMagicDefense = 36;
        this.imageId = R.drawable.unit_balrog;
        this.idName = R.string.adventurer_balrog_name;
        this.idDescription = R.string.adventurer_balrog_description;
        this.passiveSkill = Skills.PASSIVE_CHAOTIC;
        this.activeSkill = Skills.ACTIVE_WHIP_AND_TEAR;
        this.weaponType = R.string.type_staff;
        this.armorType = R.string.type_armor_light;
        this.potionDrinkerType = PotionDrinkerType.MAGE;
    }
}
