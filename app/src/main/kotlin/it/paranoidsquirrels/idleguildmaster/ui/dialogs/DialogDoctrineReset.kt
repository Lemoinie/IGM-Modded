package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogDoctrineResetBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine

class DialogDoctrineReset : CustomDialog() {
    var adventurer: Adventurer? = null
    private var binding: DialogDoctrineResetBinding? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogDoctrineResetBinding
    }

    override fun getTitle(): String = getString(R.string.reset)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogDoctrineResetBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val adv = adventurer ?: return
        val b = binding ?: return
        b.body.text = String.format(getString(R.string.dialog_doctrine_confirm_reset), getString(adv.idName))
        context?.let { ctx ->
            b.errorNoGems.setTextColor(resources.getColor(UIUtils.getFailureColor(), ctx.theme))
        }
        b.errorNoGems.visibility = 8
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.containerGems.setOnClickListener {
            val adv = adventurer ?: return@setOnClickListener
            if (MainActivity.data.gems >= 50) {
                MainActivity.data.gems -= 50
                (activity as? MainActivity)?.refreshGems()
                adv.doctrine = Doctrine.getInstance("EmptyDoctrine")
                DialogDoctrine.removeWeaponMaster(resources, adv)
                MainActivity.shownDialogDoctrine?.dismiss()
                MainActivity.shownDialogEntityDetail?.update()
                MainActivity.adventurersFragment?.refresh()
                dismiss()
                return@setOnClickListener
            }
            b.errorNoGems.visibility = 0
        }
        b.close.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogDoctrineReset = this
    }

    override fun onStop() {
        MainActivity.shownDialogDoctrineReset = null
        super.onStop()
    }
}
