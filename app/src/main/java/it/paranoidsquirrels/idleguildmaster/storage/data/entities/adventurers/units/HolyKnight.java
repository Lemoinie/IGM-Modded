package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class HolyKnight extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 20;
        this.baseMaxHp = 130;
        this.baseConstitution = 20;
        this.baseIntelligence = 10;
        this.baseDexterity = 7;
        this.baseDefense = 20;
        this.baseMagicDefense = 23;
        this.threat = 2;
        this.darknessReduction = 10;
        this.imageId = R.drawable.unit_holy_knight;
        this.idName = R.string.adventurer_holy_knight_name;
        this.idDescription = R.string.adventurer_holy_knight_description;
        this.passiveSkill = Skills.PASSIVE_BLINDING_I;
        this.activeSkill = Skills.ACTIVE_CONDEMN;
        this.weaponType = R.string.type_sword;
        this.armorType = R.string.type_armor_heavy;
        this.potionDrinkerType = PotionDrinkerType.WARRIOR;
        this.nextClasses.add("Paladin");
    }
}
