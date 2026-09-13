package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class SkinBlender extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_skin_blender_name;
        this.idDescription = R.string.accessory_skin_blender_description;
        this.idEffect = R.string.accessory_skin_blender_effect;
        this.idImage = R.drawable.skin_blender;
        this.price = 987L;
        this.criticalChance = 0.15d;
        this.criticalDamage = 0.15d;
        this.constitution = 24;
        this.dexterity = 20;
    }
}
