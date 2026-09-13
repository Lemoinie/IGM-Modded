package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class ChampionArmor extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_champion_armor_name;
        this.idDescription = R.string.armor_heavy_champion_armor_description;
        this.idEffect = R.string.armor_heavy_champion_armor_effect;
        this.idImage = R.drawable.champion_armor;
        this.price = 13300L;
        this.maxHp = Logger.BARD_SHIELD;
        this.constitution = 28;
        this.counterattack = 0.4d;
    }
}
