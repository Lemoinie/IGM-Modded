package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import androidx.work.WorkRequest;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff;

/* JADX INFO: loaded from: classes3.dex */
public class SerpentStaff extends Staff {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_staff_serpent_staff_name;
        this.idDescription = R.string.weapon_staff_serpent_staff_description;
        this.idEffect = R.string.weapon_staff_serpent_staff_effect;
        this.idImage = R.drawable.serpent_staff;
        this.source.add(Integer.valueOf(R.string.raid_name_the_dreadful_ascent));
        this.price = WorkRequest.MIN_BACKOFF_MILLIS;
        this.uniqueOrigin = getTrueClass();
        this.notSellable = true;
        this.onTargetHit = new StatusEffect(StatusEffectType.FRENZY, null, 3, 1.0d);
        this.intelligence = 40;
        this.healingModifier = -0.5d;
    }
}
