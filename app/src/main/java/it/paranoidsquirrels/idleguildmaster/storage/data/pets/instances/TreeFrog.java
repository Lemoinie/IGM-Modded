package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Reptile;

/* JADX INFO: loaded from: classes3.dex */
public class TreeFrog extends Reptile {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
    protected void configureStatistics() {
        this.idImage = R.drawable.pet_tree_frog;
        this.idName = R.string.pet_tree_frog_name;
        this.idDescription = R.string.pet_tree_frog_description;
        this.abilityNumber = 3;
    }
}
