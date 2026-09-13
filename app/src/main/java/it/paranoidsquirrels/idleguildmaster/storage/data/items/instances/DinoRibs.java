package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Food;

/* JADX INFO: loaded from: classes3.dex */
public class DinoRibs extends Food {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.food_dino_ribs_name;
        this.idDescription = R.string.food_dino_ribs_description;
        this.idImage = R.drawable.dino_ribs;
        this.source.add(Integer.valueOf(R.string.dungeon_name_lost_lands));
        this.price = 20L;
        this.feedPower = 30;
    }
}
