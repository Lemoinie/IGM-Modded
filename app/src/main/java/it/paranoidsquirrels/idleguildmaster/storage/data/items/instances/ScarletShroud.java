package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class ScarletShroud extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_scarlet_shroud_name;
        this.idDescription = R.string.armor_medium_scarlet_shroud_description;
        this.idEffect = R.string.armor_medium_scarlet_shroud_effect;
        this.idImage = R.drawable.scarlet_shroud;
        this.price = 135000L;
        this.maxHp = 300;
        this.constitution = 50;
        this.dexterity = 40;
        this.criticalChance = 0.21d;
        this.criticalDamage = 0.21d;
    }
}
