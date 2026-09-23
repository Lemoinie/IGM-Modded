package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.animation.ValueAnimator
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogSendTeamBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import java.util.ArrayList
import java.util.Arrays

class DialogSendTeam : CustomDialog() {
    @JvmField
    var area: Area? = null
    @JvmField
    var binding: DialogSendTeamBinding? = null
    @JvmField
    var selectedAdventurersId: MutableList<Int> = ArrayList()
    @JvmField
    var selectedPetId: Int? = null
    private var slotsList: List<LayoutAdventurerBinding>? = null
    private var teamMembersBusy: AlertDialog? = null

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogSendTeamBinding
    }

    override fun getTitle(): String = getString(R.string.team_composition)

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogSendTeamBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val a = area
        if (a == null) {
            dismiss()
            return
        }
        val b = binding ?: return
        val advNum = a.adventurersNumber()
        val displayMetrics = resources.displayMetrics
        b.scrollView.layoutParams.height = Math.min((displayMetrics.density * advNum * 68).toInt(), (displayMetrics.heightPixels * 0.6).toInt())
        selectedAdventurersId = ArrayList()
        a.adventurersExploringIds.clear()
        slotsList = Arrays.asList(
            b.adventurer1, b.adventurer2, b.adventurer3, b.adventurer4, b.adventurer5,
            b.adventurer6, b.adventurer7, b.adventurer8, b.adventurer9, b.adventurer10,
            b.adventurer11, b.adventurer12, b.adventurer13, b.adventurer14
        )
        slotsList?.let { slots ->
            for (i in 13 downTo advNum) {
                slots[i].root.visibility = 8
            }
        }
        b.autoRaid.visibility = if (a.getAreaType() == 1 && a.canRefillWithGems()) View.VISIBLE else View.GONE
        setupAdventurers()
    }

    override fun attachListeners() {
        val b = binding ?: return
        val a = area ?: return
        b.save.setOnClickListener { view ->
            a.savedAdventurersIds.clear()
            a.savedAdventurersIds.addAll(selectedAdventurersId)
            a.savedPetId = selectedPetId
            blink(view as TextView, true)
        }
        b.load.setOnClickListener { view ->
            if (a.savedAdventurersIds.isEmpty() && a.savedPetId == null) {
                blink(view as TextView, false)
                return@setOnClickListener
            }
            selectedAdventurersId.clear()
            val availableSaved = ArrayList(a.savedAdventurersIds)
            selectedPetId = a.savedPetId
            val busyMessages = ArrayList<String>()

            for (otherArea in Utils.compileDungeonRaidList()) {
                for (id in otherArea.adventurersExploringIds) {
                    if (a.savedAdventurersIds.contains(id)) {
                        availableSaved.remove(id)
                        for (adv in MainActivity.data.adventurers) {
                            if (adv.id == id) {
                                busyMessages.add(String.format(getString(R.string.load_team_busy_member), getString(adv.idName), getString(otherArea.getName())))
                                break
                            }
                        }
                    }
                }
                if (otherArea.petExploringId != null && otherArea.petExploringId == a.savedPetId) {
                    for (pet in MainActivity.data.pets) {
                        if (pet.id == selectedPetId) {
                            busyMessages.add(String.format(getString(R.string.load_team_busy_member), getString(pet.idName), getString(otherArea.getName())))
                            break
                        }
                    }
                    selectedPetId = null
                }
            }
            selectedAdventurersId.addAll(availableSaved)
            if ((availableSaved.size < a.savedAdventurersIds.size || (selectedPetId == null && a.savedPetId != null)) && teamMembersBusy == null) {
                val sb = StringBuilder()
                for (i in busyMessages.indices) {
                    sb.append(busyMessages[i])
                    if (i < busyMessages.size - 1) {
                        sb.append(System.lineSeparator())
                    }
                }
                val dialog = UIUtils.getInfoDialog(context, R.string.load_team_busy_members, sb.toString(), false)
                teamMembersBusy = dialog
                dialog.setOnDismissListener { teamMembersBusy = null }
                dialog.show()
            }
            setupAdventurers()
            blink(view as TextView, true)
        }
        b.close.setOnClickListener {
            dismiss()
        }
        b.clear.setOnClickListener {
            selectedAdventurersId.clear()
            selectedPetId = null
            setupAdventurers()
        }
        b.send.setOnClickListener {
            if (selectedAdventurersId.size > 0) {
                a.terminationRequested = false
                a.adventurersExploringIds = selectedAdventurersId
                a.petExploringId = selectedPetId
                a.triesAvailable = false
                a.refreshTries()
                if (MainActivity.data.isSettingAutoOpenDungeonDetail) {
                    UIUtils.clickArea(MainActivity.dungeonsFragment, a)
                }
            }
            dismiss()
        }
        b.autoRaid.setOnClickListener {
            if (selectedAdventurersId.size > 0) {
                a.savedAdventurersIds.clear()
                a.savedAdventurersIds.addAll(selectedAdventurersId)
                a.savedPetId = selectedPetId
                val dialog = DialogAutoRaidConfig()
                dialog.area = a
                dialog.show(parentFragmentManager, "dialog_auto_raid_config")
            }
        }
        b.petContainer.setOnClickListener {
            if (MainActivity.shownDialogChoosePet == null) {
                val dialog = DialogChoosePet()
                MainActivity.shownDialogChoosePet = dialog
                dialog.show(parentFragmentManager, "dialog_choose_pet")
            }
        }
    }

    private fun blink(textView: TextView, success: Boolean) {
        val ctx = context ?: return
        val failureColor = UIUtils.getFailureColor()
        val targetColor = ctx.getColor(if (success) R.color.success else failureColor)
        val defaultColor = ctx.getColor(R.color.dim_white)
        val animator = ValueAnimator.ofArgb(defaultColor, targetColor, defaultColor)
        animator.interpolator = LinearInterpolator()
        animator.addUpdateListener { va ->
            textView.setTextColor(va.animatedValue as Int)
        }
        animator.duration = 400L
        animator.start()
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogSendTeam = this
    }

    override fun onStop() {
        MainActivity.shownDialogSendTeam = null
        super.onStop()
    }

    fun setupAdventurers() {
        val a = area ?: return
        val slots = slotsList ?: return
        val advNum = a.adventurersNumber()
        val theme = context?.theme

        var i = 0
        while (true) {
            if (i < advNum) {
                val slotBinding = slots[i]
                val nextSlot = i + 1
                if (selectedAdventurersId.size >= nextSlot) {
                    var adventurer: Adventurer? = null
                    for (adv in MainActivity.data.adventurers) {
                        if (adv.id == selectedAdventurersId[i]) {
                            adventurer = adv
                            break
                        }
                    }
                    if (adventurer == null) {
                        try {
                            a.savedAdventurersIds.remove(selectedAdventurersId[i])
                        } catch (unused: Exception) {
                            a.savedAdventurersIds.clear()
                        }
                        dismiss()
                        return
                    }
                    slotBinding.image.visibility = 0
                    slotBinding.weapon.visibility = 0
                    slotBinding.armor.visibility = 0
                    slotBinding.accessory.visibility = 0
                    slotBinding.plusSign.visibility = 8

                    if (adventurer.isAscended()) {
                        UIUtils.applyAscendedPalette(slotBinding)
                    } else {
                        slotBinding.containerAdventurer.setBackgroundResource(R.drawable.object_border_dim_white)
                        slotBinding.weapon.setBackgroundResource(R.drawable.object_border_dim_white)
                        slotBinding.armor.setBackgroundResource(R.drawable.object_border_dim_white)
                        slotBinding.accessory.setBackgroundResource(R.drawable.object_border_dim_white)
                        slotBinding.image.setBackgroundResource(R.drawable.object_border_rounded_left)
                        slotBinding.name.setTextColor(resources.getColor(R.color.dim_white, theme))
                    }
                    slotBinding.image.setImageDrawable(ResourcesCompat.getDrawable(resources, adventurer.imageId, theme))
                    slotBinding.name.text = getString(adventurer.idName)
                    val emptyDoc = adventurer.doctrine?.trueClass == "EmptyDoctrine"
                    slotBinding.cardView.visibility = if (emptyDoc) 8 else 0
                    adventurer.doctrine?.let { doc ->
                        slotBinding.doctrine.setImageDrawable(ResourcesCompat.getDrawable(resources, doc.idImage, theme))
                    }
                    slotBinding.expendableDoctrinePoints.visibility = 8
                    slotBinding.traits.text = UIUtils.traitsToShortString(adventurer, resources)
                    slotBinding.weapon.setImageDrawable(Utils.getEquipmentDrawable(adventurer.weapon, context))
                    slotBinding.armor.setImageDrawable(Utils.getEquipmentDrawable(adventurer.armor, context))
                    slotBinding.accessory.setImageDrawable(Utils.getEquipmentDrawable(adventurer.accessory, context))
                } else {
                    slotBinding.image.visibility = 4
                    slotBinding.name.text = ""
                    slotBinding.traits.text = ""
                    slotBinding.cardView.visibility = 8
                    slotBinding.weapon.visibility = 4
                    slotBinding.armor.visibility = 4
                    slotBinding.accessory.visibility = 4
                    slotBinding.plusSign.visibility = 0
                }
                val slotIndex = i
                slotBinding.root.setOnClickListener {
                    if (MainActivity.shownDialogChooseAdventurer == null) {
                        val dialog = DialogChooseAdventurer()
                        MainActivity.shownDialogChooseAdventurer = dialog
                        val bundle = Bundle()
                        bundle.putInt("positionClicked", slotIndex)
                        dialog.arguments = bundle
                        dialog.show(parentFragmentManager, "dialog_choose_adventurer")
                    }
                }
                i = nextSlot
            } else {
                var pet: Pet? = null
                val petId = selectedPetId
                if (petId != null) {
                    for (p in MainActivity.data.pets) {
                        if (p.id == petId) {
                            pet = p
                            break
                        }
                    }
                }
                binding?.imagePetPlus?.visibility = if (pet != null) 4 else 0
                binding?.imagePet?.visibility = if (pet == null) 4 else 0
                if (pet != null) {
                    binding?.imagePet?.setImageDrawable(ResourcesCompat.getDrawable(resources, pet.idImage, theme))
                }
                return
            }
        }
    }
}
