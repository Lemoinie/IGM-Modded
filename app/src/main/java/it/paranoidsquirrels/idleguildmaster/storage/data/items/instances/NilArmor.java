package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class NilArmor extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_nil_armor_name;
        this.idDescription = R.string.armor_heavy_nil_armor_description;
        this.idImage = R.drawable.nil_armor;
        this.price = 57000L;
        this.maxHp = 350;
        this.defense = 15;
        this.magicDefense = 15;
    }
}
