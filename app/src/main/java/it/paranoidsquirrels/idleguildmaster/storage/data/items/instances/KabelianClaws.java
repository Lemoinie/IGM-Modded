package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class KabelianClaws extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_kabelian_claws_name;
        this.idDescription = R.string.accessory_kabelian_claws_description;
        this.idEffect = R.string.accessory_kabelian_claws_effect;
        this.idImage = R.drawable.kabelian_claws;
        this.price = 6720L;
        this.endOfTurnAction = EndOfTurnAction.BLEED_POKE_II;
        this.dexterity = 16;
        this.constitution = 15;
    }
}
