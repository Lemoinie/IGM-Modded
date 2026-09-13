package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances;

import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbilityType;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DoctrineOfAffliction extends Doctrine {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    protected void setupValues() {
        this.idName = R.string.doctrine_affliction_name;
        this.idDescription = R.string.doctrine_affliction_description;
        this.idDescriptionShort = R.string.doctrine_affliction_description_short;
        this.idImage = R.drawable.doctrine_of_affliction;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    protected List<DoctrineAbilityType> setupAbilities() {
        return Arrays.asList(DoctrineAbilityType.IMPROVED_HEALTH, DoctrineAbilityType.IMPROVED_DEXTERITY, DoctrineAbilityType.NECROSIS_PORPHYRICA, DoctrineAbilityType.SERVUS_SANGUINIS, DoctrineAbilityType.SERVUS_UMBRAE, DoctrineAbilityType.GENUS_VAMPYRI);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusQuestPoints() {
        return MainActivity.data.getAfflictionLevel();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusHp() {
        return getValue(DoctrineAbilityType.IMPROVED_HEALTH);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusDexterity() {
        return getValue(DoctrineAbilityType.IMPROVED_DEXTERITY);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int reduceCriticalBonusDamage() {
        return getValue(DoctrineAbilityType.NECROSIS_PORPHYRICA);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusLifesteal() {
        return getValue(DoctrineAbilityType.SERVUS_SANGUINIS);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int darknessDamageIncrease() {
        return getValue(DoctrineAbilityType.SERVUS_UMBRAE);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int maxLifestealOverheal() {
        return getValue(DoctrineAbilityType.GENUS_VAMPYRI);
    }
}
