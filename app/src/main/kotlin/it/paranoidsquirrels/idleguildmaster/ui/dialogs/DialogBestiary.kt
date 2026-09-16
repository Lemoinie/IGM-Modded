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
        val raids = Utils.compileRaidList().filter { it.isUnlocked && it != MainActivity.data.guildRequest && it != MainActivity.data.guildSiege }
        val other = listOfNotNull(MainActivity.data.guildRequest, MainActivity.data.guildSiege).filter { it.isUnlocked }
        constraintHeight(b.dungeonsBestiaryList, dungeons.size > 3)
        constraintHeight(b.raidsBestiaryList, raids.size > 3)
        constraintHeight(b.otherBestiaryList, other.size > 3)
        b.dungeonsBestiaryList.adapter = UIUtils.getBestiaryListAdapter(dungeons)
        b.raidsBestiaryList.adapter = UIUtils.getBestiaryListAdapter(raids)
        b.otherBestiaryList.adapter = UIUtils.getBestiaryListAdapter(other)
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
        when (b.radioGroup.checkedRadioButtonId) {
            R.id.radiobutton_dungeons -> {
                b.dungeonsBestiaryList.visibility = View.VISIBLE
                b.raidsBestiaryList.visibility = View.GONE
                b.otherBestiaryList.visibility = View.GONE
            }
            R.id.radiobutton_raids -> {
                b.dungeonsBestiaryList.visibility = View.GONE
                b.raidsBestiaryList.visibility = View.VISIBLE
                b.otherBestiaryList.visibility = View.GONE
            }
            R.id.radiobutton_other -> {
                b.dungeonsBestiaryList.visibility = View.GONE
                b.raidsBestiaryList.visibility = View.GONE
                b.otherBestiaryList.visibility = View.VISIBLE
            }
        }
    }

    private fun constraintHeight(view: View, z: Boolean) {
        val layoutParams = view.layoutParams as ConstraintLayout.LayoutParams
        layoutParams.constrainedHeight = z
        view.setLayoutParams(layoutParams)
    }
}
