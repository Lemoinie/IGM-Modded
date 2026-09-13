package it.paranoidsquirrels.idleguildmaster.storage;

import android.content.Context;
import com.google.android.gms.games.PlayGames;
import com.google.android.gms.games.SnapshotsClient;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.storage.data.Data;
import it.paranoidsquirrels.idleguildmaster.storage.data.DataDeserializer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class FileManager {
    private static final String FILE_NAME = "data.txt";
    private static final String FILE_NAME_BACKUP = "databackup.txt";
    private static Gson gson = null;
    private static boolean saveToggle = false;
    private static boolean writeToCloud = false;

    static /* synthetic */ void lambda$writeSnapshot$0(Exception exc) {
    }

    private FileManager() {
    }

    private static void initGson() {
        if (gson == null) {
            gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(Data.class, new DataDeserializer()).create();
        }
    }

    public static void save(Context context) {
        if (gson == null) {
            initGson();
        }
        try {
            String json = gson.toJson(MainActivity.data);
            overwriteFile(context, json);
            if (writeToCloud) {
                writeToCloud = false;
                if (MainActivity.data.getAdventurers().size() > (MainActivity.data.isImperialVanguardPurchased() ? 4 : 0) + 3 + (MainActivity.data.isUnholyCrusadePurchased() ? 4 : 0)) {
                    writeSnapshot(json.getBytes(StandardCharsets.UTF_8));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void overwriteFile(Context context, String str) {
        boolean z = saveToggle;
        String str2 = z ? FILE_NAME : FILE_NAME_BACKUP;
        saveToggle = !z;
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(str2, 0);
            try {
                fileOutputStreamOpenFileOutput.write(str.getBytes());
                fileOutputStreamOpenFileOutput.flush();
                if (fileOutputStreamOpenFileOutput != null) {
                    fileOutputStreamOpenFileOutput.close();
                }
            } catch (Throwable th) {
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cleanFile(Context context) {
        context.deleteFile(FILE_NAME);
        context.deleteFile(FILE_NAME_BACKUP);
    }

    public static Data load(Context context) {
        Data data;
        Data data2;
        try {
            data = loadFile(context, FILE_NAME);
        } catch (Exception unused) {
            data = new Data();
        }
        try {
            data2 = loadFile(context, FILE_NAME_BACKUP);
        } catch (Exception unused2) {
            data2 = new Data();
        }
        return Utils.getNewestSaveFile(data, data2);
    }

    private static Data loadFile(Context context, String str) throws IOException {
        FileInputStream fileInputStreamOpenFileInput = context.openFileInput(str);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStreamOpenFileInput, StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                sb.append(line);
            }
            String string = sb.toString();
            fileInputStreamOpenFileInput.close();
            bufferedReader.close();
            if (string.isEmpty()) {
                return new Data();
            }
            if (gson == null) {
                initGson();
            }
            return (Data) gson.fromJson(string, Data.class);
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static File getSaveFile(Context context) {
        File file = new File(context.getFilesDir(), FILE_NAME);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public static void writeToCloud() {
        writeToCloud = true;
    }

    private static void writeSnapshot(final byte[] bArr) {
        try {
            final SnapshotsClient snapshotsClient = PlayGames.getSnapshotsClient(MainActivity.dungeonsFragment.getActivity());
            snapshotsClient.open(MainActivity.SAVE_FILE_NAME, true, 3).addOnFailureListener(new OnFailureListener() { // from class: it.paranoidsquirrels.idleguildmaster.storage.FileManager$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    FileManager.lambda$writeSnapshot$0(exc);
                }
            }).continueWith(new Continuation() { // from class: it.paranoidsquirrels.idleguildmaster.storage.FileManager$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) throws Exception {
                    return FileManager.lambda$writeSnapshot$1(bArr, snapshotsClient, task);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ Object lambda$writeSnapshot$1(byte[] bArr, SnapshotsClient snapshotsClient, Task task) throws Exception {
        try {
            Snapshot snapshot = (Snapshot) ((SnapshotsClient.DataOrConflict) task.getResult()).getData();
            snapshot.getSnapshotContents().writeBytes(bArr);
            snapshotsClient.commitAndClose(snapshot, new SnapshotMetadataChange.Builder().setDescription(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).build());
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Data loadFromTestFile(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open("manual_load.txt")));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String string = sb.toString();
        if (string.isEmpty()) {
            return new Data();
        }
        if (gson == null) {
            initGson();
        }
        return (Data) gson.fromJson(string, Data.class);
    }
}
