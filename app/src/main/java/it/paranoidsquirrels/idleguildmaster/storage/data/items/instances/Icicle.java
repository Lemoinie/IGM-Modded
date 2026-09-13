package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff;

/* JADX INFO: loaded from: classes3.dex */
public class Icicle extends Staff {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_staff_icicle_name;
        this.idDescription = R.string.weapon_staff_icicle_description;
        this.idEffect = R.string.weapon_staff_icicle_effect;
        this.idImage = R.drawable.icicle;
        this.price = 2358L;
        this.onTargetHit = new StatusEffect(StatusEffectType.FROZEN, null, 1, 1.0d);
        this.intelligence = 26;
        this.constitution = 10;
        this.dexterity = 10;
    }
}
