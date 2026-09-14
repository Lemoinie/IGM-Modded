package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.Faq
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogFaqBinding

class DialogFaq : CustomDialog() {
    private var adapter: BaseAdapter? = null
    private var binding: DialogFaqBinding? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogFaqBinding
    }

    override fun getTitle(): String = getString(R.string.drawer_faq_title)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogFaqBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        adapter = UIUtils.getFaqAdapter(listOf(*Faq.values()))
        binding?.faqList?.adapter = adapter
    }

    override fun attachListeners() {
        binding?.close?.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogFaq = this
    }

    override fun onStop() {
        MainActivity.shownDialogFaq = null
        super.onStop()
    }
}
