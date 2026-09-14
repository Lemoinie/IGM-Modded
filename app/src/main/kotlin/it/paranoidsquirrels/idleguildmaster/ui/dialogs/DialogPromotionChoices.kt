package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.AchievementsUtils
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogPromotionChoicesBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerPromotionBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area

class DialogPromotionChoices : CustomDialog() {
    companion object {
        @JvmField
        var confirmDialog: AlertDialog? = null

        @JvmStatic
        fun showConfirmationDialog(customDialog: CustomDialog, adventurer: Adventurer, adventurer2: Adventurer?) {
            if (adventurer2 == null) return
            if (confirmDialog != null) {
                return
            }
            var area: Area? = null
            for (a in Utils.compileDungeonRaidList()) {
                if (a.adventurersExploringIds.contains(adventurer.id)) {
                    area = a
                    break
                }
            }
            val index = MainActivity.data.adventurers.indexOf(adventurer)
            if (index == -1) {
                return
            }
            val context = customDialog.context ?: return
            val isAscension = adventurer2.isAscended() && !adventurer.isAscended()
            var message = String.format(
                context.getString(if (isAscension) R.string.adventurers_dialog_confirm_ascension_message else R.string.adventurers_dialog_confirm_promotion_message),
                context.getString(adventurer.idName),
                context.getString(adventurer2.idName)
            )
            if (area != null) {
                message = message + "\n\n" + String.format(context.getString(R.string.adventurers_dialog_confirm_promotion_message_extra), context.getString(area.getName()))
            }
            val actionDialog = UIUtils.getActionDialog(
                context,
                R.string.adventurers_dialog_confirm_promotion_title,
                message,
                if (isAscension) R.string.adventurers_dialog_confirm_ascension_ok else R.string.adventurers_dialog_confirm_promotion_ok
            ) { _, _ ->
                MainActivity.data.adventurers[index] = adventurer2
                MainActivity.adventurersFragment?.refresh()
                unlockTierAchievements(adventurer2.maxLevel / 5)
                if (!MainActivity.data.isEverAscended && isAscension) {
                    MainActivity.data.isEverAscended = true
                    AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_ASCENDED)
                }
                if (area != null) {
                    if (area.getAreaType() == 0) {
                        area.restartRequested = true
                    } else {
                        area.terminationRequested = true
                    }
                }
                MainActivity.shownDialogEntityDetail?.dismiss()
                if (customDialog is DialogPromotionChoices) {
                    customDialog.dismiss()
                }
                if (customDialog is DialogConsumePotionOfRejuvenation) {
                    customDialog.dismiss()
                    Utils.removeItemFromStorage(Item.getInstance("PotionOfRejuvenation", 1))
                    adventurer2.doctrine?.abilities?.forEach { doctrineAbility ->
                        doctrineAbility.level = 0
                    }
                    MainActivity.shownDialogItemDetail?.initialize(null)
                    MainActivity.shownDialogStorage?.update()
                }
                confirmDialog?.dismiss()
            }
            confirmDialog = actionDialog
            actionDialog.setOnDismissListener {
                confirmDialog = null
            }
            actionDialog.show()
        }

        @JvmStatic
        private fun unlockTierAchievements(tier: Int) {
            if (tier <= MainActivity.data.maxAdventurerTier) {
                return
            }
            for (i in 2..9) {
                if (i >= MainActivity.data.maxAdventurerTier) {
                    when (i) {
                        2 -> AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_NOVICE)
                        3 -> AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_SKILLED)
                        4 -> AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_EXPERT)
                        5 -> AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_VETERAN)
                        6 -> AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_LEGENDARY)
                        7 -> AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_MYTHIC)
                        8 -> AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_FABLED)
                        9 -> AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_DIVINE)
                    }
                }
            }
            MainActivity.data.maxAdventurerTier = tier
        }
    }

    var adventurer: Adventurer? = null
    @JvmField
    var binding: DialogPromotionChoicesBinding? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogPromotionChoicesBinding
    }

    override fun getTitle(): String = getString(R.string.adventurers_dialog_promote_title)

    override fun inflate(layoutInflater: LayoutInflater, viewGroup: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogPromotionChoicesBinding.inflate(layoutInflater, viewGroup, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val adv = adventurer ?: return
        val b = binding ?: return
        val theme = context?.theme
        for (nextClass in adv.nextClasses) {
            val nextAdv = Adventurer.getInstance(
                nextClass,
                adv.id,
                1,
                0,
                adv.weapon,
                adv.armor,
                adv.accessory,
                adv.traitCommon,
                adv.traitRare,
                adv.potionsDrank,
                adv.doctrine,
                adv.isAscended()
            ) ?: continue
            val promoBinding = LayoutAdventurerPromotionBinding.inflate(layoutInflater, b.promotionPossibilities, false)
            if (nextAdv.isAscended()) {
                promoBinding.containerAdventurer.setBackgroundResource(R.drawable.object_border_ascended)
                promoBinding.promotionImage.setBackgroundResource(R.drawable.object_border_rounded_left_ascended)
                promoBinding.promotionLevelup.setBackgroundResource(R.drawable.object_border_rounded_right_ascended)
                promoBinding.promotionName.setTextColor(resources.getColor(R.color.ascended_unit, theme))
            }
            promoBinding.promotionImage.setImageDrawable(ResourcesCompat.getDrawable(resources, nextAdv.imageId, theme))
            promoBinding.promotionName.text = getString(nextAdv.idName)
            promoBinding.promotionTraits.text = UIUtils.traitsToShortString(nextAdv, resources)
            val cardView = promoBinding.cardView
            if (nextAdv.doctrine?.trueClass == "EmptyDoctrine") {
                cardView.visibility = 8
            } else {
                cardView.visibility = 0
                nextAdv.doctrine?.let { doc ->
                    promoBinding.doctrine.setImageDrawable(ResourcesCompat.getDrawable(resources, doc.idImage, theme))
                }
            }
            promoBinding.promotionLevelup.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.check_brass, theme))
            promoBinding.promotionLevelup.setOnClickListener {
                showConfirmationDialog(this, adv, nextAdv)
            }
            promoBinding.promotionImage.setOnClickListener {
                UIUtils.getAdventurerDetailDialog(parentFragmentManager, nextAdv, false, true)
            }
            b.promotionPossibilities.addView(promoBinding.root)
        }
    }

    override fun attachListeners() {
        binding?.exit?.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogPromotionChoices = this
    }

    override fun onStop() {
        MainActivity.shownDialogPromotionChoices = null
        super.onStop()
    }
}
