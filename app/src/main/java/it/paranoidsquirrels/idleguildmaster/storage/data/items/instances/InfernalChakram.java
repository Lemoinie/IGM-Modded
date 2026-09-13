package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class InfernalChakram extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger, it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
    public boolean isRanged() {
        return true;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_infernal_chakram_name;
        this.idDescription = R.string.weapon_dagger_infernal_chakram_description;
        this.idEffect = R.string.weapon_dagger_infernal_chakram_effect;
        this.idImage = R.drawable.infernal_chakram;
        this.price = 2625L;
        this.dexterity = 50;
    }
}
