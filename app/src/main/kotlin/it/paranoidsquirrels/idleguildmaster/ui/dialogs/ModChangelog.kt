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
        "- Added 5th tab \"Guild Activities\" (Request & Siege) to the bottom navigation.\n" +
        "\n" +
        "1.3.0.0 (13/9/2026):\n" +
        "- Guild Activities rebuilt as real Raids: Request/Siege now use the vanilla combat engine (DialogSendTeam -> DialogDungeonDetail), tick offline via compileDungeonRaidList and persist mid-fight state through save/load.\n" +
        "- Raid-style cards in the Guild tab with orange/blank try dots per the game's raid look, plus countdown timers to the next refresh.\n" +
        "- Reputation now lives in its own top-bar box with an icon (was inlined into the gems box); Guild tab title now updates like the other tabs.\n" +
        "- Elite Request targets are persisted via the Elite_ marker trueClass and rebuilt by the patched Enemy.getInstance().\n" +
        "- Unchanged rules: Request reward = Reputation, -5 on failed Request, Siege = 10 waves (5-10 monsters, no bosses), -10 on failure.\n" +
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
        "- Integrated all mod features natively into the game source; removed the old mod/ModManager inject layer (Imperial Captain, idle/loot caps, changelog UI, and consumables now live in their proper game systems).\n" +
        "- Added Archer Barrage Dynamic Retargeting.\n" +
        "- Made Celestial Mothership Normal Raid & Loot Rebalance.\n" +
        "\n" +
        "1.3.1.0 (16/9/2026):\n" +
        "- Added Guild Activities: the Daily Request and Weekly Siege as real raid areas (DialogSendTeam -> DialogDungeonDetail) that tick offline and persist mid-fight state.\n" +
        "- Added the Shadow boss (100/100/100 stats, 100-1000 damage, 50% crit, 100% status immunity, 1000 HP) and its Geode drop: 10% -> 100 gems, 20% -> 50 gems, 70% -> 20 gems.\n" +
        "- Daily Request: up to 12 adventurers vs. a wave of 1 Shadow + 2 Void Slimes.\n" +
        "- Weekly Siege: up to 12 defenders across 10 waves of 5-10 non-boss monsters pulled from unlocked areas.\n" +
        "- Guild activities roll over on the daily/weekly boundaries and refresh their cooldown timers.\n" +
        "- Bestiary: added the \"Other\" category listing the Request, Siege, and Shadow.\n" +
        "\n" +
        "1.3.1.1 (16/9/2026):\n" +
        "- Fixed the Weekly Siege freezing and crashing the game (infinite recursion in the siege wave spawner was building the eligible enemy pool from itself).\n" +
        "- Removed the Reputation stat and its penalties; the Daily Request now awards 100 gems on completion.\n" +
        "- Shadow now drops a Geode in its loot pool: 10% -> 100 gems, 20% -> 50 gems, 70% -> 20 gems.\n" +
        "- Daily Request wave order changed to [Void Slime, Shadow, Void Slime].\n" +
        "\n" +
        "1.3.1.2 (16/9/2026):\n" +
        "- Fixed Shadow and Void Slimes in The Hunt not dropping loot (combat victory was ending the area before the loot phase ran).\n" +
        "- Fixed The Siege's final (10th) wave not dropping loot for the same reason.\n" +
        "- Fixed the orange available/unavailable marker on Request and Siege cards not updating.\n" +
        "- Added a dedicated 5th 'Guild Activities' tab; Request and Siege no longer appear inside the Raids tab.\n" +
        "- The Siege now spawns 5-10 enemies per wave (it was stuck at 5 until the final wave).\n" +
        "- Removed the 100-gem reward from The Hunt completion.\n" +
        "- Renamed Daily Request -> The Hunt and Weekly Siege -> The Siege.\n" +
        "- Fixed the changelog detail Close button closing the entire dialog instead of just the detail.\n" +
        "- Made the changelog dialog full-width and the version detail view bigger.\n" +
        "\n" +
        "1.3.1.3 (16/9/2026):\n" +
        "- Fixed Shadow's Geode not dropping in The Hunt (its drop weight was 1/1000 — effectively nothing — instead of the intended guaranteed drop).\n" +
        "- Fixed The Siege battle only displaying 5 monsters at once; up to 10 enemies per wave are now shown.\n" +
        "- The Hunt's Void Slime count is now randomized: 70% one, 20% two, 10% four — with Shadow always in the middle.\n" +
        "- The Siege now picks one dungeon/raid per wave (later waves favour harder areas) and spawns only that area's monsters, honouring per-area rules: e.g. Divine Archeology = Sand Demon only, Ancient Grave Digging excludes Kabar/Necrolith, Dire Descent never spawns, and bosses are skipped.\n" +
        "- Bestiary: the \"Other\" tab now shows only new monsters not already listed in the Dungeons/Raids tabs (Shadow).\n" +
        "\n" +
        "1.3.1.4 (16/9/2026):\n" +
        "- Shadow now drops a stack of 3 Geodes per kill (guaranteed; 10%/20%/70% gem yield each).\n" +
        "- The Siege now dispatches at most 10 adventurers (was 12).\n" +
        "- The Siege logs a yellow \"Wave X of 10\" banner at the start of every wave, plus enter-dungeon/enter-wave atmosphere logs.\n" +
        "- The Hunt also gained enter-dungeon/enter-room atmosphere logs.\n" +
        "- Fixed the Imperial Captain log showing a raw \"[%d/100]\" — it now displays the real kill count in yellow every time the counter updates (guard kill, captain kill, team wipe) and resets to [0/100] on retreat.\n" +
        "- Retreating from The Siege or The Hunt now consumes that period's try (the card becomes unavailable immediately after sending a team, like other raids).\n" +
        "- Added \"NEW HUNT IN / NEXT SIEGE IN\" countdown timers to the Guild Activities tab.\n" +
        "\n" +
        "1.3.1.5 (17/9/2026):\n" +
        "- Fixed pet trait Savage never activating: the PET redeem code set the pet's level after its abilities were configured, so traits kept their level-1/zero magnitude (e.g. a level-2000 Semi with Savage stayed at 0). Pet abilities are now recomputed whenever the level changes.\n" +
        "- Fixed defense penetration (Doctrine of War's Tactical Knowledge)\u00A0ignoring far less armor than intended \u2014 combat read the raw armorIgnored field instead of the getter, so the doctrine's 40% armor ignore never applied.\n" +
        "- Fixed Healing Nova (Doctrine of Grace) not healing on kill \u2014 the heal-on-death total came from the raw field instead of the getter, so the doctrine contribution was lost.\n" +
        "- Fixed Overheal (Doctrine of Grace) not applying a shield \u2014 the shield block read the raw maxOverheal field (always 0) instead of the getter that includes the doctrine value.\n" +
        "\n" +
        "1.3.1.6 (17/9/2026):\n" +
        "- Added per-class attack stat scaling: Adventurers now have attackConstitutionScaling/attackIntelligenceScaling/attackDexterityScaling (default 1.0) applied to their stats before the weapon damage modifier.\n" +
        "- Black Regent, Angel of War, and Divine Champion now scale Constitution at 150% for weapon damage (1.5x CON), making their heavy CON builds hit noticeably harder.\n" +
        "\n" +
        "1.3.1.7 (17/9/2026):\n" +
        "- Added the new status effect Bloodflame (new icon): burns for 5% of max Health each turn as magic damage at the start of the turn, and prevents the affected unit from healing in any way (direct heals, lifesteal, regeneration, healing nova). Like Ablaze, it does not stack (only a longer duration refreshes). Its combat logs read \"cursed and rotten by bloodflame\" and the per-turn tick reports the damage suffered.\n" +
        "- Subjugate and Subjugate II now set Bloodflame on basic-attack hits (1 turn for Subjugate, 2 turns for Subjugate II); their descriptions explain the effect.\n" +
        "- Decimate / Decimate II / Decimate III now apply BOTH effects on all hit enemies: STUN (unchanged from the original) plus Bloodflame for 1 turn; their descriptions explain both.\n" +
        "- Extended the 150% CON weapon scaling to the whole Knight branch: Knight, Dark Knight, Death Knight, Scourge, Tyrant, Overlord, Holy Knight, Paladin, Templar, Inquisitor, and Justiciar (Angel of War, Black Regent, and Divine Champion were already scaled). The Guard branch is untouched.\n" +
        "\n" +
        "1.3.1.8 (17/9/2026):\n" +
        "- New Sword: Colossal Sword of Scarlet King (+124 CON, +7 DEX, Bloodflame damage +50%, half damage below 120 CON). Crafted from Colossal Sword + 5 Heart of Darkness + 5 Ancestral Blood.\n" +
        "- Added the Bloodflame damage bonus stat to gear: equipment can now amplify the Bloodflame burn it inflicts (the Scarlet King sword grants +50%).\n" +
        "\n" +
        "1.3.1.9 (17/9/2026):\n" +
        "- Colossal Sword of Scarlet King: removed the half-damage rule below 120 CON — it now always uses the full Constitution for weapon damage (the sword itself grants 124 CON), and its description no longer mentions the old rule.\n" +
        "- Fixed the Bloodflame damage bonus: +N% now multiplies the 5% max-HP burn (5% x 1.5 = 7.5% with the Scarlet King sword, e.g. 300 damage on a 4000 HP enemy) instead of replacing that 5% entirely (was 55%).\n" +
        "\n" +
        "1.3.2.0 (17/9/2026):\n" +
        "- Added the Enemy Type System: all 124 enemies and elite variants across Dungeons, Raids, and special encounters are now classified into 10 RPG types (Humanoid, Beast, Undead, Demon, Dragon, Slime, Elemental, Plant, Construct, Aberration).\n" +
        "- Enemy details now display the enemy type next to the damage characteristics (e.g. Melee, Physical, Beast or Ranged, Magic, Dragon).\n" +
        "- Tapping the attack type row in enemy details explains attack and damage mechanics alongside the enemy type lore.\n" +
        "\n" +
        "1.3.3.0 (17/9/2026):\n" +
        "- Holy Knight -> Angel of War evolution line fully reworked into a Frontline Auramancer (threat 2): weapon scaling is now 100% CON + 70% INT.\n" +
        "- New Radiant Blessing party aura (new status effect + icon): at battle start grants all allies status immunity, flat damage reduction, HP regeneration and bonus damage against Undead (scaling +10%->+50%, +5->+15 flat DR, up to +5% HP regen and +30% vs Undead by tier).\n" +
        "- Holy Knight (Holy Smite I) & Paladin (Holy Smite II): physical strikes that heal the lowest-HP ally for 50%/60% of the damage dealt; Paladin and above also heal for 25-50% of damage dealt on every basic attack.\n" +
        "- Templar & Inquisitor (Radiant Judgment I/II), Justiciar (Wrath of Heaven I) and Angel of War (Wrath of Heaven II): magic-damage strikes (+50% extra damage vs Undead) with Silence, party cleansing, and party holy shields or heals.\n" +
        "- Aura passives replace the old silence/darkness kit: darkness reduction now scales 15 -> 50 by tier.\n" +
        "\n" +
        "1.3.4.0 (18/9/2026):\n" +
        "- Bleed Rebalance: bleeding targets now have their Defense shredded by 0.1% per Bleed stack (rounded down, capped at 15% at 150+ stacks).\n" +
        "- Thousand Cuts I & II now trigger instant Hemorrhage right after applying their Bleed stacks: burst damage equal to 100% of the target's current Bleed stacks, scaled by the party pet's Bloodcrave bonus, and rolled against the inflicter's crit stats (Critical Hit) plus the pet's Savage tier (Devastating Hit). All existing Thousand Cuts behaviour (3.0x critical amplification and damage-to-bleed conversion of damage/3.0 and damage/2.0) is unchanged, and the 1,000-stack auto-rupture is removed.\n" +
        "- New pet ability Bloodcrave: increases all bleed damage dealt by level * 0.5% (level 100 = +50%). It replaces Counterattack in the Wild pet family's guaranteed first-ability pool (Wild now rolls Lifesteal or Bloodcrave) and joins the normal pet-ability roll pool.\n" +
        "- New pet abilities Lacerate and Serrated: Lacerate gives level * 0.6% chance for bleed to deal its damage a second time in a turn (without consuming an extra stack); Serrated gives level * 0.6% chance to inflict bleed twice whenever a bleed is applied. Both have dedicated combat log lines.\n" +
        "\n" +
        "1.3.5.0 (18/9/2026):\n" +
        "- New currency tier: Diamond Coin (1 Diamond = 100 Platinum = 100,000,000 copper), displayed to the left of Platinum everywhere the money container renders (headquarters top bar, prices, market).\n" +
        "- New Nightstall / Black Market: a nocturnal 12-slot stall has a 10% chance to arrive at each daily reset, guaranteed after 6 consecutive missed days. It sells smuggled materials at -50% gold, a smuggled legendary (ScarletStrand/Aegis: 90% gems at -35%, 10% gold), contraband potions (-40%), a shady delicacy (-40%), a Forbidden Evolution Vial (Evo22/23 at 1000/1200 gems) and up to 3 guild upgrades at -35% gems.\n" +
        "- Expanded gem upgrade limits: storage up to 185 gem purchases (300 total spaces), quarters 15 (40 roster), tavern capacity 7 (15 guests), shelter 7 (20 pets), and workshop/market time 15 (reaching speed level 40).\n" +
        "- Crafting and selling times are now clamped to a minimum of 1 second, preventing division-by-zero crashes at speed level 40.\n" +
        "\n" +
        "1.3.5.1 (18/9/2026):\n" +
        "- Fixed melee targeting prioritizing unreachable flying units: melee units without ranged/reach weapons or skills now intelligently ignore flying enemies and prioritize reachable ground targets whenever any are alive, only swinging at flying enemies if no ground targets remain.\n" +
        "\n" +
        "1.3.5.2 (18/9/2026):\n" +
        "- The Black Market top-bar icon now uses a dedicated black market icon.\n" +
        "- The Black Market dialog header now shows only the departure countdown (the cluttered \"Tonight's deals ... Departs in:\" bar was removed).\n" +
        "\n" +
        "1.3.6.0 (18/9/2026):\n" +
        "- Semi's description is now simply \"A divine kitsune spirit dedicated to the guild.\"\n" +
        "- Kitsune Spirit Blessing reworked: it now grants progressive healing of +(level * 0.6)% (was a fixed +20%), and the +5 HP regen/turn and +1 light are removed. The \"(5th Trait)\" suffix and the \"5 Traits (All Unlocked)\" label are gone from the pet card; the trait name is just \"Kitsune Spirit Blessing\" with the current % shown.\n" +
        "- The Black Market header is now a clean plain-text countdown with no header bar — it shows only the time left before the stall departs (like the tavern's \"Next visitor in\").\n" +
        "- The Mod Info changelog detail now sizes its window from the actual wrapped text of each version (long single-line changes like 1.3.5.1 get a full-size scrollable window, capped at 78% of the screen), and the Changelog header shows the total version count.\n" +
        "\n" +
        "1.3.6.1 (19/9/2026):\n" +
        "- Kitsune Spirit Blessing now MULTIPLIES the pet's healing stat by (1 + level * 0.6%) instead of adding a flat amount; the trait's name shows the pet's level next to it (e.g. \"Kitsune Spirit Blessing 74\").\n" +
        "- Hidden Achievements, Load from Cloud, and Reddit from the sidebar menu.\n" +
        "- Mod Info / Changelog is now two separate windows: Mod Info shows IGM+, the version (auto-read from the build via versionName) and the developer, with a Changelog button; the Changelog window lists the versions with the total count in its title.\n" +
        "\n" +
        "1.3.6.2 (19/9/2026):\n" +
        "- Kitsune Spirit Blessing now MULTIPLIES the healing dealt by the party's ADVENTURERS (heals from skills/doctrines) by (1 + level * 0.6%) instead of boosting the pet's own heal — it is a team-healing multiplier, matching the \"Team Healing\" intent.\n" +
        "- The sidebar now has two separate entries: \"Mod Info\" (IGM+, version, developer) and \"Changelog\" (scrollable version list).\n" +
        "\n" +
        "1.3.7.0 (19/9/2026):\n" +
        "- New Pet Shelter upgrade: Effectiveness. After buying Auto-Feed, the right-hand shelter button becomes \"Effectiveness +10%\": 5 gold tiers (5 Gold -> 50 Gold -> 5 Platinum -> 50 Platinum -> 5 Diamond, i.e. 50k / 500k / 5M / 50M / 500M copper) grant +10% each.\n" +
        "- 5 gem tiers: the new UpgradeShelterEffectiveness item (1,000 gems each, up to 5) can be found in the Traveling Merchant / Black Market once Auto-Feed is owned — +10% auto-feed food value per purchase.\n" +
        "- At max effectiveness (gold + gems = 10 levels), auto-fed food is worth +100%: a 10-feed-power food yields 20 feed power to your favourite pets.\n" +
        "- Effectiveness only applies to food consumed via dungeon/raid auto-feeding (collectDrops); manual feeding from inventory is never affected.\n" +
        "\n" +
        "1.3.7.1 (19/9/2026):\n" +
        "- The Shelter Effectiveness button no longer shows the purchase level — it reads \"Effectiveness +10%\", and the current total is shown under the shelter capacity line as \"Feed Effectiveness: n%\".\n" +
        "- Fixed auto-feed long-press marking the wrong pet: the pets grid now re-binds from the freshly re-sorted list (previously the stale adapter order made long-pressing pet N toggle a different pet).\n" +
        "\n" +
        "1.3.7.2 (19/9/2026):\n" +
        "- Angel of War branch gains an AoE Row Defense (Shared Burden) mechanic: when an enemy performs an AoE attack against an adventurer, every alive branch unit (Holy Knight -> Angel of War) in the same row intercepts the highest-tier % of the pre-mitigation damage and splits it evenly (10% -> 35% by tier: Light I/II 10%/15%, Devotion I/II 20%/25%, Sanctity 30%, Seraphim 35%). Each protector mitigates its slice with its own defenses and logs \"[Protector] intercepted [N] damage for [Ally].\".\n" +
        "\n" +
        "1.3.8.0 (19/9/2026):\n" +
        "- In-game Shop Rework: completely switched from real-money in-app purchases to in-game Gem unlocks.\n" +
        "- 7 categorized shop bundles with filter navigation chips: Starter, Adventurers, Companions, Merchant, Workshop, Storage, and Utility.\n" +
        "- Adventurer bundle unique packs (5,000 Gems each) strictly feature Tier 4 units (max level 20) with PLUS basic traits and rare traits: Imperial Vanguard, Unholy Crusade, and the new Primal Vanguard (Wolf Rider, Shadow Dancer, Silver Tongue, Iron Warden).\n" +
        "- Companion bundle features Senko's Celestial Bond (2,500 Gems): grants Level 50 Kitsune Pet Senko with all 5 traits unlocked + Shelter Capacity +1.\n" +
        "- Merchant and Workshop bundles feature dedicated 4-tier progression packs (Apprentice, Journeyman, Grand/Master, Trade Baron/Grandmaster) providing tiered queue/listing and speed bonuses (+20%, +40%, +60%).\n" +
        "- Storage bundle introduces standalone Minor (+35), Expanded (+50), and Grand (+70) storage expansions; storage bonuses removed from starter/adventurer/merchant packs.\n" +
        "- Utility bundle adds Deep Pockets (+1,000 Max Loot), Extended Vigil (+6 Offline Idle Hours), and Sacred Intercession (repeatable 1x Intercession).\n" +
        "- Offline double-purchase protection: prevents re-purchasing already unlocked packs and properly displays the brass checkmark for owned packs.\n" +
        "\n" +
        "1.3.8.1 (19/9/2026):\n" +
        "- Auto-Migration Failsafe on Save Load: importing older or vanilla saves with Starter, Adventurer, or Merchant packs automatically grants the corresponding new modular storage (+35, +50, +70), workshop (+2 queue, +40% speed), and max loot (+1,000) perks so no player stats or inventory capacities are lost on import.\n" +
        "\n" +
        "1.3.8.2 (19/9/2026):\n" +
        "- Fixed the Shop entry being hidden from the sidebar drawer: it is now visible (still controlled by the DebugToggles.DISABLE_SHOP flag, which defaults to false = shown).\n" +
        "\n" +
        "1.3.8.3 (19/9/2026):\n" +
        "- Fixed the max-loot cap: the Deep Pockets / merchant-pack +1,000 bonus is now authoritative at 3,000. A stale LOOTCAP cheat redeem no longer silently keeps the chest cap at a legacy value like 4096.\n" +
        "- Sacred Intercession is now a one-time purchase (persisted flag).\n" +
        "- Merchant/workshop pack bonuses rebalanced: Grand Merchant +3, Master Workshop +3, Trade Baron +4, Grandmaster Workshop +4.\n" +
        "- Senko pack pet's first trait changed to Savage (was Healer).\n" +
        "- New Companion bundle pack: 10x Ceremonial Cake for 10,000 Gems (one-time).\n" +
        "- Shop price buttons now show a gem icon next to the number instead of the word \"Gems\".\n" +
        "- Fixed shop borders: storage pack icons now use a square border, and the Sacred Intercession icon border matches the other item cards.\n" +
        "\n" +
        "1.3.8.4 (20/9/2026):\n" +
        "- Updated the merchant/workshop pack icons to match the rebalanced bonuses: Grand Merchant & Master Workshop now use the +3 icon (shop_3), Trade Baron & Grandmaster Workshop use the +4 icon (shop_4).\n" +
        "- Fixed the Ceremonial Cake bundle so it actually lives inside the Companion bundle category (it was previously rendered outside the category container, so it never showed under the Companion filter)." +
        "\n\n" +
        "1.3.8.5 (20/9/2026):\n" +
        "- Shop Expansion: converted the legacy vanilla redeem codes (Divine Champion, Eternal Reliquary, Alchemist's Bounty, Patrician's Wardrobe, Royal Treasury & Feast, Shroud of the Ancients) into purchasable gem packs in the Shop; legacy saves that already redeemed those codes auto-migrate and show them as purchased.\n" +
        "- New Equipment bundle: Celestial Bow pack. New Infrastructure bundle: Barracks I & II (+1 adventurer slot each), Grand Tavern (+2 tavern capacity, visitors 20% faster), Sanctuary I & II (+2 pet slots each), Idle Hours II/III/IV (+6/+24/+48 offline hours), Eternal Vigil (+72 offline hours), Deep Pockets II (+1000 max loot), Evolution Synthesis, Storage +100, Storage +150.\n" +
        "- Unhidden the Celestial Bow's +10% crit chance and +10% crit damage in its tooltip/stat line.\n" +
        "\n" +
        "1.3.8.6 (20/9/2026):\n" +
        "- Shop UI & packs reworked to match the expansion plan exactly. Pack names, gem prices, categories, and contents corrected: Barracks Expansion I (1,000) / II (2,000) with the shop_1 Quarters Spaces icon, Grand Tavern Expansion (1,250), Sanctuary Grounds I (750) / II (1,250) under Infrastructure; Extended Vigil II/III/IV (Chronos Ward, Aegis of Time, Temporal Anchor), Eternal Vigil (Timeless Continuum), and Deep Pockets II (Bottomless Chest) under Utility; Dimensional Vault (+100) and Infinite Hoard (+150) under Storage; Armory: Celestial Bow (1,000) under Equipment. Evolutionary Synthesis Crate (1,000: 1x Evo-22 Vial, 1x Evo-23 Vial, 2x Dreamcatcher) added under Utility.\n" +
        "- The converted redeem packs now display every contained item/adventurer (Divine Champion hero + gear, Eternal Reliquary items, all 11 Alchemist potions, Patrician's Wardrobe items, Royal Treasury + Feast) and every icon is clickable to open its detail dialog.\n" +
        "- Removed redundant in-pack text that repeated the pack name; each pack card now shows only its contents/benefit. Sacred Intercession no longer shows its long description, the Celestial Bow pack no longer says 'attacks thrice per turn', and the Shroud of the Ancients pack no longer says '(Legendary Medium Armor)'.\n" +
        "- Reverted the duplicated crit stat strings; the shop now reuses the existing critical_chance_formatted / critical_damage_formatted resources.\n" +
        "\n" +
        "1.3.8.7 (20/9/2026):\n" +
        "- Re-added the Evolutionary Synthesis Crate (1,000 Gems, one-time) to the Utility bundle: grants 1x Evo-22 Vial, 1x Evo-23 Vial and 2x Dreamcatcher, with clickable item previews.\n" +
        "- Normalized all new shop pack cards to the vanilla geometry: pack titles at 18sp and 140x36 buy buttons.\n" +
        "- Updated the MAX IDLE HOURS tooltip for the progressive Vigil caps (up to 168 hours / 7 days).\n" +
        "\n" +
        "1.3.8.8 (20/9/2026):\n" +
        "- Fixed all Shop expansion pack layouts: item-row TextViews now use layout_weight=\"1\" inside match_parent LinearLayouts so item names are always visible (they collapsed to zero-width in wrap_content rows).\n" +
        "- Fixed buy button positioning in all new single-row packs (Vigil II/III/IV, Eternal Vigil, Deep Pockets II, Dimensional Vault, Infinite Hoard, Celestial Bow, all Infrastructure packs): buttons are now vertically centred in their card via constraintTop/Bottom_toTopOf/BottomOf=\"parent\" instead of floating below the icon.\n" +
        "- Affected packs: Divine Champion, Eternal Reliquary, Alchemist's Bounty, Patrician's Wardrobe, Royal Treasury & Feast, Shroud of the Ancients, Evolutionary Synthesis Crate, Chronos Ward, Aegis of Time, Temporal Anchor, Timeless Continuum, Bottomless Chest, Dimensional Vault, Infinite Hoard, Armory: Celestial Bow, Barracks Expansion I & II, Grand Tavern Expansion, Sanctuary Grounds I & II." +
        "\n\n" +
        "1.3.8.9 (20/9/2026):\n" +
        "- Shop polish: Minor/Expanded/Grand Storage packs now use the Dimensional Vault icon; Grand Tavern and Sanctuary I/II now use the shop_2 (+2) icon.\n" +
        "- Reordered the Utility category to group related packs: Deep Pockets + Bottomless Chest, then the Extended Vigil family (Chronos Ward, Aegis of Time, Temporal Anchor, Timeless Continuum), then Sacred Intercession + Evolutionary Synthesis Crate.\n" +
        "- Converted starter packs and key utility packs now state item counts (e.g. 1x Champion Armor, 100x of each potion, 10x Ceremonial Cake, 2x Dreamcatcher).\n" +
        "- Celestial Bow pack renamed to just CELESTIAL BOW and its icon now opens the weapon detail dialog.\n" +
        "- Divine Champion pack now displays its hero like the other adventurer packs, and Eternal Reliquary / Alchemist's Bounty / Patrician's Wardrobe items are shown in two columns." +
        "\n\n" +
        "1.3.8.10 (20/9/2026):\n" +
        "- Divine Champion, Eternal Reliquary, Alchemist's Bounty and Patrician's Wardrobe buy buttons now sit at the bottom-right of their cards (like the Guild Initiate / Explorer's Supply Cache packs).\n" +
        "- Grand Tavern Expansion now lists its two benefits as separate rows: shop_2 icon for Tavern Visitor Capacity, hourglass icon for -20% Visitor Arrival Interval.\n" +
        "- Utility packs now use their keyword names instead of the bracketed titles: CHRONOS WARD, AEGIS OF TIME, TEMPORAL ANCHOR, TIMELESS CONTINUUM, BOTTOMLESS CHEST.\n" +
        "- Buy buttons on all new shop packs are slightly smaller (120x32)." +
        "\n\n" +
        "1.3.8.11 (20/9/2026):\n" +
        "- Divine Champion, Eternal Reliquary, Alchemist's Bounty and Patrician's Wardrobe now fill their cards with a 2-column item grid and the buy button sits in its own row at the bottom; Divine Champion keeps its full adventurer row on top.\n" +
        "- All item/pet/shop icon square borders now use one universal 40x40 size (adventurer previews untouched); all buy buttons use a universal 120x32 size.\n" +
        "- Bottomless Chest description updated to 'Max Loot +10000'; Temporal Anchor and Timeless Continuum now grant +6 Max Idle Hours each (description and effect).\n" +
        "- Master Workshop and Grand Merchant packs increased to 2,500 Gems; Grandmaster Workshop and Trade Baron packs increased to 5,000 Gems.\n" +
        "- The shop now switches category when you swipe left/right on the content, in addition to the category chips." +
        "\n\n" +
        "1.3.8.12 (20/9/2026):\n" +
        "- Removed the swipe-to-change-category gesture from the shop.\n" +
        "- Utility price rebalance: Chronos Ward 2,000, Aegis of Time 3,500, Temporal Anchor 7,000, Timeless Continuum 10,000, Deep Pockets 1,000, Bottomless Chest 2,000.\n" +
        "- Ceremonial Cake Bundle title/description cleaned (removed '(x10)' and 'for your pets').\n" +
        "- Fixed the converted starter packs (Divine Champion, Eternal Reliquary, Alchemist's Bounty, Patrician's Wardrobe) showing too much space between the first row and the card border.\n" +
        "- Alchemist's Bounty potions are now clickable to open their detail dialogs; the Celestial Bow detail dialog now shows its +10% crit chance and +10% crit damage." +
        "\n\n" +
        "1.3.8.13 (20/9/2026):\n" +
        "- Fixed the item detail crit display: the Celestial Bow effect now reads 'Attack thrice, +10% crit chance and dmg' (crit stated in the effect text like Scarlet Shroud) and the auto-appended crit lines were removed, so no item shows duplicated crit text." +
        "\n\n" +
        "1.3.8.14 (21/9/2026):\n" +
        "- New craftable legendary armor completes the Scarlet trilogy: Scarlet Oni (Heavy, +470 HP, +56 CON, +18% crit chance, +5% crit dmg, 100,000L) and Scarlet Sigil (Light, +200 HP, +62 INT, +20% crit chance, +2 mana regen, 60,893L).\n" +
        "- Equipment can now grant Mana Regen: weapon, armor and accessory mana regen is added to an adventurer's mana gain every turn.\n" +
        "- Both new recipes retroactively unlock in the Workshop for saves that have already seen Scarlet Strand or Eldritch Seal."

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