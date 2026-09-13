package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class CursedClaws extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_cursed_claws_name;
        this.idDescription = R.string.accessory_cursed_claws_description;
        this.idEffect = R.string.accessory_cursed_claws_effect;
        this.idImage = R.drawable.cursed_claws;
        this.price = 1920L;
        this.endOfTurnAction = EndOfTurnAction.BLEED_POKE;
        this.dexterity = 12;
        this.constitution = 12;
    }
}
