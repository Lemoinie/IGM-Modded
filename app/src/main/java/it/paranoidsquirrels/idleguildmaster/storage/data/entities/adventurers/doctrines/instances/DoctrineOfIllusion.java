package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances;

import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbilityType;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DoctrineOfIllusion extends Doctrine {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    protected void setupValues() {
        this.idName = R.string.doctrine_illusion_name;
        this.idDescription = R.string.doctrine_illusion_description;
        this.idDescriptionShort = R.string.doctrine_illusion_description_short;
        this.idImage = R.drawable.doctrine_of_illusion;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    protected List<DoctrineAbilityType> setupAbilities() {
        return Arrays.asList(DoctrineAbilityType.IMPROVED_DEXTERITY, DoctrineAbilityType.IMPROVED_INTELLIGENCE, DoctrineAbilityType.EPHEMERAL_PRESENCE, DoctrineAbilityType.BEAT_THE_ODDS, DoctrineAbilityType.FALSE_LIFE, DoctrineAbilityType.TRUE_AGONY);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusQuestPoints() {
        return MainActivity.data.getIllusionLevel();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusDexterity() {
        return getValue(DoctrineAbilityType.IMPROVED_DEXTERITY);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusIntelligence() {
        return getValue(DoctrineAbilityType.IMPROVED_INTELLIGENCE);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusDodgeChance() {
        return getValue(DoctrineAbilityType.EPHEMERAL_PRESENCE);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public boolean rollDamageThreeTimes() {
        return getValue(DoctrineAbilityType.BEAT_THE_ODDS) > 0;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int falseLifeChance() {
        return getValue(DoctrineAbilityType.FALSE_LIFE);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int damageOnFalseLifeRemoval() {
        return getValue(DoctrineAbilityType.TRUE_AGONY);
    }
}
