package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances;

import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbilityType;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DoctrineOfFortitude extends Doctrine {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    protected void setupValues() {
        this.idName = R.string.doctrine_fortitude_name;
        this.idDescription = R.string.doctrine_fortitude_description;
        this.idDescriptionShort = R.string.doctrine_fortitude_description_short;
        this.idImage = R.drawable.doctrine_of_fortitude;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    protected List<DoctrineAbilityType> setupAbilities() {
        return Arrays.asList(DoctrineAbilityType.IMPROVED_HEALTH, DoctrineAbilityType.IMPROVED_CONSTITUTION, DoctrineAbilityType.MANIFEST_DANGER, DoctrineAbilityType.TROLL_RESISTANCE, DoctrineAbilityType.WARLOCK_RESILIENCE, DoctrineAbilityType.MIRROR_OF_ANGUISH);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusQuestPoints() {
        return MainActivity.data.getFortitudeLevel();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusConstitution() {
        return getValue(DoctrineAbilityType.IMPROVED_CONSTITUTION);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusHp() {
        return getValue(DoctrineAbilityType.IMPROVED_HEALTH);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusThreat() {
        return getValue(DoctrineAbilityType.MANIFEST_DANGER);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusDefense() {
        return getValue(DoctrineAbilityType.TROLL_RESISTANCE);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusMagicDefense() {
        return getValue(DoctrineAbilityType.WARLOCK_RESILIENCE);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public boolean addsDefensesToRetaliate() {
        return getValue(DoctrineAbilityType.MIRROR_OF_ANGUISH) > 0;
    }
}
