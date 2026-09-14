package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.databinding.DialogRefreshQuestsBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances.EmptyDoctrine
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager
import kotlin.math.min

class DialogRefreshQuests : CustomDialog() {
    private var binding: DialogRefreshQuestsBinding? = null
    private var gems: Int = 100

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogRefreshQuestsBinding
    }

    override fun getTitle(): String = getString(R.string.dialog_quests_refresh_title)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogRefreshQuestsBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        var count = 0
        for (adv in MainActivity.data.adventurers) {
            if (adv.doctrine !is EmptyDoctrine) {
                count++
            }
        }
        gems = if (MainActivity.data.afflictionLevel < 10 ||
            MainActivity.data.controlLevel < 10 ||
            MainActivity.data.fortitudeLevel < 10 ||
            MainActivity.data.graceLevel < 10 ||
            MainActivity.data.illusionLevel < 10 ||
            MainActivity.data.knowledgeLevel < 10 ||
            MainActivity.data.ruinLevel < 10 ||
            MainActivity.data.warLevel < 10
        ) {
            min(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, (count * 10) + 100)
        } else {
            100
        }
        binding?.confirmAmount?.text = gems.toString()
    }

    override fun attachListeners() {
        binding?.confirmContainer?.setOnClickListener {
            if (MainActivity.data.gems < gems) {
                return@setOnClickListener
            }
            QuestsManager.extractQuests()
            MainActivity.data.gems -= gems.toLong()
            MainActivity.data.isQuestsRefreshed = true
            MainActivity.shownDialogQuests?.reInitialize()
            (activity as? MainActivity)?.refresh()
            dismiss()
        }
        binding?.close?.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogRefreshQuests = this
    }

    override fun onStop() {
        MainActivity.shownDialogRefreshQuests = null
        super.onStop()
    }

    override fun setLayout() {
        dialog?.window?.setLayout((resources.displayMetrics.widthPixels * 0.9).toInt(), -2)
    }
}
