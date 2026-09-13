package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances;

import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.DoctrineAbilityType;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DoctrineOfKnowledge extends Doctrine {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    protected void setupValues() {
        this.idName = R.string.doctrine_knowledge_name;
        this.idDescription = R.string.doctrine_knowledge_description;
        this.idDescriptionShort = R.string.doctrine_knowledge_description_short;
        this.idImage = R.drawable.doctrine_of_knowlegde;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    protected List<DoctrineAbilityType> setupAbilities() {
        return Arrays.asList(DoctrineAbilityType.EXALTED_CONSTITUTION, DoctrineAbilityType.EXALTED_DEXTERITY, DoctrineAbilityType.EXALTED_INTELLIGENCE, DoctrineAbilityType.EXALTED_HEALTH, DoctrineAbilityType.EXALTED_MANA, DoctrineAbilityType.LORE_MASTER);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusQuestPoints() {
        return MainActivity.data.getKnowledgeLevel();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusConstitution() {
        return getValue(DoctrineAbilityType.EXALTED_CONSTITUTION);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusHp() {
        return getValue(DoctrineAbilityType.EXALTED_HEALTH);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusDexterity() {
        return getValue(DoctrineAbilityType.EXALTED_DEXTERITY);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusIntelligence() {
        return getValue(DoctrineAbilityType.EXALTED_INTELLIGENCE);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public int bonusManaRegen() {
        return getValue(DoctrineAbilityType.EXALTED_MANA);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
    public boolean doubleAccessoryStats() {
        return getValue(DoctrineAbilityType.LORE_MASTER) > 0;
    }
}
