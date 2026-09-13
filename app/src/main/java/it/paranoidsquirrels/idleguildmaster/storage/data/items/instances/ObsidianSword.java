package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class ObsidianSword extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_obsidian_sword_name;
        this.idDescription = R.string.weapon_sword_obsidian_sword_description;
        this.idImage = R.drawable.obsidian_sword;
        this.price = 324L;
        this.constitution = 21;
        this.dexterity = 7;
    }
}
