package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class ShortCircuit extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_short_circuit_name;
        this.idDescription = R.string.accessory_short_circuit_description;
        this.idEffect = R.string.accessory_short_circuit_effect;
        this.idImage = R.drawable.short_circuit;
        this.price = 705L;
        this.endOfTurnAction = EndOfTurnAction.STUN_FLAT;
        this.dexterity = 25;
    }
}
