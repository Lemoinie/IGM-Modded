package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion;

/* JADX INFO: loaded from: classes3.dex */
public class PotionOfAgility extends Potion {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion
    public int getPotionType() {
        return 10;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.consumable_potion_of_agility_name;
        this.idDescription = R.string.consumable_potion_of_agility_description;
        this.idImage = R.drawable.potion_of_agility;
        this.source.add(Integer.valueOf(R.string.dungeon_name_the_southern_grove));
        this.price = 10L;
    }
}
