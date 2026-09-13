package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances;

import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbilityType;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DoctrineOfRuin extends Doctrine {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    protected void setupValues() {
        this.idName = R.string.doctrine_ruin_name;
        this.idDescription = R.string.doctrine_ruin_description;
        this.idDescriptionShort = R.string.doctrine_ruin_description_short;
        this.idImage = R.drawable.doctrine_of_ruin;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    protected List<DoctrineAbilityType> setupAbilities() {
        return Arrays.asList(DoctrineAbilityType.IMPROVED_DEXTERITY, DoctrineAbilityType.EXPOSE_WEAKNESS, DoctrineAbilityType.EXPLOIT_WEAKNESS, DoctrineAbilityType.LIGHTNING_SPEED, DoctrineAbilityType.EYE_FOR_AN_EYE, DoctrineAbilityType.RAGEBOUND);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusQuestPoints() {
        return MainActivity.data.getRuinLevel();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusDexterity() {
        return getValue(DoctrineAbilityType.IMPROVED_DEXTERITY);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusCritChance() {
        return getValue(DoctrineAbilityType.EXPOSE_WEAKNESS);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusCritDamage() {
        return getValue(DoctrineAbilityType.EXPLOIT_WEAKNESS);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int extraAttackChance() {
        return getValue(DoctrineAbilityType.LIGHTNING_SPEED);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public boolean moreDamageWhenHalfLife() {
        return getValue(DoctrineAbilityType.EYE_FOR_AN_EYE) > 0;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public boolean moreDamageDealtAndTaken() {
        return getValue(DoctrineAbilityType.RAGEBOUND) > 0;
    }
}
