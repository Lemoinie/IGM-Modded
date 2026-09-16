package it.paranoidsquirrels.idleguildmaster.game.activities

import com.google.gson.annotations.SerializedName

class GuildActivitiesState {
    companion object {
        const val STATUS_ACTIVE = 0
        const val STATUS_COMPLETED = 1
        const val STATUS_FAILED = 2
    }

    @SerializedName("requestDayBoundary")
    var requestDayBoundary: Long = 0L

    @SerializedName("requestStatus")
    var requestStatus: Int = STATUS_ACTIVE

    @SerializedName("requestRewardClaimed")
    var requestRewardClaimed: Boolean = false

    @SerializedName("siegeWeekBoundary")
    var siegeWeekBoundary: Long = 0L

    @SerializedName("siegeStatus")
    var siegeStatus: Int = STATUS_ACTIVE

    @SerializedName("siegeWavesCleared")
    var siegeWavesCleared: Int = 0
}
