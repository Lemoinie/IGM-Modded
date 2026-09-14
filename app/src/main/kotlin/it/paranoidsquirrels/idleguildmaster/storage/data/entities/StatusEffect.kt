package it.paranoidsquirrels.idleguildmaster.storage.data.entities

class StatusEffect @JvmOverloads constructor(
    var type: StatusEffectType? = null,
    @Transient var cause: Entity? = null,
    var turnsLeft: Int = 0,
    @Transient var probability: Double = 0.0
) {
    companion object {
        const val DURATION_LONG: Int = 999
        @JvmField
        val STATIC_INSTANCE_FROZEN: StatusEffect = StatusEffect(StatusEffectType.FROZEN, null, 0, 0.0)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StatusEffect) return false
        return type == other.type
    }

    override fun hashCode(): Int {
        return type?.hashCode() ?: 0
    }
}
