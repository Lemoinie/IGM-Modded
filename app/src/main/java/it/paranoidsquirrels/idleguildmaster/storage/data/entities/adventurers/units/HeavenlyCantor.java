package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class HeavenlyCantor extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 40;
        this.baseMaxHp = 240;
        this.baseConstitution = 21;
        this.baseIntelligence = 23;
        this.baseDexterity = 21;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.saboteur = true;
        this.endOfTurnAction = EndOfTurnAction.SHIELD_EXALT_I;
        this.imageId = R.drawable.unit_heavenly_cantor;
        this.idName = R.string.adventurer_heavenly_cantor_name;
        this.idDescription = R.string.adventurer_heavenly_cantor_description;
        this.passiveSkill = Skills.PASSIVE_EXALTING_I;
        this.activeSkill = Skills.ACTIVE_PETRIFYING_MELODY;
        this.weaponType = R.string.type_dagger;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.THIEF;
        this.nextClasses.add("Eidolon");
    }
}
