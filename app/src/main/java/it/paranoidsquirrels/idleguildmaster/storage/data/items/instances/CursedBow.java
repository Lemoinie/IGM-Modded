package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow;

/* JADX INFO: loaded from: classes3.dex */
public class CursedBow extends Bow {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_bow_cursed_bow_name;
        this.idDescription = R.string.weapon_bow_cursed_bow_description;
        this.idEffect = R.string.weapon_bow_cursed_bow_effect;
        this.idImage = R.drawable.cursed_bow;
        this.price = 7683L;
        this.endOfTurnAction = EndOfTurnAction.EXTRA_ATTACK;
        this.dexterity = 26;
    }
}
