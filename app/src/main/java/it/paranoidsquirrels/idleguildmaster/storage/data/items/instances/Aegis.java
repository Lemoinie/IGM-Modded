package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class Aegis extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_aegis_name;
        this.idDescription = R.string.weapon_sword_aegis_description;
        this.idEffect = R.string.weapon_sword_aegis_effect;
        this.idImage = R.drawable.aegis;
        this.price = 150000L;
        this.onTargetHit = new StatusEffect(StatusEffectType.TAUNT, null, 2, 1.0d);
        this.maxHp = 60;
        this.defense = 10;
        this.magicDefense = 10;
    }
}
