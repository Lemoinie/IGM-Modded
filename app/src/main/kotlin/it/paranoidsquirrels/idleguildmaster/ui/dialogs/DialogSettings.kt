package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.BuildConfig
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.SaveResetter
import it.paranoidsquirrels.idleguildmaster.databinding.DialogSettingsBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger
import java.util.HashMap

class DialogSettings : CustomDialog() {
    companion object {
        private var languageMap: MutableMap<Int, String>? = null
    }

    private var autoOpenDungeonDetail: Boolean = false
    @JvmField
    var binding: DialogSettingsBinding? = null
    private var colorblindMode: Boolean = false
    private var confirmRetreat: Boolean = false
    private var confirmSwap: Boolean = false
    private var confirmUpgrade: Boolean = false
    private var craftMaxAmount: Boolean = false
    private var language: String = ""
    private var sellMaxAmount: Boolean = false
    private var verboseLogs: Boolean = false

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogSettingsBinding
    }

    override fun getTitle(): String = getString(R.string.drawer_settings_title)

    override fun setLayout() {
        dialog?.window?.setLayout((resources.displayMetrics.widthPixels * 0.9).toInt(), -2)
    }

    override fun inflate(layoutInflater: LayoutInflater, viewGroup: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogSettingsBinding.inflate(layoutInflater, viewGroup, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val b = binding ?: return
        b.version.text = String.format(getString(R.string.drawer_settings_version_number), BuildConfig.VERSION_NAME)
        if (languageMap == null) {
            val map = HashMap<Int, String>()
            languageMap = map
            map[0] = "en"
            map[1] = "zh"
            map[2] = "fr"
            map[3] = "de"
            map[4] = "it"
            map[5] = "ja"
            map[6] = "ko"
            map[7] = "pl"
            map[8] = "pt"
            map[9] = "ru"
            map[10] = "es"
            map[11] = "th"
        }
        language = getString(R.string.language_code)
        sellMaxAmount = MainActivity.data.isSettingSellMaxAmount
        craftMaxAmount = MainActivity.data.isSettingCraftMaxAmount
        confirmUpgrade = MainActivity.data.isSettingConfirmUpgrade
        confirmRetreat = MainActivity.data.isSettingConfirmRetreat
        confirmSwap = MainActivity.data.isSettingConfirmSwap
        autoOpenDungeonDetail = MainActivity.data.isSettingAutoOpenDungeonDetail
        verboseLogs = MainActivity.data.isSettingVerboseLogs
        colorblindMode = MainActivity.data.isSettingColorblindMode

        val ctx = requireContext()
        val adapter = ArrayAdapter.createFromResource(ctx, R.array.drawer_settings_languages, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        b.languageSpinner.adapter = adapter

        languageMap?.let { map ->
            for ((key, value) in map) {
                if (language == value) {
                    b.languageSpinner.setSelection(key)
                }
            }
        }
        refreshValues()
    }

    private fun refreshValues() {
        val b = binding ?: return
        b.valueSellAmount.setText(if (sellMaxAmount) R.string.max else R.string.one)
        b.valueCraftAmount.setText(if (craftMaxAmount) R.string.max else R.string.one)
        b.valueConfirmUpgrades.setText(if (confirmUpgrade) R.string.yes else R.string.no)
        b.valueConfirmRetreat.setText(if (confirmRetreat) R.string.yes else R.string.no)
        b.valueSwapEquipment.setText(if (confirmSwap) R.string.yes else R.string.no)
        b.valueAutoOpenDungeon.setText(if (autoOpenDungeonDetail) R.string.yes else R.string.no)
        b.valueVerboseLogs.setText(if (verboseLogs) R.string.yes else R.string.no)
        b.valueColorblindMode.setText(if (colorblindMode) R.string.yes else R.string.no)
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.reset.setOnClickListener {
            context?.let { ctx ->
                SaveResetter.showResetConfirmation(ctx, activity)
            }
        }
        b.languageSpinner.onItemSelectedListener = LanguageSpinnerListener()
        b.valueSellAmount.setOnClickListener {
            sellMaxAmount = !sellMaxAmount
            refreshValues()
        }
        b.valueCraftAmount.setOnClickListener {
            craftMaxAmount = !craftMaxAmount
            refreshValues()
        }
        b.valueConfirmUpgrades.setOnClickListener {
            confirmUpgrade = !confirmUpgrade
            refreshValues()
        }
        b.valueConfirmRetreat.setOnClickListener {
            confirmRetreat = !confirmRetreat
            refreshValues()
        }
        b.valueSwapEquipment.setOnClickListener {
            confirmSwap = !confirmSwap
            refreshValues()
        }
        b.valueAutoOpenDungeon.setOnClickListener {
            autoOpenDungeonDetail = !autoOpenDungeonDetail
            refreshValues()
        }
        b.valueVerboseLogs.setOnClickListener {
            verboseLogs = !verboseLogs
            refreshValues()
        }
        b.valueColorblindMode.setOnClickListener {
            colorblindMode = !colorblindMode
            refreshValues()
        }
        b.restorePurchases.setOnClickListener {
            try {
                MainActivity.IAPWrapper?.restorePurchases()
            } catch (e: Exception) {
                e.printStackTrace()
            }
            dismiss()
        }
        b.cancel.setOnClickListener {
            dismiss()
        }
        b.save.setOnClickListener {
            MainActivity.data.isSettingSellMaxAmount = sellMaxAmount
            MainActivity.data.isSettingCraftMaxAmount = craftMaxAmount
            MainActivity.data.isSettingConfirmUpgrade = confirmUpgrade
            MainActivity.data.isSettingConfirmRetreat = confirmRetreat
            MainActivity.data.isSettingConfirmSwap = confirmSwap
            MainActivity.data.isSettingAutoOpenDungeonDetail = autoOpenDungeonDetail
            MainActivity.data.isSettingVerboseLogs = verboseLogs
            MainActivity.data.isSettingColorblindMode = colorblindMode

            if (language != MainActivity.data.settingsLanguage) {
                MainActivity.data.settingsLanguage = language
                Logger.invalidate()
                for (area in Utils.compileDungeonRaidList()) {
                    area.invalidateAnimator()
                }
                activity?.let { act ->
                    act.startActivity(Intent(act, MainActivity::class.java))
                    act.finish()
                }
            }
            dismiss()
        }
    }

    inner class LanguageSpinnerListener : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {}
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            languageMap?.get(position)?.let {
                language = it
            }
        }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogSettings = this
    }

    override fun onStop() {
        MainActivity.shownDialogSettings = null
        super.onStop()
    }
}
