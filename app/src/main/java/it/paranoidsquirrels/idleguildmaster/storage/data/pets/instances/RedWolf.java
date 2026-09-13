package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Wild;

/* JADX INFO: loaded from: classes3.dex */
public class RedWolf extends Wild {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
    protected void configureStatistics() {
        this.idImage = R.drawable.pet_red_wolf;
        this.idName = R.string.pet_red_wolf_name;
        this.idDescription = R.string.pet_red_wolf_description;
        this.abilityNumber = 4;
    }
}
