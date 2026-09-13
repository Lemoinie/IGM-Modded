package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class GoldenGauntlets extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_golden_gauntlets_name;
        this.idDescription = R.string.accessory_golden_gauntlets_description;
        this.idImage = R.drawable.golden_gauntlets;
        this.price = 228L;
        this.constitution = 11;
        this.dexterity = 9;
    }
}
