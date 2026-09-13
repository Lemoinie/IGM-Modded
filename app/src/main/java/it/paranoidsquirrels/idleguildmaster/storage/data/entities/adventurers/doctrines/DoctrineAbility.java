package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class DoctrineAbility {
    private int level;
    private DoctrineAbilityType type;

    public DoctrineAbility(DoctrineAbilityType doctrineAbilityType, int i) {
        this.type = doctrineAbilityType;
        this.level = i;
    }

    public DoctrineAbilityType getType() {
        return this.type;
    }

    public void setType(DoctrineAbilityType doctrineAbilityType) {
        this.type = doctrineAbilityType;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public int getValue() {
        return this.level * this.type.increasePerLevel;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DoctrineAbility) && this.type == ((DoctrineAbility) obj).type;
    }

    public int hashCode() {
        return Objects.hash(this.type);
    }
}
