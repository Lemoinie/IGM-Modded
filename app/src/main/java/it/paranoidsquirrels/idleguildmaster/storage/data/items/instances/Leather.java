package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class Leather extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_leather_name;
        this.idDescription = R.string.item_leather_description;
        this.idImage = R.drawable.leather;
        this.price = 3L;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    public long getSecondsToCraft() {
        if (MainActivity.data.getTutorialStep() == 3) {
            return 10L;
        }
        return super.getSecondsToCraft();
    }
}
