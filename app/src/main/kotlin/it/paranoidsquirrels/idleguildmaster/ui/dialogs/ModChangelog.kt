package it.paranoidsquirrels.idleguildmaster.ui.dialogs

/**
 * Version-by-version changelog backing the "Mod info" and version-detail dialogs.
 * Entries are listed newest first.
 */
object ModChangelog {

    class VersionEntry(val title: String, val body: String)

    val MOD_ABOUT_TEXT: String =
        "1.0.0.0 (31/8/2026):\n" +
        "- Initialized Mod.\n" +
        "- Made Tests: x4 Speed in Expedition. Increase idle time to 24h\n" +
        "\n" +
        "1.0.0.1 (31/8/2026):\n" +
        "- Fixed bugs\n" +
        "\n" +
        "1.0.1.0 (31/8/2026):\n" +
        "- Added new Wild type pet Semi.\n" +
        "- Initialized 5th trait system for pet.\n" +
        "- Initialized Save File system.\n" +
        "\n" +
        "1.0.1.1 (31/8/2026):\n" +
        "- Fixed bugs\n" +
        "- Fixed crash when summon Semi\n" +
        "- Fixed bug unable to summon Semi\n" +
        "\n" +
        "1.0.1.2 (31/8/2026):\n" +
        "- Fix bugs and crashes\n" +
        "\n" +
        "1.0.2.0 (31/8/2026):\n" +
        "- Initialized new class system.\n" +
        "- Added new class Berserker.\n" +
        "- Added unique type of class with 2 slots of weapon, 1 slot of armor and 0 slot of accessories\n" +
        "- Added 1 new Passive skill and 1 new Active skill\n" +
        "\n" +
        "1.0.2.1 (31/8/2026):\n" +
        "- Fixed bug unable to dismiss Berserker\n" +
        "- Fixed bug unable to promote to Berserker\n" +
        "- Fixed bug lost weapon in second weapon slot when dismiss Berserker\n" +
        "- Fixed bug unable to ascend Berserker\n" +
        "- Fixed visual bug on Berserker in Adventurer tab\n" +
        "\n" +
        "1.0.2.2 (31/8/2026):\n" +
        "- Fixed visual bug in Dungeon tab and Raid tab\n" +
        "- Removed x4 speed and 24h idle time\n" +
        "\n" +
        "1.0.3.0 (1/9/2026):\n" +
        "- Initialized Attack Thrice system\n" +
        "- Added new item: Celestial Bow\n" +
        "\n" +
        "1.0.4.0 (1/9/2026):\n" +
        "- Initialized XP Book system\n" +
        "- Added 4 new xp books\n" +
        "\n" +
        "1.0.4.1 (1/9/2026):\n" +
        "- Fix bug: Unable to open screen when use XP Book\n" +
        "\n" +
        "1.0.5.0 (1/9/2026):\n" +
        "- Initialized Basic trait modification system\n" +
        "- Added new item Evo-22 Vial\n" +
        "\n" +
        "1.0.5.1 (1/9/2026):\n" +
        "- Fixed bug: Unable to open screen when use Evo-22 Vial\n" +
        "- Fixed bug: Unable to display list of adventurers\n" +
        "- Fixed bug: Unable to change adventurer's basic trait\n" +
        "\n" +
        "1.0.5.2 (1/9/2026):\n" +
        "- Fixed visual bugs.\n" +
        "- Updated new art for class Berserker.\n" +
        "- Removed 2 weapon slots system.\n" +
        "- Updated Berserker's passive skill\n" +
        "\n" +
        "1.0.5.3 (2/9/2026):\n" +
        "- Fixed minor bugs\n" +
        "\n" +
        "1.0.6.0 (2/9/2026):\n" +
        "- Added Knight Slime into Slime Pond raid and Bestiary\n" +
        "- Added 1 new Passive skill\n" +
        "\n" +
        "1.0.6.1 (2/9/2026):\n" +
        "- Fixed crash when spawn Knight Slime\n" +
        "- Fixed bug unable to display Knight Slime's details\n" +
        "- Fixed crash when open Knight Slime's details\n" +
        "- Fixed crash when drop Knight Slime's loots\n" +
        "- Fixed bug unable to display Knight Slime's icon in battle\n" +
        "- Fixed bug Knight Slime automatically die when spawn\n" +
        "- Fixed bug unable to drop Knight Slime's loot\n" +
        "- Fixed bug Knight Slime drops Green Slime's loot\n" +
        "\n" +
        "1.1.0.0 (5/9/2026):\n" +
        "- Big update for mod engine\n" +
        "- Built pipeline, stubs, ModManager skeleton\n" +
        "- Expanded decompiled resources and added development tooling\n" +
        "- Update ModManager with enhanced modification capabilities\n" +
        "\n" +
        "1.1.1.0 (6/9/2026):\n" +
        "- Added new miniboss into The Golden City dungeon: Imperial Captain\n" +
        "- Added 1 new Passive skill and 1 new Active skill\n" +
        "- Added new weapon: Captain's sword\n" +
        "\n" +
        "1.1.1.1 (6/9/2026):\n" +
        "- Fixed visual bugs: Repetitive in description of Captain's Sword, Imperial Authority, Execution Order.\n" +
        "- Fixed bugs: Unable to consume Evo-23 Vial, Evo-22 Vial, XP Books\n" +
        "- Fixed bugs: Kill count doesn't reset, leading to repeated encounters with the Imperial Captain.\n" +
        "- Added announce log for Imperial Captain.\n" +
        "- Fixed visual bug: Announce log of Imperial Captain doesn't display number.\n" +
        "\n" +
        "1.1.1.2 (7/9/2026):\n" +
        "- Troll's Resistance / Warlock's Resilience: Doctrine cost reduced from 3 -> 1, Defense bonus increased from +1 -> +2 DEF per point, Max points increased from 2 -> 5\n" +
        "- Lightning Speed: Extra attack chance increased from +15% -> +20% per level\n" +
        "- Improved Health: Health bonus increased from +15 -> +25 HP per level\n" +
        "- Troll Blood: Reworked from flat HP regeneration to (Tier / 2)% of max HP regenerated per turn. At Tier 9: 4.5% max HP regenerated per turn.\n" +
        "- Dragon Blood: Now grants 1% damage reduction per tier\n" +
        "- Blessed: Darkness reduction increased from 8 -> 15\n" +
        "- Nimble: Dodge chance increased from 8% -> 15%\n" +
        "- Cursed: HP loss reduced from -4% -> -2% per turn, Lifesteal increased from 15 -> 20\n" +
        "- Focused: Miss chance reduction increased from 15% -> 25%\n" +
        "- Nocturnal: Damage bonus increased from 0.5% -> 1% per point of darkness\n" +
        "- Brute+ / Feral+ / Bookworm+: Stat multiplier increased from 1.15x -> 1.20x\n" +
        "- Added new rare trait: Ruthless+\n" +
        "\n" +
        "1.1.1.3 (7/9/2026):\n" +
        "- Fixed Evo-23 Vial unusable\n" +
        "- Fixed crash when open Settings\n" +
        "- Added Mod About\n" +
        "- Upgraded UI of Mod About.\n" +
        "\n" +
        "1.2.0.0 (12/9/2026):\n" +
        "- Added guild activities: Daily Request + Weekly Siege\n" +
        "- Added mod-owned Reputation stat (0-100, shown next to Gems)\n" +
        "- Request: daily elite enemy hunt, 2x stats, up to 12 adventurers, rewards Gems equal to current Reputation on success\n" +
        "- Failed Request: -5 Reputation\n" +
        "- Siege: weekly 10-wave defense, up to 12 defenders, no boss waves\n" +
        "- Failed Siege: -10 Reputation\n" +
        "- New redeem codes: REQUEST, SIEGE, REP [n]\n" +
        "- Added 5th tab \"Guild Activities\" (Request & Siege) to the bottom navigation.\n" +
        "\n" +
        "1.3.0.0 (13/9/2026):\n" +
        "- Guild Activities rebuilt as real Raids: Request/Siege now use the vanilla combat engine (DialogSendTeam -> DialogDungeonDetail), tick offline via compileDungeonRaidList and persist mid-fight state through save/load.\n" +
        "- Raid-style cards in the Guild tab with orange/blank try dots per the game's raid look, plus countdown timers to the next refresh.\n" +
        "- Reputation now lives in its own top-bar box with an icon (was inlined into the gems box); Guild tab title now updates like the other tabs.\n" +
        "- Elite Request targets are persisted via the Elite_ marker trueClass and rebuilt by the patched Enemy.getInstance().\n" +
        "- Unchanged rules: Request reward = Reputation, -5 on failed Request, Siege = 10 waves (5-10 monsters, no bosses), -10 on failure.\n" +
        "- Redeem codes: REQUEST, SIEGE, REP [n]\n" +
        "\n" +
        "1.3.0.1 (15/9/2026):\n" +
        "- Rebuilt mod engine into 100% native Kotlin without smali dependencies.\n" +
        "- Added 'Start New Game' confirmation in Settings wired to game save reset.\n" +
        "- Fixed Tavern capacity and new visitor timer labels.\n" +
        "- Fixed Storage item grid synchronization when selecting items.\n" +
        "- Fixed Imperial Captain and Knight Slime in Bestiary.\n" +
        "- Fixed Pet avatar click in dungeon & raid battle log screens.\n" +
        "- Fixed Imperial Captain kill count resetting properly on round end (wipe or defeat).\n" +
        "- Redesigned Pet Senko/Semi 5th trait display and unlocked all traits at Level 1.\n" +
        "- Restored custom Berserker sprite art and updated app icon to Sha.\n" +
        "\n" +
        "1.3.0.2 (15/9/2026):\n" +
        "- Fixed Celestial Bow only attacking twice instead of attacking thrice. \n" +
        "- Fixed Berserker sprite art.\n" +
        "\n" +
        "1.3.0.3 (15/9/2026):\n" +
        "- Renamed the app to IGM+.\n" +
        "- Fixed corrupted status text (\"Fighting…\", \"Looting items…\", \"Searching…\", \"New guest…\") that displayed mojibake due to an encoding regression in the localized strings.xml files.\n" +
        "- Upgraded the Mod About/Changelog dialog: version rows now show their change count, and long changelogs open in a scrollable per-change list.\n" +
        "- Integrated all mod features natively into the game source; removed the old mod/ModManager inject layer (redeem codes, Imperial Captain, idle/loot caps, changelog UI, and consumables now live in their proper game systems)."

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
}