package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances;

import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbilityType;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DoctrineOfControl extends Doctrine {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    protected void setupValues() {
        this.idName = R.string.doctrine_control_name;
        this.idDescription = R.string.doctrine_control_description;
        this.idDescriptionShort = R.string.doctrine_control_description_short;
        this.idImage = R.drawable.doctrine_of_control;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    protected List<DoctrineAbilityType> setupAbilities() {
        return Arrays.asList(DoctrineAbilityType.IMPROVED_INTELLIGENCE, DoctrineAbilityType.IMPENETRABLE_WILLPOWER, DoctrineAbilityType.MIND_BENDER, DoctrineAbilityType.CHILLING_FLOW, DoctrineAbilityType.STAR_GAZE, DoctrineAbilityType.ARCANE_SUPPRESSION);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusQuestPoints() {
        return MainActivity.data.getControlLevel();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusIntelligence() {
        return getValue(DoctrineAbilityType.IMPROVED_INTELLIGENCE);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusStatusImmunity() {
        return getValue(DoctrineAbilityType.IMPENETRABLE_WILLPOWER);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int ignoreEnemyImmunities() {
        return getValue(DoctrineAbilityType.MIND_BENDER);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int freezeOnHit() {
        return getValue(DoctrineAbilityType.CHILLING_FLOW);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int petrifyOnHit() {
        return getValue(DoctrineAbilityType.STAR_GAZE);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int damagePerTurnPerStatus() {
        return getValue(DoctrineAbilityType.ARCANE_SUPPRESSION);
    }
}
