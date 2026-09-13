package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion;

/* JADX INFO: loaded from: classes3.dex */
public class PotionOfConstitution extends Potion {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion
    public int getPotionType() {
        return 0;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.consumable_potion_of_constitution_name;
        this.idDescription = R.string.consumable_potion_of_constitution_description;
        this.idImage = R.drawable.potion_of_constitution;
        this.source.add(Integer.valueOf(R.string.dungeon_name_eternal_battlefield));
        this.source.add(Integer.valueOf(R.string.raid_name_ancient_grave_digging));
        this.price = 100L;
    }
}
