package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion;

/* JADX INFO: loaded from: classes3.dex */
public class PotionOfPrecision extends Potion {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion
    public int getPotionType() {
        return 6;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.consumable_potion_of_precision_name;
        this.idDescription = R.string.consumable_potion_of_precision_description;
        this.idImage = R.drawable.potion_of_precision;
        this.source.add(Integer.valueOf(R.string.dungeon_name_the_desert));
        this.price = 10L;
    }
}
