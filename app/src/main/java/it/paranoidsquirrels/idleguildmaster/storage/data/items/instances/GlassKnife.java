package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class GlassKnife extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_glass_knife_name;
        this.idDescription = R.string.weapon_dagger_glass_knife_description;
        this.idImage = R.drawable.glass_knife;
        this.price = 56L;
        this.constitution = 5;
        this.dexterity = 5;
    }
}
