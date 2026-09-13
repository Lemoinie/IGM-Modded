package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class Dreamcatcher extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_dreamcatcher_name;
        this.idDescription = R.string.accessory_dreamcatcher_description;
        this.idEffect = R.string.accessory_dreamcatcher_effect;
        this.idImage = R.drawable.dreamcatcher;
        this.price = 1L;
        this.notSellable = true;
        this.constitution = 3;
        this.dexterity = 3;
        this.intelligence = 3;
        this.bonusExperience = 50;
    }
}
