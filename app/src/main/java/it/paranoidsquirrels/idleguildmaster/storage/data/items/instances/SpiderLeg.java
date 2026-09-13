package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class SpiderLeg extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_spider_leg_name;
        this.idDescription = R.string.item_spider_leg_description;
        this.idImage = R.drawable.spider_leg;
        this.source.add(Integer.valueOf(R.string.dungeon_name_obsidian_mines));
        this.price = 2L;
    }
}
