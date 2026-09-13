package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class LivingScimitar extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_living_scimitar_name;
        this.idDescription = R.string.weapon_sword_living_scimitar_description;
        this.idEffect = R.string.weapon_sword_living_scimitar_effect;
        this.idImage = R.drawable.living_scimitar;
        this.price = 227L;
        this.constitution = 10;
        this.magicDefense = 5;
        this.counterattack = 0.1d;
    }
}
