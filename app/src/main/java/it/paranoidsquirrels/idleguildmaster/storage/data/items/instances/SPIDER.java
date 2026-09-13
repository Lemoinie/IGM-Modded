package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class SPIDER extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_spider_name;
        this.idDescription = R.string.accessory_spider_description;
        this.idEffect = R.string.accessory_spider_effect;
        this.idImage = R.drawable.spider;
        this.source.add(Integer.valueOf(R.string.raid_name_kaunis));
        this.price = 18500L;
        this.endOfTurnAction = EndOfTurnAction.EXTRA_ATTACK_MELEE;
        this.maxHp = 20;
        this.constitution = 5;
        this.dexterity = 5;
    }
}
