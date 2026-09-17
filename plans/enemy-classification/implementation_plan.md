# Implementation Plan: Enemy Classification (Boss & Elite System)

## Goal Description
Implement an explicit categorization system in Enemy to identify whether an enemy is a **Boss** or an **Elite**. Normal enemies will have both flags set to alse.

---

## 1. Enemy Mappings

### 1.1 Elite Enemies (11)
Normal encounters/mini-bosses classified as Elite:
1. **Forest Spirit** (ForestSpirit)
2. **Djinn** (Djinn)
3. **Abomination** (Abomination)
4. **Imperial Captain** (ImperialCaptain)
5. **Snow Wyvern** (SnowWyvern)
6. **Pale Hermit** (PaleHermit)
7. **Primeval Wurm** (PrimevalWurm)
8. **Wicked Tribute** (WickedTribute)
9. **Smoldering Titan** (SmolderingTitan)
10. **Undead General** (UndeadGeneral)
11. **Sand Demon** (SandDemon)

### 1.2 Boss Enemies (26)
Dungeon, Raid, and Event major bosses classified as Boss:
1. **Slime King** (SlimeKing)
2. **Sha\'kire** (ShaKireFirstSwordsman)
3. **Sha** (ShaTheHiddenGod)
4. **Kabar** (KabarTheRotten)
5. **Emperor Clovis** (EmperorClovisXXVIII)
6. **Claris** (Claris)
7. **Thovus** (Thorvus)
8. **Primodial Titan** (PrimordialTitan)
9. **Kasimir** (KasimirTheSeer)
10. **Herald Kali** (HeraldKali)
11. **Tekeli** (TekeliLiFirstApostle)
12. **Avatar of the Ancient** (AvatarOfTheAncient)
13. **Legate** (LegateHadrian)
14. **Xavi** (HeraldXavi)
15. **Maya** (HeraldMaya)
16. **Shoran** (HeraldShoran)
17. **Singularity** (Singularity)
18. **King Aino** (KingAino)
19. **Atos** (FirstMinisterAtos)
20. **Lazarus** (Lazarus)
21. **Phoenix** (Phoenix)
22. **Headless Knight** (HeadlessKnight)
23. **Ultraslime** (Ultraslime)
24. **The Exiled** (TheExiled)
25. **The Ancient** (TheAncient)
26. **The Machine** (TheMachine)

---

## 2. Technical Architecture

### 2.1 Central Registry
Create EnemyClassificationRegistry.kt under storage/data/entities/enemies/:
- Defines al ELITE_CLASSES: Set<String> containing the 11 elite class names.
- Defines al BOSS_CLASSES: Set<String> containing the 26 boss class names.
- Provides utility functions:
  - un isElite(trueClass: String?): Boolean
  - un isBoss(trueClass: String?): Boolean

### 2.2 Enemy Base Class
In Enemy.kt:
- Add query functions:
  - open fun isBoss(): Boolean = EnemyClassificationRegistry.isBoss(trueClass ?: this::class.java.simpleName)
  - open fun isElite(): Boolean = EnemyClassificationRegistry.isElite(trueClass ?: this::class.java.simpleName)
- Normal enemies return alse for both by default.

### 2.3 UI Indicators
In DialogEntityDetail.kt:
- In initialize() where enemy details are bound:
  - Check e.isBoss() and e.isElite().
  - If isBoss(): render a bold [Boss] badge in gold/red next to the enemy name or attack type.
  - If isElite(): render a bold [Elite] badge in purple/silver next to the enemy name or attack type.

---

## 3. Proposed Changes

### [NEW] EnemyClassificationRegistry.kt
- Path: pp/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/EnemyClassificationRegistry.kt
- Implements set lookups for Elites and Bosses.

### [MODIFY] Enemy.kt
- Path: pp/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/storage/data/entities/enemies/Enemy.kt
- Adds isBoss() and isElite() methods.

### [MODIFY] DialogEntityDetail.kt
- Path: pp/src/main/kotlin/it/paranoidsquirrels/idleguildmaster/ui/dialogs/DialogEntityDetail.kt
- Displays [Boss] or [Elite] tag.

---

## 4. Verification Plan

### Automated Verification
1. Compilation check via Gradle / uild_mod.ps1.
2. Unit verification script:
   - Instantiate all 11 Elites -> assert isElite() == true and isBoss() == false.
   - Instantiate all 26 Bosses -> assert isBoss() == true and isElite() == false.
   - Instantiate normal enemies (e.g. Wolf, Skeleton, Rat) -> assert both are alse.

### Manual Verification
1. Launch game, open enemy detail sheet for Slime King -> confirm [Boss] badge.
2. Open enemy detail sheet for Forest Spirit -> confirm [Elite] badge.
3. Open regular monster detail sheet -> confirm no badges displayed.
