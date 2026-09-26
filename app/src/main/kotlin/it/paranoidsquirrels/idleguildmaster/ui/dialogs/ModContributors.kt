package it.paranoidsquirrels.idleguildmaster.ui.dialogs

/**
 * Role a contributor holds in the mod, together with the badge color shown in the
 * Mod Info dialog's contributors section.
 */
enum class ContributorRole(val title: String, val badgeColor: Int) {
    LEAD_DEV("Lead Developer", 0xFFFFD700.toInt()),       // Gold
    CORE_DEV("Core Developer", 0xFF00BFFF.toInt()),       // Light Blue
    CONTRIBUTOR("Contributor", 0xFF66BB6A.toInt()),       // Green
    SPECIAL_THANKS("Special Thanks", 0xFFBA68C8.toInt()),  // Purple
    ARTIST("Artist", 0xFFFF7043.toInt()),                 // Coral Orange
}

/** Structured profile of a single contributor rendered by the Mod Info dialog. */
data class ModContributor(
    val name: String,
    val role: ContributorRole,
    val description: String,
    val github: String? = null,
    val discord: String? = null,
)

/**
 * Registry of everyone who built the mod. The Mod Info dialog measures and renders a
 * card for every entry — adding a contributor is exactly one clean line in [ALL].
 */
object ModContributors {
    val ALL: List<ModContributor> = listOf(
        ModContributor(
            name = "Lemoinie",
            role = ContributorRole.LEAD_DEV,
            description = "Mod creator, Kotlin reconstruction.",
            github = "Lemoinie",
            discord = "https://discord.gg/qj7b4b7h"
        ),
            ModContributor(
            name = "Angyy",
            role = ContributorRole.CORE_DEV,
            description = "Programmer.",
            discord = "kindanotfun"
        ),
        // New contributors can be added here cleanly as 1 line
        ModContributor(
            name = "Taine.Andrew",
            role = ContributorRole.ARTIST,
            description = "Lead Artist for the mod.",
            discord = "lordkangora"
        ),
        ModContributor(
            name = "Semi",
            role = ContributorRole.SPECIAL_THANKS,
            description = "Lead Tester and Idea Giver.",
            discord = "semi2512"
        ),
        ModContributor(
            name = "Hau",
            role = ContributorRole.SPECIAL_THANKS,
            description = "Tester",
            discord = "zhauz_"
        )
    )
}