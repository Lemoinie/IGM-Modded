package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class PrimevalArmor extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_primeval_armor_name;
        this.idDescription = R.string.armor_heavy_primeval_armor_description;
        this.idImage = R.drawable.primeval_armor;
        this.price = 1296L;
        this.maxHp = 270;
        this.constitution = 9;
        this.defense = 15;
    }
}
