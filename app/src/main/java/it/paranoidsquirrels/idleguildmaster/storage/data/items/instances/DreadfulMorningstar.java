package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Sword;

/* JADX INFO: loaded from: classes3.dex */
public class DreadfulMorningstar extends Sword {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.weapon_sword_dreadful_morningstar_name;
        this.idDescription = R.string.weapon_sword_dreadful_morningstar_description;
        this.idEffect = R.string.weapon_sword_dreadful_morningstar_effect;
        this.idImage = R.drawable.dreadful_morningstar;
        this.source.add(Integer.valueOf(R.string.raid_name_the_tower));
        this.price = 20000L;
        this.onTargetHit = new StatusEffect(StatusEffectType.TERRIFY, null, 1, 0.18d);
        this.constitution = 40;
        this.dexterity = 10;
    }
}
