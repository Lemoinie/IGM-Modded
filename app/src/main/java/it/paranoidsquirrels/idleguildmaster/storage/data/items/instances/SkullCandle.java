package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class SkullCandle extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_skull_candle_name;
        this.idDescription = R.string.accessory_skull_candle_description;
        this.idEffect = R.string.accessory_skull_candle_effect;
        this.idImage = R.drawable.skull_candle;
        this.price = 69L;
        this.intelligence = 4;
        this.darknessReduction = 10;
    }
}
