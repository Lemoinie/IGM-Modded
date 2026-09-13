package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;

/* JADX INFO: loaded from: classes3.dex */
public class RedReaperSauce extends Food {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.food_red_reaper_sauce_name;
        this.idDescription = R.string.food_red_reaper_sauce_description;
        this.idImage = R.drawable.red_reaper_sauce;
        this.price = 80L;
        this.feedPower = 128;
    }
}
