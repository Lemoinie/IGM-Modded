package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable;

/* JADX INFO: loaded from: classes3.dex */
public class Geode extends Consumable {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.consumable_geode_name;
        this.idDescription = R.string.consumable_geode_description;
        this.idImage = R.drawable.geode;
        this.source.add(Integer.valueOf(R.string.item_found_everywhere));
        this.price = 10L;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable
    public int printConsumeImage() {
        return R.drawable.consume_geode;
    }
}
