package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class SpiritTome extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_spirit_tome_name;
        this.idDescription = R.string.accessory_spirit_tome_description;
        this.idImage = R.drawable.spirit_tome;
        this.source.add(Integer.valueOf(R.string.dungeon_name_eternal_battlefield));
        this.price = 26L;
        this.intelligence = 9;
    }
}
