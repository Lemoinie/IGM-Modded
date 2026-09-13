package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import androidx.work.WorkRequest;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow;

/* JADX INFO: loaded from: classes3.dex */
public class SerpentSting extends Bow {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_bow_serpent_sting_name;
        this.idDescription = R.string.weapon_bow_serpent_sting_description;
        this.idEffect = R.string.weapon_bow_serpent_sting_effect;
        this.idImage = R.drawable.serpent_sting;
        this.price = WorkRequest.MIN_BACKOFF_MILLIS;
        this.source.add(Integer.valueOf(R.string.raid_name_the_dire_descent));
        this.uniqueOrigin = getTrueClass();
        this.notSellable = true;
        this.endOfTurnAction = EndOfTurnAction.STUN_SELF_NOT_CLEANSABLE;
        this.dexterity = 40;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Bow, it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
    public int getDamageModifier(int i, int i2, int i3) {
        return super.getDamageModifier(i, i2, i3) * 3;
    }
}
