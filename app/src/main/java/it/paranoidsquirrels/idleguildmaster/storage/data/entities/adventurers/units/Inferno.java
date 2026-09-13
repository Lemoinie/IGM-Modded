package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionDrinkerType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class Inferno extends Adventurer {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
    protected void configureStatistics() {
        this.maxLevel = 45;
        this.baseMaxHp = 200;
        this.baseConstitution = 10;
        this.baseIntelligence = 50;
        this.baseDexterity = 12;
        this.baseDefense = 0;
        this.baseMagicDefense = 30;
        this.onTargetHit = new StatusEffect(StatusEffectType.ABLAZE, this, 1, 1.0d);
        this.imageId = R.drawable.unit_inferno;
        this.idName = R.string.adventurer_inferno_name;
        this.idDescription = R.string.adventurer_inferno_description;
        this.passiveSkill = Skills.PASSIVE_PYROMANCY_II;
        this.activeSkill = Skills.ACTIVE_METEOR_II;
        this.weaponType = R.string.type_staff;
        this.armorType = R.string.type_armor_light;
        this.potionDrinkerType = PotionDrinkerType.MAGE;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer, it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public List<EndOfTurnAction> endOfTurnActions() {
        ArrayList arrayList = new ArrayList(super.endOfTurnActions());
        arrayList.addAll(Collections.nCopies(2, EndOfTurnAction.EXTRA_ATTACK_1));
        return arrayList;
    }
}
