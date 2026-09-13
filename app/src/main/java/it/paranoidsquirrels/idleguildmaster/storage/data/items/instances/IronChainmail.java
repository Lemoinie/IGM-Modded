package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class IronChainmail extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_iron_chainmail_name;
        this.idDescription = R.string.armor_heavy_iron_chainmail_description;
        this.idImage = R.drawable.iron_chainmail;
        this.price = 51L;
        this.maxHp = 60;
        this.constitution = 2;
    }
}
