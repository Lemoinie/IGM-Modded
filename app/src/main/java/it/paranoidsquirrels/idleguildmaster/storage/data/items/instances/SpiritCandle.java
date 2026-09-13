package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class SpiritCandle extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_spirit_candle_name;
        this.idDescription = R.string.item_spirit_candle_description;
        this.idImage = R.drawable.spirit_candle;
        this.source.add(Integer.valueOf(R.string.dungeon_name_eternal_battlefield));
        this.price = 20L;
    }
}
