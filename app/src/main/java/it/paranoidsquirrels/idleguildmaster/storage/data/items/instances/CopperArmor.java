package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class CopperArmor extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_copper_armor_name;
        this.idDescription = R.string.armor_heavy_copper_armor_description;
        this.idImage = R.drawable.copper_armor;
        this.price = 20L;
        this.maxHp = 30;
        this.constitution = 1;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    public long getSecondsToCraft() {
        if (MainActivity.data.getTutorialStep() == 4) {
            return 20L;
        }
        return super.getSecondsToCraft();
    }
}
