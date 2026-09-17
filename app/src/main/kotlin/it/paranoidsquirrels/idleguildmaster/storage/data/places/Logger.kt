package it.paranoidsquirrels.idleguildmaster.storage.data.places

import android.content.res.Resources
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDungeonDetail

object Logger {
    const val ABILITY_CASTED = 29
    const val ADVENTURER_SLAIN = 38
    const val AMULET_OF_RESURRECTION = 119
    const val ARCANE_SUPPRESSION = 116
    const val BARD_SHIELD = 120
    const val YELLOW_LOG = 121
    const val STATUS_BLOODBLAZE = 122
    const val BOTCHED_OFFERING = 115
    private const val COLOR_FORMAT = "<font color=%s><strong>%s</strong></font>"
    const val DARKNESS_DESCRIPTION = 1
    const val DEAL_DAMAGE = 33
    const val DECAY = 20
    const val DODGE_BASIC_ATTACK = 21
    const val DODGE_FLYING = 45
    const val DODGE_GENERIC = 22
    const val DROP = 8
    const val DUNGEON_UNLOCKED = 56
    const val ENEMY_SLAIN = 36
    const val ESCAPE = 43
    const val EVENT = 100
    const val EVENT_BENEFICIAL = 102
    const val EVENT_EYE_DRAW = 48
    const val EVENT_HARMFUL = 101
    const val EVENT_MAGIC_AMPLIFICATION = 109
    const val EVENT_SHAHURI = 44
    const val EVENT_SIGNIFICANT = 103
    const val EVENT_WILL_O_WISP = 47
    const val EVENT_WURM_APPROACHING = 104
    const val EXECUTION = 34
    const val EXP_GAIN = 6
    const val FLEE = 3
    const val FROSTBITE_PEAKS_CRATE_FAILURE = 52
    const val FROSTBITE_PEAKS_CRATE_FOUND = 51
    const val FROSTBITE_PEAKS_CRATE_SUCCESS = 53
    private const val GREEN = "#3CC83C"
    const val HEAL = 24
    const val HEALING_NOVA = 117
    const val ITEM_FOUND = 40
    const val LEVEL_UP = 7
    const val LIFE_STEAL = 35
    const val LOG_PET_DAMAGE = 105
    const val LOG_PET_HEAL = 106
    const val LOST_EXPEDITION_FALL_DAMAGE = 112
    const val MINION_REANIMATED = 39
    const val MINION_SLAIN = 37
    const val NOTHING_FOUND = 41
    private const val NO_COLOR_FORMAT = "<strong>%s</strong>"
    const val NO_DROPS = 9
    private const val ORANGE = "#C86400"
    const val PARRY_BASIC_ATTACK = 31
    const val PARRY_GENERIC = 32
    const val PET_DECOY = 107
    const val PET_EXECUTION = 108
    const val PROGRESS = 55
    private const val RED = "#C84646"
    private const val RED_COLORBLIND = "#FFC8C8"
    const val REGENERATION = 49
    private var RESOURCES: Resources? = null
    const val RESPAWN = 4
    const val RETALIATION_DAMAGE = 46
    const val REVIVE = 30
    const val RITUAL_SUMMON_SMOLDERING_TITAN = 113
    const val STATUS_APPLIED = 11
    const val STATUS_APPLIED_FOREVER = 12
    const val STATUS_BLEED = 19
    const val STATUS_CLEARED = 10
    const val STATUS_FEEBLE_TETHER = 110
    const val STATUS_FROZEN = 50
    const val STATUS_ON_FIRE = 17
    const val STATUS_PETRIFIED = 111
    const val STATUS_POISONED = 14
    const val STATUS_REGENERATING = 18
    const val STATUS_SILENCED = 16
    const val STATUS_STUNNED = 15
    const val STATUS_TAUNTED = 13
    const val STATUS_TERRIFIED = 118
    const val SUMMON_SMOLDERING_TITAN = 114
    const val TEAM_DEAD = 2
    const val TRAP_AVOIDED = 26
    const val TRAP_DESCRIPTION = 25
    const val TRAP_DISARMED = 28
    const val TRAP_NOT_AVOIDED = 27
    const val VICTORY = 5
    private const val YELLOW = "#C8C800"

    @JvmStatic
    fun log(area: Area?, i: Int, vararg objArr: Any?) {
        val dialogDungeonDetail = MainActivity.shownDialogDungeonDetail
        if (Utils.isMainLooper() && dialogDungeonDetail != null && dialogDungeonDetail.area == area) {
            if (RESOURCES == null) {
                val frag = MainActivity.dungeonsFragment
                if (frag == null || frag.context == null) {
                    return
                } else {
                    RESOURCES = frag.resources
                }
            }
            val res = RESOURCES ?: return
            val zIsSettingVerboseLogs = MainActivity.data.isSettingVerboseLogs
            var z = true
            var strWrap: String? = null
            var red5 = GREEN
            var entity: Entity? = null
            var statusEffect: StatusEffect? = null
            var entity2: Entity? = null
            var statusEffect2: StatusEffect? = null
            var red = GREEN
            var red2 = GREEN
            var red3 = GREEN
            var red4 = GREEN

            when (i) {
                121 -> {
                    val formatArgs = objArr.drop(1).toTypedArray()
                    strWrap = wrap(String.format(RESOURCES!!.getString((objArr[0] as Number).toInt()), *formatArgs), YELLOW)
                }
                55 -> {
                    strWrap = wrap(String.format(RESOURCES!!.getString(R.string.log_progress), RESOURCES!!.getString((objArr[0] as Number).toInt()), (objArr[1] as Number).toInt(), (objArr[2] as Number).toInt()), YELLOW)
                }
                56 -> {
                    strWrap = wrap(String.format(RESOURCES!!.getString(R.string.log_dungeon_unlocked), RESOURCES!!.getString((objArr[0] as Number).toInt())), YELLOW)
                }
                1 -> {
                    if (zIsSettingVerboseLogs) {
                        val iIntValue = (objArr[0] as Number).toInt()
                        if (iIntValue != 0) {
                            strWrap = UIUtils.darknessDescription(iIntValue, RESOURCES)
                        }
                    }
                }
                2 -> {
                    strWrap = wrap(RESOURCES!!.getString(R.string.log_defeat), getRed())
                }
                3 -> {
                    strWrap = RESOURCES!!.getString(R.string.log_flee)
                }
                4 -> {
                    strWrap = RESOURCES!!.getString(R.string.log_respawn)
                }
                5 -> {
                    strWrap = wrap(RESOURCES!!.getString(R.string.log_victory), GREEN)
                }
                6 -> {
                    strWrap = String.format(RESOURCES!!.getString(R.string.log_exp_gain), wrap(RESOURCES!!.getString((objArr[0] as Number).toInt()), GREEN), wrap((objArr[1] as Number).toInt(), ORANGE))
                }
                7 -> {
                    strWrap = wrap(String.format(RESOURCES!!.getString(R.string.log_level_gain), RESOURCES!!.getString((objArr[0] as Number).toInt())), ORANGE)
                }
                8 -> {
                    strWrap = String.format(RESOURCES!!.getString(R.string.log_loot_item), wrap(RESOURCES!!.getString((objArr[0] as Number).toInt()), getRed()), wrap((objArr[1] as Number).toInt(), ORANGE), wrap(RESOURCES!!.getString((objArr[2] as Number).toInt()), ORANGE))
                }
                9 -> {
                    strWrap = RESOURCES!!.getString(R.string.log_no_drops)
                }
                10 -> {
                    if (zIsSettingVerboseLogs) {
                    val entity3 = objArr[0] as Entity
                    val statusEffectType = objArr[1] as StatusEffectType
                    var string = RESOURCES!!.getString(R.string.status_effect_log_end)
                    var strWrap2 = wrap(RESOURCES!!.getString(entity3.idName), (if (entity3 is Enemy) getRed() else GREEN))
                    var string2 = RESOURCES!!.getString(statusEffectType.logDescription)
                    if (statusEffectType.negative) {
                    red5 = getRed()
                    }
                    strWrap = String.format(string, strWrap2, wrap(string2, red5))
                    }
                }
                11 -> {
                    if (zIsSettingVerboseLogs) {
                    var zEquals = "ko".equals(RESOURCES!!.getString(R.string.language_code))
                    val entity4 = objArr[0] as Entity
                    val statusEffectType2 = objArr[1] as StatusEffectType
                    val iIntValue2 = (objArr[2] as Number).toInt()
                    var strWrap3 = wrap(RESOURCES!!.getString(statusEffectType2.logDescription), (if (statusEffectType2.negative) getRed() else GREEN))
                    var strWrap4 = wrap(iIntValue2, (if (statusEffectType2.negative) getRed() else GREEN))
                    var string3 = RESOURCES!!.getString(R.string.log_effect)
                    var string4 = RESOURCES!!.getString(entity4.idName)
                    if (entity4 is Enemy) {
                    red5 = getRed()
                    }
                    var strWrap5 = wrap(string4, red5)
                    var str = (if (zEquals) strWrap4 else strWrap3)
                    if (!zEquals) {
                    strWrap3 = strWrap4
                    }
                    strWrap = String.format(string3, strWrap5, str, strWrap3)
                    }
                }
                12 -> {
                    if (zIsSettingVerboseLogs) {
                    val entity5 = objArr[0] as Entity
                    val statusEffectType3 = objArr[1] as StatusEffectType
                    var string5 = RESOURCES!!.getString(R.string.status_effect_log_simple_omit_turns)
                    var strWrap6 = wrap(RESOURCES!!.getString(entity5.idName), (if (entity5 is Enemy) getRed() else GREEN))
                    var string6 = RESOURCES!!.getString(statusEffectType3.logDescription)
                    if (statusEffectType3.negative) {
                    red5 = getRed()
                    }
                    strWrap = String.format(string5, strWrap6, wrap(string6, red5))
                    }
                }
                13 -> {
                    if (zIsSettingVerboseLogs) {
                    var zEquals2 = "ko".equals(RESOURCES!!.getString(R.string.language_code))
                    val entity6 = objArr[0] as Entity
                    val statusEffect3 = objArr[1] as StatusEffect
                    var strWrap7 = wrap(RESOURCES!!.getString(statusEffect3.type!!.logDescription), (if (statusEffect3.type!!.negative) getRed() else GREEN))
                    var strWrap8 = wrap(RESOURCES!!.getString(statusEffect3.cause!!.idName), (if (statusEffect3.cause is Enemy) getRed() else GREEN))
                    var string7 = RESOURCES!!.getString(R.string.status_effect_log_cause)
                    var strWrap9 = wrap(RESOURCES!!.getString(entity6.idName), (if (entity6 is Enemy) getRed() else GREEN))
                    var str2 = (if (zEquals2) strWrap8 else strWrap7)
                    if (!zEquals2) {
                    strWrap7 = strWrap8
                    }
                    val turnsLeft = statusEffect3.turnsLeft
                    if (statusEffect3.type!!.negative) {
                    red5 = getRed()
                    }
                    strWrap = String.format(string7, strWrap9, str2, strWrap7, wrap(turnsLeft, red5))
                    }
                }
                14, 15, 16, 18 -> {
                    if (!zIsSettingVerboseLogs) {
                    entity = objArr[0] as Entity
                    statusEffect = objArr[1] as StatusEffect
                    var string8 = RESOURCES!!.getString(R.string.status_effect_log_simple)
                    var string9 = RESOURCES!!.getString(entity.idName)
                    if (entity is Enemy) {
                    red = getRed()
                    } else {
                    red = GREEN
                    }
                    var strWrap10 = wrap(string9, red)
                    var string10 = RESOURCES!!.getString(statusEffect.type!!.logDescription)
                    if (statusEffect.type!!.negative) {
                    red2 = getRed()
                    } else {
                    red2 = GREEN
                    }
                    var strWrap11 = wrap(string10, red2)
                    val turnsLeft2 = statusEffect.turnsLeft
                    if (statusEffect.type!!.negative) {
                    red5 = getRed()
                    }
                    strWrap = String.format(string8, strWrap10, strWrap11, wrap(turnsLeft2, red5))
                    }
                }
                17, 19, 122 -> {
                    if (zIsSettingVerboseLogs) {
                    entity2 = objArr[0] as Entity
                    statusEffect2 = objArr[1] as StatusEffect
                    val iIntValue3 = (objArr[2] as Number).toInt()
                    var string11 = RESOURCES!!.getString(R.string.status_effect_log_damage)
                    var string12 = RESOURCES!!.getString(entity2.idName)
                    if (entity2 is Enemy) {
                    red3 = getRed()
                    } else {
                    red3 = GREEN
                    }
                    var strWrap12 = wrap(string12, red3)
                    var string13 = RESOURCES!!.getString(statusEffect2.type!!.logDescription)
                    if (statusEffect2.type!!.negative) {
                    red4 = getRed()
                    } else {
                    red4 = GREEN
                    }
                    var strWrap13 = wrap(string13, red4)
                    var strWrap14 = wrap(iIntValue3, getRed())
                    val turnsLeft3 = statusEffect2.turnsLeft
                    if (statusEffect2.type!!.negative) {
                    red5 = getRed()
                    }
                    strWrap = String.format(string11, strWrap12, strWrap13, strWrap14, wrap(turnsLeft3, red5))
                    }
                }
                20 -> {
                    if (zIsSettingVerboseLogs) {
                    val entity7 = objArr[0] as Entity
                    val iIntValue4 = (objArr[1] as Number).toInt()
                    var string14 = RESOURCES!!.getString(R.string.log_decay)
                    var string15 = RESOURCES!!.getString(entity7.idName)
                    if (entity7 is Enemy) {
                    red5 = getRed()
                    }
                    strWrap = String.format(string14, wrap(string15, red5), wrap(iIntValue4, getRed()))
                    }
                }
                21 -> {
                    val entity8 = objArr[0] as Entity
                    val entity9 = objArr[1] as Entity
                    val iIntValue5 = (objArr[2] as Number).toInt()
                    var string16 = RESOURCES!!.getString(R.string.log_dodge_attack)
                    var strWrap15 = wrap(RESOURCES!!.getString(entity8.idName), (if (entity8 is Enemy) getRed() else GREEN))
                    var string17 = RESOURCES!!.getString(entity9.idName)
                    if (entity9 is Enemy) {
                    red5 = getRed()
                    }
                    strWrap = String.format(string16, strWrap15, wrap(string17, red5), wrap(iIntValue5, null))
                }
                22 -> {
                    val entity10 = objArr[0] as Entity
                    val iIntValue6 = (objArr[1] as Number).toInt()
                    var string18 = RESOURCES!!.getString(R.string.log_dodge_skill)
                    var string19 = RESOURCES!!.getString(entity10.idName)
                    if (entity10 is Enemy) {
                    red5 = getRed()
                    }
                    strWrap = String.format(string18, wrap(string19, red5), wrap(iIntValue6, null))
                }
                24 -> {
                    val iIntValue7 = (objArr[0] as Number).toInt()
                    val entity11 = objArr[1] as Entity
                    val entity12 = objArr[2] as Entity
                    val iIntValue8 = (objArr[3] as Number).toInt()
                    var z2 = java.lang.Boolean.parseBoolean(RESOURCES!!.getString(R.string.swap_amount_and_target_in_logs))
                    var strWrap16 = wrap(RESOURCES!!.getString(entity11.idName), (if (entity11 is Enemy) getRed() else GREEN))
                    var strWrap17 = wrap(iIntValue8, GREEN)
                    var string20 = RESOURCES!!.getString(entity12.idName)
                    if (entity12 is Enemy) {
                    red5 = getRed()
                    }
                    var strWrap18 = wrap(string20, red5)
                    var string21 = RESOURCES!!.getString(R.string.log_healing)
                    var str3 = (if (z2) strWrap18 else strWrap17)
                    if (!z2) {
                    strWrap17 = strWrap18
                    }
                    var str4 = String.format(string21, strWrap16, str3, strWrap17)
                    if (iIntValue7 == 1) {
                    str4 = str4 + " " + wrap(RESOURCES!!.getString(R.string.log_critical_hit), null)
                    }
                    strWrap = (if (iIntValue7 != 2) str4 else str4 + " " + wrap(RESOURCES!!.getString(R.string.log_devastating_hit), null))
                }
                25 -> {
                    strWrap = String.format(RESOURCES!!.getString(R.string.log_trap_roll_description), wrap(RESOURCES!!.getString((objArr[0] as Number).toInt()), null), wrap((objArr[1] as Number).toInt(), null))
                }
                26 -> {
                    val entity13 = objArr[0] as Entity
                    val iIntValue9 = (objArr[1] as Number).toInt()
                    var string22 = RESOURCES!!.getString(R.string.log_trap_avoided)
                    var string23 = RESOURCES!!.getString(entity13.idName)
                    if (entity13 is Enemy) {
                    red5 = getRed()
                    }
                    strWrap = String.format(string22, wrap(string23, red5), wrap(iIntValue9, null))
                }
                27 -> {
                    val entity14 = objArr[0] as Entity
                    val iIntValue10 = (objArr[1] as Number).toInt()
                    val iIntValue11 = (objArr[2] as Number).toInt()
                    var string24 = RESOURCES!!.getString(R.string.log_trap_not_avoided)
                    var string25 = RESOURCES!!.getString(entity14.idName)
                    if (entity14 is Enemy) {
                    red5 = getRed()
                    }
                    strWrap = String.format(string24, wrap(string25, red5), wrap(iIntValue10, getRed()), wrap(iIntValue11, null))
                }
                28 -> {
                    val entity15 = objArr[0] as Entity
                    var string26 = RESOURCES!!.getString(R.string.log_trap_disarmed)
                    var string27 = RESOURCES!!.getString(entity15.idName)
                    if (entity15 is Enemy) {
                    red5 = getRed()
                    }
                    strWrap = String.format(string26, wrap(string27, red5))
                }
                29 -> {
                    val entity16 = objArr[0] as Entity
                    var str5 = String.format(RESOURCES!!.getString(R.string.log_skill), RESOURCES!!.getString(entity16.idName), RESOURCES!!.getString(entity16.activeSkill!!.nameRes))
                    if (entity16 is Enemy) {
                    red5 = getRed()
                    }
                    strWrap = wrap(str5, red5)
                }
                30 -> {
                    val entity17 = objArr[0] as Entity
                    val entity18 = objArr[1] as Entity
                    var string28 = RESOURCES!!.getString(R.string.log_revive)
                    var strWrap19 = wrap(RESOURCES!!.getString(entity17.idName), (if (entity17 is Enemy) getRed() else GREEN))
                    var string29 = RESOURCES!!.getString(entity18.idName)
                    if (entity18 is Enemy) {
                    red5 = getRed()
                    }
                    strWrap = String.format(string28, strWrap19, wrap(string29, red5))
                }
                31 -> {
                    val entity19 = objArr[0] as Entity
                    val entity20 = objArr[1] as Entity
                    var string30 = RESOURCES!!.getString(R.string.log_parry_attack)
                    var strWrap20 = wrap(RESOURCES!!.getString(entity19.idName), (if (entity19 is Enemy) getRed() else GREEN))
                    var string31 = RESOURCES!!.getString(entity20.idName)
                    if (entity20 is Enemy) {
                    red5 = getRed()
                    }
                    strWrap = String.format(string30, strWrap20, wrap(string31, red5))
                }
                32 -> {
                    val entity21 = objArr[0] as Entity
                    var string32 = RESOURCES!!.getString(R.string.log_parry_skill)
                    var string33 = RESOURCES!!.getString(entity21.idName)
                    if (entity21 is Enemy) {
                    red5 = getRed()
                    }
                    strWrap = String.format(string32, wrap(string33, red5))
                }
                33 -> {
                    val iIntValue12 = (objArr[0] as Number).toInt()
                    val iIntValue13 = (objArr[1] as Number).toInt()
                    val entity22 = objArr[2] as Entity
                    val entity23 = objArr[3] as Entity
                    val iIntValue14 = (objArr[4] as Number).toInt()
                    var z3 = java.lang.Boolean.parseBoolean(RESOURCES!!.getString(R.string.swap_amount_and_target_in_logs))
                    var strWrap21 = wrap(RESOURCES!!.getString(entity22.idName), (if (entity22 is Enemy) getRed() else GREEN))
                    var strWrap22 = wrap(iIntValue14, getRed())
                    var string34 = RESOURCES!!.getString(entity23.idName)
                    if (entity23 is Enemy) {
                    red5 = getRed()
                    }
                    var strWrap23 = wrap(string34, red5)
                    var string35 = RESOURCES!!.getString(iIntValue12)
                    var str6 = (if (z3) strWrap23 else strWrap22)
                    if (!z3) {
                    strWrap22 = strWrap23
                    }
                    var str7 = String.format(string35, strWrap21, str6, strWrap22)
                    if (iIntValue13 == 1) {
                    str7 = str7 + " " + wrap(RESOURCES!!.getString(R.string.log_critical_hit), null)
                    }
                    strWrap = (if (iIntValue13 != 2) str7 else str7 + " " + wrap(RESOURCES!!.getString(R.string.log_devastating_hit), null))
                }
                34 -> {
                    val entity24 = objArr[0] as Entity
                    val entity25 = objArr[1] as Entity
                    var string36 = RESOURCES!!.getString(R.string.log_execution)
                    var strWrap24 = wrap(RESOURCES!!.getString(entity24.idName), (if (entity24 is Enemy) getRed() else GREEN))
                    var string37 = RESOURCES!!.getString(entity25.idName)
                    if (entity25 is Enemy) {
                    red5 = getRed()
                    }
                    strWrap = String.format(string36, strWrap24, wrap(string37, red5))
                }
                35 -> {
                    val entity26 = objArr[0] as Entity
                    strWrap = String.format(RESOURCES!!.getString(R.string.log_lifesteal), wrap(RESOURCES!!.getString(entity26.idName), (if (entity26 is Enemy) getRed() else GREEN)), wrap((objArr[1] as Number).toInt(), GREEN))
                }
                36 -> {
                    strWrap = String.format(RESOURCES!!.getString(R.string.log_enemy_death), wrap(RESOURCES!!.getString((objArr[0] as Number).toInt()), getRed()))
                }
                37 -> {
                    strWrap = String.format(RESOURCES!!.getString(R.string.log_reanimated_unit_death), wrap(RESOURCES!!.getString((objArr[0] as Number).toInt()), GREEN))
                }
                38 -> {
                    val iIntValue15 = (objArr[0] as Number).toInt()
                    strWrap = if ((objArr[2] as Number).toInt() != 0) String.format(RESOURCES!!.getString(R.string.log_adventurer_death_preserve_exp), wrap(RESOURCES!!.getString(iIntValue15), GREEN)) else String.format(RESOURCES!!.getString(R.string.log_adventurer_death), wrap(RESOURCES!!.getString(iIntValue15), GREEN), wrap((objArr[1] as Number).toInt(), ORANGE))
                }
                39 -> {
                    strWrap = String.format(RESOURCES!!.getString(R.string.log_reanimate_corpse), wrap(RESOURCES!!.getString((objArr[0] as Number).toInt()), GREEN), wrap(RESOURCES!!.getString((objArr[1] as Number).toInt()), GREEN))
                }
                40 -> {
                    strWrap = String.format(RESOURCES!!.getString(R.string.log_search_item_found), wrap((objArr[0] as Number).toInt(), ORANGE), wrap(RESOURCES!!.getString((objArr[1] as Number).toInt()), ORANGE))
                }
                41 -> {
                    strWrap = RESOURCES!!.getString(R.string.log_search_no_item)
                }
                43 -> {
                    strWrap = String.format(RESOURCES!!.getString(R.string.log_escape), wrap(RESOURCES!!.getString((objArr[0] as Number).toInt()), getRed()))
                }
                44 -> {
                    strWrap = wrap(String.format(RESOURCES!!.getString((objArr[0] as Number).toInt()), (objArr[1] as Number).toInt()), YELLOW)
                }
                45 -> {
                    val entity27 = objArr[0] as Entity
                    val entity28 = objArr[1] as Entity
                    var string38 = RESOURCES!!.getString(R.string.log_dodge_flying)
                    var strWrap25 = wrap(RESOURCES!!.getString(entity27.idName), (if (entity27 is Enemy) getRed() else GREEN))
                    var string39 = RESOURCES!!.getString(entity28.idName)
                    if (entity28 is Enemy) {
                    red5 = getRed()
                    }
                    strWrap = String.format(string38, strWrap25, wrap(string39, red5))
                }
                46 -> {
                    if (zIsSettingVerboseLogs) {
                    val entity29 = objArr[0] as Entity
                    val iIntValue16 = (objArr[1] as Number).toInt()
                    var string40 = RESOURCES!!.getString(R.string.log_damage_received_retaliation)
                    var string41 = RESOURCES!!.getString(entity29.idName)
                    if (entity29 is Enemy) {
                    red5 = getRed()
                    }
                    strWrap = String.format(string40, wrap(string41, red5), wrap(iIntValue16, getRed()))
                    }
                }
                47 -> {
                    strWrap = wrap(String.format(RESOURCES!!.getString(R.string.log_eternal_battlefield_event_1a), (objArr[0] as Number).toInt()), YELLOW)
                }
                48 -> {
                    strWrap = String.format(RESOURCES!!.getString(R.string.log_the_golden_city_finding_2a), wrap((objArr[0] as Number).toInt(), getRed()), wrap(RESOURCES!!.getString((objArr[1] as Number).toInt()), GREEN))
                }
                49 -> {
                    if (zIsSettingVerboseLogs) {
                    val entity30 = objArr[0] as Entity
                    strWrap = String.format(RESOURCES!!.getString(R.string.log_regeneration), wrap(RESOURCES!!.getString(entity30.idName), (if (entity30 is Enemy) getRed() else GREEN)), wrap((objArr[1] as Number).toInt(), GREEN))
                    }
                }
                50 -> {
                    if (zIsSettingVerboseLogs) {
                    entity2 = objArr[0] as Entity
                    statusEffect2 = objArr[1] as StatusEffect
                    val iIntValue17 = (objArr[2] as Number).toInt()
                    var string110 = RESOURCES!!.getString(R.string.status_effect_log_damage)
                    var string111 = RESOURCES!!.getString(entity2.idName)
                    if (entity2 is Enemy) {
                    red3 = getRed()
                    } else {
                    red3 = GREEN
                    }
                    var strWrap110 = wrap(string111, red3)
                    var string112 = RESOURCES!!.getString(statusEffect2.type!!.logDescription)
                    if (statusEffect2.type!!.negative) {
                    red4 = getRed()
                    } else {
                    red4 = GREEN
                    }
                    var strWrap111 = wrap(string112, red4)
                    var strWrap112 = wrap(iIntValue17, getRed())
                    val turnsLeft4 = statusEffect2.turnsLeft
                    if (statusEffect2.type!!.negative) {
                    red5 = getRed()
                    }
                    strWrap = String.format(string110, strWrap110, strWrap111, strWrap112, wrap(turnsLeft4, red5))
                    }
                }
                51 -> {
                    strWrap = String.format(RESOURCES!!.getString(R.string.log_frostbite_peaks_finding_1a), wrap((objArr[0] as Number).toInt(), null), wrap(RESOURCES!!.getString((objArr[1] as Number).toInt()), GREEN), wrap((objArr[2] as Number).toInt(), null))
                }
                52 -> {
                    strWrap = String.format(RESOURCES!!.getString(R.string.log_frostbite_peaks_finding_1b), wrap(RESOURCES!!.getString((objArr[0] as Number).toInt()), GREEN))
                }
                53 -> {
                    strWrap = String.format(RESOURCES!!.getString(R.string.log_frostbite_peaks_finding_1c), wrap(RESOURCES!!.getString((objArr[0] as Number).toInt()), GREEN))
                }
                100 -> {
                    strWrap = RESOURCES!!.getString((objArr[0] as Number).toInt())
                }
                101 -> {
                    strWrap = wrap(RESOURCES!!.getString((objArr[0] as Number).toInt()), getRed())
                }
                102 -> {
                    strWrap = wrap(RESOURCES!!.getString((objArr[0] as Number).toInt()), GREEN)
                }
                EVENT_SIGNIFICANT -> {
                    strWrap = wrap(RESOURCES!!.getString((objArr[0] as Number).toInt()), YELLOW)
                }
                104 -> {
                    strWrap = wrap(String.format(RESOURCES!!.getString(R.string.log_the_southern_grove_wurm_chase), (objArr[0] as Number).toInt(), (objArr[1] as Number).toInt()), YELLOW)
                }
                105 -> {
                    if (zIsSettingVerboseLogs) {
                    val iIntValue18 = (objArr[0] as Number).toInt()
                    val pet = objArr[1] as Pet
                    val entity31 = objArr[2] as Entity
                    val iIntValue19 = (objArr[3] as Number).toInt()
                    var z4 = java.lang.Boolean.parseBoolean(RESOURCES!!.getString(R.string.swap_amount_and_target_in_logs))
                    var strWrap26 = wrap(RESOURCES!!.getString(pet.idName), GREEN)
                    var strWrap27 = wrap(iIntValue19, getRed())
                    var strWrap28 = wrap(RESOURCES!!.getString(entity31.idName), getRed())
                    var string42 = RESOURCES!!.getString(iIntValue18)
                    var str8 = (if (z4) strWrap28 else strWrap27)
                    if (!z4) {
                    strWrap27 = strWrap28
                    }
                    strWrap = String.format(string42, strWrap26, str8, strWrap27)
                    }
                }
                LOG_PET_HEAL -> {
                    if (zIsSettingVerboseLogs) {
                    val pet2 = objArr[0] as Pet
                    val entity32 = objArr[1] as Entity
                    val iIntValue20 = (objArr[2] as Number).toInt()
                    var z5 = java.lang.Boolean.parseBoolean(RESOURCES!!.getString(R.string.swap_amount_and_target_in_logs))
                    var strWrap29 = wrap(RESOURCES!!.getString(pet2.idName), GREEN)
                    var strWrap30 = wrap(iIntValue20, GREEN)
                    var strWrap31 = wrap(RESOURCES!!.getString(entity32.idName), GREEN)
                    var string43 = RESOURCES!!.getString(R.string.log_healing)
                    var str9 = (if (z5) strWrap31 else strWrap30)
                    if (!z5) {
                    strWrap30 = strWrap31
                    }
                    strWrap = String.format(string43, strWrap29, str9, strWrap30)
                    }
                }
                PET_DECOY -> {
                    strWrap = String.format(RESOURCES!!.getString(R.string.log_pet_decoy), wrap(RESOURCES!!.getString((objArr[0] as Pet).idName), GREEN), wrap(RESOURCES!!.getString((objArr[1] as Entity).idName), getRed()))
                }
                108 -> {
                    strWrap = String.format(RESOURCES!!.getString(R.string.log_pet_execution), wrap(RESOURCES!!.getString((objArr[0] as Entity).idName), getRed()), wrap(RESOURCES!!.getString((objArr[1] as Pet).idName), GREEN))
                }
                109 -> {
                    strWrap = wrap(String.format(RESOURCES!!.getString(R.string.log_hidden_city_of_larox_event_magic_amplification), (objArr[0] as Number).toInt()), YELLOW)
                }
                STATUS_FEEBLE_TETHER -> {
                    if (zIsSettingVerboseLogs) {
                    strWrap = wrap(String.format(RESOURCES!!.getString(R.string.status_effect_log_feeble_tether), RESOURCES!!.getString((objArr[0] as Entity).idName)), getRed())
                    }
                }
                STATUS_PETRIFIED -> {
                    if (!zIsSettingVerboseLogs) {
                    entity = objArr[0] as Entity
                    statusEffect = objArr[1] as StatusEffect
                    var string44 = RESOURCES!!.getString(R.string.status_effect_log_simple)
                    var string45 = RESOURCES!!.getString(entity.idName)
                    if (entity is Enemy) {
                    red = getRed()
                    } else {
                    red = GREEN
                    }
                    var strWrap113 = wrap(string45, red)
                    var string113 = RESOURCES!!.getString(statusEffect.type!!.logDescription)
                    if (statusEffect.type!!.negative) {
                    red2 = getRed()
                    } else {
                    red2 = GREEN
                    }
                    var strWrap114 = wrap(string113, red2)
                    val turnsLeft5 = statusEffect.turnsLeft
                    if (statusEffect.type!!.negative) {
                    red5 = getRed()
                    }
                    strWrap = String.format(string44, strWrap113, strWrap114, wrap(turnsLeft5, red5))
                    }
                }
                LOST_EXPEDITION_FALL_DAMAGE -> {
                    strWrap = wrap(String.format(RESOURCES!!.getString(R.string.log_the_lost_expedition_fall_damage), RESOURCES!!.getString((objArr[0] as Entity).idName), (objArr[1] as Number).toInt()), getRed())
                }
                RITUAL_SUMMON_SMOLDERING_TITAN -> {
                    strWrap = wrap(String.format(RESOURCES!!.getString(R.string.log_lost_lands_event_increase), (objArr[0] as Number).toInt()), YELLOW)
                }
                SUMMON_SMOLDERING_TITAN -> {
                    strWrap = wrap(RESOURCES!!.getString(R.string.log_lost_lands_event_summon), YELLOW)
                }
                BOTCHED_OFFERING -> {
                    val entity33 = objArr[0] as Entity
                    strWrap = wrap(String.format(RESOURCES!!.getString(R.string.log_the_dire_descent_event_1), RESOURCES!!.getString(entity33.idName), RESOURCES!!.getString(entity33.activeSkill!!.nameRes)), getRed())
                }
                ARCANE_SUPPRESSION -> {
                    var zEquals3 = "ko".equals(RESOURCES!!.getString(R.string.language_code))
                    val entity34 = objArr[0] as Entity
                    val iIntValue21 = (objArr[1] as Number).toInt()
                    var string46 = RESOURCES!!.getString(R.string.doctrine_ability_arcane_suppression_name)
                    var string47 = RESOURCES!!.getString(R.string.log_arcane_suppression)
                    var string48 = RESOURCES!!.getString(entity34.idName)
                    if (entity34 is Enemy) {
                    red5 = getRed()
                    }
                    var strWrap32 = wrap(string48, red5)
                    var strWrap33 = (if (zEquals3) string46 else wrap(iIntValue21, getRed()))
                    if (zEquals3) {
                    string46 = wrap(iIntValue21, getRed())
                    }
                    strWrap = String.format(string47, strWrap32, strWrap33, string46)
                }
                HEALING_NOVA -> {
                    var string49 = RESOURCES!!.getString(R.string.language_code)
                    if (!"zh".equals(string49) && !"ko".equals(string49)) {
                    z = false
                    }
                    var strValueOf = (objArr[0] as Number).toInt().toString()
                    var string50 = RESOURCES!!.getString(R.string.doctrine_ability_healing_nova_name)
                    var string51 = RESOURCES!!.getString(R.string.log_healing_nova)
                    var strWrap34 = wrap((if (z) string50 else strValueOf), GREEN)
                    if (!z) {
                    strValueOf = string50
                    }
                    strWrap = String.format(string51, strWrap34, wrap(strValueOf, GREEN))
                }
                STATUS_TERRIFIED -> {
                    if (zIsSettingVerboseLogs) {
                    entity2 = objArr[0] as Entity
                    statusEffect2 = objArr[1] as StatusEffect
                    val iIntValue110 = (objArr[2] as Number).toInt()
                    var string114 = RESOURCES!!.getString(R.string.status_effect_log_damage)
                    var string115 = RESOURCES!!.getString(entity2.idName)
                    if (entity2 is Enemy) {
                    red3 = getRed()
                    } else {
                    red3 = GREEN
                    }
                    var strWrap115 = wrap(string115, red3)
                    var string116 = RESOURCES!!.getString(statusEffect2.type!!.logDescription)
                    if (statusEffect2.type!!.negative) {
                    red4 = getRed()
                    } else {
                    red4 = GREEN
                    }
                    var strWrap116 = wrap(string116, red4)
                    var strWrap117 = wrap(iIntValue110, getRed())
                    val turnsLeft6 = statusEffect2.turnsLeft
                    if (statusEffect2.type!!.negative) {
                    red5 = getRed()
                    }
                    strWrap = String.format(string114, strWrap115, strWrap116, strWrap117, wrap(turnsLeft6, red5))
                    }
                }
                AMULET_OF_RESURRECTION -> {
                    strWrap = wrap(String.format(RESOURCES!!.getString(R.string.log_amulet_of_resurrection), RESOURCES!!.getString((objArr[0] as Entity).idName)), GREEN)
                }
                BARD_SHIELD -> {
                    val entity35 = objArr[0] as Entity
                    val entity36 = objArr[1] as Entity
                    strWrap = String.format(RESOURCES!!.getString(R.string.log_shielding), wrap(RESOURCES!!.getString(entity35.idName), (if (entity35 is Adventurer) GREEN else getRed())), wrap(RESOURCES!!.getString(entity36.idName), (if (entity36 is Adventurer) GREEN else getRed())), wrap((objArr[2] as Number).toInt(), GREEN))
                }
            }
            if (strWrap != null) {
                try {
                    MainActivity.shownDialogDungeonDetail?.log(strWrap)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    @JvmStatic
    fun invalidate() {
        RESOURCES = null
    }

    private fun getRed(): String {
        return if (MainActivity.data.isSettingColorblindMode) RED_COLORBLIND else RED
    }

    private fun wrap(str: Any?, color: String? = null): String {
        val s = str?.toString() ?: ""
        return if (color == null) {
            String.format(NO_COLOR_FORMAT, s)
        } else {
            String.format(COLOR_FORMAT, color, s)
        }
    }
}
