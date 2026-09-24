package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import it.paranoidsquirrels.idleguildmaster.ui.dialogs.changelog.ModChangelogActive
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.changelog.ModChangelogArchive

/**
 * Facade over the era-split changelog files.
 *
 * [MOD_ABOUT_TEXT] concatenates the static archive (v1.0.x - v1.2.x) **first** and the
 * active v1.3.x era **last**: the legacy parser below unshifts every block, so feeding
 * it oldest-first text keeps [allEntries] newest-first exactly like the original
 * monolithic changelog did. (The plan sketch lists Active + Archive, but that order
 * would make the archive entries come out newest; the Archive + Active order preserves
 * the required identical [allEntries] callers rely on.)
 *
 * New releases only touch `changelog/ModChangelogActive.kt`; the archive is immutable.
 */
object ModChangelog {

    class VersionEntry(val title: String, val body: String)

    val MOD_ABOUT_TEXT: String by lazy {
        ModChangelogArchive.TEXT + "\n\n" + ModChangelogActive.TEXT
    }

    private val MOD_VERSION_LIST: List<VersionEntry> by lazy { parseVersionEntries() }

    /** Parsed changelog entries, newest first. */
    @JvmStatic
    fun parseVersionEntries(): List<VersionEntry> {
        val out = mutableListOf<VersionEntry>()
        val blocks = MOD_ABOUT_TEXT.replace("\r", "").split(Regex("\n\\s*\n"))
        for (block in blocks) {
            val trimmed = block.trim()
            if (trimmed.isEmpty()) continue
            val nl = trimmed.indexOf('\n')
            val title = if (nl < 0) trimmed else trimmed.substring(0, nl).trim()
            val body = if (nl < 0) "" else trimmed.substring(nl + 1).trim()
            out.add(0, VersionEntry(title, body))
        }
        return out
    }

    @JvmStatic
    fun allEntries(): List<VersionEntry> = MOD_VERSION_LIST

    /** The newest version entry, or null when the changelog is empty. */
    @JvmStatic
    fun latestEntry(): VersionEntry? = MOD_VERSION_LIST.firstOrNull()
}