package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Upgrade;

/* JADX INFO: loaded from: classes3.dex */
public class UpgradeShelter extends Upgrade {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.upgrade_shelter_name;
        this.idDescription = R.string.upgrade_shelter_description;
        this.idImage = R.drawable.upgrade_shelter;
        this.notSellable = true;
        this.price = 1L;
        this.gemPrice = 500;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Upgrade
    public void use() {
        MainActivity.data.setUpgradeShelter(MainActivity.data.getUpgradeShelter() + 1);
    }
}
