package it.paranoidsquirrels.idleguildmaster.ui.dialogs.changelog

import it.paranoidsquirrels.idleguildmaster.ui.dialogs.ModChangelog.VersionEntry
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.ModChangelog.version

/**
 * Historical changelog archive - every entry from the mod's first release up to the
 * end of the v1.2.x era (v1.2.0.0 down to v1.0.0.0). This file is static: it is only
 * preserved for history, never touched for new releases.
 *
 * Entries are ordered newest-first.
 */
object ModChangelogArchive {

    val ENTRIES: List<VersionEntry> = listOf(
        version("1.2.0.0", "12/9/2026",
            "Added guild activities: Daily Request + Weekly Siege",
            "Added mod-owned Reputation stat (0-100, shown next to Gems)",
            "Request: daily elite enemy hunt, 2x stats, up to 12 adventurers, rewards Gems equal to current Reputation on success",
            "Failed Request: -5 Reputation",
            "Siege: weekly 10-wave defense, up to 12 defenders, no boss waves",
            "Failed Siege: -10 Reputation",
            "Added 5th tab \"Guild Activities\" (Request & Siege) to the bottom navigation."
        ),
        version("1.1.1.3", "7/9/2026",
            "Fixed Evo-23 Vial unusable",
            "Fixed crash when open Settings",
            "Added Mod About",
            "Upgraded UI of Mod About."
        ),
        version("1.1.1.2", "7/9/2026",
            "Troll's Resistance / Warlock's Resilience: Doctrine cost reduced from 3 -> 1, Defense bonus increased from +1 -> +2 DEF per point, Max points increased from 2 -> 5",
            "Lightning Speed: Extra attack chance increased from +15% -> +20% per level",
            "Improved Health: Health bonus increased from +15 -> +25 HP per level",
            "Troll Blood: Reworked from flat HP regeneration to (Tier / 2)% of max HP regenerated per turn. At Tier 9: 4.5% max HP regenerated per turn.",
            "Dragon Blood: Now grants 1% damage reduction per tier",
            "Blessed: Darkness reduction increased from 8 -> 15",
            "Nimble: Dodge chance increased from 8% -> 15%",
            "Cursed: HP loss reduced from -4% -> -2% per turn, Lifesteal increased from 15 -> 20",
            "Focused: Miss chance reduction increased from 15% -> 25%",
            "Nocturnal: Damage bonus increased from 0.5% -> 1% per point of darkness",
            "Brute+ / Feral+ / Bookworm+: Stat multiplier increased from 1.15x -> 1.20x",
            "Added new rare trait: Ruthless+"
        ),
        version("1.1.1.1", "6/9/2026",
            "Fixed visual bugs: Repetitive in description of Captain's Sword, Imperial Authority, Execution Order.",
            "Fixed bugs: Unable to consume Evo-23 Vial, Evo-22 Vial, XP Books",
            "Fixed bugs: Kill count doesn't reset, leading to repeated encounters with the Imperial Captain.",
            "Added announce log for Imperial Captain.",
            "Fixed visual bug: Announce log of Imperial Captain doesn't display number."
        ),
        version("1.1.1.0", "6/9/2026",
            "Added new miniboss into The Golden City dungeon: Imperial Captain",
            "Added 1 new Passive skill and 1 new Active skill",
            "Added new weapon: Captain's sword"
        ),
        version("1.1.0.0", "5/9/2026",
            "Big update for mod engine",
            "Built pipeline, stubs, ModManager skeleton",
            "Expanded decompiled resources and added development tooling",
            "Update ModManager with enhanced modification capabilities"
        ),
        version("1.0.6.1", "2/9/2026",
            "Fixed crash when spawn Knight Slime",
            "Fixed bug unable to display Knight Slime's details",
            "Fixed crash when open Knight Slime's details",
            "Fixed crash when drop Knight Slime's loots",
            "Fixed bug unable to display Knight Slime's icon in battle",
            "Fixed bug Knight Slime automatically die when spawn",
            "Fixed bug unable to drop Knight Slime's loot",
            "Fixed bug Knight Slime drops Green Slime's loot"
        ),
        version("1.0.6.0", "2/9/2026",
            "Added Knight Slime into Slime Pond raid and Bestiary",
            "Added 1 new Passive skill"
        ),
        version("1.0.5.3", "2/9/2026",
            "Fixed minor bugs"
        ),
        version("1.0.5.2", "1/9/2026",
            "Fixed visual bugs.",
            "Updated new art for class Berserker.",
            "Removed 2 weapon slots system.",
            "Updated Berserker's passive skill"
        ),
        version("1.0.5.1", "1/9/2026",
            "Fixed bug: Unable to open screen when use Evo-22 Vial",
            "Fixed bug: Unable to display list of adventurers",
            "Fixed bug: Unable to change adventurer's basic trait"
        ),
        version("1.0.5.0", "1/9/2026",
            "Initialized Basic trait modification system",
            "Added new item Evo-22 Vial"
        ),
        version("1.0.4.1", "1/9/2026",
            "Fix bug: Unable to open screen when use XP Book"
        ),
        version("1.0.4.0", "1/9/2026",
            "Initialized XP Book system",
            "Added 4 new xp books"
        ),
        version("1.0.3.0", "1/9/2026",
            "Initialized Attack Thrice system",
            "Added new item: Celestial Bow"
        ),
        version("1.0.2.2", "31/8/2026",
            "Fixed visual bug in Dungeon tab and Raid tab",
            "Removed x4 speed and 24h idle time"
        ),
        version("1.0.2.1", "31/8/2026",
            "Fixed bug unable to dismiss Berserker",
            "Fixed bug unable to promote to Berserker",
            "Fixed bug lost weapon in second weapon slot when dismiss Berserker",
            "Fixed bug unable to ascend Berserker",
            "Fixed visual bug on Berserker in Adventurer tab"
        ),
        version("1.0.2.0", "31/8/2026",
            "Initialized new class system.",
            "Added new class Berserker.",
            "Added unique type of class with 2 slots of weapon, 1 slot of armor and 0 slot of accessories",
            "Added 1 new Passive skill and 1 new Active skill"
        ),
        version("1.0.1.2", "31/8/2026",
            "Fix bugs and crashes"
        ),
        version("1.0.1.1", "31/8/2026",
            "Fixed bugs",
            "Fixed crash when summon Semi",
            "Fixed bug unable to summon Semi"
        ),
        version("1.0.1.0", "31/8/2026",
            "Added new Wild type pet Semi.",
            "Initialized 5th trait system for pet.",
            "Initialized Save File system."
        ),
        version("1.0.0.1", "31/8/2026",
            "Fixed bugs"
        ),
        version("1.0.0.0", "31/8/2026",
            "Initialized Mod.",
            "Made Tests: x4 Speed in Expedition. Increase idle time to 24h"
        ),    )

    /** Backward-compatible full text in legacy oldest-first order */
    val TEXT: String by lazy {
        ENTRIES.reversed().joinToString("\n\n") { "${it.title}:\n${it.body}" }
    }
}
