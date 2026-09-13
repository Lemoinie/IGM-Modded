package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class SerpentJaws extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_serpent_jaws_name;
        this.idDescription = R.string.weapon_sword_serpent_jaws_description;
        this.idEffect = R.string.weapon_sword_serpent_jaws_effect;
        this.idImage = R.drawable.serpent_jaws;
        this.price = 0L;
        this.counterattack = 0.35d;
        this.dexterity = 5;
    }
}
