package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class SylvanFlute extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_sylvan_flute_name;
        this.idDescription = R.string.accessory_sylvan_flute_description;
        this.idEffect = R.string.accessory_sylvan_flute_effect;
        this.idImage = R.drawable.sylvan_flute;
        this.source.add(Integer.valueOf(R.string.dungeon_name_the_southern_grove));
        this.price = 540L;
        this.exaltInspireBonusTurns = 2;
        this.constitution = 10;
        this.dexterity = 10;
        this.intelligence = 10;
    }
}
