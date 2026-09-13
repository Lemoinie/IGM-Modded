# Known Uncertainties

## Tracking List

### 1. Area.cast(Entity) Disassembly
- **Status**: Open / Investigation in progress.
- **Context**: JADX failed to produce Java code for the skill dispatcher method due to SSA variable elimination conflicts.
- **Reference**: eference/clean_apk/smali_classes3/it/paranoidsquirrels/idleguildmaster/storage/data/places/Area.smali (~line 1440).
- **Resolution Path**: Decode the packed-switch / sparse-switch table from smali into Java switch cases mapping skill identifiers to combat calculations.

### 2. AdMob & Play Billing Stubs
- **Status**: Planned for Stage 1.
- **Context**: User directed that ads and billing be temporarily disabled and hidden from the UI, but interfaces preserved so calling code compiles.
- **Resolution Path**: Implement lightweight offline stubs for IAPWrapper and ad listeners that return graceful defaults (no ads available, billing disconnected).

### 3. DataBinding Generation vs JADX Output
- **Status**: Under evaluation.
- **Context**: JADX extracts generated databinding/ classes (ActivityMainBindingImpl.java, etc.). In a standard Gradle build, AGP regenerates these from XML layouts.
- **Resolution Path**: Exclude decompiled it.paranoidsquirrels.idleguildmaster.databinding from the Java source tree to allow AGP to generate them cleanly, avoiding duplicate class collisions.
