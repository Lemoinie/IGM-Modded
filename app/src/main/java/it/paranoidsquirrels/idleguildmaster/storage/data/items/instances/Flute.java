package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class Flute extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_flute_name;
        this.idDescription = R.string.accessory_flute_description;
        this.idEffect = R.string.accessory_flute_effect;
        this.idImage = R.drawable.flute;
        this.source.add(Integer.valueOf(R.string.dungeon_name_the_golden_city));
        this.price = 100L;
        this.exaltInspireBonusTurns = 1;
        this.constitution = 5;
        this.dexterity = 5;
        this.intelligence = 5;
    }
}
