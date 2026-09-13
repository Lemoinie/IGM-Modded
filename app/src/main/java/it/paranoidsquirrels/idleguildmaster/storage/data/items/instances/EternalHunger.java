package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class EternalHunger extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_eternal_hunger_name;
        this.idDescription = R.string.accessory_eternal_hunger_description;
        this.idEffect = R.string.accessory_eternal_hunger_effect;
        this.idImage = R.drawable.eternal_hunger;
        this.source.add(Integer.valueOf(R.string.raid_name_the_cultist_rebels));
        this.price = 15000L;
        this.intelligence = 5;
        this.lifesteal = 50;
    }
}
