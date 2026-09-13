package it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.PetAbility;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Reptile extends Pet {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
    protected List<PetAbility> guaranteedFirstAbility() {
        return Arrays.asList(PetAbility.SAVAGE, PetAbility.OPPORTUNIST);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
    public int printPetType() {
        return R.string.pet_type_reptile;
    }
}
