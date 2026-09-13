package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Wooden;

/* JADX INFO: loaded from: classes3.dex */
public class FloatingSeed extends Wooden {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
    protected void configureStatistics() {
        this.idImage = R.drawable.pet_floating_seed;
        this.idName = R.string.pet_floating_seed_name;
        this.idDescription = R.string.pet_floating_seed_description;
        this.abilityNumber = 2;
    }
}
