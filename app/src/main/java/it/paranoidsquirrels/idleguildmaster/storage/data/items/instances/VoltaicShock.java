package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class VoltaicShock extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_voltaic_shock_name;
        this.idDescription = R.string.accessory_voltaic_shock_description;
        this.idEffect = R.string.accessory_voltaic_shock_effect;
        this.idImage = R.drawable.voltaic_shock;
        this.price = 4058L;
        this.endOfTurnAction = EndOfTurnAction.STUN_FLAT_II;
        this.dexterity = 30;
        this.intelligence = 10;
    }
}
