package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;

/* JADX INFO: loaded from: classes3.dex */
public class ReassemblingJacket extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_reassembling_jacket_name;
        this.idDescription = R.string.armor_medium_reassembling_jacket_description;
        this.idEffect = R.string.armor_medium_reassembling_jacket_effect;
        this.idImage = R.drawable.reassembling_jacket;
        this.price = 2088L;
        this.immunityToStatus = 0.3d;
        this.regeneration = 40;
        this.maxHp = 200;
        this.constitution = 25;
        this.dexterity = 7;
    }
}
