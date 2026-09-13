package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;

/* JADX INFO: loaded from: classes3.dex */
public class WildEgg extends it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Egg {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.egg_wild_name;
        this.idDescription = R.string.egg_wild_description;
        this.idImage = R.drawable.egg_wild;
        this.source.add(Integer.valueOf(R.string.dungeon_name_enchanted_forest));
        this.source.add(Integer.valueOf(R.string.dungeon_name_blackwater_port));
        this.price = 100L;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Egg
    public Pet hatch() {
        int iCalculateNewPetId = Utils.calculateNewPetId();
        double dRandom = Utils.random();
        if (dRandom < 0.75d) {
            return Pet.getInstance("Rat", iCalculateNewPetId);
        }
        return dRandom < 0.95d ? Pet.getInstance("Squirrel", iCalculateNewPetId) : Pet.getInstance("RedWolf", iCalculateNewPetId);
    }
}
