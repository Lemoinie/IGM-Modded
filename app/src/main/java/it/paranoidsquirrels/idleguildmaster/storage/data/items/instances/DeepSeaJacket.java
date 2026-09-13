package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class DeepSeaJacket extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_deep_sea_jacket_name;
        this.idDescription = R.string.armor_medium_deep_sea_jacket_description;
        this.idEffect = R.string.armor_medium_deep_sea_jacket_effect;
        this.idImage = R.drawable.deep_sea_jacket;
        this.price = 5883L;
        this.maxHp = 100;
        this.constitution = 5;
        this.dexterity = 5;
        this.immunityToStatus = 0.4d;
    }
}
