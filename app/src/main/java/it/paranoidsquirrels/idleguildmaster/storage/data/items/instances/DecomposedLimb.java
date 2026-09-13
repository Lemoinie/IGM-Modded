package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class DecomposedLimb extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_decomposed_limb_name;
        this.idDescription = R.string.weapon_sword_decomposed_limb_description;
        this.idImage = R.drawable.decomposed_limb;
        this.price = 0L;
        this.constitution = 1;
    }
}
