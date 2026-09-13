package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class TacticalHelmet extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_tactical_helmet_name;
        this.idDescription = R.string.accessory_tactical_helmet_description;
        this.idEffect = R.string.accessory_tactical_helmet_effect;
        this.idImage = R.drawable.tactical_helmet;
        this.price = 1152L;
        this.darknessDamageAmplification = 0.005d;
        this.maxHp = Logger.BARD_SHIELD;
        this.dexterity = 12;
    }
}
