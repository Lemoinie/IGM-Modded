package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class GiantMothWing extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_giant_moth_wing_name;
        this.idDescription = R.string.item_giant_moth_wing_description;
        this.idImage = R.drawable.giant_moth_wing;
        this.source.add(Integer.valueOf(R.string.dungeon_name_the_southern_grove));
        this.price = 3L;
    }
}
