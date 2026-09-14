package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.content.res.ColorStateList
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.viewbinding.ViewBinding
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.UIUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.databinding.DialogEntityDetailBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutItemBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances.EmptyDoctrine
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Equipment
import java.util.HashSet

class DialogEntityDetail : CustomDialog() {
    companion object {
        @JvmStatic
        fun formatEquipmentHelp(equipment: Equipment?, resources: Resources?): String {
            if (equipment == null || resources == null) return ""
            return resources.getString(equipment.getIdName()) + "\n" + UIUtils.formatEquipmentDescription(equipment, resources)
        }
    }

    @JvmField
    var allowEquipmentChange: Boolean = false
    @JvmField
    var binding: DialogEntityDetailBinding? = null
    private var currentPage: Int = 0
    @JvmField
    var entity: Entity? = null
    @JvmField
    var promotion: Boolean = false

    fun getEntity(): Entity? = entity
    fun setEntity(e: Entity?) { entity = e }

    override fun getBinding(): ViewBinding = binding!!

    override fun setBinding(viewBinding: ViewBinding) {
        binding = viewBinding as DialogEntityDetailBinding
    }

    override fun getTitle(): String {
        val e = entity ?: return ""
        return getString(e.idName)
    }

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ViewBinding {
        val b = DialogEntityDetailBinding.inflate(inflater, container, attachToRoot)
        binding = b
        return b
    }

    public override fun initialize(bundle: Bundle?) {
        val b = binding ?: return
        val e = entity ?: run { dismiss(); return }

        currentPage = 0
        changePage(true)
        b.help.setText(e.idDescription)

        if (e is Adventurer) {
            b.lootTitle.visibility = View.GONE
            b.lootContent.visibility = View.GONE
            b.lootContentScroller.visibility = View.GONE
            if (e.isAscended()) {
                val colorAscended = resources.getColor(R.color.ascended_unit, context?.theme)
                b.detailExperienceBar.progressTintList = ColorStateList.valueOf(colorAscended)
                b.detailLevel.setTextColor(colorAscended)
                b.detailExperience.setTextColor(colorAscended)
                b.detailImage.setBackgroundResource(R.drawable.object_border_ascended)
                b.detailWeapon.setBackgroundResource(R.drawable.object_border_ascended)
                b.detailArmor.setBackgroundResource(R.drawable.object_border_ascended)
                b.detailAccessory.setBackgroundResource(R.drawable.object_border_ascended)
                b.swapEquipment.setBackgroundResource(R.drawable.object_border_ascended)
            }
        } else if (e is Enemy) {
            b.detailLevel.visibility = View.GONE
            b.levelupAdventurer.visibility = View.GONE
            b.detailExperience.visibility = View.GONE
            b.detailExperienceBar.visibility = View.GONE
            b.detailTraits.visibility = View.GONE
            b.detailContainerEquipments.visibility = View.GONE
            b.swapEquipment.visibility = View.GONE
            b.detailDarknessReduction.visibility = View.GONE
            b.detailExpBonus.visibility = View.GONE
            b.detailHealModifier.visibility = View.GONE
            b.detailDecay.visibility = View.GONE

            val addedClasses = HashSet<String>()
            for (itemWrapper in e.listDrops(0).keys) {
                val trueClass = itemWrapper.item?.getTrueClass() ?: ""
                if (!addedClasses.contains(trueClass)) {
                    addedClasses.add(trueClass)
                    val itemBinding = LayoutItemBinding.inflate(layoutInflater, b.lootContent, false)
                    itemBinding.stack.visibility = View.GONE
                    itemBinding.root.setBackgroundResource(R.drawable.object_border_dim_white)
                    val isSeen = MainActivity.data.seenItems.contains(trueClass)
                    val item = itemWrapper.item
                    itemBinding.image.setImageDrawable(
                        ResourcesCompat.getDrawable(
                            resources,
                            if (isSeen && item != null) item.getIdImage() else R.drawable.unknown,
                            context?.theme
                        )
                    )
                    if (isSeen && item != null) {
                        itemBinding.root.setOnClickListener {
                            UIUtils.openItemDetail(item)
                        }
                    }
                    b.lootContent.addView(itemBinding.root)
                }
            }
        }
        update()
    }

    public fun update() {
        val b = binding ?: return
        val e = entity ?: return

        if (!e.canPickDoctrine()) {
            b.doctrine.visibility = View.GONE
            b.expendableDoctrinePoints.visibility = View.GONE
        }
        b.eightDpFromDoctrine.visibility = if (e.canPickDoctrine()) View.VISIBLE else View.GONE
        b.detailImage.setImageDrawable(ResourcesCompat.getDrawable(resources, e.imageId, context?.theme))
        b.namePassive.text = getString(e.passiveSkill?.nameRes ?: 0)
        b.nameActive.text = getString(e.activeSkill?.nameRes ?: 0)
        b.detailAttackDamage.text = String.format(getString(R.string.attack_formatted), e.calculateMinAttackDamage(), e.calculateMaxAttackDamage())
        b.detailAttackType.text = String.format(getString(R.string.attack_type), getString(if (e.isRanged()) R.string.ranged else R.string.melee), getString(if (e.isMagic()) R.string.magic else R.string.physical))
        b.detailHp.text = String.format(getString(R.string.hp_formatted), e.calculateTotalMaxHp())
        b.detailMana.text = String.format(getString(R.string.mana_gain_formatted), e.calculateManaRegen())
        b.detailConstitution.text = String.format(getString(R.string.constitution_formatted), e.calculateTotalConstitution())
        b.detailDexterity.text = String.format(getString(R.string.dexterity_formatted), e.calculateTotalDexterity())
        b.detailIntelligence.text = String.format(getString(R.string.intelligence_formatted), e.calculateTotalIntelligence())
        b.detailDefense.text = String.format(getString(R.string.defense_formatted), e.calculateTotalDefense())
        b.detailMagicDefense.text = String.format(getString(R.string.magic_defense_formatted), e.calculateTotalMagicDefense())
        b.detailThreat.text = String.format(getString(R.string.threat_formatted), e.threat)
        b.detailDodge.text = String.format(getString(R.string.bonus_dodge_formatted), Utils.round(e.calculateTotalFlatDodgeChance() * 100.0))
        b.detailCritChance.text = String.format(getString(R.string.critical_chance_formatted), Utils.round(e.calculateCriticalChance() * 100.0))
        b.detailCritDamage.text = String.format(getString(R.string.critical_damage_formatted), Utils.round(e.calculateCriticalDamage() * 100.0))
        b.detailStatusImmunity.text = String.format(getString(R.string.status_immunity_formatted), Utils.round(Math.min(1.0, e.calculateImmunityToStatus()) * 100.0))
        b.detailCounterattack.text = String.format(getString(R.string.counterattack_formatted), Utils.round(Math.min(1.0, e.calculateCounterattackChance()) * 100.0))
        b.detailLifesteal.text = String.format(getString(R.string.lifesteal_formatted), e.calculateTotalLifesteal())
        b.detailDarknessDamage.text = String.format(getString(R.string.darkness_damage_formatted), UIUtils.formatDouble1Decimal(e.calculateTotalDarknessDamageAmplification() * 100.0))
        b.detailRetaliation.text = String.format(getString(R.string.retaliation_formatted), e.calculateRetaliationPhysicalDamage(), e.calculateRetaliationMagicalDamage())
        b.detailRegeneration.text = String.format(getString(R.string.regeneration_formatted), e.calculateTotalRegeneration())

        if (e is Adventurer) {
            b.detailTraits.text = UIUtils.traitsToShortString(e, resources)
            b.detailWeapon.setImageDrawable(Utils.getEquipmentDrawable(e.weapon, context))
            b.detailArmor.setImageDrawable(Utils.getEquipmentDrawable(e.armor, context))
            b.detailAccessory.setImageDrawable(Utils.getEquipmentDrawable(e.accessory, context))
            b.detailLevel.text = String.format(getString(R.string.level_formatted_long), e.level, e.maxLevel)
            b.detailExperienceBar.progress = ((e.experience.toDouble() * 100.0) / e.totalExperienceToNextLevel().toDouble()).toInt()
            b.detailExperience.text = if (e.level >= e.maxLevel) getString(R.string.experience_max) else String.format(getString(R.string.experience_formatted), e.experience, formatMaxExperience(e.totalExperienceToNextLevel()))
            b.doctrine.setImageDrawable(ResourcesCompat.getDrawable(resources, e.doctrine?.idImage ?: 0, context?.theme))
            b.expendableDoctrinePoints.visibility = if (e.getDoctrinePoints() > 0) View.VISIBLE else View.GONE
            b.detailDarknessReduction.text = String.format(getString(R.string.darkness_reduction_formatted), e.darknessReduction())
            b.detailExpBonus.text = String.format(getString(R.string.experience_bonus_formatted), Utils.round(e.experienceMultiplier() * 100.0))
            b.detailHealModifier.text = String.format(getString(R.string.healing_modifier_formatted), Utils.round(e.calculateHealingModifier() * 100.0))
            b.detailDecay.text = String.format(getString(R.string.decay_formatted), e.decay())

            formatPotion(b.detailPotionHealth, e, 3)
            formatPotion(b.detailPotionConstitution, e, 0)
            formatPotion(b.detailPotionDexterity, e, 1)
            formatPotion(b.detailPotionIntelligence, e, 2)
            formatPotion(b.detailPotionDefense, e, 4)
            formatPotion(b.detailPotionMagicDefense, e, 5)
            formatPotion(b.detailPotionPrecision, e, 6)
            formatPotion(b.detailPotionViciousness, e, 7)
            formatPotion(b.detailPotionAgility, e, 10)
            formatPotion(b.detailPotionImmunity, e, 9)
            formatPotion(b.detailPotionDarkness, e, 8)

            var canPromote = true
            if (e.level < e.maxLevel || (e.isAscended() && e.nextClasses.isEmpty())) {
                canPromote = false
            }

            if (canPromote && b.levelupAdventurer.animation == null) {
                val anim = AlphaAnimation(0.0f, 1.0f)
                anim.duration = 500L
                anim.repeatMode = AlphaAnimation.REVERSE
                anim.repeatCount = AlphaAnimation.INFINITE
                b.levelupAdventurer.startAnimation(anim)
            } else if (!canPromote && b.levelupAdventurer.animation != null) {
                b.levelupAdventurer.clearAnimation()
            }

            b.levelupAdventurer.visibility = if (canPromote) View.VISIBLE else View.INVISIBLE
            b.detailImage.alpha = if (canPromote) 0.5f else 1.0f
        }
    }

    public fun populateHelp(view: View?, text: String, isEquip: Boolean, slotType: String?) {
        val b = binding ?: return
        b.help.text = text
        val canSwap = isEquip && allowEquipmentChange
        b.swapEquipment.visibility = if (canSwap) View.VISIBLE else View.GONE
        if (canSwap) {
            b.swapEquipment.setOnClickListener {
                if (MainActivity.shownDialogSelectEquipment != null) return@setOnClickListener
                val dialog = DialogSelectEquipment()
                dialog.type = slotType
                dialog.adventurer = entity as? Adventurer
                dialog.show(parentFragmentManager, "select_equipment")
            }
        }
        if (view == null) return
        selectElement(b.root.findViewWithTag("selected"), false)
        selectElement(view, true)
    }

    private fun selectElement(view: View?, selected: Boolean) {
        if (!selected && view == null) return
        if (selected && view == binding?.root) return

        view?.tag = if (selected) "selected" else ""
        val isAscended = (entity as? Adventurer)?.isAscended() == true

        when (view) {
            is TextView -> {
                view.setTypeface(null, if (selected) 1 else 0)
            }
            is ConstraintLayout -> {
                view.setBackgroundResource(if (selected) R.drawable.object_border_dim_white_extra_opaque else R.drawable.object_border_dim_white)
            }
            is ImageView -> {
                val res = if (selected) {
                    if (isAscended) R.drawable.object_border_ascended_extra_opaque else R.drawable.object_border_dim_white_extra_opaque
                } else {
                    if (isAscended) R.drawable.object_border_ascended else R.drawable.object_border_dim_white
                }
                view.setBackgroundResource(res)
            }
            else -> {
                if (view == binding?.detailExperienceBar) {
                    binding?.detailExperience?.setTypeface(null, if (selected) 1 else 0)
                }
            }
        }
    }

    private fun formatMaxExperience(i: Int): String {
        return if (i >= 10000) (i / 1000).toString() + getString(R.string.abbreviation_thousands) else i.toString()
    }

    private fun dialogAdventurerPromotion(adventurer: Adventurer) {
        if (adventurer.maxLevel < 45) {
            promote(adventurer)
        } else {
            ascend(adventurer)
        }
    }

    private fun promote(adventurer: Adventurer) {
        if (MainActivity.shownDialogPromotionChoices != null) return
        val dialog = DialogPromotionChoices()
        dialog.adventurer = adventurer
        dialog.show(parentFragmentManager, "dialog_promotion")
    }

    private fun ascend(adventurer: Adventurer) {
        val baseAdv = Adventurer.getInstance(
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
            true
        )
        DialogPromotionChoices.showConfirmationDialog(this, adventurer, baseAdv)
    }

    private fun clickDoctrine(adventurer: Adventurer) {
        if (adventurer.doctrine == null || adventurer.doctrine is EmptyDoctrine) {
            if (MainActivity.shownDialogChooseDoctrine != null) return
            val dialog = DialogChooseDoctrine()
            dialog.adventurer = adventurer
            dialog.show(parentFragmentManager, "dialog_change_doctrine")
            return
        }
        UIUtils.openDoctrineDialog(adventurer, null)
    }

    private fun formatPotion(textView: TextView, adventurer: Adventurer, i: Int) {
        val drank = adventurer.potionsDrank?.get(i) ?: 0
        val maxPotions = adventurer.calculateMaxPotions(i)
        textView.text = String.format(getString(R.string.min_bar_max), drank, maxPotions)
        if (drank >= maxPotions) {
            textView.setTextColor(resources.getColor(R.color.brass_filler, context?.theme))
        }
    }

    private fun changePage(forward: Boolean) {
        val e = entity
        val maxPages = if (e is Adventurer) {
            if (e.isSummonedMinion()) 3 else 4
        } else {
            2
        }
        currentPage += if (forward) 1 else -1

        val canGoLeft: Boolean
        val canGoRight: Boolean
        if (currentPage <= 1) {
            currentPage = 1
            canGoLeft = false
            canGoRight = true
        } else if (currentPage >= maxPages) {
            currentPage = maxPages
            canGoLeft = true
            canGoRight = false
        } else {
            canGoLeft = true
            canGoRight = true
        }

        val b = binding ?: return
        b.arrowLeft.visibility = if (canGoLeft) View.VISIBLE else View.GONE
        b.arrowRight.visibility = if (canGoRight) View.VISIBLE else View.GONE
        b.page.text = String.format(getString(R.string.min_bar_max), currentPage, maxPages)
        b.containerStats.visibility = if (currentPage == 1) View.VISIBLE else View.INVISIBLE
        b.containerSecondaryStats.visibility = if (currentPage == 2) View.VISIBLE else View.INVISIBLE
        b.containerTertiaryStats.visibility = if (currentPage == 3) View.VISIBLE else View.INVISIBLE
        b.containerPotions.visibility = if (currentPage == 4) View.VISIBLE else View.INVISIBLE
    }

    override fun attachListeners() {
        val b = binding ?: return
        val e = entity ?: return

        b.root.setOnClickListener { populateHelp(it, "", false, null) }
        b.containerPassive.setOnClickListener {
            val desc = e.passiveSkill?.description ?: 0
            populateHelp(it, if (desc != 0) getString(desc) else "", false, null)
        }
        b.containerActive.setOnClickListener {
            val desc = e.activeSkill?.description ?: 0
            populateHelp(it, if (desc != 0) getString(desc) else "", false, null)
        }
        b.detailLevel.setOnClickListener { populateHelp(it, getString(R.string.help_level), false, null) }
        b.detailExperience.setOnClickListener { populateHelp(it, getString(R.string.help_experience), false, null) }
        b.detailExperienceBar.setOnClickListener { populateHelp(it, getString(R.string.help_experience), false, null) }
        b.detailAttackType.setOnClickListener {
            populateHelp(
                it,
                String.format(
                    getString(R.string.attack_type_description),
                    getString(if (e.isRanged()) R.string.ranged_description else R.string.melee_description),
                    getString(if (e.isMagic()) R.string.magic_description else R.string.physical_description)
                ),
                false,
                null
            )
        }
        b.detailHp.setOnClickListener { populateHelp(it, getString(R.string.help_hp), false, null) }
        b.detailConstitution.setOnClickListener { populateHelp(it, getString(R.string.help_constitution), false, null) }
        b.detailDexterity.setOnClickListener { populateHelp(it, getString(R.string.help_dexterity), false, null) }
        b.detailDefense.setOnClickListener { populateHelp(it, getString(R.string.help_defense), false, null) }
        b.detailMana.setOnClickListener { populateHelp(it, String.format(getString(R.string.help_mana), 100), false, null) }
        b.detailIntelligence.setOnClickListener { populateHelp(it, getString(R.string.help_intelligence), false, null) }
        b.detailMagicDefense.setOnClickListener { populateHelp(it, getString(R.string.help_magic_defense), false, null) }
        b.detailThreat.setOnClickListener { populateHelp(it, getString(R.string.help_threat), false, null) }
        b.detailDodge.setOnClickListener { populateHelp(it, getString(R.string.help_dodge), false, null) }
        b.detailCritChance.setOnClickListener { populateHelp(it, getString(R.string.help_crit_chance), false, null) }
        b.detailCritDamage.setOnClickListener { populateHelp(it, getString(R.string.help_crit_damage), false, null) }
        b.detailStatusImmunity.setOnClickListener { populateHelp(it, getString(R.string.help_status_immunity), false, null) }
        b.detailCounterattack.setOnClickListener { populateHelp(it, getString(R.string.help_counterattack), false, null) }
        b.detailLifesteal.setOnClickListener { populateHelp(it, getString(R.string.help_lifesteal), false, null) }
        b.detailDarknessDamage.setOnClickListener { populateHelp(it, getString(R.string.help_darkness_damage), false, null) }
        b.detailRetaliation.setOnClickListener { populateHelp(it, getString(R.string.help_retaliation), false, null) }
        b.detailRegeneration.setOnClickListener { populateHelp(it, getString(R.string.help_regeneration), false, null) }
        b.detailImage.setOnClickListener { populateHelp(it, getString(e.idDescription), false, null) }

        if (e is Adventurer) {
            b.detailAttackDamage.setOnClickListener {
                val dmgDesc = e.weapon?.damageDescription() ?: R.string.physical
                populateHelp(it, String.format(getString(R.string.help_attack), getString(dmgDesc)), false, null)
            }
            b.detailTraits.setOnClickListener { populateHelp(it, UIUtils.traitsToLongString(e, resources), false, null) }
            b.detailWeapon.setOnClickListener {
                val w = e.weapon
                populateHelp(it, if (w != null) formatEquipmentHelp(w, resources) else "", true, "weapon")
            }
            b.detailArmor.setOnClickListener {
                val a = e.armor
                populateHelp(it, if (a != null) formatEquipmentHelp(a, resources) else "", true, "armor")
            }
            b.detailAccessory.setOnClickListener {
                val acc = e.accessory
                populateHelp(it, if (acc != null) formatEquipmentHelp(acc, resources) else "", true, "accessory")
            }
            b.levelupAdventurer.setOnClickListener { dialogAdventurerPromotion(e) }
            b.detailDarknessReduction.setOnClickListener { populateHelp(it, getString(R.string.help_darkness_reduction), false, null) }
            b.detailExpBonus.setOnClickListener { populateHelp(it, getString(R.string.help_exp_bonus), false, null) }
            b.detailHealModifier.setOnClickListener { populateHelp(it, getString(R.string.help_heal_modifier), false, null) }
            b.detailDecay.setOnClickListener { populateHelp(it, getString(R.string.help_decay), false, null) }
            b.detailPotionHealth.setOnClickListener { populateHelp(it, getString(R.string.help_potion_health), false, null) }
            b.detailPotionConstitution.setOnClickListener { populateHelp(it, getString(R.string.help_potion_constitution), false, null) }
            b.detailPotionDexterity.setOnClickListener { populateHelp(it, getString(R.string.help_potion_dexterity), false, null) }
            b.detailPotionIntelligence.setOnClickListener { populateHelp(it, getString(R.string.help_potion_intelligence), false, null) }
            b.detailPotionDefense.setOnClickListener { populateHelp(it, getString(R.string.help_potion_defense), false, null) }
            b.detailPotionMagicDefense.setOnClickListener { populateHelp(it, getString(R.string.help_potion_magic_defense), false, null) }
            b.detailPotionPrecision.setOnClickListener { populateHelp(it, getString(R.string.help_potion_precision), false, null) }
            b.detailPotionViciousness.setOnClickListener { populateHelp(it, getString(R.string.help_potion_viciousness), false, null) }
            b.detailPotionAgility.setOnClickListener { populateHelp(it, getString(R.string.help_potion_agility), false, null) }
            b.detailPotionImmunity.setOnClickListener { populateHelp(it, getString(R.string.help_potion_immunity), false, null) }
            b.detailPotionDarkness.setOnClickListener { populateHelp(it, getString(R.string.help_potion_darkness), false, null) }
            b.doctrine.setOnClickListener { clickDoctrine(e) }
        } else if (e is Enemy) {
            b.detailAttackDamage.setOnClickListener {
                populateHelp(it, getString(R.string.help_attack_enemy), false, null)
            }
        }

        b.arrowLeft.setOnClickListener { changePage(false) }
        b.arrowRight.setOnClickListener { changePage(true) }
        b.help.setOnClickListener { /* no-op */ }
        b.exit2.setOnClickListener { dismiss() }
    }

    override fun onStart() {
        super.onStart()
        if (promotion) {
            MainActivity.shownDialogAdventurerDetailPromotion = this
        } else {
            MainActivity.shownDialogEntityDetail = this
        }
    }

    override fun onStop() {
        if (promotion) {
            MainActivity.shownDialogAdventurerDetailPromotion = null
        } else {
            MainActivity.shownDialogEntityDetail = null
        }
        super.onStop()
    }
}
