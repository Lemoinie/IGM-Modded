package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class AegisMechanica extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword, it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
    public boolean isRanged() {
        return true;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_aegis_mechanica_name;
        this.idDescription = R.string.weapon_sword_aegis_mechanica_description;
        this.idEffect = R.string.weapon_sword_aegis_mechanica_effect;
        this.idImage = R.drawable.aegis_mechanica;
        this.price = 234000L;
        this.onTargetHit = new StatusEffect(StatusEffectType.TAUNT, null, 2, 1.0d);
        this.maxHp = 85;
        this.defense = 10;
        this.magicDefense = 10;
    }
}
