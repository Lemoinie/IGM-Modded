package it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Egg extends Consumable {
    public abstract Pet hatch();

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable, it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    public int printType() {
        return R.string.type_egg;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable
    public int printConsumeImage() {
        return R.drawable.consume_egg;
    }
}
