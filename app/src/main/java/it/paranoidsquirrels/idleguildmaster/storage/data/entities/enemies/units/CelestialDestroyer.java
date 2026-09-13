package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.units;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.EndOfTurnAction;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CelestialDestroyer extends Enemy {
    private List<EndOfTurnAction> endOfTurnActions;

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMaxDamage() {
        return Logger.BARD_SHIELD;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected int getMinDamage() {
        return 100;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean isMagic() {
        return false;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public boolean isRanged() {
        return true;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    protected void configureStatistics() {
        this.baseMaxHp = 4000;
        this.baseConstitution = 200;
        this.baseIntelligence = 1;
        this.baseDexterity = 62;
        this.baseDefense = 20;
        this.baseMagicDefense = 20;
        this.team = 1;
        this.imageId = R.drawable.unit_celestial_destroyer;
        this.idName = R.string.enemy_celestial_destroyer_name;
        this.idDescription = R.string.enemy_celestial_destroyer_description;
        this.flying = true;
        this.endOfTurnActions = Collections.nCopies(5, EndOfTurnAction.EXTRA_ATTACK_90);
        this.passiveSkill = Skills.PASSIVE_FLYING_FORTRESS;
        this.activeSkill = Skills.ACTIVE_NONE;
        this.rarity = 1;
        this.expGiven = 2400;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy, it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
    public List<EndOfTurnAction> endOfTurnActions() {
        return this.endOfTurnActions;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
    public LinkedHashMap<ItemWrapper, Integer> listDrops(int i) {
        LinkedHashMap<ItemWrapper, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ItemWrapper.getInstance("CelestialScraps", 3), 600);
        linkedHashMap.put(ItemWrapper.getInstance("AetherIgnis", 1), 400);
        return linkedHashMap;
    }
}
