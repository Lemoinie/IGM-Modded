package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.LightArmor;

/* JADX INFO: loaded from: classes3.dex */
public class SpectralRobe extends LightArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_light_spectral_robe_name;
        this.idDescription = R.string.armor_light_spectral_robe_description;
        this.idImage = R.drawable.spectral_robe;
        this.price = 135L;
        this.maxHp = 30;
        this.intelligence = 9;
    }
}
