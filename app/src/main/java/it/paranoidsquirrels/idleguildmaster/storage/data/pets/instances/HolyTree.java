package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Wooden;

/* JADX INFO: loaded from: classes3.dex */
public class HolyTree extends Wooden {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
    protected void configureStatistics() {
        this.idImage = R.drawable.pet_holy_tree;
        this.idName = R.string.pet_holy_tree_name;
        this.idDescription = R.string.pet_holy_tree_description;
        this.abilityNumber = 4;
    }
}
