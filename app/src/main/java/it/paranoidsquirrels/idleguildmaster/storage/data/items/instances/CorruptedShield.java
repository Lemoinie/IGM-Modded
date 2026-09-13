package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class CorruptedShield extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_corrupted_shield_name;
        this.idDescription = R.string.accessory_corrupted_shield_description;
        this.idImage = R.drawable.corrupted_shield;
        this.source.add(Integer.valueOf(R.string.dungeon_name_the_golden_city));
        this.source.add(Integer.valueOf(R.string.raid_name_imperial_rescue));
        this.price = 1L;
        this.constitution = 1;
    }
}
