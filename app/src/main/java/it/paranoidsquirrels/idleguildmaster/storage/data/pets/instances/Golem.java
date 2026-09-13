package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Construct;

/* JADX INFO: loaded from: classes3.dex */
public class Golem extends Construct {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
    protected void configureStatistics() {
        this.idImage = R.drawable.pet_golem;
        this.idName = R.string.pet_golem_name;
        this.idDescription = R.string.pet_golem_description;
        this.abilityNumber = 3;
    }
}
