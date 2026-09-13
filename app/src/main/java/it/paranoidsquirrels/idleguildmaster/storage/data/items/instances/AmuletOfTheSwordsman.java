package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class AmuletOfTheSwordsman extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_amulet_of_the_swordsman_name;
        this.idDescription = R.string.accessory_amulet_of_the_swordsman_description;
        this.idEffect = R.string.accessory_amulet_of_the_swordsman_effect;
        this.idImage = R.drawable.amulet_of_the_swordsman;
        this.price = 7590L;
        this.uniqueOrigin = "EyesOfTheSwordsman";
        this.notSellable = true;
        this.constitution = 25;
        this.counterattack = 0.25d;
        this.alwaysHits = true;
    }
}
