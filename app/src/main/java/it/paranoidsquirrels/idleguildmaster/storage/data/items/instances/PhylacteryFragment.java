package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;

/* JADX INFO: loaded from: classes3.dex */
public class PhylacteryFragment extends Item {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.item_phylactery_fragment_name;
        this.idDescription = R.string.item_phylactery_fragment_description;
        this.idImage = R.drawable.phylactery_fragment;
        this.source.add(Integer.valueOf(R.string.raid_name_ancient_grave_digging));
        this.price = 450L;
    }
}
