package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.AchievementsUtils
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.TrueTimeUtils
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.mod.ModManager
import it.paranoidsquirrels.idleguildmaster.databinding.DialogRedeemCodeBinding
import it.paranoidsquirrels.idleguildmaster.storage.FileManager
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager

class DialogRedeemCode : CustomDialog() {
    @JvmField
    var binding: DialogRedeemCodeBinding? = null

    override fun initialize(arguments: Bundle?) {}

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogRedeemCodeBinding
    }

    override fun getTitle(): String = getString(R.string.drawer_redeem_code_title)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogRedeemCodeBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.close.setOnClickListener {
            dismiss()
        }
        b.ok.setOnClickListener {
            redeem(b.editText.text.toString())
        }
    }

    private fun redeem(rawInput: String) {
        val input = if (rawInput.length < 8) "voidcode" else rawInput
        val prefix = input.substring(0, 8)
        val extra = if (input.length > 8) input.substring(8) else ""

        when (prefix) {
            "g75nfkf4" -> {
                if (MainActivity.data.isRedeem_g73mfkf4) {
                    displayMessage(getString(R.string.drawer_redeem_already_redeemed), false)
                } else {
                    redeemGems(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION)
                    MainActivity.data.isRedeem_g73mfkf4 = true
                }
            }
            "f3hqt045" -> {
                if (MainActivity.data.isRedeemed_f8hf3045) {
                    displayMessage(getString(R.string.drawer_redeem_already_redeemed), false)
                } else {
                    try {
                        val item = Item.getInstance(extra, 1) ?: throw Exception()
                        Utils.collectItem(item, MainActivity.data.items)
                        MainActivity.headquartersFragment?.refresh()
                        MainActivity.data.isRedeemed_f8hf3045 = true
                        clearInput()
                    } catch (unused: Exception) {
                        blinkInput()
                    }
                }
            }
            "fj9rf8hh" -> {
                if (MainActivity.data.isRedeemed_fj9rf8hh) {
                    displayMessage(getString(R.string.drawer_redeem_already_redeemed), false)
                } else {
                    redeemGems(100)
                    MainActivity.data.isRedeemed_fj9rf8hh = true
                }
            }
            "g394te91" -> {
                if (MainActivity.data.isRedeemed_g294ps91) {
                    displayMessage(getString(R.string.drawer_redeem_already_redeemed), false)
                } else {
                    try {
                        val amount = extra.substring(0, 1).toInt()
                        val itemName = extra.substring(1)
                        val item = Item.getInstance(itemName, amount) ?: throw Exception()
                        Utils.collectItem(item, MainActivity.data.items)
                        MainActivity.headquartersFragment?.refresh()
                        MainActivity.data.isRedeemed_g294ps91 = true
                        clearInput()
                    } catch (unused: Exception) {
                        blinkInput()
                    }
                }
            }
            "rotdrv9d" -> {
                if (MainActivity.data.isRedeem_potionsRefund1) {
                    displayMessage(getString(R.string.drawer_redeem_already_redeemed), false)
                } else {
                    if (extra.isEmpty()) {
                        if (MainActivity.data.kingsQuests.isEmpty() && TrueTimeUtils.millis() <= 1750435056102L) {
                            QuestsManager.extractQuests()
                            (activity as? MainActivity)?.refreshIcons()
                        }
                    } else if (extra == "eq") {
                        Utils.collectItem(Item.getInstance("PatricianArmor", 2), MainActivity.data.items)
                        Utils.collectItem(Item.getInstance("DiamondAmulet", 19), MainActivity.data.items)
                        Utils.collectItem(Item.getInstance("CottontailJacket", 10), MainActivity.data.items)
                        Utils.collectItem(Item.getInstance("GhostRabbitCloak", 6), MainActivity.data.items)
                        Utils.collectItem(Item.getInstance("CeremonialCake", 10), MainActivity.data.items)
                        Utils.collectItem(Item.getInstance("PotionOfConstitution", 100), MainActivity.data.items)
                        Utils.collectItem(Item.getInstance("PotionOfDexterity", 100), MainActivity.data.items)
                        Utils.collectItem(Item.getInstance("PotionOfIntelligence", 100), MainActivity.data.items)
                        Utils.collectItem(Item.getInstance("PotionOfHealth", 100), MainActivity.data.items)
                        Utils.collectItem(Item.getInstance("PotionOfDefense", 100), MainActivity.data.items)
                        Utils.collectItem(Item.getInstance("PotionOfMagicDefense", 100), MainActivity.data.items)
                        Utils.collectItem(Item.getInstance("PotionOfPrecision", 100), MainActivity.data.items)
                        Utils.collectItem(Item.getInstance("PotionOfViciousness", 100), MainActivity.data.items)
                        Utils.collectItem(Item.getInstance("PotionOfDarkness", 100), MainActivity.data.items)
                        Utils.collectItem(Item.getInstance("PotionOfImmunity", 100), MainActivity.data.items)
                        Utils.collectItem(Item.getInstance("PotionOfAgility", 100), MainActivity.data.items)
                        MainActivity.data.money += 10000000L
                    }
                    MainActivity.headquartersFragment?.refresh()
                    MainActivity.data.isRedeem_potionsRefund1 = true
                    clearInput()
                }
            }
            "e44ttr7z" -> {
                if (MainActivity.data.isRedeemed_e44opo7z) {
                    displayMessage(getString(R.string.drawer_redeem_already_redeemed), false)
                } else {
                    redeemGems(2000)
                    MainActivity.data.isRedeemed_e44opo7z = true
                }
            }
            "vrd75ywc" -> {
                if (MainActivity.data.isRedeemed_vrw74ync) {
                    displayMessage(getString(R.string.drawer_redeem_already_redeemed), false)
                } else {
                    redeemGems(1000)
                    MainActivity.data.isRedeemed_vrw74ync = true
                }
            }
            "brttr5g5" -> {
                MainActivity.data.seenEnemies.add("Gcss")
                MainActivity.data.seenEnemies.add("ReinforcedDoor")
                MainActivity.data.seenEnemies.add("LegateHadrian")
                clearInput()
            }
            "UNLOCKME" -> {
                AchievementsUtils.retroactivelyUnlockAchievements()
                clearInput()
            }
            "vrt4983y" -> {
                if (MainActivity.data.isRedeemed_vre8983y) {
                    displayMessage(getString(R.string.drawer_redeem_already_redeemed), false)
                } else {
                    redeemGems(500)
                    MainActivity.data.isRedeemed_vre8983y = true
                }
            }
            "f1r29u15" -> {
                if (MainActivity.data.isRedeem_f1r39h15) {
                    displayMessage(getString(R.string.drawer_redeem_already_redeemed), false)
                } else {
                    if (extra.isEmpty()) {
                        try {
                            val cm = MainActivity.data.celestialMothership
                            if (cm?.completed() != true) {
                                blinkInput()
                            } else {
                                MainActivity.data.seenEnemies.add("Gcss")
                                MainActivity.data.seenEnemies.add("ReinforcedDoor")
                                MainActivity.data.seenItems.remove("Evo23Vial")
                                cm.maxProgress = 16
                                MainActivity.raidsFragment?.refresh()
                            }
                        } catch (unused: Exception) {
                            blinkInput()
                            return
                        }
                    } else if (extra == "eq") {
                        val adv = Adventurer.getInstance("DivineChampion", 25, 45, 0, Item.getInstance("Spade") as? Weapon, null, null, Trait.BRUTE, Trait.FOCUSED, PotionsDrank(), null, false)
                        adv?.let { MainActivity.data.adventurers.add(it) }
                        Utils.collectItem(Item.getInstance("ChampionArmor", 1), MainActivity.data.items)
                        Utils.collectItem(Item.getInstance("SpikedPrimevalShield", 1), MainActivity.data.items)
                        Utils.collectItem(Item.getInstance("EternalHunger", 2), MainActivity.data.items)
                        Utils.collectItem(Item.getInstance("SeekingGlass", 1), MainActivity.data.items)
                        Utils.collectItem(Item.getInstance("ScarletVeil", 1), MainActivity.data.items)
                        Utils.collectItem(Item.getInstance("ReassemblingJacket", 1), MainActivity.data.items)
                        MainActivity.headquartersFragment?.refresh()
                        MainActivity.adventurersFragment?.refresh()
                        MainActivity.dungeonsFragment?.refresh()
                    }
                    MainActivity.data.isRedeem_f1r39h15 = true
                    clearInput()
                }
            }
            "DEBUG000" -> {
                val ctx = context ?: return
                val saveFile = FileManager.getSaveFile(ctx)
                val act = activity
                if (saveFile == null || act == null) {
                    Toast.makeText(act, "No file found", Toast.LENGTH_SHORT).show()
                    return
                }
                val uri = FileProvider.getUriForFile(ctx, act.packageName + ".fileprovider", saveFile)
                val intent = Intent("android.intent.action.SEND")
                intent.type = "text/plain"
                intent.putExtra("android.intent.extra.EMAIL", arrayOf("beyond.idle.incremental@gmail.com"))
                intent.putExtra("android.intent.extra.SUBJECT", "Data")
                intent.putExtra("android.intent.extra.TEXT", "Data")
                intent.putExtra("android.intent.extra.STREAM", uri)
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                if (intent.resolveActivity(act.packageManager) != null) {
                    startActivity(Intent.createChooser(intent, "Send Email"))
                } else {
                    Toast.makeText(act, "No email client installed.", Toast.LENGTH_SHORT).show()
                }
            }
            else -> blinkInput()
        }
    }

    private fun redeemGems(amount: Int) {
        MainActivity.data.gems += amount.toLong()
        (MainActivity.headquartersFragment?.activity as? MainActivity)?.refreshGems()
        displayMessage(String.format(getString(R.string.drawer_redeem_gems), amount.toString()), true)
        clearInput()
    }

    private fun displayMessage(msg: String, success: Boolean) {
        val b = binding ?: return
        b.message.text = msg
        val theme = context?.theme
        b.message.setTextColor(resources.getColor(if (success) R.color.success else UIUtils.getFailureColor(), theme))
    }

    private fun clearInput() {
        binding?.editText?.text?.clear()
    }

    private fun blinkInput() {
        val ctx = context ?: return
        val defaultColor = ctx.getColor(R.color.dim_white)
        val failureColor = UIUtils.getFailureColor()
        val animator = ValueAnimator.ofArgb(defaultColor, failureColor, defaultColor)
        animator.interpolator = LinearInterpolator()
        animator.addUpdateListener { va ->
            binding?.editText?.setTextColor(va.animatedValue as Int)
        }
        animator.duration = 400L
        animator.start()
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogRedeemCode = this
    }

    override fun onStop() {
        MainActivity.shownDialogRedeemCode = null
        super.onStop()
    }
}
