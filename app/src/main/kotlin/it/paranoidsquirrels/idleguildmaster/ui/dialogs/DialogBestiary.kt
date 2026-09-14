package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogBestiaryBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area

class DialogBestiary : CustomDialog() {
    private var adapter: BaseAdapter? = null
    @JvmField
    var binding: DialogBestiaryBinding? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogBestiaryBinding
    }

    override fun getTitle(): String = getString(R.string.drawer_bestiary_title)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogBestiaryBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val b = binding ?: return
        val dungeons = Utils.compileDungeonList().filter { it.isUnlocked }
        val raids = Utils.compileRaidList().filter { it.isUnlocked }
        constraintHeight(b.dungeonsBestiaryList, dungeons.size > 3)
        constraintHeight(b.raidsBestiaryList, raids.size > 3)
        b.dungeonsBestiaryList.adapter = UIUtils.getBestiaryListAdapter(dungeons)
        b.raidsBestiaryList.adapter = UIUtils.getBestiaryListAdapter(raids)
        b.radiobuttonDungeons.isChecked = true
        toggle()
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.radioGroup.setOnCheckedChangeListener { _, _ ->
            toggle()
        }
        b.close.setOnClickListener {
            dismiss()
        }
    }

    private fun toggle() {
        val b = binding ?: return
        val isDungeons = b.radioGroup.checkedRadioButtonId == R.id.radiobutton_dungeons
        b.dungeonsBestiaryList.visibility = if (isDungeons) 0 else 8
        b.raidsBestiaryList.visibility = if (isDungeons) 8 else 0
    }

    private fun constraintHeight(view: View, z: Boolean) {
        val layoutParams = view.layoutParams as ConstraintLayout.LayoutParams
        layoutParams.constrainedHeight = z
        view.setLayoutParams(layoutParams)
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogBestiary = this
    }

    override fun onStop() {
        MainActivity.shownDialogBestiary = null
        super.onStop()
    }
}
