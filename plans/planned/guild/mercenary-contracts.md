# Mercenary Contracts: Daily 5-Unit Bounty Raid

## Goal Description
Introduce **Mercenary Contracts**, a new daily tactical combat activity in the Guild Activities tab (alongside *The Hunt* and *The Siege*).

Unlike *The Hunt* (12 adventurers vs single boss) and *The Siege* (10 defenders vs 10 waves), *Mercenary Contracts* tests a standard **5-adventurer party** in a high-stakes, 1-try-per-day skirmish against rival mercenary squads and rogue bounty targets.

### Key Rules
1. **Daily Cooldown**: Resets daily at 00:00 UTC (synchronized with The Hunt).
2. **Strict Single Try**: Exactly **1 attempt per day**. Retreating or wiping immediately consumes the try for that day (no retries, no second chances).
3. **5 Units Max**: Standard dungeon team formation (front/back row mechanics fully active).
4. **Zero New Enemy Sprites Required**: Solves the enemy workload by assembling 5-man **Rival Mercenary Squads** using existing humanoid enemy types and adventurer classes with empowered combat kits.

---

## User Review Required

> [!IMPORTANT]
> ### 1. Enemy Solution: The 7 Rotating Rival Mercenary Squads
> To avoid the heavy art and animation workload of creating new enemy assets, Mercenary Contracts uses **7 themed rival mercenary bands** (one for each day of the week), composed of existing humanoid enemy classes and sprites:
> 
> | Day | Contract Name | Enemy Lineup (5 Units) | Combat Theme |
> | :--- | :--- | :--- | :--- |
> | **Monday** | *The Iron Vultures* | 2× `Footman`, 1× `Knight`, 1× `Marksman`, 1× `ImperialCaptain` (Boss) | Heavy physical frontline + backline snipers |
> | **Tuesday** | *The Shadow Syndicate* | 2× `Cutthroat`, 2× `ShadowCrawler`, 1× `NightBlade` (Boss) | High dodge, stealth, and lethal burst |
> | **Wednesday** | *The Heretic Coven* | 2× `Cultist`, 1× `DarkSorcerer`, 1× `Necromancer`, 1× `Lich` (Boss) | Magic burst, curses, and undead minions |
> | **Thursday** | *Bloodfang Marauders* | 2× `WolfRider`, 1× `SpitfangRider`, 1× `MeatCarver`, 1× `Tyrant` (Boss) | Heavy bleed, frenzy, and high threat |
> | **Friday** | *Corrupted Inquisitors* | 2× `Inquisitor`, 1× `Templar`, 1× `Justiciar`, 1× `DivineChampion` (Boss) | Holy smites, row-intercept, high armor |
> | **Saturday** | *Abyssal Corsairs* | 2× `AbyssalCutlass`, 1× `DeepSeaVelvet`, 1× `CrushingDepth`, 1× `PirateKing` (Boss) | Stuns, water magic, darkness |
> | **Sunday** | *The Apex Deserters* | 1× `BlackRegent`, 1× `AngelOfWar`, 1× `Archmage`, 1× `Assassin`, 1× `Overlord` (Boss) | Full Tier-5 endgame mercenary squad |

---

> [!IMPORTANT]
> ### 2. Daily Lock & Failure Penalty
> - **Attempts**: Strictly **1 try per day**.
> - **No Extra Chances**: There are no gem purchases or consumables to gain extra attempts.
> - **Wipe / Retreat**: Once the battle begins, retreating or party wipe immediately locks the contract until the next daily reset, marking the card as unavailable (dimmed with empty dot).

---

> [!IMPORTANT]
> ### 3. Contract Rewards
> Successful completion awards:
> 1. **Massive Bounty Gold**: 5 to 25 Gold (scales with guild level / progression).
> 2. **Targeted Material Caches**: Bundles of 10–20 high-demand crafting materials matching the theme (e.g. Black Iron, Mithril, Orichalcum, Ancestral Blood, Abyssal Ingots).
> 3. **Bounty Geode**: 1× Geode with standard gem yields (20, 50, or 100 Gems).

---

## Proposed Changes

### UI & Presentation
#### [NEW] [card_contract.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/layout/card_contract.xml)
- Card layout for the Guild Activities tab matching the aesthetic of `card_hunt.xml` and `card_siege.xml`.
- Displays contract title, remaining time countdown, bounty reward preview, and status try dot.

#### [MODIFY] [fragment_guild_activities.xml](file:///c:/Repositories/IGM-Modded/app/src/main/res/layout/fragment_guild_activities.xml)
- Add the Mercenary Contract card between The Hunt and The Siege.

---

### Game Logic & Data
#### [NEW] [MercenaryContractArea.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/places/raids/MercenaryContractArea.kt)
- Extends `RaidArea` with `maxTeamSize = 5`.
- Implements daily enemy pool selection based on `dayOfWeek`.
- Enforces strict 1-try lifecycle: `hasAttemptedToday` flag persisted in save data.

#### [MODIFY] [Data.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/Data.kt)
- Add `@SerializedName("mercenaryContract") var mercenaryContract: MercenaryContractArea?`.
- Add `@SerializedName("mercenaryContractTryUsed") var isMercenaryContractTryUsed: Boolean`.

#### [MODIFY] [GuildActivitiesState.kt](file:///c:/Repositories/IGM-Modded/app/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/game/activities/GuildActivitiesState.kt)
- Add contract reset logic to daily boundary rollover (00:00 UTC).

---

## Verification Plan

### Automated Tests
- In `GuildActivitiesTest.kt`:
  - `testContractTeamSizeCap()`: verify maximum 5 units allowed.
  - `testContractSingleTryConsumption()`: verify retreating or wiping sets `isMercenaryContractTryUsed = true` and prevents further entries.
  - `testContractDailyReset()`: verify rollover at midnight UTC resets the attempt flag and updates the daily contract.
  - `testContractRewardDistribution()`: verify gold, material caches, and geode are awarded on victory.
