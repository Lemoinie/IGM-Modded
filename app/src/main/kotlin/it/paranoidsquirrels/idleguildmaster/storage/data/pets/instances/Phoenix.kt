package it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances

import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.abstractClasses.Mythic

/** Phoenix (display name "Kiara") — Mythic pet whose 5th trait is Solar Rebirth. */
class Phoenix : Mythic() {
    init {
        trueClass = "Phoenix"
    }

    override fun configureStatistics() {
        idImage = R.drawable.pet_phoenix
        idName = R.string.pet_phoenix_name
        idDescription = R.string.pet_phoenix_description
        abilityNumber = 5
    }

    /** Solar Rebirth trigger chance each combat turn: 0.15% per level (7.5% at Lv 50, 15% at Lv 100). */
    fun getSolarRebirthChance(): Double = level * 0.0015

    /** Allies protected/revived by Solar Rebirth each proc: 1 + floor(level / 50). */
    fun getSolarRebirthTargetCount(): Int = 1 + (level / 50)
}