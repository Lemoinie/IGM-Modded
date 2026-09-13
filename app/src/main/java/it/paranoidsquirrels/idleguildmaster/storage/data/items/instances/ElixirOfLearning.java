package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class ElixirOfLearning extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_elixir_of_learning_name;
        this.idDescription = R.string.item_elixir_of_learning_description;
        this.idImage = R.drawable.elixir_of_learning;
        this.source.add(Integer.valueOf(R.string.raid_name_the_cultist_rebels));
        this.price = 65L;
    }
}
