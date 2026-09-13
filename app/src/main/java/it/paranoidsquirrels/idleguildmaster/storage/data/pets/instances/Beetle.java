package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Insect;

/* JADX INFO: loaded from: classes3.dex */
public class Beetle extends Insect {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
    protected void configureStatistics() {
        this.idImage = R.drawable.pet_beetle;
        this.idName = R.string.pet_beetle_name;
        this.idDescription = R.string.pet_beetle_description;
        this.abilityNumber = 3;
    }
}
