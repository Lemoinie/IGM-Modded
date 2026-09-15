package it.paranoidsquirrels.idleguildmaster

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.res.Resources
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.work.WorkRequest
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutAdventurerBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutBestiaryElementBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutCraftNamedBinding
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutMoneyBinding
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.Doctrine
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Recipes
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Equipment
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.storage.data.places.EnemyCounter
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.BarrenWastelands
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.BlackwaterPort
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.EternalBattlefield
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.FrostbitePeaks
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.HiddenCityOfLarox
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.LostLands
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.ObsidianMines
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.TheDesert
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.TheGoldenCity
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.TheSouthernGrove
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.SleepingPlanet
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheDireDescent
import it.paranoidsquirrels.idleguildmaster.storage.data.places.raids.TheDreadfulAscent
import it.paranoidsquirrels.idleguildmaster.ui.adventurers.AdventurersFragment
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDoctrine
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogDungeonDetail
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogItemDetail
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRefillRaidTry
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSendTeam
import it.paranoidsquirrels.idleguildmaster.ui.dungeons.DungeonsFragment
import it.paranoidsquirrels.idleguildmaster.ui.headquarters.HeadquartersFragment
import it.paranoidsquirrels.idleguildmaster.ui.raids.RaidsFragment
import java.text.DecimalFormat
import java.util.ArrayList

object UIUtils {
    private val df1 = DecimalFormat("0.0")
    private val df2 = DecimalFormat("0.00")

    @JvmStatic
    fun populateMoneyContainer(layoutMoneyBinding: LayoutMoneyBinding, j: Long, z: Boolean) {
        val j2 = j % 100
        val j3 = ((j % WorkRequest.MIN_BACKOFF_MILLIS) - j2) / 100
        val j4 = (((j % 1000000) - j3) - j2) / WorkRequest.MIN_BACKOFF_MILLIS
        val j5 = (((j - j4) - j3) - j2) / 1000000
        layoutMoneyBinding.amountCopper.text = j2.toString()
        layoutMoneyBinding.amountSilver.text = j3.toString()
        layoutMoneyBinding.amountGold.text = j4.toString()
        layoutMoneyBinding.amountPlatinum.text = j5.toString()
        val z2 = j3 == 0L && j4 == 0L && j5 == 0L
        val z3 = j4 == 0L && j5 == 0L
        val z4 = j5 == 0L
        val z5 = z && j >= WorkRequest.MIN_BACKOFF_MILLIS
        val z6 = z && j >= 1000000L
        layoutMoneyBinding.amountCopper.visibility = if (z5) View.GONE else View.VISIBLE
        layoutMoneyBinding.imageCopper.visibility = if (z5) View.GONE else View.VISIBLE
        layoutMoneyBinding.amountSilver.visibility = if (z2 || z6) View.GONE else View.VISIBLE
        layoutMoneyBinding.imageSilver.visibility = if (z2 || z6) View.GONE else View.VISIBLE
        layoutMoneyBinding.amountGold.visibility = if (z3) View.GONE else View.VISIBLE
        layoutMoneyBinding.imageGold.visibility = if (z3) View.GONE else View.VISIBLE
        layoutMoneyBinding.amountPlatinum.visibility = if (z4) View.GONE else View.VISIBLE
        layoutMoneyBinding.imagePlatinum.visibility = if (z4) View.GONE else View.VISIBLE
    }

    @JvmStatic
    fun changeMoneyContainerColor(layoutMoneyBinding: LayoutMoneyBinding, z: Boolean) {
        val color = layoutMoneyBinding.root.context.getColor(if (z) R.color.dim_white else getFailureColor())
        layoutMoneyBinding.amountCopper.setTextColor(color)
        layoutMoneyBinding.amountSilver.setTextColor(color)
        layoutMoneyBinding.amountGold.setTextColor(color)
        layoutMoneyBinding.amountPlatinum.setTextColor(color)
    }

    @JvmStatic
    fun getInfoDialog(context: Context?, num: Int?, str: String?, z: Boolean): AlertDialog {
        val context = context!!
        val builder = AlertDialog.Builder(context, R.style.AlertDialog)
        if (num != null) {
            builder.setTitle(num)
        }
        if (z) {
            builder.setMessage(Html.fromHtml(str, 0))
        } else {
            builder.setMessage(str)
        }
        builder.setPositiveButton(android.R.string.ok) { dialogInterface, _ ->
            dialogInterface.dismiss()
        }
        val alertDialogCreate = builder.create()
        alertDialogCreate.setOnShowListener {
            alertDialogCreate.getButton(-1)?.setTextColor(context.resources.getColor(R.color.brass_border, context.theme))
            hideUI(alertDialogCreate.window ?: return@setOnShowListener)
            alertDialogCreate.window?.clearFlags(8)
        }
        alertDialogCreate.window?.setBackgroundDrawable(ColorDrawable(0))
        alertDialogCreate.window?.setBackgroundDrawableResource(R.drawable.dialog_border)
        alertDialogCreate.window?.setFlags(8, 8)
        return alertDialogCreate
    }

    @JvmStatic
    fun getActionDialog(context: Context?, num: Int?, str: String?, i: Int, onClickListener: DialogInterface.OnClickListener?): AlertDialog {
        val context = context!!
        val builder = AlertDialog.Builder(context, R.style.AlertDialog)
        if (num != null) {
            builder.setTitle(num)
        }
        builder.setMessage(str)
        builder.setNegativeButton(R.string.no) { dialogInterface, _ ->
            dialogInterface.dismiss()
        }
        builder.setPositiveButton(i, onClickListener)
        val alertDialogCreate = builder.create()
        alertDialogCreate.setOnShowListener {
            alertDialogCreate.getButton(-2)?.setTextColor(context.resources.getColor(R.color.dim_white, context.theme))
            alertDialogCreate.getButton(-1)?.setTextColor(context.resources.getColor(R.color.brass_border, context.theme))
            hideUI(alertDialogCreate.window ?: return@setOnShowListener)
            alertDialogCreate.window?.clearFlags(8)
        }
        alertDialogCreate.window?.setBackgroundDrawable(ColorDrawable(0))
        alertDialogCreate.window?.setBackgroundDrawableResource(R.drawable.dialog_border)
        alertDialogCreate.window?.setFlags(8, 8)
        return alertDialogCreate
    }

    @JvmStatic
    fun askConfirmUpgrade(context: Context?, i: Int, onClickListener: DialogInterface.OnClickListener?): AlertDialog {
        val context = context!!
        return getActionDialog(context, R.string.confirm, String.format(context.getString(R.string.confirm_upgrade_body), context.getString(i)), R.string.yes, onClickListener)
    }

    @JvmStatic
    fun getAdventurerDetailDialog(fragmentManager: FragmentManager, entity: Entity?, z: Boolean, z2: Boolean) {
        if (z2 || MainActivity.shownDialogEntityDetail == null) {
            if ((!z2 || MainActivity.shownDialogAdventurerDetailPromotion == null) && entity != null) {
                val dialogEntityDetail = DialogEntityDetail()
                dialogEntityDetail.setEntity(entity)
                dialogEntityDetail.allowEquipmentChange = z
                dialogEntityDetail.promotion = z2
                dialogEntityDetail.show(fragmentManager, "dialog_entity_detail")
            }
        }
    }

    @JvmStatic
    fun getEnemyDetailDialog(fragmentManager: FragmentManager, entity: Entity?) {
        getAdventurerDetailDialog(fragmentManager, entity, false, false)
    }

    @JvmStatic
    fun getFightRarity(list: List<Enemy>): Int {
        var rarity = 1
        for (enemy in list) {
            if (enemy.getRarity() > rarity) {
                rarity = enemy.getRarity()
            }
        }
        return when (rarity) {
            1 -> R.string.rarity_common
            2 -> R.string.rarity_uncommon
            3 -> R.string.rarity_rare
            4 -> R.string.rarity_epic
            5 -> R.string.rarity_legendary
            else -> R.string.rarity_common
        }
    }

    @JvmStatic
    fun backgroundFromRarity(i: Int): Int = R.drawable.object_border_dim_white

    @JvmStatic
    fun traitsToShortString(adventurer: Adventurer, resources: Resources): String {
        val traitCommon = adventurer.traitCommon
        val traitRare = adventurer.traitRare
        if (traitCommon == null && traitRare == null) {
            return ""
        }
        if (traitCommon != null && traitRare != null) {
            return resources.getString(traitCommon.nameRes) + ", " + resources.getString(traitRare.nameRes)
        }
        return if (traitCommon != null) {
            resources.getString(traitCommon.nameRes)
        } else {
            resources.getString(traitRare!!.nameRes)
        }
    }

    @JvmStatic
    fun traitsToLongString(adventurer: Adventurer, resources: Resources): String {
        val traitCommon = adventurer.traitCommon
        val traitRare = adventurer.traitRare
        if (traitCommon == null && traitRare == null) {
            return ""
        }
        if (traitCommon != null && traitRare != null) {
            return String.format(resources.getString(R.string.traits_formatted_2), resources.getString(traitCommon.nameRes), resources.getString(traitCommon.description), resources.getString(traitRare.nameRes), resources.getString(traitRare.description))
        }
        return if (traitCommon != null) {
            String.format(resources.getString(R.string.traits_formatted_1), resources.getString(traitCommon.nameRes), resources.getString(traitCommon.description))
        } else {
            String.format(resources.getString(R.string.traits_formatted_1), resources.getString(traitRare!!.nameRes), resources.getString(traitRare!!.description))
        }
    }

    @JvmStatic
    fun hideUI(window: Window) {
        window.navigationBarColor = 0
        window.decorView.systemUiVisibility = 5638
    }

    @JvmStatic
    fun openItemDetail(item: Item?) {
        val item = item ?: return
        if (MainActivity.shownDialogItemDetail != null) {
            return
        }
        try {
            val parentFragmentManager = MainActivity.headquartersFragment?.parentFragmentManager ?: return
            val dialogItemDetail = DialogItemDetail()
            dialogItemDetail.setItems(ArrayList(listOf(item)))
            dialogItemDetail.show(parentFragmentManager, "item_detail")
        } catch (_: Exception) {
        }
    }

    @JvmStatic
    fun formatSeconds(j: Long): String {
        val i = (j / 3600).toInt()
        val i2 = ((j / 60) % 60).toInt()
        val i3 = (j % 60).toInt()
        val s3 = if (i3 > 9) i3.toString() else "0$i3"
        return if (i == 0) {
            String.format("%d:%s", i2, s3)
        } else {
            val s2 = if (i2 > 9) i2.toString() else "0$i2"
            String.format("%d:%s:%s", i, s2, s3)
        }
    }

    @JvmStatic
    fun formatDouble1Decimal(d: Double): String = df1.format(d)

    @JvmStatic
    fun formatDouble2Decimals(d: Double): String = df2.format(d)

    @JvmStatic
    fun formatEquipmentDescription(equipment: Equipment, resources: Resources): String {
        val str = formatStat(R.string.hp_difference, equipment.getMaxHp(), resources) +
                formatStat(R.string.constitution_difference, equipment.getConstitution(), resources) +
                formatStat(R.string.intelligence_difference, equipment.getIntelligence(), resources) +
                formatStat(R.string.dexterity_difference, equipment.getDexterity(), resources) +
                formatStat(R.string.defense_difference, equipment.getDefense(), resources) +
                formatStat(R.string.magic_defence_difference, equipment.getMagicDefense(), resources)
        return str + (if (str.isEmpty() || equipment.getIdEffect() == 0) "" else "\n") + (if (equipment.getIdEffect() != 0) resources.getString(equipment.getIdEffect()) else "")
    }

    @JvmStatic
    fun formatStat(i: Int, i2: Int, resources: Resources): String {
        if (i2 == 0) return ""
        return String.format(resources.getString(i), if (i2 > 0) "+" else "", i2) + " "
    }

    @JvmStatic
    fun darknessDescription(i: Int, resources: Resources?): String {
        val resources = resources ?: return ""
        return when {
            i == 0 -> String.format(resources.getString(R.string.log_darkness_0), i)
            i <= 25 -> String.format(resources.getString(R.string.log_darkness_1_25), i)
            i <= 50 -> String.format(resources.getString(R.string.log_darkness_26_50), i)
            i <= 75 -> String.format(resources.getString(R.string.log_darkness_51_75), i)
            else -> String.format(resources.getString(R.string.log_darkness_76_100), i)
        }
    }

    @JvmStatic
    fun vibrate(context: Context?) {
        val context = context ?: return
        val vibrator = context.getSystemService("vibrator") as? Vibrator ?: return
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(50L, -1))
        } else {
            vibrator.vibrate(50L)
        }
    }

    @JvmStatic
    fun unlockArea(area: Area) {
        area.isUnlocked = true
        area.triesAvailable = true
        when (area) {
            is TheDesert -> {
                unlockMessage(KingMessage.MESSAGE_2)
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_DESERT)
            }
            is EternalBattlefield -> {
                unlockMessage(KingMessage.MESSAGE_3)
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_ETERNAL_BATTLEFIELD)
            }
            is TheGoldenCity -> {
                unlockMessage(KingMessage.MESSAGE_4)
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_GOLDEN_CITY)
            }
            is BlackwaterPort -> {
                unlockMessage(KingMessage.MESSAGE_5)
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_BLACKWATER_PORT)
            }
            is FrostbitePeaks -> {
                unlockMessage(KingMessage.MESSAGE_6)
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_FROSTBITE_PEAKS)
            }
            is ObsidianMines -> {
                unlockMessage(KingMessage.MESSAGE_7)
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_OBSIDIAN_MINES)
            }
            is TheDreadfulAscent -> {
                unlockMessage(KingMessage.MESSAGE_8)
            }
            is TheSouthernGrove -> {
                unlockMessage(KingMessage.MESSAGE_9)
                unlockMessage(KingMessage.MESSAGE_10)
                unlockMessage(KingMessage.MESSAGE_11)
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_SOUTHERN_GROVE)
            }
            is BarrenWastelands -> {
                unlockMessage(KingMessage.MESSAGE_12)
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_BARREN_WASTELANDS)
            }
            is HiddenCityOfLarox -> {
                unlockMessage(KingMessage.MESSAGE_13)
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_HIDDEN_CITY)
            }
            is LostLands -> {
                unlockMessage(KingMessage.MESSAGE_14)
                AchievementsUtils.unlock(AchievementsUtils.ACHIEVEMENT_THE_LOST_LANDS)
            }
            is TheDireDescent -> {
                unlockMessage(KingMessage.MESSAGE_15)
            }
            is SleepingPlanet -> {
                unlockMessage(KingMessage.MESSAGE_16)
                unlockMessage(KingMessage.MESSAGE_17)
            }
        }
        if (MainActivity.dungeonsFragment != null && Utils.isMainLooper()) {
            MainActivity.dungeonsFragment.refreshDungeonVisibility()
            val mainActivity = MainActivity.dungeonsFragment.activity as? MainActivity
            mainActivity?.refreshKingMessages()
            mainActivity?.refreshRaidsFragmentVisibility()
        }
        if (MainActivity.raidsFragment == null || !Utils.isMainLooper()) {
            return
        }
        MainActivity.raidsFragment.refreshRaidVisibility()
    }

    private fun unlockMessage(kingMessage: KingMessage) {
        MainActivity.data.messagesToShow.add(kingMessage)
        MainActivity.data.messagesGotten.add(kingMessage)
    }

    @JvmStatic
    fun clickArea(fragment: Fragment, area: Area) {
        if (area.adventurersExploringIds.isEmpty()) {
            if (area.getAreaType() == 0 || area.triesAvailable) {
                if (MainActivity.shownDialogSendTeam != null) {
                    return
                }
                val dialog = DialogSendTeam()
                dialog.area = area
                MainActivity.shownDialogSendTeam = dialog
                dialog.show(fragment.parentFragmentManager, "dialog_send_team")
                return
            }
            if (MainActivity.shownDialogRefillRaidTry != null) {
                return
            }
            val refillDialog = DialogRefillRaidTry()
            val iCostToRefresh = area.costToRefresh()
            refillDialog.title = fragment.getString(R.string.gems_replenish_raid_tries_title)
            refillDialog.description = String.format(fragment.getString(R.string.gems_replenish_raid_tries_body), iCostToRefresh)
            refillDialog.cost = iCostToRefresh
            refillDialog.callback = java.util.function.BooleanSupplier {
                val gems = MainActivity.data.gems
                val j = iCostToRefresh.toLong()
                if (gems < j) {
                    MainActivity.shownDialogRefillRaidTry?.displayError()
                    false
                } else {
                    area.triesAvailable = true
                    MainActivity.data.gems = gems - j
                    (fragment.activity as? MainActivity)?.refreshGems()
                    area.refreshTries()
                    true
                }
            }
            MainActivity.shownDialogRefillRaidTry = refillDialog
            refillDialog.show(fragment.parentFragmentManager, "dialog_spend_gems")
            return
        }
        if (area.terminationRequested || MainActivity.shownDialogDungeonDetail != null) {
            return
        }
        val dungeonDialog = DialogDungeonDetail()
        dungeonDialog.area = area
        MainActivity.shownDialogDungeonDetail = dungeonDialog
        dungeonDialog.show(fragment.parentFragmentManager, "dialog_dungeon_detail")
    }

    @JvmStatic
    fun getFailureColor(): Int {
        return if (MainActivity.data.isSettingColorblindMode) R.color.failure_colorblind else R.color.failure
    }

    @JvmStatic
    fun openDoctrineDialog(adventurer: Adventurer, doctrine: Doctrine?) {
        if (MainActivity.shownDialogDoctrine != null) {
            return
        }
        val dialog = DialogDoctrine()
        dialog.doctrine = doctrine ?: adventurer.doctrine
        dialog.adventurer = adventurer
        dialog.readOnly = doctrine != null
        MainActivity.shownDialogDoctrine = dialog
        dialog.show(MainActivity.headquartersFragment?.parentFragmentManager ?: return, "dialog_doctrine")
    }

    @JvmStatic
    fun applyAscendedPalette(layoutAdventurerBinding: LayoutAdventurerBinding) {
        val context = layoutAdventurerBinding.root.context
        layoutAdventurerBinding.containerAdventurer.setBackgroundResource(R.drawable.object_border_ascended)
        layoutAdventurerBinding.weapon.setBackgroundResource(R.drawable.object_border_ascended)
        layoutAdventurerBinding.armor.setBackgroundResource(R.drawable.object_border_ascended)
        layoutAdventurerBinding.accessory.setBackgroundResource(R.drawable.object_border_ascended)
        layoutAdventurerBinding.image.setBackgroundResource(R.drawable.object_border_rounded_left_ascended)
        layoutAdventurerBinding.name.setTextColor(context.resources.getColor(R.color.ascended_unit, context.theme))
    }

    @JvmStatic
    fun getPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter {
        return ScreenSlidePagerAdapter(fragmentActivity)
    }

    private class ScreenSlidePagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
        override fun createFragment(i: Int): Fragment {
            return when (i) {
                1 -> AdventurersFragment()
                2 -> DungeonsFragment()
                3 -> RaidsFragment()
                else -> HeadquartersFragment()
            }
        }

        override fun getItemCount(): Int {
            return if (RaidsFragment.VISIBLE) 4 else 3
        }
    }

    @JvmStatic
    @Suppress("UNCHECKED_CAST")
    fun getItemsGridAdapter(context: Context?, list: List<Item?>?): ArrayAdapter<Item> {
        val ctx = context!!
        val itemList = (list as? List<Item>) ?: emptyList()
        return GridAdapter(ctx, R.layout.layout_item_big_grid, itemList)
    }

    private class GridAdapter(
        context: Context,
        private val resource: Int,
        private val items: List<Item>
    ) : ArrayAdapter<Item>(context, resource, items) {
        override fun getCount(): Int = items.size
        override fun getItem(position: Int): Item? = items.getOrNull(position)

        override fun getView(i: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: LayoutInflater.from(context).inflate(resource, parent, false)
            val imageView = view.findViewById<ImageView>(R.id.image)
            val textView = view.findViewById<TextView>(R.id.stack)
            val item = items[i]
            imageView.setImageDrawable(ResourcesCompat.getDrawable(context.resources, item.getIdImage(), context.theme))
            imageView.setBackgroundResource(backgroundFromRarity(item.getRarity()))
            textView.text = item.getStack().toString()
            return view
        }
    }

    @JvmStatic
    fun getEnemyReportGridAdapter(context: Context?, list: List<EnemyCounter>): ArrayAdapter<EnemyCounter> {
        val context = context!!
        return GridAdapterEnemies(context, R.layout.layout_item_big_grid, list)
    }

    private class GridAdapterEnemies(
        context: Context,
        private val resource: Int,
        private val enemies: List<EnemyCounter>
    ) : ArrayAdapter<EnemyCounter>(context, resource) {
        override fun getCount(): Int = enemies.size

        override fun getView(i: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: LayoutInflater.from(context).inflate(resource, parent, false)
            val imageView = view.findViewById<ImageView>(R.id.image)
            val textView = view.findViewById<TextView>(R.id.stack)
            val enemyCounter = enemies[i]
            val enemy = enemyCounter.enemy?.let { Enemy.getInstance(it) }
            imageView.setImageDrawable(ResourcesCompat.getDrawable(context.resources, enemy?.imageId ?: 0, context.theme))
            imageView.setBackgroundResource(R.drawable.object_border_dim_white)
            textView.text = enemyCounter.timesSlain.toString()
            return view
        }
    }

    @JvmStatic
    fun getRecipesListAdapter(list: List<Recipes>): BaseAdapter {
        return RecipesAdapter(list)
    }

    private class RecipesAdapter(private val recipes: List<Recipes>) : BaseAdapter() {
        override fun getItemId(i: Int): Long = 0L
        override fun getCount(): Int = recipes.size
        override fun getItem(i: Int): Any = recipes[i]

        override fun getView(i: Int, convertView: View?, parent: ViewGroup): View {
            val holder: LayoutCraftNamedViewHolder
            if (convertView == null) {
                val binding = LayoutCraftNamedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                holder = LayoutCraftNamedViewHolder(binding)
            } else {
                holder = convertView.tag as LayoutCraftNamedViewHolder
            }
            val b = holder.binding
            val context = b.root.context
            val r = recipes[i]
            val result = r.getResult()
            if (result != null) {
                b.name.setText(result.getIdName())
                b.result.image.setImageDrawable(ResourcesCompat.getDrawable(context.resources, result.getIdImage(), context.theme))
                b.result.image.setBackgroundResource(backgroundFromRarity(result.getRarity()))
                b.result.stack.text = result.getStack().toString()
                b.result.root.setOnClickListener {
                    openItemDetail(result)
                }
            }
            val ingredients = r.getIngredients()
            val ing0 = ingredients.getOrNull(0)
            if (ing0 != null) {
                b.ingredient1.image.setImageDrawable(ResourcesCompat.getDrawable(context.resources, ing0.getIdImage(), context.theme))
                b.ingredient1.image.setBackgroundResource(backgroundFromRarity(ing0.getRarity()))
                b.ingredient1.stack.text = ing0.getStack().toString()
                b.ingredient1.stack.setTextColor(context.resources.getColor(if (Utils.gotEnoughItem(ing0)) R.color.dim_white else getFailureColor(), context.theme))
                b.ingredient1.root.setOnClickListener {
                    openItemDetail(ing0)
                }
            }
            if (ingredients.size > 1 && ingredients[1] != null) {
                val ing1 = ingredients[1]!!
                b.plusSign1.visibility = View.VISIBLE
                b.ingredient2.root.visibility = View.VISIBLE
                b.ingredient2.image.setImageDrawable(ResourcesCompat.getDrawable(context.resources, ing1.getIdImage(), context.theme))
                b.ingredient2.image.setBackgroundResource(backgroundFromRarity(ing1.getRarity()))
                b.ingredient2.stack.text = ing1.getStack().toString()
                b.ingredient2.stack.setTextColor(context.resources.getColor(if (Utils.gotEnoughItem(ing1)) R.color.dim_white else getFailureColor(), context.theme))
                b.ingredient2.root.setOnClickListener {
                    openItemDetail(ing1)
                }
            } else {
                b.plusSign1.visibility = View.GONE
                b.ingredient2.root.visibility = View.GONE
            }
            if (ingredients.size > 2 && ingredients[2] != null) {
                val ing2 = ingredients[2]!!
                b.plusSign2.visibility = View.VISIBLE
                b.ingredient3.root.visibility = View.VISIBLE
                b.ingredient3.image.setImageDrawable(ResourcesCompat.getDrawable(context.resources, ing2.getIdImage(), context.theme))
                b.ingredient3.image.setBackgroundResource(backgroundFromRarity(ing2.getRarity()))
                b.ingredient3.stack.text = ing2.getStack().toString()
                b.ingredient3.stack.setTextColor(context.resources.getColor(if (Utils.gotEnoughItem(ing2)) R.color.dim_white else getFailureColor(), context.theme))
                b.ingredient3.root.setOnClickListener {
                    openItemDetail(ing2)
                }
            } else {
                b.plusSign2.visibility = View.GONE
                b.ingredient3.root.visibility = View.GONE
            }
            return holder.view
        }

        private class LayoutCraftNamedViewHolder(val binding: LayoutCraftNamedBinding) {
            val view: View = binding.root
            init {
                view.tag = this
            }
        }
    }

    @JvmStatic
    fun getBestiaryListAdapter(list: List<Area>): BaseAdapter {
        return BestiaryAdapter(list)
    }

    private class BestiaryAdapter(private val areas: List<Area>) : BaseAdapter() {
        override fun getItemId(i: Int): Long = 0L
        override fun getCount(): Int = areas.size
        override fun getItem(i: Int): Any = areas[i]

        override fun getView(i: Int, convertView: View?, parent: ViewGroup): View {
            val holder: LayoutBestiaryElementViewHolder
            if (convertView == null) {
                val binding = LayoutBestiaryElementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                holder = LayoutBestiaryElementViewHolder(binding)
            } else {
                holder = convertView.tag as LayoutBestiaryElementViewHolder
            }
            val b = holder.binding
            val context = b.root.context
            val area = areas[i]
            val listEnemies = area.listEnemies()
            b.areaName.text = context.getString(area.getName())
            b.enemiesGrid.adapter = getEnemiesGridAdapter(context, listEnemies)
            b.enemiesGrid.onItemClickListener = AdapterView.OnItemClickListener { _, _, i2, _ ->
                val enemy = listEnemies[i2]
                if (MainActivity.data.seenEnemies.contains(enemy.trueClass)) {
                    val fm = MainActivity.headquartersFragment?.parentFragmentManager ?: return@OnItemClickListener
                    getEnemyDetailDialog(fm, enemy)
                }
            }
            return holder.view
        }

        private class LayoutBestiaryElementViewHolder(val binding: LayoutBestiaryElementBinding) {
            val view: View = binding.root
            init {
                view.tag = this
            }
        }
    }

    @JvmStatic
    fun getEnemiesGridAdapter(context: Context?, list: List<Enemy>): ArrayAdapter<Enemy> {
        val context = context!!
        return BestiaryGridAdapter(context, R.layout.layout_bestiary_enemy, list)
    }

    private class BestiaryGridAdapter(
        context: Context,
        private val resource: Int,
        private val enemies: List<Enemy>
    ) : ArrayAdapter<Enemy>(context, resource) {
        override fun getCount(): Int = enemies.size

        override fun getView(i: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: LayoutInflater.from(context).inflate(resource, parent, false)
            val imageView = view.findViewById<ImageView>(R.id.image)
            val enemy = enemies[i]
            val isSeen = MainActivity.data.seenEnemies.contains(enemy.trueClass)
            val drawableRes = if (isSeen) enemy.imageId else R.drawable.unknown
            imageView.setImageDrawable(ResourcesCompat.getDrawable(context.resources, drawableRes, context.theme))
            return view
        }
    }

    @JvmStatic
    fun getKingMessagesAdapter(list: List<KingMessage>): BaseAdapter {
        return KingMessagesAdapter(list)
    }

    private class KingMessagesAdapter(private val messages: List<KingMessage>) : BaseAdapter() {
        override fun getItemId(i: Int): Long = 0L
        override fun getCount(): Int = messages.size
        override fun getItem(i: Int): Any = messages[i]

        override fun getView(i: Int, convertView: View?, parent: ViewGroup): View {
            val context = parent.context
            val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.layout_king_message, parent, false)
            val textView = view.findViewById<TextView>(R.id.message_text)
            val kingMessage = messages[i]
            textView.setText(kingMessage.title)
            view.setOnClickListener {
                if (MainActivity.shownKingMessageDialog != null) return@setOnClickListener
                val dialog = getInfoDialog(context, kingMessage.title, context.getString(kingMessage.body), true)
                MainActivity.shownKingMessageDialog = dialog
                dialog.setOnDismissListener {
                    MainActivity.shownKingMessageDialog = null
                }
                dialog.show()
            }
            return view
        }
    }

    @JvmStatic
    fun getDoctrinesAdapter(list: List<Doctrine?>?, adventurer: Adventurer?): BaseAdapter {
        val filtered = list?.filterNotNull() ?: emptyList()
        return DoctrinesAdapter(filtered, adventurer)
    }

    private class DoctrinesAdapter(
        private val doctrines: List<Doctrine>,
        private val adventurer: Adventurer?
    ) : BaseAdapter() {
        override fun getItemId(i: Int): Long = 0L
        override fun getCount(): Int = doctrines.size
        override fun getItem(i: Int): Any = doctrines[i]

        override fun getView(i: Int, convertView: View?, parent: ViewGroup): View {
            val context = parent.context
            val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.layout_doctrine, parent, false)
            val textView = view.findViewById<TextView>(R.id.doctrine_name)
            val textView2 = view.findViewById<TextView>(R.id.doctrine_description)
            val imageView = view.findViewById<ImageView>(R.id.doctrine_image)
            val doctrine = doctrines[i]
            textView.text = context.getString(doctrine.idName)
            textView2.text = context.getString(doctrine.idDescriptionShort)
            imageView.setImageDrawable(ResourcesCompat.getDrawable(context.resources, doctrine.idImage, context.theme))
            view.setOnClickListener {
                if (adventurer != null) openDoctrineDialog(adventurer, doctrine)
            }
            return view
        }
    }

    @JvmStatic
    fun getFaqAdapter(list: List<Faq>): BaseAdapter {
        return FaqAdapter(list)
    }

    private class FaqAdapter(private val faqs: List<Faq>) : BaseAdapter() {
        override fun getItemId(i: Int): Long = 0L
        override fun getCount(): Int = faqs.size
        override fun getItem(i: Int): Any = faqs[i]

        override fun getView(i: Int, convertView: View?, parent: ViewGroup): View {
            val context = parent.context
            val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.layout_king_message, parent, false)
            val textView = view.findViewById<TextView>(R.id.message_text)
            val faq = faqs[i]
            textView.setText(faq.title)
            view.setOnClickListener {
                if (MainActivity.shownDialogIndividualFaq != null) return@setOnClickListener
                val dialog = getInfoDialog(context, faq.title, context.getString(faq.body), false)
                MainActivity.shownDialogIndividualFaq = dialog
                dialog.setOnDismissListener {
                    MainActivity.shownDialogIndividualFaq = null
                }
                dialog.show()
            }
            return view
        }
    }

    @JvmStatic
    fun getPetsGridAdapter(context: Context?, list: List<Pet?>?): ArrayAdapter<Pet> {
        val context = context!!
        val filtered = list?.filterNotNull() ?: emptyList()
        return PetsGridAdapter(context, R.layout.layout_pet_grid, filtered)
    }

    private class PetsGridAdapter(
        context: Context,
        private val resource: Int,
        private val pets: List<Pet>
    ) : ArrayAdapter<Pet>(context, resource) {
        override fun getCount(): Int = pets.size

        override fun getView(i: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: LayoutInflater.from(context).inflate(resource, parent, false)
            val imageView = view.findViewById<ImageView>(R.id.image)
            val textView = view.findViewById<TextView>(R.id.level)
            val imageView2 = view.findViewById<ImageView>(R.id.autofeed)
            val pet = pets[i]
            imageView.setImageDrawable(ResourcesCompat.getDrawable(context.resources, pet.idImage, context.theme))
            textView.text = pet.level.toString()
            imageView2.visibility = if (pet.favourite) View.VISIBLE else View.INVISIBLE
            return view
        }
    }
}
