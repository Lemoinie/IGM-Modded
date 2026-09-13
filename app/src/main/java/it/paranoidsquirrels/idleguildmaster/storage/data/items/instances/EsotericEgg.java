package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;

/* JADX INFO: loaded from: classes3.dex */
public class EsotericEgg extends it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Egg {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.egg_esoteric_name;
        this.idDescription = R.string.egg_esoteric_description;
        this.idImage = R.drawable.egg_esoteric;
        this.source.add(Integer.valueOf(R.string.dungeon_name_the_desert));
        this.source.add(Integer.valueOf(R.string.dungeon_name_eternal_battlefield));
        this.source.add(Integer.valueOf(R.string.dungeon_name_blackwater_port));
        this.source.add(Integer.valueOf(R.string.dungeon_name_frostbite_peaks));
        this.source.add(Integer.valueOf(R.string.dungeon_name_obsidian_mines));
        this.source.add(Integer.valueOf(R.string.raid_name_the_lost_expedition));
        this.price = 100L;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Egg
    public Pet hatch() {
        int iCalculateNewPetId = Utils.calculateNewPetId();
        double dRandom = Utils.random();
        if (dRandom < 0.75d) {
            return Pet.getInstance("FloatingEye", iCalculateNewPetId);
        }
        return dRandom < 0.95d ? Pet.getInstance("TentacleTangle", iCalculateNewPetId) : Pet.getInstance("ThingFromTheAbyss", iCalculateNewPetId);
    }
}
