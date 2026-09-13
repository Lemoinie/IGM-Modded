package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion;

/* JADX INFO: loaded from: classes3.dex */
public class PotionOfDarkness extends Potion {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Potion
    public int getPotionType() {
        return 8;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.consumable_potion_of_darkness_name;
        this.idDescription = R.string.consumable_potion_of_darkness_description;
        this.idImage = R.drawable.potion_of_darkness;
        this.source.add(Integer.valueOf(R.string.dungeon_name_obsidian_mines));
        this.source.add(Integer.valueOf(R.string.raid_name_the_lost_expedition));
        this.price = 10L;
    }
}
