package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class EternalFortress extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 45;
        this.baseMaxHp = 380;
        this.baseConstitution = 40;
        this.baseIntelligence = 20;
        this.baseDexterity = 12;
        this.baseDefense = 30;
        this.baseMagicDefense = 30;
        this.threat = 5;
        this.imageId = R.drawable.unit_eternal_fortress;
        this.idName = R.string.adventurer_eternal_fortress_name;
        this.idDescription = R.string.adventurer_eternal_fortress_description;
        this.passiveSkill = Skills.PASSIVE_THREATENING_IV;
        this.activeSkill = Skills.ACTIVE_TAUNT_IV;
        this.weaponType = R.string.type_sword;
        this.armorType = R.string.type_armor_heavy;
        this.potionDrinkerType = PotionDrinkerType.WARRIOR;
    }
}
