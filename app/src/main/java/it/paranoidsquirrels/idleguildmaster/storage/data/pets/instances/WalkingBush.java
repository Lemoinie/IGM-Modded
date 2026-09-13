package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Wooden;

/* JADX INFO: loaded from: classes3.dex */
public class WalkingBush extends Wooden {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
    protected void configureStatistics() {
        this.idImage = R.drawable.pet_walking_bush;
        this.idName = R.string.pet_walking_bush_name;
        this.idDescription = R.string.pet_walking_bush_description;
        this.abilityNumber = 3;
    }
}
