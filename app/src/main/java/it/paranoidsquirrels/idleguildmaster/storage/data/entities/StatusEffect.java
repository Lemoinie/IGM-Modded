package it.paranoidsquirrels.idleguildmaster.storage.data.entities;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class StatusEffect {
    public static final int DURATION_LONG = 999;
    public static final StatusEffect STATIC_INSTANCE_FROZEN = new StatusEffect(StatusEffectType.FROZEN, null, 0, 0.0d);
    private transient Entity cause;
    private transient double probability;
    private int turnsLeft;
    private StatusEffectType type;

    public StatusEffect(StatusEffectType statusEffectType, Entity entity, int i, double d) {
        this.type = statusEffectType;
        this.cause = entity;
        this.turnsLeft = i;
        this.probability = d;
    }

    public StatusEffectType getType() {
        return this.type;
    }

    public void setType(StatusEffectType statusEffectType) {
        this.type = statusEffectType;
    }

    public Entity getCause() {
        return this.cause;
    }

    public void setCause(Entity entity) {
        this.cause = entity;
    }

    public int getTurnsLeft() {
        return this.turnsLeft;
    }

    public void setTurnsLeft(int i) {
        this.turnsLeft = i;
    }

    public double getProbability() {
        return this.probability;
    }

    public void setProbability(double d) {
        this.probability = d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StatusEffect) && this.type == ((StatusEffect) obj).type;
    }

    public int hashCode() {
        return Objects.hash(this.type);
    }
}
