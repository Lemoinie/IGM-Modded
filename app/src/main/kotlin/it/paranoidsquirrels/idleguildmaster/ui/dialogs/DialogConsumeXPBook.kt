package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.databinding.DialogConsumeEvo23Binding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerChangeTraitBinding
import it.paranoidsquirrels.idleguildmaster.mod.ModManager
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.*

class DialogConsumeXPBook : CustomDialog() {
    var selectedBook: Consumable? = null
    private var binding: DialogConsumeEvo23Binding? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogConsumeEvo23Binding
    }

    override fun getTitle(): String {
        return selectedBook?.let { "Use " + getString(it.idName) } ?: "Use XP Book"
    }

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogConsumeEvo23Binding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val b = binding ?: return
        b.list.removeAllViews()
        for (adv in MainActivity.data.adventurers) {
            val itemBinding = LayoutAdventurerChangeTraitBinding.inflate(layoutInflater, b.list, false)
            if (adv.isAscended()) {
                itemBinding.containerAdventurer.setBackgroundResource(R.drawable.object_border_ascended)
                itemBinding.image.setBackgroundResource(R.drawable.object_border_rounded_left_ascended)
                context?.let { ctx ->
                    itemBinding.name.setTextColor(resources.getColor(R.color.ascended_unit, ctx.theme))
                }
            }
            context?.let { ctx ->
                itemBinding.image.setImageDrawable(ResourcesCompat.getDrawable(resources, adv.imageId, ctx.theme))
                adv.doctrine?.let { doc ->
                    itemBinding.doctrine.setImageDrawable(ResourcesCompat.getDrawable(resources, doc.idImage, ctx.theme))
                }
            }
            itemBinding.level.text = adv.level.toString()
            itemBinding.cardView.visibility = if (adv.doctrine?.trueClass == "EmptyDoctrine") View.GONE else View.VISIBLE
            itemBinding.name.text = getString(adv.idName)
            itemBinding.traits.text = "Lvl ${adv.level} - ${adv.experience} / ${adv.totalExperienceToNextLevel()} XP"
            itemBinding.root.setOnClickListener {
                onAdventurerSelected(adv)
            }
            b.list.addView(itemBinding.root)
        }
    }

    private fun onAdventurerSelected(adv: Adventurer) {
        val book = selectedBook ?: return
        val xpToGive = when (book) {
            is XPBook1 -> book.getXpToGive()
            is XPBook2 -> book.getXpToGive()
            is XPBook3 -> book.getXpToGive()
            is XPBook10 -> book.getXpToGive()
            else -> 0
        }
        if (xpToGive > 0) {
            adv.addExperience(xpToGive)
            if (MainActivity.data.items.contains(book)) {
                book.stack -= 1
                if (book.stack <= 0) {
                    MainActivity.data.items.remove(book)
                }
            }
            context?.let { ctx ->
                ModManager.saveGameSynchronous(ctx)
                Toast.makeText(ctx, "Gained $xpToGive XP!", Toast.LENGTH_SHORT).show()
            }
            MainActivity.shownDialogItemDetail?.initialize(null)
            MainActivity.shownDialogStorage?.update()
            MainActivity.shownDialogEntityDetail?.update()
            MainActivity.headquartersFragment?.refresh()
            MainActivity.adventurersFragment?.refresh()

            if (book.stack > 0) {
                initialize(null)
            } else {
                dismiss()
            }
        }
    }

    override fun attachListeners() {
        binding?.close?.setOnClickListener {
            dismiss()
        }
    }
}
