package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Upgrade;

/* JADX INFO: loaded from: classes3.dex */
public class UpgradeTavernCapacity extends Upgrade {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.upgrade_tavern_capacity_name;
        this.idDescription = R.string.upgrade_tavern_capacity_description;
        this.idImage = R.drawable.upgrade_tavern_capacity;
        this.notSellable = true;
        this.price = 1L;
        this.gemPrice = 500;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Upgrade
    public void use() {
        MainActivity.data.setUpgradeTavernCapacity(MainActivity.data.getUpgradeTavernCapacity() + 1);
    }
}
