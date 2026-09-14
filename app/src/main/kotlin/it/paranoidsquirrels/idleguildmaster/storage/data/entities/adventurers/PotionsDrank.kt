package it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers

data class PotionsDrank @JvmOverloads constructor(
    var potionOfConstitutionDrank: Int = 0,
    var potionOfDexterityDrank: Int = 0,
    var potionOfIntelligenceDrank: Int = 0,
    var potionOfHealthDrank: Int = 0,
    var potionOfDefenseDrank: Int = 0,
    var potionOfMagicDefenseDrank: Int = 0,
    var potionOfPrecisionDrank: Int = 0,
    var potionOfViciousnessDrank: Int = 0,
    var potionOfDarknessDrank: Int = 0,
    var potionOfImmunityDrank: Int = 0,
    var potionOfAgilityDrank: Int = 0
) {
    fun increase(type: Int) {
        when (type) {
            0 -> potionOfConstitutionDrank++
            1 -> potionOfDexterityDrank++
            2 -> potionOfIntelligenceDrank++
            3 -> potionOfHealthDrank++
            4 -> potionOfDefenseDrank++
            5 -> potionOfMagicDefenseDrank++
            6 -> potionOfPrecisionDrank++
            7 -> potionOfViciousnessDrank++
            8 -> potionOfDarknessDrank++
            9 -> potionOfImmunityDrank++
            10 -> potionOfAgilityDrank++
        }
    }

    fun get(type: Int): Int = when (type) {
        0 -> potionOfConstitutionDrank
        1 -> potionOfDexterityDrank
        2 -> potionOfIntelligenceDrank
        3 -> potionOfHealthDrank
        4 -> potionOfDefenseDrank
        5 -> potionOfMagicDefenseDrank
        6 -> potionOfPrecisionDrank
        7 -> potionOfViciousnessDrank
        8 -> potionOfDarknessDrank
        9 -> potionOfImmunityDrank
        10 -> potionOfAgilityDrank
        else -> 0
    }

    fun resetAgility() {
        potionOfAgilityDrank = 0
    }
}
