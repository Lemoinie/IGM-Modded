package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Construct;

/* JADX INFO: loaded from: classes3.dex */
public class Rockling extends Construct {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
    protected void configureStatistics() {
        this.idImage = R.drawable.pet_rockling;
        this.idName = R.string.pet_rockling_name;
        this.idDescription = R.string.pet_rockling_description;
        this.abilityNumber = 2;
    }
}
