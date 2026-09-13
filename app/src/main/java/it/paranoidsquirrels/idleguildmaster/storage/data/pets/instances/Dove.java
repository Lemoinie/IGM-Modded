package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Avian;

/* JADX INFO: loaded from: classes3.dex */
public class Dove extends Avian {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
    protected void configureStatistics() {
        this.idImage = R.drawable.pet_dove;
        this.idName = R.string.pet_dove_name;
        this.idDescription = R.string.pet_dove_description;
        this.abilityNumber = 2;
    }
}
