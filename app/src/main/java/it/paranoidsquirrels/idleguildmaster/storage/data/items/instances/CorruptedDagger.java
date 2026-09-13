package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class CorruptedDagger extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_corrupted_dagger_name;
        this.idDescription = R.string.weapon_dagger_corrupted_dagger_description;
        this.idImage = R.drawable.corrupted_dagger;
        this.source.add(Integer.valueOf(R.string.dungeon_name_the_golden_city));
        this.price = 1L;
        this.dexterity = 1;
    }
}
