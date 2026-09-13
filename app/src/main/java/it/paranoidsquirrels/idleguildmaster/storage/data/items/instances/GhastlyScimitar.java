package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class GhastlyScimitar extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_ghastly_scimitar_name;
        this.idDescription = R.string.weapon_sword_ghastly_scimitar_description;
        this.idEffect = R.string.weapon_sword_ghastly_scimitar_effect;
        this.idImage = R.drawable.ghastly_scimitar;
        this.price = 416L;
        this.constitution = 16;
        this.magicDefense = 10;
        this.counterattack = 0.2d;
    }
}
