package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class PterodactylClaw extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_pterodactyl_claw_name;
        this.idDescription = R.string.item_pterodactyl_claw_description;
        this.idImage = R.drawable.pterodactyl_claw;
        this.source.add(Integer.valueOf(R.string.dungeon_name_lost_lands));
        this.price = 42L;
    }
}
