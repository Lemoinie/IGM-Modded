package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;

/* JADX INFO: loaded from: classes3.dex */
public class ReptileEgg extends it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Egg {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.egg_reptile_name;
        this.idDescription = R.string.egg_reptile_description;
        this.idImage = R.drawable.egg_reptile;
        this.source.add(Integer.valueOf(R.string.dungeon_name_the_southern_grove));
        this.source.add(Integer.valueOf(R.string.dungeon_name_barren_wastelands));
        this.price = 100L;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Egg
    public Pet hatch() {
        int iCalculateNewPetId = Utils.calculateNewPetId();
        double dRandom = Utils.random();
        if (dRandom < 0.75d) {
            return Pet.getInstance("Lizard", iCalculateNewPetId);
        }
        return dRandom < 0.95d ? Pet.getInstance("TreeFrog", iCalculateNewPetId) : Pet.getInstance("Crocodile", iCalculateNewPetId);
    }
}
