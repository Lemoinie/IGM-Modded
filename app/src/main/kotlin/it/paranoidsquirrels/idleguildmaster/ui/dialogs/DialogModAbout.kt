package it.paranoidsquirrels.idleguildmaster.ui.dialogs

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.ScrollView
import android.widget.TextView
import it.paranoidsquirrels.idleguildmaster.BuildConfig
import it.paranoidsquirrels.idleguildmaster.R

/**
 * "Mod info" dialog — the dedicated dark-theme XML layout (`dialog_mod_info.xml`) with
 * the app/version header, the Latest Highlights card and the Contributor credits, plus
 * the scrollable version-list changelog and per-version detail dialogs.
 *
 * The changelog window lists every version (its title carries the total version count);
 * each version row shows its **change count**, and tapping a version opens a scrollable
 * list where every change bullet is its own row, so long changelogs are easy to scan.
 * Opened from the navigation drawer (`R.id.mod_about` and `R.id.mod_changelog`).
 */
object DialogModAbout {

    @JvmField
    var shownModAboutDialog: AlertDialog? = null

    @JvmField
    var shownVersionDetailDialog: AlertDialog? = null

    private fun sp(context: Context, value: Float): Int =
        (value * context.resources.displayMetrics.density).toInt()

    private fun changeCount(body: String): String {
        val count = buildChangeRows(body).size
        return "$count change" + if (count == 1) "" else "s"
    }

    /**
     * Splits a changelog body into **logical change rows**.
     *
     * Lines that start with whitespace are continuation fragments of the previous
     * change (legacy hard-wrapped entries) and are joined back onto it, so each item
     * is one row and the count reflects actual changes, not line breaks.
     */
    private fun buildChangeRows(body: String): List<String> {
        val rows = mutableListOf<String>()
        for (line in body.split('\n')) {
            if (line.isBlank()) continue
            if (line.first() == ' ' && rows.isNotEmpty()) {
                rows[rows.size - 1] = rows[rows.size - 1] + " " + line.trimStart()
            } else {
                rows.add(line.trim())
            }
        }
        return rows
    }

    /** Dismisses both the version-detail dialog and the Mod Info / Changelog dialog. */
    private fun closeBothDialogs() {
        shownVersionDetailDialog?.dismiss()
        shownVersionDetailDialog = null
        shownModAboutDialog?.dismiss()
        shownModAboutDialog = null
    }

    /** The mod part of `versionName` (e.g. `1.3.13.7` from `2.148-mod-1.3.13.7`). */
    private fun modVersion(): String {
        val raw = BuildConfig.VERSION_NAME
        return if (raw != null && raw.contains("mod-")) {
            raw.substring(raw.indexOf("mod-") + 4)
        } else {
            raw ?: "1.3.13.7"
        }
    }

@JvmStatic
fun show(activity: Activity) {
    if (activity.isFinishing || shownModAboutDialog != null) return

    try {
        val ctx = activity
        val root = LayoutInflater.from(ctx).inflate(R.layout.dialog_mod_info, null)

        root.findViewById<TextView>(R.id.button_view_changelog).setOnClickListener {
            shownModAboutDialog?.dismiss()
            shownModAboutDialog = null
            showChangelog(ctx)
        }

        root.findViewById<TextView>(R.id.button_close).setOnClickListener {
            closeBothDialogs()
        }

        val dialog = AlertDialog.Builder(ctx, R.style.AlertDialog)
            .setView(root)
            .setCancelable(true)
            .create()

        dialog.window?.setBackgroundDrawableResource(R.drawable.dialog_border)
        dialog.setOnDismissListener {
            shownModAboutDialog = null
        }

        shownModAboutDialog = dialog
        dialog.show()

        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window?.decorView?.setPadding(0, 0, 0, 0)

    } catch (t: Throwable) {
        t.printStackTrace()
        shownModAboutDialog = null
    }
}
            root.findViewById<TextView>(R.id.button_view_changelog).setOnClickListener {
                shownModAboutDialog?.dismiss()
                shownModAboutDialog = null
                showChangelog(ctx)
            }
            root.findViewById<TextView>(R.id.button_close).setOnClickListener { closeBothDialogs() }

            val dialog = AlertDialog.Builder(ctx, R.style.AlertDialog)
                .setView(root)
                .setCancelable(true)
                .create()
            dialog.window?.setBackgroundDrawableResource(R.drawable.dialog_border)
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.window?.decorView?.setPadding(0, 0, 0, 0)
            dialog.setOnDismissListener { shownModAboutDialog = null }
            shownModAboutDialog = dialog
            dialog.show()
        } catch (t: Throwable) {
            t.printStackTrace()
            shownModAboutDialog = null
        }
    }

    /** The version-list (Changelog) window; its title carries the total version count. */
    @JvmStatic
    fun showChangelog(activity: Activity) {
        if (activity.isFinishing || shownModAboutDialog != null) return
        try {
            val ctx = activity
            val pad8 = sp(ctx, 8f)

            val list = ListView(ctx)
            list.adapter = ModAboutAdapter(ctx, ModChangelog.allEntries())
            list.divider = ColorDrawable(Color.TRANSPARENT)
            list.dividerHeight = pad8
            list.setPadding(pad8, pad8, pad8, 0)
            list.scrollBarStyle = View.SCROLLBARS_INSIDE_INSET

            val rowsVisible = 6.0f
            val rowHeight = sp(ctx, 58f) // title (16sp) + count (12sp) + vertical padding
            val listHeight = (rowsVisible * rowHeight).toInt() + ((rowsVisible - 1.0f) * pad8).toInt()

            val body = LinearLayout(ctx)
            body.orientation = LinearLayout.VERTICAL
            body.addView(list, LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, listHeight))
            body.addView(newCloseButton(ctx), LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT))

            val title = ctx.getString(R.string.drawer_changelog_title) + " (" + ModChangelog.allEntries().size + ")"
            val dialog = AlertDialog.Builder(ctx, R.style.AlertDialog)
                .setTitle(title)
                .setView(body)
                .setCancelable(true)
                .create()
            dialog.window?.setBackgroundDrawableResource(R.drawable.dialog_border)
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.window?.decorView?.setPadding(0, 0, 0, 0)
            dialog.setOnDismissListener { shownModAboutDialog = null }
            shownModAboutDialog = dialog
            dialog.show()
        } catch (t: Throwable) {
            t.printStackTrace()
            shownModAboutDialog = null
        }
    }

    private fun newCloseButton(ctx: Context): TextView {
        val close = TextView(ctx)
        close.setText(R.string.close)
        close.textSize = 14f
        close.typeface = Typeface.DEFAULT_BOLD
        close.setTextColor(-0x4f4f50) // 0xFFB0B0B0
        close.gravity = Gravity.CENTER_HORIZONTAL
        close.setPadding(0, sp(ctx, 12f), 0, sp(ctx, 12f))
        close.setOnClickListener { closeBothDialogs() }
        return close
    }

    /** Close button used inside the version-detail dialog: only closes the detail. */
    private fun newDetailCloseButton(ctx: Context): TextView {
        val close = TextView(ctx)
        close.setText(R.string.close)
        close.textSize = 14f
        close.typeface = Typeface.DEFAULT_BOLD
        close.setTextColor(-0x4f4f50) // 0xFFB0B0B0
        close.gravity = Gravity.CENTER_HORIZONTAL
        close.setPadding(0, sp(ctx, 12f), 0, sp(ctx, 12f))
        close.setOnClickListener {
            shownVersionDetailDialog?.dismiss()
            shownVersionDetailDialog = null
        }
        return close
    }

    private class ModAboutAdapter(
        private val ctx: Context,
        private val versions: List<ModChangelog.VersionEntry>
    ) : BaseAdapter() {
        override fun getCount(): Int = versions.size
        override fun getItem(position: Int): Any = versions[position]
        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val entry = versions[position]
            val pad12 = sp(ctx, 12f)

            val row = LinearLayout(ctx)
            row.orientation = LinearLayout.VERTICAL
            row.setPadding(pad12, pad12, pad12, pad12)
            row.setBackgroundResource(R.drawable.object_border_dim_white_square_no_border)
            row.setOnClickListener { showVersionDetail(ctx, entry) }

            val title = TextView(ctx)
            title.text = entry.title
            title.textSize = 16f
            title.typeface = Typeface.DEFAULT_BOLD
            title.setTextColor(-0x171718) // 0xFFE8E8E8
            row.addView(title, LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT))

            val subtitle = TextView(ctx)
            subtitle.text = changeCount(entry.body)
            subtitle.textSize = 12f
            subtitle.setTextColor(0xFF9E9E9E.toInt()) // muted gray
            val pad2 = sp(ctx, 2f)
            subtitle.setPadding(0, pad2, 0, 0)
            row.addView(subtitle, LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT))
            return row
        }
    }

    @JvmStatic
    fun showVersionDetail(context: Context, entry: ModChangelog.VersionEntry) {
        if (shownVersionDetailDialog != null) return
        try {
            val ctx = context
            val pad8 = sp(ctx, 8f)
            val pad12 = sp(ctx, 12f)

            val header = TextView(ctx)
            header.text = entry.title + " — " + changeCount(entry.body)
            header.textSize = 17f
            header.typeface = Typeface.DEFAULT_BOLD
            header.setTextColor(-0x171718) // 0xFFE8E8E8
            header.gravity = Gravity.CENTER_HORIZONTAL
            header.setPadding(0, pad8, 0, pad8)

            val lines = buildChangeRows(entry.body)

            // One wrapped TextView inside a ScrollView — height is measured from the REAL
            // wrapped content (so long single changes like 1.3.5.1 get a proper window),
            // capped at 78% of the screen with scrolling for anything taller.
            val textView = TextView(ctx)
            textView.text = lines.joinToString("\n\n")
            textView.textSize = 15f
            textView.setTextColor(0xFFE0E0E0.toInt())
            val padText = sp(ctx, 8f)
            textView.setPadding(pad12, padText, pad12, padText)

            val widthHint = ctx.resources.displayMetrics.widthPixels - sp(ctx, 32f)
            textView.measure(
                View.MeasureSpec.makeMeasureSpec(widthHint, View.MeasureSpec.AT_MOST),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            )
            val maxHeight = (ctx.resources.displayMetrics.heightPixels * 0.78).toInt()
            val contentHeight = textView.measuredHeight + (padText * 2)
            val listHeight = Math.min(contentHeight, maxHeight).coerceAtLeast(sp(ctx, 40f))

            val scroll = ScrollView(ctx)
            scroll.setPadding(0, 0, 0, 0)
            scroll.addView(textView, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))

            val body = LinearLayout(ctx)
            body.orientation = LinearLayout.VERTICAL
            body.addView(header, LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT))
            body.addView(scroll, LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, listHeight))
            body.addView(newDetailCloseButton(ctx), LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT))

            val detail = AlertDialog.Builder(ctx, R.style.AlertDialog)
                .setView(body)
                .setCancelable(true)
                .create()
            detail.window?.setBackgroundDrawableResource(R.drawable.dialog_border)
            detail.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            detail.window?.decorView?.setPadding(0, 0, 0, 0)
            detail.setOnDismissListener { shownVersionDetailDialog = null }
            shownVersionDetailDialog = detail
            detail.show()
        } catch (t: Throwable) {
            t.printStackTrace()
            shownVersionDetailDialog = null
        }
    }
}