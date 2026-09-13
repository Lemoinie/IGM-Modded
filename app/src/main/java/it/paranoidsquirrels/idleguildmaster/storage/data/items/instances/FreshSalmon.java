package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;

/* JADX INFO: loaded from: classes3.dex */
public class FreshSalmon extends Food {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.food_fresh_salmon_name;
        this.idDescription = R.string.food_fresh_salmon_description;
        this.idImage = R.drawable.fresh_salmon;
        this.source.add(Integer.valueOf(R.string.dungeon_name_blackwater_port));
        this.price = 10L;
        this.feedPower = 18;
    }
}
