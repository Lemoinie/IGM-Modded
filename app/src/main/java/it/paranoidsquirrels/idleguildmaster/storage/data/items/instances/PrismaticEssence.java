package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class PrismaticEssence extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_prismatic_essence_name;
        this.idDescription = R.string.item_prismatic_essence_description;
        this.idImage = R.drawable.prismatic_essence;
        this.price = 13000L;
    }
}
