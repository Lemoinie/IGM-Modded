package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow;

/* JADX INFO: loaded from: classes3.dex */
public class BansheeScream extends Bow {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_bow_banshee_scream_name;
        this.idDescription = R.string.weapon_bow_banshee_scream_description;
        this.idEffect = R.string.weapon_bow_banshee_scream_effect;
        this.idImage = R.drawable.banshee_scream;
        this.price = 3152L;
        this.criticalChance = 0.1d;
        this.dexterity = 38;
        this.intelligence = 12;
    }
}
