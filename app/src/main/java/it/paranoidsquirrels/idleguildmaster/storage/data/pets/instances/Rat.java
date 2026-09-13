package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Wild;

/* JADX INFO: loaded from: classes3.dex */
public class Rat extends Wild {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
    protected void configureStatistics() {
        this.idImage = R.drawable.pet_rat;
        this.idName = R.string.pet_rat_name;
        this.idDescription = R.string.pet_rat_description;
        this.abilityNumber = 2;
    }
}
