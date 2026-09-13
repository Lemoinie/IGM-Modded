package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class WerewolfFang extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_werewolf_fang_name;
        this.idDescription = R.string.item_werewolf_fang_description;
        this.idImage = R.drawable.werewolf_fang;
        this.source.add(Integer.valueOf(R.string.dungeon_name_enchanted_forest));
        this.price = 24L;
    }
}
