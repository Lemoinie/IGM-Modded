package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Accessory;

/* JADX INFO: loaded from: classes3.dex */
public class SpellCompendium extends Accessory {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.accessory_spell_compendium_name;
        this.idDescription = R.string.accessory_spell_compendium_description;
        this.idImage = R.drawable.spell_compendium;
        this.source.add(Integer.valueOf(R.string.dungeon_name_hidden_city_of_larox));
        this.price = 40L;
        this.intelligence = 30;
    }
}
