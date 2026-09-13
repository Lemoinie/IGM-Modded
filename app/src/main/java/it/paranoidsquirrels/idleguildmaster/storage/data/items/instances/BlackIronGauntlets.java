package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class BlackIronGauntlets extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_black_iron_gauntlets_name;
        this.idDescription = R.string.accessory_black_iron_gauntlets_description;
        this.idImage = R.drawable.black_iron_gauntlets;
        this.price = 278L;
        this.constitution = 13;
        this.dexterity = 11;
    }
}
