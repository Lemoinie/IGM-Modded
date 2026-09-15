package it.paranoidsquirrels.idleguildmaster.mod

import android.graphics.drawable.ColorDrawable
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.R
import it.paranoidsquirrels.idleguildmaster.TrueTimeUtils
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.FileManager
import it.paranoidsquirrels.idleguildmaster.storage.SaveManager
import it.paranoidsquirrels.idleguildmaster.storage.SaveResetter
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
import it.paranoidsquirrels.idleguildmaster.storage.data.items.MerchantOffer
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Consumable
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon
import it.paranoidsquirrels.idleguildmaster.storage.data.items.instances.*
import it.paranoidsquirrels.idleguildmaster.storage.data.pets.Pet
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumeEvo22
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogConsumeXPBook
import it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSettings
import java.util.concurrent.CopyOnWriteArrayList
import java.util.regex.Pattern

object ModManager {

    const val IMPERIAL_CAPTAIN_THRESHOLD = 100

    @JvmStatic
    fun onItemConsume(item: Item): Boolean {
        if (item is XPBook1 || item is XPBook2 || item is XPBook3 || item is XPBook10) {
            if (item.stack > 0 && MainActivity.headquartersFragment != null) {
                val dialog = DialogConsumeXPBook()
                dialog.selectedBook = item as Consumable
                dialog.show(MainActivity.headquartersFragment!!.parentFragmentManager, "dialog_consume_xpbook")
                return true
            }
        } else if (item is Evo22Vial) {
            if (item.stack > 0 && MainActivity.headquartersFragment != null) {
                val dialog = DialogConsumeEvo22()
                dialog.show(MainActivity.headquartersFragment!!.parentFragmentManager, "dialog_consume_evo22")
                return true
            }
        }
        return false
    }

    @JvmStatic
    fun onAdventurerDismissed(adventurer: Adventurer?) {
        if (adventurer == null) return
        adventurer.weapon?.let {
            Utils.collectItem(it, MainActivity.data.items)
            adventurer.weapon = null
        }
        adventurer.armor?.let {
            Utils.collectItem(it, MainActivity.data.items)
            adventurer.armor = null
        }
        adventurer.accessory?.let {
            Utils.collectItem(it, MainActivity.data.items)
            adventurer.accessory = null
        }
    }

    @JvmStatic
    fun saveGameSynchronous(context: Context?) {
        if (context == null || MainActivity.data == null) return
        try {
            MainActivity.data.lastAccess = TrueTimeUtils.millis()
            if (!SaveManager.inhibitSave && (MainActivity.IDLE_THREAD_FINISHED == null || MainActivity.IDLE_THREAD_FINISHED.value)) {
                FileManager.save(context)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    // Packed int field storage in data.redeem_m975nfu5:
    // Bits 0-9: Imperial kills (0-1023)
    // Bits 10-17: Idle progress cap in hours (12 to 168)
    // Bits 18-31: Loot cap override
    private fun getPacked(): Int {
        return try { MainActivity.data.redeem_m975nfu5 } catch (e: Exception) { 0 }
    }

    private fun setPacked(packed: Int) {
        try { MainActivity.data.redeem_m975nfu5 = packed } catch (e: Exception) { e.printStackTrace() }
    }

    @JvmStatic
    fun getImperialKills(): Int = getPacked() and 0x3FF

    @JvmStatic
    fun setImperialKills(amount: Int, context: Context?) {
        val clamped = amount.coerceIn(0, 1023)
        setPacked((getPacked() and 0x3FF.inv()) or clamped)
        saveGameSynchronous(context)
    }

    @JvmStatic
    fun shouldSpawnImperialCaptain(): Boolean {
        return try {
            if (MainActivity.data == null) false
            else getImperialKills() >= IMPERIAL_CAPTAIN_THRESHOLD && Math.random() < 0.5
        } catch (e: Exception) {
            false
        }
    }

    @JvmStatic
    fun onEnemyKilled(trueClass: String, context: Context?): Boolean {
        if (trueClass == "ImperialGuard") {
            setImperialKills(getImperialKills() + 1, context)
            return true
        }
        return false
    }

    @JvmStatic
    fun getIdleTimeCap(vanillaCapSeconds: Int): Int {
        val hours = (getPacked() shr 10) and 0xFF
        return if (hours in 12..168) hours * 3600 else vanillaCapSeconds
    }

    @JvmStatic
    fun setIdleTimeCap(hours: Int, context: Context?) {
        val clamped = hours.coerceIn(12, 168)
        setPacked((getPacked() and (0xFF shl 10).inv()) or (clamped shl 10))
        saveGameSynchronous(context)
    }

    @JvmStatic
    fun getLootCap(): Int {
        val cap = (getPacked() shr 18) and 0x3FFF
        return if (cap > 0) cap else 50
    }

    @JvmStatic
    fun setLootCap(cap: Int, context: Context?) {
        val clamped = cap.coerceIn(10, 16000)
        setPacked((getPacked() and (0x3FFF shl 18).inv()) or (clamped shl 18))
        saveGameSynchronous(context)
    }

    @JvmStatic
    fun dragonBloodMultiplier(entity: Entity, currentDamage: Double): Double {
        return try {
            if (entity is Adventurer && entity.traitRare == Trait.DRAGON_BLOOD) {
                val tier = entity.maxLevel / 5
                currentDamage * Math.max(0.0, 1.0 - (tier * 0.01))
            } else {
                currentDamage
            }
        } catch (e: Exception) {
            currentDamage
        }
    }

    @JvmStatic
    fun setAdventurerCommonTrait(adv: Adventurer, trait: Trait): Boolean {
        adv.traitCommon = trait
        return true
    }

    @JvmStatic
    fun refreshShop() {
        try {
            val d = MainActivity.data ?: return
            d.merchantRegularStockItems.clear()
            d.isNewMerchantRegularItems = true
            MainActivity.headquartersFragment?.refresh()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @JvmStatic
    fun addGold(amount: Long) {
        val d = MainActivity.data ?: return
        d.money = (d.money + amount).coerceAtLeast(0L)
        MainActivity.headquartersFragment?.refresh()
    }

    @JvmStatic
    fun expandStorage(extraSlots: Int, context: Context?) {
        val d = MainActivity.data ?: return
        d.upgradeStorage += extraSlots
        MainActivity.headquartersFragment?.refresh()
        saveGameSynchronous(context)
    }

    @JvmStatic
    fun processRedeemCode(code: String?, context: Context?): String? {
        if (code.isNullOrBlank() || MainActivity.data == null) return null
        val upper = code.trim().uppercase()

        if (upper == "SHOP") {
            refreshShop()
            saveGameSynchronous(context)
            return "Shop refreshed!"
        }
        if (upper.startsWith("GOLD ")) {
            return try {
                val amount = code.substring(5).trim().toLong()
                addGold(amount)
                saveGameSynchronous(context)
                "Added $amount Gold!"
            } catch (e: Exception) { "Invalid gold amount" }
        }
        if (upper.startsWith("STORAGE ")) {
            return try {
                val slots = code.substring(8).trim().toInt()
                expandStorage(slots, context)
                "Expanded warehouse by $slots slots!"
            } catch (e: Exception) { "Invalid storage slots" }
        }
        if (upper.startsWith("IDLETIME ")) {
            return try {
                val hours = code.substring(9).trim().toInt()
                setIdleTimeCap(hours, context)
                "Idle progress cap set to $hours hours!"
            } catch (e: Exception) { "Usage: IDLETIME <12-168>" }
        }
        if (upper.startsWith("LOOTCAP ")) {
            return try {
                val cap = code.substring(8).trim().toInt()
                setLootCap(cap, context)
                "Chest loot capacity set to $cap!"
            } catch (e: Exception) { "Usage: LOOTCAP <10-16000>" }
        }
        if (upper == "QUEST") {
            try {
                MainActivity.data.kingsQuests.clear()
                MainActivity.data.isQuestsRefreshed = true
                MainActivity.headquartersFragment?.refresh()
                saveGameSynchronous(context)
                return "Quests refreshed!"
            } catch (e: Exception) { return "Failed to refresh quests" }
        }
        if (upper == "KILLS") {
            return "Imperial Guard kills: ${getImperialKills()} / $IMPERIAL_CAPTAIN_THRESHOLD"
        }
        if (upper.startsWith("SETKILLS ")) {
            return try {
                val n = code.substring(9).trim().toInt()
                setImperialKills(n, context)
                "Imperial Guard kills set to $n!"
            } catch (e: Exception) { "Usage: SETKILLS <0-1023>" }
        }
        if (upper.startsWith("ITEM ")) {
            return giveItemCode(code.substring(5).trim(), context)
        }
        if (upper.startsWith("HERO ")) {
            return createCustomAdventurer(code.substring(5).trim(), context)
        }
        if (upper.startsWith("PET ")) {
            return spawnPetCode(code.substring(4).trim(), context)
        }

        return null
    }

    @JvmStatic
    fun giveItemCode(itemSpec: String, context: Context?): String {
        return try {
            val parts = itemSpec.split(" ")
            val name = parts[0]
            val count = if (parts.size > 1) parts[1].toInt() else 1
            val item = Item.getInstance(name, count) ?: return "Item '$name' not found"
            Utils.collectItem(item, MainActivity.data.items)
            MainActivity.shownDialogStorage?.update()
            saveGameSynchronous(context)
            "Collected $count x $name!"
        } catch (e: Exception) {
            "Usage: ITEM <ItemName> [count]"
        }
    }

    @JvmStatic
    fun createCustomAdventurer(spec: String, context: Context?): String {
        return try {
            val parts = spec.split(" ")
            val unitClass = parts[0]
            val level = if (parts.size > 1) parts[1].toInt() else 1
            val newId = Utils.calculateNewAdventurerId()
            val adv = Adventurer.getInstance(unitClass, newId, level, 0, null, null, null, null, null, PotionsDrank(), null, false)
                ?: return "Hero class '$unitClass' not found"
            if (parts.size > 2) adv.traitCommon = Trait.fromString(parts[2])
            if (parts.size > 3) adv.traitRare = Trait.fromString(parts[3])
            MainActivity.data.adventurers.add(adv)
            MainActivity.adventurersFragment?.refresh()
            MainActivity.headquartersFragment?.refresh()
            saveGameSynchronous(context)
            "Created $unitClass (Lvl $level)!"
        } catch (e: Exception) {
            "Usage: HERO <Class> [level] [commonTrait] [rareTrait]"
        }
    }

    @JvmStatic
    fun spawnPetCode(spec: String, context: Context?): String {
        return try {
            val parts = spec.split(" ")
            val petClass = parts[0]
            val level = if (parts.size > 1) parts[1].toInt() else 1
            val id = Utils.calculateNewPetId()
            val pet = Pet.getInstance(petClass, id) ?: return "Pet '$petClass' not found"
            pet.level = level
            MainActivity.data.pets.add(pet)
            MainActivity.headquartersFragment?.refresh()
            saveGameSynchronous(context)
            "Pet '$petClass' added to shelter!"
        } catch (e: Exception) {
            "Usage: PET <PetClass> [level]"
        }
    }

    @JvmStatic
    fun wireSettingsReset(dialog: DialogSettings) {
        val ctx = dialog.context ?: return
        val dlg = dialog.dialog ?: return
        val win = dlg.window ?: return
        val root = win.decorView
        val resetId = ctx.resources.getIdentifier("reset", "id", ctx.packageName)
        if (resetId != 0) {
            root.findViewById<View>(resetId)?.setOnClickListener {
                SaveResetter.showResetConfirmation(ctx, dialog.activity)
            }
        }
    }

    public const val MOD_ABOUT_TEXT: String =
        "1.0.0.0 (31/8/2026):\n" +
        "- Initialized Mod.\n" +
        "- Made Tests: x4 Speed in Expedition. Increase idle time to 24h\n" +
        "\n" +
        "1.0.0.1 (31/8/2026):\n" +
        "- Fixed bugs\n" +
        "\n" +
        "1.0.1.0 (31/8/2026):\n" +
        "- Added new Wild type pet Semi.\n" +
        "- Initialized 5th trait system for pet.\n" +
        "- Initialized Save File system.\n" +
        "\n" +
        "1.0.1.1 (31/8/2026):\n" +
        "- Fixed bugs\n" +
        "- Fixed crash when summon Semi\n" +
        "- Fixed bug unable to summon Semi\n" +
        "\n" +
        "1.0.1.2 (31/8/2026):\n" +
        "- Fix bugs and crashes\n" +
        "\n" +
        "1.0.2.0 (31/8/2026):\n" +
        "- Initialized new class system.\n" +
        "- Added new class Berserker.\n" +
        "- Added unique type of class with 2 slots of weapon, 1 slot of armor and 0 slot of accessories\n" +
        "- Added 1 new Passive skill and 1 new Active skill\n" +
        "\n" +
        "1.0.2.1 (31/8/2026):\n" +
        "- Fixed bug unable to dismiss Berserker\n" +
        "- Fixed bug unable to promote to Berserker\n" +
        "- Fixed bug lost weapon in second weapon slot when dismiss Berserker\n" +
        "- Fixed bug unable to ascend Berserker\n" +
        "- Fixed visual bug on Berserker in Adventurer tab\n" +
        "\n" +
        "1.0.2.2 (31/8/2026):\n" +
        "- Fixed visual bug in Dungeon tab and Raid tab\n" +
        "- Removed x4 speed and 24h idle time\n" +
        "\n" +
        "1.0.3.0 (1/9/2026):\n" +
        "- Initialized Attack Thrice system\n" +
        "- Added new item: Celestial Bow\n" +
        "\n" +
        "1.0.4.0 (1/9/2026):\n" +
        "- Initialized XP Book system\n" +
        "- Added 4 new xp books\n" +
        "\n" +
        "1.0.4.1 (1/9/2026):\n" +
        "- Fix bug: Unable to open screen when use XP Book\n" +
        "\n" +
        "1.0.5.0 (1/9/2026):\n" +
        "- Initialized Basic trait modification system\n" +
        "- Added new item Evo-22 Vial\n" +
        "\n" +
        "1.0.5.1 (1/9/2026):\n" +
        "- Fixed bug: Unable to open screen when use Evo-22 Vial\n" +
        "- Fixed bug: Unable to display list of adventurers\n" +
        "- Fixed bug: Unable to change adventurer's basic trait\n" +
        "\n" +
        "1.0.5.2 (1/9/2026):\n" +
        "- Fixed visual bugs.\n" +
        "- Updated new art for class Berserker.\n" +
        "- Removed 2 weapon slots system.\n" +
        "- Updated Berserker's passive skill\n" +
        "\n" +
        "1.0.5.3 (2/9/2026):\n" +
        "- Fixed minor bugs\n" +
        "\n" +
        "1.0.6.0 (2/9/2026):\n" +
        "- Added Knight Slime into Slime Pond raid and Bestiary\n" +
        "- Added 1 new Passive skill\n" +
        "\n" +
        "1.0.6.1 (2/9/2026):\n" +
        "- Fixed crash when spawn Knight Slime\n" +
        "- Fixed bug unable to display Knight Slime's details\n" +
        "- Fixed crash when open Knight Slime's details\n" +
        "- Fixed crash when drop Knight Slime's loots\n" +
        "- Fixed bug unable to display Knight Slime's icon in battle\n" +
        "- Fixed bug Knight Slime automatically die when spawn\n" +
        "- Fixed bug unable to drop Knight Slime's loot\n" +
        "- Fixed bug Knight Slime drops Green Slime's loot\n" +
        "\n" +
        "1.1.0.0 (5/9/2026):\n" +
        "- Big update for mod engine\n" +
        "- Built pipeline, stubs, ModManager skeleton\n" +
        "- Expanded decompiled resources and added development tooling\n" +
        "- Update ModManager with enhanced modification capabilities\n" +
        "\n" +
        "1.1.1.0 (6/9/2026):\n" +
        "- Added new miniboss into The Golden City dungeon: Imperial Captain\n" +
        "- Added 1 new Passive skill and 1 new Active skill\n" +
        "- Added new weapon: Captain's sword\n" +
        "\n" +
        "1.1.1.1 (6/9/2026):\n" +
        "- Fixed visual bugs: Repetitive in description of Captain's Sword, Imperial Authority, Execution Order.\n" +
        "- Fixed bugs: Unable to consume Evo-23 Vial, Evo-22 Vial, XP Books\n" +
        "- Fixed bugs: Kill count doesn't reset, leading to repeated encounters with the Imperial Captain.\n" +
        "- Added announce log for Imperial Captain.\n" +
        "- Fixed visual bug: Announce log of Imperial Captain doesn't display number.\n" +
        "\n" +
        "1.1.1.2 (7/9/2026):\n" +
        "- Troll's Resistance / Warlock's Resilience: Doctrine cost reduced from 3 -> 1, Defense bonus increased from +1 -> +2 DEF per point, Max points increased from 2 -> 5\n" +
        "- Lightning Speed: Extra attack chance increased from +15% -> +20% per level\n" +
        "- Improved Health: Health bonus increased from +15 -> +25 HP per level\n" +
        "- Troll Blood: Reworked from flat HP regeneration to (Tier / 2)% of max HP regenerated per turn. At Tier 9: 4.5% max HP regenerated per turn.\n" +
        "- Dragon Blood: Now grants 1% damage reduction per tier\n" +
        "- Blessed: Darkness reduction increased from 8 -> 15\n" +
        "- Nimble: Dodge chance increased from 8% -> 15%\n" +
        "- Cursed: HP loss reduced from -4% -> -2% per turn, Lifesteal increased from 15 -> 20\n" +
        "- Focused: Miss chance reduction increased from 15% -> 25%\n" +
        "- Nocturnal: Damage bonus increased from 0.5% -> 1% per point of darkness\n" +
        "- Brute+ / Feral+ / Bookworm+: Stat multiplier increased from 1.15x -> 1.20x\n" +
        "- Added new rare trait: Ruthless+\n" +
        "\n" +
        "1.1.1.3 (7/9/2026):\n" +
        "- Fixed Evo-23 Vial unusable\n" +
        "- Fixed crash when open Settings\n" +
        "- Added Mod About\n" +
        "- Upgraded UI of Mod About.\n" +
        "\n" +
        "1.2.0.0 (12/9/2026):\n" +
        "- Added guild activities: Daily Request + Weekly Siege\n" +
        "- Added mod-owned Reputation stat (0-100, shown next to Gems)\n" +
        "- Request: daily elite enemy hunt, 2x stats, up to 12 adventurers,\n" +
        "  rewards Gems equal to current Reputation on success\n" +
        "- Failed Request: -5 Reputation\n" +
        "- Siege: weekly 10-wave defense, up to 12 defenders, no boss waves\n" +
        "- Failed Siege: -10 Reputation\n" +
        "- New redeem codes: REQUEST, SIEGE, REP [n]\n" +
        "- Added 5th tab \"Guild Activities\" (Request & Siege) to the bottom navigation.\n" +
        "\n" +
        "1.3.0.0 (13/9/2026):\n" +
        "- Guild Activities rebuilt as real Raids: Request/Siege now use the vanilla\n" +
        "  combat engine (DialogSendTeam -> DialogDungeonDetail), tick offline via\n" +
        "  compileDungeonRaidList and persist mid-fight state through save/load.\n" +
        "- Raid-style cards in the Guild tab with orange/blank try dots per the\n" +
        "  game's raid look, plus countdown timers to the next refresh.\n" +
        "- Reputation now lives in its own top-bar box with an icon (was inlined\n" +
        "  into the gems box); Guild tab title now updates like the other tabs.\n" +
        "- Elite Request targets are persisted via the Elite_ marker trueClass and\n" +
        "  rebuilt by the patched Enemy.getInstance().\n" +
        "- Unchanged rules: Request reward = Reputation, -5 on failed Request,\n" +
        "  Siege = 10 waves (5-10 monsters, no bosses), -10 on failure.\n" +
        "- Redeem codes: REQUEST, SIEGE, REP [n]\n" +
        "\n" +
        "1.3.0.1 (15/9/2026):\n" +
        "- Rebuilt mod engine into 100% native Kotlin without smali dependencies.\n" +
        "- Added 'Start New Game' confirmation in Settings wired to game save reset.\n" +
        "- Fixed Tavern capacity and new visitor timer labels.\n" +
        "- Fixed Storage item grid synchronization when selecting items.\n" +
        "- Fixed Imperial Captain and Knight Slime in Bestiary.\n" +
        "- Fixed Pet avatar click in dungeon & raid battle log screens.\n" +
        "- Fixed Imperial Captain kill count resetting properly on round end (wipe or defeat).\n" +
        "- Redesigned Pet Senko/Semi 5th trait display and unlocked all traits at Level 1.\n" +
        "- Restored custom Berserker sprite art and updated app icon to Sha." +
        "\n" +
        "1.3.0.2 (15/9/2026):\n" +
        "- Fixed Celestial Bow only attacking twice instead of attacking thrice."

    @JvmField
    var shownModAboutDialog: AlertDialog? = null
    @JvmField
    var shownVersionDetailDialog: AlertDialog? = null

    class VersionEntry(val title: String, val body: String)

    @JvmStatic
    fun parseVersionEntries(): List<VersionEntry> {
        val out = mutableListOf<VersionEntry>()
        val blocks = MOD_ABOUT_TEXT.replace("\r", "").split(Regex("\n\\s*\n"))
        for (block in blocks) {
            val trimmed = block.trim()
            if (trimmed.isEmpty()) continue
            val nl = trimmed.indexOf('\n')
            val title = if (nl < 0) trimmed else trimmed.substring(0, nl).trim()
            val body = if (nl < 0) "" else trimmed.substring(nl + 1).trim()
            out.add(0, VersionEntry(title, body))
        }
        return out
    }

    private val MOD_VERSION_LIST: List<VersionEntry> by lazy { parseVersionEntries() }

    @JvmStatic
    fun showModAbout(activity: Activity) {
        if (activity.isFinishing || shownModAboutDialog != null) return
        try {
            val ctx = activity
            val density = ctx.resources.displayMetrics.density
            val pad8 = (8.0f * density).toInt()
            val pad12 = (12.0f * density).toInt()

            val list = ListView(ctx)
            list.adapter = ModAboutAdapter(ctx, MOD_VERSION_LIST)
            list.divider = ColorDrawable(Color.TRANSPARENT)
            list.dividerHeight = pad8
            list.setPadding(pad8, pad8, pad8, 0)
            list.scrollBarStyle = View.SCROLLBARS_INSIDE_INSET

            val rowsVisible = 5.0f
            val rowHeight = (16f * density + pad12 + pad12).toInt()
            val listHeight = (rowsVisible * rowHeight).toInt() + ((rowsVisible - 1.0f) * pad8).toInt()

            val close = TextView(ctx)
            close.setText(R.string.close)
            close.textSize = 14f
            close.typeface = Typeface.DEFAULT_BOLD
            close.setTextColor(-0x4f4f50) // 0xFFB0B0B0
            close.gravity = Gravity.CENTER_HORIZONTAL
            close.setPadding(0, pad12, 0, pad12)
            close.setOnClickListener {
                shownModAboutDialog?.dismiss()
                shownModAboutDialog = null
            }

            val body = LinearLayout(ctx)
            body.orientation = LinearLayout.VERTICAL
            body.addView(list, LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, listHeight))
            body.addView(close, LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT))

            val dialog = AlertDialog.Builder(ctx, R.style.AlertDialog)
                .setTitle(R.string.drawer_mod_about_title)
                .setView(body)
                .setCancelable(true)
                .create()
            dialog.window?.setBackgroundDrawableResource(R.drawable.dialog_border)
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.setOnDismissListener { shownModAboutDialog = null }
            shownModAboutDialog = dialog
            dialog.show()
        } catch (t: Throwable) {
            t.printStackTrace()
            shownModAboutDialog = null
        }
    }

    private class ModAboutAdapter(
        private val ctx: Context,
        private val versions: List<VersionEntry>
    ) : BaseAdapter() {
        override fun getCount(): Int = versions.size
        override fun getItem(position: Int): Any = versions[position]
        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val entry = versions[position]
            val row = (convertView as? TextView) ?: TextView(ctx)
            row.text = entry.title
            row.textSize = 16f
            row.typeface = Typeface.DEFAULT_BOLD
            row.setTextColor(-0x171718) // 0xFFE8E8E8
            row.gravity = Gravity.CENTER_HORIZONTAL
            val pad12 = (12.0f * ctx.resources.displayMetrics.density).toInt()
            row.setPadding(pad12, pad12, pad12, pad12)
            row.setBackgroundResource(R.drawable.object_border_dim_white_square_no_border)
            row.setOnClickListener { showVersionDetail(ctx, entry) }
            return row
        }
    }

    @JvmStatic
    fun showVersionDetail(context: Context, entry: VersionEntry) {
        if (shownVersionDetailDialog != null) return
        try {
            val detail = AlertDialog.Builder(context, R.style.AlertDialog)
                .setTitle(entry.title)
                .setMessage(entry.body)
                .setPositiveButton(R.string.close, null)
                .create()
            detail.window?.setBackgroundDrawableResource(R.drawable.dialog_border)
            detail.setOnDismissListener { shownVersionDetailDialog = null }
            shownVersionDetailDialog = detail
            detail.show()
        } catch (t: Throwable) {
            t.printStackTrace()
            shownVersionDetailDialog = null
        }
    }

    @JvmStatic
    fun onImperialCaptainDefeated(context: Context?) {
        setImperialKills(0, context)
    }

    @JvmStatic
    fun onTeamWipe(context: Context?) {
        setImperialKills(0, context)
    }
}
