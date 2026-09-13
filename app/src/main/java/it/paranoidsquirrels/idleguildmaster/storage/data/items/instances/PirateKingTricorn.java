package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class PirateKingTricorn extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_pirate_king_tricorn_name;
        this.idDescription = R.string.accessory_pirate_king_tricorn_description;
        this.idEffect = R.string.accessory_pirate_king_tricorn_effect;
        this.idImage = R.drawable.pirate_king_tricorn;
        this.price = 14600L;
        this.maxHp = 100;
        this.dexterity = 15;
        this.intelligence = 10;
        this.criticalDamage = 0.5d;
    }
}
