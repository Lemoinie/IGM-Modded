package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.content.DialogInterface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.R

abstract class CustomDialog : AppCompatDialogFragment() {
    private var skipOnShowListener = false

    protected abstract fun attachListeners()
    protected abstract fun getBinding(): ViewBinding
    protected abstract fun getTitle(): String
    protected abstract fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding
    protected abstract fun initialize(arguments: Bundle?)
    protected abstract fun setBinding(viewBinding: ViewBinding)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)
        dialog?.window?.apply {
            setBackgroundDrawable(ColorDrawable(0))
            setBackgroundDrawableResource(R.drawable.dialog_border)
            setFlags(8, 8)
            decorView.systemUiVisibility = activity?.window?.decorView?.systemUiVisibility ?: 0
        }
        dialog?.setOnShowListener { _ ->
            try {
                dialog?.window?.clearFlags(8)
                if (!skipOnShowListener) {
                    val wm = activity?.getSystemService("window") as? WindowManager
                    wm?.updateViewLayout(dialog?.window?.decorView, dialog?.window?.attributes)
                }
            } catch (_: Exception) {
                dismiss()
            }
        }
        setBinding(inflate(inflater, container, false))
        return try {
            initialize(arguments)
            attachListeners()
            dialog?.setTitle(getTitle())
            setLayout()
            getBinding().root
        } catch (e: Exception) {
            e.printStackTrace()
            dismiss()
            getBinding().root
        }
    }

    protected open fun setLayout() {
        dialog?.window?.setLayout(-1, -2)
    }

    fun skipOnShowListener() {
        skipOnShowListener = true
    }
}
