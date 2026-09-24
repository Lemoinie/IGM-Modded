package it.paranoidsquirrels.idleguildmaster.ui.dialogs.changelog

/**
 * Historical changelog archive - every entry from the mod's first release up to the
 * end of the v1.2.x era (v1.0.0.0 ... v1.2.0.0). This file is static: it is only
 * appended to when preserving history, never touched for new releases.
 *
 * The text stays oldest-first (matching the original monolithic changelog source),
 * which is the exact ordering the facade parser expects.
 */
object ModChangelogArchive {

    val TEXT: String =
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
        "- Added 5th tab \"Guild Activities\" (Request & Siege) to the bottom navigation.\n"
}
