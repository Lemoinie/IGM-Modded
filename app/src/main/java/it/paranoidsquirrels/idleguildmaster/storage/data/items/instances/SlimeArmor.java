package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class SlimeArmor extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_slime_armor_name;
        this.idDescription = R.string.armor_heavy_slime_armor_description;
        this.idImage = R.drawable.slime_armor;
        this.price = 630L;
        this.maxHp = 150;
        this.defense = 5;
    }
}
