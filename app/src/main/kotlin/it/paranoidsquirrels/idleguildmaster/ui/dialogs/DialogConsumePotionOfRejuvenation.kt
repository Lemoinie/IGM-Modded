package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogConsumePotionOfRejuvenationBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerChangeTraitBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer

class DialogConsumePotionOfRejuvenation : CustomDialog() {
    private var binding: DialogConsumePotionOfRejuvenationBinding? = null
    private var confirmDialog: AlertDialog? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogConsumePotionOfRejuvenationBinding
    }

    override fun getTitle(): String = getString(R.string.dialog_consume_evo23_title)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogConsumePotionOfRejuvenationBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val b = binding ?: return
        b.list.removeAllViews()
        for (adventurer in MainActivity.data.adventurers) {
            val itemBinding = LayoutAdventurerChangeTraitBinding.inflate(layoutInflater, b.list, false)
            if (adventurer.isAscended()) {
                itemBinding.containerAdventurer.setBackgroundResource(R.drawable.object_border_ascended)
                itemBinding.image.setBackgroundResource(R.drawable.object_border_rounded_left_ascended)
                context?.let { ctx ->
                    itemBinding.name.setTextColor(resources.getColor(R.color.ascended_unit, ctx.theme))
                }
            }
            context?.let { ctx ->
                itemBinding.image.setImageDrawable(ResourcesCompat.getDrawable(resources, adventurer.imageId, ctx.theme))
                adventurer.doctrine?.let { doc ->
                    itemBinding.doctrine.setImageDrawable(ResourcesCompat.getDrawable(resources, doc.idImage, ctx.theme))
                }
            }
            itemBinding.level.text = adventurer.level.toString()
            itemBinding.cardView.visibility = if (adventurer.doctrine?.trueClass == "EmptyDoctrine") 8 else 0
            itemBinding.name.text = getString(adventurer.idName)
            itemBinding.traits.text = UIUtils.traitsToShortString(adventurer, resources)
            itemBinding.root.setOnClickListener {
                DialogPromotionChoices.showConfirmationDialog(
                    this,
                    adventurer,
                    Adventurer.getInstance(
                        Utils.getBaseClass(adventurer),
                        adventurer.id,
                        1,
                        0,
                        adventurer.weapon,
                        adventurer.armor,
                        adventurer.accessory,
                        adventurer.traitCommon,
                        adventurer.traitRare,
                        adventurer.potionsDrank,
                        adventurer.doctrine,
                        adventurer.isAscended()
                    )
                )
            }
            b.list.addView(itemBinding.root)
        }
    }

    override fun attachListeners() {
        binding?.close?.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogConsumePotionOfRejuvenation = this
    }

    override fun onStop() {
        MainActivity.shownDialogConsumePotionOfRejuvenation = null
        super.onStop()
    }
}
