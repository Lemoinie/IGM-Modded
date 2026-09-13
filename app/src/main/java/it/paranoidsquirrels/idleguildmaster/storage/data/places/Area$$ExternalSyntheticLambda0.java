package it.paranoidsquirrels.idleguildmaster.storage.data.places;

import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class Area$$ExternalSyntheticLambda0 implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return ((Adventurer) obj).isSummonedMinion();
    }
}
