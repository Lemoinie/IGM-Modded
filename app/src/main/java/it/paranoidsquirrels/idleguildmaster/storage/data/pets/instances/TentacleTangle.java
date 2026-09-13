package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Esoteric;

/* JADX INFO: loaded from: classes3.dex */
public class TentacleTangle extends Esoteric {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
    protected void configureStatistics() {
        this.idImage = R.drawable.pet_tentacle_tangle;
        this.idName = R.string.pet_tentacle_tangle_name;
        this.idDescription = R.string.pet_tentacle_tangle_description;
        this.abilityNumber = 3;
    }
}
