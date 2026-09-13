package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Reptile;

/* JADX INFO: loaded from: classes3.dex */
public class Lizard extends Reptile {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
    protected void configureStatistics() {
        this.idImage = R.drawable.pet_lizard;
        this.idName = R.string.pet_lizard_name;
        this.idDescription = R.string.pet_lizard_description;
        this.abilityNumber = 2;
    }
}
