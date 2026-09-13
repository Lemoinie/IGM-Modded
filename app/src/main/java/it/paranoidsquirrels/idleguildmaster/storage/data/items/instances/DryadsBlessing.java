package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff;

/* JADX INFO: loaded from: classes3.dex */
public class DryadsBlessing extends Staff {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_staff_dryads_blessing_name;
        this.idDescription = R.string.weapon_staff_dryads_blessing_description;
        this.idEffect = R.string.weapon_staff_dryads_blessing_effect;
        this.idImage = R.drawable.dryads_blessing;
        this.price = 735L;
        this.healingModifier = 0.23d;
        this.intelligence = 22;
    }
}
