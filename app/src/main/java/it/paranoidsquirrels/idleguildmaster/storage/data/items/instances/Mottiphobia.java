package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class Mottiphobia extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_mottiphobia_name;
        this.idDescription = R.string.weapon_dagger_mottiphobia_description;
        this.idEffect = R.string.weapon_dagger_mottiphobia_effect;
        this.idImage = R.drawable.mottiphobia;
        this.price = 3758L;
        this.endOfTurnAction = EndOfTurnAction.EXTRA_ATTACK_HP_TO_DAMAGE;
        this.maxHp = 25;
        this.dexterity = 10;
    }
}
