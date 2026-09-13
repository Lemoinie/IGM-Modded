package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class ObsidianDagger extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_obsidian_dagger_name;
        this.idDescription = R.string.weapon_dagger_obsidian_dagger_description;
        this.idImage = R.drawable.obsidian_dagger;
        this.price = 306L;
        this.dexterity = 20;
        this.constitution = 20;
    }
}
