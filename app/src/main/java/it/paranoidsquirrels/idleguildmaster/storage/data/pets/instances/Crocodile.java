package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Reptile;

/* JADX INFO: loaded from: classes3.dex */
public class Crocodile extends Reptile {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
    protected void configureStatistics() {
        this.idImage = R.drawable.pet_crocodile;
        this.idName = R.string.pet_crocodile_name;
        this.idDescription = R.string.pet_crocodile_description;
        this.abilityNumber = 4;
    }
}
