package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import it.paranoidsquirrels.idleguildmaster.ui.dialogs.changelog.ModChangelogActive
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.changelog.ModChangelogArchive

/**
 * Facade over the era-split changelog files.
 *
 * Changelog entries are structured declaratively using [version].
 * Developers edit [ModChangelogActive] by adding new [version] entries at the TOP of its list.
 *
 * All entries are maintained in newest-first order.
 */
object ModChangelog {

    class VersionEntry(
        val version: String,
        val date: String = "",
        val changes: List<String> = emptyList()
    ) {
        /** Compatibility constructor for legacy callers passing (title, body) */
        constructor(title: String, body: String) : this(
            version = if (title.contains(" ")) title.substringBefore(" ").trim() else title.trim(),
            date = if (title.contains("(") && title.contains(")")) title.substringAfter("(").substringBefore(")").trim() else "",
            changes = body.split("\n").map { it.trim().removePrefix("-").trim() }.filter { it.isNotEmpty() }
        )

        /** Backward-compatible title: "1.3.14.0 (25/9/2026)" or "1.3.14.0" */
        val title: String
            get() = if (date.isNotBlank()) "$version ($date)" else version

        /** Backward-compatible body: lines starting with "- " */
        val body: String
            get() = changes.joinToString("\n") { "- $it" }
    }

    /** Clean DSL helper for declaring a changelog entry with vararg changes without `\n` or `+`. */
    @JvmStatic
    fun version(version: String, date: String = "", vararg changes: String): VersionEntry =
        VersionEntry(
            version = version.trim(),
            date = date.trim(),
            changes = changes.map { it.trim().removePrefix("-").trim() }.filter { it.isNotEmpty() }
        )

    val MOD_ABOUT_TEXT: String by lazy {
        allEntries().reversed().joinToString("\n\n") { "${it.title}:\n${it.body}" }
    }

    private val MOD_VERSION_LIST: List<VersionEntry> by lazy {
        ModChangelogActive.ENTRIES + ModChangelogArchive.ENTRIES
    }

    /** Parsed changelog entries, newest first. */
    @JvmStatic
    fun parseVersionEntries(): List<VersionEntry> = MOD_VERSION_LIST

    @JvmStatic
    fun allEntries(): List<VersionEntry> = MOD_VERSION_LIST

    /** The newest version entry, or null when the changelog is empty. */
    @JvmStatic
    fun latestEntry(): VersionEntry? = MOD_VERSION_LIST.firstOrNull()
}