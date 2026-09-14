package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogChooseDoctrineBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine

class DialogChooseDoctrine : CustomDialog() {
    private var adapter: BaseAdapter? = null
    var adventurer: Adventurer? = null
    private var binding: DialogChooseDoctrineBinding? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogChooseDoctrineBinding
    }

    override fun getTitle(): String = getString(R.string.dialog_choose_doctrine_title)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogChooseDoctrineBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        adapter = UIUtils.getDoctrinesAdapter(
            listOf(
                Doctrine.getInstance("DoctrineOfFortitude"),
                Doctrine.getInstance("DoctrineOfIllusion"),
                Doctrine.getInstance("DoctrineOfWar"),
                Doctrine.getInstance("DoctrineOfAffliction"),
                Doctrine.getInstance("DoctrineOfKnowledge"),
                Doctrine.getInstance("DoctrineOfRuin"),
                Doctrine.getInstance("DoctrineOfGrace"),
                Doctrine.getInstance("DoctrineOfControl")
            ),
            adventurer
        )
        binding?.doctrineList?.adapter = adapter
    }

    override fun attachListeners() {
        binding?.close?.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogChooseDoctrine = this
    }

    override fun onStop() {
        MainActivity.shownDialogChooseDoctrine = null
        super.onStop()
    }
}
