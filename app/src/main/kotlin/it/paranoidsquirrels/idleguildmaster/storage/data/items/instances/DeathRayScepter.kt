package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Staff

class DeathRayScepter : Staff() {
    override fun configureProperties() {
        idName = R.string.weapon_staff_death_ray_scepter_name
        idDescription = R.string.weapon_staff_death_ray_scepter_description
        idEffect = R.string.weapon_staff_death_ray_scepter_effect
        idImage = R.drawable.death_ray_scepter
        price = 4281L
        alwaysHits = true
        intelligence = 40
    }
}
