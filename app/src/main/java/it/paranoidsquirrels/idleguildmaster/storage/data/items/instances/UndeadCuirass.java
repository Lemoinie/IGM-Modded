package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class UndeadCuirass extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_undead_cuirass_name;
        this.idDescription = R.string.armor_heavy_undead_cuirass_description;
        this.idImage = R.drawable.undead_cuirass;
        this.price = 72L;
        this.maxHp = 90;
        this.constitution = 3;
    }
}
