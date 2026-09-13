package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class ShadowGem extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_shadow_gem_name;
        this.idDescription = R.string.item_shadow_gem_description;
        this.idImage = R.drawable.shadow_gem;
        this.source.add(Integer.valueOf(R.string.dungeon_name_obsidian_mines));
        this.source.add(Integer.valueOf(R.string.raid_name_the_lost_expedition));
        this.price = 34L;
    }
}
