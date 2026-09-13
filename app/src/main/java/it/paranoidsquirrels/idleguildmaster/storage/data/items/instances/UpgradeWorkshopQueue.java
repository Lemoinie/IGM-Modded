package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Upgrade;

/* JADX INFO: loaded from: classes3.dex */
public class UpgradeWorkshopQueue extends Upgrade {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.upgrade_workshop_queue_name;
        this.idDescription = R.string.upgrade_workshop_queue_description;
        this.idImage = R.drawable.upgrade_workshop_queue;
        this.notSellable = true;
        this.price = 1L;
        this.gemPrice = 500;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Upgrade
    public void use() {
        MainActivity.data.setUpgradeWorkshopQueue(MainActivity.data.getUpgradeWorkshopQueue() + 1);
    }
}
