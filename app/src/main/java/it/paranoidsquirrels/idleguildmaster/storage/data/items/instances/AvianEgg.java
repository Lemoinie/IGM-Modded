package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;

/* JADX INFO: loaded from: classes3.dex */
public class AvianEgg extends it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Egg {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.egg_avian_name;
        this.idDescription = R.string.egg_avian_description;
        this.idImage = R.drawable.egg_avian;
        this.source.add(Integer.valueOf(R.string.dungeon_name_the_desert));
        this.source.add(Integer.valueOf(R.string.dungeon_name_obsidian_mines));
        this.source.add(Integer.valueOf(R.string.dungeon_name_frostbite_peaks));
        this.price = 100L;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Egg
    public Pet hatch() {
        int iCalculateNewPetId = Utils.calculateNewPetId();
        double dRandom = Utils.random();
        if (dRandom < 0.75d) {
            return Pet.getInstance("Dove", iCalculateNewPetId);
        }
        return dRandom < 0.95d ? Pet.getInstance("Owl", iCalculateNewPetId) : Pet.getInstance("Eagle", iCalculateNewPetId);
    }
}
