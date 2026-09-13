package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class GiantTortoise extends Enemy {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return 55;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 40;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean isMagic() {
        return false;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean isRanged() {
        return false;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected void configureStatistics() {
        this.baseMaxHp = 1400;
        this.baseConstitution = 60;
        this.baseIntelligence = 2;
        this.baseDexterity = 1;
        this.baseDefense = 50;
        this.baseMagicDefense = 0;
        this.onSelfHit = new StatusEffect(StatusEffectType.BLEED, this, 25, 1.0d);
        this.imageId = R.drawable.unit_giant_tortoise;
        this.idName = R.string.enemy_giant_tortoise_name;
        this.idDescription = R.string.enemy_giant_tortoise_description;
        this.passiveSkill = Skills.PASSIVE_SHARP_SPIKES;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.rarity = 1;
        this.expGiven = 70;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("GiantShellFragment", 1), 500);
        linkedHashMap.put(ItemWrapper.getInstance("TortoiseThorn", 1), 50);
        linkedHashMap.put(ItemWrapper.getInstance("Egg", 1), 25);
        linkedHashMap.put(ItemWrapper.getInstance("ReptileEgg", 1), 1);
        return linkedHashMap;
    }
}
