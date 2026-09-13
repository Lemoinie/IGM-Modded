package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable;

/* JADX INFO: loaded from: classes3.dex */
public class Evo23Vial2 extends Consumable {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.consumable_evo23_vial_name;
        this.idDescription = R.string.consumable_evo23_vial_description_alternative;
        this.idImage = R.drawable.evo23_vial;
        this.notSellable = true;
        this.price = 10L;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable
    public int printConsumeImage() {
        return R.drawable.consume_evo23_vial;
    }
}
