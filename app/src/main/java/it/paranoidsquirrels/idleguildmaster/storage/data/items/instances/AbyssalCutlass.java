package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class AbyssalCutlass extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_abyssal_cutlass_name;
        this.idDescription = R.string.weapon_sword_abyssal_cutlass_description;
        this.idImage = R.drawable.abyssal_cutlass;
        this.price = 5501L;
        this.constitution = 24;
    }
}
