package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class ScarletVeil extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_scarlet_veil_name;
        this.idDescription = R.string.armor_medium_scarlet_veil_description;
        this.idEffect = R.string.armor_medium_scarlet_veil_effect;
        this.idImage = R.drawable.scarlet_veil;
        this.price = 80000L;
        this.maxHp = 270;
        this.constitution = 30;
        this.dexterity = 24;
        this.criticalChance = 0.18d;
    }
}
