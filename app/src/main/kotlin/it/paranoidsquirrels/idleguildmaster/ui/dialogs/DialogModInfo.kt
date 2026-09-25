package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.databinding.DialogModInfoBinding

/**
 * CustomDialog implementation of the "Mod Info" screen.
 *
 * Inherits [CustomDialog] to render at the game's standard full screen width
 * with the [R.drawable.dialog_border] frame, immersive sticky UI flags, and
 * consistent window management.
 */
class DialogModInfo : CustomDialog() {

    private var binding: DialogModInfoBinding? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogModInfoBinding
    }

    override fun getTitle(): String = getString(R.string.drawer_mod_about_title)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogModInfoBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val b = binding ?: return
        val ctx = requireContext()

        b.modVersionText.text = ctx.getString(R.string.mod_info_version, "v" + DialogModAbout.modVersion())

        b.contributorsList.removeAllViews()
        val inflater = LayoutInflater.from(ctx)
        for (contributor in ModContributors.ALL) {
            val card = inflater.inflate(R.layout.item_mod_contributor, b.contributorsList, false)
            card.findViewById<TextView>(R.id.contributor_badge).also {
                it.text = contributor.role.title
                it.setTextColor(contributor.role.badgeColor)
            }
            card.findViewById<TextView>(R.id.contributor_name).text = contributor.name
            card.findViewById<TextView>(R.id.contributor_description).text = contributor.description
            val github = card.findViewById<TextView>(R.id.contributor_github)
            if (contributor.github != null) {
                github.text = ctx.getString(R.string.mod_info_github, contributor.github)
                github.visibility = View.VISIBLE
                github.setOnClickListener {
                    try {
                        val url = "https://github.com/${contributor.github}"
                        ctx.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                    } catch (ignored: Exception) {}
                }
            }

            val discord = card.findViewById<TextView>(R.id.contributor_discord)
            if (contributor.discord != null) {
                val isUrl = contributor.discord.startsWith("http://") || contributor.discord.startsWith("https://")
                val discordText = if (isUrl) {
                    contributor.discord
                } else {
                    "@" + contributor.discord.removePrefix("@")
                }
                discord.text = ctx.getString(R.string.mod_info_discord, discordText)
                discord.visibility = View.VISIBLE
                if (isUrl) {
                    discord.setOnClickListener {
                        try {
                            ctx.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(contributor.discord)))
                        } catch (ignored: Exception) {}
                    }
                }
            }

            b.contributorsList.addView(card)
        }
    }

    override fun attachListeners() {
        binding?.buttonClose?.setOnClickListener { dismiss() }
    }

    override fun setLayout() {
        dialog?.window?.decorView?.setPadding(0, 0, 0, 0)
        dialog?.window?.setLayout(-1, -2)
    }
}
