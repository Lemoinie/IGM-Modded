package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;

/* JADX INFO: loaded from: classes3.dex */
public class WyvernChop extends Food {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.food_wyvern_chop_name;
        this.idDescription = R.string.food_wyvern_chop_description;
        this.idImage = R.drawable.wyvern_chop;
        this.source.add(Integer.valueOf(R.string.dungeon_name_frostbite_peaks));
        this.price = 1L;
        this.feedPower = 75;
    }
}
