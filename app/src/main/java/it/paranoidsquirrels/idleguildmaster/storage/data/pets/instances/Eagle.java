package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Avian;

/* JADX INFO: loaded from: classes3.dex */
public class Eagle extends Avian {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
    protected void configureStatistics() {
        this.idImage = R.drawable.pet_eagle;
        this.idName = R.string.pet_eagle_name;
        this.idDescription = R.string.pet_eagle_description;
        this.abilityNumber = 4;
    }
}
