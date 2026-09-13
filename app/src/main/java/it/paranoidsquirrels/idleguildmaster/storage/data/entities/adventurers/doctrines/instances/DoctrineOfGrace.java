package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances;

import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbilityType;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DoctrineOfGrace extends Doctrine {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    protected void setupValues() {
        this.idName = R.string.doctrine_grace_name;
        this.idDescription = R.string.doctrine_grace_description;
        this.idDescriptionShort = R.string.doctrine_grace_description_short;
        this.idImage = R.drawable.doctrine_of_grace;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    protected List<DoctrineAbilityType> setupAbilities() {
        return Arrays.asList(DoctrineAbilityType.IMPROVED_HEALTH, DoctrineAbilityType.IMPROVED_INTELLIGENCE, DoctrineAbilityType.SELFLESS_SPIRIT, DoctrineAbilityType.DIVINE_INTERVENTION, DoctrineAbilityType.OVERHEAL, DoctrineAbilityType.HEALING_NOVA);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusQuestPoints() {
        return MainActivity.data.getGraceLevel();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusHp() {
        return getValue(DoctrineAbilityType.IMPROVED_HEALTH);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusIntelligence() {
        return getValue(DoctrineAbilityType.IMPROVED_INTELLIGENCE);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusResurrectionChance() {
        return getValue(DoctrineAbilityType.DIVINE_INTERVENTION);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusHealingModifier() {
        return getValue(DoctrineAbilityType.SELFLESS_SPIRIT);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int maxOverheal() {
        return getValue(DoctrineAbilityType.OVERHEAL);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int healingNova() {
        return getValue(DoctrineAbilityType.HEALING_NOVA);
    }
}
