package it.paranoidsquirrels.idleguildmaster.storage

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.Data
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets

class SaveImporter : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleIntent(this, intent)
        finish()
    }

    companion object {
        @JvmStatic
        fun handleIntent(context: Context?, intent: Intent?) {
            if (context == null || intent == null) return
            val action = intent.action ?: return
            if (Intent.ACTION_SEND != action && Intent.ACTION_VIEW != action) return

            try {
                var text = ""
                var stream: Uri? = intent.getParcelableExtra(Intent.EXTRA_STREAM)
                if (stream == null) {
                    stream = intent.data
                }
                if (stream != null) {
                    val isStream = context.contentResolver.openInputStream(stream)
                    if (isStream != null) {
                        text = BufferedReader(InputStreamReader(isStream, StandardCharsets.UTF_8)).use { it.readText() }
                    }
                }
                if (text.trim().isEmpty()) {
                    text = intent.getStringExtra(Intent.EXTRA_TEXT) ?: ""
                }
                if (text.contains("\"save\":")) {
                    try {
                        val wrapper = JSONObject(text)
                        if (wrapper.has("save")) {
                            text = wrapper.getString("save")
                        }
                    } catch (ignored: Throwable) {}
                }
                if (text.trim().isEmpty()) return

                context.openFileOutput("data.txt", Context.MODE_PRIVATE).use { it.write(text.toByteArray(StandardCharsets.UTF_8)) }
                context.openFileOutput("databackup.txt", Context.MODE_PRIVATE).use { it.write(text.toByteArray(StandardCharsets.UTF_8)) }

                val parsed = FileManager.getGson().fromJson(text, Data::class.java)
                if (parsed is Data) {
                    MainActivity.data = parsed
                    Utils.invalidateAreaCaches()
                }

                // If the game is already running underneath, reload its screens in
                // place so the imported save is reflected immediately (the relaunch
                // below is best-effort; without this the dungeon/raid screens keep
                // showing the previous save until a full process restart).
                (MainActivity.context as? MainActivity)?.takeIf { !it.isFinishing }?.reloadAfterSaveChange()

                Toast.makeText(context, "Save Imported Successfully!", Toast.LENGTH_SHORT).show()
                val mainIntent = Intent(context, MainActivity::class.java)
                mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(mainIntent)
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }
    }
}
