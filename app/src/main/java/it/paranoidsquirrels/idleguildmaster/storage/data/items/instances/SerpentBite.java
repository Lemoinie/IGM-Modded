package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import androidx.work.WorkRequest;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class SerpentBite extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_serpent_bite_name;
        this.idDescription = R.string.weapon_sword_serpent_bite_description;
        this.idEffect = R.string.weapon_sword_serpent_bite_effect;
        this.idImage = R.drawable.serpent_bite;
        this.price = WorkRequest.MIN_BACKOFF_MILLIS;
        this.source.add(Integer.valueOf(R.string.raid_name_the_dire_descent));
        this.uniqueOrigin = getTrueClass();
        this.notSellable = true;
        this.threat = -4;
        this.constitution = 30;
        this.dexterity = 10;
    }
}
