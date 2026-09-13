package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class ExoticVelvet extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_exotic_velvet_name;
        this.idDescription = R.string.item_exotic_velvet_description;
        this.idImage = R.drawable.exotic_velvet;
        this.source.add(Integer.valueOf(R.string.dungeon_name_blackwater_port));
        this.price = 30L;
    }
}
