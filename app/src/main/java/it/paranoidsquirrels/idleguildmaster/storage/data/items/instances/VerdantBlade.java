package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class VerdantBlade extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_verdant_blade_name;
        this.idDescription = R.string.weapon_dagger_verdant_blade_description;
        this.idImage = R.drawable.verdant_blade;
        this.price = 246L;
        this.dexterity = 23;
        this.constitution = 23;
    }
}
