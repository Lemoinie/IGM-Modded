package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogMessagesReceivedBinding

class DialogMessagesReceived : CustomDialog() {
    private var adapter: BaseAdapter? = null
    private var binding: DialogMessagesReceivedBinding? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogMessagesReceivedBinding
    }

    override fun getTitle(): String = getString(R.string.drawer_messages_received_title)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogMessagesReceivedBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        adapter = UIUtils.getKingMessagesAdapter(MainActivity.data.messagesGotten)
        binding?.messagesList?.adapter = adapter
    }

    override fun attachListeners() {
        binding?.close?.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownMessagesReceived = this
    }

    override fun onStop() {
        MainActivity.shownMessagesReceived = null
        super.onStop()
    }
}
