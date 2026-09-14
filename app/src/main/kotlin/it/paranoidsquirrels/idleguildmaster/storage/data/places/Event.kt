package it.paranoidsquirrels.idleguildmaster.storage.data.places

class Event {
    companion object {
        const val ANGRY_EYE = "angry_eye"
        const val BLIZZARD = "blizzard"
        const val ENRAGED_SPIRIT = "enraged_spirit"
        const val HALLS_EXPLORATION = "halls_exploration"
        const val HALLS_SKELETON_DOOR = "halls_skeleton_door"
        const val LOST_EXPEDITION_TRAPDOOR = "lost_expedition_trapdoor"
        const val MAGIC_AMPLIFICATION = "magic_amplification"
        const val PRIMEVAL_WURM_COOLDOWN = "primeval_wurm_cooldown"
        const val PRIMEVAL_WURM_PROGRESS = "primeval_wurm_progress"
        const val PYRAMID_DOOR_OPEN = "pyramid_door_open"
        const val SHAHURI_ARMY_CHARGING = "shahuri_army_charging"
        const val SHAHURI_ARMY_READY = "shahuri_army_ready"
        const val SUMMON_SMOLDERING_TITAN = "summon_smoldering_titan"
        const val THE_KRAKEN = "the_kraken"
        const val THE_KRAKEN_FIGHT = "the_kraken_fight"
        const val TUTORIAL = "tutorial"
        const val UNSPEAKABLE_HORROR = "unspeakable_horror"
        const val UNSPEAKABLE_HORROR_COOLDOWN = "unspeakable_horror_cooldown"
        const val WILL_O_WISP_HUNT = "will_o_wisp_hunt"
    }

    var key: Int = 0
    var progress: Int = 0

    constructor()

    constructor(event: String) {
        key = when (event) {
            SHAHURI_ARMY_CHARGING,
            UNSPEAKABLE_HORROR,
            PYRAMID_DOOR_OPEN,
            WILL_O_WISP_HUNT,
            BLIZZARD,
            ANGRY_EYE,
            LOST_EXPEDITION_TRAPDOOR,
            MAGIC_AMPLIFICATION,
            HALLS_EXPLORATION,
            ENRAGED_SPIRIT,
            THE_KRAKEN,
            SUMMON_SMOLDERING_TITAN,
            PRIMEVAL_WURM_PROGRESS -> 1

            PRIMEVAL_WURM_COOLDOWN,
            THE_KRAKEN_FIGHT,
            HALLS_SKELETON_DOOR,
            TUTORIAL,
            SHAHURI_ARMY_READY,
            UNSPEAKABLE_HORROR_COOLDOWN -> 2

            else -> 0
        }
    }
}
