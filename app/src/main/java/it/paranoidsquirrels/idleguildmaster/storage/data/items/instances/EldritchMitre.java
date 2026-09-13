package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class EldritchMitre extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_eldritch_mitre_name;
        this.idDescription = R.string.accessory_eldritch_mitre_description;
        this.idEffect = R.string.accessory_eldritch_mitre_effect;
        this.idImage = R.drawable.eldritch_mitre;
        this.price = 2255L;
        this.maxHp = 50;
        this.intelligence = 45;
        this.healingModifier = -0.99d;
    }
}
