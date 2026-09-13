package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class UnholySpellcage extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_unholy_spellcage_name;
        this.idDescription = R.string.armor_heavy_unholy_spellcage_description;
        this.idEffect = R.string.armor_heavy_unholy_spellcage_effect;
        this.idImage = R.drawable.unholy_spellcage;
        this.price = 3086L;
        this.maxHp = 320;
        this.constitution = 9;
        this.retaliationMagicalDamage = 60;
    }
}
