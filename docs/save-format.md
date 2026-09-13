# Save Format Specification

## Format
- Root storage: JSON file named save.json located in app internal storage (/data/data/<package>/files/).
- Deserializer: Custom Jackson / manual parser in DataDeserializer.java.
- Serializer: Data.java writes JSON representation.

## Top-Level Schema
- save_version: Integer tracking schema version.
- money: Current gold.
- gems: Current gem count.
- dventurers: Array of adventurer state objects (stats, equipment, traits, XP, levels).
- inventory: Items in guild storage.
- dungeons: Active dungeon exploration states, floor progress, enemy waves.
- dormant fields: Several legacy/unused fields exist in the vanilla structure (edeem_m975nfu5, etc.).
