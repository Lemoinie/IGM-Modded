package it.paranoidsquirrels.idleguildmaster.storage.data.places

data class EnemyCounter @JvmOverloads constructor(
    var enemy: String? = null,
    var timesSlain: Int = 0
)
