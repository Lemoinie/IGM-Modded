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
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.game.redeem.RedeemCodes
import it.paranoidsquirrels.idleguildmaster.databinding.DialogRedeemCodeBinding
import it.paranoidsquirrels.idleguildmaster.storage.FileManager

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
        val modMsg = RedeemCodes.process(rawInput, context)
        if (modMsg != null) {
            displayMessage(modMsg, true)
            clearInput()
            return
        }

        val input = if (rawInput.length < 8) "voidcode" else rawInput
        val prefix = input.substring(0, 8)

        when (prefix) {
            "g75nfkf4" -> {
                if (MainActivity.data.isRedeem_g73mfkf4) {
                    displayMessage(getString(R.string.drawer_redeem_already_redeemed), false)
                } else {
                    redeemGems(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION)
                    MainActivity.data.isRedeem_g73mfkf4 = true
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
            "vrt4983y" -> {
                if (MainActivity.data.isRedeemed_vre8983y) {
                    displayMessage(getString(R.string.drawer_redeem_already_redeemed), false)
                } else {
                    redeemGems(500)
                    MainActivity.data.isRedeemed_vre8983y = true
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
