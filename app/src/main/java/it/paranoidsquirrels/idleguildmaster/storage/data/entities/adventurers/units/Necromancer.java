package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Necromancer extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 20;
        this.baseMaxHp = 50;
        this.baseConstitution = 5;
        this.baseIntelligence = 25;
        this.baseDexterity = 7;
        this.baseDefense = 0;
        this.baseMagicDefense = 30;
        this.baseLifesteal = 50;
        this.imageId = R.drawable.unit_necromancer;
        this.idName = R.string.adventurer_necromancer_name;
        this.idDescription = R.string.adventurer_necromancer_description;
        this.passiveSkill = Skills.PASSIVE_WITHERING_TOUCH;
        this.activeSkill = Skills.ACTIVE_CURSE_I;
        this.weaponType = R.string.type_staff;
        this.armorType = R.string.type_armor_light;
        this.potionDrinkerType = PotionDrinkerType.MAGE;
        this.nextClasses.add("Demilich");
        this.nextClasses.add("Unchained");
    }
}
