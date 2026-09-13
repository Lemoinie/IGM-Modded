package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import androidx.work.WorkRequest;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class ColossalSword extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_colossal_sword_name;
        this.idDescription = R.string.weapon_sword_colossal_sword_description;
        this.idEffect = R.string.weapon_sword_colossal_sword_effect;
        this.idImage = R.drawable.colossal_sword;
        this.source.add(Integer.valueOf(R.string.raid_name_the_cultist_rebels));
        this.price = WorkRequest.MIN_BACKOFF_MILLIS;
        this.constitution = 50;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword, it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
    public int getDamageModifier(int i, int i2, int i3) {
        return i >= 120 ? i : i / 2;
    }
}
