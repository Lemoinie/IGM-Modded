package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class InfusedNecklace extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_infused_necklace_name;
        this.idDescription = R.string.accessory_infused_necklace_description;
        this.idEffect = R.string.accessory_infused_necklace_effect;
        this.idImage = R.drawable.infused_necklace;
        this.price = 38L;
        this.constitution = 1;
        this.dexterity = 1;
        this.intelligence = 2;
        this.bonusExperience = 10;
    }
}
