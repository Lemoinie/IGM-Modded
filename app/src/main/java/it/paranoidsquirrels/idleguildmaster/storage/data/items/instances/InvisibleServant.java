package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class InvisibleServant extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_invisible_servant_name;
        this.idDescription = R.string.accessory_invisible_servant_description;
        this.idEffect = R.string.accessory_invisible_servant_effect;
        this.idImage = R.drawable.invisible_servant;
        this.price = 16200L;
        this.endOfTurnAction = EndOfTurnAction.EXTRA_ATTACK_140_MAGIC;
        this.maxHp = 135;
        this.constitution = 35;
    }
}
