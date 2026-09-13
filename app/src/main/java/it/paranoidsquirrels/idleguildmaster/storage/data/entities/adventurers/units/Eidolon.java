package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;

/* JADX INFO: loaded from: classes3.dex */
public class Eidolon extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 45;
        this.baseMaxHp = 290;
        this.baseConstitution = 23;
        this.baseIntelligence = 26;
        this.baseDexterity = 23;
        this.baseDefense = 10;
        this.baseMagicDefense = 10;
        this.saboteur = true;
        this.endOfTurnAction = EndOfTurnAction.SHIELD_EXALT_II;
        this.imageId = R.drawable.unit_eidolon;
        this.idName = R.string.adventurer_eidolon_name;
        this.idDescription = R.string.adventurer_eidolon_description;
        this.passiveSkill = Skills.PASSIVE_EXALTING_II;
        this.activeSkill = Skills.ACTIVE_PETRIFYING_MELODY;
        this.weaponType = R.string.type_dagger;
        this.armorType = R.string.type_armor_medium;
        this.potionDrinkerType = PotionDrinkerType.THIEF;
    }
}
