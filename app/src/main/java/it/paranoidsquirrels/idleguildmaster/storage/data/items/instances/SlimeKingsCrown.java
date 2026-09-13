package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import androidx.lifecycle.CoroutineLiveDataKt;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class SlimeKingsCrown extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_slime_kings_crown_name;
        this.idDescription = R.string.accessory_slime_kings_crown_description;
        this.idEffect = R.string.accessory_slime_kings_crown_effect;
        this.idImage = R.drawable.slime_kings_crown;
        this.source.add(Integer.valueOf(R.string.raid_name_the_slime_pond));
        this.price = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        this.bonusExperience = 35;
    }
}
