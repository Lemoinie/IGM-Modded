package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.databinding.DialogIdleProgressBinding

class DialogIdleProgress : CustomDialog() {
    @JvmField
    var binding: DialogIdleProgressBinding? = null

    override fun attachListeners() {}

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogIdleProgressBinding
    }

    override fun getTitle(): String = getString(R.string.loading_screen_title)

    override fun setLayout() {
        dialog?.window?.setLayout((resources.displayMetrics.widthPixels * 0.9).toInt(), -2)
    }

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogIdleProgressBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        refreshProgress(0)
        binding?.progressBar?.visibility = 4
    }

    fun refreshProgress(i: Int) {
        try {
            binding?.progressBar?.visibility = 0
            binding?.progressBar?.progress = i
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
