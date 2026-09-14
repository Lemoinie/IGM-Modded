package it.paranoidsquirrels.idleguildmaster.storage

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.storage.data.Data
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets

class SaveContentProvider : ContentProvider() {

    companion object {
        const val METHOD_READ = "READ_SAVE"
        const val METHOD_WRITE = "WRITE_SAVE"
        const val KEY_SAVE = "save_content"
        const val KEY_SUCCESS = "success"
    }

    override fun onCreate(): Boolean = true

    override fun query(uri: Uri, projection: Array<out String>?, selection: String?, selectionArgs: Array<out String>?, sortOrder: String?): Cursor? = null
    override fun getType(uri: Uri): String? = null
    override fun insert(uri: Uri, values: ContentValues?): Uri? = null
    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int = 0
    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int = 0

    override fun call(method: String, arg: String?, extras: Bundle?): Bundle {
        val result = Bundle()
        when (method) {
            METHOD_READ -> readSave(result)
            METHOD_WRITE -> {
                val content = extras?.getString(KEY_SAVE)
                if (content != null) {
                    writeSave(content, result)
                }
            }
        }
        return result
    }

    private fun readSave(result: Bundle) {
        try {
            val ctx = context ?: return
            val fis = ctx.openFileInput("data.txt")
            val reader = BufferedReader(InputStreamReader(fis, StandardCharsets.UTF_8))
            val content = reader.use { it.readText() }
            result.putString(KEY_SAVE, content)
            result.putBoolean(KEY_SUCCESS, true)
        } catch (t: Throwable) {
            t.printStackTrace()
        }
    }

    private fun writeSave(content: String, result: Bundle) {
        try {
            val ctx = context ?: return
            ctx.openFileOutput("data.txt", 0).use { it.write(content.toByteArray(StandardCharsets.UTF_8)) }
            ctx.openFileOutput("databackup.txt", 0).use { it.write(content.toByteArray(StandardCharsets.UTF_8)) }

            val parsed = FileManager.getGson().fromJson(content, Data::class.java)
            if (parsed is Data) {
                MainActivity.data = parsed
            }
            result.putBoolean(KEY_SUCCESS, true)
        } catch (t: Throwable) {
            t.printStackTrace()
        }
    }
}
