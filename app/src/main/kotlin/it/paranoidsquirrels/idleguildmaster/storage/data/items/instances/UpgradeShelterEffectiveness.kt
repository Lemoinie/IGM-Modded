package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances

import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Upgrade

/**
 * Gem-funded Shelter Effectiveness tier: grants +10% auto-feed effectiveness per
 * purchase (up to 5). Bought from the Traveling Merchant / Black Market (1,000 gems each).
 */
class UpgradeShelterEffectiveness : Upgrade() {
    override fun configureProperties() {
        idName = R.string.upgrade_shelter_effectiveness_name
        idDescription = R.string.upgrade_shelter_effectiveness_description
        idImage = R.drawable.upgrade_shelter
        notSellable = true
        price = 1L
        gemPrice = 1000
    }

    override fun use() {
        val data = MainActivity.data
        if (data.upgradeShelterEffectiveness < 5) {
            data.upgradeShelterEffectiveness++
        }
    }
}