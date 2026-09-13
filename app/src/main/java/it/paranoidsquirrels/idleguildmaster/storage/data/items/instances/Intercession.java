package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable;

/* JADX INFO: loaded from: classes3.dex */
public class Intercession extends Consumable {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.consumable_intercession_name;
        this.idDescription = R.string.consumable_intercession_description;
        this.idImage = R.drawable.intercession;
        this.notSellable = true;
        this.price = 10L;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable
    public int printConsumeImage() {
        return R.drawable.consume_intercession;
    }
}
