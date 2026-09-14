package it.paranoidsquirrels.idleguildmaster.storage

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.storage.data.Data

object SaveResetter {

    @JvmStatic
    fun showResetConfirmation(context: Context?, activity: Activity?) {
        if (context == null) return
        try {
            AlertDialog.Builder(context)
                .setTitle("Start New Game?")
                .setMessage(
                    "Are you sure you want to wipe all progress and start completely fresh? " +
                    "All heroes, items, gold, and progress will be reset like a new device.\n\n" +
                    "This action cannot be undone."
                )
                .setPositiveButton("Wipe and Start Fresh") { dialog, _ ->
                    dialog?.dismiss()
                    doReset(activity)
                }
                .setNegativeButton("Cancel", null)
                .show()
        } catch (t: Throwable) {
            t.printStackTrace()
        }
    }

    @JvmStatic
    fun doReset(activity: Activity?) {
        if (activity == null) return
        try {
            activity.deleteFile("data.txt")
            activity.deleteFile("databackup.txt")

            MainActivity.data = Data()

            FileManager.save(activity)
            FileManager.save(activity)

            val intent = Intent(activity, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            activity.startActivity(intent)
            activity.finish()
        } catch (t: Throwable) {
            t.printStackTrace()
        }
    }
}
