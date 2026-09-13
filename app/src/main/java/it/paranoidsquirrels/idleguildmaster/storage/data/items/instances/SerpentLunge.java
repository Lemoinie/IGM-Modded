package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import androidx.work.WorkRequest;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Dagger;

/* JADX INFO: loaded from: classes3.dex */
public class SerpentLunge extends Dagger {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_dagger_serpent_lunge_name;
        this.idDescription = R.string.weapon_dagger_serpent_lunge_description;
        this.idEffect = R.string.weapon_dagger_serpent_lunge_effect;
        this.idImage = R.drawable.serpent_lunge;
        this.price = WorkRequest.MIN_BACKOFF_MILLIS;
        this.source.add(Integer.valueOf(R.string.raid_name_the_dire_descent));
        this.uniqueOrigin = getTrueClass();
        this.notSellable = true;
        this.flatDodgeChance = 0.1d;
        this.dexterity = 25;
        this.constitution = 25;
    }
}
