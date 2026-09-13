package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances;

import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbilityType;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DoctrineOfWar extends Doctrine {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    protected void setupValues() {
        this.idName = R.string.doctrine_war_name;
        this.idDescription = R.string.doctrine_war_description;
        this.idDescriptionShort = R.string.doctrine_war_description_short;
        this.idImage = R.drawable.doctrine_of_war;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    protected List<DoctrineAbilityType> setupAbilities() {
        return Arrays.asList(DoctrineAbilityType.IMPROVED_CONSTITUTION, DoctrineAbilityType.IMPROVED_DEXTERITY, DoctrineAbilityType.CONDITIONED_REFLEXES, DoctrineAbilityType.TACTICAL_KNOWLEDGE, DoctrineAbilityType.RELENTLESS_ASSAULT, DoctrineAbilityType.WEAPON_MASTER);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusQuestPoints() {
        return MainActivity.data.getWarLevel();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusConstitution() {
        return getValue(DoctrineAbilityType.IMPROVED_CONSTITUTION);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusDexterity() {
        return getValue(DoctrineAbilityType.IMPROVED_DEXTERITY);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusCounterattack() {
        return getValue(DoctrineAbilityType.CONDITIONED_REFLEXES);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int ignoreArmorPercentage() {
        return getValue(DoctrineAbilityType.TACTICAL_KNOWLEDGE);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public boolean forcesCounterattack() {
        return getValue(DoctrineAbilityType.RELENTLESS_ASSAULT) > 0;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public boolean canUseAllWeapons() {
        return getValue(DoctrineAbilityType.WEAPON_MASTER) > 0;
    }
}
