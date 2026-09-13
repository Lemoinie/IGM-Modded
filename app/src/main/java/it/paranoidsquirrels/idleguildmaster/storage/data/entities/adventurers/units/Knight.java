package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Knight extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 15;
        this.baseMaxHp = 95;
        this.baseConstitution = 16;
        this.baseIntelligence = 8;
        this.baseDexterity = 6;
        this.baseDefense = 20;
        this.baseMagicDefense = 20;
        this.threat = 2;
        this.imageId = R.drawable.unit_knight;
        this.idName = R.string.adventurer_knight_name;
        this.idDescription = R.string.adventurer_knight_description;
        this.passiveSkill = Skills.PASSIVE_THREATENING_I;
        this.activeSkill = Skills.ACTIVE_CRUSHING_STRIKE;
        this.weaponType = R.string.type_sword;
        this.armorType = R.string.type_armor_heavy;
        this.potionDrinkerType = PotionDrinkerType.WARRIOR;
        this.nextClasses.add("DarkKnight");
        this.nextClasses.add("HolyKnight");
    }
}
