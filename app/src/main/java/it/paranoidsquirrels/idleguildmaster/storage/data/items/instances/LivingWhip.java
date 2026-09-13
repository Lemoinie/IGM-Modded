package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class LivingWhip extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword, it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
    public boolean isRanged() {
        return true;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_living_whip_name;
        this.idDescription = R.string.weapon_sword_living_whip_description;
        this.idEffect = R.string.weapon_sword_living_whip_effect;
        this.idImage = R.drawable.living_whip;
        this.price = 567L;
        this.onTargetHit = new StatusEffect(StatusEffectType.TAUNT, null, 1, 0.65d);
        this.maxHp = 40;
        this.dexterity = 12;
    }
}
