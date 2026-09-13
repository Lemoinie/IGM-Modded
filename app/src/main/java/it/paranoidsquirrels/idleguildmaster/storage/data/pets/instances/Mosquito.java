package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Insect;

/* JADX INFO: loaded from: classes3.dex */
public class Mosquito extends Insect {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
    protected void configureStatistics() {
        this.idImage = R.drawable.pet_mosquito;
        this.idName = R.string.pet_mosquito_name;
        this.idDescription = R.string.pet_mosquito_description;
        this.abilityNumber = 2;
    }
}
