package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers

enum class PotionDrinkerType(
    @JvmField val constitution: Double,
    @JvmField val dexterity: Double,
    @JvmField val intelligence: Double,
    @JvmField val health: Double,
    @JvmField val defense: Double,
    @JvmField val magicDefense: Double,
    @JvmField val precision: Double,
    @JvmField val viciousness: Double,
    @JvmField val darkness: Double,
    @JvmField val immunity: Double,
    @JvmField val agility: Double
) {
    NONE(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0),
    WARRIOR(9.0, 3.0, 1.0, 10.0, 5.0, 5.0, 2.0, 2.0, 3.0, 15.0, 3.0),
    ARCHER(4.0, 10.0, 4.0, 5.0, 3.0, 3.0, 6.0, 6.0, 4.0, 3.0, 6.0),
    THIEF(7.0, 7.0, 4.0, 5.0, 3.0, 3.0, 8.0, 4.0, 6.0, 1.0, 6.0),
    MAGE(3.0, 3.0, 14.0, 3.0, 1.0, 5.0, 2.0, 6.0, 4.0, 10.0, 3.0);

    companion object {
        private const val STANDARD_STEP = 0.02857142857142857
    }

    fun getMaxAmount(i: Int, i2: Int, z: Boolean): Double {
        return if (!z) {
            getMaxAmountPreAscension(i, i2)
        } else {
            getMaxAmountPreAscension(i, 45) + getIncreasedAmountPostAscension(i, i2)
        }
    }

    private fun getMaxAmountPreAscension(i: Int, i2: Int): Double {
        val d = when (i) {
            0 -> this.constitution
            1 -> this.dexterity
            2 -> this.intelligence
            3 -> this.health
            4 -> this.defense
            5 -> this.magicDefense
            6 -> this.precision
            7 -> this.viciousness
            8 -> this.darkness
            9 -> this.immunity
            10 -> this.agility
            else -> 0.0
        }
        val d2 = i2.toDouble() * STANDARD_STEP
        return d * d2
    }

    private fun getIncreasedAmountPostAscension(i: Int, i2: Int): Double {
        var d2 = i2.toDouble() * STANDARD_STEP
        val d: Double
        when (i) {
            0 -> d = this.constitution
            1 -> d = this.dexterity
            2 -> d = this.intelligence
            3 -> d = this.health
            4, 5 -> {
                d2 = 1.0
                d = 1.0
            }
            6 -> {
                d = this.precision
                d2 *= 0.5
            }
            7 -> {
                d = this.viciousness
                d2 *= 0.5
            }
            8 -> {
                d = this.darkness
                d2 *= 0.5
            }
            9 -> {
                d = this.immunity
                d2 *= 0.5
            }
            10 -> {
                d = this.agility
                d2 *= 0.5
            }
            else -> d = 0.0
        }
        return d * d2
    }
}
