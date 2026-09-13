package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Angel extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 40;
        this.baseMaxHp = 160;
        this.baseConstitution = 9;
        this.baseIntelligence = 45;
        this.baseDexterity = 11;
        this.baseDefense = 0;
        this.baseMagicDefense = 30;
        this.healer = true;
        this.cleanser = true;
        this.imageId = R.drawable.unit_angel;
        this.idName = R.string.adventurer_angel_name;
        this.idDescription = R.string.adventurer_angel_description;
        this.passiveSkill = Skills.PASSIVE_HEALER_II;
        this.activeSkill = Skills.ACTIVE_RESTORATION_I;
        this.weaponType = R.string.type_staff;
        this.armorType = R.string.type_armor_light;
        this.potionDrinkerType = PotionDrinkerType.MAGE;
        this.nextClasses.add("Archangel");
    }
}
