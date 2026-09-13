package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Construct;

/* JADX INFO: loaded from: classes3.dex */
public class Tesseract extends Construct {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
    protected void configureStatistics() {
        this.idImage = R.drawable.pet_tesseract;
        this.idName = R.string.pet_tesseract_name;
        this.idDescription = R.string.pet_tesseract_description;
        this.abilityNumber = 4;
    }
}
