package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Esoteric;

/* JADX INFO: loaded from: classes3.dex */
public class FloatingEye extends Esoteric {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
    protected void configureStatistics() {
        this.idImage = R.drawable.pet_floating_eye;
        this.idName = R.string.pet_floating_eye_name;
        this.idDescription = R.string.pet_floating_eye_description;
        this.abilityNumber = 2;
    }
}
