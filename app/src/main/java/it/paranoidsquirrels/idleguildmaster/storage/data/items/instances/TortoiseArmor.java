package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class TortoiseArmor extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_tortoise_armor_name;
        this.idDescription = R.string.armor_heavy_tortoise_armor_description;
        this.idImage = R.drawable.tortoise_armor;
        this.price = 492L;
        this.maxHp = 240;
        this.constitution = 8;
    }
}
