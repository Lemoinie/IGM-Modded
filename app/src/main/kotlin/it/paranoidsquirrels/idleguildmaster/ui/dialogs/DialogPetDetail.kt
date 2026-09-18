package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.app.AlertDialog
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogPetDetailBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.PetAbility
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import java.util.ArrayList

class DialogPetDetail : CustomDialog() {
    companion object {
        private const val ORANGE_BOLD = "<font color=#C86400><strong>%s</strong></font>"

        private fun wrap(str: String): String = String.format(ORANGE_BOLD, str)
        private fun wrap(i: Int): String = wrap(i.toString())
    }

    @JvmField
    var binding: DialogPetDetailBinding? = null
    @JvmField
    var pet: Pet? = null
    private var setFreeDialog: AlertDialog? = null
    private var isSmallScreen = false
    private var descriptionLinesDisplayed = Integer.MAX_VALUE

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogPetDetailBinding
    }

    override fun getTitle(): String {
        val p = pet ?: return ""
        return getString(p.idName)
    }

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogPetDetailBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    override fun initialize(arguments: Bundle?) {
        val p = pet ?: return
        val b = binding ?: return
        val theme = context?.theme

        isSmallScreen = resources.displayMetrics.heightPixels < 1400
        b.description.maxLines = if (isSmallScreen) 1 else Integer.MAX_VALUE
        b.detailImage.setImageDrawable(ResourcesCompat.getDrawable(resources, p.idImage, theme))
        b.detailLevel.text = String.format(getString(R.string.pet_level_formatted), p.level)
        b.petType.text = getString(p.printPetType())
        val nextLvlFood = p.totalFoodToNextLevel()
        b.detailExperience.text = String.format(getString(R.string.pet_food_formatted), p.food, nextLvlFood)
        b.detailExperienceBar.progress = if (nextLvlFood > 0) ((p.food * 100.0) / nextLvlFood).toInt() else 0
        b.description.text = getString(p.idDescription)

        val isSenko = (p.trueClass.equals("Senko", ignoreCase = true) || p.trueClass.equals("Semi", ignoreCase = true) || p is it.paranoidsquirrels.idleguildmaster.storage.data.pets.instances.Senko)
        if (isSenko) {
            // Unlock all traits at level 1 with full power
            b.ability1Name.text = String.format(getString(R.string.pet_ability_name_unlocked), getString(p.petAbility1.nameRes), p.level)
            b.ability2Name.text = String.format(getString(R.string.pet_ability_name_unlocked), getString(p.petAbility2.nameRes), p.level)
            b.ability3Name.text = String.format(getString(R.string.pet_ability_name_unlocked), getString(p.petAbility3.nameRes), p.level)
            b.ability4Name.text = String.format(getString(R.string.pet_ability_name_unlocked), getString(p.petAbility4.nameRes), p.level)

            b.lockAbility2.visibility = View.GONE
            b.lockAbility3.visibility = View.GONE
            b.lockAbility4.visibility = View.GONE

            b.containerAbility3.visibility = View.VISIBLE
            b.containerAbility4.visibility = View.VISIBLE

            // Kitsune Spirit Blessing
            b.containerAbility5.visibility = View.VISIBLE
            b.ability5Name.text = "Kitsune Spirit Blessing"
            val blessingPct = Utils.round(p.getKitsuneBlessing() * 100.0)
            b.ability5Description.text = Html.fromHtml("<font color=#FFDB7F><b>+$blessingPct%</b></font> Healing", 0)
            b.detailTraits.visibility = View.GONE
        } else {
            b.ability1Name.text = String.format(getString(R.string.pet_ability_name_unlocked), getString(p.petAbility1.nameRes), p.level)
            b.ability2Name.text = if (p.level > 20) {
                String.format(getString(R.string.pet_ability_name_unlocked), getString(p.petAbility2.nameRes), p.level - 20)
            } else {
                String.format(getString(R.string.pet_ability_name_locked), getString(p.petAbility2.nameRes), 21)
            }
            b.ability3Name.text = if (p.level > 40) {
                String.format(getString(R.string.pet_ability_name_unlocked), getString(p.petAbility3.nameRes), p.level - 40)
            } else {
                String.format(getString(R.string.pet_ability_name_locked), getString(p.petAbility3.nameRes), 41)
            }
            b.ability4Name.text = if (p.level > 60) {
                String.format(getString(R.string.pet_ability_name_unlocked), getString(p.petAbility4.nameRes), p.level - 60)
            } else {
                String.format(getString(R.string.pet_ability_name_locked), getString(p.petAbility4.nameRes), 61)
            }

            b.lockAbility2.visibility = if (p.level > 20) View.GONE else View.VISIBLE
            b.lockAbility3.visibility = if (p.level > 40) View.GONE else View.VISIBLE
            b.lockAbility4.visibility = if (p.level > 60) View.GONE else View.VISIBLE

            b.containerAbility3.visibility = if (p.abilityNumber > 2) View.VISIBLE else View.GONE
            b.containerAbility4.visibility = if (p.abilityNumber <= 3) View.GONE else View.VISIBLE

            b.containerAbility5.visibility = View.GONE
            b.detailTraits.visibility = View.GONE
        }

        b.ability1Description.text = Html.fromHtml(formatPetAbilityDescription(p.petAbility1), 0)
        b.ability2Description.text = Html.fromHtml(formatPetAbilityDescription(p.petAbility2), 0)
        b.ability3Description.text = Html.fromHtml(formatPetAbilityDescription(p.petAbility3), 0)
        b.ability4Description.text = Html.fromHtml(formatPetAbilityDescription(p.petAbility4), 0)

        b.dismiss.setText(if ((p.level > 1 || p.food > 0) && MainActivity.data.pets.size > 1) R.string.pet_merge else R.string.pet_set_free)
    }

    override fun attachListeners() {
        val b = binding ?: return
        b.dismiss.setOnClickListener {
            val p = pet ?: return@setOnClickListener
            val isMerge = (p.level > 1 || p.food > 0) && MainActivity.data.pets.size > 1
            if (isMerge || setFreeDialog == null) {
                if (!isMerge || MainActivity.shownDialogConsumeFood == null) {
                    if (isMerge) {
                        val dialog = DialogMergePet()
                        dialog.selected = p
                        dialog.show(parentFragmentManager, "merge_pet")
                        return@setOnClickListener
                    }
                    val savedAreas = ArrayList<Area>()
                    var areaFound: Area? = null
                    for (area2 in Utils.compileDungeonRaidList()) {
                        if (areaFound == null && area2.petExploringId != null && area2.petExploringId == p.id) {
                            areaFound = area2
                        }
                        if (area2.savedPetId != null && area2.savedPetId == p.id) {
                            savedAreas.add(area2)
                        }
                    }
                    var body = String.format(getString(R.string.pet_set_free_body), getString(p.idName))
                    if (areaFound != null) {
                        body = body + "\n\n" + String.format(getString(R.string.dismiss_dialog_dungeon_pet), getString(areaFound.getName()))
                    }
                    val actionDialog = UIUtils.getActionDialog(context, R.string.pet_set_free, body, R.string.yes) { _, _ ->
                        MainActivity.data.pets.remove(p)
                        for (a in savedAreas) {
                            a.savedPetId = null
                        }
                        if (areaFound != null) {
                            areaFound.terminationRequested = true
                        }
                        MainActivity.shownDialogShelter?.refresh()
                        MainActivity.headquartersFragment?.refresh()
                        dismiss()
                    }
                    setFreeDialog = actionDialog
                    actionDialog.setOnDismissListener { setFreeDialog = null }
                    actionDialog.show()
                }
            }
        }
        if (isSmallScreen) {
            b.description.setOnClickListener {
                b.description.maxLines = if (b.description.maxLines <= 1) Integer.MAX_VALUE else 1
            }
        }
        b.exit2.setOnClickListener {
            dismiss()
        }
    }

    fun formatPetAbilityDescription(petAbility: PetAbility): String {
        val p = pet ?: return ""
        val string = getString(petAbility.description)
        return when (petAbility) {
            PetAbility.FIGHTER -> String.format(string, wrap(Utils.round(p.fighter * 0.9)), wrap(Utils.round(p.fighter * 1.1)))
            PetAbility.HEALER -> String.format(string, wrap(Utils.round(p.healer * 0.9)), wrap(Utils.round(p.healer * 1.1)))
            PetAbility.DECOY -> String.format(string, wrap(UIUtils.formatDouble2Decimals(p.decoy)))
            PetAbility.OPPORTUNIST -> String.format(string, wrap(UIUtils.formatDouble2Decimals(p.opportunist)))
            PetAbility.MAGIC -> String.format(string, wrap(UIUtils.formatDouble2Decimals(p.statusEffectChance)), wrap(p.statusEffectTurns))
            PetAbility.SAVAGE -> String.format(string, wrap(UIUtils.formatDouble2Decimals(p.savage)))
            PetAbility.BRIGHT -> String.format(string, wrap(p.bright))
            PetAbility.EXPERIENCE -> String.format(string, wrap(UIUtils.formatDouble2Decimals(p.experience)))
            PetAbility.DROPS -> String.format(string, wrap(UIUtils.formatDouble2Decimals(p.drops)))
            PetAbility.COUNTERATTACK -> String.format(string, wrap(UIUtils.formatDouble2Decimals(p.counterattack)))
            PetAbility.LIFESTEAL -> String.format(string, wrap(UIUtils.formatDouble2Decimals(p.lifesteal)))
            PetAbility.REGENERATION -> String.format(string, wrap(p.regeneration))
            PetAbility.BARRIER -> String.format(string, wrap(p.barrier))
            PetAbility.BLOODCRAVE -> String.format(string, wrap(UIUtils.formatDouble2Decimals(p.bloodcrave)))
            PetAbility.LACERATE -> String.format(string, wrap(UIUtils.formatDouble2Decimals(p.lacerate)))
            PetAbility.SERRATED -> String.format(string, wrap(UIUtils.formatDouble2Decimals(p.serrated)))
            else -> ""
        }
    }

    override fun onStart() {
        super.onStart()
        MainActivity.shownDialogPetDetail = this
    }

    override fun onStop() {
        MainActivity.shownDialogPetDetail = null
        super.onStop()
    }
}
