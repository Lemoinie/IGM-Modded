package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item

/**
 * Scarlet Debris — an endgame material sheared from a Bloodstone Colossus in
 * The Sanguine Crucible. The key craft component for the Scarlet Oni Juggernaut
 * (5x Scarlet Debris replace 10x Heart of Darkness).
 */
class ScarletDebris : Item() {
    override fun configureProperties() {
        idName = R.string.item_scarlet_debris_name
        idDescription = R.string.item_scarlet_debris_description
        idImage = R.drawable.scarlet_debris
        source.add(R.string.raid_name_sanguine_crucible)
        price = 2500L
    }
}