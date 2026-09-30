package it.paranoidsquirrels.idleguildmaster.storage.data.places

/**
 * A persisted snapshot of one hero's equipped gear for a Dungeon/Raid area.
 * Stores the item class names (e.g. "AegisMechanica", "NilArmor", "JeweledCrown"),
 * resolving via `Item.getInstance(name)`. All fields default to null so older saves
 * and empty snapshots deserialize without custom handling.
 */
data class SavedEquipment(
    var weapon: String? = null,
    var armor: String? = null,
    var accessory: String? = null
)