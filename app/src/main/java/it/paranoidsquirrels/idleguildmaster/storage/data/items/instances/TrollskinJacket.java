package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.MediumArmor;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class TrollskinJacket extends MediumArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_medium_trollskin_jacket_name;
        this.idDescription = R.string.armor_medium_trollskin_jacket_description;
        this.idEffect = R.string.armor_medium_trollskin_jacket_effect;
        this.idImage = R.drawable.trollskin_jacket;
        this.price = 306L;
        this.maxHp = Logger.BARD_SHIELD;
        this.constitution = 5;
        this.dexterity = 5;
        this.regeneration = 6;
    }
}
