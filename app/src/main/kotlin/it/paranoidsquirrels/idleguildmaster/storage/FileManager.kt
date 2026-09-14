package it.paranoidsquirrels.idleguildmaster.storage

import android.content.Context
import com.google.android.gms.games.PlayGames
import com.google.android.gms.games.SnapshotsClient
import com.google.android.gms.games.snapshot.Snapshot
import com.google.android.gms.games.snapshot.SnapshotMetadataChange
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import it.paranoidsquirrels.idleguildmaster.MainActivity
import it.paranoidsquirrels.idleguildmaster.Utils
import it.paranoidsquirrels.idleguildmaster.storage.data.Data
import it.paranoidsquirrels.idleguildmaster.storage.data.DataDeserializer
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.text.SimpleDateFormat
import java.util.Date

object FileManager {
    private const val FILE_NAME = "data.txt"
    private const val FILE_NAME_BACKUP = "databackup.txt"
    private var gson: Gson? = null
    private var saveToggle = false
    private var writeToCloud = false

    @JvmStatic
    fun getGson(): Gson {
        if (gson == null) {
            initGson()
        }
        return gson!!
    }

    @JvmStatic
    fun initGson() {
        if (gson == null) {
            gson = GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Data::class.java, DataDeserializer())
                .create()
        }
    }

    @JvmStatic
    fun save(context: Context) {
        if (gson == null) {
            initGson()
        }
        try {
            val json = gson!!.toJson(MainActivity.data)
            overwriteFile(context, json)
            if (writeToCloud) {
                writeToCloud = false
                val threshold = (if (MainActivity.data.isImperialVanguardPurchased) 4 else 0) + 3 + (if (MainActivity.data.isUnholyCrusadePurchased) 4 else 0)
                if (MainActivity.data.adventurers.size > threshold) {
                    writeSnapshot(json.toByteArray(StandardCharsets.UTF_8))
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @JvmStatic
    fun overwriteFile(context: Context, str: String) {
        val z = saveToggle
        val filename = if (z) FILE_NAME else FILE_NAME_BACKUP
        saveToggle = !z
        try {
            context.openFileOutput(filename, 0).use { fos ->
                fos.write(str.toByteArray())
                fos.flush()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @JvmStatic
    fun cleanFile(context: Context) {
        context.deleteFile(FILE_NAME)
        context.deleteFile(FILE_NAME_BACKUP)
    }

    @JvmStatic
    fun load(context: Context): Data {
        val data = try {
            loadFile(context, FILE_NAME)
        } catch (unused: Exception) {
            Data()
        }
        val data2 = try {
            loadFile(context, FILE_NAME_BACKUP)
        } catch (unused2: Exception) {
            Data()
        }
        return Utils.getNewestSaveFile(data, data2)
    }

    @JvmStatic
    @Throws(IOException::class)
    fun loadFile(context: Context, str: String): Data {
        val fis = context.openFileInput(str)
        val isr = InputStreamReader(fis, StandardCharsets.UTF_8)
        val sb = StringBuilder()
        BufferedReader(isr).use { reader ->
            var line: String? = reader.readLine()
            while (line != null) {
                sb.append(line)
                line = reader.readLine()
            }
        }
        val strContent = sb.toString()
        if (strContent.isEmpty()) {
            return Data()
        }
        if (gson == null) {
            initGson()
        }
        return gson!!.fromJson(strContent, Data::class.java)
    }

    @JvmStatic
    fun getSaveFile(context: Context): File? {
        val file = File(context.filesDir, FILE_NAME)
        return if (file.exists()) file else null
    }

    @JvmStatic
    fun writeToCloud() {
        writeToCloud = true
    }

    private fun writeSnapshot(bArr: ByteArray) {
        try {
            val act = MainActivity.dungeonsFragment?.activity ?: return
            val snapshotsClient = PlayGames.getSnapshotsClient(act)
            snapshotsClient.open(MainActivity.SAVE_FILE_NAME, true, 3)
                .addOnFailureListener { /* ignore */ }
                .continueWith { task ->
                    try {
                        val snapshot = (task.result as SnapshotsClient.DataOrConflict).data ?: return@continueWith null
                        snapshot.snapshotContents?.writeBytes(bArr)
                        snapshotsClient.commitAndClose(
                            snapshot,
                            SnapshotMetadataChange.Builder()
                                .setDescription(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date()))
                                .build()
                        )
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                    null
                }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @JvmStatic
    fun loadFromTestFile(context: Context): Data {
        val sb = StringBuilder()
        try {
            BufferedReader(InputStreamReader(context.assets.open("manual_load.txt"))).use { reader ->
                var line: String? = reader.readLine()
                while (line != null) {
                    sb.append(line)
                    line = reader.readLine()
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        val strContent = sb.toString()
        if (strContent.isEmpty()) {
            return Data()
        }
        if (gson == null) {
            initGson()
        }
        return gson!!.fromJson(strContent, Data::class.java)
    }
}
