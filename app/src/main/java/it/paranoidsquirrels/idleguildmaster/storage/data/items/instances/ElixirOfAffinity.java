package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class ElixirOfAffinity extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_elixir_of_affinity_name;
        this.idDescription = R.string.item_elixir_of_affinity_description;
        this.idImage = R.drawable.elixir_of_affinity;
        this.price = 1233L;
    }
}
