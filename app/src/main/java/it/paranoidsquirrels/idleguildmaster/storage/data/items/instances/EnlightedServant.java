package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class EnlightedServant extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_enlighted_servant_name;
        this.idDescription = R.string.accessory_enlighted_servant_description;
        this.idEffect = R.string.accessory_enlighted_servant_effect;
        this.idImage = R.drawable.enlighted_servant;
        this.price = 28425L;
        this.endOfTurnAction = EndOfTurnAction.EXTRA_ATTACK_200_MAGIC;
        this.maxHp = 150;
        this.constitution = 40;
    }
}
