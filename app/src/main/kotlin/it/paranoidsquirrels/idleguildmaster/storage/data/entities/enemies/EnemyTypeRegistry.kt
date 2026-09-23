package it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies

object EnemyTypeRegistry {
    private val TYPE_MAP: Map<String, EnemyType> = mapOf(
        // SLIME (8)
        "ElectricSlime" to EnemyType.SLIME,
        "FireSlime" to EnemyType.SLIME,
        "FrozenSlime" to EnemyType.SLIME,
        "KnightSlime" to EnemyType.SLIME,
        "Slime" to EnemyType.SLIME,
        "SlimeKing" to EnemyType.SLIME,
        "Ultraslime" to EnemyType.SLIME,
        "VoidSlime" to EnemyType.SLIME,

        // DRAGON (2)
        "DreamwroughtDragon" to EnemyType.DRAGON,
        "SnowWyvern" to EnemyType.DRAGON,

        // PLANT (5)
        "AmanitaObscura" to EnemyType.PLANT,
        "AncientEnt" to EnemyType.PLANT,
        "Dryad" to EnemyType.PLANT,
        "Ent" to EnemyType.PLANT,
        "Treant" to EnemyType.PLANT,

        // UNDEAD (12)
        "Banshee" to EnemyType.UNDEAD,
        "BoneNightmareEnemy" to EnemyType.UNDEAD,
        "EtherealSoul" to EnemyType.UNDEAD,
        "Ghoul" to EnemyType.UNDEAD,
        "HeadlessKnight" to EnemyType.UNDEAD,
        "KabarTheRotten" to EnemyType.UNDEAD,
        "Lazarus" to EnemyType.UNDEAD,
        "LostMiner" to EnemyType.UNDEAD,
        "Phantasm" to EnemyType.UNDEAD,
        "Undead" to EnemyType.UNDEAD,
        "UndeadArcher" to EnemyType.UNDEAD,
        "UndeadGeneral" to EnemyType.UNDEAD,
        "UndeadWarlord" to EnemyType.UNDEAD,

        // DEMON (3)
        "EmperorClovisXXVIII" to EnemyType.DEMON,
        "Imp" to EnemyType.DEMON,
        "SandDemon" to EnemyType.DEMON,

        // CONSTRUCT (9)
        "DreamwroughtForge" to EnemyType.CONSTRUCT,
        "Gcss" to EnemyType.CONSTRUCT,
        "MagicArmor" to EnemyType.CONSTRUCT,
        "Mimic" to EnemyType.CONSTRUCT,
        "Necrobot" to EnemyType.CONSTRUCT,
        "ObsidianGolem" to EnemyType.CONSTRUCT,
        "ReinforcedDoor" to EnemyType.CONSTRUCT,
        "SandStatue" to EnemyType.CONSTRUCT,
        "TheMachine" to EnemyType.CONSTRUCT,

        // ELEMENTAL (5)
        "Djinn" to EnemyType.ELEMENTAL,
        "ForestSpirit" to EnemyType.ELEMENTAL,
        "IceElemental" to EnemyType.ELEMENTAL,
        "Phoenix" to EnemyType.ELEMENTAL,
        "WillOWisp" to EnemyType.ELEMENTAL,

        // BEAST (18)
        "Boar" to EnemyType.BEAST,
        "DeathHound" to EnemyType.BEAST,
        "DreamwroughtBeast" to EnemyType.BEAST,
        "DreamwroughtSwarm" to EnemyType.BEAST,
        "EldritchHound" to EnemyType.BEAST,
        "GiantMoth" to EnemyType.BEAST,
        "GiantSpider" to EnemyType.BEAST,
        "GiantTortoise" to EnemyType.BEAST,
        "GoldenRabbit" to EnemyType.BEAST,
        "GreenSpitfang" to EnemyType.BEAST,
        "PrimevalWurm" to EnemyType.BEAST,
        "Pterodactyl" to EnemyType.BEAST,
        "SandVulture" to EnemyType.BEAST,
        "Terrorsaurus" to EnemyType.BEAST,
        "TutorialWolf" to EnemyType.BEAST,
        "VampireBat" to EnemyType.BEAST,
        "Wolf" to EnemyType.BEAST,
        "Wurm" to EnemyType.BEAST,

        // ABERRATION (19)
        "Abomination" to EnemyType.ABERRATION,
        "AvatarOfTheAncient" to EnemyType.ABERRATION,
        "Beholder" to EnemyType.ABERRATION,
        "CelestialDestroyer" to EnemyType.ABERRATION,
        "CelestialLancer" to EnemyType.ABERRATION,
        "Cerebrum" to EnemyType.ABERRATION,
        "Iconoclast" to EnemyType.ABERRATION,
        "LesserTitan" to EnemyType.ABERRATION,
        "MysteriousTentacle" to EnemyType.ABERRATION,
        "Necrolith" to EnemyType.ABERRATION,
        "Oculus" to EnemyType.ABERRATION,
        "PrimordialTitan" to EnemyType.ABERRATION,
        "ShaTheHiddenGod" to EnemyType.ABERRATION,
        "Shadow" to EnemyType.ABERRATION,
        "Singularity" to EnemyType.ABERRATION,
        "SmolderingTitan" to EnemyType.ABERRATION,
        "TekeliLiFirstApostle" to EnemyType.ABERRATION,
        "TheAncient" to EnemyType.ABERRATION,
        "WickedTribute" to EnemyType.ABERRATION,

        // HUMANOID (43)
        "ArcaneAssassin" to EnemyType.HUMANOID,
        "ArchmageOfLarox" to EnemyType.HUMANOID,
        "Berserker" to EnemyType.HUMANOID,
        "BleakDeacon" to EnemyType.HUMANOID,
        "BleakDisciple" to EnemyType.HUMANOID,
        "Centaur" to EnemyType.HUMANOID,
        "ChiefScientistAva" to EnemyType.HUMANOID,
        "CityWarden" to EnemyType.HUMANOID,
        "Claris" to EnemyType.HUMANOID,
        "Crusader" to EnemyType.HUMANOID,
        "Deckhand" to EnemyType.HUMANOID,
        "Enforcer" to EnemyType.HUMANOID,
        "FirstMinisterAtos" to EnemyType.HUMANOID,
        "HeraldKali" to EnemyType.HUMANOID,
        "HeraldMaya" to EnemyType.HUMANOID,
        "HeraldShoran" to EnemyType.HUMANOID,
        "HeraldXavi" to EnemyType.HUMANOID,
        "ImperialCaptain" to EnemyType.HUMANOID,
        "ImperialGuard" to EnemyType.HUMANOID,
        "ImperialMage" to EnemyType.HUMANOID,
        "InsaneCitizen" to EnemyType.HUMANOID,
        "InsaneMerchant" to EnemyType.HUMANOID,
        "InsanePriest" to EnemyType.HUMANOID,
        "KasimirTheSeer" to EnemyType.HUMANOID,
        "KingAino" to EnemyType.HUMANOID,
        "LegateHadrian" to EnemyType.HUMANOID,
        "NexusResearcher" to EnemyType.HUMANOID,
        "PaleHermit" to EnemyType.HUMANOID,
        "Pirate" to EnemyType.HUMANOID,
        "PirateCaptain" to EnemyType.HUMANOID,
        "PirateLieutenant" to EnemyType.HUMANOID,
        "ShaKireFirstSwordsman" to EnemyType.HUMANOID,
        "ShahuriArcher" to EnemyType.HUMANOID,
        "ShahuriMage" to EnemyType.HUMANOID,
        "ShahuriWarrior" to EnemyType.HUMANOID,
        "StoneShaman" to EnemyType.HUMANOID,
        "TheExiled" to EnemyType.HUMANOID,
        "Thorvus" to EnemyType.HUMANOID,
        "Troll" to EnemyType.HUMANOID,
        "TrollShaman" to EnemyType.HUMANOID,
        "TrollWarrior" to EnemyType.HUMANOID,
        "TrollWhelp" to EnemyType.HUMANOID,
        "WizardOfLarox" to EnemyType.HUMANOID
    )

    @JvmStatic
    fun getTypeForClass(className: String): EnemyType {
        // Strip Elite_ prefix if present
        val baseName = if (className.startsWith("Elite_")) className.substring("Elite_".length) else className
        return TYPE_MAP[baseName] ?: EnemyType.HUMANOID
    }
}
