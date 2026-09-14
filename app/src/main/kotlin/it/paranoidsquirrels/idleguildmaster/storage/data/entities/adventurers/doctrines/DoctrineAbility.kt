package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines

class DoctrineAbility @JvmOverloads constructor(
    var type: DoctrineAbilityType? = null,
    var level: Int = 0
) {
    fun getValue(): Int {
        val t = type ?: return 0
        return level * t.increasePerLevel
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DoctrineAbility) return false
        return type == other.type
    }

    override fun hashCode(): Int {
        return type?.hashCode() ?: 0
    }
}
