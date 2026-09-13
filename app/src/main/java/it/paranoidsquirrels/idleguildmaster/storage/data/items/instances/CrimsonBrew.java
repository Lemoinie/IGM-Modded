package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class CrimsonBrew extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_crimson_brew_name;
        this.idDescription = R.string.item_crimson_brew_description;
        this.idImage = R.drawable.crimson_brew;
        this.price = 360L;
    }
}
