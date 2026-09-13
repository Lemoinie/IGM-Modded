package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class CosmicViolin extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_cosmic_violin_name;
        this.idDescription = R.string.accessory_cosmic_violin_description;
        this.idEffect = R.string.accessory_cosmic_violin_effect;
        this.idImage = R.drawable.cosmic_violin;
        this.source.add(Integer.valueOf(R.string.raid_name_the_lost_expedition));
        this.price = 11111L;
        this.exaltInspireBonusTurns = 3;
        this.constitution = 25;
        this.dexterity = 25;
        this.intelligence = 25;
    }
}
